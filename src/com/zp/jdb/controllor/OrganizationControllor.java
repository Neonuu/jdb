package com.zp.jdb.controllor;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.zp.jdb.dao.System_JournalDao;
import com.zp.jdb.entity.Administrators;
import com.zp.jdb.entity.Alltable;
import com.zp.jdb.entity.Organization;
import com.zp.jdb.entity.System_Journal;
import com.zp.jdb.entity.User_Org;
import com.zp.jdb.service.AdminService;
import com.zp.jdb.service.OrganizationService;
import com.zp.jdb.service.ProductionService;
import com.zp.jdb.service.System_JournalService;


@Controller
public class OrganizationControllor {
	private Integer pageSize=10;//每页几个结果
	@Resource
	private OrganizationService service;
	
	@Resource
	private ProductionService pservice;
	
	@Resource
	private AdminService adservice;
	
	@Resource
	private System_JournalService sjservice;
	
	@RequestMapping("/organization.do")
	public String organization(Alltable ata,HttpServletRequest request, Model m){
		long pid = (long)request.getSession().getAttribute("power_id");
		ata.setPower_id(pid);
		List<Alltable> alist = adservice.isSelectOperateInPower(ata);
		m.addAttribute("kzlist", alist);
		
		return "organization/organization";
	}
	
	/**
	 * 点击机构入驻，跳转到机构入驻页面
	 * @param ata
	 * @param request
	 * @param m
	 * @return
	 */
	
	@RequestMapping("/insertOrgjsp.do")
	public String insertOrgjsp(Alltable ata,HttpServletRequest request,Model m){
		long pid = (long)request.getSession().getAttribute("power_id");
		ata.setPower_id(pid);
		List<Alltable> alist = adservice.isSelectOperateInPower(ata);
		m.addAttribute("kzlist", alist);
		return "organization/insertOrg";
	}

	
	/**
	 * 机构入驻
	 * @param m
	 * @param org
	 * @param myfiles
	 * @param request
	 * @param ata
	 * @return
	 */
	@RequestMapping("/insertOrg.do")
	public String insertOrganization(Model m, Organization org, @RequestParam MultipartFile[] myfiles, HttpServletRequest request,Alltable ata){
		long pid = (long)request.getSession().getAttribute("power_id");
		ata.setPower_id(pid);
		List<Alltable> alist = adservice.isSelectOperateInPower(ata);
		m.addAttribute("kzlist", alist);
		
		Map<String,Object> paramMap =new  HashMap<String,Object>();
	
		//如果只是上传一个文件，则只需要MultipartFile类型接收文件即可，而且无需显式指定@RequestParam注解  
        //如果想上传多个文件，那么这里就要用MultipartFile[]类型来接收文件，并且还要指定@RequestParam注解  
        //并且上传多个文件时，前台表单中的所有<input type="file"/>的name都应该是myfiles，否则参数里的myfiles无法获取到所有上传的文件  
        for(MultipartFile myfile : myfiles){  
            if(myfile.isEmpty()){  
                System.out.println("文件未上传");  
            }else{  
                System.out.println("文件长度: " + myfile.getSize());  
                System.out.println("文件类型: " + myfile.getContentType());  
                System.out.println("文件名称: " + myfile.getName());  
                System.out.println("文件原名: " + myfile.getOriginalFilename());  
                System.out.println("========================================"); 
                //获得文件后缀名  
	            String suffix = myfile.getOriginalFilename().substring(myfile.getOriginalFilename().lastIndexOf("."));
                
	            // 获取时间戳
            	String t = String.valueOf(System.currentTimeMillis());
                // 文件存入数据库中的名 = 地址+获取时间戳+"."图片后缀名
            	String databaseName = PublicControllor.IP_address+"/upload/upload/"+t+suffix;
	            
                // 文件存入数据库中的名 = 获取时间戳+"."图片扩展名
                String newFileName = "upload/"+t+suffix;
                
                System.out.println("文件存入数据库中的名: " + databaseName);
                paramMap.put("orgLogo", databaseName);
                
                //如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\CommandFile/JDB\\文件夹中  
                String realPath = request.getSession().getServletContext().getRealPath("/upload");  
                //这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的  
                System.out.println(realPath);
                try {
					FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, newFileName));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
                
            }  
        }  
        
