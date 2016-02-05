package com.zp.jdb.dao;

import java.util.List;
import java.util.Map;

import com.zp.jdb.entity.Commission_detail;

public interface CommissionDetailDao {
	
	/**
	 * 条件查询返回结果集
	 * @param map
	 * @return
	 */
	public List<Commission_detail> findAllByLimit(Map<String, Object> map);

	/**
	 * 查询有多少条数据
	 * @return
	 */
	public int findAll(Map<String, Object> map);
	
	/**
	 * 添加佣金变动记录
	 * @param cd
	 */
	public void addCommissionChangeRecord(Commission_detail cd);
	
	
	/**
	 * 条件查询返回结果集
	 * @param map
	 * @return
	 */
	public List<Commission_detail> findTiXianAllByLimit(Map<String, Object> map);

	/**
	 * 查询有多少条数据
	 * @return
	 */
	public int findTiXianAll(Map<String, Object> map);
	
	
	/**
	 * 当点击（提现申请）返款成功按钮时把状态改成“提现成功”
	 * @param id
	 */
	public void updateSuccessTiXianById(Map<String,Object> paramMap);
	
    public Commission_detail findById(Long id);
	

}
