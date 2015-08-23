package hu.neuron.java.warehouse.whBusiness.service;

import hu.neuron.java.warehouse.whBusiness.vo.StockHistoryVO;
import hu.neuron.java.warehouse.whBusiness.vo.StockVO;
import hu.neuron.java.warehouse.whBusiness.vo.TransportVO;
import hu.neuron.java.warehouse.whBusiness.vo.WarehouseVO;

import java.util.List;

public interface StockReportServiceRemote {

	public WarehouseVO getWarehouseByName(String warehouseName);

	public int getStockRowNumber();

	public int getStockHistoryRowNumber();

	public int getTransportRowNumber();

	public List<StockVO> getStock();

	public List<StockHistoryVO> getStockHistory();

	public List<TransportVO> getTransports();
	
	public List<WarehouseVO> getWarehouses();

	public List<StockVO> getStock(int i, int pageSize, String sortField, int sortOrder,
			String filter, String filterColumnName);

	public List<StockHistoryVO> getStockHistory(int i, int pageSize, String sortField,
			int sortOrder, String filter, String filterColumnName);

	public List<TransportVO> getTransports(int i, int pageSize, String sortField, int sortOrder,
			String filter, String filterColumnName);

	public int getStockCount();

	public int getStockHistoryCount();

	public int getTransportCount();
}
