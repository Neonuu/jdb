package com.zp.jdb.controllor;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zp.jdb.entity.CustomerO;

import com.zp.jdb.entity.Housing;
import com.zp.jdb.entity.Img_forhouse;
import com.zp.jdb.entity.Order_inHours;
import com.zp.jdb.service.HouseInformationService;

@Controller
public class HouseInformationControllor {
	@Resource
	private HouseInformationService service;
	
	@RequestMapping(value="/houseinfo.do")
	public String insertCarInformation(Model m, Housing h, @RequestParam MultipartFile[] myfiles,String ID,HttpServletRequest request){
//		List<String> tupian = new ArrayList<String>();
		System.out.println("kkkk");
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
            	Order_inHours s = service.findOrderByIdAndStatus(id);
            	Img_forhouse house = new Img_forhouse();
                house.setImg(databaseName);
                house.setOrder_number(s.getOrder_number());
                service.insertHouseImg(house);
//                h.setPhoto(databaseName);
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
        int rowNum = Integer.parseInt(request.getParameter("hiddenValue2"));
        System.out.println("2:"+rowNum);
        if(rowNum>=0){
        	Long id = Long.parseLong(ID);
        	Order_inHours s = service.findOrderByIdAndStatus(id);
   		    CustomerO c = service.findUser_id(s.getUser_idCardNumber());
        	for(int i=0;i<=rowNum;i++){
//        	  String databaseName = tupian.get(i);
        	  String housingName = request.getParameter("housingName"+i);
        	  String housingAddress = request.getParameter("housingAddress"+i);
        	  String housingFCZ = request.getParameter("housingFCZ"+i);
        	  String Cnotear = request.getParameter("cnotear"+i);
        	  String uid = request.getParameter("user_id");
        	  int uid2 = Integer.parseInt(uid);
        	  
        	  Date date = new Date();
//        	  h.setPhoto(databaseName);
        	  h.setHousingName(housingName);
        	  h.setHousingAddress(housingAddress);
        	  h.setHousingFCZ(housingFCZ);
        	  h.setCnotear(Cnotear);
        	  h.setAdd_time(date);
        	  h.setCustomerid(c.getId());
        	  h.setOrder_number(s.getOrder_number());
        	  h.setUser_id(uid2);
        	  
        		
//        	 paramMap.put("housingName"+i,h.getHousingName() );
//       		 paramMap.put("housingAddress"+i,h.getHousingAddress() );
//       		 paramMap.put("housingFCZ"+i,h.getHousingFCZ() );
//       		 paramMap.put("Cnotear"+i,h.getCnotear() );
//       		 paramMap.put("order_number"+i,s.getOrder_number());
//       		 Date date = new Date();
//       		 paramMap.put("add_time",date);
//       		 paramMap.put("order_number",s.getOrder_number());
//             paramMap.put("user_id", s.getUser_id());
//             paramMap.put("customerid", c.getId());
       		service.isinsertHouseInfo(h);
       		service.isupdateStatus(id);
        	}
        	
        } 
		
		 
		 
		
		return "redirect:/toOrderOneIndex.do";
		}
	
//	@RequestMapping("/toBuChongCaiLiao.do")
//	public String tojsp(String ID,Model model){
//		
//		System.out.println(ID);
//		model.addAttribute("ID",ID);
//        return "add_house_information";
//	}
	
	

}

