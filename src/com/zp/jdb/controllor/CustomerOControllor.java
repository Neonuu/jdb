package com.zp.jdb.controllor;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
		


import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zp.jdb.dao.AdministratorsDao;
import com.zp.jdb.entity.Administrators;
import com.zp.jdb.entity.Alltable;
import com.zp.jdb.entity.CustomerO;
import com.zp.jdb.entity.System_Journal;
import com.zp.jdb.service.AdminService;
import com.zp.jdb.service.CustomerOService;
import com.zp.jdb.service.System_JournalService;
import com.zp.jdb.util.ConstantValue;
		
@Controller
public class CustomerOControllor {
			
		@Resource
		private CustomerOService service1;
		@Resource
		private AdminService service2;
		
		@Resource
		private System_JournalService sjservice;
		
		@Resource
		private AdministratorsDao admindao;
		
		/**
		 * 查看用户
		 * @param m
		 * @param ata
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/chakanyonghu.do")
		public String yonghu(Model m, Alltable ata, HttpServletRequest request){
			long pid = (long)request.getSession().getAttribute("power_id");
			ata.setPower_id(pid);
			List<Alltable> plist = service2.isSelectOperateInPower(ata);
			m.addAttribute("kzlist", plist);
			List<Alltable> list1 = service2.selectAllUser(ata);
			int total = service2.isSelectAdminTotalCount3(ata);
			int maxpage = (total % ConstantValue.PAGE_COUNT == 0) ? (total / ConstantValue.PAGE_COUNT) : (total / ConstantValue.PAGE_COUNT + 1);
			if(maxpage == 0){
				maxpage = 1;
			}
			ata.setTotalCount(total);
			ata.setMaxpage(maxpage);
			m.addAttribute("ptlist", list1);
			m.addAttribute("svo", ata);
			return "yonghuKH";
		}
		/**
		 * 查看用户客户
		 * @param m
		 * @param cu
		 * @param request
		 * @param ata
		 * @return
		 */
		@RequestMapping(value="/wodekehu.do")
		public String kehu(Model m, CustomerO cu, HttpServletRequest request, Alltable ata){
			long pid = (long)request.getSession().getAttribute("power_id");
			ata.setPower_id(pid);
			List<Alltable> plist = service2.isSelectOperateInPower(ata);
			m.addAttribute("kzlist", plist);
			request.getSession().setAttribute("foruser_id", cu.getUser_id());
			List<CustomerO> list1 = service1.selectkehu(cu);
			int total = service1.selectkehufy(cu);
			int maxpage = (total % ConstantValue.PAGE_COUNT == 0) ? (total / ConstantValue.PAGE_COUNT) : (total / ConstantValue.PAGE_COUNT + 1);
			if(maxpage == 0){
				maxpage = 1;
			}
			cu.setTotalCount(total);
			cu.setMaxpage(maxpage);
			cu.setUser_id(cu.getUser_id());
			m.addAttribute("kehulist", list1);
			m.addAttribute("svo", cu);
			return "wodekehu";
		}
		/**
		 * 查看客户详情
		 * @param m
		 * @param cu
		 * @param ata
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/kehuxiangqing.do")
		public String kehuziliao(Model m, CustomerO cu, Alltable ata, HttpServletRequest request){
			long pid = (long)request.getSession().getAttribute("power_id");
			ata.setPower_id(pid);
			List<Alltable> plist = service2.isSelectOperateInPower(ata);
			m.addAttribute("kzlist", plist);
			CustomerO c = service1.selectkehuxinxi(cu);
			m.addAttribute("kehu", c);
			return "kehuxiangqing";
		}
		/**
		 * 查看客户详情
		 * @param m
		 * @param cu
		 * @param ata
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/kehuxiangqing2.do")
		public String kehuziliao2(Model m, CustomerO cu, Alltable ata, HttpServletRequest request){
			long pid = (long)request.getSession().getAttribute("power_id");
			ata.setPower_id(pid);
			List<Alltable> plist = service2.isSelectOperateInPower(ata);
			m.addAttribute("kzlist", plist);
			CustomerO c = service1.selectkehuxinxi(cu);
			m.addAttribute("kehu", c);
			return "kehuxiangqing2";
		}
		/**
		 * 修改客户资料
		 * @param m
		 * @param cu
		 * @param myfiles
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/xiugaikehuziliao.do")
		public String kehuziliaoxiugai(Model m, CustomerO cu, HttpServletRequest request){
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cu.setAdd_time(sdf.format(new Date()));
    		service1.updatekehu(cu);
			int user_id = (int)request.getSession().getAttribute("foruser_id");
			
			//操作记录
	        System_Journal sj = new System_Journal();
	        sj.setDate(new Date());
	        sj.setModule("客户管理");
	        sj.setOperation_content("修改客户：　("+cu.getId()+")"+cu.getCustomer_name()+"　的资料");
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
			return "redirect:/wodekehu.do?user_id="+user_id;
		}
		
		
		
		
		/**
		 * 修改客户资料
		 * @param m
		 * @param cu
		 * @param myfiles
		 * @param request
		 * @return
		 */
		@RequestMapping(value="/xiugaikehuziliao2.do")
		public String kehuziliaoxiugai2(Model m, CustomerO cu, HttpServletRequest request){
            	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                cu.setAdd_time(sdf.format(new Date()));
        		service1.updatekehu(cu);
			//操作记录
	        System_Journal sj = new System_Journal();
	        sj.setDate(new Date());
	        sj.setModule("用户管理");
	        sj.setOperation_content("修改客户：　("+cu.getId()+")"+cu.getCustomer_name()+"　的资料");
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
			return "redirect:/selectAllKehu.do";
		}
		
		
		
		
		
		@RequestMapping(value="/selectAllKehu.do")
		public String selectAllKehu(Model m, CustomerO c, HttpServletRequest request, Alltable ata){
			long pid = (long)request.getSession().getAttribute("power_id");
			ata.setPower_id(pid);
			List<Alltable> plist = service2.isSelectOperateInPower(ata);
			m.addAttribute("kzlist", plist);
			List<CustomerO> list = service1.selectAllKehu(c);
			int total = service1.selectAllKehuFY(c);
			int maxpage = (total % ConstantValue.PAGE_COUNT == 0) ? (total / ConstantValue.PAGE_COUNT) : (total / ConstantValue.PAGE_COUNT + 1);
			if(maxpage == 0){
				maxpage = 1;
			}
			c.setTotalCount(total);
			c.setMaxpage(maxpage);
			m.addAttribute("svo", c);
			m.addAttribute("clist", list);
			return "AllCustomer";
		}
	}