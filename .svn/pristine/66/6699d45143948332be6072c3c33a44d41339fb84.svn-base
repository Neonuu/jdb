<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>未通过审核订单管理</title>
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
      url:"dataOrderNoIndex.do",
      type:"post",
      data:{"page":page,"name":$("#name").val(),"order_number":$("#order_number").val(),
            "user_identity":$("#user_identity").val(),"product":$("#product").val(),"user_idCardNumber":$("#idCardNumber").val(),
            "date1":$("#date1").val(),"date2":$("#date2").val(),"auditerName":$("#auditerName").val()},
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
     	   str+="<tr><td>"+data.list[i].name+"</td><td>"+data.list[i].order_number+"</td><td>"+
                data.list[i].user_identity+"</td><td>"+data.list[i].product+"</td><td>"+data.list[i].true_name+"</td><td>"+data.list[i].user_idCardNumber+"</td><td>"+
                data.list[i].money+"</td><td>"+data.list[i].recommemd+
                "</td><td>"+data.list[i].add_time+"</td><td>"+data.list[i].remark+"</td></tr>";
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
      url:"dataOrderNoIndex.do",
      type:"post",
      data:{"page":page,"name":$("#name").val(),"order_number":$("#order_number").val(),
            "user_identity":$("#user_identity").val(),"product":$("#product").val(),"user_idCardNumber":$("#idCardNumber").val(),
            "date1":$("#date1").val(),"date2":$("#date2").val(),"auditerName":$("#auditerName").val()},
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
     	  str+="<tr><td>"+data.list[i].name+"</td><td>"+data.list[i].order_number+"</td><td>"+
                data.list[i].user_identity+"</td><td>"+data.list[i].product+"</td><td>"+data.list[i].true_name+"</td><td>"+data.list[i].user_idCardNumber+"</td><td>"+
                data.list[i].money+"</td><td>"+data.list[i].recommemd+
                "</td><td>"+data.list[i].add_time+"</td><td>"+data.list[i].remark+"</td></tr>";
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
      url:"dataOrderNoIndex.do",
      type:"post",
      data:{"page":page,"name":$("#name").val(),"order_number":$("#order_number").val(),
            "user_identity":$("#user_identity").val(),"product":$("#product").val(),"user_idCardNumber":$("#idCardNumber").val(),
            "date1":$("#date1").val(),"date2":$("#date2").val(),"auditerName":$("#auditerName").val()},
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
     	  str+="<tr><td>"+data.list[i].name+"</td><td>"+data.list[i].order_number+"</td><td>"+
                data.list[i].user_identity+"</td><td>"+data.list[i].product+"</td><td>"+data.list[i].true_name+"</td><td>"+data.list[i].user_idCardNumber+"</td><td>"+
                data.list[i].money+"</td><td>"+data.list[i].recommemd+
                "</td><td>"+data.list[i].add_time+"</td><td>"+data.list[i].remark+"</td></tr>";
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
      url:"dataOrderNoIndex.do",
      type:"post",
      data:{"page":page,"name":$("#name").val(),"order_number":$("#order_number").val(),
            "user_identity":$("#user_identity").val(),"product":$("#product").val(),"user_idCardNumber":$("#idCardNumber").val(),
            "date1":$("#date1").val(),"date2":$("#date2").val(),"auditerName":$("#auditerName").val()},
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
     	  str+="<tr><td>"+data.list[i].name+"</td><td>"+data.list[i].order_number+"</td><td>"+
                data.list[i].user_identity+"</td><td>"+data.list[i].product+"</td><td>"+data.list[i].true_name+"</td><td>"+data.list[i].user_idCardNumber+"</td><td>"+
                data.list[i].money+"</td><td>"+data.list[i].recommemd+
                "</td><td>"+data.list[i].add_time+"</td><td>"+data.list[i].remark+"</td></tr>";
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
      url:"dataOrderNoIndex.do",
      type:"post",
      data:{"page":page,"name":$("#name").val(),"order_number":$("#order_number").val(),
            "user_identity":$("#user_identity").val(),"product":$("#product").val(),"user_idCardNumber":$("#idCardNumber").val(),
            "date1":$("#date1").val(),"date2":$("#date2").val(),"auditerName":$("#auditerName").val()},
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
     	  str+="<tr><td>"+data.list[i].name+"</td><td>"+data.list[i].order_number+"</td><td>"+
                data.list[i].user_identity+"</td><td>"+data.list[i].product+"</td><td>"+data.list[i].true_name+"</td><td>"+data.list[i].user_idCardNumber+"</td><td>"+
                data.list[i].money+"</td><td>"+data.list[i].recommemd+
                "</td><td>"+data.list[i].add_time+"</td><td>"+data.list[i].remark+"</td></tr>";
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
      url:"dataOrderNoIndex.do",
      type:"post",
      data:{"page":page,"name":$("#name").val(),"order_number":$("#order_number").val(),
            "user_identity":$("#user_identity").val(),"product":$("#product").val(),"user_idCardNumber":$("#idCardNumber").val(),
            "date1":$("#date1").val(),"date2":$("#date2").val(),"auditerName":$("#auditerName").val()},
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
     	  str+="<tr><td>"+data.list[i].name+"</td><td>"+data.list[i].order_number+"</td><td>"+
                data.list[i].user_identity+"</td><td>"+data.list[i].product+"</td><td>"+data.list[i].true_name+"</td><td>"+data.list[i].user_idCardNumber+"</td><td>"+
                data.list[i].money+"</td><td>"+data.list[i].recommemd+
                "</td><td>"+data.list[i].add_time+"</td><td>"+data.list[i].remark+"</td></tr>";
        }
        $("#tbody1").append(str);
        $("#btn2").html("第"+data.page);
        $("#span").html(data.totalCount);
        $("#num").val("");
      },
      error:function(){alert("查询出错了！");}
    });
});


