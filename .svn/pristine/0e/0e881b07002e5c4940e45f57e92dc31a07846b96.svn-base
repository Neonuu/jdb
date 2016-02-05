package com.zp.jdb.controllor;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zp.jdb.dao.AdministratorsDao;
import com.zp.jdb.dao.AlltableDao;
import com.zp.jdb.entity.Administrators;

import com.zp.jdb.entity.System_Journal;
import com.zp.jdb.po.R_Code;
import com.zp.jdb.service.LoginService;
import com.zp.jdb.service.System_JournalService;
import com.zp.jdb.sms.Send_sms;


@Controller
public class LoginControllor {
	
	@Resource
	private LoginService service;
	
	@Resource
	private System_JournalService sjservice;
	
	@Resource
	private AdministratorsDao admindao;
	
	@Resource
	private AlltableDao alldao;
	
	
	/**
	 * 验证登录
	 * @param us
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/login.do")
	@ResponseBody
	public int isSelectLogin(Administrators admin, HttpServletRequest request){
		
		int count = service.isSelectLogin(admin);
		
		if(count == 1){
		Administrators admin1 = service.isSelectUserID(admin);
		String jigou_id = alldao.selectjigouIDbyUserID(admin1.getUser_id());
		request.getSession().setAttribute("user_id", (long)admin1.getUser_id());
		request.getSession().setAttribute("user_name", admin1.getLoginName());
		request.getSession().setAttribute("jigou_id", jigou_id);
		}
		return count;
	}
	
	/**
	 * 验证修改密码
	 * @param admin
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/detection.do")
	@ResponseBody
	public int selectPass(Administrators admin, HttpServletRequest request){
		int count = service.selectPass(admin);
		if(count == 1){
		long id = service.selectAdminID(admin);
		request.getSession().setAttribute("detUser_id", id);
		}
		return count;
	}
	
	/**
	 * 获取验证码
	 */
	@RequestMapping(value="/getcode.do")
	@ResponseBody
	public void getcode(Administrators admin, HttpServletRequest request){
		String phoneNumber = admin.getPhoneNumber();
		Send_sms ss = new Send_sms("com.mysql.jdbc.Driver", "jdbc:mysql://123.56.98.210:3306/OrderDatabase?characterEncoding=utf8", "pitc_dev", "pitc123", "【交单宝】", "4008-344-666", "null", "4bcaedc85db3990c505009b1085452a8");
		R_Code r = ss.find_pwd(phoneNumber);
		Date create_time = r.getCreate_time();
		String r_code = r.getR_code();
		request.getSession().setAttribute("code", r_code);
		request.getSession().setAttribute("time", create_time);
	}
	/**
	 * 填写新密码
	 * @param admin
	 * @return
	 */
	@RequestMapping(value="/vcode.do")
	public String vcode(Administrators admin, HttpServletRequest request, String code){
		String sesscode = (String) request.getSession().getAttribute("code");
			if(sesscode.equals(code)){
				return("updatePass");
			}else{
				return("unUpdatePass");
			}
	}
	
	/**
	 * 修改密码
	 * @param admin
	 * @return
	 */
	@RequestMapping(value="/updatePass.do")
	public String updatePass(Administrators admin, HttpServletRequest request){
			long id = (long)request.getSession().getAttribute("detUser_id");
			admin.setUser_id((int)id);
			service.updatePass(admin);
			
			//操作记录
	        System_Journal sj = new System_Journal();
	        sj.setDate(new Date());
	        sj.setModule("管理员管理");
	        sj.setOperation_content("修改密码");
	        long uid = (Long) request.getSession().getAttribute("user_id");
	        Administrators ad = admindao.findById(uid);
	        String name = ad.getLoginName();
	        sj.setOperator(name);
	        sj.setType("修改");
	        try {
				sjservice.addJournal(sj);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			return("logback");
	}
}