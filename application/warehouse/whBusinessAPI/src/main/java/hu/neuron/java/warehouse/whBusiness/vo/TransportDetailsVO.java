package hu.neuron.java.warehouse.whBusiness.vo;

import java.io.Serializable;

public class TransportDetailsVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;

	private TransportVO transport;

	private WareVo ware;

	private int piece;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TransportVO getTransport() {
		return transport;
	}

	public void setTransport(TransportVO transport) {
		this.transport = transport;
	}

	public WareVo getWare() {
		return ware;
	}

	public void setWare(WareVo ware) {
		this.ware = ware;
	}

	public int getPiece() {
		return piece;
	}

	public void setPiece(int piece) {
		this.piece = piece;
	}
	
}
