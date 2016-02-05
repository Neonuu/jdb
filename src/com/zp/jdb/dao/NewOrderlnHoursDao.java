package com.zp.jdb.dao;

import java.util.List;

import com.zp.jdb.entity.Jiaodanliang;
import com.zp.jdb.entity.Order_inHours;

public interface NewOrderlnHoursDao {
	
	/**
	 * 交单排行
	 * @param ata
	 * @return
	 */
	public List<Jiaodanliang> jiaodanliangPH(Order_inHours ata);
	
	/**
	 * 成交量排行
	 * @param ata
	 * @return
	 */
	public List<Order_inHours> chengjiaoliangPH(Order_inHours ata);
	
	/**
	 * 成交额排行
	 * @param ata
	 * @return
	 */
	public List<Order_inHours> chengjiaoerPH(Order_inHours ata);
	
	/**
	 * 查询交单量总条数
	 * @return
	 */
	public int jiaodanfy();
	
	/**
	 * 查询成交量总条数
	 * @return
	 */
	public int chengjiaofy();
	
	/**
	 * 查询成交额总条数
	 * @return
	 */
	public int moneyfy();

}