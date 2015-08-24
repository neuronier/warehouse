package hu.neuron.java.warehouse.whBusiness.service.impl;

import java.util.ArrayList;
import java.util.List;

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
					transportVO.getToWarehouseId(), transportVO.getTransportStatus());
			transportDetailsDao.addToTransportDetails(detailsVO.getWareId(),
					detailsVO.getPiece(), detailsVO.getTransportId());

			// csökkentsük a from piece mezőjét az adott mennyiséggel
			// növeljük a to piece mezőjét az adott mennyiséggel
			int number = transportDao.transportToWarehouse(detailsVO.getPiece(),
					detailsVO.getWareId(), transportVO.getToWarehouseId());
			if (number == 0) {
				transportDao.addTransportToWarehouse(detailsVO.getPiece(),
						detailsVO.getWareId(), transportVO.getToWarehouseId());
			}
			transportDao.transportFromWarehouse(detailsVO.getPiece(),
					detailsVO.getWareId(), transportVO.getFromWarehouseId());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Override
	public List<Long> getids() {
		List<Long> ids = new ArrayList<Long>();
		try {
			ids = transportDao.findAllTransportid();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ids;
	}

}
