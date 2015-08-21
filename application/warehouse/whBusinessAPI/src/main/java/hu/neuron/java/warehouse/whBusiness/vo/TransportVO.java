package hu.neuron.java.warehouse.whBusiness.vo;

import java.io.Serializable;

public class TransportVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * A feladó raktár id-ja
	 */
	private Long fromWarehouseId;

	/**
	 * Az átvevő raktár id-ja
	 */
	private Long toWarehouseId;
	
	/**
	 * A szállítás státusza
	 */
	private String transportStatus;

	public Long getFromWarehouseId() {
		return fromWarehouseId;
	}

	public void setFromWarehouseId(Long fromWarehouseId) {
		this.fromWarehouseId = fromWarehouseId;
	}

	public Long getToWarehouseId() {
		return toWarehouseId;
	}

	public void setToWarehouseId(Long toWarehouseId) {
		this.toWarehouseId = toWarehouseId;
	}

	public String getTransportStatus() {
		return transportStatus;
	}

	public void setTransportStatus(String transportStatus) {
		this.transportStatus = transportStatus;
	}

}
