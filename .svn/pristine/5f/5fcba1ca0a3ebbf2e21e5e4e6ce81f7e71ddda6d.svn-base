package com.zp.jdb.controllor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zp.jdb.entity.Alltable;
import com.zp.jdb.entity.Perform_order;
import com.zp.jdb.entity.User;
import com.zp.jdb.service.AdminService;
import com.zp.jdb.service.PerformService;
import com.zp.jdb.util.StatisticsValue;
@Controller
public class WZLPerformControllor {
	@Resource
	private PerformService service;
	@Resource
	private AdminService service1;
	
	@RequestMapping(value="/tongji.do")
	public String statistics(Model m, Perform_order ao,HttpServletRequest request, Alltable ata){
		long pid = (long)request.getSession().getAttribute("power_id");
		ata.setPower_id(pid);
		String add_time = request.getParameter("add_time");
		ao.setAdd_time(add_time);
		List<Alltable> plist = service1.isSelectOperateInPower(ata);
		m.addAttribute("kzlist", plist);
		
		List<Perform_order> list = service.isStatistics(ao);
		List<User> listu = service.selectUserInfo();
		int total = service.isSelectTotalCount(ao);
		int maxpage = (total % StatisticsValue.PAGE_COUNT == 0) ? (total / StatisticsValue.PAGE_COUNT) : (total / StatisticsValue.PAGE_COUNT + 1); 
		if(maxpage == 0){
			maxpage = 1;
		}
		m.addAttribute("add_time", add_time);
		ao.setTotalCount(total);
		ao.setMaxpage(maxpage);
		m.addAttribute("svo", ao);
		m.addAttribute("user", listu);
		m.addAttribute("jdph", list);
		return"tongji";
	}
}
