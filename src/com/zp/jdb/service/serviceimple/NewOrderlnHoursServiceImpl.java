package com.zp.jdb.service.serviceimple;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zp.jdb.dao.NewOrderlnHoursDao;
import com.zp.jdb.entity.Jiaodanliang;
import com.zp.jdb.entity.Order_inHours;
import com.zp.jdb.service.NewOrderlnHoursService;


@Service
@Transactional
public class NewOrderlnHoursServiceImpl implements NewOrderlnHoursService{

	@Resource
	private NewOrderlnHoursDao dao;

	@Override
	public List<Jiaodanliang> jiaodanliangPH(Order_inHours ata) {
		if(ata.getPagenum() == null || ata.getPagenum() <= 0){
			ata.setPagenum(1);
		}
		ata.setStartIndex((ata.getPagenum() - 1) * ata.getPagecount());
		return dao.jiaodanliangPH(ata);
	}

	@Override
	public List<Order_inHours> chengjiaoliangPH(Order_inHours ata) {
		if(ata.getPagenum() == null || ata.getPagenum() <= 0){
			ata.setPagenum(1);
		}
		ata.setStartIndex((ata.getPagenum() - 1) * ata.getPagecount());
		return dao.chengjiaoliangPH(ata);
	}

	@Override
	public List<Order_inHours> chengjiaoerPH(Order_inHours ata) {
		if(ata.getPagenum() == null || ata.getPagenum() <= 0){
			ata.setPagenum(1);
		}
		ata.setStartIndex((ata.getPagenum() - 1) * ata.getPagecount());
		return dao.chengjiaoerPH(ata);
	}

	@Override
	public int chengjiaofy() {
		return dao.chengjiaofy();
	}

	@Override
	public int jiaodanfy() {
		return dao.jiaodanfy();
	}

	@Override
	public int moneyfy() {
		return dao.moneyfy();
	}
	
}
