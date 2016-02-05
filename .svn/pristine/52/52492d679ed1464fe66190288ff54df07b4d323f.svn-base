package com.zp.jdb.controllor;
		

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zp.jdb.dao.AdministratorsDao;
import com.zp.jdb.entity.Administrators;
import com.zp.jdb.entity.Alltable;
import com.zp.jdb.entity.Organization;
import com.zp.jdb.entity.System_Journal;
import com.zp.jdb.entity.User_Org;
import com.zp.jdb.service.AdminService;
import com.zp.jdb.service.LoginService;
import com.zp.jdb.service.OrganizationService;
import com.zp.jdb.service.System_JournalService;
import com.zp.jdb.service.UserOService;
import com.zp.jdb.util.ConstantValue;
		
@Controller
public class AdminControllor {
			
		@Resource
		private AdminService service;
		
		@Resource
		private UserOService service1;
		
		@Resource
		private OrganizationService oservice;
		
		@Resource
		private LoginService logservice;
		
		@Resource
		private System_JournalService sjservice;
		
		@Resource
		private AdministratorsDao admindao;

		
		
		
		/**
		 * 登陆后进到主页判断是否具有管理员权限，没有踢回登陆页。
		 * 有就查询相关信息返回页面。
		 * @param m
		 * @param ata
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/zhuye.do")
		public String isSelectGroupAndPower(Model m, Alltable ata, HttpServletRequest request){
			long user_id = (Long) request.getSession().getAttribute("user_id");
			ata.setUser_id((int)user_id);
			int count = service.isSelectID(ata);
			if(count == 0){
				return "unlogin";
			}else{
				String user_name = service.isSelectUser_name(ata);
				int adm = service.isSelectAdmin(ata);
				List<Alltable>  list1 = service.isSelectGroup();
				List<Alltable>	list2 = service.isSelectGroupAndPower();
				String list3 = service.isSelectAllpower(ata);
				String list4 = service.isSelectAlloperate(ata);
				String[] list5 = list3.split(",");
				String[] list6 = list4.split(",");
				String gid = "";
				HashSet<String> list7 = new HashSet<String>();
				for(String power_id:list5){
					gid = service.isSelectInGroup(power_id);
					list7.add(gid);
			}
			m.addAttribute("glist", list1);
			m.addAttribute("gplist", list2);
			m.addAttribute("allplist", list5);
			m.addAttribute("inglist", list7);
			request.getSession().setAttribute("user_name", user_name);
			request.getSession().setAttribute("admin", adm);
			request.getSession().setAttribute("alloperate_id", list6);
			return "zhuye";
			}
		}
		/**
		 * 查询登录管理可进行的操作。
		 * @param ata
		 * @param m
		 * @return
		 */
		@RequestMapping(value="/cando.do")
		public String isEnter(Alltable ata, Model m, HttpServletRequest request){
			request.getSession().setAttribute("power_id", ata.getPower_id());
			List<Alltable> list1 = service.isSelectOperateInPower(ata);
			m.addAttribute("kzlist", list1);
			return "cando";
		}
		/**
		 * 查询管理员。查询所有管理员个人信息。
		 * @param m
		 * @param ata
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/selectAdmin.do")
		public String isSelectUser1(Model m, Alltable ata, HttpServletRequest request){
			long pid = (long)request.getSession().getAttribute("power_id");
			ata.setPower_id(pid);
			List<Alltable> plist = service.isSelectOperateInPower(ata);
			m.addAttribute("kzlist", plist);
			List<Alltable> list = service.isSelectAdministrator(ata);
			int total = service.isSelectAdminTotalCount(ata);
			int maxpage = (total % ConstantValue.PAGE_COUNT == 0) ? (total / ConstantValue.PAGE_COUNT) : (total / ConstantValue.PAGE_COUNT + 1); 
			if(maxpage == 0){
				maxpage = 1;
			}
			ata.setTotalCount(total);
			ata.setMaxpage(maxpage);
			m.addAttribute("alist", list);
			m.addAttribute("svo", ata);
			return "selectAdmin";
		}
		/**
		 * 删除管理员。查询所有管理员信息。
		 * @param m
		 * @param ata
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/deleteAdmin.do")
		public String isSelectUser2(Model m, Alltable ata, HttpServletRequest request){
			long pid = (long)request.getSession().getAttribute("power_id");
			ata.setPower_id(pid);
			List<Alltable> plist = service.isSelectOperateInPower(ata);
			m.addAttribute("kzlist", plist);
			List<Alltable> list = service.isSelectAdministrator(ata);
			Integer adm = (Integer)request.getSession().getAttribute("admin");
			int total = service.isSelectAdminTotalCount(ata);
			int maxpage = (total % ConstantValue.PAGE_COUNT == 0) ? (total / ConstantValue.PAGE_COUNT) : (total / ConstantValue.PAGE_COUNT + 1);
			if(maxpage == 0){
				maxpage = 1;
			}
			ata.setTotalCount(total);
			ata.setMaxpage(maxpage);
			m.addAttribute("alist", list);
			m.addAttribute("svo", ata);
			m.addAttribute("admin", adm);
			
			
			return "deleteAdmin";
		}
		/**
		 * 删除管理员。将被选中管理员的is_delete列“0”变为“1”。
		 * @param m
		 * @param ata
		 * @return
		 */
		@RequestMapping(value="/deleteAdminDEL.do")
			public String isDeleteAdmin(Model m, Alltable ata, HttpServletRequest request){
			service.isDeleteAdministrator(ata);
			//操作记录
	        System_Journal sj = new System_Journal();
	        sj.setDate(new Date());
	        sj.setModule("权限管理");
	        Administrators asd = admindao.findById((long)ata.getUser_id());
	        sj.setOperation_content("删除登录名为：　"+asd.getLoginName()+"　的管理员");
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

			return "redirect:/deleteAdmin.do";
		}
		/**
		 * 增加管理员。查询非管理员个人信息。
		 * @param m
		 * @param ata
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/insertAdmin.do")
		public String isSelectPutongUser(Model m, Alltable ata, HttpServletRequest request){
			long pid = (long)request.getSession().getAttribute("power_id");
			ata.setPower_id(pid);
			List<Alltable> plist = service.isSelectOperateInPower(ata);
			m.addAttribute("kzlist", plist);
			List<Alltable> list = service.isSelectPutongUser(ata);
			Integer adm = (Integer)request.getSession().getAttribute("admin");
			int total = service.isSelectAdminTotalCount2(ata);
			int maxpage = (total % ConstantValue.PAGE_COUNT == 0) ? (total / ConstantValue.PAGE_COUNT) : (total / ConstantValue.PAGE_COUNT + 1);
			if(maxpage == 0){
				maxpage = 1;
			}
			ata.setTotalCount(total);
			ata.setMaxpage(maxpage);
			m.addAttribute("alist", list);
			m.addAttribute("svo", ata);
			m.addAttribute("admin", adm);
			return "insertAdmin";
		}
		/**
		 * 增加管理员。增加拥有管理员所有权限的管理员。
		 * @param m
		 * @param ata
		 * @return
		 */
		@RequestMapping(value="/insertAllAdmin.do")
		public String isInsertAllAdmin(Model m, Alltable ata, HttpServletRequest request){
			Integer uid = ata.getUser_id();
			List<Alltable> list1 = service.isSelectGroupID();
			List<Alltable> list2 = service.isSelectPowerID();
			List<Alltable> list3 = service.isSelectOperateID();
			String gid = "";
			for(Alltable groupid:list1){
				gid += groupid.getGroup_id()+",";
			}
			String pid = "";
			for(Alltable powerid:list2){
				pid += powerid.getPower_id()+",";
			}
			String oid = "";
			for(Alltable operateid:list3){
				oid += operateid.getOperate_id()+",";
			}
			ata.setUser_id(uid);
			ata.setAllgroup_id(gid);
			ata.setAllpower_id(pid);
			ata.setAlloperate_id(oid);
			service.isInsertAllAdmin(ata);
			
			//默认操作全部机构
			Map<String,Object> paramMap =new  HashMap<String,Object>();
			paramMap.put("user_id",uid);
			paramMap.put("orgId",0);
			User_Org uo = oservice.selectUserOrg(uid);
			if(uo == null){
				oservice.insertUserOrg(paramMap);		
			}else{
				oservice.updateUserOrg(paramMap);
			}
			
			
			//操作记录
	        System_Journal sj = new System_Journal();
	        sj.setDate(new Date());
	        sj.setModule("权限管理");
	        Administrators asd = admindao.findById((long)ata.getUser_id());
	        sj.setOperation_content("将登录名为：　"+asd.getLoginName()+"　分配为管理员");
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
			return "redirect:/insertAdmin.do";
		}
		/**
		 * 增加管理员。增加机构管理所有权限的管理员。
		 * @param m
		 * @param ata
		 * @return
		 */
		@RequestMapping(value="/insertJigouAdmin.do")
		public String isInsertJigouAdmin(Model m, Alltable ata, HttpServletRequest request){
			Integer uid = ata.getUser_id();
			long gp_id = service.selectGuanliyuanguanliID();
			List<Alltable> list1 = service.selectJigouguanliPowerID(gp_id);
			List<Alltable> list2 = service.selectJigouguanliOperateID(gp_id);
			String gid = "";
			gid = gp_id+",";
			String pid = "";
			for(Alltable powerid:list1){
				pid += powerid.getPower_id()+",";
			}
			String oid = "";
			for(Alltable operateid:list2){
				oid += operateid.getOperate_id()+",";
			}
			ata.setUser_id(uid);
			ata.setAllgroup_id(gid);
			ata.setAllpower_id(pid);
			ata.setAlloperate_id(oid);
			service.isInsertJigouAdmin(ata);
			
			//默认操作全部机构
			Map<String,Object> paramMap =new  HashMap<String,Object>();
			paramMap.put("user_id",uid);
			paramMap.put("orgId",0);
			User_Org uo = oservice.selectUserOrg(uid);
			if(uo == null){
				oservice.insertUserOrg(paramMap);		
			}else{
				oservice.updateUserOrg(paramMap);
			}
			
			
			//操作记录
	        System_Journal sj = new System_Journal();
	        sj.setDate(new Date());
	        sj.setModule("权限管理");
	        Administrators asd = admindao.findById((long)ata.getUser_id());
	        sj.setOperation_content("将登录名为：　"+asd.getLoginName()+"　分配为机构管理员");
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
			return "redirect:/insertAdmin.do";
		}
		/**
		 * 修改管理权限/操作。查询所有管理员信息。
		 * @param m
		 * @param ata
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/updateAdmin.do")
		public String isSelectAdministrator(Model m, Alltable ata, HttpServletRequest request){
			long pid = (long)request.getSession().getAttribute("power_id");
			ata.setPower_id(pid);
			List<Alltable> plist = service.isSelectOperateInPower(ata);
			m.addAttribute("kzlist", plist);
			List<Alltable> list1 = service.isSelectAdministrator(ata);
			Integer adm = (Integer)request.getSession().getAttribute("admin");
			int total = service.isSelectAdminTotalCount(ata);
			int maxpage = (total % ConstantValue.PAGE_COUNT == 0) ? (total / ConstantValue.PAGE_COUNT) : (total / ConstantValue.PAGE_COUNT + 1);
			if(maxpage == 0){
				maxpage = 1;
			}
			ata.setTotalCount(total);
			ata.setMaxpage(maxpage);
			m.addAttribute("alist", list1);
			m.addAttribute("svo", ata);
			m.addAttribute("admin", adm);
			return "updateAdmin";
		}
		/**
		 * 修改管理员权限/操作。查看被选中管理员的权限/操作信息。
		 * @param m
		 * @param ata
		 * @return
		 */
		@RequestMapping(value="/peizhiquanxian.do")
		public String isUpdatePower(Model m, Alltable ata, HttpServletRequest request){
			long pid = (long)request.getSession().getAttribute("power_id");
			ata.setPower_id(pid);
			List<Alltable> plist = service.isSelectOperateInPower(ata);
			m.addAttribute("kzlist", plist);
			List<Alltable> list1 = service.isSelectAdministrator(ata);
			List<Alltable> list2 = service.isSelectPowerID();
			List<Alltable> list3 = service.isSelectPowerAndOperate();
			
			List<Organization> olist = oservice.selectExistOrgList();
			m.addAttribute("olist", olist);
			
			
			
			String list4 = service.isSelectAdminPower(ata);
			String list5 = service.isSelectAdminOperate(ata);
			int admin = service.isSelectXuanAdmin(ata);
			int id = (int) service.selectGuanliyuanguanliID();
			List<Alltable> list6 = service.selectJigouguanliPowerID(id);
			List<Alltable> list7 = service.selectJigouguanliOperateID(id);
			int total = service.isSelectAdminTotalCount(ata);
			int maxpage = (total % ConstantValue.PAGE_COUNT == 0) ? (total / ConstantValue.PAGE_COUNT) : (total / ConstantValue.PAGE_COUNT + 1);
			if(maxpage == 0){
				maxpage = 1;
			}
			ata.setTotalCount(total);
			ata.setMaxpage(maxpage);
			m.addAttribute("alist", list1);
			m.addAttribute("plist", list2);
			m.addAttribute("polist", list3);
			m.addAttribute("aplist", list4);
			m.addAttribute("aolist", list5);
			m.addAttribute("jigouplist", list6);
			m.addAttribute("jigouolist", list7);
			m.addAttribute("beixuanadmin", admin);
			m.addAttribute("svo", ata);
			
			
			User_Org uo = oservice.selectUserOrg(ata.getUser_id());
			if(uo == null){
				return "updateAdminPower";
			}else{
				m.addAttribute("user_org", uo);
				return "updateAdminPower";
			}
			
			
		}
		/**
		 * 修改管理权限/操作。将修改后的权限/操作更新到数据库中。
		 * @param m
		 * @param ata
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/updatePower.do")
		public String isUpdatePowerOperate(User_Org user,Model m, Alltable ata, HttpServletRequest request){
			String allpower_id = request.getParameter("allpower_id");
			String alloperate_id = request.getParameter("alloperate_id");
			String uid = request.getParameter("user_id");
			int user_id = Integer.parseInt(uid);
			ata.setAllpower_id(allpower_id);
			ata.setAlloperate_id(alloperate_id);
			ata.setUser_id(user_id);
			service.isUpdatePower(ata);
			
			
			User_Org uo = oservice.selectUserOrg(user.getUser_id());
			
			
			if(uo == null){//如果user_org表中不存在，则新增
				Map<String,Object> paramMap =new  HashMap<String,Object>(); 
				paramMap.put("user_id", user.getUser_id());
				paramMap.put("orgId", user.getOrgId());
				oservice.insertUserOrg(paramMap);
			}else{//存在则修改
				
				Map<String,Object> paramMap =new  HashMap<String,Object>();
				paramMap.put("user_id", user.getUser_id());
				paramMap.put("orgId", user.getOrgId());
				oservice.updateUserOrg(paramMap);
				
			}
			
			
			//操作记录
	        System_Journal sj = new System_Journal();
	        sj.setDate(new Date());
	        sj.setModule("权限管理");
	        Administrators asd = admindao.findById((long)ata.getUser_id());
	        sj.setOperation_content("修改登录名为：　"+asd.getLoginName()+"　的权限");
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
			return "redirect:/updateAdmin.do";
			
		}
		/**
		 * 进入到注册页面
		 * @param m
		 * @param ata
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/zhuce.do")
		public String insertUser(Model m, Alltable ata, HttpServletRequest request){
			long pid = (long)request.getSession().getAttribute("power_id");
			ata.setPower_id(pid);
			List<Alltable> plist = service.isSelectOperateInPower(ata);
			m.addAttribute("kzlist", plist);
			return "insertinfo";
		}
		/**
		 * 验证用户名是否重复
		 * @param m
		 * @param admin
		 * @return
		 */
		@RequestMapping(value="/loginName.do")
		@ResponseBody
		public int vloginName(Model m, Administrators admin){
			int count = logservice.selectCountLoginName(admin);
			return count;
		}
		
		/**
		 * 添加无权限管理员账号
		 * @param m
		 * @param admin
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/zhuceguanli.do")
		public String insertAdmin(Model m, Administrators admin, HttpServletRequest request){
			logservice.insertUnOperateAdmin(admin);
			
			//操作记录
	        System_Journal sj = new System_Journal();
	        sj.setDate(new Date());
	        sj.setModule("权限管理");
	        sj.setOperation_content("添加管理账号");
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
			return "redirect:/insertAdmin.do";
		}
		/**
		 * 进入找回密码页
		 * @param m
		 * @param ata
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/zhaohui.do")
		public String EnterFindPass(){
			return "findLoginPass";
		}
}