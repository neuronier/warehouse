package hu.neuron.java.warehouse.whWeb.controller;

import hu.neuron.java.warehouse.whBusiness.service.StockReportServiceRemote;
import hu.neuron.java.warehouse.whBusiness.vo.WarehouseVO;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean(name = "stockReportController")
public class StockReportController implements Serializable {
	private static final long serialVersionUID = 1L;

	private LazyStockReportActualModel lazyStockReportActualModel;

	private LazyStockReportHistoryModel lazyStockReportHistoryModel;

	private LazyStockReportTransferModel lazyStockReportTransferModel;

	@EJB(beanName = "StockReportService")
	private StockReportServiceRemote stockReportService;

	private WarehouseVO selectedWarehouse;

	private List<WarehouseVO> warehouses;

	@PostConstruct
	public void init() {
		warehouses = stockReportService.getWarehouses();
		setLazyStockReportActualModel(new LazyStockReportActualModel(stockReportService));
		setLazyStockReportHistoryModel(new LazyStockReportHistoryModel(stockReportService));
		// setLazyStockReportTransferModel(new
		// LazyStockReportTransferModel(stockReportService));
	}

	public void onWarehouseChange() {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Selection info", selectedWarehouse
						.getName() + " selected"));
	}

	public LazyStockReportActualModel getLazyStockReportActualModel() {
		return lazyStockReportActualModel;
	}

	public void setLazyStockReportActualModel(LazyStockReportActualModel lazyStockReportActualModel) {
		this.lazyStockReportActualModel = lazyStockReportActualModel;
	}

	public LazyStockReportHistoryModel getLazyStockReportHistoryModel() {
		return lazyStockReportHistoryModel;
	}

	public void setLazyStockReportHistoryModel(
			LazyStockReportHistoryModel lazyStockReportHistoryModel) {
		this.lazyStockReportHistoryModel = lazyStockReportHistoryModel;
	}

	public LazyStockReportTransferModel getLazyStockReportTransferModel() {
		return lazyStockReportTransferModel;
	}

	public void setLazyStockReportTransferModel(
			LazyStockReportTransferModel lazyStockReportTransferModel) {
		this.lazyStockReportTransferModel = lazyStockReportTransferModel;
	}

	public StockReportServiceRemote getStockReportService() {
		return stockReportService;
	}

	public void setStockReportService(StockReportServiceRemote stockReportService) {
		this.stockReportService = stockReportService;
	}

	public List<WarehouseVO> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(List<WarehouseVO> warehouses) {
		this.warehouses = warehouses;
	}

	public WarehouseVO getSelectedWarehouse() {
		return selectedWarehouse;
	}

	public void setSelectedWarehouse(WarehouseVO selectedWarehouse) {
		this.selectedWarehouse = selectedWarehouse;
	}

}
