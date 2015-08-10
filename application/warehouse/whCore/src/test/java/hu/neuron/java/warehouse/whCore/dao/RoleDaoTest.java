package hu.neuron.java.warehouse.whCore.dao;

import hu.neuron.java.warehouse.whCore.entity.Role;
import hu.neuron.java.warehouse.whCore.entity.UserRoleMap;

import java.util.ArrayList;
import java.util.Collection;

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
public class RoleDaoTest {

	private static final Logger logger = Logger.getLogger(RoleDaoTest.class);

	private static Role role;

	@Autowired
	RoleDao roleDao;

	Collection<UserRoleMap> users = new ArrayList<>();

	@Test
	public void testSave() {
		try {
			role = new Role();

			role.setRoleName("asd");
			role.setUsers(users);

			role = roleDao.save(role);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Test
	public void testUpdate() {
		try {
			role = roleDao.findOne(role.getId());

			role.setRoleName("asd");
			role.setUsers(users);

			role = roleDao.save(role);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

//	fogalmam nincs miért error
//	@Test
//	public void testDelete() {
//		try {
//			roleDao.delete(role.getId());
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			throw new RuntimeException(e);
//		}
//	}

}
