package com.zp.jdb.service;

import java.util.List;

import com.zp.jdb.entity.User;

public interface UserOService {
	
	public List<User> selectUserMessage(User us);
	
	public int selectUserCount(User us);
	
	public void updateUserDong(User us);
	
	public void updateUserHui(User us);
	
	public User selectGeren(User us);
	
}
