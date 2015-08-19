package hu.neuron.java.warehouse.whBusiness.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.neuron.java.warehouse.whBusiness.converter.ManagerConverter;
import hu.neuron.java.warehouse.whBusiness.converter.WarehouseConverter;
import hu.neuron.java.warehouse.whBusiness.service.ManagerServiceLocal;
import hu.neuron.java.warehouse.whBusiness.service.WarehouseServiceLocal;
import hu.neuron.java.warehouse.whBusiness.service.WarehouseServiceRemote;
import hu.neuron.java.warehouse.whBusiness.vo.ManagerVO;
import hu.neuron.java.warehouse.whBusiness.vo.WarehouseVO;
import hu.neuron.java.warehouse.whCore.dao.ManagerDao;
import hu.neuron.java.warehouse.whCore.dao.UserDao;
import hu.neuron.java.warehouse.whCore.dao.WarehouseDao;

@Stateless(mappedName = "ManagerService", name = "ManagerService")
@Local(ManagerServiceLocal.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class ManagerServiceImpl implements ManagerServiceLocal {

	@Autowired
	ManagerDao managerDao;

	@Autowired
	WarehouseDao warehouseDao;

	@EJB
	ManagerConverter managerConverter;

	@EJB
	WarehouseConverter warehouseConverter;

	@Override
	public void addManager(ManagerVO manager) {
		managerDao.save(managerConverter.toEntity(manager));

	}

	@Override
	public List<WarehouseVO> getWarehouseByUsderName(String userName) {
		List<ManagerVO> managers = new ArrayList<ManagerVO>();
		try {
			managers = managerConverter.toVO(managerDao
					.findUserByName(userName));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WarehouseVO> warehouses = new ArrayList<WarehouseVO>();
		for (ManagerVO managerVO : managers) {
			try {
				warehouses.add(warehouseConverter.toVO(warehouseDao
						.findWarehouseByWarehouseId(managerVO.getWarehouse())));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return warehouses;
	}

}
