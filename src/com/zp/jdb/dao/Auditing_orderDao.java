package com.zp.jdb.dao;

import java.util.List;
import java.util.Map;

import com.zp.jdb.entity.Auditing_order;
import com.zp.jdb.entity.Order_inHours;

	
	public interface Auditing_orderDao {
	
		
	/**
	 * 根据条件搜索查询数据
	 * @param map
	 * @return
	 */
	public List<Auditing_order> findAllByLimit(Map<String,Object> map);

	/**
	 * 根据条件搜索
	 * @param map
	 * @return
	 */
	public int findAll(Map<String,Object> map);
		
	/**
	 * 根据id查询锁定状态订单表数据
	 * @param id
	 * @return
	 */
	public Auditing_order findById(Long id);
		
	/**
	 * 保存数据
	 * @param ao
	 */
	public void saveAuditOrder(Order_inHours order) throws Exception;
	
	/**
	 * 依据id修改记录
	 * @param id
	 */
	public void updateAuditingOrderById(Auditing_order ao) throws Exception;
	
	/**
	 * 依据id删除记录
	 * @param id
	 * @throws Exception
	 */
	public void delAuditingOrderById(Long id) throws Exception;
	
	
	
}
