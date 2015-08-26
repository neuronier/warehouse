package hu.neuron.java.warehouse.whCore.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Transport")
public class Transport extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * A feladó raktár id-ja
	 */
	//id, csak odagenerálja mögé a _id -t
	@ManyToOne(targetEntity = Warehouse.class)
	private Warehouse fromWarehouse;

	/**
	 * Az átvevő raktár id-ja
	 */
	//id, csak odagenerálja mögé a _id -t
	@ManyToOne(targetEntity = Warehouse.class)
	private Warehouse toWarehouse;
	
	/**
	 * Az szállítás id-ja
	 */
	//id, csak odagenerálja mögé a _id -t
	@OneToMany(targetEntity = TransportDetails.class)
	private List<TransportDetails> transport;
	
	/**
	 * A szállítás státusza
	 */
	private String transportStatus;

	public Warehouse getFromWarehouse() {
		return fromWarehouse;
	}

	public void setFromWarehouse(Warehouse fromWarehouse) {
		this.fromWarehouse = fromWarehouse;
	}

	public Warehouse getToWarehouse() {
		return toWarehouse;
	}

	public void setToWarehouse(Warehouse toWarehouse) {
		this.toWarehouse = toWarehouse;
	}

	public List<TransportDetails> getTransport() {
		return transport;
	}

	public void setTransport(List<TransportDetails> transport) {
		this.transport = transport;
	}

	public String getTransportStatus() {
		return transportStatus;
	}

	public void setTransportStatus(String transportStatus) {
		this.transportStatus = transportStatus;
	}	

	@Override
	public String toString() {
		return "Transport [fromWarehouse=" + fromWarehouse + ", toWarehouse="
				+ toWarehouse + ", transportStatus=" + transportStatus + "]";
	}
	
}
