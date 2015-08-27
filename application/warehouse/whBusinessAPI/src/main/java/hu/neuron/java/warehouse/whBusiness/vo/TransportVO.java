package hu.neuron.java.warehouse.whBusiness.vo;

import java.io.Serializable;

public class TransportVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	/**
	 * A feladó raktár id-ja
	 */
	private WarehouseVO fromWarehouse;

	/**
	 * Az átvevő raktár id-ja
	 */
	private WarehouseVO toWarehouse;
	
	/**
	 * A szállítás státusza
	 */
	private String transportStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public WarehouseVO getFromWarehouse() {
		return fromWarehouse;
	}

	public void setFromWarehouse(WarehouseVO fromWarehouse) {
		this.fromWarehouse = fromWarehouse;
	}

	public WarehouseVO getToWarehouse() {
		return toWarehouse;
	}

	public void setToWarehouse(WarehouseVO toWarehouse) {
		this.toWarehouse = toWarehouse;
	}

	public String getTransportStatus() {
		return transportStatus;
	}

	public void setTransportStatus(String transportStatus) {
		this.transportStatus = transportStatus;
	}

}
