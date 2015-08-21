package hu.neuron.java.warehouse.whCore.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
	@ManyToOne(targetEntity = Warehouse.class)
	private Long fromWarehouseId;

	/**
	 * Az átvevő raktár id-ja
	 */
	@ManyToOne(targetEntity = Warehouse.class)
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
