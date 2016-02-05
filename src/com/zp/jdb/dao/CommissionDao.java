package com.zp.jdb.dao;

import java.util.List;
import java.util.Map;

import com.zp.jdb.entity.Commission;

public interface CommissionDao {

	/**
	 * 条件查询返回结果集
	 * @param map
	 * @return
	 */
	public List<Commission> findAllByLimit(Map<String,Object> map);
	
	/**
	 * 查询有多少条数据
	 * @return
	 */
	public int findAll(Map<String, Object> map);
	
	/**
	 * 根据用户id查询出用户佣金情况
	 * @param comm
	 * @return
	 */
	public Commission findById(Long user_commission_id);
	
	/**
	 * 查询所有用户佣金信息
	 */
	public List<Commission> findAllCommission();
	
	
	/**
	 * 根据用户id修改对应的用户的可提现佣金额度
	 * @param comm  包含用户id和修改后的用户的可提现佣金额度
	 */
	public void updateUserCanUseBalance(Commission comm);
	
	/**
	 * 根据用户id修改对应的用户的佣金余额
	 * @param comm 包含用户id和变动后的佣金余额
	 */
	public void updateUserBalance(Commission comm);
	
	public void updateaddmoney(Commission comm);
	
}
