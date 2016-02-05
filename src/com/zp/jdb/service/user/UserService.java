package com.zp.jdb.service.user;

import java.util.List;

import com.zp.jdb.entity.user.Customer;
import com.zp.jdb.entity.user.User;
import com.zp.jdb.entity.user.UserJiaoDanLiangNum;

/**
 * ҵ���ӿ�
 * 
 * @author acer
 * 
 */
public interface UserService {
	/**
	 * �������û�
	 * 
	 */
	public void addUser(User user);

	/**
	 * ��̬��ѯ�û�
	 * 
	 */
	public List<User> findUser(User user);
	
	/**
	 * �����û�id��ѯ�û�
	 * @param id
	 * @return
	 */
	public User findUserById(Integer user_id);

	/**
	 * ��̬�����û�
	 * 
	 */
	public void updataUser(User user);

	/**
	 * ɾ���û�
	 * 
	 */
	public void delUser(User user);

	/**
	 * ��ѯ�û������пͻ�
	 * 
	 * @param phoneNumber
	 */
	public List<Customer> findUser_customer(User user);

	/**
	 * ��ѯ����������
	 * 
	 * @return
	 */
	public List<UserJiaoDanLiangNum> queryJiaoDanLiang();
}
