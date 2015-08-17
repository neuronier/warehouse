package hu.neuron.java.warehouse.whCore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TransportDetails")
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class TransportDetails extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private Long transportId;

	@ManyToOne(targetEntity = Warehouse.class)
	Warehouse fromWarehouse;

	@ManyToOne(targetEntity = Warehouse.class)
	Warehouse toWarehouse;

	@ManyToOne(targetEntity = Ware.class)
	Ware ware;

	int piece;

	public Warehouse getToWarehouse() {
		return toWarehouse;
	}

	public void setToWarehouse(Warehouse toWarehouse) {
		this.toWarehouse = toWarehouse;
	}

	public Warehouse getFromWarehouse() {
		return fromWarehouse;
	}

	public void setFromWarehouse(Warehouse fromWarehouse) {
		this.fromWarehouse = fromWarehouse;
	}

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

	@Override
	public String toString() {
		return "TransportDetails [toWarehouse=" + toWarehouse
				+ ", fromWarehouse=" + fromWarehouse + ", ware=" + ware
				+ ", piece=" + piece + "]";
	}

}
