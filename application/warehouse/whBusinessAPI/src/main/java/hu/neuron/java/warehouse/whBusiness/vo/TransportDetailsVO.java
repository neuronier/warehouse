package hu.neuron.java.warehouse.whBusiness.vo;

import java.io.Serializable;

public class TransportDetailsVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long transportId;

	private WareVo wareId;

	private int piece;

	public Long getTransportId() {
		return transportId;
	}

	public void setTransportId(Long transportId) {
		this.transportId = transportId;
	}

	public WareVo getWare() {
		return wareId;
	}

	public void setWare(WareVo ware) {
		this.wareId = ware;
	}

	public int getPiece() {
		return piece;
	}

	public void setPiece(int piece) {
		this.piece = piece;
	}
	
}
