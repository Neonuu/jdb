package com.zp.jdb.dao;


import java.util.List;

import com.zp.jdb.entity.Administrators;

public interface AdministratorsDao {
	
	/**
	 * 验证登录
	 * @param us
	 * @return
	 */
	public int selectLogin(Administrators admin) ;
	
	/**
	 * 查询登录用户的user_id
	 * @param us
	 * @return
	 */
	public Administrators selectUserID(Administrators admin);
	
	/**
	 * 查询用户信息
	 * @return
	 */
	public List<Administrators> selectUserInfo();
	
	/**
	 * 查询表中用户名是否存在
	 * @param admin
	 * @return
	 */
	public int selectCountLoginName(Administrators admin);
	
	/**
	 * 注册无权限管理账号
	 * @param admin
	 */
	public void insertUnOperateAdmin(Administrators admin);
	
	/**
	 * 根据user_id查询管理员
	 * 
	 * @param user_id
	 * @return
	 */
	public Administrators findById(Long user_id);
	
	/**
	 * 根据登录名查询管理员
	 * 
	 * @param loginName 
	 * @return
	 */
	public Administrators findByLoginName(String loginName);
	
	/**
	 * 根据用户名和电话号码查询管理是否存在。
	 * @param admin
	 * @return
	 */
	public int selectPass(Administrators admin);
	
	/**
	 * 查询需要修改密码的管理员ID
	 * @param admin
	 * @return
	 */
	public Long selectAdminID(Administrators admin);
	
	/**
	 * 修改密码
	 * @param admin
	 */
	public void updatePass(Administrators admin);
	
	/**
	 * 验证找回密码
	 * @param admin
	 * @return
	 */
	public int selectAdminTrue(Administrators admin);

}