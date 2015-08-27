package hu.neuron.java.warehouse.whBusiness.service;

import hu.neuron.java.warehouse.whBusiness.vo.TransportDetailsVO;
import hu.neuron.java.warehouse.whBusiness.vo.TransportVO;

import java.util.List;

public interface TransportDetailsServiceRemote {

	public List<TransportDetailsVO> findByTransportId(Long id);
	
	public void updateTransportDetails(TransportVO transportVo) throws Exception;
	
}
