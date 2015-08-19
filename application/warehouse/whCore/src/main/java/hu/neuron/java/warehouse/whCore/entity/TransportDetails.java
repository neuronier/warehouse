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

	@ManyToOne(targetEntity = Ware.class)
	private Ware wareId;

	private int piece;

	public Ware getWare() {
		return wareId;
	}

	public void setWare(Ware ware) {
		this.wareId = ware;
	}

	public int getPiece() {
		return piece;
	}

	public void setPiece(int piece) {
		this.piece = piece;
	}

	@Override
	public String toString() {
		return "TransportDetails [transportId=" + transportId + ", ware="
				+ wareId + ", piece=" + piece + "]";
	}

	

}
