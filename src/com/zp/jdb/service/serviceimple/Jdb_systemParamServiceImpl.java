package com.zp.jdb.service.serviceimple;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zp.jdb.dao.AdministratorsDao;
import com.zp.jdb.dao.Change_system_param_recordDao;
import com.zp.jdb.dao.CommissionDao;
import com.zp.jdb.dao.Jdb_systemParameterDao;
import com.zp.jdb.dao.System_JournalDao;
import com.zp.jdb.dao.user.UserDao;
import com.zp.jdb.entity.Administrators;
import com.zp.jdb.entity.Change_system_param_record;
import com.zp.jdb.entity.Jdb_systemParam;
import com.zp.jdb.entity.System_Journal;
import com.zp.jdb.service.Jdb_systemParamService;




@Service
public class Jdb_systemParamServiceImpl implements Jdb_systemParamService{

	@Resource
	private Jdb_systemParameterDao  jspDao;
	@Resource
	private Change_system_param_recordDao csprDao;
	@Resource
	private UserDao userDao;
	@Resource
	private CommissionDao cDao;
	@Resource
	private AdministratorsDao aDao;
	@Resource
	private System_JournalDao sjDao;
	

	@Transactional
	public void isAddSystemParam(Jdb_systemParam sp,Long user_id) throws Exception{
		Change_system_param_record cspr=new Change_system_param_record();
		cspr.setOld_commission_quota((double)0);
		cspr.setOld_recommend_scale((double)0);
		cspr.setOld_user_scale((double)0);
		cspr.setNew_commission_quota(sp.getCommission_quota());
		cspr.setNew_recommend_scale(sp.getRecommend_scale());
		cspr.setNew_user_scale(sp.getUser_scale());
		cspr.setAdd_time(new Date());
		cspr.setAuditer_id(user_id);
		csprDao.addRecord(cspr);//添加修改记录
		jspDao.addSystemParam(sp);//保存修改的数据
		//插入操作记录日志部分
			System_Journal sj=new System_Journal();
			sj.setDate(new Date());//操作时间
			sj.setModule("佣金管理");//所属模块
			sj.setOperation_content("添加系统参数。客户经理返佣百分比："+sp.getUser_scale()+"%,推广人返佣百分比："+sp.getRecommend_scale()+"%");//操作内容
			sj.setOperator(aDao.findById(user_id).getUser_name());//操作者
			sj.setType("增加");//操作类型
			sjDao.addJournal(sj);
		//修改用户可提现额度
//		List<Commission> list=cDao.findAllCommission();
//		for(int i=0;i<list.size();i++){
//			Commission c=new Commission();
//			c.setCan_use_balance(list.get(i).getBalance().multiply(new BigDecimal(sp.getCommission_quota()/100)));
//			c.setUser_id(list.get(i).getUser_id());
//			cDao.updateUserCanUseBalance(c);
//		}
	}
	
	@Transactional
	public void isChangSystemParam(Jdb_systemParam sp,Long user_id) throws Exception{
		Change_system_param_record cspr=new Change_system_param_record();
	    Jdb_systemParam jsp= jspDao.findById();
	    cspr.setOld_commission_quota(jsp.getCommission_quota());
		cspr.setOld_recommend_scale(jsp.getRecommend_scale());
		cspr.setOld_user_scale(jsp.getUser_scale());
		if(sp.getCommission_quota()!=null){
			cspr.setNew_commission_quota(sp.getCommission_quota());
		}else{
			cspr.setNew_commission_quota(jsp.getCommission_quota());
		}
        if(sp.getRecommend_scale()!=null){
			cspr.setNew_recommend_scale(sp.getRecommend_scale());
		}else{
			cspr.setNew_recommend_scale(jsp.getRecommend_scale());
		}
        if(sp.getUser_scale()!=null){
	        cspr.setNew_user_scale(sp.getUser_scale());
		}else{
			cspr.setNew_user_scale(jsp.getUser_scale());
		}
        cspr.setAdd_time(new Date());
        cspr.setAuditer_id(user_id);
        csprDao.addRecord(cspr);//添加修改记录
	    jspDao.updateSystemParam(sp);//保存修改的数据
	  //插入操作记录日志部分
	  		System_Journal sj=new System_Journal();
	  		sj.setDate(new Date());//操作时间
	  		sj.setModule("佣金管理");//所属模块
	  		sj.setOperation_content("修改系统参数。客户经理返佣百分比："+sp.getUser_scale()+"%,推广人返佣百分比："+sp.getRecommend_scale()+"%");//操作内容
	  		sj.setOperator(aDao.findById(user_id).getLoginName());//操作者
	  		sj.setType("修改");//操作类型
	  		sjDao.addJournal(sj);
	   //修改用户可提现额度
//  		List<Commission> list=cDao.findAllCommission();
//  		for(int i=0;i<list.size();i++){
//  			Commission c=new Commission();
//  			c.setCan_use_balance(list.get(i).getBalance().multiply(new BigDecimal(sp.getCommission_quota()/100)));
//  			c.setUser_id(list.get(i).getUser_id());
//  			cDao.updateUserCanUseBalance(c);
//  		}
	}

