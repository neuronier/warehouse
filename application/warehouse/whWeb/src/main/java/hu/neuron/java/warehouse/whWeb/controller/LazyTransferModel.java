package hu.neuron.java.warehouse.whWeb.controller;

import hu.neuron.java.warehouse.whBusiness.service.StockReportServiceRemote;
import hu.neuron.java.warehouse.whBusiness.service.TransportDetailsServiceRemote;
import hu.neuron.java.warehouse.whBusiness.service.TransportServiceRemote;
import hu.neuron.java.warehouse.whBusiness.vo.TransportVO;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyTransferModel extends LazyDataModel<TransportVO> {
	private static final long serialVersionUID = 1L;

	private List<TransportVO> visibleList;

	private StockReportServiceRemote stockReportService;

	private TransportServiceRemote serviceRemote;

	private TransportDetailsServiceRemote detailsServiceRemote;

	public LazyTransferModel(StockReportServiceRemote stockReportService,
			TransportServiceRemote serviceRemote) {
		super();
		this.stockReportService = stockReportService;
		this.serviceRemote = serviceRemote;
	}

	@Override
	public TransportVO getRowData(String rowkey) {
		if (visibleList != null || rowkey != null) {
			for (TransportVO transportVO : visibleList) {
				if (transportVO.getId().toString().equals(rowkey)) {
					return transportVO;
				}
			}
		}
		return null;
	}

	@Override
	public Object getRowKey(TransportVO transportVO) {
		if (transportVO == null) {
			return null;
		}
		return transportVO.getId();
	}

	@Override
	public List<TransportVO> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {

		if (sortField == null) {
			sortField = "fromWarehouse";
		}

		int dir = sortOrder.equals(SortOrder.ASCENDING) ? 1 : 2;
		visibleList = serviceRemote.getByUsers(first / pageSize, pageSize,
				sortField, dir, filters);

		int dataSize = visibleList.size();

		this.setRowCount(dataSize);

		return visibleList;

	}

	public List<TransportVO> getVisibleList() {
		return visibleList;
	}

	public void setVisibleList(List<TransportVO> visibleList) {
		this.visibleList = visibleList;
	}

	public StockReportServiceRemote getStockReportService() {
		return stockReportService;
	}

	public void setStockReportService(
			StockReportServiceRemote stockReportService) {
		this.stockReportService = stockReportService;
	}

	public TransportServiceRemote getServiceRemote() {
		return serviceRemote;
	}

	public void setServiceRemote(TransportServiceRemote serviceRemote) {
		this.serviceRemote = serviceRemote;
	}

	public TransportDetailsServiceRemote getDetailsServiceRemote() {
		return detailsServiceRemote;
	}

	public void setDetailsServiceRemote(
			TransportDetailsServiceRemote detailsServiceRemote) {
		this.detailsServiceRemote = detailsServiceRemote;
	}

}
