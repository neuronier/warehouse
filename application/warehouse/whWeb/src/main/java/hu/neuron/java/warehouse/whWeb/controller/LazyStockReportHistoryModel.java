package hu.neuron.java.warehouse.whWeb.controller;

import hu.neuron.java.warehouse.whBusiness.service.StockReportServiceRemote;
import hu.neuron.java.warehouse.whBusiness.vo.StockHistoryVO;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyStockReportHistoryModel extends LazyDataModel<StockHistoryVO> {
	private static final long serialVersionUID = 1L;

	private List<StockHistoryVO> visibleList;

	private StockReportServiceRemote stockReportService;

	private String selectedWarehouseName = " ";
	
	private Date startDate;
	private Date endDate;

	public LazyStockReportHistoryModel(StockReportServiceRemote stockReportService) {
		super();
		this.stockReportService = stockReportService;
	}

	@Override
	public StockHistoryVO getRowData(String rowkey) {
		if (visibleList != null || rowkey != null) {
			for (StockHistoryVO stockHistoryVO : visibleList) {
				if (stockHistoryVO.getId().toString().equals(rowkey)) {
					return stockHistoryVO;
				}
			}
		}
		return null;
	}

	@Override
	public Object getRowKey(StockHistoryVO stockHistoryVO) {
		if (stockHistoryVO == null) {
			return null;
		}
		return stockHistoryVO.getId();
	}

	@Override
	public List<StockHistoryVO> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {
		filters.put("warehouse", selectedWarehouseName);
		filters.put("startDate", startDate);
		filters.put("endDate", endDate);
		
		int dir;

		if (sortField == null) {
			sortField = "changeTime";
			dir = 2;
		} else {
			dir = sortOrder.equals(SortOrder.ASCENDING) ? 1 : 2;
		}
		visibleList = stockReportService.getStockHistory(first / pageSize, pageSize, sortField,
				dir, filters);

		int dataSize = stockReportService.getStockHistoryCount();

		this.setRowCount(dataSize);

		return visibleList;

	}

	public List<StockHistoryVO> getVisibleList() {
		return visibleList;
	}

	public void setVisibleList(List<StockHistoryVO> visibleList) {
		this.visibleList = visibleList;
	}

	public StockReportServiceRemote getStockReportService() {
		return stockReportService;
	}

	public void setStockReportService(StockReportServiceRemote stockReportService) {
		this.stockReportService = stockReportService;
	}

	public String getSelectedWarehouseName() {
		return selectedWarehouseName;
	}

	public void setSelectedWarehouseName(String selectedWarehouseName) {
		this.selectedWarehouseName = selectedWarehouseName;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}
