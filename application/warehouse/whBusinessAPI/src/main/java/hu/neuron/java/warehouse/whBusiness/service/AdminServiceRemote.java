package hu.neuron.java.warehouse.whBusiness.service;

import hu.neuron.java.warehouse.whBusiness.vo.RoleVO;
import hu.neuron.java.warehouse.whBusiness.vo.UserVO;

import java.util.List;

public interface AdminServiceRemote {

	public UserVO getUserByName(String userName);

	public UserVO setUpUsers(UserVO userVO) throws Exception;

	public int getRowNumber();

	public List<UserVO> getUsers();

	public List<UserVO> getUsers(int i, int pageSize, String sortField, int sortOrder,
			String filter, String filterColumnName);

	public int getUserCount();

	public Boolean updateUser(UserVO userVO) throws Exception;

	public List<RoleVO> getRoles();
}
