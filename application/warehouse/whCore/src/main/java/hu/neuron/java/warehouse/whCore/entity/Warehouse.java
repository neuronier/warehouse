package hu.neuron.java.warehouse.whCore.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Warehouse")
public class Warehouse extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(unique = true, nullable = false)
	private String name;

	@Column(unique = true, nullable = false)
	private String warehouseId;

	@Column(nullable = false)
	private int zipCode;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private int addressNumber;

	// @ManyToMany(fetch = FetchType.LAZY)
	// @JoinTable(name = "warehouse_user")
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "warehouse_user", joinColumns = { @JoinColumn(name = "warehouseId") }, inverseJoinColumns = { @JoinColumn(name = "userName") })
	private Collection<User> users;

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(int addressNumber) {
		this.addressNumber = addressNumber;
	}

	@Override
	public String toString() {
		return "Warehouse [name=" + name + ", warehouseId=" + warehouseId
				+ ", zipCode=" + zipCode + ", city=" + city + ", address="
				+ address + ", addressNumber=" + addressNumber + ", users="
				+ users + "]";
	}

}
