package hu.neuron.java.warehouse.whBusiness.vo;

import java.io.Serializable;

public class TransportVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * A feladó raktár id-ja
	 */
	private Long fromWarehouse;

	/**
	 * Az átvevő raktár id-ja
	 */
	private Long toWarehouse;
	
	/**
	 * A szállítás státusza
	 */
	private String transportStatus;

	public Long getFromWarehouseId() {
		return fromWarehouse;
	}

	public void setFromWarehouseId(Long fromWarehouseId) {
		this.fromWarehouse = fromWarehouseId;
	}

	public Long getToWarehouseId() {
		return toWarehouse;
	}

	public void setToWarehouseId(Long toWarehouseId) {
		this.toWarehouse = toWarehouseId;
	}

	public String getTransportStatus() {
		return transportStatus;
	}

	public void setTransportStatus(String transportStatus) {
		this.transportStatus = transportStatus;
	}

}
