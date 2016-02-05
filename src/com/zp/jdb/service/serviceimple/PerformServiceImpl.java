package com.zp.jdb.service.serviceimple;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zp.jdb.dao.PerformDao;
import com.zp.jdb.dao.UserLDao;
import com.zp.jdb.entity.Perform_order;
import com.zp.jdb.entity.User;
import com.zp.jdb.service.PerformService;

@Service
@Transactional
public class PerformServiceImpl implements PerformService{
	@Resource
	private PerformDao dao;
	@Resource
	private UserLDao dao1;
	
	public List<Perform_order> isStatistics(Perform_order ao) {
		if(ao.getPagenum() == null || ao.getPagenum() <= 0){
			 ao.setPagenum(1);
			}
		 ao.setStartIndex((ao.getPagenum() - 1) * ao.getPagecount());
		return dao.Statistics(ao);
	}
	 public int isSelectTotalCount(Perform_order ao){
			return dao.SelectTotalCount(ao);
		}

	public List<User> selectUserInfo() {
		return dao1.selectUserInfo();
	}

}
