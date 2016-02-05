package com.zp.jdb.controllor;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zp.jdb.dao.Auditing_orderDao;
import com.zp.jdb.dao.CarImgDao;
import com.zp.jdb.dao.CarInformationDao;
import com.zp.jdb.dao.DictionaryDao;
import com.zp.jdb.dao.HouseImgDao;
import com.zp.jdb.dao.HouseInformationDao;
import com.zp.jdb.dao.Jdb_systemParameterDao;
import com.zp.jdb.dao.OrderlnHoursDao;
import com.zp.jdb.dao.ProductionDao;
import com.zp.jdb.entity.Alltable;
import com.zp.jdb.entity.Auditing_order;
import com.zp.jdb.entity.Car;
import com.zp.jdb.entity.Dictionary;
import com.zp.jdb.entity.Housing;
import com.zp.jdb.entity.Img_forcar;
import com.zp.jdb.entity.Img_forhouse;
import com.zp.jdb.entity.Jdb_systemParam;
import com.zp.jdb.entity.Order_inHours;
import com.zp.jdb.entity.Production;
import com.zp.jdb.service.AdminService;
import com.zp.jdb.service.OrderService;
import com.zp.jdb.util.Util;

/**
 * 订单管理
 * @author Administrator
 *
 */
@Controller
public class OrderController {   
	
	private Integer pageSize=Util.PAGESIZE;
	
	@Resource
	private OrderService  orderService;	
	@Resource
	private AdminService service;
	@Resource
    private DictionaryDao  dictionaryDao;
	@Resource
	private ProductionDao proDao;
	@Resource
	private Jdb_systemParameterDao jspDao;
    @Resource
    private HouseInformationDao housDao;
    @Resource
    private CarInformationDao carDao;
    @Resource
	private OrderlnHoursDao  orderlnHoursDao;
    @Resource
    private  Auditing_orderDao auditingOrderDao;
    @Resource
	private CarImgDao cDao;
    @Resource
    private  HouseImgDao hDao;
	
	/**
	 * 进入订单机构页面
	 * @return
	 */
	@RequestMapping("/toDingDan.do")
	public String isEnter(Alltable ata, Model m, HttpServletRequest request){
		request.getSession().setAttribute("power_id", ata.getPower_id());
		List<Alltable> list1 = service.isSelectOperateInPower(ata);
		m.addAttribute("kzlist", list1);
		return "dingdan";
	}
	
	
	//第一状态（补充材料状态）部分
	/**
	 * 进入补充材料页面（状态是0的）
	 * @param model
	 * @param res
	 * @param oi
	 * @param page  
	 * @param name
	 * @return
	 */
	@RequestMapping("/toOrderOneIndex.do")
	public String toOrderOneIndex(Alltable ata,Model model,HttpServletRequest res,Order_inHours oi){
		
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("status", 0);
		String jigou_id=(String) res.getSession().getAttribute("jigou_id");
		jigou_id=jigou_id.substring(0, jigou_id.length()-1);
		if("0".equals(jigou_id)){
			paramMap.put("jigou_id", null);
		}else{
		    paramMap.put("jigou_id", jigou_id);
		}
System.out.println(paramMap);
		int number=orderService.isFindOrderAll(paramMap);/////////////////////////////////////////
		if(number%pageSize==0){
			if(number==0){
				model.addAttribute("totalCount", 1);
			}else{
				model.addAttribute("totalCount", number/pageSize);
			}
		}else{
			model.addAttribute("totalCount", number/pageSize+1);
		}
		Long power_id=(long)res.getSession().getAttribute("power_id");
		ata.setPower_id(power_id);
		List<Alltable> list1 = service.isSelectOperateInPower(ata);
		model.addAttribute("kzlist", list1);
		List<Dictionary> provinceList=dictionaryDao.findByParentId(0);
		model.addAttribute("province", provinceList);
		List<Production> productions=proDao.findAllProductions();
		model.addAttribute("productions", productions);
		return "order/order_one";
	}
	
