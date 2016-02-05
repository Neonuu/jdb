package com.zp.jdb.controllor;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zp.jdb.dao.AdministratorsDao;
import com.zp.jdb.entity.Administrators;
import com.zp.jdb.entity.B_Brand;
import com.zp.jdb.entity.Brand;
import com.zp.jdb.entity.Car;
import com.zp.jdb.entity.CustomerO;
import com.zp.jdb.entity.Img_forcar;
import com.zp.jdb.entity.Order_inHours;
import com.zp.jdb.entity.S_Series;
import com.zp.jdb.entity.Series;
import com.zp.jdb.entity.System_Journal;
import com.zp.jdb.service.AdminService;
import com.zp.jdb.service.CarInformationService;
import com.zp.jdb.service.System_JournalService;

@Controller
public class CarInformationControllor {
	@Resource
	private CarInformationService service;
	
	@Resource
	private AdminService adservice;
	@Resource
	private System_JournalService sjservice;
	
	@Resource
	private AdministratorsDao admindao;

	
	
	@RequestMapping("/toBuChongCaiLiao.do")
	public String tojsp(String ID,String user_id,Model model,HttpServletRequest request){
		 List<B_Brand> brand = service.findBrand();
		 model.addAttribute("brand",brand);
		 model.addAttribute("ID",ID);
		 model.addAttribute("user_id",user_id);
     	//补充材料的ID
     	request.getSession().setAttribute("addcarinfoID", ID);
        return "add_car_information";
	}
	
	@RequestMapping("/fanhuiBuChongCaiLiao.do")
	public String fanhuijsp(Model model,HttpServletRequest request){
		 List<B_Brand> brand = service.findBrand();
		 model.addAttribute("brand",brand);
		 String ID = (String) request.getSession().getAttribute("addcarinfoID");
		 model.addAttribute("ID",ID);
        return "add_car_information";
	}
	
	@RequestMapping("/chexi.do")
	@ResponseBody
	public List<S_Series> tocar(int id,S_Series s){
		s.setbID(id);
		List<S_Series> series = service.findSeries(id);
		return series;
	}
	
	
	
	@RequestMapping("/newcar.do")
	public String newcar(Model model, HttpServletRequest request){
		List<B_Brand> brand = service.findBrand();
		model.addAttribute("brand",brand);
        return "newCar";
	}
	
	@RequestMapping("/addname.do")
	public String addname(HttpServletRequest request, Brand b){
		service.addname(b.getBName());
        return "redirect:/newcar.do";
	}
	@RequestMapping("/addxilie.do")
	public String addxilie(HttpServletRequest request, Series s){
		service.addxilie(s);
		return "redirect:/fanhuiBuChongCaiLiao.do";
	}
	
	
	
	@RequestMapping(value="/carinfo.do")
	public String insertCarInformation(Model m, Car c,B_Brand b,Img_forcar car,S_Series s,String ID, @RequestParam MultipartFile[] myfiles, HttpServletRequest request){

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
                Long id = Long.parseLong(ID);
            	Order_inHours oi = service.findOrderByIdAndStatus(id);
            	car.setImg(databaseName);
            	car.setOrder_number(oi.getOrder_number());
            	service.insertCarImg(car);
                
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

        System.out.println("11111");
        int rowNum = Integer.parseInt(request.getParameter("hiddenValue"));
        if(rowNum>=0){
        	Long id = Long.parseLong(ID);
        	Order_inHours oi = service.findOrderByIdAndStatus(id);
    		CustomerO cu = service.findUser_id(oi.getUser_idCardNumber());
        	for(int i=0;i<=rowNum;i++){
        		int carbrand = Integer.parseInt(request.getParameter("carbrand"+i));
        		List<B_Brand> s_id = service.findById(carbrand);
//        		S_Series ss = new S_Series();
        		for(B_Brand ss:s_id){
        			String bName = ss.getbName();
        			c.setCarbrand(bName);
        		}
//        		System.out.println(carbrand+i);
//        		String carbrand = request.getParameter("carbrand"+i);
        		String carxilie = request.getParameter("carxilie"+i);
        		String carModel = request.getParameter("carModel"+i);
        		String carNiandai = request.getParameter("carNiandai"+i);
        		String carframe = request.getParameter("carframe"+i);
        		String cnotear = request.getParameter("cnotear"+i);
        		String uid = request.getParameter("user_id");
        		int uid2 = Integer.parseInt(uid);
        		
        		String totalString = carbrand+"|"+carxilie+"|"+carModel+"|"+carNiandai+"|"+carframe+"|"+cnotear;

        		System.out.println(i+":"+totalString);
        		Date date = new Date();
//        		c.setCarbrand(carbrand);
        		c.setCustomerID(cu.getId());
        		c.setCarxilie(carxilie);
        		c.setCarModel(carModel);
        		c.setCarNiandai(carNiandai);
        		c.setCarframe(carframe);
        		c.setCnotear(cnotear);
        		c.setOrder_number(oi.getOrder_number());
        		c.setAdd_time(date);
        		c.setUser_id(uid2);
        		
        		service.isinsertCarInfo(c);
        		service.isupdateStatus(id);
        	}
        	
        }
        
		
		
        	
		   //操作记录
	       System_Journal sj = new System_Journal();
	       sj.setDate(new Date());
	       sj.setModule("车辆材料补充");
	       sj.setOperation_content("上传车辆信息");
	       long uid = (Long) request.getSession().getAttribute("user_id");
	       Administrators ad = admindao.findById(uid);
	       String name = ad.getLoginName();
	       sj.setOperator(name);
	       sj.setType("材料上传");
	       try {
				sjservice.addJournal(sj);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "redirect:/toOrderOneIndex.do";
		}

}
