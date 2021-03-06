package hu.neuron.java.warehouse.whBusiness.service;

import hu.neuron.java.warehouse.whBusiness.vo.StockHistoryVO;
import hu.neuron.java.warehouse.whBusiness.vo.StockVO;
import hu.neuron.java.warehouse.whBusiness.vo.TransportDetailsVO;
import hu.neuron.java.warehouse.whBusiness.vo.TransportVO;
import hu.neuron.java.warehouse.whBusiness.vo.WarehouseVO;

import java.util.List;
import java.util.Map;

public interface StockReportServiceRemote {

	public WarehouseVO getWarehouseByName(String warehouseName);

	public int getStockRowNumber();

	public int getStockHistoryRowNumber();

	public int getTransportRowNumber();
	
	public int getTransportDetailsRowNumber();

	public List<StockVO> getStock();

	public List<StockHistoryVO> getStockHistory();

	public List<TransportVO> getTransports();
	
	public List<TransportDetailsVO> getTransportDetails();

	public List<WarehouseVO> getWarehouses();

	List<StockVO> getStock(int i, int pageSize, String sortField, int sortOrder,
			Map<String, Object> filters);

	public List<StockHistoryVO> getStockHistory(int i, int pageSize, String sortField,
			int sortOrder, Map<String, Object> filters);

	public List<TransportVO> getTransports(int i, int pageSize, String sortField, int sortOrder,
			Map<String, Object> filters);
	
	public List<TransportDetailsVO> getTransportDetails(int i, int pageSize, String sortField, int sortOrder,
			Map<String, Object> filters);

	public int getStockCount();

	public int getStockHistoryCount();

	public int getTransportCount();
	
	public int getTransportDetailsCount();

}
