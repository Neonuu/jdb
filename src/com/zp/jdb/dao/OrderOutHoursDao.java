package com.zp.jdb.dao;

import java.util.List;
import java.util.Map;

import com.zp.jdb.entity.Order_inHours;
import com.zp.jdb.entity.Order_outHours;

public interface OrderOutHoursDao {
	
	/**
	 * 条件查询返回结果集
	 * @param map
	 * @return
	 */
	public List<Order_outHours> findAllByLimit(Map<String,Object> map);
	
	/**
	 * 条件查询返回结果条数
	 * @param map
	 * @return
	 */
	public int findAll(Map<String,Object> map);
	
	/**
	 * 依据id查询72小时外订单
	 * @param id
	 * @return
	 */
	public Order_outHours findById(Long id);
	
	/**
	 * 依据id删除72小时外订单
	 * @param id
	 */
	
	public void delOrderOutHoursById(Long id);
	
	/**
	 * 依据id修改72小时外订单的状态为待审核状态（避免重复信审）
	 * @param id
	 */
	public void changeStatusOrderOutHoursById(Long id);
	
	/**
	 * 依据id修改72小时外订单的状态为锁定状态（信审不通过）
	 * @param id
	 */
	public void changeStatusToLockOrderOutHoursById(Long id);
	
	/**
	 * 依据订单号隐藏72小时外订单数据
	 * @param order_number 订单号
	 */
	public void delOrderOutHoursByOrderNumber(String order_number);
	
	/**
	 * 把超过72小时的订单保存到非锁定状态订单表中
	 * @param oo
	 */
	public void insertOrderInHoursOrder(Order_inHours oo);


	
}
