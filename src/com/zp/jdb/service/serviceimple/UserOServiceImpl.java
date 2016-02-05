package com.zp.jdb.service.serviceimple;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zp.jdb.dao.UserODao;
import com.zp.jdb.entity.User;
import com.zp.jdb.service.UserOService;


@Service
@Transactional
public class UserOServiceImpl implements UserOService{

	@Resource
	private UserODao dao;

	@Override
	public List<User> selectUserMessage(User us) {
		if(us.getPagenum() == null || us.getPagenum() <= 0){
			us.setPagenum(1);
		}
		us.setStartIndex((us.getPagenum() - 1) * us.getPagecount());
		return dao.selectUserMessage(us);
	}

	@Override
	public int selectUserCount(User us) {
		return dao.selectUserCount(us);
	}

	@Override
	public void updateUserDong(User us) {
		dao.updateUserDong(us);
		return;
	}

	@Override
	public void updateUserHui(User us) {
		dao.updateUserHui(us);
		return;
	}

	@Override
	public User selectGeren(User us) {
		return dao.selectGeren(us);
	}
	
}