	public Map<String,Object> isFindById() {
		Map<String,Object> resMap=new HashMap<String,Object>();
		Jdb_systemParam sp=jspDao.findById();
		if(sp==null){
			resMap.put("status","1");//没有系统参数数据
			resMap.put("user_scale", 0 );
			resMap.put("recommend_scale", 0 );
			resMap.put("commission_quota", 0 );
		}else{
			resMap.put("status", "0");//有系统参数数据
			resMap.put("user_scale", sp.getUser_scale());
			resMap.put("recommend_scale", sp.getRecommend_scale());
			resMap.put("commission_quota", sp.getCommission_quota());
	
		}
		
		return resMap;
	}

	
	
	public int isFindAll() {
//		String name=(String)map.get("name");
//		  if(name==null || name==""){
//			  map.put("user_id",null);
//		  }else{
//			  User parUser=new User();
//			  parUser.setUser_name(name);
//			  List<User> userList=userDao.findUser(parUser);
//	          if(userList==null || userList.size()==0){
//	        	 map.put("user_id",-1); 
//	          }else{
//	        	 map.put("user_id", userList.get(0).getUser_id());
//	          }
//		  }
		return csprDao.findAll();
	}


	

	public List<Map<String, Object>> isFindAllByLimit(Map<String, Object> map) {
//		String name=(String)map.get("name");
//		  if(name==null || name==""){
//			  map.put("user_id",null);
//		  }else{
//			  User parUser=new User();
//			  parUser.setUser_name(name);
//			  List<User> userList=userDao.findUser(parUser);
//	          if(userList==null || userList.size()==0){
//	        	 map.put("user_id",-1); 
//	          }else{
//	        	 map.put("user_id", userList.get(0).getUser_id());
//	          }
//		  }		

		  List<Change_system_param_record> list=csprDao.findAllByLimit(map);
		  List<Map<String,Object>> resList=new ArrayList<Map<String,Object>>();
		  for(Change_system_param_record cspr:list){
			  Map<String,Object> paramMap=new HashMap<String,Object>();
//			  paramMap.put("userId", comm.getUser_id());
//			  long user_id=comm.getUser_id();
//			  User user=userDao.findUserById((int)user_id);
//			  if(user==null){
//				  user=new User();
//			  }
			  paramMap.put("old_user_scale", cspr.getOld_user_scale());
			  paramMap.put("new_user_scale",cspr.getNew_user_scale() );
			  paramMap.put("old_recommend_scale", cspr.getOld_recommend_scale());
			  paramMap.put("new_recommend_scale", cspr.getNew_recommend_scale());
			  paramMap.put("old_commission_quota",cspr.getOld_commission_quota() );
			  paramMap.put("new_commission_quota", cspr.getNew_commission_quota());
			  SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			  paramMap.put("add_time", sdf.format(cspr.getAdd_time()));
			  Long recommemd_id=cspr.getAuditer_id();
			  Administrators admin=aDao.findById(recommemd_id);
			  paramMap.put("auditer_name", admin.getLoginName());
			  resList.add(paramMap);
		  }
	      return resList;
		 
}
}