package com.zp.jdb.controllor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zp.jdb.entity.Alltable;
import com.zp.jdb.service.AdminService;

@Controller
public class RankingControllor {
	
	@Resource
	private AdminService service;
	
	@RequestMapping(value="/paihang.do")
	public String isEnter(Alltable ata, HttpServletRequest request, Model m){
		long pid = (long)request.getSession().getAttribute("power_id");
		ata.setPower_id(pid);
		List<Alltable> plist = service.isSelectOperateInPower(ata);
		m.addAttribute("kzlist", plist);
		
		
		return "paihang";
	}
	
}