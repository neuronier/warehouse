package hu.neuron.java.warehouse.whCore.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class of Role.
 */
@Entity
@Table(name = "UserRoleMap")
public class UserRoleMap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	@ManyToOne
    @JoinColumn(name = "user_name", referencedColumnName = "userName")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_name", referencedColumnName = "roleName")
    private Role role;
    
    @Override
	public String toString() {
		return "UserRoleMap [id="+id+"]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