	/**
	 * 返回补充材料条件查询数据（状态是0的）
	 * @param res
	 * @param oi
	 * @param page
	 * @param name
	 * @return
	 */
	@RequestMapping("/returnOrderOneIndex.do")
	@ResponseBody
	public Map<String,Object> returnOrderOneIndex(HttpServletRequest res,Order_inHours oi,Integer page){
		String date1=res.getParameter("date1");
		String date2=res.getParameter("date2");
		String jigou_id=(String) res.getSession().getAttribute("jigou_id");
		jigou_id=jigou_id.substring(0, jigou_id.length()-1);	
		Map<String,Object> paramMap=new HashMap<String,Object>();
		Map<String,Object> resMap=new HashMap<String,Object>();
		paramMap.put("number", (page-1)*pageSize);
		paramMap.put("pageSize", pageSize);
		paramMap.put("user_phoneNumber", oi.getUser_phoneNumber());
		paramMap.put("order_number", oi.getOrder_number());
		paramMap.put("user_identity", oi.getUser_identity());
		paramMap.put("product", oi.getProduct());
		paramMap.put("true_name", oi.getTrue_name());
		paramMap.put("province", oi.getProvince());
		paramMap.put("user_idCardNumber", oi.getUser_idCardNumber());
		paramMap.put("city", oi.getCity());
		paramMap.put("status", 0);		
		if("0".equals(jigou_id)){
			paramMap.put("jigou_id", null);
		}else{
		    paramMap.put("jigou_id", jigou_id);
		}
		paramMap.put("auditer_name", oi.getAuditer_name());
		if((date1==null ||date1=="") && (date2==null ||date2=="")){
			paramMap.put("add_time", null);                                                		
		}else{
            SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd hh:mm:ss");
            Date resDate1=new Date();
            Date resDate2=new Date();
            try{
	            if((date1==null ||date1=="")){ 
	            	resDate1 = sdf.parse("2015-01-01 22:22:22");
	            	resDate2=sdf.parse(date2);  
	            }
	            if(date2==null ||date2==""){
	            	resDate1=sdf.parse(date1);
	            }
	            if((date1!=null ||date1!="")  && (date2!=null || date2!="")){
	            	resDate1=sdf.parse(date1);
	            	resDate2=sdf.parse(date2);
	            }
            }catch(Exception e){
            	System.out.println("日期类型转换异常！");
            }                                             
			paramMap.put("add_time", "123");	
			paramMap.put("add_time1", resDate1);
			paramMap.put("add_time2", resDate2);
		}
//System.out.println("状态为0的："+paramMap.toString());		
		List<Map<String,Object>> resList=orderService.isFindOrderAllByLimit(paramMap);///////////////////////////
		resMap.put("list", resList);
		resMap.put("page", page);	
		int number=orderService.isFindOrderAll(paramMap);//////////////////////////////////////////////
		if(number%pageSize==0){
			if(number==0){
			   resMap.put("totalCount", 1);
			}else{
			   resMap.put("totalCount", number/pageSize);
			}
		}else{
			resMap.put("totalCount", number/pageSize+1);
		}
		return resMap;
	}
	
	/**
	 * 处理收集材料齐全请求(提交到订单审批状态（状态改为1）)
	 */
	@RequestMapping("/okOrderOneIndex.do")
	@ResponseBody
	public Map<String,Object> okOrderOneIndex(Long id,HttpServletRequest req){
		String user_name=(String)req.getSession().getAttribute("user_name");
		Map<String,Object> resMap=new HashMap<String,Object>();
		try{
			orderService.changeOrderZeroToOne(user_name,id);////////////////////
		}catch(Exception e ){
			e.printStackTrace();
			resMap.put("err", "提交失败");
		}
		return resMap;
		
	}
	
	/**
	 * 处理收集材料不齐全请求(提交到订单关闭状态（状态改为5）)
	 */
	@RequestMapping("/noOrderOneIndex.do")
	@ResponseBody
	public Map<String,Object> noOrderOneIndex(Long id,HttpServletRequest req,String remarks){
		String user_name=(String)req.getSession().getAttribute("user_name");
		Map<String,Object> resMap=new HashMap<String,Object>();
		try{
			orderService.changOrderZeroToFive(user_name,remarks,id);//////////////////////////////////
		}catch(Exception e ){
			e.printStackTrace();
			resMap.put("err", "提交失败");
		}
		return resMap;
		
	}
	
	
	
	//第二状态（订单审批）部分
	/** 进入订单审批页面（状态为1的）
	 */
	@RequestMapping("/toOrderTwoIndex.do")
	public String toOrderTwoIndex(Alltable ata,Model model,HttpServletRequest res,Auditing_order ao){
		String jigou_id=(String) res.getSession().getAttribute("jigou_id");
		jigou_id=jigou_id.substring(0, jigou_id.length()-1);
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("status", 1);
		if("0".equals(jigou_id)){
			paramMap.put("jigou_id", null);
		}else{
		    paramMap.put("jigou_id", jigou_id);
		}
		int number=orderService.isFindAuditingAll(paramMap);/////////////////////////////////////////////
		if(number%pageSize==0){
			if(number==0){
				model.addAttribute("totalCount", 1);
			}else{
				model.addAttribute("totalCount", number/pageSize);
			}
			
		}else{
			model.addAttribute("totalCount", number/pageSize+1);
		}
		Long power_id=(long)res.getSession().getAttribute("power_id");
		ata.setPower_id(power_id);
		List<Alltable> list1 = service.isSelectOperateInPower(ata);
		model.addAttribute("kzlist", list1);
		List<Dictionary> provinceList=dictionaryDao.findByParentId(0);
		model.addAttribute("province", provinceList);
		List<Production> productions=proDao.findAllProductions();
		model.addAttribute("productions", productions);
		return "order/order_two";
	}
	
