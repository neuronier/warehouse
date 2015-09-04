package hu.neuron.java.warehouse.whBusiness.vo;

import java.io.Serializable;

public class RoleVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String roleName;

	@Override
	public String toString() {
		return roleName.substring(5);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
