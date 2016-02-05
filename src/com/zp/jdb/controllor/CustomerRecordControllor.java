package com.zp.jdb.controllor;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zp.jdb.entity.Administrators;
import com.zp.jdb.entity.Alltable;
import com.zp.jdb.entity.Car;
import com.zp.jdb.entity.Housing;
import com.zp.jdb.entity.Img_forcar;
import com.zp.jdb.entity.Img_forhouse;
import com.zp.jdb.entity.Order_inHours;
import com.zp.jdb.entity.Organization;
import com.zp.jdb.entity.Production;
import com.zp.jdb.entity.ProductionDetail;
import com.zp.jdb.entity.System_Journal;
import com.zp.jdb.service.AdminService;
import com.zp.jdb.service.CustomerRecordService;
import com.zp.jdb.service.OrganizationService;
import com.zp.jdb.service.ProductionDetailService;
import com.zp.jdb.service.ProductionService;
import com.zp.jdb.service.System_JournalService;

@Controller
public class CustomerRecordControllor{
	private Integer pageSize=10;//每页几个结果
	@Resource
	private ProductionDetailService service;
	
	@Resource
	private OrganizationService oservice;
	
	@Resource
	private ProductionService pservice;
	
	@Resource
	private AdminService adservice;
	
	@Resource
	private System_JournalService sjservice;
	
	@Resource
	private CustomerRecordService crservice;
	
	/**
	 * 点击“客户记录查询”，跳转到customerRecord页面
	 * @param m
	 * @param request
	 * @param ata
	 * @return
	 */
	  @RequestMapping("/customerRecord.do")
	  public String selectCustomerRecord(Model m,HttpServletRequest request, Alltable ata){
		    request.getSession().setAttribute("power_id", ata.getPower_id());
			List<Alltable> list1 = adservice.isSelectOperateInPower(ata);
			m.addAttribute("kzlist", list1); 
		
			return "customerRecord";
	}
	  
	  /**
	   * 查询所有记录
	   * @param or
	   * @param m
	   * @param request
	   * @param ata
	   * @param page
	   * @return
	   */
	  @RequestMapping("/allRecord.do")
	  public String selectAllcustomerRecord(Order_inHours or,Model m,HttpServletRequest request, Alltable ata, String page){
		    long pid = (long)request.getSession().getAttribute("power_id");
			ata.setPower_id(pid);
			List<Alltable> alist = adservice.isSelectOperateInPower(ata);
			m.addAttribute("kzlist", alist); 
		
			int intPage;
			if(page == "" || page == null ){
				 intPage=1;
			}else{
				intPage=Integer.parseInt(page);
			}
			
			Map<String,Object> paramMap =new  HashMap<String,Object>(); 
			paramMap.put("true_name", or.getTrue_name());
			paramMap.put("user_idCardNumber", or.getUser_idCardNumber());
			paramMap.put("tel_number", or.getTel_number());
			
			paramMap.put("page", intPage);
			paramMap.put("pageIndex", (intPage-1)*pageSize);//每页第一个结果的下角标
			paramMap.put("pageSize", pageSize);//每页多少条结果
			
			int total = crservice.crselectCustomerRecordTotal(paramMap);
			int maxpage = (total % pageSize == 0) ? (total / pageSize) : (total / pageSize + 1);
			paramMap.put("maxpage", maxpage);
			
			List<Order_inHours> list = crservice.selectRecordByCondition(paramMap);
			m.addAttribute("svo", paramMap);
			m.addAttribute("crlist", list);
			return "allCustomerRecord";
	}
	  
	  /**
	   * 查询某条记录的详情
	   * @param order_number
	   * @param m
	   * @param request
	   * @param ata
	   * @param page
	   * @return
	   */
	  @RequestMapping("/recordDetail.do")
	  public String selectRecordDetail(String order_number, Model m,HttpServletRequest request, Alltable ata, String page){
		long pid = (long)request.getSession().getAttribute("power_id");
		ata.setPower_id(pid);
		List<Alltable> alist = adservice.isSelectOperateInPower(ata);
		m.addAttribute("kzlist", alist); 

		Map<String,Object> paramMap =new  HashMap<String,Object>(); 
		paramMap.put("order_number", order_number);
		
		Car c = crservice.selectCarByOrder_number(paramMap);
		Housing h = crservice.selectHouseByOrder_number(paramMap);	
		
		if(c != null){
			m.addAttribute("car", c);
			return "customerRecordCarDetail";
		}else {
			m.addAttribute("house", h);
			return "customerRecordHouseDetail";	
		}
		
	}
	  /**
	   * 查询车辆贷款记录
	   * @param c
	   * @param m
	   * @param request
	   * @param ata
	   * @param page
	   * @return
	   */
	  @RequestMapping("/carRecord.do")
	  public String selectCarRecord(Car c, Model m,HttpServletRequest request, Alltable ata, String page){
		long pid = (long)request.getSession().getAttribute("power_id");
		ata.setPower_id(pid);
		List<Alltable> alist = adservice.isSelectOperateInPower(ata);
		m.addAttribute("kzlist", alist); 
		
		int intPage;
		if(page == "" || page == null ){
			 intPage=1;
			 
		}else{
			intPage=Integer.parseInt(page);
		}
		
		Map<String,Object> paramMap =new  HashMap<String,Object>(); 
		paramMap.put("carframe", c.getCarframe());
		
		paramMap.put("page", intPage);
		paramMap.put("pageIndex", (intPage-1)*pageSize);//每页第一个结果的下角标
		paramMap.put("pageSize", pageSize);//每页多少条结果
		
		int total = crservice.selectCarRecordTotal(paramMap);
		int maxpage = (total % pageSize == 0) ? (total / pageSize) : (total / pageSize + 1);
		paramMap.put("maxpage", maxpage);
		
		List<Car> clist = crservice.selectCarByCondition(paramMap);
		for(Car car : clist){
			String on = car.getOrder_number();
			Map<String,Object> paramMap2 =new  HashMap<String,Object>();
			paramMap2.put("order_number", on);
			Order_inHours oi = crservice.selectOrder_inhoursByNum(paramMap2);
			car.setTrue_name(oi.getTrue_name());
			car.setTel_number(oi.getTel_number());
			car.setUser_idCardNumber(oi.getUser_idCardNumber());
			car.setAdd_time(oi.getAdd_time());
			car.setStatus(oi.getStatus());
			//System.out.println(oi.getStatus());
		}
		
		m.addAttribute("crlist", clist);
		m.addAttribute("svo", paramMap);
		//m.addAttribute("house", h);
		
		return "carRecord";
		
	}
	  
