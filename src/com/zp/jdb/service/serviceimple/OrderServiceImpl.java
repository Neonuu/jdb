package com.zp.jdb.service.serviceimple;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zp.jdb.dao.Auditing_orderDao;
import com.zp.jdb.dao.Auditing_order_recordDao;
import com.zp.jdb.dao.CommissionDao;
import com.zp.jdb.dao.CommissionDetailDao;
import com.zp.jdb.dao.Jdb_systemParameterDao;
import com.zp.jdb.dao.OrderlnHoursDao;
import com.zp.jdb.dao.System_JournalDao;
import com.zp.jdb.entity.Auditing_order;
import com.zp.jdb.entity.Commission;
import com.zp.jdb.entity.Commission_detail;
import com.zp.jdb.entity.Jdb_systemParam;
import com.zp.jdb.entity.Order_inHours;
import com.zp.jdb.entity.Production;
import com.zp.jdb.entity.System_Journal;
import com.zp.jdb.service.OrderService;
import com.zp.jdb.sms.Send_sms;



@Service
public class OrderServiceImpl implements OrderService{
	
	@Resource
	private OrderlnHoursDao  orderlnHoursDao;
    @Resource
    private CommissionDetailDao  commissionDetailDao;
    @Resource
    private CommissionDao  commissionDao;
    @Resource
    private Auditing_order_recordDao aorDao;
    @Resource
    private Jdb_systemParameterDao  jspDao;
    @Resource
	private System_JournalDao sjDao;
    @Resource
    private  Auditing_orderDao auditingOrderDao;
    
