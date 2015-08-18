package hu.neuron.java.warehouse.whCore.dao;
import hu.neuron.java.warehouse.whCore.entity.Ware;
import hu.neuron.java.warehouse.whCore.entity.Warehouse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface WareDao extends JpaRepository<Ware, Long> {

	Ware findByWareName(@Param("Name") String name) throws Exception;

	Page<Ware> findByWareNameStartsWith(String filter,Pageable pageable);
	
	@Query("select w from Ware w where w.wareName=?1")	
	Ware findWareByName(String wareName) throws Exception;
	
//	@Modifying
//	@Query(value = "insert into user_ware_sw (ware_id) VALUES (?2)", nativeQuery = true)
//	void addUserToWarehouse(Long userId, Long wareId) throws Exception;
	
}
