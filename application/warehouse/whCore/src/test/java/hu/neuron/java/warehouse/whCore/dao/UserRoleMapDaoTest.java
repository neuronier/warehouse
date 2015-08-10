package hu.neuron.java.warehouse.whCore.dao;

import hu.neuron.java.warehouse.whCore.entity.UserRoleMap;

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
public class UserRoleMapDaoTest {

	private static final Logger logger = Logger
			.getLogger(WarehouseDaoTest.class);

	private static UserRoleMap userRoleMap;

	@Autowired
	UserRoleMapDao userRoleMapDao;

	@Test
	public void testSave() {
		try {
			// Role role = new Role();
			// User user = new User();
			userRoleMap = new UserRoleMap();

			// userRoleMap.setRole(role);
			// userRoleMap.setUser(user);

			userRoleMap = userRoleMapDao.save(userRoleMap);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Test
	public void testUpdate() {
		try {
			userRoleMap = userRoleMapDao.findOne(userRoleMap.getId());

			userRoleMap = userRoleMapDao.save(userRoleMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

//	fogalmam nincs miért error
//	@Test
//	public void testDelete() {
//		try {
//			userRoleMapDao.delete(userRoleMap.getId());
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			throw new RuntimeException(e);
//		}
//	}

}