	  /**
	   * 查询房屋贷款记录
	   * @param h
	   * @param m
	   * @param request
	   * @param ata
	   * @param page
	   * @return
	   */
	  @RequestMapping("/houseRecord.do")
	  public String selectHouseRecord(Housing h, Model m,HttpServletRequest request, Alltable ata, String page){
		long pid = (long)request.getSession().getAttribute("power_id");
		ata.setPower_id(pid);
		List<Alltable> alist = adservice.isSelectOperateInPower(ata);
		m.addAttribute("kzlist", alist); 
		
		int intPage;
		if(page == "" || page == null ){
			 intPage=1;
		}else{
			intPage=Integer.parseInt(page);
		}
		
		Map<String,Object> paramMap =new  HashMap<String,Object>(); 
		paramMap.put("housingFCZ", h.getHousingFCZ());
		
		paramMap.put("page", intPage);
		paramMap.put("pageIndex", (intPage-1)*pageSize);//每页第一个结果的下角标
		paramMap.put("pageSize", pageSize);//每页多少条结果
		
		int total = crservice.selectHouseRecordTotal(paramMap);
		int maxpage = (total % pageSize == 0) ? (total / pageSize) : (total / pageSize + 1);
		paramMap.put("maxpage", maxpage);
		
		List<Housing> hlist = crservice.selectHouseByCondition(paramMap);
		for(Housing hou : hlist){
			String on = hou.getOrder_number();
			Map<String,Object> paramMap3 =new  HashMap<String,Object>();
			paramMap3.put("order_number", on);
			Order_inHours oi = crservice.selectOrder_inhoursByNum(paramMap3);
			hou.setTrue_name(oi.getTrue_name());
			hou.setTel_number(oi.getTel_number());
			hou.setUser_idCardNumber(oi.getUser_idCardNumber());
			hou.setAdd_time(oi.getAdd_time());
			hou.setStatus(oi.getStatus());
			//System.out.println(oi.getStatus());
		}
		
		m.addAttribute("crlist", hlist);
		m.addAttribute("svo", paramMap);
		//m.addAttribute("house", h);
		
		return "houseRecord";
		
	}
	  
	  /**
	   * 查看房屋图片
	   * @param h
	   * @param m
	   * @param request
	   * @param ata
	   * @param page
	   * @return
	   */
	  @RequestMapping("/housePhoto.do")
	  public String selectHousePicture(Housing h, Model m,HttpServletRequest request, Alltable ata, String page){
		long pid = (long)request.getSession().getAttribute("power_id");
		ata.setPower_id(pid);
		List<Alltable> alist = adservice.isSelectOperateInPower(ata);
		m.addAttribute("kzlist", alist); 
		
		Map<String,Object> paramMap =new  HashMap<String,Object>(); 
		paramMap.put("order_number", h.getOrder_number());
		System.out.println(h.getOrder_number());
		List<Img_forhouse> hlist = crservice.selectHouse(paramMap);
		System.out.println(hlist);
		m.addAttribute("hlist", hlist);
		
		return "housePhoto";
		
	}
	  
	  /**
	   * 查看车辆图片
	   * @param c
	   * @param m
	   * @param request
	   * @param ata
	   * @param page
	   * @return
	   */
	  @RequestMapping("/carPhoto.do")
	  public String selectCarPicture(Car c, Model m,HttpServletRequest request, Alltable ata, String page){
		long pid = (long)request.getSession().getAttribute("power_id");
		ata.setPower_id(pid);
		List<Alltable> alist = adservice.isSelectOperateInPower(ata);
		m.addAttribute("kzlist", alist); 
		
		Map<String,Object> paramMap =new  HashMap<String,Object>(); 
		paramMap.put("order_number", c.getOrder_number());
		List<Img_forcar> clist = crservice.selectCar(paramMap);
		
		m.addAttribute("clist", clist);
		
		return "carPhoto";
		
	}

	  
}
