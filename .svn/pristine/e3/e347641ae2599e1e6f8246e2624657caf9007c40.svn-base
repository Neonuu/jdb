<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>返佣成功订单管理</title>
<link href="/jdb/css/style.css" rel="stylesheet" type="text/css"/>
<link href="/jdb/css/grid.css" rel="stylesheet" type="text/css"/>
<link href="/jdb/css/font.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="/jdb/js/jquery.min.js"></script>
<script type="text/javascript" src="/jdb/js/styleLayer/layer/layer.js"></script>
<script type="text/javascript" src="/jdb/js/styleLayer/layer/extend/layer.ext.js"></script>
<script language="javascript" type="text/javascript" src="/jdb/js/My97DatePicker/WdatePicker.js"></script>
<link href="/jdb/js/My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" >
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
      layer.msg("已经是第一页了！");
      return;
    }
    $("#tbody1").html("");
    $.ajax({
      url:"returnOrderFiveIndex.do",
      type:"post",
      data:{"page":page,"user_phoneNumber":$("#name").val(),"order_number":$("#order_number").val(),
            "user_identity":$("#user_identity").val(),"product":$("#product").val(),
            "true_name":$("#true_name").val(),"province":$("#province").val(),"user_idCardNumber":$("#idCardNumber").val(),
            "city":$("#city").val(),"date1":$("#date1").val(),"date2":$("#date2").val(),"auditer_name":$("#auditer_name").val()},
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
                data.list[i].user_identity+"</td><td>"+data.list[i].product+"</td><td>"+data.list[i].true_name+
                "</td><td>"+data.list[i].user_idCardNumber+"</td><td>"+data.list[i].tel_number+"</td><td>"+
                data.list[i].province+"</td><td>"+data.list[i].city+"</td><td>"+data.list[i].add_time+"</td><td>"+data.list[i].auditer_name+"</td>"+
                "<td><a href='javascript:chaKanXiangQing("+data.list[i].ID+")'  class='btn btn-sm'>查看详情</a></td></tr>";
        }
        $("#tbody1").append(str);
        $("#btn2").html("第"+data.page);
        $("#span").html(data.totalCount);
     
      },
      error:function(){layer.msg("查询出错了！");}
    });
});


//下一页
 $("#btn3").click(function(){
    page=Number(page)+1;
    if(page>Number($("#span").html())){
      page=page-1;
      layer.msg("已经是最后一页了！");
      return;
    }
   
    $("#tbody1").html("");
    $.ajax({
      url:"returnOrderFiveIndex.do",
      type:"post",
      data:{"page":page,"user_phoneNumber":$("#name").val(),"order_number":$("#order_number").val(),
            "user_identity":$("#user_identity").val(),"product":$("#product").val(),
            "true_name":$("#true_name").val(),"province":$("#province").val(),"user_idCardNumber":$("#idCardNumber").val(),
            "city":$("#city").val(),"date1":$("#date1").val(),"date2":$("#date2").val(),"auditer_name":$("#auditer_name").val()},
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
                data.list[i].user_identity+"</td><td>"+data.list[i].product+"</td><td>"+data.list[i].true_name+
                "</td><td>"+data.list[i].user_idCardNumber+"</td><td>"+data.list[i].tel_number+"</td><td>"+
                data.list[i].province+"</td><td>"+data.list[i].city+"</td><td>"+data.list[i].add_time+"</td><td>"+data.list[i].auditer_name+"</td>"+
                "<td><a href='javascript:chaKanXiangQing("+data.list[i].ID+")'  class='btn btn-sm'>查看详情</a></td></tr>";
        }
        $("#tbody1").append(str);
        $("#btn2").html("第"+data.page);
        $("#span").html(data.totalCount);
   
      },
      error:function(){layer.msg("查询出错了！");}
    });
});

//搜索
 $("#btn4").click(function(){
    $("#tbody1").html("");
     page=1;
    $.ajax({
      url:"returnOrderFiveIndex.do",
      type:"post",
      data:{"page":page,"user_phoneNumber":$("#name").val(),"order_number":$("#order_number").val(),
            "user_identity":$("#user_identity").val(),"product":$("#product").val(),
            "true_name":$("#true_name").val(),"province":$("#province").val(),"user_idCardNumber":$("#idCardNumber").val(),
            "city":$("#city").val(),"date1":$("#date1").val(),"date2":$("#date2").val(),"auditer_name":$("#auditer_name").val()},
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
                data.list[i].user_identity+"</td><td>"+data.list[i].product+"</td><td>"+data.list[i].true_name+
                "</td><td>"+data.list[i].user_idCardNumber+"</td><td>"+data.list[i].tel_number+"</td><td>"+
                data.list[i].province+"</td><td>"+data.list[i].city+"</td><td>"+data.list[i].add_time+"</td><td>"+data.list[i].auditer_name+"</td>"+
                "<td><a href='javascript:chaKanXiangQing("+data.list[i].ID+")'  class='btn btn-sm'>查看详情</a></td></tr>";
        }
        $("#tbody1").append(str);
        $("#btn2").html("第"+data.page);
        $("#span").html(data.totalCount);
      
      },
      error:function(){layer.msg("查询出错了！");}
    });
});

