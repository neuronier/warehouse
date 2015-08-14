package hu.neuron.java.warehouse.whCore.dao;

import hu.neuron.java.warehouse.whCore.entity.Transport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface TransportDao extends JpaRepository<Transport, Long> {

//	@Modifying
//	@Query(value = "", nativeQuery = true)
//	void transportItemToWarehouse(Long fromWarehouseId, Long toWarehouseId)
//			throws Exception;
}
