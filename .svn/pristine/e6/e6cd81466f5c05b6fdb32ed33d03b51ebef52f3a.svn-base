package com.zp.jdb.service.serviceimple;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zp.jdb.dao.CarInformationDao;
import com.zp.jdb.dao.HouseInformationDao;
import com.zp.jdb.dao.OrderlnHoursDao;
import com.zp.jdb.entity.B_Brand;
import com.zp.jdb.entity.Brand;
import com.zp.jdb.entity.Car;
import com.zp.jdb.entity.CustomerO;
import com.zp.jdb.entity.Img_forcar;
import com.zp.jdb.entity.Order_inHours;
import com.zp.jdb.entity.S_Series;
import com.zp.jdb.entity.Series;
import com.zp.jdb.service.CarInformationService;
@Service
@Transactional
public class CarInformationServiceImpl implements CarInformationService{
	@Resource
	private CarInformationDao dao;
	@Resource
	private OrderlnHoursDao inhourdao;
	@Resource
	private HouseInformationDao housedao;

	public void isinsertCarInfo(Car c) {
		dao.insertCarInfo(c);
		return;
		
	}

	public void isupdateStatus(Long id) {
		dao.updateStatus(id);
		return;
		
	}
    
	public Order_inHours findOrderByIdAndStatus(Long id) {
		 return inhourdao.findOrderByIdAndStatus(id);
	
	}

	public CustomerO findUser_id(String idCard) {
		return housedao.findUser_id(idCard);
	}

	public List<B_Brand> findBrand() {
		return dao.findBrand();
	}

	public List<S_Series> findSeries(int bid) {
		return dao.findSeries(bid);
	}

	@Override
	public List<B_Brand> findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void insertCarImg(Img_forcar car) {
		dao.insertCarImg(car);
		
	}

	@Override
	public void addname(String BName) {
		dao.addname(BName);
	}

	@Override
	public void addxilie(Series s) {
		dao.addxilie(s);
	}

}