//首页
 $("#first").click(function(){
    $("#tbody1").html("");
     page=1;
    $.ajax({
      url:"returnOrderFiveIndex.do",
      type:"post",
      data:{"page":page,"user_phoneNumber":$("#name").val(),"order_number":$("#order_number").val(),
            "user_identity":$("#user_identity").val(),"product":$("#product").val(),
            "true_name":$("#true_name").val(),"province":$("#province").val(),"user_idCardNumber":$("#idCardNumber").val(),
            "city":$("#city").val(),"date1":$("#date1").val(),"date2":$("#date2").val(),"auditer_name":$("#auditer_name").val()},
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
                data.list[i].user_identity+"</td><td>"+data.list[i].product+"</td><td>"+data.list[i].true_name+
                "</td><td>"+data.list[i].user_idCardNumber+"</td><td>"+data.list[i].tel_number+"</td><td>"+
                data.list[i].province+"</td><td>"+data.list[i].city+"</td><td>"+data.list[i].add_time+"</td><td>"+data.list[i].auditer_name+"</td>"+
                "<td><a href='javascript:chaKanXiangQing("+data.list[i].ID+")'  class='btn btn-sm'>查看详情</a></td></tr>";
        }
        $("#tbody1").append(str);
        $("#btn2").html("第"+data.page);
        $("#span").html(data.totalCount);
      
      },
      error:function(){layer.msg("查询出错了！");}
    });
});

//尾页
 $("#last").click(function(){
    $("#tbody1").html("");
      page=Number($("#span").html());
    $.ajax({
      url:"returnOrderFiveIndex.do",
      type:"post",
      data:{"page":page,"user_phoneNumber":$("#name").val(),"order_number":$("#order_number").val(),
            "user_identity":$("#user_identity").val(),"product":$("#product").val(),
            "true_name":$("#true_name").val(),"province":$("#province").val(),"user_idCardNumber":$("#idCardNumber").val(),
            "city":$("#city").val(),"date1":$("#date1").val(),"date2":$("#date2").val(),"auditer_name":$("#auditer_name").val()},
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
                data.list[i].user_identity+"</td><td>"+data.list[i].product+"</td><td>"+data.list[i].true_name+
                "</td><td>"+data.list[i].user_idCardNumber+"</td><td>"+data.list[i].tel_number+"</td><td>"+
                data.list[i].province+"</td><td>"+data.list[i].city+"</td><td>"+data.list[i].add_time+"</td><td>"+data.list[i].auditer_name+"</td>"+
                "<td><a href='javascript:chaKanXiangQing("+data.list[i].ID+")'  class='btn btn-sm'>查看详情</a></td></tr>";
        }
        $("#tbody1").append(str);
        $("#btn2").html("第"+data.page);
        $("#span").html(data.totalCount);
      
      },
      error:function(){layer.msg("查询出错了！");}
    });
});

//跳转页
 $("#go").click(function(){
    $("#tbody1").html("");
      page=Number($("#num").val());
      if(page=="" || page==0){
    	  page=1;
      }
      if(page>Number($("#span").html())){
      	page=Number($("#span").html());
      }
    $.ajax({
      url:"returnOrderFiveIndex.do",
      type:"post",
      data:{"page":page,"user_phoneNumber":$("#name").val(),"order_number":$("#order_number").val(),
            "user_identity":$("#user_identity").val(),"product":$("#product").val(),
            "true_name":$("#true_name").val(),"province":$("#province").val(),"user_idCardNumber":$("#idCardNumber").val(),
            "city":$("#city").val(),"date1":$("#date1").val(),"date2":$("#date2").val(),"auditer_name":$("#auditer_name").val()},
      dataType:"json",
      success:function(data){
        var str=""; 
        if(data.list.length==0){        
            $("#tbody1").append(str);
            $("#btn2").html("第"+data.page);
            $("#span").html(data.totalCount);
            $("#num").val("");
            return;
         }
        for(var i=0;i<data.list.length;i++){
         str+="<tr><td>"+data.list[i].name+"</td><td>"+data.list[i].order_number+"</td><td>"+
                data.list[i].user_identity+"</td><td>"+data.list[i].product+"</td><td>"+data.list[i].true_name+
                "</td><td>"+data.list[i].user_idCardNumber+"</td><td>"+data.list[i].tel_number+"</td><td>"+
                data.list[i].province+"</td><td>"+data.list[i].city+"</td><td>"+data.list[i].add_time+"</td><td>"+data.list[i].auditer_name+"</td>"+
                "<td><a href='javascript:chaKanXiangQing("+data.list[i].ID+")'  class='btn btn-sm'>查看详情</a></td></tr>";
        }
        $("#tbody1").append(str);
        $("#btn2").html("第"+data.page);
        $("#span").html(data.totalCount);
        $("#num").val("");
      },
      error:function(){layer.msg("查询出错了！");}
    });
});

