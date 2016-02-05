package com.zp.jdb.service;

import java.util.List;
import java.util.Map;

public interface CommissionDetailService {
	
	/**
	 * 条件查询返回结果集
	 * @param map
	 * @return
	 */
    public List<Map<String,Object>> isFindAllByLimit(Map<String,Object> map);
	
    /**
	 * 查询有多少条数据
	 * @return
	 */
	public int isFindAll(Map<String,Object> map);
	
	/**
	 * 条件查询返回结果集
	 * @param map
	 * @return
	 */
    public List<Map<String,Object>> isFindAllTiXianByLimit(Map<String,Object> map);
	
    /**
	 * 查询有多少条数据
	 * @return
	 */
	public int isFindAllTiXian(Map<String,Object> map);
	
	
	/**
	 * 当点击（提现申请）返款成功按钮时把状态改成“提现成功”
	 * @param id
	 */
	public void updateSuccessTiXianById(Long id,Long user_id) throws Exception;


}
