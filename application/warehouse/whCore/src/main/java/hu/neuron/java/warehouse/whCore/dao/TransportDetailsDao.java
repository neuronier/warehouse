package hu.neuron.java.warehouse.whCore.dao;

import hu.neuron.java.warehouse.whCore.entity.TransportDetails;

import java.util.List;

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
public interface TransportDetailsDao extends JpaRepository<TransportDetails, Long> {

	@Modifying
	@Query(value = "INSERT INTO transportdetails (ware_id, piece, transport_id)"
			+ "VALUES (?1, ?2, ?3)", nativeQuery = true)
	void addToTransportDetails(Long wareId, int piece, Long transportId)
			throws Exception;

	@Modifying
	@Query(value = "SELECT transportId from transportdetails", nativeQuery = true)
	List<Long> findAllTransportid() throws Exception;
	
	public List<TransportDetails> findByTransportId(Long id);

	Page<TransportDetails> findByTransportIdAndWareWareNameStartsWith(Long filter1, String filter2, Pageable pageable);
	
//	Page<TransportDetails> findByWarehouseUsersUserName(Long filter, Pageable page);
	
}