$('#province').on('change', function(){
	$("#city").html("<option selected value=''>全部</option>");
	if(this.value==""){
		return;
	}
	$.ajax({
		url:"dataCityIndex.do",
		type:"post",
		data:{"provinceName":this.value},
		dataType:"json",
		success:function(data){
			var str="";
			for(var i=0;i<data.city.length;i++){
				str+="<option  value="+data.city[i].name+">"+data.city[i].name+"</option>";
			}
			$("#city").append(str);
		}
	});
});

$(function(){
	$("#btn25").attr("class","btn btn-sm");
});

});

//查看订单详情调用的函数
function chaKanXiangQing(ID){
	layer.open({
	    type: 2,
	    title: '订单详情页',
	    shadeClose: true,
	    shade: 0.8,
	    area: ['1000px', '95%'],
	    content: 'toChaKanXIangQing.do?ID='+ID //iframe的url
	}); 
}
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
                 <input id="name" placeholder="客户经理电话"/>  &nbsp;&nbsp;
			     <input id="order_number" placeholder="订单号"/>  &nbsp;&nbsp;
			     <!--<input id="product" placeholder="产品名"/>  &nbsp;&nbsp;-->
			     <input id="true_name" placeholder="客户名"/>  &nbsp;&nbsp;
			     <input id="idCardNumber" placeholder="客户身份证号"/>  &nbsp;&nbsp;
			      <input id="auditer_name" placeholder="操作者"/>  &nbsp;&nbsp;
			     <input id="date1" class="Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" placeholder="返佣时间" style="width:180px;"/>
				 &nbsp;&nbsp;&nbsp;&nbsp;至&nbsp;&nbsp;&nbsp;&nbsp;
				 <input id="date2" class="Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'}) "  placeholder="返佣时间" style="width:180px;"/>
			     <br/><br/>
			      &nbsp;&nbsp;
			            产品：<select id="product">
				         <option value="" selected="selected">所有</option>
					     <c:forEach items="${productions}" var="p">
					        <option value="${p.proName}">${p.proName}</option>
					     </c:forEach>
				       </select>
		        &nbsp;&nbsp;
				  客户身份：<select id="user_identity">
					        <option value="">所有</option>
					        <option value="工薪族客户">工薪族客户</option>
					        <option value="企业主客户">企业主客户</option>
					     </select>&nbsp;&nbsp;
			          省份：  <select id="province">
			                <option selected value="">全部</option>
			          		<c:forEach items="${province}" var="p">
						        <option value="${p.name}">${p.name}</option>
						    </c:forEach>   
			     	   </select>&nbsp;&nbsp;
			      
			           城市：<select id="city">
			                <option selected value="">全部</option>
			          </select>&nbsp;&nbsp;
				 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 <a href="javascript:void(0);" class="btn bg-warning" id="btn4">查询</a>
          </div>
        </div>
        <hr/>
        <div class="widget-table"  >
            <div class="widget-content" >
               <table border='1px' id="table1" class="table table-striped table-bordered">
				    <thead>
			           <tr>
				           <td style="width:80px;">客户经理电话</td><td style="width:150px;">订单号</td><td style="width:70px;">客户身份</td>
				           <td style="width:120px;">产品名</td><td style="width:100px;">客户名</td><td style="width:169px;">身份证号</td>
				           <td style="width:100px;">电话号</td><td style="width:70px;">省份</td><td style="width:60px;">城市</td>
				           <td style="width:115px;">返佣时间</td><td style="width:85px;">操作者</td><td  style="width:100px;">查看详情</td>
			           </tr>
		            </thead>
		           <tbody id="tbody1"></tbody>
      		   </table>
      	    </div>
      	 </div>	 
      		 <hr/>
      		  <div  style="text-align: center;"><br/>
      		  		<button id="first" class="btn btn-sm" >首页</button>&nbsp;
		    		<a id="btn1" href="javascript:void(0);" class="btn btn-sm" >上一页</a>&nbsp;
			        <span id="btn2">第1</span>/<span id="span">${totalCount}</span><span>页</span>
			        <a id="btn3" href="javascript:void(0);" class="btn btn-sm" >下一页</a>&nbsp;
			        <button id="last" class="btn btn-sm" >尾页</button>&nbsp;
			        <input  type="text" placeholder="页码" id="num" style="width:60px;height:25px;" onkeyup="value=value.replace(/[^\d]/g,'')"/>
			        <button id="go" class="btn btn-sm" >跳转</button>&nbsp;
		     </div>
    </div>
</body>
</html>