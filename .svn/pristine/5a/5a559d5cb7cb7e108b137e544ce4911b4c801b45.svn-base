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
import com.zp.jdb.entity.Jdb_systemParam;
import com.zp.jdb.service.AdminService;
import com.zp.jdb.service.Jdb_systemParamService;
import com.zp.jdb.util.Util;

/**
 * 系统参数
 * @author Administrator
 *
 */
@Controller
public class Jdb_systemParamController {
	
	private Integer pageSize=Util.PAGESIZE;
	@Resource
	private Jdb_systemParamService spService;
	@Resource
	private AdminService service;
	
	/**
	 * 进入查询系统参数页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/toSystemParamIndex.do")
	public String toSystemParamIndex(HttpServletRequest req,Alltable ata,Model model){
		Map<String,Object> resMap=spService.isFindById();
	    model.addAttribute("map",resMap );
	    Long power_id=(long)req.getSession().getAttribute("power_id");
		ata.setPower_id(power_id);
		List<Alltable> list1 = service.isSelectOperateInPower(ata);
		model.addAttribute("kzlist", list1);
		return "system_param";
	} 
	
	/**
	 * 进入改变系统参数页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/toChangeSystemParamIndex.do")
	public String toChangeSystemParamIndex(HttpServletRequest res,Alltable ata,Model model){
		Map<String,Object> resMap=spService.isFindById();
		model.addAttribute("map", resMap);
		Long power_id=(long)res.getSession().getAttribute("power_id");
		ata.setPower_id(power_id);
		List<Alltable> list1 = service.isSelectOperateInPower(ata);
		model.addAttribute("kzlist", list1);
		return "change_system_param";
	}
	
	/**
	 * 保存修改的的系统参数
	 * @param sp
	 * @return
	 */
	@RequestMapping("/changeSystemParamIndex.do")
	@ResponseBody
	public  Map<String,Object> changeSystemParamIndex(Jdb_systemParam sp,HttpServletRequest req){
		Map<String,Object> resMap=new HashMap<String,Object>();
		Long user_id=(Long)req.getSession().getAttribute("user_id");
		try{
			spService.isChangSystemParam(sp,user_id);
		}catch(Exception e){
			resMap.put("err", "操作失败");
		}
		
		return resMap;
	}
	
	
	/**
	 * 进入添加系统参数页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/toAddSystemParamIndex.do")
	public String toAddSystemParamIndex(HttpServletRequest res,Alltable ata,Model model){
		Long power_id=(long)res.getSession().getAttribute("power_id");
		ata.setPower_id(power_id);
		List<Alltable> list1 = service.isSelectOperateInPower(ata);
		model.addAttribute("kzlist", list1);
		return "add_system_param";
	}
	
	
	/**
	 * 保存添加的系统参数
	 * @param sp
	 * @return
	 */
	@RequestMapping("/addSystemParamIndex.do")
	@ResponseBody
	public  Map<String,Object> addSystemParamIndex(Jdb_systemParam sp,HttpServletRequest req){
		Map<String,Object> resMap=new HashMap<String,Object>();
		Long user_id=(Long)req.getSession().getAttribute("user_id");
		try{
			spService.isAddSystemParam(sp,user_id);
		}catch(Exception e){
			resMap.put("err", "操作失败");
		}
		
		return resMap;
	}
	
	
	
	/**
	 * 进入查看修改系统参数页并返回总页数
	 * @param model
	 * @return
	 */
	@RequestMapping("/toChangeSystemParamRecordIndex.do")
	public String toChangeSystemParamRecordIndex(HttpServletRequest res,Alltable ata,Model model){
		int number=spService.isFindAll();
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
		return "change_system_param_record";
	}

	
	/**
	 * 根据条件查询并返回修改系统参数页数据
	 * @param page  第几页
	 * @return
	 */
	@RequestMapping("/dataChangeSystemParamRecordIndex.do")
	@ResponseBody
	public Map<String,Object>  returnChangeSystemParamRecordIndex(Integer page){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		Map<String,Object> resMap=new HashMap<String,Object>();
		paramMap.put("number", (page-1)*pageSize);
		paramMap.put("pageSize", pageSize);
		List<Map<String,Object>> resList2=spService.isFindAllByLimit(paramMap);
		resMap.put("list", resList2);
		resMap.put("page", page);	
		int number=spService.isFindAll();
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