package com.zp.jdb.service;

import java.util.List;
import java.util.Map;

import com.zp.jdb.entity.Administrators;
import com.zp.jdb.entity.Commission_detail;
import com.zp.jdb.entity.Organization;
import com.zp.jdb.entity.User_Org;
import com.zp.jdb.entity.User;

public interface TixianService {
	
	public List<Commission_detail> selectTixian(Map<String,Object> map);
	
	public int selectTixianTotal(Map<String,Object> map);
	
	public void updateTixianMark(Map<String,Object> map);
	
	public void updateTixianMarkAndReason(Map<String,Object> map);
	
	public User selectUserByID(Long user_id);
	
	public List<User> selectUserByName(User u);
    
	public Commission_detail selectmoneybyid(Long user_id);
    
}
