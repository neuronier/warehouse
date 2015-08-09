package hu.neuron.java.warehouse.whCore.dao;

import hu.neuron.java.warehouse.whCore.entity.Warehouse;

import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-test-core.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class WarehouseDaoTest {

	private static final Logger logger = Logger
			.getLogger(WarehouseDaoTest.class);

	private static Warehouse warehouse;

	@Autowired
	WarehouseDao warehouseDao;

	@Test
	public void test1Save() {

		try {
			warehouse = new Warehouse();

			warehouse.setAddress("sd");
			warehouse.setAddressNumber(12);
			warehouse.setCity("vbcvbcv");
			warehouse.setManagerId(2l);
			warehouse.setName("naeyxc");
			warehouse.setWarehouseId(1l);
			warehouse.setZipCode(1234);

			warehouse = warehouseDao.save(warehouse);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}

	}

	@Test
	public void test2Update() {
		try {
			warehouse = warehouseDao.findOne(warehouse.getId());

			warehouse.setAddress("Böszörményi út");
			warehouse.setAddressNumber(35);
			warehouse.setCity("Debrecen");
			warehouse.setManagerId(2l);
			warehouse.setName("Központ");
			warehouse.setWarehouseId(1l);
			warehouse.setZipCode(4321);

			warehouse = warehouseDao.save(warehouse);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Test
	public void test3Delete() {
		try {
			warehouseDao.delete(warehouse.getId());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}
}
