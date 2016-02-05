package com.zp.jdb.service;

import java.util.List;
import java.util.Map;

import com.zp.jdb.entity.Jdb_systemParam;

public interface Jdb_systemParamService {
	
	
	
	/**
	 * 查看系统参数
	 * @return
	 */
	public Map<String,Object> isFindById();
	
	
	/**
	 * 修改系统参数
	 * @param sp
	 * @param user_id 管理员id
	 */
	public void isChangSystemParam(Jdb_systemParam sp,Long user_id) throws Exception;
	
	/**
	 * 添加系统参数
	 * @param sp
	 * @param user_id 管理员id
	 */
	public void isAddSystemParam(Jdb_systemParam sp,Long user_id) throws Exception;
	
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
	public int isFindAll();
	
	
	
	
	
}
