package com.zp.jdb.controllor;
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
import com.zp.jdb.service.CommissionDetailService;
import com.zp.jdb.util.Util;

/**
 * 用户佣金变动记录
 * @author Administrator
 *
 */
@Controller
public class CommissionDetailController {
	
	private Integer pageSize = Util.PAGESIZE;
	
	@Resource
	private CommissionDetailService commission_detailService;
	@Resource
	private AdminService service;

	/**
	 * 进入佣金交易页并返回总页数
	 * @param model
	 * @return
	 */
	@RequestMapping("/toCommissionDetailIndex.do")
	public String toCommissionIndex(HttpServletRequest res,Alltable ata,Model model,Long user_id){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("user_id", user_id);
		int number=commission_detailService.isFindAll(paramMap);
		if(number%pageSize==0){
			if(number==0){
				model.addAttribute("totalCount", 1);
			}else{
				model.addAttribute("totalCount", number/pageSize);
			}
			
		}else{
			model.addAttribute("totalCount", number/pageSize+1);
		}
		model.addAttribute("user_id", user_id);
		Long power_id=(long)res.getSession().getAttribute("power_id");
		ata.setPower_id(power_id);
		List<Alltable> list1 = service.isSelectOperateInPower(ata);
		model.addAttribute("kzlist", list1);
		return "commission_detail";
	}
	
	/**
	 * 根据条件查询并返回佣金页数据
	 * @param name 用户名
	 * @param balance 余额
	 * @param bank_number  银行卡号
 	 * @param page  第几页
	 * @return
	 */
	@RequestMapping("/dataCommissionDetailIndex.do")
	@ResponseBody
	public Map<String,Object>  returnCommissionIndex(Integer page,Long user_id){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		Map<String,Object> resMap=new HashMap<String,Object>();
		paramMap.clear();
		paramMap.put("number", (page-1)*pageSize);
		paramMap.put("pageSize", pageSize);
		paramMap.put("user_id",user_id );
		List<Map<String,Object>> resList2=commission_detailService.isFindAllByLimit(paramMap);
		resMap.put("list", resList2);
		resMap.put("page", page);
		int number=commission_detailService.isFindAll(paramMap);
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
	 * 进入佣金交易页并返回总页数
	 * @param model
	 * @return
	 */
	@RequestMapping("/toConfirmTiXian.do")
	public String toCommissionTiXIanIndex(HttpServletRequest res,Alltable ata,Model model,Long user_id){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("user_id", user_id);
		int number=commission_detailService.isFindAllTiXian(paramMap);
		if(number%pageSize==0){
			if(number==0){
				model.addAttribute("totalCount", 1);
			}else{
				model.addAttribute("totalCount", number/pageSize);
			}
			
		}else{
			model.addAttribute("totalCount", number/pageSize+1);
		}
		model.addAttribute("user_id", user_id);
		Long power_id=(long)res.getSession().getAttribute("power_id");
		ata.setPower_id(power_id);
		List<Alltable> list1 = service.isSelectOperateInPower(ata);
		model.addAttribute("kzlist", list1);
		return "commission_tixian_detail";
	}
	
	/**
	 * 根据条件查询并返回佣金页数据
	 * @param name 用户名
	 * @param balance 余额
	 * @param bank_number  银行卡号
 	 * @param page  第几页
	 * @return
	 */
	@RequestMapping("/dataConfirmTiXian.do")
	@ResponseBody
	public Map<String,Object>  returnCommissionTiXIanIndex(Integer page,Long user_id){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		Map<String,Object> resMap=new HashMap<String,Object>();
		paramMap.clear();
		paramMap.put("number", (page-1)*pageSize);
		paramMap.put("pageSize", pageSize);
		paramMap.put("user_id",user_id );
		List<Map<String,Object>> resList2=commission_detailService.isFindAllTiXianByLimit(paramMap);
		resMap.put("list", resList2);
		resMap.put("page", page);
		int number=commission_detailService.isFindAllTiXian(paramMap);
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
		 * 当点击（提现申请）返款成功按钮时把状态改成“提现成功”
		 * @param id 佣金交易记录的id
		 * @return
		 */
	@RequestMapping("/toCommissionDetailTiXianIndex.do")
    @ResponseBody
	public Map<String,Object> CommissionDetailTiXianIndex(Long id,HttpServletRequest req){
		Long user_id=(Long)req.getSession().getAttribute("user_id");
		Map<String,Object> resMap=new HashMap<String,Object>();
		try {
			commission_detailService.updateSuccessTiXianById(id,user_id);
		} catch (Exception e) {
			resMap.put("err", "提交失败！");
		}
		
		return resMap;
	}
		
	
	

}
