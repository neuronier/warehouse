package hu.neuron.java.warehouse.whBusiness.service.impl;

import hu.neuron.java.warehouse.whBusiness.converter.RoleConverter;
import hu.neuron.java.warehouse.whBusiness.converter.UserConverter;
import hu.neuron.java.warehouse.whBusiness.service.AdminServiceRemote;
import hu.neuron.java.warehouse.whBusiness.vo.RoleVO;
import hu.neuron.java.warehouse.whBusiness.vo.UserVO;
import hu.neuron.java.warehouse.whCore.dao.RoleDao;
import hu.neuron.java.warehouse.whCore.dao.UserDao;
import hu.neuron.java.warehouse.whCore.entity.User;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

@Stateless(mappedName = "AdminService", name = "AdminService")
@Remote(AdminServiceRemote.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class AdminServiceImpl implements AdminServiceRemote, Serializable {
	private static final long serialVersionUID = 1L;

	// private static final Logger logger = Logger
	// .getLogger(AdminServiceImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	UserDao userDao;

	@EJB
	UserConverter userConverter;

	@Autowired
	RoleDao roleDao;

	@EJB
	RoleConverter roleConverter;

	@Override
	public UserVO getUserByName(String userName) {
		UserVO userVO = null;
		try {
			userVO = userConverter.toVO(userDao.findUserByName(userName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userVO;
	}

	@Override
	public UserVO setUpUsers(UserVO userVO) throws Exception {
		return null;
	}

	@Override
	public int getRowNumber() {
		return (int) userDao.count();
	}

	@Override
	public List<UserVO> getUsers() {
		return userConverter.toVO(userDao.findAll());

	}

	@Override
	public List<RoleVO> getRoles() {
		return roleConverter.toVO(roleDao.findAll());
	}

	@Override
	public List<UserVO> getUsers(int i, int pageSize, String sortField, int sortOrder,
			String filter, String filterColumnName) {
		Direction dir = sortOrder == 1 ? Sort.Direction.ASC : Sort.Direction.DESC;
		PageRequest pageRequest = new PageRequest(i, pageSize, new Sort(
				new org.springframework.data.domain.Sort.Order(dir, sortField)));
		Page<User> entities;

		if (filter.length() != 0 && filterColumnName.equals("userName")) {
			entities = userDao.findByUserNameStartsWith(filter, pageRequest);
		} else if (filter.length() != 0 && filterColumnName.equals("fullName")) {
			entities = userDao.findByFullNameStartsWith(filter, pageRequest);
		} else if (filter.length() != 0 && filterColumnName.equals("email")) {
			entities = userDao.findByEmailStartsWith(filter, pageRequest);
		} else if (filter.length() != 0 && filterColumnName.equals("phoneNumber")) {
			entities = userDao.findByPhoneNumberStartsWith(filter, pageRequest);
		} else {
			entities = userDao.findAll(pageRequest);
		}

		List<UserVO> ret = userConverter.toVO(entities.getContent());

		return ret;
	}

	@Override
	public int getUserCount() {
		return (int) userDao.count();
	}

	@Override
	public Boolean updateUser(UserVO userVO) throws Exception {
		userDao.save(userConverter.toEntity(userVO));
		return true;
	}
}
