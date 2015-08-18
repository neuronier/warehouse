package hu.neuron.java.warehouse.whBusiness.service;

import hu.neuron.java.warehouse.whBusiness.vo.TransportDetailsVO;
import hu.neuron.java.warehouse.whBusiness.vo.TransportVO;

public interface TransportServiceLocal {

	void transportItemToWarehouse(TransportVO transportVO,
			TransportDetailsVO detailsVO);

}
