package hu.neuron.java.warehouse.whBusiness.service;


public interface TransportServiceRemote {

	void transportItemToWarehouse(String fromWarehouseId, String toWarehouseId,
			Long wareId, int piece) throws Exception;

}