        paramMap.put("orgId", org.getOrgId());
		paramMap.put("orgName", org.getOrgName());
		paramMap.put("maxRebate", org.getMaxRebate());
		paramMap.put("area", org.getArea());
		paramMap.put("statements", org.getStatements());
		paramMap.put("isdel", org.getIsdel());
		paramMap.put("creditEnquiryCost", org.getCreditEnquiryCost());
		paramMap.put("doorServiceCost", org.getDoorServiceCost());
		paramMap.put("loanHandCost", org.getLoanHandCost());
        service.insertOrganization(paramMap);
        
        //操作记录
        System_Journal sj = new System_Journal();
        sj.setDate(new Date());
        sj.setModule("机构管理");
        sj.setOperation_content("增加机构"+org.getOrgName());
        long id = (Long) request.getSession().getAttribute("user_id");
        Administrators ad = service.findById(id);
        String name = ad.getLoginName();
        sj.setOperator(name);
        sj.setType("增加");
        try {
			sjservice.addJournal(sj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return "redirect:/select.do";
	}
	

	
	
	/**
	 * 条件查询机构
	 * @param org
	 * @param page
	 * @param m
	 * @param ata
	 * @param request
	 * @return
	 */
	@RequestMapping("/select.do")
	public String selectOrganizationsByCondition(Organization org, String page,  Model m,Alltable ata,HttpServletRequest request){

		long pid = (long)request.getSession().getAttribute("power_id");
		ata.setPower_id(pid);
		List<Alltable> alist = adservice.isSelectOperateInPower(ata);
		m.addAttribute("kzlist", alist);
		
		long id = (Long) request.getSession().getAttribute("user_id");
		int user_id = (int)id;
		String orgId = service.selectOrgByUser(user_id);
		System.out.println(orgId);
		
		int intPage;
		if(page == "" || page == null ){
			 intPage=1;
		}else{
			System.out.println("页码："+page);
			intPage=Integer.parseInt(page);
		}
		if(orgId.equals("0,")){//系统管理员可以查看所有机构
			
			Map<String,Object> paramMap =new  HashMap<String,Object>(); 
			paramMap.put("page", intPage);
			paramMap.put("pageIndex", (intPage-1)*pageSize);//每页第一个结果的下角标
			paramMap.put("pageSize", pageSize);//每页多少条结果
			paramMap.put("orgId", org.getOrgId());
			paramMap.put("orgName", org.getOrgName());
			paramMap.put("area", org.getArea());
			
			List<Organization> list = service.selectOrganizationsByCondition(paramMap);
			int total = service.selectOrganizationTotal(paramMap);
			int maxpage = (total % pageSize == 0) ? (total / pageSize) : (total / pageSize + 1);
			paramMap.put("maxpage", maxpage);
			
			if(list.isEmpty()){
				paramMap.put("maxpage", 1);
				paramMap.put("page", 1);
			}

			m.addAttribute("plist", list);
			m.addAttribute("svo", paramMap);
			return "organization/updateOrg";
			
		}
		
		if(orgId.equals("-1,")){
			Map<String,Object> paramMap =new  HashMap<String,Object>(); 
			paramMap.put("maxpage", 1);
			paramMap.put("page", 1);
			m.addAttribute("svo", paramMap);
			return "organization/updateOrg2";
		}
		
		else{//判断所属机构，若不是系统管理员，则只能查看本机构信息
			Map<String,Object> paramMap =new  HashMap<String,Object>(); 
			paramMap.put("page", intPage);
			paramMap.put("pageIndex", (intPage-1)*pageSize);//每页第一个结果的下角标
			paramMap.put("pageSize", pageSize);//每页多少条结果
			System.out.println(orgId.substring(0,orgId.lastIndexOf(",")));
			if(org.getOrgId() == null){//判断参数（查询条件）是否为空，若为空则查询该机构管理员所有所属机构
				paramMap.put("orgId", orgId.substring(0,orgId.lastIndexOf(",")));
			}else{//若不为空，则查询条件
				paramMap.put("orgId", org.getOrgId());
			}
			
			paramMap.put("orgName", org.getOrgName());
			paramMap.put("area", org.getArea());
			
			List<Organization> list = service.selectOrganizationsByCondition2(paramMap);
			
			int total = service.selectOrganizationTotal2(paramMap);
			int maxpage = (total % pageSize == 0) ? (total / pageSize) : (total / pageSize + 1);
			paramMap.put("maxpage", maxpage);
			
			if(list.isEmpty()){
				paramMap.put("maxpage", 1);
				paramMap.put("page", 1);
			}
			
			m.addAttribute("plist", list);
			m.addAttribute("svo", paramMap);
			return "organization/updateOrg2";
			
			}
		
		
	}
	
	/**
	 * 删除机构，更改机构isdel
	 * @param org
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateOrgIsdel.do")
	public String updateOrganizationIsdelByID(Organization org,HttpServletRequest request){
		
		Map<String,Object> paramMap =new  HashMap<String,Object>(); 
		paramMap.put("orgId", org.getOrgId());
		paramMap.put("isdel", org.getIsdel());
		pservice.updateProductionIsdelByOrg(paramMap);
		
		//同时删除该机构下的产品
		service.updateOrganizationIsdelByID(paramMap);
		
		Organization o = service.selectOrganizationByID2(org.getOrgId());
		
        //操作记录
        System_Journal sj = new System_Journal();
        sj.setDate(new Date());
        sj.setModule("机构管理");
        sj.setOperation_content("删除机构"+o.getOrgName()+"和该机构下的产品");
        long id = (Long) request.getSession().getAttribute("user_id");
        Administrators ad = service.findById(id);
        String name = ad.getLoginName();
        sj.setOperator(name);
        sj.setType("删除");
        try {
			sjservice.addJournal(sj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/select.do"; 		
	}
	
	/**
	 * 把要更改的机构信息发到更改界面更上
	 * @param orgId
	 * @param m
	 * @param ata
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/entryUpdate.do")
	public String entryUpdate(Integer orgId, Model m,Alltable ata,HttpServletRequest request) throws Exception{
		long pid = (long)request.getSession().getAttribute("power_id");
		ata.setPower_id(pid);
		List<Alltable> alist = adservice.isSelectOperateInPower(ata);
		m.addAttribute("kzlist", alist);
		
		Organization o = null;
		if(orgId != null){
			o = service.selectOrganizationByID(orgId);
		}
		//List<Depts> list = ds.selectExistDeptList();
		m.addAttribute("organization", o);
		//m.addAttribute("dlist", list);
		return "organization/entryUpdateOrg";	
	}
	
	/**
	 * 更改机构信息
	 * @param org
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateOrg.do")
	public String updateOrganization(Organization org,HttpServletRequest request){
		
		Map<String,Object> paramMap =new  HashMap<String,Object>(); 
		paramMap.put("orgId", org.getOrgId());
		paramMap.put("orgName", org.getOrgName());
		paramMap.put("maxRebate", org.getMaxRebate());
		paramMap.put("area", org.getArea());
		paramMap.put("statements", org.getStatements());
		paramMap.put("isdel", org.getIsdel());
		paramMap.put("creditEnquiryCost", org.getCreditEnquiryCost());
		paramMap.put("doorServiceCost", org.getDoorServiceCost());
		paramMap.put("loanHandCost", org.getLoanHandCost());
		
		
		service.updateOrganization(paramMap);
		
        //操作记录
        System_Journal sj = new System_Journal();
        sj.setDate(new Date());
        sj.setModule("机构管理");
        sj.setOperation_content("修改机构"+org.getOrgName()+"的信息");
        long id = (Long) request.getSession().getAttribute("user_id");
        Administrators ad = service.findById(id);
        String name = ad.getLoginName();
        sj.setOperator(name);
        sj.setType("修改");
        try {
			sjservice.addJournal(sj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		

		return "redirect:/select.do";		
	}
	
	/**
	 * 查看机构Logo
	 * @param orgId
	 * @param m
	 * @param ata
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showLogo.do")
	public String showLogo(Integer orgId, Model m,Alltable ata,HttpServletRequest request) throws Exception{
		long pid = (long)request.getSession().getAttribute("power_id");
		ata.setPower_id(pid);
		List<Alltable> alist = adservice.isSelectOperateInPower(ata);
		m.addAttribute("kzlist", alist);
		
		Organization o = null;
		if(orgId != null){
			o = service.selectOrganizationByID(orgId);
		}
		//List<Depts> list = ds.selectExistDeptList();
		m.addAttribute("organization", o);
		//m.addAttribute("dlist", list);
		return "organization/showLogo";	
	}
	
	
//	@RequestMapping("/updateOrgLogo.do")
//	public String fileUpload2(Organization org,HttpServletRequest request,HttpServletResponse response,Model m,Alltable ata) throws Exception{
//		System.out.println("hh");
//		long pid = (long)request.getSession().getAttribute("power_id");
//		ata.setPower_id(pid);
//		List<Alltable> alist = adservice.isSelectOperateInPower(ata);
//		m.addAttribute("kzlist", alist);
//		
//		System.out.println("id:"+org.getOrgId());
//	
//	    CommonsMultipartResolver cmr = new CommonsMultipartResolver(request.getServletContext());
//	    if(cmr.isMultipart(request)){
//	        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest)(request);
//	        Iterator<String> files = mRequest.getFileNames();
//	        while(files.hasNext()){
//	            MultipartFile mFile = mRequest.getFile(files.next());
//	            if(mFile != null){
//	                //获得文件后缀名  
//		            String suffix = mFile.getOriginalFilename().substring(mFile.getOriginalFilename().lastIndexOf("."));
//                	// 获取时间戳
//                	String t = String.valueOf(System.currentTimeMillis());
//                    // 文件存入数据库中的名 = 地址+获取时间戳+"."图片后缀名
//                	//String databaseName = PublicControllor.IP_address+"/upload/upload/"+t+suffix;
//                	String databaseName = PublicControllor.IP_address+"/upload/upload/"+t+suffix;
//                	
//					String newFileName = "upload/"+t+suffix;
//					
//					//System.out.println("文件存入数据库中的名: " + databaseName);
//					Map<String,Object> paramMap =new  HashMap<String,Object>();
//					paramMap.put("orgId", org.getOrgId());
//					paramMap.put("orgLogo", databaseName);
//					service.updateOrganizationLogo(paramMap);
//					
//	                //String fileName = UUID.randomUUID()+mFile.getOriginalFilename();
//					String fileName = t+suffix;
//	                String path = request.getSession().getServletContext().getRealPath("/upload")+"/upload/"+fileName;
//	                System.out.println(path);
//	                
//	                File localFile = new File(path);
//	                mFile.transferTo(localFile);
//	                request.setAttribute("fileUrl", path);
//	            }
//	        }
//	    }
//		//将修改后的Logo返回到jsp页面
//		Organization o = null;
//		if(org.getOrgId() != null){
//			o = service.selectOrganizationByID(org.getOrgId());
//		}
//		
//		m.addAttribute("organization", o);
//
//		return "organization/showLogo";
//	}  
	
	/**
	 * 更改机构Logo
	 * @param org
	 * @param myfiles
	 * @param request
	 * @param m
	 * @param ata
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/updateOrgLogo.do")
	public String updateOrganizationLogo(Organization org,@RequestParam MultipartFile[] myfiles, HttpServletRequest request,Model m,Alltable ata) throws IOException{
		long pid = (long)request.getSession().getAttribute("power_id");
		ata.setPower_id(pid);
		List<Alltable> alist = adservice.isSelectOperateInPower(ata);
		m.addAttribute("kzlist", alist);
		Map<String,Object> paramMap =new  HashMap<String,Object>();
		
		String imageCode = "-1";//默认上传失败  enctype="multipart/form-data"
	       
		
		paramMap.put("orgId", org.getOrgId());
		//System.out.println("id:"+paramMap.get("orgId"));
		
		//如果只是上传一个文件，则只需要MultipartFile类型接收文件即可，而且无需显式指定@RequestParam注解  
        //如果想上传多个文件，那么这里就要用MultipartFile[]类型来接收文件，并且还要指定@RequestParam注解  
        //并且上传多个文件时，前台表单中的所有<input type="file"/>的name都应该是myfiles，否则参数里的myfiles无法获取到所有上传的文件  
        for(MultipartFile myfile : myfiles){  
            if(myfile.isEmpty()){  
                System.out.println("文件未上传"); 
                imageCode = "1";//未选择图片
            }else{  
                System.out.println("文件长度: " + myfile.getSize());  
                System.out.println("文件类型: " + myfile.getContentType());  
                System.out.println("文件名称: " + myfile.getName());  
                System.out.println("文件原名: " + myfile.getOriginalFilename());  
                System.out.println("========================================"); 
                //获得文件后缀名  
	            String suffix = myfile.getOriginalFilename().substring(myfile.getOriginalFilename().lastIndexOf("."));
	            if(suffix.equals(".jpg") || suffix.equals(".gif") || suffix.equals(".png")) {//检测图片类型  
	                if(myfile.getSize() > 1000000) {  
	                    imageCode = "2";//图片过大  
	                    //throw new Exception("上传失败：文件大小不能超过1M");  
	                }else { 
	                	// 获取时间戳
	                	String t = String.valueOf(System.currentTimeMillis());
	                    // 文件存入数据库中的名 = 地址+获取时间戳+"."图片后缀名
	                	String databaseName = PublicControllor.IP_address+"/upload/upload/"+t+suffix;
	                	
						String newFileName = "upload/"+t+suffix;
						
						System.out.println("文件存入数据库中的名: " + databaseName);
						paramMap.put("orgLogo", databaseName);
						
						//如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\upload\\文件夹中  
						String realPath = request.getSession().getServletContext().getRealPath("/upload"); 
						//上传成功
						imageCode = "0";
						//这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的  
						System.out.println(realPath);
						try {
							FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, newFileName));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
						service.updateOrganizationLogo(paramMap);
						
						Organization o = service.selectOrganizationByID(org.getOrgId());
				        //操作记录
				        System_Journal sj = new System_Journal();
				        sj.setDate(new Date());
				        sj.setModule("机构管理");
				        sj.setOperation_content("修改机构"+o.getOrgName()+"的Logo");
				        long id = (Long) request.getSession().getAttribute("user_id");
				        Administrators ad = service.findById(id);
				        String name = ad.getLoginName();
				        sj.setOperator(name);
				        sj.setType("修改");
				        try {
							sjservice.addJournal(sj);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                }  
	            }
	            else{//图片类型不符  
	                imageCode = "3";  
	            }
	                             
            } 
            System.out.println("imageCode:"+imageCode);
            m.addAttribute("imageCode",imageCode); 
        } 
		
		
		
		//将修改后的Logo返回到jsp页面
		Organization o = null;
		if(org.getOrgId() != null){
			o = service.selectOrganizationByID(org.getOrgId());
		}
		
		m.addAttribute("organization", o);

		return "organization/showLogo";		
	}
	
	/**
	 * 点击左侧菜单机构管理组中的机构管理
	 * @param ata
	 * @param m
	 * @param request
	 * @return
	 */
	@RequestMapping("/haha.do")
	public String selectOperateInPower(Alltable ata, Model m, HttpServletRequest request){
		request.getSession().setAttribute("power_id",ata.getPower_id());
		List<Alltable> alist = adservice.isSelectOperateInPower(ata);
		m.addAttribute("kzlist", alist);
		
		return "organization/organization";
		
	}
	
	/**
	 * 新增用户所属部门
	 * @param user
	 * @param m
	 * @param request
	 * @param ata
	 */
	  @RequestMapping("/insertUserOrg.do")
	  public void insertUserOrg(User_Org user, Model m,HttpServletRequest request, Alltable ata){ 
		
		Map<String,Object> paramMap =new  HashMap<String,Object>(); 
		paramMap.put("user_id", user.getUser_id());
		paramMap.put("orgId", user.getOrgId());
		service.insertUserOrg(paramMap);
        //操作记录
        System_Journal sj = new System_Journal();
        sj.setDate(new Date());
        sj.setModule("权限管理");
        sj.setOperation_content("将id为"+user.getUser_id()+"的管理员分配到id为"+user.getOrgId()+"的部门");
        long id = (Long) request.getSession().getAttribute("user_id");
        Administrators ad = service.findById(id);
        String name = ad.getLoginName();
        sj.setOperator(name);
        sj.setType("增加");
        try {
			sjservice.addJournal(sj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return;
	}
	
	
	

//	public Integer getPage() {
//		return page;
//	}
//
//	public void setPage(Integer page) {
//		this.page = page;
//	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	

}
