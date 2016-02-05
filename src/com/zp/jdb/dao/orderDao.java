package com.zp.jdb.dao;

import java.util.List;

import com.zp.jdb.entity.Auditing_order;

public interface orderDao {
	public List<Auditing_order> Statistics();
	
	/**
	 * 获取信息总页数
	 * @param sd 实体类
	 * @return
	 */
	public int selectMsgTotalCount();
}
