package com.zp.jdb.service.serviceimple;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.zp.jdb.dao.CommissionDao;
import com.zp.jdb.dao.user.UserDao;
import com.zp.jdb.entity.Commission;
import com.zp.jdb.entity.user.User;
import com.zp.jdb.service.CommissionService;

@Service
public class CommissionServiceImpl implements CommissionService{

	@Resource
	private CommissionDao commissionDao;
	@Resource
	private UserDao userDao;
	
	public List<Map<String,Object>> isFindAllByLimit(Map<String, Object> map) {
		  String name=(String)map.get("name");
		  if(name==null || name==""){
			  map.put("user_id",null);
		  }else{
			  User parUser=new User();
			  parUser.setPhoneNumber(name);
			  List<User> userList=userDao.findUser(parUser);
	          if(userList==null || userList.size()==0){
	        	 map.put("user_id",-1);
	          }else{
	        	 map.put("user_id", userList.get(0).getUser_id());
	          }
		  }
		  
		  List<Commission> list=commissionDao.findAllByLimit(map);
		  List<Map<String,Object>> resList=new ArrayList<Map<String,Object>>();
		  for(Commission comm:list){
			  Map<String,Object> paramMap=new HashMap<String,Object>();
			  paramMap.put("userId", comm.getUser_id());
			  long user_id=comm.getUser_id();
			  User user=userDao.findUserById((int)user_id);
			  if(user==null){
				  user=new User();
			  }
			  paramMap.put("id", comm.getId());
			  paramMap.put("name", user.getPhoneNumber());
			  paramMap.put("balance",comm.getBalance() );
			  paramMap.put("canUseBalance", comm.getTotal_balance());
			  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			  paramMap.put("co_time", sdf.format(comm.getCo_time()));
			  Long recommemd_id=comm.getRecommemd_id();
			  if(recommemd_id==null){
				  paramMap.put("recommemd","无");
			  }else{
				  long recommemdInt_id=recommemd_id;
				  User recommemdUser=userDao.findUserById((int)recommemdInt_id);
				  if( recommemdUser==null){
					  recommemdUser=new User();
				  }
				  paramMap.put("recommemd", recommemdUser.getUser_name());
			  }
			  resList.add(paramMap);
		  }
		return resList;
	}

	
	public int isFindAll(Map<String, Object> map){
		 String name=(String)map.get("name");
		  if(name==null || name==""){
			  map.put("user_id",null);
		  }else{
			  User parUser=new User();
			  parUser.setPhoneNumber(name);;
			  List<User> userList=userDao.findUser(parUser);
	          if(userList==null || userList.size()==0){
	        	 map.put("user_id",-1); 
	          }else{
	        	 map.put("user_id", userList.get(0).getUser_id());
	          }
		  }
		  
		return commissionDao.findAll(map);
	}


	@Override
	public void updateaddmoney(Commission comm) {
		commissionDao.updateaddmoney(comm);
	}


}