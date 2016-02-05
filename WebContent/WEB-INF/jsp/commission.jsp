<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>佣金管理</title>
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
      url:"dataCommissionIndex.do",
      type:"post",
      data:{"page":page,"name":$("#name").val(),"balance":$("#balance").val(),"can_use_balance":$("#can_use_balance").val(),"total_balance1":$("#total_balance1").val(),"total_balance2":$("#total_balance2").val()},
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
          str+="<tr><td>"+data.list[i].id+"</td><td>"+data.list[i].name+"</td><td>"+data.list[i].balance+
               "</td><td>"+data.list[i].canUseBalance+"</td><td>"+data.list[i].recommemd+"</td><td>"+data.list[i].co_time+
               "</td><td><a href='javascript:getUserId("+data.list[i].userId+")' class='btn btn-sm'>查看佣金交易记录</a></td></tr>";
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
      url:"dataCommissionIndex.do",
      type:"post",
      data:{"page":page,"name":$("#name").val(),"balance":$("#balance").val(),"can_use_balance":$("#can_use_balance").val(),"total_balance1":$("#total_balance1").val(),"total_balance2":$("#total_balance2").val()},
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
          str+="<tr><td>"+data.list[i].id+"</td><td>"+data.list[i].name+"</td><td>"+data.list[i].balance+
          "</td><td>"+data.list[i].canUseBalance+"</td><td>"+data.list[i].recommemd+"</td><td>"+data.list[i].co_time+
          "</td><td><a href='javascript:getUserId("+data.list[i].userId+")' class='btn btn-sm'>查看佣金交易记录</a></td></tr>";
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
      url:"dataCommissionIndex.do",
      type:"post",
      data:{"page":page,"name":$("#name").val(),"balance":$("#balance").val(),"can_use_balance":$("#can_use_balance").val(),"total_balance1":$("#total_balance1").val(),"total_balance2":$("#total_balance2").val()},
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
          str+="<tr><td>"+data.list[i].id+"</td><td>"+data.list[i].name+"</td><td>"+data.list[i].balance+
          "</td><td>"+data.list[i].canUseBalance+"</td><td>"+data.list[i].recommemd+"</td><td>"+data.list[i].co_time+
          "</td><td><a href='javascript:getUserId("+data.list[i].userId+")' class='btn btn-sm'>查看佣金交易记录</a></td></tr>";
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
      url:"dataCommissionIndex.do",
      type:"post",
      data:{"page":page,"name":$("#name").val(),"balance":$("#balance").val(),"can_use_balance":$("#can_use_balance").val(),"total_balance1":$("#total_balance1").val(),"total_balance2":$("#total_balance2").val()},
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
          str+="<tr><td>"+data.list[i].id+"</td><td>"+data.list[i].name+"</td><td>"+data.list[i].balance+
          "</td><td>"+data.list[i].canUseBalance+"</td><td>"+data.list[i].recommemd+"</td><td>"+data.list[i].co_time+
          "</td><td><a href='javascript:getUserId("+data.list[i].userId+")' class='btn btn-sm'>查看佣金交易记录</a></td></tr>";
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
      url:"dataCommissionIndex.do",
      type:"post",
      data:{"page":page,"name":$("#name").val(),"balance":$("#balance").val(),"can_use_balance":$("#can_use_balance").val(),"total_balance1":$("#total_balance1").val(),"total_balance2":$("#total_balance2").val()},
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
          str+="<tr><td>"+data.list[i].id+"</td><td>"+data.list[i].name+"</td><td>"+data.list[i].balance+
          "</td><td>"+data.list[i].canUseBalance+"</td><td>"+data.list[i].recommemd+"</td><td>"+data.list[i].co_time+
          "</td><td><a href='javascript:getUserId("+data.list[i].userId+")' class='btn btn-sm'>查看佣金交易记录</a></td></tr>";
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
      url:"dataCommissionIndex.do",
      type:"post",
      data:{"page":page,"name":$("#name").val(),"balance":$("#balance").val(),"can_use_balance":$("#can_use_balance").val(),"total_balance1":$("#total_balance1").val(),"total_balance2":$("#total_balance2").val()},
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
          str+="<tr><td>"+data.list[i].id+"</td><td>"+data.list[i].name+"</td><td>"+data.list[i].balance+
          "</td><td>"+data.list[i].canUseBalance+"</td><td>"+data.list[i].recommemd+"</td><td>"+data.list[i].co_time+
          "</td><td><a href='javascript:getUserId("+data.list[i].userId+")' class='btn btn-sm'>查看佣金交易记录</a></td></tr>";
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
});
//点击修改时获取当前显示用户的id
function getUserId(userId){
	 window.location.href="toCommissionDetailIndex.do?user_id="+userId;
}

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
 
  <div class="templatemo-content-wrapper">
        <div class="faq-query">
          <div class="item">
              &nbsp;&nbsp;
             <input id="name" placeholder="客户经理电话"/>  &nbsp;&nbsp;
		     <input id="balance" placeholder="可提现余额" type="number"/>  &nbsp;&nbsp;至&nbsp;&nbsp;
		     <input id="can_use_balance" placeholder="可提现余额" type="number"/>  &nbsp;&nbsp;
		     <input id="total_balance1" placeholder="佣金总额" type="number"/>  &nbsp;&nbsp;至&nbsp;&nbsp;
		     <input id="total_balance2" placeholder="佣金总额" type="number"/>  &nbsp;&nbsp;
          </div>
          <div class="item query-btn"><a href="#" class="btn bg-warning" id="btn4">查询</a></div>
        </div>
        <hr/>
        <div class="widget-table">
            <div class="widget-content" style="height: 400px;">
               <table border='1px' id="table1" class="table table-striped table-bordered">
				   <thead>
			           <tr>
			           	   <td>ID</td><td>客户经理电话</td><td>可提现余额</td><td>佣金总额</td><td>推广人</td><td>注册时间</td><td>操作</td>
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
			        <button id="last" class="btn btn-sm" >尾页</button>&nbsp;
			        <input  type="text" placeholder="页码" id="num" style="width:60px;height:25px;" onkeyup="value=value.replace(/[^\d]/g,'')"/>
			        <button id="go" class="btn btn-sm" >跳转</button>&nbsp;
       		 </div>
     </div>   
</body>
</html>