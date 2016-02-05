package com.zp.jdb.service.serviceimple;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zp.jdb.dao.AdministratorsDao;
import com.zp.jdb.dao.OrganizationDao;
import com.zp.jdb.entity.Administrators;
import com.zp.jdb.entity.Organization;
import com.zp.jdb.entity.User_Org;
import com.zp.jdb.service.OrganizationService;



@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService{

	@Resource
	private OrganizationDao dao;
	
	@Resource
	private AdministratorsDao adao; 
	
	
	@Transactional
	public void insertOrganization(Map<String, Object> map) {
		dao.insertOrganization(map);
		return;
		
	}
	

	public List<Organization> selectOrganizationsByCondition(Map<String,Object> map) {
		List<Organization> list=dao.selectOrganizationsByCondition(map);
        return list;
	}


	public Organization selectOrganizationByID(int orgId) {
		return dao.selectOrganizationByID(orgId);	
	}

	public void updateOrganizationIsdelByID(Map<String, Object> map) {
		dao.updateOrganizationIsdelByID(map);
		return;
		
	}

	public void updateOrganization(Map<String, Object> map) {
		dao.updateOrganization(map);
		return;
		
	}


	public int selectOrganizationTotal(Map<String, Object> map) {
		int total = dao.selectOrganizationTotal(map);
		return total;
	}


	public void updateOrganizationLogo(Map<String, Object> map) {
		dao.updateOrganizationLogo(map);
		return;
		
	}


	public List<Organization> selectExistOrgList() {
		List<Organization> list = dao.selectExistOrgList();
		return list;
	}


	public String selectOrgByUser(int user_id) {
		String orgId = dao.selectOrgByUser(user_id);
		return orgId;
	}


	@Override
	public void updateOrganizationState2ByID(int orgId) {
		dao.updateOrganizationState2ByID(orgId);
		return;
		
	}


	@Override
	public void updateOrganizationState0ByID(int orgId) {
		dao.updateOrganizationState0ByID(orgId);
		return;
		
	}


	@Override
	public void updateOrganizationRebateByID(Map<String,Object> map) {
		dao.updateOrganizationRebateByID(map);
		return;
		
	}


	@Override
	public void insertUserOrg(Map<String, Object> map) {
		dao.insertUserOrg(map);
		return;
		
	}


	@Override
	public User_Org selectUserOrg(int user_id) {
		User_Org uo = dao.selectUserOrg(user_id);
		return uo;
	}


	@Override
	public void updateUserOrg(Map<String, Object> map) {
		dao.updateUserOrg(map);
		return;
		
	}


	@Override
	public Administrators findById(Long user_id) {
		return adao.findById(user_id);
	}


	@Override
	public Organization selectOrganizationByID2(int orgId) {
		return dao.selectOrganizationByID2(orgId);
	}


	@Override
	public List<Organization> selectOrganizationsByCondition2(Map<String, Object> map) {
		return dao.selectOrganizationsByCondition2(map);
	}


	@Override
	public int selectOrganizationTotal2(Map<String, Object> map) {
		return dao.selectOrganizationTotal2(map);
	}


	@Override
	public List<Organization> selectExistOrgList2(Map<String,Object> map) {
		return dao.selectExistOrgList2(map);
	}
	

}
