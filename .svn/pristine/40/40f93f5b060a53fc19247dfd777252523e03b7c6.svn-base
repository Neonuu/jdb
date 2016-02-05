<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统操作日志管理</title>
<link href="/jdb/css/style.css" rel="stylesheet" type="text/css"/>
<link href="/jdb/css/grid.css" rel="stylesheet" type="text/css"/>
<link href="/jdb/css/font.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="/jdb/js/jquery.min.js"></script>
<script language="javascript" type="text/javascript" src="/jdb/js/My97DatePicker/WdatePicker.js"></script>
<link href="/jdb/js/My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
function myfun(){
    $("#btn3").click();
}
window.onload=myfun;

$(function(){
 var page=0;
 $("#btn3").click;
//上一页
$("#btn1").click(function(){
    page=page-1;
    if(page<=0){
      page=page+1;
      alert("已经是第一页了！");
      return;
    }
    $("#tbody1").html("");
    $.ajax({
      url:"dateSystemJournal.do",
      type:"post",
      data:{"page":page,"module":$("#module").val(), "date1":$("#date1").val(),"date1":$("#date2").val()},
      dataType:"json",
      success:function(data){
        var str="";
        if(data.list.length==0){
           
            $("#tbody1").append(str);
            $("#btn2").html("第"+data.page);
            $("#span").html(data.totalCount);
            return;
         }
        for(var i=0;i<data.list.length;i++){
     	   str+="<tr><td>"+data.list[i].operation_content+"</td><td>"+data.list[i].module+"</td><td>"+
                data.list[i].strDate+"</td><td>"+data.list[i].operator+"</td><td>"+data.list[i].type+"</td></tr>";
        }
        $("#tbody1").append(str);
        $("#btn2").html("第"+data.page);
        $("#span").html(data.totalCount);
     
      },
      error:function(){alert("查询出错了！");}
    });
});


//下一页
 $("#btn3").click(function(){
    page=page+1;
    if(page>Number($("#span").html())){
      page=page-1;
      alert("已经是最后一页了！");
      return;
    }
   
    $("#tbody1").html("");
    $.ajax({
      url:"dateSystemJournal.do",
      type:"post",
      data:{"page":page,"module":$("#module").val(), "date1":$("#date1").val(),"date2":$("#date2").val()},
      dataType:"json",
      success:function(data){
        var str="";
        if(data.list.length==0){
           
            $("#tbody1").append(str);
            $("#btn2").html("第"+data.page);
            $("#span").html(data.totalCount);
            return;
         }
        for(var i=0;i<data.list.length;i++){
        	 str+="<tr><td>"+data.list[i].operation_content+"</td><td>"+data.list[i].module+"</td><td>"+
             data.list[i].strDate+"</td><td>"+data.list[i].operator+"</td><td>"+data.list[i].type+"</td></tr>";
        }
        $("#tbody1").append(str);
        $("#btn2").html("第"+data.page);
        $("#span").html(data.totalCount);
       
      },
      error:function(){alert("查询出错了！");}
    });
});

//搜索
 $("#btn4").click(function(){
    $("#tbody1").html("");
    page=1;
    $.ajax({
      url:"dateSystemJournal.do",
      type:"post",
      data:{"page":page,"module":$("#module").val(), "date1":$("#date1").val(),"date2":$("#date2").val()},
      dataType:"json",
      success:function(data){
        var str=""; 
        if(data.list.length==0){
           
            $("#tbody1").append(str);
            $("#btn2").html("第"+data.page);
            $("#span").html(data.totalCount);
            return;
         }
        for(var i=0;i<data.list.length;i++){
        	 str+="<tr><td>"+data.list[i].operation_content+"</td><td>"+data.list[i].module+"</td><td>"+
             data.list[i].strDate+"</td><td>"+data.list[i].operator+"</td><td>"+data.list[i].type+"</td></tr>";
        }
        $("#tbody1").append(str);
        $("#btn2").html("第"+data.page);
        $("#span").html(data.totalCount);
      
      },
      error:function(){alert("查询出错了！");}
    });
});

//首页
 $("#first").click(function(){
    $("#tbody1").html("");
    page=1;
    $.ajax({
      url:"dateSystemJournal.do",
      type:"post",
      data:{"page":page,"module":$("#module").val(), "date1":$("#date1").val(),"date2":$("#date2").val()},
      dataType:"json",
      success:function(data){
        var str=""; 
        if(data.list.length==0){
           
            $("#tbody1").append(str);
            $("#btn2").html("第"+data.page);
            $("#span").html(data.totalCount);
            return;
         }
        for(var i=0;i<data.list.length;i++){
        	 str+="<tr><td>"+data.list[i].operation_content+"</td><td>"+data.list[i].module+"</td><td>"+
             data.list[i].strDate+"</td><td>"+data.list[i].operator+"</td><td>"+data.list[i].type+"</td></tr>";
        }
        $("#tbody1").append(str);
        $("#btn2").html("第"+data.page);
        $("#span").html(data.totalCount);
      
      },
      error:function(){alert("查询出错了！");}
    });
});

//尾页
 $("#last").click(function(){
    $("#tbody1").html("");
    page=Number($("#span").html());
    $.ajax({
      url:"dateSystemJournal.do",
      type:"post",
      data:{"page":page,"module":$("#module").val(), "date1":$("#date1").val(),"date2":$("#date2").val()},
      dataType:"json",
      success:function(data){
        var str=""; 
        if(data.list.length==0){
           
            $("#tbody1").append(str);
            $("#btn2").html("第"+data.page);
            $("#span").html(data.totalCount);
            return;
         }
        for(var i=0;i<data.list.length;i++){
        	 str+="<tr><td>"+data.list[i].operation_content+"</td><td>"+data.list[i].module+"</td><td>"+
             data.list[i].strDate+"</td><td>"+data.list[i].operator+"</td><td>"+data.list[i].type+"</td></tr>";
        }
        $("#tbody1").append(str);
        $("#btn2").html("第"+data.page);
        $("#span").html(data.totalCount);
      
      },
      error:function(){alert("查询出错了！");}
    });
});

//跳转
 $("#go").click(function(){
    $("#tbody1").html("");
    page=Number($("#num").val());
    if(page=="" || page==0){
  	  page=1;
    }
    if(Number(page)>Number($("#span").html())){
    	page=Number($("#span").html());
    }
    $.ajax({
      url:"dateSystemJournal.do",
      type:"post",
      data:{"page":page,"module":$("#module").val(), "date1":$("#date1").val(),"date2":$("#date2").val()},
      dataType:"json",
      success:function(data){
        var str=""; 
        if(data.list.length==0){
           
            $("#tbody1").append(str);
            $("#btn2").html("第"+data.page);
            $("#span").html(data.totalCount);
            return;
         }
        for(var i=0;i<data.list.length;i++){
        	 str+="<tr><td>"+data.list[i].operation_content+"</td><td>"+data.list[i].module+"</td><td>"+
             data.list[i].strDate+"</td><td>"+data.list[i].operator+"</td><td>"+data.list[i].type+"</td></tr>";
        }
        $("#tbody1").append(str);
        $("#btn2").html("第"+data.page);
        $("#span").html(data.totalCount);
        $("#num").val("");
      },
      error:function(){alert("查询出错了！");}
    });
});   
});
</script>
</head>
<body>
   <div class="templatemo-content-wrapper">
        <div class="faq-query">
          <div class="item">
             &nbsp;&nbsp;
	                    所属模块：<select id="module">
				         <option value="" selected="selected">所有</option>
					     <option value="权限管理">权限管理</option>
					     <option value="机构管理">机构管理</option>
					     <option value="交单管理">交单管理</option>
					     <option value="佣金管理">佣金管理</option>
					     <option value="用户管理">用户管理</option>
					     <option value="短信管理">短信管理</option>
			     	</select>&nbsp;&nbsp;
					 <input id="date1" class="Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" placeholder="操作时间" style="width:180px;"/>&nbsp;至&nbsp;
					 <input id="date2" class="Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'}) "  placeholder="操作时间" style="width:180px;"/>&nbsp;&nbsp;
			        <a href="#" class="btn bg-warning" id="btn4">查询</a>
          </div>
        </div>
        <hr/>
        <div class="widget-table">
            <div class="widget-content">
               <table border='1px' id="table1" class="table table-striped table-bordered">
				   <thead>
			           <tr>
				           <td>操作内容</td><td style="width:150px;">所属模块</td><td>操作时间</td><td>操作者</td><td>操作类型</td>
			           </tr>
		           </thead>
		           <tbody id="tbody1"></tbody>
      		   </table>
      		</div>
      	 </div>
      	 <hr/>	
    	 <div  style="text-align: center;"><br/>
    	    <button id="first" class="btn btn-sm" >首页</button>&nbsp;
    		<a id="btn1" href="#" class="btn btn-sm" >上一页</a>&nbsp;
	        <span id="btn2">第1</span>/<span id="span">${totalCount}</span><span>页</span>
	        <a id="btn3" href="#" class="btn btn-sm" >下一页</a>&nbsp;
	        <button id="last"  class="btn btn-sm" >尾页</button>&nbsp;
	        <input  type="text" placeholder="页码" id="num" style="width:60px;height:25px;" onkeyup="value=value.replace(/[^\d]/g,'')"/>
			<button id="go" class="btn btn-sm" >跳转</button>&nbsp;
        </div>
    </div>
</body>
</html>