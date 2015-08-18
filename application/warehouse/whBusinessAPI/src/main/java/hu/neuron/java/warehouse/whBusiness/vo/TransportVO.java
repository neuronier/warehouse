package hu.neuron.java.warehouse.whBusiness.vo;

import java.io.Serializable;

public class TransportVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * A feladó raktár id-ja
	 */
	private String fromWarehouseId;

	/**
	 * Az átvevő raktár id-ja
	 */
	private String toWarehouseId;
	
	/**
	 * A szállítás státusza
	 */
	private String transportStatus;

	public String getFromWarehouseId() {
		return fromWarehouseId;
	}

	public void setFromWarehouseId(String fromWarehouseId) {
		this.fromWarehouseId = fromWarehouseId;
	}

	public String getToWarehouseId() {
		return toWarehouseId;
	}

	public void setToWarehouseId(String toWarehouseId) {
		this.toWarehouseId = toWarehouseId;
	}

	public String getTransportStatus() {
		return transportStatus;
	}

	public void setTransportStatus(String transportStatus) {
		this.transportStatus = transportStatus;
	}

}