	/**
	 * 返回订单审批状态条件查询数据（状态为1的）
	 */
	@RequestMapping("/returnOrderTwoIndex.do")
	@ResponseBody
	public Map<String,Object> returnOrderTwoIndex(HttpServletRequest res,Auditing_order ao,Integer page){
		String date1=res.getParameter("date1");
		String date2=res.getParameter("date2");
		String jigou_id=(String) res.getSession().getAttribute("jigou_id");
		jigou_id=jigou_id.substring(0, jigou_id.length()-1);	
		Map<String,Object> paramMap=new HashMap<String,Object>();
		Map<String,Object> resMap=new HashMap<String,Object>();
		paramMap.put("number", (page-1)*pageSize);
		paramMap.put("pageSize", pageSize);
		paramMap.put("user_phoneNumber", ao.getUser_phoneNumber());
		paramMap.put("order_number", ao.getOrder_number());
		paramMap.put("user_identity", ao.getUser_identity());
		paramMap.put("product", ao.getProduct());
		paramMap.put("true_name", ao.getTrue_name());
		paramMap.put("province", ao.getProvince());
		paramMap.put("user_idCardNumber", ao.getUser_idCardNumber());
		paramMap.put("city", ao.getCity());
		paramMap.put("status", 1);
		if("0".equals(jigou_id)){
			paramMap.put("jigou_id", null);
		}else{
		    paramMap.put("jigou_id", jigou_id);
		}
		paramMap.put("auditer_name", ao.getAuditer_name());
		if((date1==null ||date1=="") && (date2==null ||date2=="")){
			paramMap.put("add_time", null);                                                		
		}else{
            SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd hh:mm:ss");
            Date resDate1=new Date();
            Date resDate2=new Date();
            try{
	            if((date1==null ||date1=="")){ 
	            	resDate1 = sdf.parse("2015-01-01 22:22:22");
	            	resDate2=sdf.parse(date2);                                             
	            }
	            if(date2==null ||date2==""){
	            	resDate1=sdf.parse(date1);                                             
	            }
	            if((date1!=null ||date1!="")  && (date2!=null || date2!="")){
	            	resDate1=sdf.parse(date1);
	            	resDate2=sdf.parse(date2);                                               	
	            }
            }catch(Exception e){
            	System.out.println("日期类型转换异常！");
            }                                             
			paramMap.put("add_time", "123");	
			paramMap.put("add_time1", resDate1);
			paramMap.put("add_time2", resDate2);
		}
//System.out.println("状态为1的："+paramMap.toString());				
		List<Map<String,Object>> resList=orderService.isFindAuditingAllByLimit(paramMap);//////////////////////////////
		resMap.put("list", resList);
		resMap.put("page", page);	
		int number=orderService.isFindAuditingAll(paramMap);//////////////////////////////////////
		if(number%pageSize==0){
			if(number==0){
			   resMap.put("totalCount", 1);
			}else{
			   resMap.put("totalCount", number/pageSize);
			}
		}else{
			resMap.put("totalCount", number/pageSize+1);
		}
		return resMap;
	}

	/**
	 * 处理通过订单审批(状态改为2)
	 */
	@RequestMapping("/okOrderTwoIndex.do")
	@ResponseBody
	public Map<String,Object> okOrderTwoIndex(Long id,HttpServletRequest req){
		String user_name=(String)req.getSession().getAttribute("user_name");
		Map<String,Object> resMap=new HashMap<String,Object>();
		try{
			orderService.changOrderOneToTwo(id,user_name);/////////////////////////////////////////
		}catch(Exception e ){
			e.printStackTrace();
			resMap.put("err", "提交失败");
		}
		return resMap;
		
	}
	
