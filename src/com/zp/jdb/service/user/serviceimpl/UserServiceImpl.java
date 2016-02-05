package com.zp.jdb.service.user.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zp.jdb.dao.user.UserDao;
import com.zp.jdb.entity.user.Customer;
import com.zp.jdb.entity.user.User;
import com.zp.jdb.entity.user.UserJiaoDanLiangNum;
import com.zp.jdb.service.user.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userdao;

	public void addUser(User user) {
		userdao.addUser(user);
	}

	public List<User> findUser(User user) {
		return userdao.findUser(user);
	}

	public User findUserById(Integer user_id) {
		return userdao.findUserById(user_id);
	}

	public void updataUser(User user) {
		userdao.updataUser(user);
	}

	public void delUser(User user) {
		userdao.updataUser(user);

	}

	public List<Customer> findUser_customer(User user) {
		return userdao.findUser_customer(user);
	}

	public List<UserJiaoDanLiangNum> queryJiaoDanLiang() {
		return userdao.queryJiaoDanLiang();
	}

}
