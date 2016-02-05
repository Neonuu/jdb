package com.zp.jdb.controllor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zp.jdb.entity.Alltable;
import com.zp.jdb.service.AdminService;
import com.zp.jdb.service.CommissionService;
import com.zp.jdb.util.Util;

/**
 * 用户佣金
 * @author Administrator
 *
 */
@Controller
public class CommissionController {
	
	private Integer pageSize=Util.PAGESIZE;
	@Resource
	private AdminService service;
	@Resource
	private CommissionService commissionService;
	
	/**
	 * 进入佣金机构
	 * @return
	 */
	@RequestMapping("/toYongJin.do")
		public String isEnter(Alltable ata, Model m, HttpServletRequest request){
			request.getSession().setAttribute("power_id", ata.getPower_id());
			List<Alltable> list1 = service.isSelectOperateInPower(ata);
			m.addAttribute("kzlist", list1);
		return "yongjin";
	}
	
	
    /**
     * 进入佣金页并返回总页数(余额1与余额2是按条件查询佣金余额在某个区域的记录)
     * @param name 用户名  
	 * @param balance 余额1
	 * @param can_use_balance 余额2 
	 * @param total_balance1 佣金总额1
	 * @param total_balance2 佣金总额2 
	 * @return
     */
	@RequestMapping("/toCommissionIndex.do")
	public String toCommissionIndex(HttpServletRequest req,
									Alltable ata,
									Model model,
									String name,
									BigDecimal balance,
									BigDecimal can_use_balance,
									BigDecimal total_balance1,
									BigDecimal total_balance2){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("name", name);
		if(balance==null && can_use_balance==null){
			paramMap.put("balance1", null);
			paramMap.put("balance2", null);
		}
		if(balance==null && can_use_balance!=null ){
			paramMap.put("balance1", null);
			paramMap.put("balance2", can_use_balance);
		}
		if(balance!=null && can_use_balance==null ){
			paramMap.put("balance1", balance);
			paramMap.put("balance2", null);
		}
		if(balance!=null && can_use_balance!=null ){
			paramMap.put("balance1", balance);
			paramMap.put("balance2", can_use_balance);
		}
		
		if(total_balance1==null && total_balance2==null){
			paramMap.put("total_balance2", null);
			paramMap.put("total_balance1", null);
		}
		if(total_balance1==null && total_balance2!=null ){
			paramMap.put("total_balance1", null);
			paramMap.put("total_balance2", total_balance2);
		}
		if(total_balance1!=null && total_balance2==null ){
			paramMap.put("total_balance1", total_balance1);
			paramMap.put("total_balance2", null);
		}
		if(total_balance1!=null && total_balance2!=null ){
			paramMap.put("total_balance1", total_balance1);
			paramMap.put("total_balance2", total_balance2);
		}
		
		int number=commissionService.isFindAll(paramMap);
		if(number%pageSize==0){
			if(number==0){
				model.addAttribute("totalCount", 1);
			}else{
				model.addAttribute("totalCount", number/pageSize);
			}
			
		}else{
			model.addAttribute("totalCount", number/pageSize+1);
		}
		Long power_id=(long)req.getSession().getAttribute("power_id");
		ata.setPower_id(power_id);
		List<Alltable> list1 = service.isSelectOperateInPower(ata);
		model.addAttribute("kzlist", list1);
		return "commission";
	}

	
	/**
	 * 根据条件查询并返回佣金页数据（余额1与余额2是按条件查询佣金余额在某个区域的记录）
	 * @param name 用户名  
	 * @param balance 余额1
	 * @param can_use_balance 余额2 
	 * @param total_balance1 佣金总额1
	 * @param total_balance2 佣金总额2 
	 * @param page  第几页
	 * @return
	 */
	@RequestMapping("/dataCommissionIndex.do")
	@ResponseBody
	public Map<String,Object>  returnCommissionIndex(String name,
													BigDecimal balance,
													BigDecimal can_use_balance,
													BigDecimal total_balance1,
													BigDecimal total_balance2,
													Integer page){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		Map<String,Object> resMap=new HashMap<String,Object>();
		paramMap.put("number", (page-1)*pageSize);
		paramMap.put("pageSize", pageSize);
		paramMap.put("name", name);
		if(balance==null && can_use_balance==null){
			paramMap.put("balance1", null);
			paramMap.put("balance2", null);
		}
		if(balance==null && can_use_balance!=null ){
			paramMap.put("balance1", null);
			paramMap.put("balance2", can_use_balance);
		}
		if(balance!=null && can_use_balance==null ){
			paramMap.put("balance1", balance);
			paramMap.put("balance2", null);
		}
		if(balance!=null && can_use_balance!=null ){
			paramMap.put("balance1", balance);
			paramMap.put("balance2", can_use_balance);
		}
		
		if(total_balance1==null && total_balance2==null){
			paramMap.put("total_balance2", null);
			paramMap.put("total_balance1", null);
		}
		if(total_balance1==null && total_balance2!=null ){
			paramMap.put("total_balance1", null);
			paramMap.put("total_balance2", total_balance2);
		}
		if(total_balance1!=null && total_balance2==null ){
			paramMap.put("total_balance1", total_balance1);
			paramMap.put("total_balance2", null);
		}
		if(total_balance1!=null && total_balance2!=null ){
			paramMap.put("total_balance1", total_balance1);
			paramMap.put("total_balance2", total_balance2);
		}
		
		List<Map<String,Object>> resList2=commissionService.isFindAllByLimit(paramMap);
		System.out.println("aa"+resList2.toString());
		resMap.put("list", resList2);
		resMap.put("page", page);	
		int number=commissionService.isFindAll(paramMap);
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


	
	

}