	/**
	 * 处理通过未订单审批请求(状态改为5)
	 */
	@RequestMapping("/noOrderTwoIndex.do")
	@ResponseBody
	public Map<String,Object> noOrderTwoIndex(Long id,HttpServletRequest req,String remarks){
		String user_name=(String)req.getSession().getAttribute("user_name");
		Map<String,Object> resMap=new HashMap<String,Object>();
		try{
			orderService.changOrderOneToFive(user_name,id,remarks);/////////////////////////////////////
		}catch(Exception e ){
			e.printStackTrace();
			resMap.put("err", "提交失败");
		}
		return resMap;
		
	}
	
	
	
	
	//第三状态（成功批款）部分
	/** 进入成功批款页面（状态为2的）
	 */
	@RequestMapping("/toOrderThreeIndex.do")
	public String toOrderThreeIndex(Alltable ata,Model model,HttpServletRequest res,Auditing_order ao,Integer page){
		String jigou_id=(String) res.getSession().getAttribute("jigou_id");
		jigou_id=jigou_id.substring(0, jigou_id.length()-1);		
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("status", 2);
		if("0".equals(jigou_id)){
			paramMap.put("jigou_id", null);
		}else{
		    paramMap.put("jigou_id", jigou_id);
		}
		int number=orderService.isFindAuditingAll(paramMap);////////////////////////////////////////////
		if(number%pageSize==0){
			if(number==0){
				model.addAttribute("totalCount", 1);
			}else{
				model.addAttribute("totalCount", number/pageSize);
			}
			
		}else{
			model.addAttribute("totalCount", number/pageSize+1);
		}
		Long power_id=(long)res.getSession().getAttribute("power_id");
		ata.setPower_id(power_id);
		List<Alltable> list1 = service.isSelectOperateInPower(ata);
		model.addAttribute("kzlist", list1);
		List<Dictionary> provinceList=dictionaryDao.findByParentId(0);
		model.addAttribute("province", provinceList);
		List<Production> productions=proDao.findAllProductions();
		model.addAttribute("productions", productions);
		return "order/order_three";
	}
	
	/**
	 * 返回订单审批状态条件查询数据（状态为2的）
	 */
	@RequestMapping("/returnOrderThreeIndex.do")
	@ResponseBody
	public Map<String,Object> returnOrderThreeIndex(HttpServletRequest res,Auditing_order ao,Integer page){
		String date1=res.getParameter("date1");
		String date2=res.getParameter("date2");
		String jigou_id=(String) res.getSession().getAttribute("jigou_id");
		jigou_id=jigou_id.substring(0, jigou_id.length()-1);		
		Map<String,Object> paramMap=new HashMap<String,Object>();
		Map<String,Object> resMap=new HashMap<String,Object>();
		paramMap.put("number", (page-1)*pageSize);
		paramMap.put("pageSize", pageSize);
		paramMap.put("user_phoneNumber", ao.getUser_phoneNumber());
		paramMap.put("order_number", ao.getOrder_number());
		paramMap.put("user_identity", ao.getUser_identity());
		paramMap.put("product", ao.getProduct());
		paramMap.put("true_name", ao.getTrue_name());
		paramMap.put("province", ao.getProvince());
		paramMap.put("user_idCardNumber", ao.getUser_idCardNumber());
		paramMap.put("city", ao.getCity());
		paramMap.put("status", 2);
		if("0".equals(jigou_id)){
			paramMap.put("jigou_id", null);
		}else{
		    paramMap.put("jigou_id", jigou_id);
		}
		paramMap.put("auditer_name", ao.getAuditer_name());
		if((date1==null ||date1=="") && (date2==null ||date2=="")){
			paramMap.put("add_time", null);                                                		
		}else{
            SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd hh:mm:ss");
            Date resDate1=new Date();
            Date resDate2=new Date();
            try{
	            if((date1==null ||date1=="")){ 
	            	resDate1 = sdf.parse("2015-01-01 22:22:22");
	            	resDate2=sdf.parse(date2);                                             
	            }
	            if(date2==null ||date2==""){
	            	resDate1=sdf.parse(date1);                                             
	            }
	            if((date1!=null ||date1!="")  && (date2!=null || date2!="")){
	            	resDate1=sdf.parse(date1);
	            	resDate2=sdf.parse(date2);                                               	
	            }
            }catch(Exception e){
            	System.out.println("日期类型转换异常！");
            }                                             
			paramMap.put("add_time", "123");	
			paramMap.put("add_time1", resDate1);
			paramMap.put("add_time2", resDate2);
		}
//System.out.println("状态为2的："+paramMap.toString());				
		List<Map<String,Object>> resList=orderService.isFindAuditingAllByLimit(paramMap);
		resMap.put("list", resList);
		resMap.put("page", page);	
		int number=orderService.isFindAuditingAll(paramMap);
		if(number%pageSize==0){
			if(number==0){
			   resMap.put("totalCount", 1);
			}else{
			   resMap.put("totalCount", number/pageSize);
			}
		}else{
			resMap.put("totalCount", number/pageSize+1);
		}
		return resMap;
	}

	/**
	 * 处理通过订单审批(状态改为3)
	 */
	@RequestMapping("/okOrderThreeIndex.do")
	@ResponseBody
	public Map<String,Object> okOrderThreeIndex(Long id,HttpServletRequest req){
		String user_name=(String)req.getSession().getAttribute("user_name");
		Map<String,Object> resMap=new HashMap<String,Object>();
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("user_name", user_name);
		paramMap.put("id", id);
		paramMap.put("status", 3);
		try{
			orderService.changeOrderTwoToThree(id,user_name);
		}catch(Exception e ){
			e.printStackTrace();
			resMap.put("err", "提交失败");
		}
		return resMap;
		
	}
	