    Send_sms ss = new Send_sms("com.mysql.jdbc.Driver", "jdbc:mysql://123.56.98.210:3306/OrderDatabase?characterEncoding=utf8", "pitc_dev", "pitc123", "【交单宝】", "4008-344-666", "null", "4bcaedc85db3990c505009b1085452a8");
    //Send_sms ss = new Send_sms(driver, url, user, pwd, company_name, company_phone, company_callback, apikey)

    
    /**
	 * 查询非锁定状态订单（0,3,4,5状态）（order表）
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> isFindOrderAllByLimit(Map<String, Object> map) {
		  List<Order_inHours> inHoursList=orderlnHoursDao.findAllByLimit(map);
		  List<Map<String,Object>> resList=new ArrayList<Map<String,Object>>();
		  for(Order_inHours oi:inHoursList){
			  Map<String,Object> paramMap=new HashMap<String,Object>();
			  paramMap.put("ID", oi.getId());
			  paramMap.put("user_id", oi.getUser_id());
			  paramMap.put("name", oi.getUser_phoneNumber());//客户经理电话
			  paramMap.put("order_number",oi.getOrder_number());
			  paramMap.put("user_identity", oi.getUser_identity());
			  paramMap.put("product", oi.getProduct());
			  paramMap.put("true_name",oi.getTrue_name());
			  paramMap.put("user_idCardNumber", oi.getUser_idCardNumber());
			  paramMap.put("tel_number", oi.getTel_number());
			  paramMap.put("province", oi.getProvince());
			  paramMap.put("city", oi.getCity());
			  paramMap.put("auditer_name", oi.getAuditer_name());
			  SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			  paramMap.put("add_time", sdf.format(oi.getAdd_time()));
			  paramMap.put("remarks", "\"原因："+oi.getRemarks()+"\"");
			  paramMap.put("status_cailiao", oi.getStatus_cailiao());
			  resList.add(paramMap);
		  }
		return resList;
	}		
	public int isFindOrderAll(Map<String,Object> map){
		return orderlnHoursDao.findAll(map);
	}

	
	/**
	 * 查询锁定状态订单（1，2状态）（Auditing_order表）
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> isFindAuditingAllByLimit(Map<String, Object> map) {
		List<Auditing_order> auditingList=auditingOrderDao.findAllByLimit(map);
		  List<Map<String,Object>> resList=new ArrayList<Map<String,Object>>();
		  for(Auditing_order oi:auditingList){
			  Map<String,Object> paramMap=new HashMap<String,Object>();
			  paramMap.put("ID", oi.getId());
			  paramMap.put("name", oi.getUser_phoneNumber());//客户经理电话
			  paramMap.put("order_number", oi.getOrder_number());
			  paramMap.put("user_identity", oi.getUser_identity());
			  paramMap.put("product", oi.getProduct());
			  paramMap.put("true_name",oi.getTrue_name());
			  paramMap.put("user_idCardNumber", oi.getUser_idCardNumber());
			  paramMap.put("tel_number", oi.getTel_number());
			  paramMap.put("province", oi.getProvince());
			  paramMap.put("city", oi.getCity());
			  paramMap.put("auditer_name", oi.getAuditer_name());
			  SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			  paramMap.put("add_time", sdf.format(oi.getAdd_time()));
			  resList.add(paramMap);
		  }
		return resList;
	}	
	public int isFindAuditingAll(Map<String,Object> map){
		return auditingOrderDao.findAll(map);
	}
	
	
	/**
	 * 将订单状态由0变成1（）
	 * @param map
	 */
	@Transactional
	public void changeOrderZeroToOne(String user_name,Long id) throws Exception{
		Order_inHours order=orderlnHoursDao.findOrderById(id);
		order.setStatus(1);
		order.setAuditer_name(user_name);
		order.setAdd_time(new Date());
		auditingOrderDao.saveAuditOrder(order);//保存到锁定表里
		orderlnHoursDao.delOrderById(id);//删除原数据
		List<Order_inHours> list=orderlnHoursDao.findOrderByIdCardNumberAndProdect(order);
		for(Order_inHours o:list){//关闭其他针对该用户的订单
			Order_inHours or=new Order_inHours();
			or.setId(o.getId());
			or.setStatus(5);
			or.setRemarks("因其他客户经理已提交完整材料，订单被关闭");
			or.setAdd_time(new Date());
			or.setAuditer_name(user_name);
			orderlnHoursDao.changOrderStatus(or);
//发送短信通知
			SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-HH:mm:ss");   
			System.out.println("客户姓名:"+o.getTrue_name().toString());
			ss.submit_fail(o.getUser_phoneNumber(),sdf.format(new Date()) , o.getTrue_name().toString());		
//短信发送完毕
			System_Journal sj=new System_Journal();
			sj.setDate(new Date());//操作时间
			sj.setModule("订单管理");//所属模块
			sj.setOperation_content("因其他客户经理已提交完整材料，订单被关闭，订单号："+o.getOrder_number());//操作内容
			sj.setOperator(user_name);//操作者
			sj.setType("修改");//操作类型
			sjDao.addJournal(sj);
		}
		//添加系统日志
		System_Journal sj=new System_Journal();
		sj.setDate(new Date());//操作时间
		sj.setModule("订单管理");//所属模块
		sj.setOperation_content("订单由补充材料状态修改为订单审批状态，订单号："+order.getOrder_number());//操作内容
		sj.setOperator(user_name);//操作者
		sj.setType("修改");//操作类型
		sjDao.addJournal(sj);
	};
	
	/**
	 * 将订单由0变成5=====================================
	 * @param id
	 */
	@Transactional
	public void changOrderZeroToFive(String user_name,String remarks,Long id) throws Exception{
		Order_inHours orid=orderlnHoursDao.findOrderById(id);
        Order_inHours order=new Order_inHours();
        order.setOrder_number(orid.getOrder_number());
		order.setStatus(5);
		order.setAuditer_name(user_name);
		order.setAdd_time(new Date());
		order.setRemarks(remarks);
		order.setId(id);
		orderlnHoursDao.changOrderStatus(order);
		//添加系统日志记录
		System_Journal sj=new System_Journal();
		sj.setDate(new Date());//操作时间
		sj.setModule("订单管理");//所属模块
		sj.setOperation_content("订单由补充材料状态修改为订单关闭状态，订单号："+order.getOrder_number());//操作内容
		sj.setOperator(user_name);//操作者
		sj.setType("修改");//操作类型
		sjDao.addJournal(sj);
	}
	
