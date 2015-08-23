package hu.neuron.java.warehouse.whBusiness.service.impl;

import hu.neuron.java.warehouse.whBusiness.converter.StockConverter;
import hu.neuron.java.warehouse.whBusiness.converter.StockHistoryConverter;
import hu.neuron.java.warehouse.whBusiness.converter.WarehouseConverter;
import hu.neuron.java.warehouse.whBusiness.service.StockReportServiceLocal;
import hu.neuron.java.warehouse.whBusiness.service.StockReportServiceRemote;
import hu.neuron.java.warehouse.whBusiness.vo.StockHistoryVO;
import hu.neuron.java.warehouse.whBusiness.vo.StockVO;
import hu.neuron.java.warehouse.whBusiness.vo.TransportVO;
import hu.neuron.java.warehouse.whBusiness.vo.WarehouseVO;
import hu.neuron.java.warehouse.whCore.dao.StockDao;
import hu.neuron.java.warehouse.whCore.dao.StockHistoryDao;
import hu.neuron.java.warehouse.whCore.dao.WarehouseDao;
import hu.neuron.java.warehouse.whCore.entity.Stock;
import hu.neuron.java.warehouse.whCore.entity.StockHistory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Local;
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

@Stateless(mappedName = "StockReportService", name = "StockReportService")
@Local(StockReportServiceLocal.class)
@Remote(StockReportServiceRemote.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class StockReportServiceImpl implements StockReportServiceRemote,
		StockReportServiceLocal, Serializable {
	private static final long serialVersionUID = 1L;

	// private static final Logger logger = Logger
	// .getLogger(AdminServiceImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	StockDao stockDao;

	@Autowired
	StockHistoryDao stockHistoryDao;

	// @Autowired
	// TransportDao transportDao;

	@Autowired
	WarehouseDao warehouseDao;

	@EJB
	StockConverter stockConverter;

	@EJB
	StockHistoryConverter stockHistoryConverter;

	// @EJB
	// TransportConverter transportConverter;

	@EJB
	WarehouseConverter warehouseConverter;

	@Override
	public WarehouseVO getWarehouseByName(String warehouseName) {
		WarehouseVO warehouseVO = null;
		try {
			warehouseVO = warehouseConverter.toVO(warehouseDao
					.findWarehouseByName(warehouseName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return warehouseVO;
	}

	@Override
	public int getStockRowNumber() {
		return (int) warehouseDao.count();
	}

	@Override
	public int getStockHistoryRowNumber() {
		return (int) stockHistoryDao.count();
	}

	@Override
	public int getTransportRowNumber() {
		// return (int) transportDao.count();
		return 0;
	}

	@Override
	public List<StockVO> getStock() {
		return stockConverter.toVO(stockDao.findAll());
	}

	@Override
	public List<StockHistoryVO> getStockHistory() {
		return stockHistoryConverter.toVO(stockHistoryDao.findAll());
	}

	@Override
	public List<TransportVO> getTransports() {
		// return transportConverter.toVO(transportDao.findAll());
		return null;
	}

	@Override
	public List<WarehouseVO> getWarehouses() {
		return warehouseConverter.toVO(warehouseDao.findAll());
	}

	@Override
	public List<StockVO> getStock(int i, int pageSize, String sortField,
			int sortOrder, String filter, String filterColumnName) {
		Direction dir = sortOrder == 1 ? Sort.Direction.ASC
				: Sort.Direction.DESC;
		PageRequest pageRequest = new PageRequest(i, pageSize, new Sort(
				new org.springframework.data.domain.Sort.Order(dir, sortField)));
		Page<Stock> entities;

		if (filter.length() != 0 && filterColumnName.equals("warehouse")) {
			entities = stockDao.findByWarehouseStartsWith(filter, pageRequest);
		} else if (filter.length() != 0 && filterColumnName.equals("ware")) {
			entities = stockDao.findByWareStartsWith(filter, pageRequest);
		} else {
			entities = stockDao.findAll(pageRequest);
		}

		List<StockVO> ret = stockConverter.toVO(entities.getContent());

		return ret;
	}

	@Override
	public List<StockHistoryVO> getStockHistory(int i, int pageSize,
			String sortField, int sortOrder, String filter,
			String filterColumnName) {
		Direction dir = sortOrder == 1 ? Sort.Direction.ASC
				: Sort.Direction.DESC;
		PageRequest pageRequest = new PageRequest(i, pageSize, new Sort(
				new org.springframework.data.domain.Sort.Order(dir, sortField)));
		Page<StockHistory> entities;

		if (filter.length() != 0 && filterColumnName.equals("warehouse")) {
			entities = stockHistoryDao.findByWarehouseStartsWith(filter,
					pageRequest);
		} else if (filter.length() != 0 && filterColumnName.equals("ware")) {
			entities = stockHistoryDao
					.findByWareStartsWith(filter, pageRequest);
		} else {
			entities = stockHistoryDao.findAll(pageRequest);
		}

		List<StockHistoryVO> ret = stockHistoryConverter.toVO(entities
				.getContent());

		return ret;
	}

	@Override
	public List<TransportVO> getTransports(int i, int pageSize,
			String sortField, int sortOrder, String filter,
			String filterColumnName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getStockCount() {
		return (int) stockDao.count();
	}

	@Override
	public int getStockHistoryCount() {
		return (int) stockHistoryDao.count();
	}

	@Override
	public int getTransportCount() {
		// return (int) transportDao.count();
		return 0;
	}

}
