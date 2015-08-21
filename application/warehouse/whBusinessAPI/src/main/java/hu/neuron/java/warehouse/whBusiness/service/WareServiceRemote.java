package hu.neuron.java.warehouse.whBusiness.service;

import java.util.List;

import hu.neuron.java.warehouse.whBusiness.vo.WareVo;



public interface WareServiceRemote {

	
	
public WareVo findWareByName(String role);
	
	
	public  WareVo setUpWares( WareVo vo) throws Exception;
	
	public int getRowNumber();
	
	public List<WareVo> getWares();
	
	public List<WareVo> getWares(int i, int pageSize, String sortField,
			int sortOrder, String filter, String filterColumnName);
	
	public int getRoleCount();
	
	public void saveWare(WareVo wareVo);
	
	public void removeWare(WareVo selectedWare);
	
	void updateWare(WareVo wareVo);
}
