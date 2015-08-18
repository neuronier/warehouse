package hu.neuron.java.warehouse.whWeb.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hu.neuron.java.warehouse.whBusiness.service.WareOrderLOcal;
import hu.neuron.java.warehouse.whBusiness.service.WareServiceLocal;
import hu.neuron.java.warehouse.whBusiness.service.WarehouseServiceLocal;
import hu.neuron.java.warehouse.whBusiness.vo.StockVO;
import hu.neuron.java.warehouse.whBusiness.vo.WareVo;
import hu.neuron.java.warehouse.whBusiness.vo.WarehouseVO;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ViewScoped
@ManagedBean(name = "wareOrderConttroller")
public class WareOrderConttroller implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB(name = "WareOrderService")
	WareOrderLOcal wareOrder;
	
	@EJB(name = "WarehouseService")
	WarehouseServiceLocal warehouseService;
	
	@EJB(name = "WareService")
	WareServiceLocal wareService;
	
	private int db;

	
	private Collection<WarehouseVO> warehouses;
	
	private Collection<String> whNames;
	
	private String selectedWhNames;

	
	
	private List<WareVo> wares;
	
	private Collection<String> wareNames;
	
	private Collection<String> selectedwareNames;
	

	@PostConstruct
	void init() {
		whNames = new ArrayList<String>();
		warehouses = new ArrayList<WarehouseVO>();
		warehouses = warehouseService.findAll();
		for (WarehouseVO warehouseVO : warehouses) {
			whNames.add(warehouseVO.getName());
		}
		
		wareNames = new ArrayList<String>();
		wares = new ArrayList<WareVo>();
		wares = wareService.getWares();
		for (WareVo wareVo : wares) {
			wareNames.add(wareVo.getWareName());
		}
	}
	
	public void order() {
		WarehouseVO wh;
		WareVo ware;
		StockVO order = new StockVO();
		try {
			wh = warehouseService.findWarehouseByName(selectedWhNames);
			
			order.setWarehouse(wh);
			for (String wareName : selectedwareNames) {
				ware = wareService.findWareByName(wareName);
				order.setWare(ware);
				order.setPiece(db);
				wareOrder.order(order);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	public void addMessage(String summary) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Siker", summary));
	}

	public Collection<WarehouseVO> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(Collection<WarehouseVO> warehouses) {
		this.warehouses = warehouses;
	}

	public int getDb() {
		return db;
	}

	public void setDb(int db) {
		this.db = db;
	}

	public Collection<String> getWhNames() {
		return whNames;
	}

	public void setWhNames(Collection<String> whNames) {
		this.whNames = whNames;
	}

	public List<WareVo> getWares() {
		return wares;
	}

	public void setWares(List<WareVo> wares) {
		this.wares = wares;
	}

	public Collection<String> getWareNames() {
		return wareNames;
	}

	public void setWareNames(Collection<String> wareNames) {
		this.wareNames = wareNames;
	}

	public WareOrderLOcal getWareOrder() {
		return wareOrder;
	}

	public void setWareOrder(WareOrderLOcal wareOrder) {
		this.wareOrder = wareOrder;
	}


	public String getSelectedWhNames() {
		return selectedWhNames;
	}

	public void setSelectedWhNames(String selectedWhNames) {
		this.selectedWhNames = selectedWhNames;
	}

	public WarehouseServiceLocal getWarehouseService() {
		return warehouseService;
	}

	public void setWarehouseService(WarehouseServiceLocal warehouseService) {
		this.warehouseService = warehouseService;
	}

	public WareServiceLocal getWareService() {
		return wareService;
	}

	public void setWareService(WareServiceLocal wareService) {
		this.wareService = wareService;
	}

	public Collection<String> getSelectedwareNames() {
		return selectedwareNames;
	}

	public void setSelectedwareNames(Collection<String> selectedwareNames) {
		this.selectedwareNames = selectedwareNames;
	}

	
}
