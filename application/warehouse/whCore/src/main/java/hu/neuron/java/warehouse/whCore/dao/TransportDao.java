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

	@Modifying
	@Query(value = "UPDATE stock SET piece=piece+?1 WHERE ware_id = ?2 and warehouse_id=?3", nativeQuery = true) 
	void transportToWarehouse(int piece, Long wareId, String toWarehouseId) throws Exception;
	
	@Modifying
	@Query(value = "UPDATE stock SET piece=piece-?1 WHERE ware_id = ?2 and warehouse_id=?3", nativeQuery = true) 
	void transportFromWarehouse(int piece, Long wareId, String toWarehouseId) throws Exception;
	
	@Modifying
	@Query(value = "INSERT INTO transport(from_warehouseId, to_warehouseId)"
				   + "VALUES (?1, ?2)", nativeQuery = true) 
	void addToTransport(String fromWarehouseId, String toWarehouseId) throws Exception;
}
