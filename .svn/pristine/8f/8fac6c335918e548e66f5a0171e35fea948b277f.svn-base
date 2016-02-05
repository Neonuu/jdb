package com.zp.jdb.service.serviceimple;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zp.jdb.dao.ProductionDao;
import com.zp.jdb.entity.Production;
import com.zp.jdb.service.ProductionService;


@Service
@Transactional
public class ProductionServiceImpl implements  ProductionService{

	@Resource
	private ProductionDao dao;
	
	@Transactional
	public List<Production> selectProductionByOrgId(Map<String, Object> map) {
		List<Production> list = dao.selectProductionByOrgId(map);
		return list;
	}

	public List<Production> selectProductionsByCondition(Map<String, Object> map) {
		List<Production> list = dao.selectProductionsByCondition(map);
		return list;
	}

	public void updateProductionIsdelByID(Map<String, Object> map) {
		dao.updateProductionIsdelByID(map);
		return;
		
	}

	public void insertProduction(Map<String, Object> map) {
		dao.insertProduction(map);
		return;
		
	}

	public Production selectProductionByID(int proId) {
		Production p = dao.selectProductionByID(proId);
		return p;
	}

	public void updateProduction(Map<String, Object> map) {
		dao.updateProduction(map);
		return;
		
	}

	public int selectProductionTotal(Map<String, Object> map) {
		int total = dao.selectProductionTotal(map);
		return total;
	}

	@Override
	public int countProductionByOrg(int orgId) {
		int i = dao.countProductionByOrg(orgId);
		return i;
	}

	@Override
	public void updateProductionState2ByID(int proId) {
		dao.updateProductionState2ByID(proId);
		return;
		
	}

	@Override
	public void updateProductionStateByID(Map<String, Object> map) {
		dao.updateProductionStateByID(map);
		return;
		
	}

	@Override
	public Double selectMaxRebate(int orgId) {
		Double m = dao.selectMaxRebate(orgId);
		return m;
	}

	@Override
	public List<Production> selectProductionByOrgId3(Map<String, Object> map) {
		return dao.selectProductionByOrgId3(map);
	}

	@Override
	public int selectProductionTotal3(Map<String, Object> map) {
		return dao.selectProductionTotal3(map);
	}

	@Override
	public List<Production> selectProductionsByCondition3(Map<String, Object> map) {
		return dao.selectProductionsByCondition3(map);
	}

	@Override
	public void updateProductionIsdelByOrg(Map<String, Object> map) {
		dao.updateProductionIsdelByOrg(map);
		
	}

	


}
