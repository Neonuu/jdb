package com.zp.jdb.dao;

import java.util.List;

import com.zp.jdb.entity.User;

public interface UserODao {
	
	/**
	 * 查询普通用户信息
	 * @param us
	 * @return
	 */
	public List<User> selectUserMessage(User us);
	
	/**
	 * 查询普通用户数量
	 * @return
	 */
	public int selectUserCount(User us);
	
	/**
	 * 冻结普通用户
	 * @param us
	 */
	public void updateUserDong(User us);
	
	/**
	 * 恢复冻结普通用户
	 * @param us
	 */
	public void updateUserHui(User us);
	
	/**
	 * 查询个人信息
	 * @param us
	 * @return
	 */
	public User selectGeren(User us);
}