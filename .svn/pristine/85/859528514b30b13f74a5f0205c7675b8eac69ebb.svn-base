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

import com.zp.jdb.dao.System_JournalDao;
import com.zp.jdb.entity.Administrators;
import com.zp.jdb.entity.Alltable;
import com.zp.jdb.entity.Organization;
import com.zp.jdb.entity.Production;
import com.zp.jdb.entity.System_Journal;
import com.zp.jdb.service.AdminService;
import com.zp.jdb.service.OrganizationService;
import com.zp.jdb.service.ProductionService;
import com.zp.jdb.service.System_JournalService;

@Controller
public class ProductionControllor{
	private Integer pageSize=10;//每页几个结果
	@Resource
	private ProductionService service;
	
	@Resource
	private OrganizationService oservice;
	
	@Resource
	private AdminService adservice;
	
	@Resource
	private System_JournalService sjservice;

	/**
	 * 查询该机构下所有产品，机构管理员查询某机构下的所有产品
	 * @param orgId
	 * @param page
	 * @param m
	 * @param request
	 * @param ata
	 * @return
	 */
	  @RequestMapping("/selectAllPro.do")
	  public String selectProductionsByCondition(Integer orgId, String page, Model m,HttpServletRequest request, Alltable ata){
		  
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
		paramMap.put("page", intPage);//第几页
		paramMap.put("pageIndex", (intPage-1)*pageSize);//每页第一个结果的下角标
		paramMap.put("pageSize", pageSize);//每页多少条结果
		paramMap.put("orgId", orgId);
		
		
		int total = service.selectProductionTotal(paramMap);//结果总条数
		int maxpage = (total % pageSize == 0) ? (total / pageSize) : (total / pageSize + 1);//最大页码
		paramMap.put("maxpage", maxpage);
		
		//Organization o = oservice.selectOrganizationByID(orgId);
		//paramMap.put("orgName", o.getOrgName());
		
		List<Production> list = service.selectProductionByOrgId(paramMap);
		for(Production p : list){
			Organization o = oservice.selectOrganizationByID(p.getOrgId());
			p.setOrgName(o.getOrgName());
			
		}
		
		m.addAttribute("plist", list);
		
		m.addAttribute("svo", paramMap);
		
		return "organization/production";
	}
	  
	  /**
	   * 产品管理员的产品操作，只能查询该机构下产品的操作，不能查询其他机构的产品
	   * @param page
	   * @param m
	   * @param request
	   * @param ata
	   * @return
	   */
	  @RequestMapping("/selectAllPro2.do")
	  public String selectProductionsByCondition2(String page, Model m, HttpServletRequest request,Alltable ata){
		long pid = (long)request.getSession().getAttribute("power_id");
	    ata.setPower_id(pid);
		List<Alltable> alist = adservice.isSelectOperateInPower(ata);
		m.addAttribute("kzlist", alist); 
		long id = (Long) request.getSession().getAttribute("user_id");
		int user_id = (int)id;
		
		String orgId = oservice.selectOrgByUser(user_id);
		if(orgId.equals("0,")){//判断用户所属机构，管理员所属机构id为0，可以查看所有机构的产品
			return "redirect:/selectPro.do";
			
		}
		
		if(orgId.equals("-1,")){
			Map<String,Object> paramMappage =new  HashMap<String,Object>(); 
			paramMappage.put("maxpage", 1);
			paramMappage.put("page", 1);
			m.addAttribute("svo", paramMappage);
			return "organization/production";
		}
		
		else{//非管理员只能查看自己机构下的产品
			
		  int intPage;
			if(page == "" || page == null ){
				 intPage=1;
			}else{
				intPage=Integer.parseInt(page);
			} 
		Map<String,Object> paramMap =new  HashMap<String,Object>();	
		paramMap.put("page", intPage);//第几页
		paramMap.put("pageIndex", (intPage-1)*pageSize);//每页第一个结果的下角标
		paramMap.put("pageSize", pageSize);//每页多少条结果
		paramMap.put("orgId", orgId.substring(0,orgId.lastIndexOf(",")));
		
		int total = service.selectProductionTotal(paramMap);//结果总条数
		int maxpage = (total % pageSize == 0) ? (total / pageSize) : (total / pageSize + 1);//最大页码
		paramMap.put("maxpage", maxpage);
		
//		Organization o = oservice.selectOrganizationByID(orgId);
//		
//		paramMap.put("orgName", o.getOrgName());
		
		List<Production> list = service.selectProductionByOrgId3(paramMap);
		for(Production p : list){
			Organization o = oservice.selectOrganizationByID(p.getOrgId());
			p.setOrgName(o.getOrgName());
			
		}
		
		paramMap.put("orgId", "");
		
		if(list.isEmpty()){
			paramMap.put("maxpage", 1);
			paramMap.put("page", 1);
		}
		
		m.addAttribute("plist", list);
		
		m.addAttribute("svo", paramMap);
		
		return "organization/production";
		}
	}
	    
