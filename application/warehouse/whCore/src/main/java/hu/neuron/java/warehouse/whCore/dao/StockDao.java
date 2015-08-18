package hu.neuron.java.warehouse.whCore.dao;

import hu.neuron.java.warehouse.whCore.entity.Stock;
import hu.neuron.java.warehouse.whCore.entity.Warehouse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface StockDao extends JpaRepository<Stock, Long>{

	
	@Modifying
	@Query ( value = "DELETE FROM stock  WHERE warehouse_id = ?1", nativeQuery=true)
	public void deleteByWarehouseId(Long warehouseId);
}
