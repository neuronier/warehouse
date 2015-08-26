package hu.neuron.java.warehouse.whCore.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Transport_Details")
public class TransportDetails extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//id, csak odagenerálja mögé a _id -t
	@ManyToOne(targetEntity = Warehouse.class)
	private Transport transport;

	//id, csak odagenerálja mögé a _id -t
	@ManyToOne(targetEntity = Ware.class)
	private Ware ware;

	private int piece;

	public Ware getWare() {
		return ware;
	}

	public void setWare(Ware ware) {
		this.ware = ware;
	}

	public int getPiece() {
		return piece;
	}

	public void setPiece(int piece) {
		this.piece = piece;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	@Override
	public String toString() {
		return "TransportDetails [transport=" + transport + ", ware=" + ware
				+ ", piece=" + piece + "]";
	}	

}
