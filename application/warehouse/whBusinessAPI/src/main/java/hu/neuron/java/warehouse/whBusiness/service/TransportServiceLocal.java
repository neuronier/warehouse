package hu.neuron.java.warehouse.whBusiness.service;


public interface TransportServiceLocal {

	void transportItemToWarehouse(String fromWarehouseId, String toWarehouseId,
			Long wareId, int piece) throws Exception;

}
