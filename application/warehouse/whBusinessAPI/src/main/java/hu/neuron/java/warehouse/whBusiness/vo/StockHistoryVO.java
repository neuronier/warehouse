package hu.neuron.java.warehouse.whBusiness.vo;

import java.io.Serializable;
import java.util.Date;

public class StockHistoryVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String warehouse;

	private String ware;

	private int piece;

	private Date changeTime;

	@Override
	public String toString() {
		return "StockHistory [Warehouse=" + warehouse + ", ware=" + ware + ", piece=" + piece
				+ ", changeTime=" + changeTime + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public String getWare() {
		return ware;
	}

	public void setWare(String ware) {
		this.ware = ware;
	}

	public int getPiece() {
		return piece;
	}

	public void setPiece(int piece) {
		this.piece = piece;
	}

	public Date getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

}
