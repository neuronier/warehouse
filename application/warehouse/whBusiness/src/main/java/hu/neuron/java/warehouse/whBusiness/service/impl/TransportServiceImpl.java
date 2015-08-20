package hu.neuron.java.warehouse.whBusiness.service.impl;

import hu.neuron.java.warehouse.whBusiness.converter.TransportConverter;
import hu.neuron.java.warehouse.whBusiness.converter.TransportDetailsConverter;
import hu.neuron.java.warehouse.whBusiness.service.TransportServiceLocal;
import hu.neuron.java.warehouse.whBusiness.service.TransportServiceRemote;
import hu.neuron.java.warehouse.whBusiness.vo.TransportDetailsVO;
import hu.neuron.java.warehouse.whBusiness.vo.TransportVO;
import hu.neuron.java.warehouse.whCore.dao.TransportDao;
import hu.neuron.java.warehouse.whCore.dao.TransportDetailsDao;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

@Stateless(mappedName = "TransportService", name = "TransportService")
@Local(TransportServiceLocal.class)
@Remote(TransportServiceRemote.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class TransportServiceImpl implements TransportServiceLocal,
		TransportServiceRemote {

	@Autowired
	TransportDao transportDao;

	@EJB
	TransportConverter transportConverter;

	@Autowired
	TransportDetailsDao transportDetailsDao;

	@EJB
	TransportDetailsConverter transportDetailsConverter;

	@Override
	public void transportItemToWarehouse(TransportVO transportVO,
			TransportDetailsVO detailsVO) {
		try {
			// táblák feltöltése
			transportDao.addToTransport(transportVO.getFromWarehouseId(),
					transportVO.getToWarehouseId());
			transportDetailsDao.addToTransportDetails(detailsVO.getWareId(),
					detailsVO.getPiece());

			// csökkentsük a from piece mezőjét az adott mennyiséggel
			// növeljük a to piece mezőjét az adott mennyiséggel
			transportDao.transportToWarehouse(detailsVO.getPiece(),
					detailsVO.getWareId(), transportVO.getToWarehouseId());
			transportDao.transportFromWarehouse(detailsVO.getPiece(),
					detailsVO.getWareId(), transportVO.getFromWarehouseId());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
