package hu.neuron.java.warehouse.whBusiness.service;

import hu.neuron.java.warehouse.whBusiness.vo.TransportVO;

public interface TransportServiceRemote {

	public void save(TransportVO transportVO);

	public void delete(TransportVO transportVO);

	public void update(TransportVO transportVO);

	public void transportItemToWarehouse(Long fromWarehouseId,
			Long toWarehouseId) throws Exception;

}
