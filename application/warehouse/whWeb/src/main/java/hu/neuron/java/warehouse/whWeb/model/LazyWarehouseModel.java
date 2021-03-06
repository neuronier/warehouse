package hu.neuron.java.warehouse.whWeb.model;

import hu.neuron.java.warehouse.whBusiness.service.UserSelfCareServiceRemote;
import hu.neuron.java.warehouse.whBusiness.service.WarehouseServiceRemote;
import hu.neuron.java.warehouse.whBusiness.vo.WarehouseVO;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyWarehouseModel extends LazyDataModel<WarehouseVO> {

	private static final long serialVersionUID = 8284121252095007781L;

	private List<WarehouseVO> visibleWarehouseList;

	private WarehouseServiceRemote warehouseService;
	private UserSelfCareServiceRemote userSelfCareService;

	public LazyWarehouseModel(WarehouseServiceRemote warehouseService) {
		super();
		this.warehouseService = warehouseService;
	}

	@Override
	public WarehouseVO getRowData(String rowkey) {
		if (visibleWarehouseList != null || rowkey != null) {
			for (WarehouseVO warehouseVO : visibleWarehouseList) {
				if (warehouseVO.getWarehouseId().toString().equals(rowkey)) {
					return warehouseVO;
				}
			}
		}
		return null;
	}

	@Override
	public Object getRowKey(WarehouseVO warehouseVO) {
		if (warehouseVO == null) {
			return null;
		}
		return warehouseVO.getWarehouseId();
	}

	@Override
	public List<WarehouseVO> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {

		String filter = "";
		String filterColumnName = "";
		if (filters.keySet().size() > 0) {
			filter = (String) filters.values().toArray()[0];
			filterColumnName = filters.keySet().iterator().next();
		}
		if (sortField == null) {
			sortField = "name";
		}

		int dir = sortOrder.equals(SortOrder.ASCENDING) ? 1 : 2;
		

		visibleWarehouseList = warehouseService.getWarehouse(first / pageSize,
				pageSize, sortField, dir, filter, filterColumnName);

		int dataSize = warehouseService.getRowNumber();

		this.setRowCount(dataSize);

		return visibleWarehouseList;
		
	}

	public WarehouseServiceRemote getWarehouseService() {
		return warehouseService;
	}

	public void setUserService(WarehouseServiceRemote warehouseService) {
		this.warehouseService = warehouseService;
	}

	public List<WarehouseVO> getVisibleWarehouseList() {
		return visibleWarehouseList;
	}

	public void setVisibleWarehouseList(List<WarehouseVO> visibleWarehouseList) {
		this.visibleWarehouseList = visibleWarehouseList;
	}

	public UserSelfCareServiceRemote getUserSelfCareService() {
		return userSelfCareService;
	}

	public void setUserSelfCareService(
			UserSelfCareServiceRemote userSelfCareService) {
		this.userSelfCareService = userSelfCareService;
	}

	public void setWarehouseService(WarehouseServiceRemote warehouseService) {
		this.warehouseService = warehouseService;
	}

}
