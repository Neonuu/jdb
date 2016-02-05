package com.zp.jdb.controllor;

import java.text.SimpleDateFormat;
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

import com.zp.jdb.entity.Alltable;
import com.zp.jdb.entity.System_Journal;
import com.zp.jdb.service.AdminService;
import com.zp.jdb.service.System_JournalService;
import com.zp.jdb.util.Util;

@Controller
public class System_JournalControllor {
	
	private Integer pageSize = Util.PAGESIZE;
	@Resource
	private System_JournalService sjService;
	@Resource
	private AdminService service;
	
	@RequestMapping("/dateSystemJournal.do")
	@ResponseBody
	public Map<String,Object>  findSystemJournalByLimitIndex(HttpServletRequest req,System_Journal sj){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		Map<String,Object> resMap=new HashMap<String,Object>();
		String date1=req.getParameter("date1");
		String date2=req.getParameter("date2");
		paramMap.put("pageSize", pageSize);
		paramMap.put("page", (sj.getPage()-1)*pageSize);
		paramMap.put("module", sj.getModule());
		if((date1==null ||date1=="") && (date2==null ||date2=="")){
			paramMap.put("date", null);                                                		
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
			paramMap.put("date", "123");	
			paramMap.put("date1", resDate1);
			paramMap.put("date2", resDate2);
		}
		List<System_Journal> reslist=sjService.findJournalsByLimit(paramMap);
		resMap.put("list", reslist);
		resMap.put("page", sj.getPage());
		int number=sjService.findJournalsAll(paramMap); 
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
	
	
	@RequestMapping("/toSystemjournal.do")
	public String  toSystemJournalIndex(HttpServletRequest req,System_Journal sj,Model model,Alltable ata){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		String date1=(String) req.getAttribute("date1");
		String date2=(String) req.getAttribute("date2");
		paramMap.put("module", sj.getModule());
		if((date1==null ||date1=="") && (date2==null ||date2=="")){
			paramMap.put("date", null);                                                		
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
			paramMap.put("date", "123");	
			paramMap.put("date1", resDate1);
			paramMap.put("date2", resDate2);
		}
		int number=sjService.findJournalsAll(paramMap);
		if(number%pageSize==0){
			if(number==0){
				model.addAttribute("totalCount", 1);
			}else{
				model.addAttribute("totalCount", number/pageSize);
			}
		}else{
			model.addAttribute("totalCount", number/pageSize+1);
		}
		return "SystemJournal";
	}

}
