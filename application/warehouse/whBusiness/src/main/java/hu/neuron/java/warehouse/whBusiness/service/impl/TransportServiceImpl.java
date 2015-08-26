package hu.neuron.java.warehouse.whBusiness.service.impl;

import hu.neuron.java.warehouse.whBusiness.converter.StockConverter;
import hu.neuron.java.warehouse.whBusiness.converter.TransportConverter;
import hu.neuron.java.warehouse.whBusiness.converter.TransportDetailsConverter;
import hu.neuron.java.warehouse.whBusiness.service.TransportServiceLocal;
import hu.neuron.java.warehouse.whBusiness.service.TransportServiceRemote;
import hu.neuron.java.warehouse.whBusiness.vo.StockVO;
import hu.neuron.java.warehouse.whBusiness.vo.TransportDetailsVO;
import hu.neuron.java.warehouse.whBusiness.vo.TransportVO;
import hu.neuron.java.warehouse.whCore.dao.StockDao;
import hu.neuron.java.warehouse.whCore.dao.TransportDao;
import hu.neuron.java.warehouse.whCore.dao.TransportDetailsDao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

@Stateless(mappedName = "TransportService", name = "TransportService")
@Local(TransportServiceLocal.class)
@Remote(TransportServiceRemote.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class TransportServiceImpl implements TransportServiceLocal,
		TransportServiceRemote {

	private static final Logger logger = Logger
			.getLogger(TransportServiceImpl.class);

	@Autowired
	TransportDao transportDao;

	@EJB
	TransportConverter transportConverter;

	@Autowired
	TransportDetailsDao transportDetailsDao;

	@EJB
	TransportDetailsConverter transportDetailsConverter;

	@Autowired
	StockDao stockDao;

	@EJB
	StockConverter stockConverter;

	private StockVO ware;

	@Override
	public void transportItemToWarehouse(TransportVO transportVO,
			TransportDetailsVO detailsVO) {
		ware = new StockVO();
		try {
			// táblák feltöltése
			transportDao.addToTransport(transportVO.getFromWarehouse().getId(),
					transportVO.getToWarehouse().getId(),
					transportVO.getTransportStatus());
			transportDetailsDao.addToTransportDetails(detailsVO.getWare().getId(),
					detailsVO.getPiece(), detailsVO.getTransport().getId());

			// csökkentsük a from piece mezőjét az adott mennyiséggel
			// növeljük a to piece mezőjét az adott mennyiséggel
			int number = transportDao.transportToWarehouse(
					detailsVO.getPiece(), detailsVO.getWare().getId(),
					transportVO.getToWarehouse().getId());
			if (number == 0) {
				transportDao.addTransportToWarehouse(detailsVO.getPiece(),
						detailsVO.getWare().getId(), transportVO
								.getToWarehouse().getId());
			}

			ware = new StockVO();
			ware = stockConverter.toVO(stockDao
					.findStockByWarehouseIdandWareId(transportVO
							.getFromWarehouse().getId(), detailsVO.getWare()
							.getId()));

			if (detailsVO.getPiece() <= ware.getPiece()) {
				int from = transportDao.transportFromWarehouse(detailsVO
						.getPiece(), detailsVO.getWare().getId(), transportVO
						.getFromWarehouse().getId());
				if (from == 0) {
					logger.error("Hiba: nincs ilyen termék kombináció.");
				}
			} else {
				logger.error("Hiba: nincs ennyi termék a kiindulási raktárban.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Long> getids() {
		List<Long> ids = new ArrayList<Long>();
		try {
			ids = transportDetailsDao.findAllTransportid();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ids;
	}

}
