package hu.neuron.java.warehouse.whBusiness.vo;

import java.io.Serializable;

public class TransportDetailsVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long transportId;

	private WarehouseVO fromWarehouse;

	private WarehouseVO toWarehouse;

	private WareVo ware;

	private int piece;

	public Long getTransportId() {
		return transportId;
	}

	public void setTransportId(Long transportId) {
		this.transportId = transportId;
	}

	public WarehouseVO getFromWarehouse() {
		return fromWarehouse;
	}

	public void setFromWarehouse(WarehouseVO fromWarehouse) {
		this.fromWarehouse = fromWarehouse;
	}

	public WarehouseVO getToWarehouse() {
		return toWarehouse;
	}

	public void setToWarehouse(WarehouseVO toWarehouse) {
		this.toWarehouse = toWarehouse;
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
