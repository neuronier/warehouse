package hu.neuron.java.warehouse.whCore.dao;

import hu.neuron.java.warehouse.whCore.entity.Warehouse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface WarehouseDao extends JpaRepository<Warehouse, Long>{
		
	@Modifying
	@Query(value = "insert into user_warehouse_sw (warehouseId, userId) VALUES (?1, ?2)", nativeQuery = true)
	void addUserToWarehouse(Long warehouseId, Long userId) throws Exception;
}
