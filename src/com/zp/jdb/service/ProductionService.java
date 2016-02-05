package com.zp.jdb.service;


import java.util.List;
import java.util.Map;

import com.zp.jdb.entity.Production;

public interface ProductionService {
	
	public List<Production> selectProductionByOrgId(Map<String,Object> map);
	
	public List<Production> selectProductionsByCondition(Map<String,Object> map);
	
	public void updateProductionIsdelByID(Map<String,Object> map);
	
	public void insertProduction(Map<String,Object> map);
	
	public Production selectProductionByID(int proId);
	
	public void updateProduction(Map<String,Object> map);
	
	public int selectProductionTotal(Map<String,Object> map);
	
	public int countProductionByOrg(int orgId);
	
	public void updateProductionState2ByID(int proId);
	
	public void updateProductionStateByID(Map<String,Object> map);
	
	public Double selectMaxRebate(int orgId);
	
	public List<Production> selectProductionByOrgId3(Map<String,Object> map);
	
	public int selectProductionTotal3(Map<String,Object> map);
	
	public List<Production> selectProductionsByCondition3(Map<String,Object> map);
	
	public void updateProductionIsdelByOrg(Map<String,Object> map);
	

}
