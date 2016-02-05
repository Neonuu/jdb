package com.zp.jdb.dao;

import com.zp.jdb.entity.User_cando;

public interface User_candoDao {
	
	/**
	 * 查询登录管理可进行的操作
	 * @param id
	 * @return
	 */
	public User_cando selectCando(long id);

}