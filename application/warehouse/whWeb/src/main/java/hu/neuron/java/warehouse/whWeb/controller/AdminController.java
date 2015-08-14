package hu.neuron.java.warehouse.whWeb.controller;

import hu.neuron.java.warehouse.whBusiness.service.AdminServiceRemote;
import hu.neuron.java.warehouse.whBusiness.vo.RoleVO;
import hu.neuron.java.warehouse.whBusiness.vo.UserVO;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

@ViewScoped
@ManagedBean(name = "adminController")
public class AdminController implements Serializable {
	private static final long serialVersionUID = 1L;

	private LazyAdminModel lazyAdminModel;

	@EJB(beanName = "AdminService")
	private AdminServiceRemote adminService;

	private UserVO selectedUser;

	private Boolean enabled;

	private List<RoleVO> roles;
	private List<RoleVO> selectedRoles;

	@PostConstruct
	public void init() {
		setLazyAdminModel(new LazyAdminModel(getAdminService()));
	}

	public void onRowSelect(SelectEvent event) {
		selectedUser = (UserVO) event.getObject();
		enabled = selectedUser.getEnabled() == 1 ? true : false;
		roles = adminService.getRoles();
		selectedRoles = selectedUser.getRoles();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", selectedUser.getUserName()));
	}

	public String updateUser() {
		if (!selectedUser.getUserName().equals("admin")) {
			selectedUser.setEnabled(enabled == true ? 1 : 0);
			selectedUser.setRoles(selectedRoles);
			try {
				if (adminService.updateUser(selectedUser)) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Update Success"));
					selectedUser = null;
					selectedRoles = null;
					roles = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
			}
			return null;
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
							"Admin can't be changed"));
			selectedUser = null;
			selectedRoles = null;
			roles = null;
			return null;
		}

	}

	public void cancelSelect() {
		selectedUser = null;
		selectedRoles = null;
		roles = null;
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Update Canceled"));
	}

	public AdminServiceRemote getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminServiceRemote adminService) {
		this.adminService = adminService;
	}

	public LazyAdminModel getLazyAdminModel() {
		return lazyAdminModel;
	}

	public void setLazyAdminModel(LazyAdminModel lazyAdminModel) {
		this.lazyAdminModel = lazyAdminModel;
	}

	public UserVO getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UserVO selectedUser) {
		this.selectedUser = selectedUser;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<RoleVO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleVO> roles) {
		this.roles = roles;
	}

	public List<RoleVO> getSelectedRoles() {
		return selectedRoles;
	}

	public void setSelectedRoles(List<RoleVO> selectedRoles) {
		this.selectedRoles = selectedRoles;
	}
}
