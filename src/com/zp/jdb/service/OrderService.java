package com.zp.jdb.service;

import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;

public interface OrderService {
	
    
    /**
	 * 查询非锁定状态订单（0,3,4,5状态）（order表）
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> isFindOrderAllByLimit(Map<String, Object> map) ;
	public int isFindOrderAll(Map<String,Object> map);

	
	/**
	 * 查询锁定状态订单（1，2状态）（Auditing_order表）
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> isFindAuditingAllByLimit(Map<String, Object> map) ;
	public int isFindAuditingAll(Map<String,Object> map);
	
	
	/**
	 * 将订单状态由0变成1（）
	 * @param map
	 */
	@Transactional
	public void changeOrderZeroToOne(String user_name,Long id) throws Exception;
	
	/**
	 * 将订单由0变成5
	 * @param id
	 */
	@Transactional
	public void changOrderZeroToFive(String user_name,String remarks,Long id) throws Exception;
	
	/**
	 * 将订单由1变成2
	 * @param map
	 */
	@Transactional
	public void changOrderOneToTwo(Long id,String user_name) throws Exception;

	
	/**
	 * 将订单由1变成5
	 * @param id
	 * @throws Exception
	 */
	@Transactional
	public void changOrderOneToFive(String user_name,Long id,String remarks) throws Exception;
	
	/**
	 * 将订单由2变成3
	 * @param id
	 * @throws Exception
	 */
	@Transactional
	public void changeOrderTwoToThree(Long id,String user_name) throws Exception;
	
	/**
	 * 将订单由2变成5
	 * @param id
	 * @throws Exception
	 */
	@Transactional
	public void changeOrderTwoToFive(Long id,String user_name,String remarks) throws Exception;

	
	/**
	 * 将订单由3变成4
	 * @param map
	 */
	
	public void changeOrderThreeToFour(Long id,String user_name,Double money) throws Exception;
	
	
	
	
}