	/**
	 * 将订单由1变成2
	 * @param map
	 */
	@Transactional
	public void changOrderOneToTwo(Long id,String user_name) throws Exception{
		
		Auditing_order ao=new Auditing_order();
		ao.setAdd_time(new Date());
		ao.setAuditer_name(user_name);
		ao.setStatus(2);
		ao.setId(id);
		auditingOrderDao.updateAuditingOrderById(ao);
		//插入系统日志
		System_Journal sj=new System_Journal();
		sj.setDate(new Date());//操作时间
		sj.setModule("订单管理");//所属模块
		sj.setOperation_content("订单由订单审批状态修改为成功批款状态，订单号："+auditingOrderDao.findById(id).getOrder_number());//操作内容
		sj.setOperator(user_name);//操作者
		sj.setType("修改");//操作类型
		sjDao.addJournal(sj);
	}

	
	/**
	 * 将订单由1变成5
	 * @param id
	 * @throws Exception
	 */
	@Transactional
	public void changOrderOneToFive(String user_name,Long id,String remarks) throws Exception{
		Auditing_order ao=auditingOrderDao.findById(id);
		ao.setRemarks(remarks);
		ao.setAdd_time(new Date());
		ao.setAuditer_name(user_name);
		ao.setStatus(5);
		orderlnHoursDao.addOrder(ao);
		auditingOrderDao.delAuditingOrderById(ao.getId());
		//插入日志记录
		System_Journal sj=new System_Journal();
		sj.setDate(new Date());//操作时间
		sj.setModule("订单管理");//所属模块
		sj.setOperation_content("订单由订单审批状态修改为订单关闭状态，订单号："+ao.getOrder_number());//操作内容
		sj.setOperator(user_name);//操作者
		sj.setType("修改");//操作类型
		sjDao.addJournal(sj);
		
	}
	
	/**
	 * 将订单由2变成3
	 * @param id
	 * @throws Exception
	 */
	@Transactional
	public void changeOrderTwoToThree(Long id,String user_name) throws Exception{
		Auditing_order ao=auditingOrderDao.findById(id);
		ao.setAdd_time(new Date());
		ao.setAuditer_name(user_name);
		ao.setStatus(3);
		orderlnHoursDao.addOrder(ao);
		auditingOrderDao.delAuditingOrderById(ao.getId());
		//插入日志记录
		System_Journal sj=new System_Journal();
		sj.setDate(new Date());//操作时间
		sj.setModule("订单管理");//所属模块
		sj.setOperation_content("订单由成功批款状态修改为成功放款状态，订单号："+ao.getOrder_number());//操作内容
		sj.setOperator(user_name);//操作者
		sj.setType("修改");//操作类型
		sjDao.addJournal(sj);
	}
	
