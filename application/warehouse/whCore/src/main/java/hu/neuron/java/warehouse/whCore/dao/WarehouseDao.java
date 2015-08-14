package hu.neuron.java.warehouse.whCore.dao;

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
public interface WarehouseDao extends JpaRepository<Warehouse, Long>{
		
	@Modifying
	@Query(value = "insert into user_warehouse_sw (users_id, warehouse_id) VALUES (?1, ?2)", nativeQuery = true)
	void addUserToWarehouse(Long userId, Long warehouseId) throws Exception;
	
//	@Query("select w from Warehouse w where w.name=?1")	
	Warehouse findWarehouseByName(@Param("warehouseName") String name) throws Exception;
	
	Page<Warehouse> findByNameStartsWith(String filter,Pageable pageable);
	
	Page<Warehouse> findByWarehouseIdStartsWith(String filter,Pageable pageable);
	
	Page<Warehouse> findByZipCodeStartsWith(String filter,Pageable pageable);
	
	Page<Warehouse> findByAddressStartsWith(String filter,Pageable pageable);
	
	Page<Warehouse> findByAddressNumberStartsWith(String filter,Pageable pageable);
	
	Page<Warehouse> findByCityStartsWith(String filter,Pageable pageable);

	
}