	  /**
	   * 条件查询产品
	   * @param pro
	   * @param page
	   * @param m
	   * @param request
	   * @param ata
	   * @return
	   */
		@RequestMapping("/selectPro.do")
		public String selectOrganizationsByCondition(Production pro, String page, Model m,HttpServletRequest request,Alltable ata){
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
            
			paramMap.put("page", intPage);//第几页
			paramMap.put("pageIndex", (intPage-1)*pageSize);//每页第一个结果的下角标
			paramMap.put("pageSize", pageSize);//每页多少条结果
			
			paramMap.put("proId", pro.getProId());
			paramMap.put("proName", pro.getProName());
			paramMap.put("orgId", pro.getOrgId());
			paramMap.put("area", pro.getArea());
			
			int total = service.selectProductionTotal3(paramMap);
			int maxpage = (total % pageSize == 0) ? (total / pageSize) : (total / pageSize + 1);
			paramMap.put("maxpage", maxpage);
			
			List<Production> list = service.selectProductionsByCondition(paramMap);
			for(Production p : list){
			    
				Organization o = oservice.selectOrganizationByID(p.getOrgId());
				p.setOrgName(o.getOrgName());
				
			}

			
			//Organization o = oservice.selectOrganizationByID(pro.getOrgId());
			//paramMap.put("orgName", o.getOrgName());
			
			if(list.isEmpty()){
				paramMap.put("maxpage", 1);
				paramMap.put("page", 1);
			}
			
			m.addAttribute("plist", list);
			m.addAttribute("svo", paramMap);
			
			return "organization/selectPro";
		}
		
