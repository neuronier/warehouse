package hu.neuron.java.warehouse.whWeb.controller;

import hu.neuron.java.warehouse.whBusiness.service.WarehouseServiceLocal;
import hu.neuron.java.warehouse.whBusiness.vo.RoleVO;
import hu.neuron.java.warehouse.whBusiness.vo.UserVO;
import hu.neuron.java.warehouse.whBusiness.vo.WarehouseVO;
import hu.neuron.java.warehouse.whWeb.model.LazyWarehouseModel;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@ViewScoped
@ManagedBean(name = "warehouseController")
public class WarehouseController implements Serializable {

	private static final long serialVersionUID = -5827519834457627715L;

	private WarehouseVO selectedWarehouse;
	private UserVO selectedUser;

	private String newWarehouseName;
	private String updateWarehouseName;

	private String newWarehouseId;
	private String updateWarehouseId;

	private String newWarehouseAddress;
	private String updateWarehouseAddress;

	private int newWarehouseAddressNumber;
	private int updateWarehouseAddressNumber;

	private String newWarehouseCity;
	private String updateWarehouseCity;

	private int newWarehouseAddressZipCode;
	private int updateWarehouseAddressZipCode;

	private Collection<UserVO> newWarehouseAddressZipUsers;
	private Collection<UserVO> updateWarehouseAddressZipusres;

	LazyWarehouseModel lazyWarehouseModel;

	@EJB(name = "WarehouseService")
	WarehouseServiceLocal warehouseService;

	@PostConstruct
	public void init() {

		setLazyWarehouseModel(new LazyWarehouseModel(warehouseService));
	}

