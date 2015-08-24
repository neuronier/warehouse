package hu.neuron.java.warehouse.whWeb.controller;

import java.util.List;
import java.util.Map;

import hu.neuron.java.warehouse.whBusiness.service.WareServiceLocal;
import hu.neuron.java.warehouse.whBusiness.vo.WareVo;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyWareModel extends LazyDataModel<WareVo> {

	private List<WareVo> visibleRoleList = null;

	private WareServiceLocal wareService;

	public WareServiceLocal getWareService() {
		return wareService;
	}

	public void setWareService(WareServiceLocal wareservice) {
		this.wareService = wareservice;
	}

	public LazyWareModel(WareServiceLocal wareService) {
		super();
		this.wareService = wareService;
	}

	@Override
	public WareVo getRowData(String rowkey) {
		if (visibleRoleList != null || rowkey != null) {
			for (WareVo wareVo : visibleRoleList) {
				if (wareVo.getId().toString().equals(rowkey)) {
					return wareVo;
				}
			}
		}
		return null;
	}

	@Override
	public Object getRowKey(WareVo wareVo) {
		if (wareVo == null) {
			return null;
		}
		return wareVo.getId();
	}

	@Override
	public List<WareVo> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {
		int vSize = -1;
		String filter = "";
		String filterColumnName = "";
		if (filters.keySet().size() > 0) {
			filter = (String) filters.values().toArray()[0];
			filterColumnName = filters.keySet().iterator().next();
		}
		if (sortField == null) {
			sortField = "wareName";
		}
//		List<WareVo> wareList = null;
		int dir = sortOrder.equals(SortOrder.ASCENDING) ? 1 : 2;
		visibleRoleList = wareService.getWares(first / pageSize, pageSize, sortField,
				dir, filter, filterColumnName);

//		for (WareVo wareVo : wareList) {
//			if (wareVo.getVisible() == 1) {
//				visibleRoleList.add(wareVo);
//
//			}
//
//		}

		int dataSize = wareService.getRowNumber();

		this.setRowCount(dataSize);

		return visibleRoleList;

	}

}
