package hu.neuron.java.warehouse.whCore.dao;

import hu.neuron.java.warehouse.whCore.entity.StockHistory;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface StockHistoryDao extends JpaRepository<StockHistory, Long> {

	Page<StockHistory> findByWarehouseNameStartsWithAndWareWareNameStartsWithAndChangeTimeAfterAndChangeTimeBefore(
			String filter1, String filter2, Date filter3, Date filter4, Pageable pageable);

}