	/**
	 * 处理通过未订单审批请求(状态改为5)
	 */
	@RequestMapping("/noOrderThreeIndex.do")
	@ResponseBody
	public Map<String,Object> noOrderThreeIndex(Long id,HttpServletRequest req,String remarks){
		String user_name=(String)req.getSession().getAttribute("user_name");
		Map<String,Object> resMap=new HashMap<String,Object>();
		try{
			orderService.changeOrderTwoToFive(id,user_name,remarks);
		}catch(Exception e ){
			e.printStackTrace();
			resMap.put("err", "提交失败");
		}
		return resMap;
		
	}
	
	
	
	
	//第四状态（成功放款）部分
	
	/** 进入成功放款页面（状态为3的）
	 */
	@RequestMapping("/toOrderFourIndex.do")
	public String toOrderFourIndex(Alltable ata,Model model,HttpServletRequest res,Auditing_order ao){
System.out.println(ao.toString());
		String jigou_id=(String) res.getSession().getAttribute("jigou_id");
		jigou_id=jigou_id.substring(0, jigou_id.length()-1);	
		Jdb_systemParam jsp=jspDao.findById();//获取返佣比例
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("status", 3);
		if("0".equals(jigou_id)){
			paramMap.put("jigou_id", null);
		}else{
		    paramMap.put("jigou_id", jigou_id);
		}
		int number=orderService.isFindOrderAll(paramMap);
		if(number%pageSize==0){
			if(number==0){
				model.addAttribute("totalCount", 1);
			}else{
				model.addAttribute("totalCount", number/pageSize);
			}
			
		}else{
			model.addAttribute("totalCount", number/pageSize+1);
		}
		Long power_id=(long)res.getSession().getAttribute("power_id");
		ata.setPower_id(power_id);
		List<Alltable> list1 = service.isSelectOperateInPower(ata);
		model.addAttribute("kzlist", list1);
		List<Dictionary> provinceList=dictionaryDao.findByParentId(0);
		model.addAttribute("province", provinceList);
		List<Production> productions=proDao.findAllProductions();
		model.addAttribute("productions", productions);
		
		model.addAttribute("bili", jsp.getUser_scale());
		return "order/order_four";
	}
	
	/**
	 * 返回成功放款状态条件查询数据（状态为3的）
	 */
	@RequestMapping("/returnOrderFourIndex.do")
	@ResponseBody
	public Map<String,Object> returnOrderFourIndex(HttpServletRequest res,Auditing_order ao,Integer page){
		String date1=res.getParameter("date1");
		String date2=res.getParameter("date2");
		String jigou_id=(String) res.getSession().getAttribute("jigou_id");
		jigou_id=jigou_id.substring(0, jigou_id.length()-1);		
		Map<String,Object> paramMap=new HashMap<String,Object>();
		Map<String,Object> resMap=new HashMap<String,Object>();
		paramMap.put("number", (page-1)*pageSize);
		paramMap.put("pageSize", pageSize);
		paramMap.put("user_phoneNumber", ao.getUser_phoneNumber());
		paramMap.put("order_number", ao.getOrder_number());
		paramMap.put("user_identity", ao.getUser_identity());
		paramMap.put("product", ao.getProduct());
		paramMap.put("true_name", ao.getTrue_name());
		paramMap.put("province", ao.getProvince());
		paramMap.put("user_idCardNumber", ao.getUser_idCardNumber());
		paramMap.put("city", ao.getCity());
		paramMap.put("status", 3);
		if("0".equals(jigou_id)){
			paramMap.put("jigou_id", null);
		}else{
		    paramMap.put("jigou_id", jigou_id);
		}
		paramMap.put("auditer_name", ao.getAuditer_name());
		if((date1==null ||date1=="") && (date2==null ||date2=="")){
			paramMap.put("add_time", null);                                                		
		}else{
            SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd hh:mm:ss");
            Date resDate1=new Date();
            Date resDate2=new Date();
            try{
	            if((date1==null ||date1=="")){ 
	            	resDate1 = sdf.parse("2015-01-01 22:22:22");
	            	resDate2=sdf.parse(date2);                                             
	            }
	            if(date2==null ||date2==""){
	            	resDate1=sdf.parse(date1);                                             
	            }
	            if((date1!=null ||date1!="")  && (date2!=null || date2!="")){
	            	resDate1=sdf.parse(date1);
	            	resDate2=sdf.parse(date2);                                               	
	            }
            }catch(Exception e){
            	System.out.println("日期类型转换异常！");
            }                                             
			paramMap.put("add_time", "123");	
			paramMap.put("add_time1", resDate1);
			paramMap.put("add_time2", resDate2);
		}
//System.out.println("状态为3的："+paramMap.toString());		
		List<Map<String,Object>> resList=orderService.isFindOrderAllByLimit(paramMap);
		resMap.put("list", resList);
		resMap.put("page", page);	
		int number=orderService.isFindOrderAll(paramMap);
		if(number%pageSize==0){
			if(number==0){
			   resMap.put("totalCount", 1);
			}else{
			   resMap.put("totalCount", number/pageSize);
			}
		}else{
			resMap.put("totalCount", number/pageSize+1);
		}
		return resMap;
	}

