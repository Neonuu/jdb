package com.zp.jdb.controllor;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.zp.jdb.dao.CommissionDao;
import com.zp.jdb.dao.System_JournalDao;
import com.zp.jdb.entity.Administrators;
import com.zp.jdb.entity.Alltable;
import com.zp.jdb.entity.Commission;
import com.zp.jdb.entity.Commission_detail;
import com.zp.jdb.entity.Organization;
import com.zp.jdb.entity.System_Journal;
import com.zp.jdb.entity.User_Org;
import com.zp.jdb.entity.User;
import com.zp.jdb.service.AdminService;
import com.zp.jdb.service.CommissionService;
import com.zp.jdb.service.OrganizationService;
import com.zp.jdb.service.ProductionService;
import com.zp.jdb.service.System_JournalService;
import com.zp.jdb.service.TixianService;


@Controller
public class TixianControllor {
	private Integer pageSize=10;//每页几个结果
	@Resource
	private TixianService service;
	
	@Resource
	private AdminService adservice;
	
	@Resource
	private System_JournalService sjservice;
	
	@Resource
	private OrganizationService oservice;
	
	@Resource
	private CommissionDao dao;
	
	@Resource
	private CommissionService commservice;
	
	
	/**
	 * 条件查询提现
	 * @param org
	 * @param page
	 * @param m
	 * @param ata
	 * @param request
	 * @return
	 */
	@RequestMapping("/tixian.do")
	public String selectTixianByCondition(String page, String user_name, String mark, Model m,Alltable ata,HttpServletRequest request){


		if(user_name == null || user_name == ""){
			
			int intPage;
			if(page == "" || page == null ){
				 intPage=1;
			}else{
				intPage=Integer.parseInt(page);
			}
			Map<String,Object> paramMap =new  HashMap<String,Object>();
			paramMap.put("page", intPage);
			paramMap.put("pageIndex", (intPage-1)*pageSize);//每页第一个结果的下角标
			paramMap.put("pageSize", pageSize);//每页多少条结果
			
			paramMap.put("mark", mark);
			
			int total = service.selectTixianTotal(paramMap);
			int maxpage = (total % pageSize == 0) ? (total / pageSize) : (total / pageSize + 1);
			paramMap.put("maxpage", maxpage);
			
			
			
			List<Commission_detail> clist = service.selectTixian(paramMap);
			for(Commission_detail cod : clist){
				User u = service.selectUserByID(cod.getUser_id());
				cod.setUser_name(u.getUser_name());
				cod.setPhone(u.getPhoneNumber());
				
				
			}
			
			m.addAttribute("alist",clist);
			m.addAttribute("svo", paramMap);
			
		}else{
			
			int intPage;
			if(page == "" || page == null ){
				 intPage=1;
			}else{
				System.out.println("页码："+page);
				intPage=Integer.parseInt(page);
			}
			
			User user = new User();
			user.setUser_name(user_name);
			List<User> ulist = service.selectUserByName(user);
			if(!ulist.isEmpty()){//用户名存在
				
				String s = "";
				for(User u : ulist){
					s+=u.getUser_id()+",";
					
				}
				String s2 = s.substring(0, s.lastIndexOf(","));
				
				Map<String,Object> paramMap =new HashMap<String,Object>();
				

				
				paramMap.put("user_id", s2);
				paramMap.put("user_name", user_name);
				paramMap.put("mark", mark);
				
				paramMap.put("page", intPage);
				paramMap.put("pageIndex", (intPage-1)*pageSize);//每页第一个结果的下角标
				paramMap.put("pageSize", pageSize);//每页多少条结果
				
				int total = service.selectTixianTotal(paramMap);
				int maxpage = (total % pageSize == 0) ? (total / pageSize) : (total / pageSize + 1);
				paramMap.put("maxpage", maxpage);
				
				List<Commission_detail> clist = service.selectTixian(paramMap);
				
				for(Commission_detail cod : clist){
					User u = service.selectUserByID(cod.getUser_id());
					cod.setUser_name(u.getUser_name());
					
				}
				
				m.addAttribute("alist",clist);
				m.addAttribute("svo", paramMap);
				
			}else{//用户名不存在
				Map<String,Object> paramMap =new HashMap<String,Object>();
				
				paramMap.put("user_name", user_name);
				paramMap.put("mark", mark);
				
				paramMap.put("page", 1);
				paramMap.put("maxpage", 1);
				
				m.addAttribute("svo", paramMap);
								
			}
			
		}
		
		return "savemoney"; 		
	}
	
