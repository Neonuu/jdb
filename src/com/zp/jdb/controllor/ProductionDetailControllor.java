package com.zp.jdb.controllor;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zp.jdb.entity.Administrators;
import com.zp.jdb.entity.Alltable;
import com.zp.jdb.entity.Organization;
import com.zp.jdb.entity.Production;
import com.zp.jdb.entity.ProductionDetail;
import com.zp.jdb.entity.System_Journal;
import com.zp.jdb.service.AdminService;
import com.zp.jdb.service.OrganizationService;
import com.zp.jdb.service.ProductionDetailService;
import com.zp.jdb.service.ProductionService;
import com.zp.jdb.service.System_JournalService;

@Controller
public class ProductionDetailControllor{
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
	
	/**
	 * 查询该产品的详情
	 * @param proId
	 * @param m
	 * @param request
	 * @param ata
	 * @return
	 */
	  @RequestMapping("/proDetail.do")
	  public String selectProductionDetailByID(Integer proId, Model m,HttpServletRequest request, Alltable ata){
		
		long pid = (long)request.getSession().getAttribute("power_id");
		ata.setPower_id(pid);
		List<Alltable> alist = adservice.isSelectOperateInPower(ata);
		m.addAttribute("kzlist", alist); 
		
		Production p = pservice.selectProductionByID(proId);
		int o =p.getOrgId();
		
		
		ProductionDetail pd = service.selectProductionDetailByID(proId);
		if(pd != null){
			
			pd.setOrgId(o);
		}
		
		List<Organization> olist = oservice.selectExistOrgList();
		m.addAttribute("proId", proId);
		m.addAttribute("productionDetail", pd);
		m.addAttribute("olist", olist);
		
		return "organization/proDetail";
	}
	  
	  /**
	   * 更改产品详情
	   * @param pd
	   * @param request
	   * @return
	   */
		@RequestMapping("/updateProDetail.do")
		public String updateOrganization(ProductionDetail pd,HttpServletRequest request){
			int i = service.countProductionDetailById(pd.getProId());
			Map<String,Object> paramMap =new  HashMap<String,Object>();
			if(i == 1){//该产品存在产品详情，则更改
			 
			paramMap.put("applyCondition", pd.getApplyCondition());

			paramMap.put("creditRequest", pd.getCreditRequest());
			paramMap.put("deadline", pd.getDeadline());
			paramMap.put("fitPeople", pd.getFitPeople());
			paramMap.put("isdel", pd.getIsdel());
			paramMap.put("limitScope", pd.getLimitScope());
			paramMap.put("materialRequested", pd.getMaterialRequested());
			paramMap.put("orgId", pd.getOrgId());
			paramMap.put("proFeature", pd.getProFeature());
			paramMap.put("proId", pd.getProId());
			paramMap.put("proType", pd.getProType());
			paramMap.put("repaymentMode", pd.getRepaymentMode());
			paramMap.put("synthesisRate", pd.getSynthesisRate());
			paramMap.put("creditEnquiryCost", pd.getCreditEnquiryCost());
			paramMap.put("doorServiceCost", pd.getDoorServiceCost());
			paramMap.put("loanHandCost", pd.getLoanHandCost());

			service.updateProductionDetail(paramMap);
			
			Production p = pservice.selectProductionByID(pd.getProId());
			
	        //操作记录
	        System_Journal sj = new System_Journal();
	        sj.setDate(new Date());
	        sj.setModule("机构管理");
	        sj.setOperation_content("修改产品"+p.getProName()+"的详情");
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
	        
			}else{//该产品不存在产品详情，则新增
				paramMap.put("applyCondition", pd.getApplyCondition());
				//System.out.println("申请条件:"+paramMap.get("applyCondition"));
				paramMap.put("creditRequest", pd.getCreditRequest());
				paramMap.put("deadline", pd.getDeadline());
				paramMap.put("fitPeople", pd.getFitPeople());
				paramMap.put("isdel", pd.getIsdel());
				paramMap.put("limitScope", pd.getLimitScope());
				paramMap.put("materialRequested", pd.getMaterialRequested());
				paramMap.put("orgId", pd.getOrgId());
				paramMap.put("proFeature", pd.getProFeature());
				paramMap.put("proId", pd.getProId());
				paramMap.put("proType", pd.getProType());
				paramMap.put("repaymentMode", pd.getRepaymentMode());
				paramMap.put("synthesisRate", pd.getSynthesisRate());
				paramMap.put("creditEnquiryCost", pd.getCreditEnquiryCost());
				paramMap.put("doorServiceCost", pd.getDoorServiceCost());
				paramMap.put("loanHandCost", pd.getLoanHandCost());
				service.insertProductionDetail(paramMap);
				
				Production p = pservice.selectProductionByID(pd.getProId());
				
		        //操作记录
		        System_Journal sj = new System_Journal();
		        sj.setDate(new Date());
		        sj.setModule("机构管理");
		        sj.setOperation_content("增加产品"+p.getProName()+"的详情");
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
		        
				pservice.updateProductionState2ByID(pd.getProId());
				
				
		        //操作记录
		        System_Journal sj2 = new System_Journal();
		        sj2.setDate(new Date());
		        sj2.setModule("机构管理");
		        sj2.setOperation_content("修改产品"+p.getProName()+"的状态");
		        sj2.setOperator(name);
		        sj2.setType("修改");
		        try {
					sjservice.addJournal(sj2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("haha"+pd.getOrgId());
				int a = pservice.countProductionByOrg(pd.getOrgId());
				System.out.println("机构产品数"+a);
				if(a != 0){
					
					oservice.updateOrganizationState0ByID(pd.getOrgId());
				}
				
				//取产品的最大返点最为机构的最高返点
				Map<String,Object> paramMapO =new  HashMap<String,Object>();
				Double maxrebate = pservice.selectMaxRebate(pd.getOrgId());
				
				paramMapO.put("maxrebate", maxrebate);
				paramMapO.put("orgId", pd.getOrgId());
				oservice.updateOrganizationRebateByID(paramMapO);
				
			}
			return "redirect:/selectAllPro2.do";	
			
		}

}
