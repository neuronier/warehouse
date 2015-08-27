package hu.neuron.java.warehouse.whBusiness.service;

import java.util.List;

import hu.neuron.java.warehouse.whBusiness.vo.TransportDetailsVO;
import hu.neuron.java.warehouse.whBusiness.vo.TransportVO;

public interface TransportServiceRemote {

	void transportItemToWarehouse(TransportVO transportVO,
			TransportDetailsVO detailsVO);

	TransportVO fillTransportTable(TransportVO transportVO);
	
	void fillDetailsTable(TransportDetailsVO detailsVO);

	void updateStatus(String status, Long fromWarehouse_id, Long toWarehouse_id);

	public List<Long> getids();

}
