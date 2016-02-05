package com.zp.jdb.service.serviceimple;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zp.jdb.dao.CustomerODao;
import com.zp.jdb.entity.CustomerO;
import com.zp.jdb.service.CustomerOService;


@Service
@Transactional
public class CustomerOServiceImpl implements CustomerOService{

	@Resource
	private CustomerODao dao;

	@Override
	public List<CustomerO> selectkehu(CustomerO cu) {
		if(cu.getPagenum() == null || cu.getPagenum() <= 0){
			cu.setPagenum(1);
		}
		cu.setStartIndex((cu.getPagenum() - 1) * cu.getPagecount());
		return dao.selectkehu(cu);
	}

	@Override
	public int selectkehufy(CustomerO cu) {
		return dao.selectkehufy(cu);
	}

	@Override
	public CustomerO selectkehuxinxi(CustomerO cu) {
		return dao.selectkehuxinxi(cu);
	}

	@Override
	public void updatekehu(CustomerO cu) {
		dao.updatekehu(cu);
		return;
	}

	@Override
	public List<CustomerO> selectAllKehu(CustomerO c) {
		if(c.getPagenum() == null || c.getPagenum() <= 0){
			c.setPagenum(1);
		}
		c.setStartIndex((c.getPagenum() - 1) * c.getPagecount());
		return dao.selectAllKehu(c);
	}

	@Override
	public int selectAllKehuFY(CustomerO c) {
		return dao.selectAllKehuFY(c);
	}
	
}
