<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>产品返佣管理</title>
<link href="/jdb/css/style.css" rel="stylesheet" type="text/css"/>
<link href="/jdb/css/grid.css" rel="stylesheet" type="text/css"/>
<link href="/jdb/css/font.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="/jdb/js/jquery.min.js"></script>
<script type="text/javascript">
function myfun(){
    $("#btn3").click();
}
window.onload=myfun;

$(function(){
var page=0;
 
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
      url:"dataCommissionDetailIndex.do",
      type:"post",
      data:{"page":page,"user_id":$("#user_id").val()},
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
          str+="<tr><td>"+data.list[i].name+"</td><td>"+data.list[i].change_amount+"</td><td>"
          +data.list[i].balance+"</td><td>"+data.list[i].state+"</td><td>"+data.list[i].add_time+
          "</td></tr>";
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
      url:"dataCommissionDetailIndex.do",
      type:"post",
      data:{"page":page,"user_id":$("#user_id").val()},
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
          str+="<tr><td>"+data.list[i].name+"</td><td>"+data.list[i].change_amount+
          "</td><td>"+data.list[i].balance+"</td><td>"+data.list[i].state+"</td><td>"
          +data.list[i].add_time+"</td></tr>";
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
    page=1
    $("#tbody1").html("");
    $.ajax({
      url:"dataCommissionDetailIndex.do",
      type:"post",
      data:{"page":page,"user_id":$("#user_id").val()},
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
          str+="<tr><td>"+data.list[i].name+"</td><td>"+data.list[i].change_amount+
          "</td><td>"+data.list[i].balance+"</td><td>"+data.list[i].state+"</td><td>"
          +data.list[i].add_time+"</td></tr>";
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
    page=Number($("#span").html());
    $("#tbody1").html("");
    $.ajax({
      url:"dataCommissionDetailIndex.do",
      type:"post",
      data:{"page":page,"user_id":$("#user_id").val()},
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
          str+="<tr><td>"+data.list[i].name+"</td><td>"+data.list[i].change_amount+
          "</td><td>"+data.list[i].balance+"</td><td>"+data.list[i].state+"</td><td>"
          +data.list[i].add_time+"</td></tr>";
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
     page=Number($("#num").val());
     if(page=="" || page==0){
   	     page=1;
     }
     if(Number(page)>Number($("#span").html())){
     	page=Number($("#span").html());
     }
    $("#tbody1").html("");
    $.ajax({
      url:"dataCommissionDetailIndex.do",
      type:"post",
      data:{"page":page,"user_id":$("#user_id").val()},
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
          str+="<tr><td>"+data.list[i].name+"</td><td>"+data.list[i].change_amount+
          "</td><td>"+data.list[i].balance+"</td><td>"+data.list[i].state+"</td><td>"
          +data.list[i].add_time+"</td></tr>";
        }
        $("#tbody1").append(str);
        $("#btn2").html("第"+data.page);
        $("#span").html(data.totalCount); 
        $("#num").val("");
      },
      error:function(){alert("查询出错了！");}
    });
});


 $("#btn7").attr("class","btn btn-sm");
 $("#btn4").click(function(){
 	window.location.href="toCommissionIndex.do";
 });
});

</script>
</head>

<body>
    <div style="text-align: left;"  class="templatemo-content-wrapper">
		  <c:forEach items="${kzlist}" var="kz">
		  <c:forEach items="${alloperate_id}" var="cz">
		  <c:if test="${kz.operate_id == cz}">
		  <input style="width:150px" type="button" value="${kz.operate_name}" id="btn${kz.operate_id}" name="btn${kz.operate_id}" onclick="window.location.href='${kz.operate_url}'" />
		  &nbsp;&nbsp;
		  </c:if>
		  </c:forEach>
		  </c:forEach>
		   <hr/>
	 </div>
   <div class="templatemo-content-wrapper" >
        <div class="faq-query">
          <div class="item">
            <input id="user_id" type="hidden" value="${user_id}"/>  &nbsp;&nbsp;
          </div>
        </div>
        <div class="widget-table">
            <div class="widget-content" style="height: 400px;">
               <table border='1px' id="table1" class="table table-striped table-bordered">
		           <thead>
			           <tr>
			           	   <td>客户经理电话</td><td>变动金额</td><td>余额</td><td>类型</td><td>交易时间</td>
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
	        <a id="btn3" href="#" class="btn btn-sm" >下一页</a>&nbsp;&nbsp;
	        <button id="last" class="btn btn-sm" >尾页</button>&nbsp;
	        <input  type="text" placeholder="页码" id="num" style="width:60px;height:25px;" onkeyup="value=value.replace(/[^\d]/g,'')"/>
	        <button id="go" class="btn btn-sm" >跳转</button>&nbsp;
	        <a id="btn4" href="#" class="btn btn-sm" >返回</a>&nbsp;
       </div>
    </div>
</body>
</html>