package hu.neuron.java.warehouse.whWeb.controller;

import hu.neuron.java.warehouse.whBusiness.service.AdminServiceRemote;
import hu.neuron.java.warehouse.whBusiness.service.WarehouseServiceRemote;
import hu.neuron.java.warehouse.whBusiness.vo.UserVO;
import hu.neuron.java.warehouse.whBusiness.vo.WarehouseVO;
import hu.neuron.java.warehouse.whWeb.model.LazyWarehouseModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DualListModel;

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

	private String newWarehouseAddressNumber;
	private String updateWarehouseAddressNumber;

	private String newWarehouseCity;
	private String updateWarehouseCity;

	private String newWarehouseAddressZipCode;
	private String updateWarehouseAddressZipCode;

	private LazyWarehouseModel lazyWarehouseModel;

	@EJB(name = "WarehouseService")
	private WarehouseServiceRemote warehouseService;

	@EJB(name = "AdminService")
	private AdminServiceRemote adminService;

	private DualListModel<String> users;

	@PostConstruct
	public void init() {

		setLazyWarehouseModel(new LazyWarehouseModel(warehouseService));

		List<String> citiesSource = new ArrayList<String>();
		List<String> citiesTarget = new ArrayList<String>();

		users = new DualListModel<String>(citiesSource, citiesTarget);
		;
	}

	public void addUserToWarehouse(WarehouseVO warehouse) {
		try {
			List<String> tmp = users.getTarget();
			List<UserVO> usersadd = new ArrayList<UserVO>();

			for (String name : tmp) {
				usersadd.add(adminService.getUserByName(name));
			}

			warehouse.setUsers(usersadd);
			warehouseService.update(warehouse);

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Succes",
							"Add user!"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
							"Add user!"));
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
		} finally {
			newWarehouseName = "";
			newWarehouseAddress = "";
			newWarehouseAddressNumber = "";
			newWarehouseCity = "";
			newWarehouseAddressZipCode = "";
			newWarehouseId = "";
		}

	}

	public void removeWarehouse() {
		try {
			warehouseService.delete(selectedWarehouse);

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

	public void onRowSelect(SelectEvent event) {

		selectedWarehouse = (WarehouseVO) event.getObject();

		List<UserVO> selecteUserVos = selectedWarehouse.getUsers();
		List<String> selectedusersName = new ArrayList<String>();
		for (UserVO peoples : selecteUserVos) {
			selectedusersName.add(peoples.getUserName());
		}

		List<UserVO> allUsers = adminService.getUsers();
		List<String> allUsersName = new ArrayList<String>();
		for (UserVO peoples : allUsers) {
			allUsersName.add(peoples.getUserName());
		}

		for (String name : selectedusersName) {
			allUsersName.remove(name);
		}

		users = new DualListModel<String>(allUsersName, selectedusersName);

		updateWarehouseName = selectedWarehouse.getName();
		updateWarehouseAddress = selectedWarehouse.getAddress();
		updateWarehouseAddressNumber = selectedWarehouse.getAddressNumber();
		updateWarehouseAddressZipCode = selectedWarehouse.getZipCode();
		updateWarehouseCity = selectedWarehouse.getCity();

	}

	public DualListModel<String> getUsers() {
		return users;
	}

	public void setUsers(DualListModel<String> users) {
		this.users = users;
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

	public WarehouseServiceRemote getWarehouseService() {
		return warehouseService;
	}

	public void setWarehouseService(WarehouseServiceRemote warehouseService) {
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

	public String getNewWarehouseAddressNumber() {
		return newWarehouseAddressNumber;
	}

	public void setNewWarehouseAddressNumber(String newWarehouseAddressNumber) {
		this.newWarehouseAddressNumber = newWarehouseAddressNumber;
	}

	public String getUpdateWarehouseAddressNumber() {
		return updateWarehouseAddressNumber;
	}

	public void setUpdateWarehouseAddressNumber(
			String updateWarehouseAddressNumber) {
		this.updateWarehouseAddressNumber = updateWarehouseAddressNumber;
	}

	public String getNewWarehouseAddressZipCode() {
		return newWarehouseAddressZipCode;
	}

	public void setNewWarehouseAddressZipCode(String newWarehouseAddressZipCode) {
		this.newWarehouseAddressZipCode = newWarehouseAddressZipCode;
	}

	public String getUpdateWarehouseAddressZipCode() {
		return updateWarehouseAddressZipCode;
	}

	public void setUpdateWarehouseAddressZipCode(
			String updateWarehouseAddressZipCode) {
		this.updateWarehouseAddressZipCode = updateWarehouseAddressZipCode;
	}

	public AdminServiceRemote getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminServiceRemote adminService) {
		this.adminService = adminService;
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