		/**
		 * 条件查询该机构下的产品
		 * @param ata
		 * @param pro
		 * @param page
		 * @param m
		 * @param req
		 * @return
		 */
		@RequestMapping("/selectPro2.do")
		public String selectOrganizationsByCondition2(Alltable ata, Production pro, String page, Model m,HttpServletRequest req){
			    long pid = (long)req.getSession().getAttribute("power_id");
				ata.setPower_id(pid);
				List<Alltable> alist = adservice.isSelectOperateInPower(ata);
				m.addAttribute("kzlist", alist);
			if(pro.getOrgId() == null){
				long id = (Long) req.getSession().getAttribute("user_id");
				int user_id = (int)id;
				String orgId = oservice.selectOrgByUser(user_id);
				int intPage;
				if(page == "" || page == null ){
					 intPage=1;
				}else{
					intPage=Integer.parseInt(page);
				}
				
				if(orgId.equals("0,")){
					Map<String,Object> paramMap =new  HashMap<String,Object>(); 
		            
					paramMap.put("page", intPage);//第几页
					paramMap.put("pageIndex", (intPage-1)*pageSize);//每页第一个结果的下角标
					paramMap.put("pageSize", pageSize);//每页多少条结果
					paramMap.put("orgId", pro.getOrgId());
					paramMap.put("proId", pro.getProId());
					paramMap.put("proName", pro.getProName());
					paramMap.put("area", pro.getArea());
					
					List<Production> list = service.selectProductionsByCondition(paramMap);
					for(Production p : list){
						Organization o = oservice.selectOrganizationByID(p.getOrgId());
						p.setOrgName(o.getOrgName());
						
					}
					int total = service.selectProductionTotal(paramMap);
					int maxpage = (total % pageSize == 0) ? (total / pageSize) : (total / pageSize + 1);
					paramMap.put("maxpage", maxpage);
					
					Organization o = oservice.selectOrganizationByID(pro.getOrgId());
					paramMap.put("orgName", o.getOrgName());

					if(list.isEmpty()){
						paramMap.put("maxpage", 1);
						paramMap.put("page", 1);
					}
					
					m.addAttribute("plist", list);
					m.addAttribute("svo", paramMap);
					
					//return "organization/production";
				}
				if(orgId.equals("-1,")){
					Map<String,Object> paramMappage =new  HashMap<String,Object>(); 
					paramMappage.put("maxpage", 1);
					paramMappage.put("page", 1);
					m.addAttribute("svo", paramMappage);
				}
				
				else{
				Map<String,Object> paramMap =new  HashMap<String,Object>(); 
	            
				paramMap.put("page", intPage);//第几页
				paramMap.put("pageIndex", (intPage-1)*pageSize);//每页第一个结果的下角标
				paramMap.put("pageSize", pageSize);//每页多少条结果
				paramMap.put("orgId", orgId.substring(0,orgId.lastIndexOf(",")));
				paramMap.put("proId", pro.getProId());
				paramMap.put("proName", pro.getProName());
				paramMap.put("area", pro.getArea());
				
				List<Production> list = service.selectProductionsByCondition3(paramMap);
				for(Production p : list){
					Organization o = oservice.selectOrganizationByID(p.getOrgId());
					p.setOrgName(o.getOrgName());
					
				}
				int total = service.selectProductionTotal3(paramMap);
				int maxpage = (total % pageSize == 0) ? (total / pageSize) : (total / pageSize + 1);
				paramMap.put("maxpage", maxpage);
				
//				Organization o = oservice.selectOrganizationByID(orgId);
//				paramMap.put("orgName", o.getOrgName());
				
				paramMap.put("orgId", "");
				
				if(list.isEmpty()){
					paramMap.put("maxpage", 1);
					paramMap.put("page", 1);
				}
				
				m.addAttribute("plist", list);
				m.addAttribute("svo", paramMap);
				
				//return "organization/production";
				}
				
				return "organization/production";
			}else{
				int intPage;
				if(page == "" || page == null ){
					 intPage=1;
				}else{
					intPage=Integer.parseInt(page);
				}
				
                Map<String,Object> paramMap =new  HashMap<String,Object>(); 
	            
				paramMap.put("page", intPage);//第几页
				paramMap.put("pageIndex", (intPage-1)*pageSize);//每页第一个结果的下角标
				paramMap.put("pageSize", pageSize);//每页多少条结果
				paramMap.put("orgId", pro.getOrgId());
				paramMap.put("proId", pro.getProId());
				paramMap.put("proName", pro.getProName());
				paramMap.put("area", pro.getArea());
				
				List<Production> list = service.selectProductionsByCondition(paramMap);
				for(Production p : list){
					Organization o = oservice.selectOrganizationByID(p.getOrgId());
					p.setOrgName(o.getOrgName());
					
				}
				int total = service.selectProductionTotal(paramMap);
				int maxpage = (total % pageSize == 0) ? (total / pageSize) : (total / pageSize + 1);
				paramMap.put("maxpage", maxpage);
				
//				Organization o = oservice.selectOrganizationByID(orgId);
//				paramMap.put("orgName", o.getOrgName());
				
				if(list.isEmpty()){
					paramMap.put("maxpage", 1);
					paramMap.put("page", 1);
				}
				
				m.addAttribute("plist", list);
				m.addAttribute("svo", paramMap);
				return "organization/production";
			}
			
		}
		
		
		/**
		 * 删除产品，更改产品isdel
		 * @param pro
		 * @param request
		 * @param ata
		 * @param m
		 * @return
		 */
		@RequestMapping("/updateProIsdel.do")
		public String updateProductionIsdelByID(Production pro, HttpServletRequest request, Alltable ata, Model m){
			    long pid = (long)request.getSession().getAttribute("power_id");
				ata.setPower_id(pid);
				List<Alltable> alist = adservice.isSelectOperateInPower(ata);
				m.addAttribute("kzlist", alist);
			Map<String,Object> paramMap =new  HashMap<String,Object>(); 
			paramMap.put("proId", pro.getProId());
			paramMap.put("isdel", pro.getIsdel());

			service.updateProductionIsdelByID(paramMap);
			
			Production p = service.selectProductionByID(pro.getProId());
			
	        //操作记录
	        System_Journal sj = new System_Journal();
	        sj.setDate(new Date());
	        sj.setModule("机构管理");
	        sj.setOperation_content("删除产品"+p.getProName());
	        long id = (Long) request.getSession().getAttribute("user_id");
	        Administrators ad = oservice.findById(id);
	        String name = ad.getLoginName();
	        sj.setOperator(name);
	        sj.setType("删除");
	        try {
				sjservice.addJournal(sj);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			//删除某个产品后，判断该机构是否还存在产品
			int i =service.countProductionByOrg(pro.getOrgId());
			
			if(i == 0){//如果不存在，则将该机构状态改为伪开通
				oservice.updateOrganizationState2ByID(pro.getOrgId());
			}


			
			return "redirect:/selectPro.do";
		}
		
		/**
		 * 删除该机构下的产品，更改产品isdel
		 * @param pro
		 * @param request
		 * @return
		 */
		@RequestMapping("/updateProIsdel2.do")
		public String updateProductionIsdelByID2(Production pro, HttpServletRequest request){
			
			Map<String,Object> paramMap =new  HashMap<String,Object>(); 
			paramMap.put("proId", pro.getProId());
			paramMap.put("isdel", pro.getIsdel());
			
			service.updateProductionIsdelByID(paramMap);
			
	        //操作记录
	        System_Journal sj = new System_Journal();
	        sj.setDate(new Date());
	        sj.setModule("机构管理");
	        sj.setOperation_content("删除产品");
	        long id = (Long) request.getSession().getAttribute("user_id");
	        Administrators ad = oservice.findById(id);
	        String name = ad.getLoginName();
	        sj.setOperator(name);
	        sj.setType("删除");
	        try {
				sjservice.addJournal(sj);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//删除某个产品后，判断该机构是否还存在产品
			int i =service.countProductionByOrg(pro.getOrgId());
			
			if(i == 0){//如果不存在，则将该机构状态改为伪开通
				oservice.updateOrganizationState2ByID(pro.getOrgId());
			}
			
			return "redirect:/selectAllPro2.do";
		}
		
		/**
		 * 跳转到产品入驻界面
		 * @param m
		 * @param request
		 * @param ata
		 * @return
		 */
		@RequestMapping("/insertProjsp.do")
		public String insertOrgjsp(Model m,HttpServletRequest request, Alltable ata){
			
		    long pid = (long)request.getSession().getAttribute("power_id");
		    ata.setPower_id(pid);
		    List<Alltable> alist = adservice.isSelectOperateInPower(ata);
			m.addAttribute("kzlist", alist);
			long id = (Long) request.getSession().getAttribute("user_id");
			int user_id = (int)id;
			
			String orgId = oservice.selectOrgByUser(user_id);
			if(orgId.equals("0,")){//管理员可以在任意机构下添加产品
				List<Organization> olist = oservice.selectExistOrgList();
				m.addAttribute("olist", olist);
				return "organization/insertPro";
			}else{//机构管理员只可以在本机构下添加产品
				//Organization o = oservice.selectOrganizationByID(orgId);
				//List<Organization> olist = new LinkedList<Organization>();
				//olist.add(o);
				Map<String,Object> paramMap =new  HashMap<String,Object>();
				paramMap.put("orgId", orgId.substring(0,orgId.lastIndexOf(",")));
				List<Organization> olist = oservice.selectExistOrgList2(paramMap);
				m.addAttribute("olist", olist);
				return "organization/insertPro";
			}
			
			
		}
		
		/**
		 * 产品入驻
		 * @param pro
		 * @param request
		 * @return
		 */
		@RequestMapping("/insertPro.do")
		public String insertOrganization(Production pro,HttpServletRequest request){
			
			Map<String,Object> paramMap =new  HashMap<String,Object>();

			paramMap.put("applyNum", pro.getApplyNum());
			paramMap.put("area", pro.getArea());
			paramMap.put("checkListTime", pro.getCheckListTime());
			paramMap.put("fitPeople", pro.getFitPeople());
			paramMap.put("isdel", pro.getIsdel());
			paramMap.put("loanAvgTime", pro.getLoanAvgTime());
			paramMap.put("orgId", pro.getOrgId());
			paramMap.put("proId", pro.getProId());
			paramMap.put("proName", pro.getProName());
			paramMap.put("rebateLimit", pro.getRebateLimit());
			
			service.insertProduction(paramMap);
			
	        //操作记录
	        System_Journal sj = new System_Journal();
	        sj.setDate(new Date());
	        sj.setModule("机构管理");
	        sj.setOperation_content("增加产品"+pro.getProName());
	        long id = (Long) request.getSession().getAttribute("user_id");
	        Administrators ad = oservice.findById(id);
	        String name = ad.getLoginName();
	        sj.setOperator(name);
	        sj.setType("增加");
	        try {
				sjservice.addJournal(sj);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//增加某个产品后，判断该机构是否存在产品
			
			int i =service.countProductionByOrg(pro.getOrgId());
			
			if(i != 0){//如果存在，则将该机构状态改为开通
				oservice.updateOrganizationState0ByID(pro.getOrgId());
			}
//			//取产品的最大返点最为机构的最高返点
//			Map<String,Object> paramMapO =new  HashMap<String,Object>();
//			int maxrebate = service.selectMaxRebate(pro.getOrgId());
//			paramMapO.put("maxrebate", maxrebate);
//			paramMapO.put("orgId", pro.getOrgId());
//			oservice.updateOrganizationRebateByID(paramMapO);
			return "redirect:/selectAllPro2.do";
		}
		
		/**
		 * 把要更改的产品信息发到更改界面更上
		 * @param proId
		 * @param m
		 * @param request
		 * @param ata
		 * @return
		 * @throws Exception
		 */
		@RequestMapping("/entryUpdatePro.do")
		public String entryUpdatePro(Integer proId, Model m,HttpServletRequest request,Alltable ata) throws Exception{
			
			long pid = (long)request.getSession().getAttribute("power_id");
		    ata.setPower_id(pid);
		    List<Alltable> alist = adservice.isSelectOperateInPower(ata);
			m.addAttribute("kzlist", alist);
			System.out.println(proId);
			Production p = null;
			if(proId != null){
				p = service.selectProductionByID(proId);
			}
			
			long id = (Long) request.getSession().getAttribute("user_id");
			int user_id = (int)id;
			
			String orgId = oservice.selectOrgByUser(user_id);
			if(orgId.equals("0,")){//管理员可以将某个机构下的产品转移到另一个机构下
				List<Organization> olist = oservice.selectExistOrgList();
				m.addAttribute("production", p);
				m.addAttribute("olist", olist);
				return "organization/entryUpdatePro";

			}else{//机构管理员不可以修改产品所属机构
				//Organization o = oservice.selectOrganizationByID(orgId);
				//List<Organization> olist = new LinkedList<Organization>();
				//olist.add(o);
				Map<String,Object> paramMap =new  HashMap<String,Object>();
				paramMap.put("orgId", orgId.substring(0,orgId.lastIndexOf(",")));
				List<Organization> olist = oservice.selectExistOrgList2(paramMap);
				m.addAttribute("production", p);
				m.addAttribute("olist", olist);
				return "organization/entryUpdatePro";
			}
				
		}
		
		/**
		 * 更改产品信息
		 * @param pro
		 * @param request
		 * @param ata
		 * @param m
		 * @param page
		 * @return
		 */
		@RequestMapping("/updatePro.do")
		public String updateProduction(Production pro, HttpServletRequest request, Alltable ata, Model m,String page){
			
			long pid = (long)request.getSession().getAttribute("power_id");
		    ata.setPower_id(pid);
		    List<Alltable> alist = adservice.isSelectOperateInPower(ata);
			m.addAttribute("kzlist", alist);
			
			Map<String,Object> paramMap =new  HashMap<String,Object>();
			
			paramMap.put("applyNum", pro.getApplyNum());
			paramMap.put("area", pro.getArea());
			paramMap.put("checkListTime", pro.getCheckListTime());
			paramMap.put("costId", pro.getCostId());
			paramMap.put("fitPeople", pro.getFitPeople());
			paramMap.put("loanAvgTime", pro.getLoanAvgTime());
			paramMap.put("orgId", pro.getOrgId());
			paramMap.put("proId", pro.getProId());
			paramMap.put("proName", pro.getProName());
			paramMap.put("rebateLimit", pro.getRebateLimit());
			
			
			service.updateProduction(paramMap);
			
	        //操作记录
	        System_Journal sj = new System_Journal();
	        sj.setDate(new Date());
	        sj.setModule("机构管理");
	        sj.setOperation_content("修改产品"+pro.getProName()+"的信息");
	        long id = (Long) request.getSession().getAttribute("user_id");
	        Administrators ad = oservice.findById(id);
	        String name = ad.getLoginName();
	        sj.setOperator(name);
	        sj.setType("修改");
	        try {
				sjservice.addJournal(sj);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//取产品的最大返点最为机构的最高返点
			Map<String,Object> paramMapO =new  HashMap<String,Object>();
			Double maxrebate = service.selectMaxRebate(pro.getOrgId());
			
			paramMapO.put("maxrebate", maxrebate);
			paramMapO.put("orgId", pro.getOrgId());
			oservice.updateOrganizationRebateByID(paramMapO);
			
			int user_id = (int)id;
			String orgId = oservice.selectOrgByUser(user_id);
			if(orgId.equals("0,")){//判断用户所属机构，管理员所属机构id为0，可以查看所有机构的产品
				
				m.addAttribute("orgId", pro.getOrgId());
				return"redirect:/selectAllPro.do";
			}
			
			if(orgId.equals("-1,")){
				Map<String,Object> paramMappage =new  HashMap<String,Object>(); 
				paramMappage.put("maxpage", 1);
				paramMappage.put("page", 1);
				m.addAttribute("svo", paramMappage);
				return "organization/production";
			}
			
			else{//非管理员只能查看自己机构下的产品
				
				
				  int intPage;
					if(page == "" || page == null ){
						 intPage=1;
					}else{
						intPage=Integer.parseInt(page);
					} 
				Map<String,Object> paramMap2 =new  HashMap<String,Object>();	
				paramMap2.put("page", intPage);//第几页
				paramMap2.put("pageIndex", (intPage-1)*pageSize);//每页第一个结果的下角标
				paramMap2.put("pageSize", pageSize);//每页多少条结果
				paramMap2.put("orgId", orgId.substring(0,orgId.lastIndexOf(",")));
				
				
				int total = service.selectProductionTotal3(paramMap2);//结果总条数
				int maxpage = (total % pageSize == 0) ? (total / pageSize) : (total / pageSize + 1);//最大页码
				paramMap2.put("maxpage", maxpage);
				
//				Organization o = oservice.selectOrganizationByID(orgId);
//				paramMap.put("orgName", o.getOrgName());
				
				List<Production> list = service.selectProductionsByCondition3(paramMap2);
				
				m.addAttribute("plist", list);
				
				m.addAttribute("svo", paramMap2);
				
				return "organization/production";
				
				
			}
		
		}
		
		/**
		 * 产品上下架
		 * @param pro
		 * @param request
		 * @return
		 */
	    @RequestMapping("/updateProState.do")
		public String updateProductionStateByID(Production pro, HttpServletRequest request){
					
					Map<String,Object> paramMap =new  HashMap<String,Object>(); 
					paramMap.put("proId", pro.getProId());
					paramMap.put("statements", pro.getStatements());
					
					service.updateProductionStateByID(paramMap);
					Production p = service.selectProductionByID(pro.getProId());
					
			        //操作记录
			        System_Journal sj = new System_Journal();
			        sj.setDate(new Date());
			        sj.setModule("机构管理");
			        sj.setOperation_content("修改产品"+p.getProName()+"的状态");
			        long id = (Long) request.getSession().getAttribute("user_id");
			        Administrators ad = oservice.findById(id);
			        String name = ad.getLoginName();
			        sj.setOperator(name);
			        sj.setType("修改");
			        try {
						sjservice.addJournal(sj);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					
					//取产品的最大返点最为机构的最高返点
					Map<String,Object> paramMapO =new  HashMap<String,Object>();
					Double maxrebate = service.selectMaxRebate(pro.getOrgId());
					
					paramMapO.put("maxrebate", maxrebate);
					paramMapO.put("orgId", pro.getOrgId());
					oservice.updateOrganizationRebateByID(paramMapO);
					
					//冻结某个产品后，判断该机构是否还存在产品
					int i =service.countProductionByOrg(pro.getOrgId());
					
					if(i == 0){//如果不存在，则将该机构状态改为伪开通
						oservice.updateOrganizationState2ByID(pro.getOrgId());
					}else{//如果存在，则将机构改为已开通
						oservice.updateOrganizationState0ByID(pro.getOrgId());
					}

					return "redirect:/selectAllPro2.do";
					
					
				}
		
		
		
	

}