	/**
	 * 处理发放佣金请求(状态改为4)
	 */
	@RequestMapping("/okOrderFourIndex.do")
	@ResponseBody
	public Map<String,Object> okOrderFourIndex(Long id,HttpServletRequest req,Double money){
		String user_name=(String)req.getSession().getAttribute("user_name");
		Map<String,Object> resMap=new HashMap<String,Object>();
		try{
			orderService.changeOrderThreeToFour(id,user_name,money);
		}catch(Exception e ){
			e.printStackTrace();
			resMap.put("err", "提交失败");
		}
		return resMap;
		
	}

	
	
	
	//第五状态（佣金到账）部分
	/** 进入佣金到账页面（状态为4的）
	 */
	@RequestMapping("/toOrderFiveIndex.do")
	public String toOrderFiveIndex(Alltable ata,Model model,HttpServletRequest res,Auditing_order ao,Integer page){
		String jigou_id=(String) res.getSession().getAttribute("jigou_id");
		jigou_id=jigou_id.substring(0, jigou_id.length()-1);	
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("status", 4);
		if("0".equals(jigou_id)){
			paramMap.put("jigou_id", null);
		}else{
		    paramMap.put("jigou_id", jigou_id);
		}
		int number=orderService.isFindOrderAll(paramMap);
		if(number%pageSize==0){
			if(number==0){
				model.addAttribute("totalCount", 1);
			}else{
				model.addAttribute("totalCount", number/pageSize);
			}
			
		}else{
			model.addAttribute("totalCount", number/pageSize+1);
		}
		Long power_id=(long)res.getSession().getAttribute("power_id");
		ata.setPower_id(power_id);
		List<Alltable> list1 = service.isSelectOperateInPower(ata);
		model.addAttribute("kzlist", list1);
		List<Dictionary> provinceList=dictionaryDao.findByParentId(0);
		model.addAttribute("province", provinceList);
		List<Production> productions=proDao.findAllProductions();
		model.addAttribute("productions", productions);
		return "order/order_five";
	}
	
	/**
	 * 返回订单审批状态条件查询数据（状态为4的）
	 */
	@RequestMapping("/returnOrderFiveIndex.do")
	@ResponseBody
	public Map<String,Object> returnOrderFiveIndex(HttpServletRequest res,Auditing_order ao,Integer page){
		String date1=res.getParameter("date1");
		String date2=res.getParameter("date2");
		String jigou_id=(String) res.getSession().getAttribute("jigou_id");
		jigou_id=jigou_id.substring(0, jigou_id.length()-1);	
		Map<String,Object> paramMap=new HashMap<String,Object>();
		Map<String,Object> resMap=new HashMap<String,Object>();
		paramMap.put("number", (page-1)*pageSize);
		paramMap.put("pageSize", pageSize);
		paramMap.put("user_phoneNumber", ao.getUser_phoneNumber());
		paramMap.put("order_number", ao.getOrder_number());
		paramMap.put("user_identity", ao.getUser_identity());
		paramMap.put("product", ao.getProduct());
		paramMap.put("true_name", ao.getTrue_name());
		paramMap.put("province", ao.getProvince());
		paramMap.put("user_idCardNumber", ao.getUser_idCardNumber());
		paramMap.put("city", ao.getCity());
		paramMap.put("status", 4);
		if("0".equals(jigou_id)){
			paramMap.put("jigou_id", null);
		}else{
		    paramMap.put("jigou_id", jigou_id);
		}
		paramMap.put("auditer_name", ao.getAuditer_name());
		if((date1==null ||date1=="") && (date2==null ||date2=="")){
			paramMap.put("add_time", null);                                                		
		}else{
            SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd hh:mm:ss");
            Date resDate1=new Date();
            Date resDate2=new Date();
            try{
	            if((date1==null ||date1=="")){ 
	            	resDate1 = sdf.parse("2015-01-01 22:22:22");
	            	resDate2=sdf.parse(date2);                                             
	            }
	            if(date2==null ||date2==""){
	            	resDate1=sdf.parse(date1);                                             
	            }
	            if((date1!=null ||date1!="")  && (date2!=null || date2!="")){
	            	resDate1=sdf.parse(date1);
	            	resDate2=sdf.parse(date2);                                               	
	            }
            }catch(Exception e){
            	System.out.println("日期类型转换异常！");
            }                                             
			paramMap.put("add_time", "123");	
			paramMap.put("add_time1", resDate1);
			paramMap.put("add_time2", resDate2);
		}
//System.out.println("状态为4的："+paramMap.toString());		
		List<Map<String,Object>> resList=orderService.isFindOrderAllByLimit(paramMap);
		resMap.put("list", resList);
		resMap.put("page", page);	
		int number=orderService.isFindOrderAll(paramMap);
		if(number%pageSize==0){
			if(number==0){
			   resMap.put("totalCount", 1);
			}else{
			   resMap.put("totalCount", number/pageSize);
			}
		}else{
			resMap.put("totalCount", number/pageSize+1);
		}
		return resMap;
	}

	
	
