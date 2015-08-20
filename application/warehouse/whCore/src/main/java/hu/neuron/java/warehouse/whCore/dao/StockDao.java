package hu.neuron.java.warehouse.whCore.dao;

import java.util.List;

import hu.neuron.java.warehouse.whCore.entity.Stock;
import hu.neuron.java.warehouse.whCore.entity.User;
import hu.neuron.java.warehouse.whCore.entity.Warehouse;

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
public interface StockDao extends JpaRepository<Stock, Long>{

	
	@Modifying
	@Query(value = "insert into stock (warehouseId, wareId, piece) VALUES (?1, ?2, ?3)", nativeQuery = true)
	void addWareToWarehouse(String warehouseId, int wareId, int piece) throws Exception;
	
	@Modifying
	@Query (value = "UPDATE stock SET piece = ?3 WHERE warehouse_id = ?1 and ware_id = ?2", nativeQuery=true)
	public void updateStock(Long warehouseId, Long wareId, int piece);

	@Modifying
	@Query ( value = "DELETE FROM stock  WHERE warehouse_id = ?1", nativeQuery=true)
	public void deleteByWarehouseId(Long warehouseId);
	
	@Query("select u from Stock u where u.warehouse.id=?1 and u.ware.id=?2")
	Stock findStockByWarehouseIdandWareId(Long warehouseId, Long wareId) throws Exception;
	
	Page<Stock> findByWarehouseStartsWith(String filter, Pageable pageable);

	Page<Stock> findByWareStartsWith(String filter, Pageable pageable);

}
