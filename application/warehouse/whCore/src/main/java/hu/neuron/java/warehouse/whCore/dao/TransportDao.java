package hu.neuron.java.warehouse.whCore.dao;

import hu.neuron.java.warehouse.whCore.entity.Transport;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	int transportToWarehouse(int piece, Long wareId, Long toWarehouseId)
			throws Exception;

	@Modifying
	@Query(value = "UPDATE stock SET piece=piece-?1 WHERE ware_id = ?2 and warehouse_id=?3", nativeQuery = true)
	int transportFromWarehouse(int piece, Long wareId, Long fromWarehouseId)
			throws Exception;

	@Modifying
	@Query(value = "INSERT INTO stock( piece,ware_id, warehouse_id) VALUES (?1,?2,?3)", nativeQuery = true)
	void addTransportToWarehouse(int piece, Long wareId, Long toWarehouseId)
			throws Exception;

	
	Page<Transport> findByFromWarehouseNameStartsWithAndToWarehouseNameStartsWithAndTransportStatusStartsWith(
			String filter1, String filter2, String filter3, Pageable pageable);

	@Modifying
	@Query(value = "UPDATE transport SET transportStatus=?1 where fromWarehouse_id = ?2 and toWarehouse_id=?3", nativeQuery = true)
	void updateStatus(String transportStatus, Long fromWarehouse_id,
			Long toWarehouse_id) throws Exception;
	
	Page<Transport> findByToWarehouseUsersUserName(String filter, Pageable page);
}
