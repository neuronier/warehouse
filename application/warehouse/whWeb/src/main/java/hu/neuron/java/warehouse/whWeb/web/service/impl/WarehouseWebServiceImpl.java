package hu.neuron.java.warehouse.whWeb.web.service.impl;

import hu.neuron.java.warehouse.whBusiness.service.WarehouseServiceRemote;
import hu.neuron.java.warehouse.whWeb.web.converter.WarehouseWebConverter;
import hu.neuron.java.warehouse.whWeb.web.service.WarehouseWebService;
import hu.neuron.java.warehouse.whWeb.webVO.WarehouseWebVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebService;

@WebService(endpointInterface = "hu.neuron.java.warehouse.whWeb.web.service.WarehouseWebService")
public class WarehouseWebServiceImpl implements WarehouseWebService {
	
	@EJB(name = "WarehouseService")
	private WarehouseServiceRemote warehouseService;
	
	@EJB
	private WarehouseWebConverter warehouseWebConverter;

	@Override
	public List<WarehouseWebVO> getAllWarehouse() {
		List<WarehouseWebVO> res = new ArrayList<WarehouseWebVO>();
		res = warehouseWebConverter.toWebVo(warehouseService.findAll());
		return res;
	}
}
