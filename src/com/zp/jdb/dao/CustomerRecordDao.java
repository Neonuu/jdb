package com.zp.jdb.dao;


import java.util.List;
import java.util.Map;

import com.zp.jdb.entity.Car;
import com.zp.jdb.entity.Housing;
import com.zp.jdb.entity.Img_forcar;
import com.zp.jdb.entity.Img_forhouse;
import com.zp.jdb.entity.Order_inHours;
import com.zp.jdb.entity.ProductionDetail;

public interface CustomerRecordDao {
	
	public int crselectCustomerRecordTotal(Map<String,Object> map); 
	
	public List<Order_inHours> selectRecordByCondition(Map<String,Object> map);
	
	public List<Img_forcar> selectCar(Map<String,Object> map);
	
	public List<Img_forhouse> selectHouse(Map<String,Object> map);
	
	public List<Car> selectCarByCondition(Map<String,Object> map);
	
	public int selectCarRecordTotal(Map<String,Object> map);
	
	public List<Housing> selectHouseByCondition(Map<String,Object> map);
	
	public int selectHouseRecordTotal(Map<String,Object> map);
	
	public Order_inHours selectOrder_inhoursByNum(Map<String,Object> map);
	
	public Car selectCarByOrder_number(Map<String,Object> map);
	
	public Housing selectHouseByOrder_number(Map<String,Object> map);
	

}
