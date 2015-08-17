package hu.neuron.java.warehouse.whCore.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Transport")
public class Transport extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * A feladó raktár id-ja
	 */
	private long fromWarehouseId;

	/**
	 * Az átvevő raktár id-ja
	 */
	private long toWarehouseId;
	
	/**
	 * A szállítás státusza
	 */
	private String transportStatus;

	public long getFromWarehouseId() {
		return fromWarehouseId;
	}

	public void setFromWarehouseId(long fromWarehouseId) {
		this.fromWarehouseId = fromWarehouseId;
	}

	public long getToWarehouseId() {
		return toWarehouseId;
	}

	public void setToWarehouseId(long toWarehouseId) {
		this.toWarehouseId = toWarehouseId;
	}

	public String getTransportStatus() {
		return transportStatus;
	}

	public void setTransportStatus(String transportStatus) {
		this.transportStatus = transportStatus;
	}
	
}
