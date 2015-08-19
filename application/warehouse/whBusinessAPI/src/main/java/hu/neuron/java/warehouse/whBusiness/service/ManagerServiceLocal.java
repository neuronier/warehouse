package hu.neuron.java.warehouse.whBusiness.service;

import java.util.List;

import hu.neuron.java.warehouse.whBusiness.vo.ManagerVO;
import hu.neuron.java.warehouse.whBusiness.vo.WarehouseVO;

public interface ManagerServiceLocal {
	
	public void addManager(ManagerVO manager);
	
	public List<WarehouseVO> getWarehouseByUsderName(String userName);
}
