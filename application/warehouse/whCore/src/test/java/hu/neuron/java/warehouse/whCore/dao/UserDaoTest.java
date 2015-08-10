package hu.neuron.java.warehouse.whCore.dao;

import hu.neuron.java.warehouse.whCore.entity.User;

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
public class UserDaoTest {

	private static final Logger logger = Logger
			.getLogger(UserDaoTest.class);

	private static User user;

	@Autowired
	UserDao userDao;

	@Test
	public void test1Save() {

		try {
			user=new User();
			user.setUserName("asd");
			user.setPassword("asd");
			user.setEnabled(1);
			user.setEmail("asd@asd.asd");
			user.setFullName("asd asd");
			user.setPhoneNumber("543654754754");

			user = userDao.save(user);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}

	}

	@Test
	public void test2Update() {
		try {
			user = userDao.findOne(user.getId());
			user.setUserName("asd");
			user.setPassword("asd");
			user.setEnabled(1);
			user.setEmail("asd@asd.asd");
			user.setFullName("asd das2");
			user.setPhoneNumber("543654754754");

			user = userDao.save(user);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}

	@Test
	public void test3Delete() {
		try {
			userDao.delete(user.getId());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
	}
}
