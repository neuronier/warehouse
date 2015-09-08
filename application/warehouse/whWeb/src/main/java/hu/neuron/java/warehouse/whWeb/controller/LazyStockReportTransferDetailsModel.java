package hu.neuron.java.warehouse.whWeb.controller;

import hu.neuron.java.warehouse.whBusiness.service.StockReportServiceRemote;
import hu.neuron.java.warehouse.whBusiness.vo.TransportDetailsVO;
import hu.neuron.java.warehouse.whBusiness.vo.TransportVO;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyStockReportTransferDetailsModel extends LazyDataModel<TransportDetailsVO> {
	private static final long serialVersionUID = 1L;

	private List<TransportDetailsVO> visibleList;

	private StockReportServiceRemote stockReportService;

	private TransportVO selectedTransport = new TransportVO();

	public LazyStockReportTransferDetailsModel(StockReportServiceRemote stockReportService) {
		super();
		this.stockReportService = stockReportService;
	}

	@Override
	public TransportDetailsVO getRowData(String rowkey) {
		if (visibleList != null || rowkey != null) {
			for (TransportDetailsVO transportDetailsVO : visibleList) {
				if (transportDetailsVO.getId().toString().equals(rowkey)) {
					return transportDetailsVO;
				}
			}
		}
		return null;
	}

	@Override
	public Object getRowKey(TransportDetailsVO transportDetailsVO) {
		if (transportDetailsVO == null) {
			return null;
		}
		return transportDetailsVO.getId();
	}

	@Override
	public List<TransportDetailsVO> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {

		filters.put("transport", selectedTransport.getId());

		if (sortField == null) {
			sortField = "piece";
		}

		int dir = sortOrder.equals(SortOrder.ASCENDING) ? 1 : 2;
		visibleList = stockReportService.getTransportDetails(first / pageSize, pageSize, sortField,
				dir, filters);

		int dataSize = visibleList.size();

		this.setRowCount(dataSize);

		return visibleList;

	}

	public List<TransportDetailsVO> getVisibleList() {
		return visibleList;
	}

	public void setVisibleList(List<TransportDetailsVO> visibleList) {
		this.visibleList = visibleList;
	}

	public StockReportServiceRemote getStockReportService() {
		return stockReportService;
	}

	public void setStockReportService(StockReportServiceRemote stockReportService) {
		this.stockReportService = stockReportService;
	}

	public TransportVO getSelectedTransport() {
		return selectedTransport;
	}

	public void setSelectedTransport(TransportVO selectedTransport) {
		this.selectedTransport = selectedTransport;
	}

}