	/**
	 * 将订单由2变成5
	 * @param id
	 * @throws Exception
	 */
	@Transactional
	public void changeOrderTwoToFive(Long id,String user_name,String remarks) throws Exception{
		Auditing_order ao=auditingOrderDao.findById(id);
		ao.setAdd_time(new Date());
		ao.setAuditer_name(user_name);
		ao.setStatus(5);
		ao.setRemarks(remarks);
		orderlnHoursDao.addOrder(ao);
		auditingOrderDao.delAuditingOrderById(ao.getId());
		//插入日志记录
		System_Journal sj=new System_Journal();
		sj.setDate(new Date());//操作时间
		sj.setModule("订单管理");//所属模块
		sj.setOperation_content("订单由成功批款状态修改为订单关闭状态，订单号："+ao.getOrder_number());//操作内容
		sj.setOperator(user_name);//操作者
		sj.setType("修改");//操作类型
		sjDao.addJournal(sj);
	}
	
	
	/**
	 * 将订单由3变成4
	 * @param map
	 */
	@Transactional
	public void changeOrderThreeToFour(Long id,String user_name,Double money1) throws Exception{
		Production prod = new Production();
		Order_inHours  ao=orderlnHoursDao.findOrderById(id);
		prod.setOrgId(ao.getJigou_id());
		prod.setProName(ao.getProduct());
		BigDecimal money=new BigDecimal(money1);
		Order_inHours  ao1=new Order_inHours();
		ao1.setId(id);
		ao1.setAdd_time(new Date());
		ao1.setAuditer_name(user_name);
		ao1.setStatus(4);
		ao1.setMoney(money);
		orderlnHoursDao.changOrderStatus(ao1);
		//插入系统日志
		System_Journal sj=new System_Journal();
		sj.setDate(new Date());//操作时间
		sj.setModule("订单管理");//所属模块
		sj.setOperation_content("订单由成功放款状态修改为佣金到账状态，订单号："+ao.getOrder_number()+"，金额："+money1+"元");//操作内容
		sj.setOperator(user_name);//操作者
		sj.setType("修改");//操作类型
		sjDao.addJournal(sj);
		//返佣
	//	修改用户和推广人佣金余额//添加佣金变动记录
		Jdb_systemParam jsp=jspDao.findById();//获取返佣比例
		Production pro = orderlnHoursDao.selectByID_Name(prod);
		double user_scale=pro.getRebateLimit()/100;//产品对用户返佣的百分比
		double recommend_scale=jsp.getRecommend_scale()/100;//产品对推广员的百分比
		double commission_quota=jsp.getCommission_quota()/100;//用户佣金提现比例
//		System.out.println("用户返佣的百分比:"+user_scale);
//		System.out.println("推广员的百分比:"+recommend_scale);
//		System.out.println("用户佣金提现比例:"+commission_quota);
//		System.out.println("产品单价:"+money);	
		long user_id=ao.getUser_id();//用户ID
		System.out.println("用户ID:"+user_id);
		Commission commission=commissionDao.findById(user_id);
		BigDecimal balance=commission.getBalance();//用户的佣金余额
		BigDecimal totalBalance=commission.getTotal_balance();//用户的总佣金数
		BigDecimal newBalance=balance.add(money.multiply(new BigDecimal(user_scale)).setScale(2, BigDecimal.ROUND_HALF_UP));
		BigDecimal newTotalBalance=totalBalance.add(money.multiply(new BigDecimal(user_scale)).setScale(2, BigDecimal.ROUND_HALF_UP));
//		System.out.println("用户的旧佣金余额:"+balance);
//		System.out.println("用户的新佣金余额:"+newBalance);
		//1.给用户返佣
		commission.setBalance(newBalance);//设置用户佣金余额值
		commission.setCan_use_balance((newBalance.multiply(new BigDecimal(commission_quota)).setScale(2, BigDecimal.ROUND_HALF_UP)));
		commission.setTotal_balance(newTotalBalance);//设置用户佣金总额度
//		System.out.println("用户的id:"+commission.getUser_id());
//      System.out.println("用户的旧佣金余额:"+commission.getBalance());
//	    System.out.println("用户的新佣金余额:"+commission.getCan_use_balance());
		//更薪用户佣金余额值 
		commissionDao.updateUserBalance(commission);
//		//2.插入用户佣金变动记录
		Commission_detail cd=new Commission_detail();
		cd.setUser_id(user_id);//设置用户id
		cd.setAdd_time(new Date());//设置插入记录时间
		cd.setState("返佣");
		cd.setChange_amount((money.multiply(new BigDecimal(user_scale)).setScale(2, BigDecimal.ROUND_HALF_UP)));//设置变动金额
		cd.setBalance(newBalance);//设置佣金最新金额
		commissionDetailDao.addCommissionChangeRecord(cd);//插入用户佣金变动记录
		Long recommemd_id=commission.getRecommemd_id();//推广人Id
		boolean f=true;	
		if(recommemd_id==null){//如果推广人不存在
			f=false;
		}		
		while(f){
			//3.给推广员返佣
			//4.插入推广员佣金变动记录
			Commission recommemd_commission=commissionDao.findById(recommemd_id);
		    System.out.println("推广人ID"+recommemd_id);
		    //System.out.println(recommemd_commission.toString());
			BigDecimal recommemd_balance=recommemd_commission.getBalance();//推广人的佣金余额
			BigDecimal recommemd_total_balance=recommemd_commission.getTotal_balance();//推广人的佣金总额
			BigDecimal recommemd_recommended_balance=recommemd_commission.getRecommended_balance();//推广人的推广佣金
			BigDecimal recommemd_newBalance=recommemd_balance.add(money.multiply(new BigDecimal(recommend_scale)).setScale(2, BigDecimal.ROUND_HALF_UP));
			BigDecimal recommemd_newTotalBalance=recommemd_total_balance.add((money.multiply(new BigDecimal(recommend_scale)).setScale(2, BigDecimal.ROUND_HALF_UP)));
			BigDecimal recommemd_newRecommendedBalance=recommemd_recommended_balance.add((money.multiply(new BigDecimal(recommend_scale)).setScale(2, BigDecimal.ROUND_HALF_UP)));
			//1）.给推广人返佣
		 	recommemd_commission.setBalance(recommemd_newBalance);//设置推广人佣金余额值
		 	recommemd_commission.setCan_use_balance((recommemd_newBalance.multiply(new BigDecimal(commission_quota)).setScale(2, BigDecimal.ROUND_HALF_UP)));
		 	recommemd_commission.setTotal_balance(recommemd_newTotalBalance);//设置推广人佣金总额度
		 	recommemd_commission.setRecommended_balance(recommemd_newRecommendedBalance);//设置推广人的推广返佣
		 	
			commissionDao.updateUserBalance(recommemd_commission);//更薪推广人佣金余额值
			//2）.插入用户佣金变动记录
			Commission_detail recommemd_cd=new Commission_detail();
			recommemd_cd.setUser_id(recommemd_id);//设置推广人用户id
			recommemd_cd.setAdd_time(new Date());//设置插入记录时间
			recommemd_cd.setState("推广返佣");
			recommemd_cd.setChange_amount((money.multiply(new BigDecimal(recommend_scale)).setScale(2, BigDecimal.ROUND_HALF_UP)));//设置变动金额
			recommemd_cd.setBalance(recommemd_newBalance);//设置推广人佣金最新金额
			commissionDetailDao.addCommissionChangeRecord(recommemd_cd);//插入推广人佣金变动记录
			recommemd_id=recommemd_commission.getRecommemd_id();		
			if(recommemd_id==null){
				f=false;
			}				
		}//while结束
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	/**
//	 * 进入审核已经信审后返佣的订单页面（返回详细信息）
//	 */
//	public  Map<String,Object> isCheckFanYongOrder(Long id){
//		Map<String,Object> paramMap=new HashMap<String,Object>();
//		Auditing_order ao=aoDao.findById(id);
//        paramMap.put("id", ao.getId());
//        long user_id=ao.getUser_id();
//        User user=userDao.findUserById((int)user_id);
//        if(user==null){
//        	user=new User();
//        }
//		paramMap.put("name", user.getPhoneNumber());//客户经理电话
//		paramMap.put("order_number", ao.getOrder_number());
//		paramMap.put("user_identity", ao.getUser_identity());
//		paramMap.put("product", ao.getProduct());
//		paramMap.put("true_name", ao.getTrue_name());
//		paramMap.put("user_idCardNumber", ao.getUser_idCardNumber());
//		paramMap.put("tel_number", ao.getTel_number());
//		paramMap.put("province", ao.getProvince());
//		paramMap.put("city",ao.getCity() );
//		Long recommend_id=ao.getAuditer_id();
//		Administrators admin=aDao.findById(recommend_id);
//		paramMap.put("recommend_name", admin.getLoginName());//根据id查询管理员登录名
//		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
//		paramMap.put("add_time",sdf.format(ao.getAdd_time()));
//		return paramMap;
//	}
//	
//	
//

	
}
