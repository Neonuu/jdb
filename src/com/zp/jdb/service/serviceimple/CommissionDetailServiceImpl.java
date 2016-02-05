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
import com.zp.jdb.dao.CommissionDetailDao;
import com.zp.jdb.dao.FindBankByBankNumberDao;
import com.zp.jdb.dao.System_JournalDao;
import com.zp.jdb.dao.user.UserDao;
import com.zp.jdb.entity.Bank;
import com.zp.jdb.entity.Commission_detail;
import com.zp.jdb.entity.System_Journal;
import com.zp.jdb.entity.user.User;
import com.zp.jdb.service.CommissionDetailService;


@Service
public class CommissionDetailServiceImpl implements CommissionDetailService{
	
	@Resource
	private CommissionDetailDao commissionDetailDao;
    @Resource
	private UserDao userDao;
    @Resource
    private FindBankByBankNumberDao findBankDao;
    @Resource
	private AdministratorsDao aDao;
	@Resource
	private System_JournalDao sjDao;
	
    
	public List<Map<String, Object>> isFindAllByLimit(Map<String, Object> map) {
//		 String name=(String)map.get("name");
//				  if(name==null || name==""){
//					  map.put("user_id",null);
//				  }else{
//					  User parUser=new User();
//					  parUser.setUser_name(name);
//					  List<User> userList=userDao.findUser(parUser);
//			          if(userList==null || userList.size()==0){
//			        	 map.put("user_id",-1); 
//			          }else{
//			        	 map.put("user_id", userList.get(0).getUser_id());
//			          }
//				  }
		  List<Commission_detail> list=commissionDetailDao.findAllByLimit(map);
		  List<Map<String,Object>> resList=new ArrayList<Map<String,Object>>();
		  for(Commission_detail comm:list){
			  Map<String,Object> paramMap=new HashMap<String,Object>();
			  long user_id=comm.getUser_id();
			  User user=userDao.findUserById((int)user_id);
			  if(user==null){
				  user=new User();
			  }
			  paramMap.put("name", user.getPhoneNumber());
			  paramMap.put("change_amount",comm.getChange_amount() );
			  paramMap.put("balance",comm.getBalance() );
			  paramMap.put("state", comm.getState());
			  SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			  paramMap.put("add_time", sdf.format(comm.getAdd_time()));
//			  if(comm.getBank_number()==null){
//				  paramMap.put("bank_number", "未绑定"); 
//			  }else{
//				  paramMap.put("bank_number", comm.getBank_number()); 
//			  }
			  resList.add(paramMap);
		  }
		return resList;
	}

	
	
	public int isFindAll(Map<String, Object> map) {	 
		return commissionDetailDao.findAll(map);
	}
	

	public List<Map<String, Object>> isFindAllTiXianByLimit(Map<String, Object> map) {
//		 String name=(String)map.get("name");
//				  if(name==null || name==""){
//					  map.put("user_id",null);
//				  }else{
//					  User parUser=new User();
//					  parUser.setUser_name(name);
//					  List<User> userList=userDao.findUser(parUser);
//			          if(userList==null || userList.size()==0){
//			        	 map.put("user_id",-1); 
//			          }else{
//			        	 map.put("user_id", userList.get(0).getUser_id());
//			          }
//				  }
		  List<Commission_detail> list=commissionDetailDao.findTiXianAllByLimit(map);
		  List<Map<String,Object>> resList=new ArrayList<Map<String,Object>>();
		  for(Commission_detail comm:list){
			  Map<String,Object> paramMap=new HashMap<String,Object>();
			  paramMap.put("id", comm.getId());
			  long user_id=comm.getUser_id();
			  User user=userDao.findUserById((int)user_id);
			  if(user==null){
				  user=new User();
			  }
			  paramMap.put("name", user.getPhoneNumber());
			  paramMap.put("change_amount",comm.getChange_amount() );
			  paramMap.put("balance",comm.getBalance() );
			  paramMap.put("state", comm.getState());
			  SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			  paramMap.put("add_time", sdf.format(comm.getAdd_time()));
			  Map<String,Object> bankMap=new HashMap<String,Object>();
			  bankMap.put("bank_number", comm.getBank_number());
			  long user_id1=comm.getUser_id();
			  bankMap.put("user_id", (int)user_id1);
			  Bank bank=findBankDao.findBankByBankNumber(bankMap);
			  paramMap.put("true_name", bank.getTrue_name());
			  paramMap.put("bank_name", bank.getBank_name());
			  paramMap.put("bank_number", bank.getBank_number());
			  
//			  if(comm.getBank_number()==null){
//				  paramMap.put("bank_number", "未绑定"); 
//			  }else{
//				  paramMap.put("bank_number", comm.getBank_number()); 
//			  }
			  resList.add(paramMap);
		  }
		return resList;
	}

	
	
	
	public int isFindAllTiXian(Map<String, Object> map) {	 
		return commissionDetailDao.findTiXianAll(map);
	}
	
	/**
	 * 当点击（提现申请）返款成功按钮时把状态改成“提现成功”
	 * @param id
	 */
	@Transactional
	public void updateSuccessTiXianById(Long id,Long user_id) throws Exception{
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("id", id);
		paramMap.put("add_time", new Date());
		commissionDetailDao.updateSuccessTiXianById(paramMap);
		//插入操作记录日志部分
		System_Journal sj=new System_Journal();
		sj.setDate(new Date());//操作时间
		sj.setModule("佣金管理");//所属模块
		sj.setOperation_content("提现申请打款成功。提现金额："+commissionDetailDao.findById(id).getChange_amount()+"元");//操作内容
		sj.setOperator(aDao.findById(user_id).getLoginName());//操作者
		sj.setType("修改");//操作类型
		sjDao.addJournal(sj);
	};
}
