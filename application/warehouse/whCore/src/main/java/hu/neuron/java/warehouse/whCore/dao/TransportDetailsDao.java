package hu.neuron.java.warehouse.whCore.dao;

import hu.neuron.java.warehouse.whCore.entity.Transport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface TransportDetailsDao extends JpaRepository<Transport, Long> {

	@Query(value = "INSERT INTO transport_details (wareId, piece)"
			   + "VALUES (?1, ?2)", nativeQuery = true)
	void addToTransportDetails(Long wareId, int piece) throws Exception;
	
	
}
