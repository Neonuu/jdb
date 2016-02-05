package com.zp.jdb.dao;

import java.util.List;
import java.util.Map;
import com.zp.jdb.entity.Auditing_order;
import com.zp.jdb.entity.Order_inHours;
import com.zp.jdb.entity.Production;

public interface OrderlnHoursDao {
	
	
	/**
	 * 条件查询返回结果集
	 * @param map
	 * @return
	 */
	public List<Order_inHours> findAllByLimit(Map<String,Object> map);

	/**
	 * 条件查询返回结果条数
	 * @param map
	 * @return
	 */
	public int findAll(Map<String,Object> map);
	
	/**
	 * 依据产品名，身份证号查询status为1的订单
	 * @param or
	 * @return
	 */
	public List<Order_inHours> findOrderByIdCardNumberAndProdect(Order_inHours or);
	
	/**
	 * 根据id查询订单
	 * @param id
	 * @return
	 */
	public Order_inHours findOrderById(Long id);
	
	/**
	 * 依据id查询状态为0的订单（为了补充材料查询写的）
	 * @param id
	 */
	public Order_inHours findOrderByIdAndStatus(Long id);
	
	
	/**
	 * 依据id删除72小时内订单
	 * @param id:订单id
	 */
	public void delOrderById(Long id) throws Exception;
	
	/**
	 * 改变订单状态
	 * @throws Exception
	 */
	public void changOrderStatus(Order_inHours order) throws Exception;
	
	/**
	 * 保存数据
	 * @param ao
	 * @throws Exception
	 */
	public void addOrder(Auditing_order ao) throws Exception;
	
	
	public Production selectByID_Name(Production pro) throws Exception;
	
	
	
}