	public void addUserToWarehouse(WarehouseVO warehouse, UserVO user) {
		try {
			warehouseService
					.addUserToWarehouse(user.getId(), warehouse.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveNewWarehouse() {

		try {
			WarehouseVO warehouseVO = new WarehouseVO();
			warehouseVO.setName(newWarehouseName);
			warehouseVO.setAddress(newWarehouseAddress);
			warehouseVO.setAddressNumber(newWarehouseAddressNumber);
			warehouseVO.setCity(newWarehouseCity);
			warehouseVO.setZipCode(newWarehouseAddressZipCode);
			warehouseVO.setWarehouseId(newWarehouseId);
			warehouseService.save(warehouseVO);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Succes",
							"Save: " + selectedWarehouse.getName()));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
							"Save"));
		}

	}

	public void onRowSelect(SelectEvent event) {
		selectedWarehouse = (WarehouseVO) event.getObject();
		updateWarehouseName = selectedWarehouse.getName();
		updateWarehouseAddress = selectedWarehouse.getAddress();
		updateWarehouseAddressNumber = selectedWarehouse.getAddressNumber();
		updateWarehouseAddressZipCode = selectedWarehouse.getZipCode();
		updateWarehouseAddressZipusres = selectedWarehouse.getUsers();
		updateWarehouseCity = selectedWarehouse.getCity();

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
						selectedWarehouse.getName()));
	}

	public void removeWarehouse() {
		try {
			warehouseService.dalete(selectedWarehouse);

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Deleted: " + selectedWarehouse.getName()));
			selectedWarehouse = null;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
							"Deleted: "));
		}
	}

	public void updateWarehouse() {
		try {
			selectedWarehouse.setName(updateWarehouseName);
			selectedWarehouse.setAddress(updateWarehouseAddress);
			selectedWarehouse.setAddressNumber(updateWarehouseAddressNumber);
			selectedWarehouse.setCity(updateWarehouseCity);
			selectedWarehouse.setZipCode(updateWarehouseAddressZipCode);
			warehouseService.update(selectedWarehouse);

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Succes",
							"Update: " + selectedWarehouse.getName()));
			selectedWarehouse = null;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
							"Update: "));
		}
	}

	public WarehouseVO getSelectedWarehouse() {
		return selectedWarehouse;
	}

	public void setSelectedWarehouse(WarehouseVO selectedWarehouse) {
		this.selectedWarehouse = selectedWarehouse;
	}

	public String getNewWarehouseName() {
		return newWarehouseName;
	}

	public void setNewWarehouseName(String newWarehouseName) {
		this.newWarehouseName = newWarehouseName;
	}

	public String getUpdateWarehouseName() {
		return updateWarehouseName;
	}

	public void setUpdateWarehouseName(String updateWarehouseName) {
		this.updateWarehouseName = updateWarehouseName;
	}

	public LazyWarehouseModel getLazyWarehouseModel() {
		return lazyWarehouseModel;
	}

	public void setLazyWarehouseModel(LazyWarehouseModel lazyWarehouseModel) {
		this.lazyWarehouseModel = lazyWarehouseModel;
	}

	public WarehouseServiceLocal getWarehouseService() {
		return warehouseService;
	}

	public void setWarehouseService(WarehouseServiceLocal warehouseService) {
		this.warehouseService = warehouseService;
	}

	public String getNewWarehouseAddress() {
		return newWarehouseAddress;
	}

	public void setNewWarehouseAddress(String newWarehouseAddress) {
		this.newWarehouseAddress = newWarehouseAddress;
	}

	public String getUpdateWarehouseAddress() {
		return updateWarehouseAddress;
	}

	public void setUpdateWarehouseAddress(String updateWarehouseAddress) {
		this.updateWarehouseAddress = updateWarehouseAddress;
	}

	public int getNewWarehouseAddressNumber() {
		return newWarehouseAddressNumber;
	}

	public void setNewWarehouseAddressNumber(int newWarehouseAddressNumber) {
		this.newWarehouseAddressNumber = newWarehouseAddressNumber;
	}

	public int getUpdateWarehouseAddressNumber() {
		return updateWarehouseAddressNumber;
	}

	public void setUpdateWarehouseAddressNumber(int updateWarehouseAddressNumber) {
		this.updateWarehouseAddressNumber = updateWarehouseAddressNumber;
	}

	public String getNewWarehouseCity() {
		return newWarehouseCity;
	}

	public void setNewWarehouseCity(String newWarehouseCity) {
		this.newWarehouseCity = newWarehouseCity;
	}

	public String getUpdateWarehouseCity() {
		return updateWarehouseCity;
	}

	public void setUpdateWarehouseCity(String updateWarehouseCity) {
		this.updateWarehouseCity = updateWarehouseCity;
	}

	public int getNewWarehouseAddressZipCode() {
		return newWarehouseAddressZipCode;
	}

	public void setNewWarehouseAddressZipCode(int newWarehouseAddressZipCode) {
		this.newWarehouseAddressZipCode = newWarehouseAddressZipCode;
	}

	public int getUpdateWarehouseAddressZipCode() {
		return updateWarehouseAddressZipCode;
	}

	public void setUpdateWarehouseAddressZipCode(
			int updateWarehouseAddressZipCode) {
		this.updateWarehouseAddressZipCode = updateWarehouseAddressZipCode;
	}

	public Collection<UserVO> getNewWarehouseAddressZipUsers() {
		return newWarehouseAddressZipUsers;
	}

	public void setNewWarehouseAddressZipUsers(
			Collection<UserVO> newWarehouseAddressZipUsers) {
		this.newWarehouseAddressZipUsers = newWarehouseAddressZipUsers;
	}

	public Collection<UserVO> getUpdateWarehouseAddressZipusres() {
		return updateWarehouseAddressZipusres;
	}

	public void setUpdateWarehouseAddressZipusres(
			Collection<UserVO> updateWarehouseAddressZipusres) {
		this.updateWarehouseAddressZipusres = updateWarehouseAddressZipusres;
	}

	public String getNewWarehouseId() {
		return newWarehouseId;
	}

	public void setNewWarehouseId(String newWarehouseId) {
		this.newWarehouseId = newWarehouseId;
	}

	public String getUpdateWarehouseId() {
		return updateWarehouseId;
	}

	public void setUpdateWarehouseId(String updateWarehouseId) {
		this.updateWarehouseId = updateWarehouseId;
	}

	public UserVO getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UserVO selectedUser) {
		this.selectedUser = selectedUser;
	}

}
