package hu.neuron.java.warehouse.whCore.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class of Role.
 */
@Entity
@Table(name = "Role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true, nullable = false)
	private String roleName;

	@OneToMany(mappedBy = "role")
	private Collection<UserRoleMap> users = new ArrayList<>();

	@Override
	public String toString() {
		return "Role [roleName=" + roleName + ", id=" + id + "]";
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

	public Collection<UserRoleMap> getUsers() {
		return users;
	}

	public void setUsers(Collection<UserRoleMap> users) {
		this.users = users;
	}

}
