package hu.neuron.java.warehouse.whWeb.controller;

import hu.neuron.java.warehouse.whBusiness.service.StockReportServiceRemote;
import hu.neuron.java.warehouse.whBusiness.service.TransportDetailsServiceRemote;
import hu.neuron.java.warehouse.whBusiness.vo.TransportVO;
import hu.neuron.java.warehouse.whBusiness.vo.UserVO;
import hu.neuron.java.warehouse.whBusiness.vo.WarehouseVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.security.core.context.SecurityContextHolder;

@ViewScoped
@ManagedBean(name = "acceptController")
public class AcceptController {

	@EJB(beanName = "TransportDetailsService")
	private TransportDetailsServiceRemote serviceRemote;

	private TransportVO selectedTransport;

	private LazyStockReportActualModel lazyStockReportActualModel;

	private LazyStockReportHistoryModel lazyStockReportHistoryModel;

	private LazyStockReportTransferModel lazyStockReportTransferModel;

	private LazyStockReportTransferDetailsModel lazyStockReportTransferDetailsModel;

	private LazyTransferDetailsModel lazyTransferDetailsModel;
	
	private LazyTransferModel lazyTransferModel;

	@EJB(beanName = "StockReportService")
	private StockReportServiceRemote stockReportService;

	private List<WarehouseVO> warehouses;
	private List<String> warehouseNames;
	private String selectedWarehouseName = " ";

	private String status;

	private List<UserVO> users;

	private UserVO selectedUser;

	private boolean enabled;

	@PostConstruct
	public void init() {
		warehouses = stockReportService.getWarehouses();
		warehouseNames = new ArrayList<String>();
		for (WarehouseVO warehouseVO : warehouses) {
			warehouseNames.add(warehouseVO.getName());
		}

		setLazyStockReportActualModel(new LazyStockReportActualModel(
				stockReportService));
		setLazyStockReportHistoryModel(new LazyStockReportHistoryModel(
				stockReportService));
		setLazyStockReportTransferModel(new LazyStockReportTransferModel(
				stockReportService));
		setLazyStockReportTransferDetailsModel(new LazyStockReportTransferDetailsModel(
				stockReportService));
		setLazyTransferDetailsModel(new LazyTransferDetailsModel(
				stockReportService));
		setLazyTransferModel(new LazyTransferModel(
				stockReportService));

	}

	public void onTransportRowSelect() {
		lazyTransferDetailsModel.setSelectedTransport(selectedTransport);
		setStatus(selectedTransport.getTransportStatus());

		setSelectedUser(serviceRemote.getUserByName(SecurityContextHolder
				.getContext().getAuthentication().getName()));
		setUsers(selectedTransport.getToWarehouse().getUsers());
		for (UserVO userVO : users) {
			if (selectedUser.getId() == userVO.getId()) {
				setEnabled(true);
			}
		}
	}

	public void updateTransport() {
		try {
			serviceRemote.updateTransportDetails(selectedTransport);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Update Success"));
			e.printStackTrace();
		}

	}

	public TransportDetailsServiceRemote getServiceRemote() {
		return serviceRemote;
	}

	public void setServiceRemote(TransportDetailsServiceRemote serviceRemote) {
		this.serviceRemote = serviceRemote;
	}

	public TransportVO getSelectedTransport() {
		return selectedTransport;
	}

	public void setSelectedTransport(TransportVO selectedTransport) {
		this.selectedTransport = selectedTransport;
	}

	public LazyStockReportActualModel getLazyStockReportActualModel() {
		return lazyStockReportActualModel;
	}

	public void setLazyStockReportActualModel(
			LazyStockReportActualModel lazyStockReportActualModel) {
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

	public LazyStockReportTransferDetailsModel getLazyStockReportTransferDetailsModel() {
		return lazyStockReportTransferDetailsModel;
	}

	public void setLazyStockReportTransferDetailsModel(
			LazyStockReportTransferDetailsModel lazyStockReportTransferDetailsModel) {
		this.lazyStockReportTransferDetailsModel = lazyStockReportTransferDetailsModel;
	}

	public StockReportServiceRemote getStockReportService() {
		return stockReportService;
	}

	public void setStockReportService(
			StockReportServiceRemote stockReportService) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<UserVO> getUsers() {
		return users;
	}

	public void setUsers(List<UserVO> users) {
		this.users = users;
	}

	public UserVO getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UserVO selectedUser) {
		this.selectedUser = selectedUser;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public LazyTransferDetailsModel getLazyTransferDetailsModel() {
		return lazyTransferDetailsModel;
	}

	public void setLazyTransferDetailsModel(
			LazyTransferDetailsModel lazyAcceptTransferModel) {
		this.lazyTransferDetailsModel = lazyAcceptTransferModel;
	}

	public LazyTransferModel getLazyTransferModel() {
		return lazyTransferModel;
	}

	public void setLazyTransferModel(LazyTransferModel lazyTransferModel) {
		this.lazyTransferModel = lazyTransferModel;
	}

}
