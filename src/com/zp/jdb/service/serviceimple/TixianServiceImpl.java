package com.zp.jdb.service.serviceimple;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zp.jdb.dao.TixianDao;
import com.zp.jdb.entity.Commission_detail;
import com.zp.jdb.entity.User;
import com.zp.jdb.service.TixianService;



@Service
@Transactional
public class TixianServiceImpl implements TixianService{

	@Resource
	private TixianDao dao;
	 	
	@Transactional
	

	@Override
	public List<Commission_detail> selectTixian(Map<String, Object> map) {
		return dao.selectTixian(map);
	}

	@Override
	public int selectTixianTotal(Map<String, Object> map) {
		return dao.selectTixianTotal(map);
	}

	@Override
	public void updateTixianMark(Map<String, Object> map) {
		dao.updateTixianMark(map);
		
	}

	@Override
	public void updateTixianMarkAndReason(Map<String, Object> map) {
		dao.updateTixianMarkAndReason(map);
		
	}

	@Override
	public User selectUserByID(Long user_id) {
		return dao.selectUserByID(user_id);
	}

	@Override
	public List<User> selectUserByName(User u) {
		return dao.selectUserByName(u);
	}

	@Override
	public Commission_detail selectmoneybyid(Long user_id) {
		return dao.selectmoneybyid(user_id);
	}
	

}
