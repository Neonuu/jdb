package com.zp.jdb.controllor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zp.jdb.entity.Alltable;
import com.zp.jdb.entity.Jiaodanliang;
import com.zp.jdb.entity.Order_inHours;
import com.zp.jdb.service.AdminService;
import com.zp.jdb.service.NewOrderlnHoursService;
import com.zp.jdb.util.ConstantValue;


@Controller
public class Auditing_orderControllor {
	
	@Resource
	private NewOrderlnHoursService service;
	@Resource
	private AdminService service2;
	
	/**
	 * 交单量排行
	 * @param m
	 * @param ata
	 * @param request
	 * @param all
	 * @return
	 */
	@RequestMapping(value="/jiaodanph.do")
	public String PH1(Model m, Order_inHours ata, HttpServletRequest request, Alltable all){
		long pid = (long)request.getSession().getAttribute("power_id");
		all.setPower_id(pid);
		List<Alltable> plist = service2.isSelectOperateInPower(all);
		m.addAttribute("kzlist", plist);
		
		List<Jiaodanliang> list = service.jiaodanliangPH(ata);
		
		int total = service.jiaodanfy();
		int maxpage = (total % ConstantValue.PAGE_COUNT == 0) ? (total / ConstantValue.PAGE_COUNT) : (total / ConstantValue.PAGE_COUNT + 1);
		System.out.println("总数"+total);
		System.out.println("最大也"+maxpage);
		if(maxpage == 0){
			maxpage = 1;
		}
		ata.setTotalCount(total);
		ata.setMaxpage(maxpage);
		int pm = 0;
		for(Jiaodanliang ao : list){
			pm++;
			String pn = "";
			pn = ao.getPhoneNumber().substring(0, 3)+"****"+ao.getPhoneNumber().substring(7);
			ao.setPhoneNumber(pn);
			String na = "";
			na = ao.getUser_name().substring(0, 1)+"**";
			ao.setUser_name(na);
			ao.setPm((ata.getPagenum()-1)*10+pm);
		}
		m.addAttribute("svo", ata);
		m.addAttribute("jdph", list);
		return"jiaodan";
	}
	/**
	 * 成交量排行
	 * @param m
	 * @param ata
	 * @param request
	 * @param all
	 * @return
	 */
	@RequestMapping(value="/chengjiaoph.do")
	public String PH2(Model m, Order_inHours ata, HttpServletRequest request, Alltable all){
		long pid = (long)request.getSession().getAttribute("power_id");
		all.setPower_id(pid);
		List<Alltable> plist = service2.isSelectOperateInPower(all);
		m.addAttribute("kzlist", plist);
		List<Order_inHours> list = service.chengjiaoliangPH(ata);
		int total = service.chengjiaofy();
		int maxpage = (total % ConstantValue.PAGE_COUNT == 0) ? (total / ConstantValue.PAGE_COUNT) : (total / ConstantValue.PAGE_COUNT + 1); 
		if(maxpage == 0){
			maxpage = 1;
		}
		ata.setTotalCount(total);
		ata.setMaxpage(maxpage);
		for(Order_inHours ao:list){
			String pn = "";
			pn = ao.getUser_phoneNumber().substring(0, 3)+"****"+ao.getUser_phoneNumber().substring(7);
			ao.setUser_phoneNumber(pn);
			String na = "";
			na = ao.getUser_name().substring(0, 1)+"**";
			ao.setUser_name(na);
		}
		m.addAttribute("svo", ata);
		m.addAttribute("cjph", list);
		return"chengjiao";
	}
	/**
	 * 成交额排行
	 * @param m
	 * @param ata
	 * @param request
	 * @param all
	 * @return
	 */
	@RequestMapping(value="/moneyph.do")
	public String PH3(Model m, Order_inHours ata, HttpServletRequest request, Alltable all){
		long pid = (long)request.getSession().getAttribute("power_id");
		all.setPower_id(pid);
		List<Alltable> plist = service2.isSelectOperateInPower(all);
		m.addAttribute("kzlist", plist);
		List<Order_inHours> list = service.chengjiaoerPH(ata);
		int total = service.moneyfy();
		int maxpage = (total % ConstantValue.PAGE_COUNT == 0) ? (total / ConstantValue.PAGE_COUNT) : (total / ConstantValue.PAGE_COUNT + 1); 
		if(maxpage == 0){
			maxpage = 1;
		}
		ata.setTotalCount(total);
		ata.setMaxpage(maxpage);
		for(Order_inHours ao:list){
			String pn = "";
			pn = ao.getUser_phoneNumber().substring(0, 3)+"****"+ao.getUser_phoneNumber().substring(7);
			ao.setUser_phoneNumber(pn);
			String na = "";
			na = ao.getUser_name().substring(0, 1)+"**";
			ao.setUser_name(na);
		}
		m.addAttribute("svo", ata);
		m.addAttribute("cjeph", list);
		return"chengjiaomoney";
	}
	/**
	 * 返回排行页
	 * @return
	 */
	@RequestMapping(value="/fanhuipaihang.do")
	public String FHPH(){
		return"paihang";
	}
}