$("#btn22").attr("class","btn btn-sm");
    
});

</script>
</head>

<body>
    <div style="text-align: left;" >
		  <c:forEach items="${kzlist}" var="kz">
		  <c:forEach items="${alloperate_id}" var="cz">
		  <c:if test="${kz.operate_id == cz}">
		  <input style="width:150px" type="button" value="${kz.operate_name}" id="btn${kz.operate_id}" name="btn${kz.operate_id}" onclick="window.location.href='${kz.operate_url}'" />
		  </c:if>
		  </c:forEach>
		  </c:forEach>
		  <hr/>
	 </div>
	
   <div class="templatemo-content-wrapper">
        <div class="faq-query">
          <div class="item">
             &nbsp;&nbsp;
             <input id="name" placeholder="客户经理电话" style="width:180px;"/> &nbsp;&nbsp;
		     <input id="order_number" placeholder="订单号" style="width:180px;"/> &nbsp;&nbsp;
		    <!--   <input id="product" placeholder="产品名" style="width:180px;"/>  -->
		      <input id="idCardNumber" placeholder="客户身份证号"/>  &nbsp;&nbsp;
		     <!--  <input id="auditerName" placeholder="审批人"/>  -->
			 <input id="date1" class="Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" placeholder="审批时间" style="width:180px;"/>&nbsp;至&nbsp;
			 <input id="date2" class="Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'}) "  placeholder="审批时间" style="width:180px;"/>&nbsp;&nbsp;
			产品： <select id="product">
			         <option value="" selected="selected">所有</option>
				     <c:forEach items="${productions}" var="p">
				        <option value="${p.proName}">${p.proName}</option>
				     </c:forEach>
		     	</select>&nbsp;&nbsp;
			 <a href="#" class="btn bg-warning" id="btn4">查询</a>
          </div>
        </div>
        <hr/>
        <div class="widget-table">
            <div class="widget-content">
               <table border='1px' id="table1" class="table table-striped table-bordered">
				   <thead>
			           <tr>
				           <td>客户经理电话</td><td style="width:150px;">订单号</td><td>客户身份</td><td>产品名</td><td>客户名</td><td>身份证号</td><td>金额</td><td>审批人</td><td style="width:100px;">审批时间</td><td style="width:200px;">状态</td>
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