package com.zp.jdb.controllor;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zp.jdb.dao.AdministratorsDao;
import com.zp.jdb.entity.Administrators;
import com.zp.jdb.entity.Alltable;
import com.zp.jdb.entity.System_Journal;
import com.zp.jdb.entity.User;
import com.zp.jdb.service.AdminService;
import com.zp.jdb.service.System_JournalService;
import com.zp.jdb.service.UserOService;
import com.zp.jdb.util.ConstantValue;
@Controller
public class UserOControllor {
	
	@Resource
	private UserOService service;
	@Resource
	private AdminService Aservice;
	
	@Resource
	private System_JournalService sjservice;
	
	@Resource
	private AdministratorsDao admindao;
	
	/**
	 * 查询登录用户能进行的操作
	 * @param ata
	 * @param m
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/yonghu.do")
	public String isEnter(Alltable ata, Model m, HttpServletRequest request){
		request.getSession().setAttribute("power_id", ata.getPower_id());
		List<Alltable> list1 = Aservice.isSelectOperateInPower(ata);
		m.addAttribute("kzlist", list1);
		return "yonghu";
	}
	/**
	 * 查询用户信息
	 * @param us
	 * @param m
	 * @param request
	 * @param ata
	 * @return
	 */
	@RequestMapping(value="/usermessage.do")
	public String selectUserMessage(User us, Model m, HttpServletRequest request, Alltable ata){
		long pid = (long)request.getSession().getAttribute("power_id");
		ata.setPower_id(pid);
		List<Alltable> plist = Aservice.isSelectOperateInPower(ata);
		m.addAttribute("kzlist", plist);
		List<User> list1 = service.selectUserMessage(us);
		int total = service.selectUserCount(us);
		int maxpage = (total % ConstantValue.PAGE_COUNT == 0) ? (total / ConstantValue.PAGE_COUNT) : (total / ConstantValue.PAGE_COUNT + 1);
		if(maxpage == 0){
			maxpage = 1;
		}
		us.setTotalCount(total);
		us.setMaxpage(maxpage);
		m.addAttribute("ulist", list1);
		m.addAttribute("svo", us);
		return "usermessage";
	}
	/**
	 * 冻结用户
	 * @param us
	 * @param m
	 * @return
	 */
	@RequestMapping(value="/dongjie.do")
	public String updateUserIsdel1(User us, Model m, HttpServletRequest request){
		service.updateUserDong(us);
		//操作记录
        System_Journal sj = new System_Journal();
        sj.setDate(new Date());
        sj.setModule("用户管理");
        User usa = service.selectGeren(us);
        sj.setOperation_content("冻结电话号码为：　"+usa.getPhoneNumber()+"　的用户");
        long id = (Long) request.getSession().getAttribute("user_id");
        Administrators ad = admindao.findById(id);
        String name = ad.getLoginName();
        sj.setOperator(name);
        sj.setType("修改");
        try {
			sjservice.addJournal(sj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/usermessage.do";
	}
	/**
	 * 恢复冻结的用户
	 * @param us
	 * @param m
	 * @return
	 */
	@RequestMapping(value="/huifu.do")
	public String updateUserIsdel2(User us, Model m, HttpServletRequest request){
		service.updateUserHui(us);
		//操作记录
        System_Journal sj = new System_Journal();
        sj.setDate(new Date());
        sj.setModule("用户管理");
        User usa = service.selectGeren(us);
        sj.setOperation_content("恢复电话号码为：　"+usa.getPhoneNumber()+"　的用户");
        long id = (Long) request.getSession().getAttribute("user_id");
        Administrators ad = admindao.findById(id);
        String name = ad.getLoginName();
        sj.setOperator(name);
        sj.setType("修改");
        try {
			sjservice.addJournal(sj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/usermessage.do";
	}
	/**
	 * 查询用户详情
	 * @param us
	 * @param m
	 * @return
	 */
	@RequestMapping(value="/userinfo.do")
	public String selectUserMessageFor(User us, Model m){
		List<User> list1 = service.selectUserMessage(us);
		int total = service.selectUserCount(us);
		int maxpage = (total % ConstantValue.PAGE_COUNT == 0) ? (total / ConstantValue.PAGE_COUNT) : (total / ConstantValue.PAGE_COUNT + 1);
		if(maxpage == 0){
			maxpage = 1;
		}
		us.setTotalCount(total);
		us.setMaxpage(maxpage);
		m.addAttribute("ulist", list1);
		m.addAttribute("svo", us);
		return "userinfo";
	}
	/**
	 * 查询用户详情
	 * @param us
	 * @param m
	 * @param request
	 * @param ata
	 * @return
	 */
	@RequestMapping(value="/selectgeren.do")
	public String selectGeren(User us, Model m, HttpServletRequest request, Alltable ata){
		long pid = (long)request.getSession().getAttribute("power_id");
		ata.setPower_id(pid);
		List<Alltable> plist = Aservice.isSelectOperateInPower(ata);
		m.addAttribute("kzlist", plist);
		User u = service.selectGeren(us);
		m.addAttribute("user", u);
		return "userinfo";
	}
}