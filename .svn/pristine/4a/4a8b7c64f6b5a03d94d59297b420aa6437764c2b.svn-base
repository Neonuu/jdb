package com.zp.jdb.service.serviceimple;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zp.jdb.dao.HouseInformationDao;
import com.zp.jdb.dao.OrderlnHoursDao;
import com.zp.jdb.entity.CustomerO;
import com.zp.jdb.entity.Housing;
import com.zp.jdb.entity.Img_forhouse;
import com.zp.jdb.entity.Order_inHours;
import com.zp.jdb.service.HouseInformationService;
@Service
@Transactional
public class HouseInformationServiceImpl implements HouseInformationService {
	@Resource
	private HouseInformationDao dao;
	@Resource
	private OrderlnHoursDao inhourdao;
	
	
	@Transactional
	public void isinsertHouseInfo(Housing h) {
		dao.insertHouseInfo(h);
		return;
		
	}

	public void isupdateStatus(Long id) {
		dao.updateStatus(id);
		return;
		
	}
    
	public Order_inHours findOrderByIdAndStatus(Long id) {
		 return inhourdao.findOrderByIdAndStatus(id);
		
		
		
	}

	@Override
	public CustomerO findUser_id(String idCard) {
		return dao.findUser_id(idCard);
	}

	@Override
	public void insertHouseImg(Img_forhouse house) {
		dao.insertHouseImg(house);
		
	}
	
	

}
