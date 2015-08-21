package hu.neuron.java.warehouse.whBusiness.vo;

import java.io.Serializable;

public class TransportDetailsVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long transportId;

	private Long ware;

	private int piece;

	public Long getTransportId() {
		return transportId;
	}

	public void setTransportId(Long transportId) {
		this.transportId = transportId;
	}

	public Long getWareId() {
		return ware;
	}

	public void setWareId(Long long1) {
		this.ware = long1;
	}

	public int getPiece() {
		return piece;
	}

	public void setPiece(int piece) {
		this.piece = piece;
	}
	
}
