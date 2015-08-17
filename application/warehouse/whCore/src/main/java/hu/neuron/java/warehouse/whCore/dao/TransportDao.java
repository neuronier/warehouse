package hu.neuron.java.warehouse.whCore.dao;

import hu.neuron.java.warehouse.whCore.entity.Transport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface TransportDao extends JpaRepository<Transport, Long> {

	//még kell ide egy update -1fromwh; +1towh
	@Modifying
	@Query(value = "INSERT INTO transport_details (from_warehouseId, to_warehouseId, wareId, piece) "
				   + "VALUES (?1, ?2, ?3, ?4)", nativeQuery = true) 
	void transportItemToWarehouse(String fromWarehouseId, String toWarehouseId,
			Long wareId, int piece) throws Exception;
}
