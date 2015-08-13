package hu.neuron.java.warehouse.whBusiness.service.impl;

import hu.neuron.java.warehouse.whBusiness.converter.WarehouseConverter;
import hu.neuron.java.warehouse.whBusiness.service.WarehouseServiceLocal;
import hu.neuron.java.warehouse.whBusiness.service.WarehouseServiceRemote;
import hu.neuron.java.warehouse.whBusiness.vo.WarehouseVO;
import hu.neuron.java.warehouse.whCore.dao.WarehouseDao;
import hu.neuron.java.warehouse.whCore.entity.Warehouse;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

@Stateless(mappedName = "WarehouseService", name = "WarehouseService")
@Local(WarehouseServiceLocal.class)
@Remote(WarehouseServiceRemote.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class WarehouseServiceImpl implements WarehouseServiceLocal,WarehouseServiceRemote {

	@Autowired
	WarehouseDao warehouseDao;

	@EJB
	WarehouseConverter warehouseConverter;

	@Override
	public void save(WarehouseVO warehouseVo) {	
		warehouseDao.save(warehouseConverter.toEntity(warehouseVo));
		
	}

	@Override
	public void dalete(WarehouseVO warehouseVo) {
		warehouseDao.delete(warehouseVo.getWarehouseId());

	}

	@Override
	public void update(WarehouseVO warehouseVo) {
		warehouseDao.save(warehouseConverter.toEntity(warehouseVo));

	}

	@Override
	public void addUserToWarehouse(Long warehouseId, Long userId)
			throws Exception {
		warehouseDao.addUserToWarehouse(userId, warehouseId);

	}

	@Override
	public WarehouseVO findWarehouseByName(String name) throws Exception {
		return warehouseConverter.toVO(warehouseDao.findWarehouseByName(name));
	}

	@Override
	public List<WarehouseVO> getWarehouse(int page, int size, String sortField,
			int sortOrder, String filter, String filterColumnName) {

		Direction dir = sortOrder == 1 ? Sort.Direction.ASC
				: Sort.Direction.DESC;
		PageRequest pageRequest = new PageRequest(page, size, new Sort(
				new org.springframework.data.domain.Sort.Order(dir, sortField)));
		Page<Warehouse> entities;

		if (filter.length() != 0 && filterColumnName.equals("name")) {
			entities = warehouseDao.findByNameStartsWith(filter, pageRequest);
		} else {
			entities = warehouseDao.findAll(pageRequest);
		}

		List<WarehouseVO> ret = warehouseConverter.toVO(entities.getContent());

		return ret;

	}


	@Override
	public int getRowNumber() {
		return (int) warehouseDao.count();
	}

}
