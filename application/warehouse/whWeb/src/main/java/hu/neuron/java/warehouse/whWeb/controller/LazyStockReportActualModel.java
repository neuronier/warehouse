package hu.neuron.java.warehouse.whWeb.controller;

import hu.neuron.java.warehouse.whBusiness.service.StockReportServiceRemote;
import hu.neuron.java.warehouse.whBusiness.vo.StockVO;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyStockReportActualModel extends LazyDataModel<StockVO> {
	private static final long serialVersionUID = 1L;

	private List<StockVO> visibleUserList;

	private StockReportServiceRemote stockReportService;

	public LazyStockReportActualModel(StockReportServiceRemote stockReportService) {
		super();
		this.stockReportService = stockReportService;
	}

	@Override
	public StockVO getRowData(String rowkey) {
		if (visibleUserList != null || rowkey != null) {
			for (StockVO stockVO : visibleUserList) {
				if (stockVO.getId().toString().equals(rowkey)) {
					return stockVO;
				}
			}
		}
		return null;
	}

	@Override
	public Object getRowKey(StockVO stockVO) {
		if (stockVO == null) {
			return null;
		}
		return stockVO.getId();
	}

	@Override
	public List<StockVO> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {

		String filter = "";
		String filterColumnName = "";
		if (filters.keySet().size() > 0) {
			filter = (String) filters.values().toArray()[0];
			filterColumnName = filters.keySet().iterator().next();
		}
		if (sortField == null) {
			sortField = "ware";
		}

		int dir = sortOrder.equals(SortOrder.ASCENDING) ? 1 : 2;
		visibleUserList = stockReportService.getStock(first / pageSize, pageSize, sortField, dir, filter,
				filterColumnName);

		int dataSize = stockReportService.getStockCount();

		this.setRowCount(dataSize);

		return visibleUserList;

	}

	public List<StockVO> getVisibleUserList() {
		return visibleUserList;
	}

	public void setVisibleUserList(List<StockVO> visibleUserList) {
		this.visibleUserList = visibleUserList;
	}

	public StockReportServiceRemote getStockReportService() {
		return stockReportService;
	}

	public void setStockReportService(StockReportServiceRemote stockReportService) {
		this.stockReportService = stockReportService;
	}

}