	//第六状态（订单关闭）部分
	/** 进入订单关闭页面（状态为5的）
	 */
	@RequestMapping("/toOrderSixIndex.do")
	public String toOrderSixIndex(Alltable ata,Model model,HttpServletRequest res,Auditing_order ao,Integer page){
		String jigou_id=(String) res.getSession().getAttribute("jigou_id");
		jigou_id=jigou_id.substring(0, jigou_id.length()-1);	
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("status", 5);
		if("0".equals(jigou_id)){
			paramMap.put("jigou_id", null);
		}else{
		    paramMap.put("jigou_id", jigou_id);
		}
		int number=orderService.isFindOrderAll(paramMap);
		if(number%pageSize==0){
			if(number==0){
				model.addAttribute("totalCount", 1);
			}else{
				model.addAttribute("totalCount", number/pageSize);
			}
			
		}else{
			model.addAttribute("totalCount", number/pageSize+1);
		}
		Long power_id=(long)res.getSession().getAttribute("power_id");
		ata.setPower_id(power_id);
		List<Alltable> list1 = service.isSelectOperateInPower(ata);
		model.addAttribute("kzlist", list1);
		List<Dictionary> provinceList=dictionaryDao.findByParentId(0);
		model.addAttribute("province", provinceList);
		List<Production> productions=proDao.findAllProductions();
		model.addAttribute("productions", productions);
		return "order/order_six";
	}
	
	/**
	 * 返回订单关闭状态条件查询数据（状态为5的）
	 */
	@RequestMapping("/returnOrderSixIndex.do")
	@ResponseBody
	public Map<String,Object> returnOrderSixIndex(HttpServletRequest res,Auditing_order ao,Integer page){
		String date1=res.getParameter("date1");
		String date2=res.getParameter("date2");
		String jigou_id=(String) res.getSession().getAttribute("jigou_id");
		jigou_id=jigou_id.substring(0, jigou_id.length()-1);	
		Map<String,Object> paramMap=new HashMap<String,Object>();
		Map<String,Object> resMap=new HashMap<String,Object>();
		paramMap.put("number", (page-1)*pageSize);
		paramMap.put("pageSize", pageSize);
		paramMap.put("user_phoneNumber", ao.getUser_phoneNumber());
		paramMap.put("order_number", ao.getOrder_number());
		paramMap.put("user_identity", ao.getUser_identity());
		paramMap.put("product", ao.getProduct());
		paramMap.put("true_name", ao.getTrue_name());
		paramMap.put("province", ao.getProvince());
		paramMap.put("user_idCardNumber", ao.getUser_idCardNumber());
		if("0".equals(jigou_id)){
			paramMap.put("jigou_id", null);
		}else{
		    paramMap.put("jigou_id", jigou_id);
		}
		paramMap.put("city", ao.getCity());
		paramMap.put("status", 5);
		paramMap.put("auditer_name", ao.getAuditer_name());
		if((date1==null ||date1=="") && (date2==null ||date2=="")){
			paramMap.put("add_time", null);                                                		
		}else{
            SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd hh:mm:ss");
            Date resDate1=new Date();
            Date resDate2=new Date();
            try{
	            if((date1==null ||date1=="")){ 
	            	resDate1 = sdf.parse("2015-01-01 22:22:22");
	            	resDate2=sdf.parse(date2);                                             
	            }
	            if(date2==null ||date2==""){
	            	resDate1=sdf.parse(date1);                                             
	            }
	            if((date1!=null ||date1!="")  && (date2!=null || date2!="")){
	            	resDate1=sdf.parse(date1);
	            	resDate2=sdf.parse(date2);                                               	
	            }
            }catch(Exception e){
            	System.out.println("日期类型转换异常！");
            }                                             
			paramMap.put("add_time", "123");	
			paramMap.put("add_time1", resDate1);
			paramMap.put("add_time2", resDate2);
		}
//System.out.println("状态为5的："+paramMap.toString());				
		List<Map<String,Object>> resList=orderService.isFindOrderAllByLimit(paramMap);
		resMap.put("list", resList);
		resMap.put("page", page);	
		int number=orderService.isFindOrderAll(paramMap);
		if(number%pageSize==0){
			if(number==0){
			   resMap.put("totalCount", 1);
			}else{
			   resMap.put("totalCount", number/pageSize);
			}
		}else{
			resMap.put("totalCount", number/pageSize+1);
		}
		return resMap;
	}
    
