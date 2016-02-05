package com.zp.jdb.controllor;
    import java.util.Date;
import java.util.List;		

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zp.jdb.dao.AdministratorsDao;
import com.zp.jdb.entity.Administrators;
import com.zp.jdb.entity.Alltable;
import com.zp.jdb.entity.Sms_msg;
import com.zp.jdb.entity.System_Journal;
import com.zp.jdb.service.AdminService;
import com.zp.jdb.service.MsgService;
import com.zp.jdb.service.System_JournalService;
import com.zp.jdb.util.pageValue;
    /**
     * 模板增、删、该、查控制层
     * @author Administrator
     *
     */
    @Controller
    public class MsgControllor {
    	
	@Resource
	private MsgService service;
	@Resource
	private AdminService adservice;
	@Resource
	private System_JournalService sjservice;
	
	@Resource
	private AdministratorsDao admindao;

	
	
	
	@RequestMapping(value="/smsenter.do")
	public String entersms_msg(Alltable ata, HttpServletRequest request, Model m){
		request.getSession().setAttribute("power_id", ata.getPower_id());
		List<Alltable> list1 = adservice.isSelectOperateInPower(ata);
		m.addAttribute("kzlist", list1);	
	return "duanxinguanli";
	}
	/**
	 * 模板查询
	 * @param m
	 * @param ata
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/find.do")
	public String findAll(Model m, Sms_msg ata, HttpServletRequest request, Alltable all){
		long pid = (long)request.getSession().getAttribute("power_id");
		all.setPower_id(pid);
		List<Alltable> plist = adservice.isSelectOperateInPower(all);
		m.addAttribute("kzlist", plist);
		
		List<Sms_msg> list = service.isFindAll(ata);
		int total = service.isSelectMsgTotalCount(ata);
		int maxpage = (total % pageValue.PAGE_COUNT == 0) ? (total / pageValue.PAGE_COUNT) : (total / pageValue.PAGE_COUNT + 1); 
		ata.setTotalCount(total);
		ata.setMaxpage(maxpage);
		m.addAttribute("alist", list);
		m.addAttribute("svo", ata);
		HttpSession se = request.getSession();
		Integer pa = ata.getPagenum();
		se.setAttribute("page", pa);
		se.setAttribute("count", pageValue.PAGE_COUNT);
		return "empList";
	}
	/**
	 * 模板添加
	 * @param m
	 * @param ata 实体类
	 * @return
	 */
	@RequestMapping(value="/add.do")
	public String isinsertsms_msg(Model m, Sms_msg ata, HttpServletRequest request, Alltable all){
		long pid = (long)request.getSession().getAttribute("power_id");
		all.setPower_id(pid);
		List<Alltable> plist = adservice.isSelectOperateInPower(all);
		m.addAttribute("kzlist", plist);
	    return "add";
	}
	/**
	 * 添加保存 
	 * @param m
	 * @param ata 实体类
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/insertMsg.do")
	public String insertsms_msg(Model m, Sms_msg ata, HttpServletRequest request, Alltable all){
		String sms_msg = request.getParameter("sms_msg");
		String sms_type = request.getParameter("sms_type");
		ata.setSms_msg(sms_msg);
		ata.setSms_type(sms_type);
		service.isinsertsms_msg(ata);
		
		//操作记录
        System_Journal sj = new System_Journal();
        sj.setDate(new Date());
        sj.setModule("短信管理");
        sj.setOperation_content("增加模板:"+ata.getSms_msg());
        long id = (Long) request.getSession().getAttribute("user_id");
        Administrators ad = admindao.findById(id);
        String name = ad.getLoginName();
        sj.setOperator(name);
        sj.setType("增加");
        try {
			sjservice.addJournal(sj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return "redirect:/find.do"; 
	
	}
	/**
	 * 模板删除
	 * @param m
	 * @param tid 模板列id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/del.do")
	public String isdeletesms_msg(Model m, int tid, Sms_msg ata,HttpServletRequest request){
	   service.isdeletesms_msg(tid);
	   
	 //操作记录
       System_Journal sj = new System_Journal();
       sj.setDate(new Date());
       sj.setModule("短信管理");
       sj.setOperation_content("删除模板列:"+tid);
       long id = (Long) request.getSession().getAttribute("user_id");
       Administrators ad = admindao.findById(id);
       String name = ad.getLoginName();
       sj.setOperator(name);
       sj.setType("删除");
       try {
			sjservice.addJournal(sj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   return "redirect:/find.do";
	}
	/**
	 * 根据id查询
	 * @param m
	 * @param tid id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/modify.do")
	public String findbytid(Model m ,int tid, HttpServletRequest request, Alltable all){
		long pid = (long)request.getSession().getAttribute("power_id");
		all.setPower_id(pid);
		List<Alltable> plist = adservice.isSelectOperateInPower(all);
		m.addAttribute("kzlist", plist);
		Sms_msg list = service.isfindbytid(tid);
		m.addAttribute("list", list);
		return "modifyMsg";
	}
	/**
	 * 模板修改
	 * @param m
	 * @param ata
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/update.do")
	public String updatesms_msg(Model m, Sms_msg ata,HttpServletRequest request){
		int tid = Integer.parseInt(request.getParameter("tid"));
		String sms_msg = request.getParameter("sms_msg");
		String sms_type = request.getParameter("sms_type");
		ata.setTid(tid);
		ata.setSms_msg(sms_msg);
		ata.setSms_type(sms_type);
		service.isupdatesms_msg(ata);
		
		//操作记录
        System_Journal sj = new System_Journal();
        sj.setDate(new Date());
        sj.setModule("短信管理");
        sj.setOperation_content("修改模板为："+ata.getSms_msg());
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
	    return "redirect:/find.do"; 
	}
	
	
	
}





