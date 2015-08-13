package hu.neuron.java.warehouse.whBusiness.vo;

import java.io.Serializable;
import java.util.Collection;

public class WarehouseVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private String name;
	
	private Long id;

	private String warehouseId;

	private int zipCode;

	private String city;

	private String address;

	private int addressNumber;

	private Collection<UserVO> users;
	
	public Collection<UserVO> getUsers() {
		return users;
	}
	public void setUsers(Collection<UserVO> users) {
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "WarehouseVO [name=" + name + ", id=" + id + ", warehouseId="
				+ warehouseId + ", zipCode=" + zipCode + ", city=" + city
				+ ", address=" + address + ", addressNumber=" + addressNumber
				+ ", users=" + users + "]";
	}
	
	

	
	
	

}
