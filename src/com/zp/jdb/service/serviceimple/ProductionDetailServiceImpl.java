package com.zp.jdb.service.serviceimple;

import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zp.jdb.dao.ProductionDetailDao;
import com.zp.jdb.entity.ProductionDetail;
import com.zp.jdb.service.ProductionDetailService;


@Service
@Transactional
public class ProductionDetailServiceImpl implements  ProductionDetailService{

	@Resource
	private ProductionDetailDao dao;
	
	@Transactional
	public ProductionDetail selectProductionDetailByID(int proId) {
		ProductionDetail pd = dao.selectProductionDetailByID(proId);
		return pd;
	}

	public void updateProductionDetail(Map<String, Object> map) {
		dao.updateProductionDetail(map);
		return;
		
	}

	@Override
	public int countProductionDetailById(int proId) {
		int i = dao.countProductionDetailById(proId);
		return i;
	}

	@Override
	public void insertProductionDetail(Map<String, Object> map) {
		dao.insertProductionDetail(map);
		return;
		
	}

}
