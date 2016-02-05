package com.zp.jdb.service.user;

import java.util.List;

import com.zp.jdb.entity.user.Customer;
import com.zp.jdb.entity.user.User;
import com.zp.jdb.entity.user.UserJiaoDanLiangNum;

/**
 * 业务层接口
 * 
 * @author acer
 * 
 */
public interface UserService {
	/**
	 * 增加新用户
	 * 
	 */
	public void addUser(User user);

	/**
	 * 动态查询用户
	 * 
	 */
	public List<User> findUser(User user);
	
	/**
	 * 根据用户id查询用户
	 * @param id
	 * @return
	 */
	public User findUserById(Integer user_id);

	/**
	 * 动态更新用户
	 * 
	 */
	public void updataUser(User user);

	/**
	 * 删除用户
	 * 
	 */
	public void delUser(User user);

	/**
	 * 查询用户的所有客户
	 * 
	 * @param phoneNumber
	 */
	public List<Customer> findUser_customer(User user);

	/**
	 * 查询交单量排行
	 * 
	 * @return
	 */
	public List<UserJiaoDanLiangNum> queryJiaoDanLiang();
}
