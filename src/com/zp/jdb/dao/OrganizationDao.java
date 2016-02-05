package com.zp.jdb.dao;

import java.util.List;
import java.util.Map;
import com.zp.jdb.entity.Organization;
import com.zp.jdb.entity.User_Org;



public interface OrganizationDao {
	
	public void insertOrganization(Map<String,Object> map);
	
	public List<Organization> selectOrganizationsByCondition(Map<String,Object> map);
	
    public void updateOrganizationIsdelByID(Map<String,Object> map);
    
    public Organization selectOrganizationByID(int orgId);
    
    public void updateOrganization(Map<String,Object> map);
    
    public int selectOrganizationTotal(Map<String,Object> map);
    
    public void updateOrganizationLogo(Map<String,Object> map);
    
    public List<Organization> selectExistOrgList();
    
    public String selectOrgByUser(int user_id);
    
    public void updateOrganizationState2ByID(int orgId);
    
    public void updateOrganizationState0ByID(int orgId);
    
    public void updateOrganizationRebateByID(Map<String,Object> map);
    
    public void insertUserOrg(Map<String,Object> map);
    
    public User_Org selectUserOrg(int user_id);
    
    public void updateUserOrg(Map<String,Object> map);
    
    public Organization selectOrganizationByID2(int orgId);
    
    public List<Organization> selectOrganizationsByCondition2(Map<String,Object> map);
    
    public int selectOrganizationTotal2(Map<String,Object> map);
    
    public List<Organization> selectExistOrgList2(Map<String,Object> map);
    
    

}
