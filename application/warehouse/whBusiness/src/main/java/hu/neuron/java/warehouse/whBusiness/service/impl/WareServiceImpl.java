package hu.neuron.java.warehouse.whBusiness.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;





import hu.neuron.java.warehouse.whBusiness.converter.WareConverter;
import hu.neuron.java.warehouse.whBusiness.service.WareServiceLocal;
import hu.neuron.java.warehouse.whBusiness.service.WareServiceRemote;
import hu.neuron.java.warehouse.whBusiness.vo.WareVo;
import hu.neuron.java.warehouse.whCore.dao.WareDao;
import hu.neuron.java.warehouse.whCore.entity.Ware;





@Stateless(mappedName = "WareService", name = "WareService")
@Local(WareServiceLocal.class)
@Remote(WareServiceRemote.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class WareServiceImpl implements WareServiceLocal, WareServiceRemote, Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger
			.getLogger(WareServiceImpl.class);
	
	
	@PersistenceContext
	private EntityManager entityManager;
	

	
	@Autowired
	WareDao wareDao;
	
//	@EJB
//	WareServiceLocal wareService;

	@EJB
	WareConverter wareConverter;

	
	
	@Override
	public WareVo findWareByName(String ware) {
		WareVo vo = null;
		try {
			vo = wareConverter.toVO(wareDao.findByWareName(ware));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public WareVo setUpWares(WareVo vo) throws Exception {
		
		return null;
	}

	@Override
	public int getRowNumber() {
		return (int) wareDao.count();
	}

	@Override
	public List<WareVo> getWares() {
		return wareConverter.toVO(wareDao.findAll());
		
	}
	@Override
	public void updateWare(WareVo wareVo) {
		wareDao.save(wareConverter.toEntity(wareVo));

	}

	@Override
	public List<WareVo> getWares(int i, int pageSize, String sortField,
			int sortOrder, String filter, String filterColumnName) {
		Direction dir = sortOrder == 1 ? Sort.Direction.ASC
				: Sort.Direction.DESC;
		PageRequest pageRequest = new PageRequest(i, pageSize, new Sort(
				new org.springframework.data.domain.Sort.Order(dir, sortField)));
		Page<Ware> entities;

		if (filter.length() != 0 && filterColumnName.equals("wareName")) {
			entities = wareDao.findByWareNameStartsWith(filter, pageRequest);
		} else {
			entities = wareDao.findAll(pageRequest);
			
		}

		List<WareVo> ret = wareConverter.toVO(entities.getContent());

		return ret;
	}

	@Override
	public int getRoleCount() {
		return (int) wareDao.count();
	}

	@Override
	public void saveWare(WareVo wareVo) {
		wareDao.save(wareConverter.toEntity(wareVo));
		
	}

	@Override
	public void removeWare(WareVo selectedWare) {
		wareDao.delete(selectedWare.getId());
		
		
		
	}

}
