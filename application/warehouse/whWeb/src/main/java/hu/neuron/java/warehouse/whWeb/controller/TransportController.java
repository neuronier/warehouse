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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean(name = "transportController")
public class TransportController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int db;

	private int max;

	private LinkedList<Integer> pieces;

	private String transportStatus;

	@EJB(name = "TransportService")
	TransportServiceLocal transportOrder;

	// warehouseok
	private Collection<WarehouseVO> warehouses;

	private Collection<String> whNames;

	private String selectedFromWarehouseName;

	private String selectedToWarehouseName;

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
		pieces = new LinkedList<Integer>();
		whNames = new ArrayList<String>();
		warehouses = new ArrayList<WarehouseVO>();
		warehouses = warehouseService.findAll();
		for (WarehouseVO warehouseVO : warehouses) {
			whNames.add(warehouseVO.getName());
		}
	}

	public void transport() {
		WarehouseVO fromWarehouse;
		WarehouseVO toWarehouse;
		WareVo ware;
		TransportVO transportVO = new TransportVO();
		TransportDetailsVO detailsVO = new TransportDetailsVO();
		try {
			fromWarehouse = warehouseService
					.findWarehouseByName(selectedFromWarehouseName);
			if (fromWarehouse == null) {
				fromWarehouse = warehouseService
						.findWarehouseByName("Default Warehouse");
			}
			transportVO.setFromWarehouse(fromWarehouse);

			toWarehouse = warehouseService
					.findWarehouseByName(selectedToWarehouseName);
			if (toWarehouse == null) {
				toWarehouse = warehouseService
						.findWarehouseByName("Default Warehouse");
			}
			transportVO.setToWarehouse(toWarehouse);

			transportVO.setTransportStatus("Szállítás alatt");
			setTransportStatus(transportVO.getTransportStatus());

			transportOrder.fillTables(transportVO, detailsVO);

			for (String wareName : selectedwareNames) {
				ware = wareService.findWareByName(wareName);
				detailsVO.setWare(ware);
				detailsVO.setPiece(pieces.getLast());
				detailsVO.setTransport(transportVO);
				pieces.removeLast();
				transportOrder.transportItemToWarehouse(transportVO, detailsVO);
			}
			FacesContext.getCurrentInstance().addMessage(
					"A szállítás megkezdődött", null);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pieces.clear();
		}

	}

	public void getWaresNames() {

		Map<String, Integer> tmp = new HashMap<String, Integer>();
		try {
			tmp = wareService.findwareAndPiecesByWarehouseId(warehouseService
					.findWarehouseByName(selectedFromWarehouseName)
					.getWarehouseId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Set<String> kesy = tmp.keySet();
		wareNames = new ArrayList<String>();
		for (String string : kesy) {
			wareNames.add(string);
			setMax(tmp.get(string));
		}
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
		pieces.addFirst(db);
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

	public String getSelectedToWarehouseName() {
		return selectedToWarehouseName;
	}

	public void setSelectedToWarehouseName(String selectedToWarehouseName) {
		this.selectedToWarehouseName = selectedToWarehouseName;
	}

	public String getSelectedFromWarehouseName() {
		return selectedFromWarehouseName;
	}

	public void setSelectedFromWarehouseName(String selectedFromWarehouseName) {
		this.selectedFromWarehouseName = selectedFromWarehouseName;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

}
