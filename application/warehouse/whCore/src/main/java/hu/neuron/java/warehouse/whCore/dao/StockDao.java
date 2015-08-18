package hu.neuron.java.warehouse.whCore.dao;

import hu.neuron.java.warehouse.whCore.entity.Stock;

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
public interface StockDao extends JpaRepository<Stock, Long> {

	@Modifying
	@Query(value = "insert into stock (warehouseId, wareId, piece) VALUES (?1, ?2, ?3)", nativeQuery = true)
	void addWareToWarehouse(String warehouseId, int wareId, int piece) throws Exception;

	Page<Stock> findByWarehouseStartsWith(String filter, Pageable pageable);

	Page<Stock> findByWareStartsWith(String filter, Pageable pageable);

}
