package hu.neuron.java.warehouse.whBusiness.service.impl;

import hu.neuron.java.warehouse.whBusiness.converter.StockConverter;
import hu.neuron.java.warehouse.whBusiness.converter.TransportConverter;
import hu.neuron.java.warehouse.whBusiness.converter.TransportDetailsConverter;
import hu.neuron.java.warehouse.whBusiness.service.TransportDetailsServiceRemote;
import hu.neuron.java.warehouse.whBusiness.vo.StockVO;
import hu.neuron.java.warehouse.whBusiness.vo.TransportDetailsVO;
import hu.neuron.java.warehouse.whBusiness.vo.TransportVO;
import hu.neuron.java.warehouse.whCore.dao.StockDao;
import hu.neuron.java.warehouse.whCore.dao.TransportDao;
import hu.neuron.java.warehouse.whCore.dao.TransportDetailsDao;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

@Stateless(mappedName = "TransportDetailsService", name = "TransportDetailsService")
@Remote(TransportDetailsServiceRemote.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class TransportDetailsServiceImpl implements TransportDetailsServiceRemote {

	@Autowired
	TransportDetailsDao transportDetailsDao;

	@EJB
	TransportDetailsConverter transportDetailsConverter;

	@Autowired
	StockDao stockDao;

	@EJB
	StockConverter stockConverter;

	@Autowired
	TransportDao transportDao;

	@EJB
	TransportConverter transportConverter;

	@Override
	public List<TransportDetailsVO> findByTransportId(Long id) {

		return transportDetailsConverter.toVO(transportDetailsDao.findByTransportId(id));

	}

	@Override
	public void updateTransportDetails(TransportVO transportVO) throws Exception {

		List<TransportDetailsVO> detailsList = findByTransportId(transportVO.getId());
		
		for (TransportDetailsVO detailsVO : detailsList) {

			StockVO stockVo = stockConverter.toVO(stockDao.findStockByWarehouseIdandWareId(
					detailsVO.getTransport().getFromWarehouse().getId(), detailsVO.getWare()
							.getId()));
			stockVo.setPiece(stockVo.getPiece() - detailsVO.getPiece());
			stockDao.save(stockConverter.toEntity(stockVo));
		}

		for (TransportDetailsVO detailsVO : detailsList) {
			StockVO stockVo = stockConverter
					.toVO(stockDao.findStockByWarehouseIdandWareId(detailsVO.getTransport()
							.getToWarehouse().getId(), detailsVO.getWare().getId()));
			if (stockVo != null) {
				stockVo.setPiece(stockVo.getPiece() + detailsVO.getPiece());
				stockDao.save(stockConverter.toEntity(stockVo));
			}else{
				stockVo=new StockVO();
				stockVo.setWarehouse(transportVO.getToWarehouse());
				stockVo.setWare(detailsVO.getWare());
				stockVo.setPiece(detailsVO.getPiece());
				stockDao.save(stockConverter.toEntity(stockVo));
			}
		}

		transportVO.setTransportStatus("Completed");
		transportDao.save(transportConverter.toEntity(transportVO));

	}

}