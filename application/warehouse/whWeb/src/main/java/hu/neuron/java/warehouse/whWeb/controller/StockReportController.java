package hu.neuron.java.warehouse.whWeb.controller;

import hu.neuron.java.warehouse.whBusiness.service.StockReportServiceRemote;
import hu.neuron.java.warehouse.whBusiness.vo.TransportVO;
import hu.neuron.java.warehouse.whBusiness.vo.WarehouseVO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "stockReportController")
public class StockReportController implements Serializable {
	private static final long serialVersionUID = 1L;

	private LazyStockReportActualModel lazyStockReportActualModel;

	private LazyStockReportHistoryModel lazyStockReportHistoryModel;

	private LazyStockReportTransferModel lazyStockReportTransferModel;

	private LazyStockReportTransferDetailsModel lazyStockReportTransferDetailsModel;

	@EJB(beanName = "StockReportService")
	private StockReportServiceRemote stockReportService;

	private List<WarehouseVO> warehouses;
	private List<String> warehouseNames;
	private String selectedWarehouseName = " ";

	private Date startDate;
	private Date endDate;

	private TransportVO selectedTransport;

	@PostConstruct
	public void init() {
		warehouses = stockReportService.getWarehouses();
		warehouseNames = new ArrayList<String>();
		for (WarehouseVO warehouseVO : warehouses) {
			warehouseNames.add(warehouseVO.getName());
		}

		setLazyStockReportActualModel(new LazyStockReportActualModel(stockReportService));
		setLazyStockReportHistoryModel(new LazyStockReportHistoryModel(stockReportService));
		setLazyStockReportTransferModel(new LazyStockReportTransferModel(stockReportService));
		setLazyStockReportTransferDetailsModel(new LazyStockReportTransferDetailsModel(
				stockReportService));

		Calendar cal = Calendar.getInstance();

		cal.set(2015, 1, 1);
		startDate = cal.getTime();
		lazyStockReportHistoryModel.setStartDate(startDate);
		cal.set(2016, 1, 1);
		endDate = cal.getTime();
		lazyStockReportHistoryModel.setEndDate(endDate);

	}

	public void onWarehouseChange() {
		lazyStockReportActualModel.setSelectedWarehouseName(selectedWarehouseName);
		lazyStockReportHistoryModel.setSelectedWarehouseName(selectedWarehouseName);
	}

	public void onTransportRowSelect() {
		lazyStockReportTransferDetailsModel.setSelectedTransport(selectedTransport);
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

	public List<String> getWarehouseNames() {
		return warehouseNames;
	}

	public void setWarehouseNames(List<String> warehouseNames) {
		this.warehouseNames = warehouseNames;
	}

	public String getSelectedWarehouseName() {
		return selectedWarehouseName;
	}

	public void setSelectedWarehouseName(String selectedWarehouseName) {
		this.selectedWarehouseName = selectedWarehouseName;
	}

	public TransportVO getSelectedTransport() {
		return selectedTransport;
	}

	public void setSelectedTransport(TransportVO selectedTransport) {
		this.selectedTransport = selectedTransport;
	}

	public LazyStockReportTransferDetailsModel getLazyStockReportTransferDetailsModel() {
		return lazyStockReportTransferDetailsModel;
	}

	public void setLazyStockReportTransferDetailsModel(
			LazyStockReportTransferDetailsModel lazyStockReportTransferDetailsModel) {
		this.lazyStockReportTransferDetailsModel = lazyStockReportTransferDetailsModel;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
