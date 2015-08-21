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
	//id, csak odagenerálja mögé a _id -t
	@ManyToOne(targetEntity = Warehouse.class)
	private Long fromWarehouse;

	/**
	 * Az átvevő raktár id-ja
	 */
	//id, csak odagenerálja mögé a _id -t
	@ManyToOne(targetEntity = Warehouse.class)
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