	/**
	 * 修改提现状态
	 * @param cd
	 * @param page
	 * @param m
	 * @param ata
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateTixianMark.do")
	public String updateTixianMark(Commission_detail cd, String page,  Model m,Alltable ata,HttpServletRequest request){

		long pid = (long)request.getSession().getAttribute("power_id");
		ata.setPower_id(pid);
		List<Alltable> alist = adservice.isSelectOperateInPower(ata);
		m.addAttribute("kzlist", alist);
		
//		long id = (Long) request.getSession().getAttribute("user_id");
//		int user_id = (int)id;
//		String orgId = service.selectOrgByUser(user_id);
//		System.out.println(orgId);
		
		Map<String,Object> paramMap =new  HashMap<String,Object>();
		paramMap.put("id",cd.getId());
		paramMap.put("mark", cd.getMark());
		
		service.updateTixianMark(paramMap);
		
		User u = service.selectUserByID(cd.getUser_id());

        //操作记录
        System_Journal sj = new System_Journal();
        sj.setDate(new Date());
        sj.setModule("佣金提现管理");
        sj.setOperation_content("将(id为"+cd.getUser_id()+")用户名为"+u.getUser_name()+"的佣金提现");
        long id = (Long) request.getSession().getAttribute("user_id");
        Administrators ad = oservice.findById(id);
        String name = ad.getLoginName();
        sj.setOperator(name);
        sj.setType("佣金提现");
        try {
			sjservice.addJournal(sj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/tixian.do"; 		
	}
	
	/**
	 * 关闭提现原因
	 */
	@RequestMapping("/closeTixian.do")
	@ResponseBody
	public Map<String,Object> close(Long id,HttpServletRequest req,String remarks,Long user_id){
		Map<String,Object> resMap=new HashMap<String,Object>();
		try{
			Map<String,Object> paramMap =new  HashMap<String,Object>();
			paramMap.put("id",id);
			paramMap.put("reason", remarks);
			paramMap.put("mark",2);
			service.updateTixianMarkAndReason(paramMap);
			Commission_detail cd = service.selectmoneybyid(id);
			Commission com = dao.findById(user_id);
			BigDecimal cam = cd.getChange_amount();
			BigDecimal bal = com.getBalance();
			BigDecimal cubal = com.getCan_use_balance();
			
			BigDecimal newbal = bal.add(cam);
			BigDecimal newcubal = cubal.add(cam);
			
			Commission comm = new Commission();
			comm.setBalance(newbal);
			comm.setCan_use_balance(newcubal);
			comm.setUser_id(user_id);
			commservice.updateaddmoney(comm);
			
			User u = service.selectUserByID(user_id);
			
			
	        //操作记录
	        System_Journal sj = new System_Journal();
	        sj.setDate(new Date());
	        sj.setModule("佣金提现管理");
	        sj.setOperation_content("将(id为"+user_id+")用户名为"+u.getUser_name()+"的佣金提现关闭");
	        long id2 = (Long) req.getSession().getAttribute("user_id");
	        Administrators ad = oservice.findById(id2);
	        String name = ad.getLoginName();
	        sj.setOperator(name);
	        sj.setType("关闭提现");
	        try {
				sjservice.addJournal(sj);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e ){
			e.printStackTrace();
			resMap.put("err", "提交失败");
		}
		
		
		return resMap;
		
	}
	

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	

}
