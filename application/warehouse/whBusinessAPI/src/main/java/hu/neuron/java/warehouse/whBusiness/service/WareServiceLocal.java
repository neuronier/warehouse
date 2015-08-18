package hu.neuron.java.warehouse.whBusiness.service;

import hu.neuron.java.warehouse.whBusiness.vo.WareVo;

import java.util.List;

public interface WareServiceLocal {
	
	
public WareVo getWareByName(String role);
	
	
	public  WareVo setUpWares( WareVo vo) throws Exception;
	
	public int getRowNumber();
	
	public List<WareVo> getWares();
	
	public List<WareVo> getWares(int i, int pageSize, String sortField,
			int sortOrder, String filter, String filterColumnName);
	
	public int getRoleCount();
	
	
	public WareVo findWareByName(String wareName);
	

}