	//以下是处理其他的一些请求
	/**
	 * 依据省份名字查询其所有城市
	 * @param provinceName
	 * @return
	 */
	@RequestMapping("/dataCityIndex.do")
	@ResponseBody
	public Map<String,Object> returnCityIndex(String provinceName){
		Map<String,Object> resMap=new HashMap<String,Object>();
		int province_id =dictionaryDao.findById(provinceName);
		List<Dictionary> cityList=dictionaryDao.findByParentId(province_id);
		resMap.put("city", cityList);
		return resMap;
	}
	
	/**
	 * 处理查看非锁定订单详情请求
	 * @param ID
	 * @param m
	 * @return
	 */
	@RequestMapping("/toChaKanXIangQing.do")
	public String toChaKanXiangQingIndex(Long ID,Model m){
		Map<String,Object> resMap=new HashMap<String,Object>();
		Order_inHours order=orderlnHoursDao.findOrderById(ID);
		String order_number=order.getOrder_number();
		resMap.put("phone_number", order.getUser_phoneNumber());
		resMap.put("order_number", order.getOrder_number());
		resMap.put("product", order.getProduct());
		resMap.put("auditer_name", order.getAuditer_name());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		resMap.put("add_time", sdf.format(order.getAdd_time()));
		resMap.put("money", order.getMoney()+"元");
		List<Housing> hoursing=housDao.findByOrderNumber(order_number);	
		List<Img_forhouse> imghouse = hDao.findHouseImgByOrderNumber(order_number);
		List<Car> car=carDao.findByOrderNumber(order_number);
		List<Img_forcar> imgcar = cDao.findCarImgByOrderNumber(order_number);
		if(hoursing==null){
			hoursing=new ArrayList<Housing>();
		}
		if(car==null){
			car=new ArrayList<Car>();
		}
		if(imghouse==null){
			imghouse = new ArrayList<Img_forhouse>();
		}
		if(imgcar==null){
			imgcar = new ArrayList<Img_forcar>();
		}
        m.addAttribute("hoursing", hoursing);
        m.addAttribute("imgh", imghouse);
        m.addAttribute("car", car);
        m.addAttribute("imgc", imgcar);
        System.out.println(imghouse.size());
        System.out.println(imgcar.size());
        System.out.println(imgcar.toString());
		m.addAttribute("map", resMap);
		return "order/check_unlock_order";
	}
	
	/**
	 * 处理查看锁定订单详情请求
	 * @param ID
	 * @param m
	 * @return
	 */
	@RequestMapping("/toChaKanXIangQingLock.do")
	public String toChaKanXiangQingLockIndex(Long ID,Model m){
		Map<String,Object> resMap=new HashMap<String,Object>();
		Auditing_order order=auditingOrderDao.findById(ID);
		String order_number=order.getOrder_number();
		resMap.put("phone_number", order.getUser_phoneNumber());
		resMap.put("order_number", order.getOrder_number());
		resMap.put("product", order.getProduct());
		resMap.put("auditer_name", order.getAuditer_name());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		resMap.put("add_time", sdf.format(order.getAdd_time()));
		resMap.put("money", order.getMoney()+"元");
		List<Housing> hoursing=housDao.findByOrderNumber(order_number);		
		List<Img_forhouse> imghouse = hDao.findHouseImgByOrderNumber(order_number);
		List<Car> car=carDao.findByOrderNumber(order_number);
		List<Img_forcar> imgcar = cDao.findCarImgByOrderNumber(order_number);
		if(hoursing==null){
			hoursing=new ArrayList<Housing>();
		}
		if(car==null){
			car=new ArrayList<Car>();
		}
		if(imghouse==null){
			imghouse = new ArrayList<Img_forhouse>();
		}
		if(imgcar==null){
			imgcar = new ArrayList<Img_forcar>();
		}
		m.addAttribute("map", resMap);
		m.addAttribute("imgh", imghouse);
		m.addAttribute("hoursing", hoursing);
		m.addAttribute("imgc", imgcar);
	    m.addAttribute("car", car);
		return "order/check_lock_order";
	}
	
	
	@RequestMapping("/getchanpinbili.do")
	@ResponseBody
	public Map<String,Object> togetbili(Long id){
		Map<String,Object> resMap=new HashMap<String,Object>();
		try {
			Order_inHours o=orderlnHoursDao.findOrderById(id);
			Production pro=new Production();
			pro.setProName(o.getProduct());
			pro.setOrgId(o.getJigou_id());
			System.out.println("id:"+id);
			System.out.println("机构id："+o.getJigou_id());
			System.out.println("产品名："+o.getProduct());
			Production pr = orderlnHoursDao.selectByID_Name(pro);
			resMap.put("bili", pr.getRebateLimit());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resMap;
	}
	
	
	

}
