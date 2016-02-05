package com.zp.jdb.controllor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zp.jdb.entity.Alltable;
import com.zp.jdb.entity.Sends_sms;
import com.zp.jdb.entity.Sms_msg;
import com.zp.jdb.service.AdminService;
import com.zp.jdb.service.MsgService;
import com.zp.jdb.service.TranService;
import com.zp.jdb.util.pageValue;
/**
 * 短信查询分类查询控制层
 * @author Administrator
 *
 */
@Controller
public class TranControllor {
	@Resource
	private TranService service;
	@Resource
	private MsgService service1;
	@Resource
	private AdminService adservice;
    /**
     * 查询及分类查询功能
     * @param m
     * @param sd 实体类
     * @param request
     * @return
     */
	@RequestMapping(value="/listPage")
	public String findAll(Model m, Sends_sms sd, HttpServletRequest request,Alltable all){
		long pid = (long)request.getSession().getAttribute("power_id");
		all.setPower_id(pid);
		List<Alltable> plist = adservice.isSelectOperateInPower(all);
		m.addAttribute("kzlist", plist);
		
		
		List<Sends_sms> list = service.isfindAll(sd);
		int total = service.isSelectMsgTotalCount(sd);
		List<Sms_msg> info = service1.isFindAllInfo();
		int maxpage = (total % pageValue.PAGE_COUNT == 0) ? (total / pageValue.PAGE_COUNT) : (total / pageValue.PAGE_COUNT + 1); 
		sd.setTotalCount(total);
		sd.setMaxpage(maxpage);
		m.addAttribute("alist", list);
		m.addAttribute("info", info);
		m.addAttribute("svo", sd);
		m.addAttribute("info_type", sd.getInfo());
		return "find";
	}
}
