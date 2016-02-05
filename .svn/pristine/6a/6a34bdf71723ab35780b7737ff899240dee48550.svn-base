package com.zp.jdb.dao.user;

import java.util.List;

import com.zp.jdb.entity.user.Customer;
import com.zp.jdb.entity.user.User;
import com.zp.jdb.entity.user.UserJiaoDanLiangNum;

/**
 * �û��־ò�����ӿ� base����
 * 
 * @author acer
 * 
 */
public interface UserDao {
	/**
	 * �������û�
	 * 
	 * @param user
	 * 
	 */
	public void addUser(User user);

	/**
	 * ��̬��ѯ�û�
	 * 
	 * @param user
	 *            ����Ҫ��ѯ��������װ��һ���û�User����
	 * @return ��ѯ�������û�List����
	 */
	public List<User> findUser(User user);
	
	/**
	 * ����û�id��ѯ�û�
	 * @param id
	 * @return
	 */
	public User findUserById(Integer user_id);

	/**
	 * ��̬�����û�
	 * 
	 * @param user
	 *            ����Ҫ���µ�������װ��һ���û�User���󣬱���Ҫ��װ�绰����
	 * 
	 */
	public void updataUser(User user);

	/**
	 * ɾ���û�
	 * 
	 * @param phoneNumber
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
	
	
	// ��ѯ�ɽ�������
	// ��ѯ�ɽ�������
	/**
	 * 依据电话号查询用户id
	 * @param phoneNumber
	 * @return
	 */
	public Long findByPhoneNumber(String phoneNumber);
}
