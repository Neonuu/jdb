package com.zp.jdb.service.serviceimple;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zp.jdb.dao.AdministratorsDao;
import com.zp.jdb.entity.Administrators;
import com.zp.jdb.service.LoginService;


@Service
public class LoginServiceImpl implements LoginService{

	@Resource
	private AdministratorsDao dao;

	public int isSelectLogin(Administrators admin) {
		
		return dao.selectLogin(admin);
	
		}

	public Administrators isSelectUserID(Administrators admin) {
		return dao.selectUserID(admin);
	}

	@Override
	public int selectCountLoginName(Administrators admin) {
		return dao.selectCountLoginName(admin);
	}

	@Override
	public void insertUnOperateAdmin(Administrators admin) {
		dao.insertUnOperateAdmin(admin);
		return;
	}

	@Override
	public int selectPass(Administrators admin) {
		return dao.selectPass(admin);
	}

	@Override
	public Long selectAdminID(Administrators admin) {
		return dao.selectAdminID(admin);
	}

	@Override
	public void updatePass(Administrators admin) {
		dao.updatePass(admin);
		return;
	}

	@Override
	public int selectAdminTrue(Administrators admin) {
		return dao.selectAdminTrue(admin);
	}
}
