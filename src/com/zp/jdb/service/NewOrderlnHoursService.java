package com.zp.jdb.service;

import java.util.List;

import com.zp.jdb.entity.Jiaodanliang;
import com.zp.jdb.entity.Order_inHours;


public interface NewOrderlnHoursService {
	
	public List<Jiaodanliang> jiaodanliangPH(Order_inHours ata);
	
	public List<Order_inHours> chengjiaoliangPH(Order_inHours ata);
	
	public List<Order_inHours> chengjiaoerPH(Order_inHours ata);
	
	public int jiaodanfy();
	
	public int chengjiaofy();
	
	public int moneyfy();
	
}
