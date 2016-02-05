package com.zp.jdb.service;

import java.util.Map;

import com.zp.jdb.entity.ProductionDetail;

public interface ProductionDetailService {

	public ProductionDetail selectProductionDetailByID(int proId);
	
	public void updateProductionDetail(Map<String,Object> map);
	
	public int countProductionDetailById(int proId);
	
	public void insertProductionDetail(Map<String,Object> map);

}
