package com.zp.jdb.service.serviceimple;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zp.jdb.dao.orderDao;
import com.zp.jdb.entity.Auditing_order;
import com.zp.jdb.service.WOrderService;

@Service
@Transactional
public class WOrderServiceImpl implements WOrderService{
	@Resource
	private orderDao dao;
	public List<Auditing_order> Statistics() {
		System.out.println(dao.Statistics());
		return dao.Statistics();
	}

}
