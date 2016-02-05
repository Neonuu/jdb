package com.zp.jdb.service.serviceimple;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zp.jdb.dao.CustomerRecordDao;
import com.zp.jdb.entity.Car;
import com.zp.jdb.entity.Housing;
import com.zp.jdb.entity.Img_forcar;
import com.zp.jdb.entity.Img_forhouse;
import com.zp.jdb.entity.Order_inHours;

import com.zp.jdb.service.CustomerRecordService;



@Service
@Transactional
public class CustomerRecordServiceImpl implements  CustomerRecordService{

	@Resource
	private CustomerRecordDao dao;
	
	@Transactional


	
	@Override
	public int crselectCustomerRecordTotal(Map<String, Object> map) {
		
		return dao.crselectCustomerRecordTotal(map);
	}
	
	
	@Override
	public List<Order_inHours> selectRecordByCondition(Map<String,Object> map) {
		return dao.selectRecordByCondition(map);
	}

	@Override
	public List<Img_forcar> selectCar(Map<String,Object> map) {
		
		return dao.selectCar(map);
	}

	@Override
	public List<Img_forhouse> selectHouse(Map<String,Object> map) {
		
		return dao.selectHouse(map);
	}


	@Override
	public List<Car> selectCarByCondition(Map<String, Object> map) {
		return dao.selectCarByCondition(map);
	}


	@Override
	public int selectCarRecordTotal(Map<String, Object> map) {
		return dao.selectCarRecordTotal(map);
	}


	@Override
	public List<Housing> selectHouseByCondition(Map<String, Object> map) {
		return dao.selectHouseByCondition(map);
	}


	@Override
	public int selectHouseRecordTotal(Map<String, Object> map) {
		return dao.selectHouseRecordTotal(map);
	}


	@Override
	public Order_inHours selectOrder_inhoursByNum(Map<String, Object> map) {
		return dao.selectOrder_inhoursByNum(map);
	}


	@Override
	public Car selectCarByOrder_number(Map<String, Object> map) {
		return dao.selectCarByOrder_number(map);
	}


	@Override
	public Housing selectHouseByOrder_number(Map<String, Object> map) {
		return dao.selectHouseByOrder_number(map);
	}



}
