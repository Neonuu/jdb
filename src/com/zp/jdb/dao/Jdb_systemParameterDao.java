package com.zp.jdb.dao;

import com.zp.jdb.entity.Jdb_systemParam;

public interface Jdb_systemParameterDao {

	/**
	 * 添加系统参数数据
	 * @param sp
	 */
	public void addSystemParam(Jdb_systemParam sp);
	
	
	/**
	 * 更新系统参数
	 * @param sp
	 */
	public void updateSystemParam(Jdb_systemParam sp);
	
	
	/**
	 * 查询系统参数
	 * @return
	 */
	public Jdb_systemParam findById();
}
