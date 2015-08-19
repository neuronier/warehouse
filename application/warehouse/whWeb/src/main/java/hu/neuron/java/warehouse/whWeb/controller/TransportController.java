package hu.neuron.java.warehouse.whWeb.controller;

import hu.neuron.java.warehouse.whBusiness.service.TransportServiceLocal;
import hu.neuron.java.warehouse.whBusiness.service.WareServiceLocal;
import hu.neuron.java.warehouse.whBusiness.service.WarehouseServiceLocal;
import hu.neuron.java.warehouse.whBusiness.vo.TransportDetailsVO;
import hu.neuron.java.warehouse.whBusiness.vo.TransportVO;
import hu.neuron.java.warehouse.whBusiness.vo.WareVo;
import hu.neuron.java.warehouse.whBusiness.vo.WarehouseVO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ViewScoped
@ManagedBean(name = "transportController")
public class TransportController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int db;
	
	private LinkedList<Integer> pieces;
	
	private String transportStatus;
	
	@EJB(name = "TransportService")
	TransportServiceLocal transportOrder;

	// warehouseok
	private Collection<WarehouseVO> warehouses;

	private Collection<String> whNames;
	
	private String selectedWarehouseNames;

	@EJB(name = "WarehouseService")
	WarehouseServiceLocal warehouseService;

	// itemek
	private List<WareVo> wares;

	private Collection<String> wareNames;
	
	private Collection<String> selectedwareNames;

	@EJB(name = "WareService")
	WareServiceLocal wareService;

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
		
		setPieces(new LinkedList<Integer>());
	}

	public void transport() {
		WarehouseVO fromWarehouse;
		WarehouseVO toWarehouse;
		WareVo ware;
		TransportVO transportVO = new TransportVO();
		TransportDetailsVO detailsVO = new TransportDetailsVO();
		try {
			fromWarehouse = warehouseService.findWarehouseByName(selectedWarehouseNames);
			if (fromWarehouse == null) {
				fromWarehouse = warehouseService.findWarehouseByName("Default Warehouse");
			}
			transportVO.setFromWarehouseId(fromWarehouse.getWarehouseId());
			
			toWarehouse = warehouseService.findWarehouseByName(selectedWarehouseNames);
			if (toWarehouse == null) {
				toWarehouse = warehouseService.findWarehouseByName("Default Warehouse");
			}
			transportVO.setToWarehouseId(toWarehouse.getWarehouseId());
			
			transportVO.setTransportStatus("Szállítás alatt");
			setTransportStatus(transportVO.getTransportStatus());
			
			
			for (String wareName : selectedwareNames) {
				ware = wareService.findWareByName(wareName);
				detailsVO.setWare(ware);
				detailsVO.setPiece(pieces.getLast());
				pieces.removeLast();
				transportOrder.transportItemToWarehouse(transportVO, detailsVO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	public void buttonAction(ActionEvent actionEvent) {
		addMessage("A szállítás hamarosan megkezdődik");
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

	public LinkedList<Integer> getPieces() {
		return pieces;
	}

	public void setPieces(LinkedList<Integer> pieces) {
		this.pieces = pieces;
	}

	public String getSelectedWarehouseNames() {
		return selectedWarehouseNames;
	}

	public void setSelectedWarehouseNames(String selectedWarehouseNames) {
		this.selectedWarehouseNames = selectedWarehouseNames;
	}

	public Collection<String> getSelectedwareNames() {
		return selectedwareNames;
	}

	public void setSelectedwareNames(Collection<String> selectedwareNames) {
		this.selectedwareNames = selectedwareNames;
	}

	public String getTransportStatus() {
		return transportStatus;
	}

	public void setTransportStatus(String transportStatus) {
		this.transportStatus = transportStatus;
	}

}
