package hu.neuron.java.warehouse.whBusiness.service;

import java.util.List;
import java.util.Map;

import hu.neuron.java.warehouse.whBusiness.vo.TransportDetailsVO;
import hu.neuron.java.warehouse.whBusiness.vo.TransportVO;
import hu.neuron.java.warehouse.whBusiness.vo.UserVO;

public interface TransportServiceRemote {

	void transportItemToWarehouse(TransportVO transportVO,
			TransportDetailsVO detailsVO);

	TransportVO fillTransportTable(TransportVO transportVO);
	
	void fillDetailsTable(TransportDetailsVO detailsVO);

	void updateStatus(String status, Long fromWarehouse_id, Long toWarehouse_id);

	public List<Long> getids();

	List<TransportVO> getByUsers(int i, int pageSize, String sortField, int dir,
			Map<String, Object> filters);
	
	public UserVO getUserByName(String user);

}
