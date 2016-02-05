<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>提现</title>
<link href="/jdb/css/style.css" type="text/css" rel="stylesheet">
<link href="/jdb/css/font.css" type="text/css" rel="stylesheet">
<link href="/jdb/css/grid.css" type="text/css" rel="stylesheet">
<script src="/jdb/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="/jdb/js/styleLayer/layer/layer.js"></script>
<script type="text/javascript" src="/jdb/js/styleLayer/layer/extend/layer.ext.js"></script>
<script type="text/javascript">
	function changePage(pagenum){
		document.getElementById("page").value = pagenum;
		document.searchForm.submit();
	}
	 $(function(){
	    	$("#jump").click(function (){
	    		var a = document.getElementById("page2").value;
	    		var b = document.getElementById("maxpage").value;
	    		if(Number(a) > Number(b)){
	    			a = b;
	    		}
	    		if(Number(a) < 1){
	    			a = 1;
	    		}
    			document.getElementById("page").value = a;
    			document.searchForm.submit();
	    	});
	    });
	 
	 function closeTixian(id,user_id){	 
			layer.prompt({
			    title: '请输入关闭提现的原因：',
			    formType:2 //prompt风格，支持0-2
				}, function(remarks){
					$.ajax({
				 		 url:"/closeTixian.do",
				 		 data:{"id":id,"user_id":user_id,"remarks":remarks},
				 		 type:"post",
				 		 dataType:"json",
				 		 success:function(data){
				 			 if(data.err){
				 				layer.msg(data.err);
				 			 }else{
				 				layer.msg("提交成功");
				 				setTimeout(function(){
				 					window.location.href="tixian.do"; 
				 				},1000);	
				 			 }
				 		 }
				 	 });

				});	 
		}
	 
		$().ready(function(){
			//获得选中项的部门ID
			var mark2 = $("#mark2").val();
			//让下拉列表选中
			$("#mark").val(mark2);
		});
</script>
<style type="text/css">
	#div1{
		width:100%;
		height:400px;
	}
	#divye{
		height:20px;
		text-align:center;
	}
</style>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
<body>
<input type="hidden" id="mark2" value="${svo.mark}"/>
<form name="searchForm" method="post" action="tixian.do">
<input type="hidden" name="page" id="page"/>
 
    	<input type="text" name="user_name" id="user_name" placeholder="用户名" value="${svo.user_name }">
    	
        状态：<select name="mark" id="mark">
		     <option value="">所有</option>
		        <option value="0">等待提现</option>
		        <option value="1">提现成功</option>
		        <option value="2">提现失败</option>		     
		</select>
     
    	<input type="submit" value="查询" class="btn bg-warning " style="width:68px;"/>
 
</form>
<hr>
<div id="div1" class="templatemo-content-wrapper">
<table class="table table-striped table-bordered" >
	<tr>
    	<td>用户ID</td>
    	<td>用户名</td>
    	<td>电话号码</td>
        <td>提现金额</td>
        <td>提现后余额</td>
        <td>银行卡号</td>
        <td>申请提现时间</td>
        <td>状态</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${alist}" var="a">
    	<tr>
	    	<td>${a.user_id }</td>
            <td>${a.user_name }</td>
            <td>${a.phone }</td>
	        <td>${a.change_amount }</td>
	        <td>${a.balance }</td>
	        <td>${a.bank_number }</td>
	        <td><fmt:formatDate value="${a.add_time }" type="date" pattern="yyyy-MM-dd HH:mm"/></td>
	        <c:choose>
	          <c:when test="${a.mark == 0}">
	          <td>等待提现</td>
	          </c:when>
	          <c:when test="${a.mark == 1}">
	          <td>提现成功</td>
	          </c:when>
	          <c:when test="${a.mark == 2}">
	          <td>提现失败</td>
	          </c:when>
	        </c:choose>
	        <td><c:choose>
	          <c:when test="${a.mark == 0}">
	        <a href="updateTixianMark.do?id=${a.id}&mark=1&user_id=${a.user_id}" class="btn btn-sm">提现成功</a>
	        <a href="javascript:closeTixian(${a.id},${a.user_id})" class="btn btn-sm">关闭</a>
	        </c:when>
	        <c:when test="${a.mark == 1}">
	                       已成功提现
	        </c:when>
	        <c:when test="${a.mark == 2}">
	                       失败原因：${a.reason}
	        </c:when>
	        </c:choose>
			</td>
	    </tr>
    </c:forEach>
</table>
</div>
<hr/>
<div id="divye">
	<a class="btn btn-sm" href="javascript:changePage(1)">首页</a>
	<c:choose>
   	<c:when test="${svo.page == 1}">
   	上一页
   	</c:when>  
   	<c:otherwise>
   	<a class="btn btn-sm" href="javascript:changePage(${svo.page - 1})">上一页</a>
   	</c:otherwise>  
	</c:choose>  
	第${svo.page}/${svo.maxpage}页
	<c:choose>
   	<c:when test="${svo.page == svo.maxpage}">
   	下一页
   	</c:when>  
   	<c:otherwise>
   	<a class="btn btn-sm" href="javascript:changePage(${svo.page + 1})">下一页</a>
   	</c:otherwise>  
	</c:choose>  
	<a class="btn btn-sm" href="javascript:changePage(${svo.maxpage})">尾页</a>
	<input type="text" onkeyup="value=value.replace(/[^\d]/g,'')" placeholder="页码" style="width:60px;height:25px;" id="page2"/>
	<a class="btn btn-sm"  id="jump">跳转</a>
	<input type="hidden" value="${svo.maxpage}" id="maxpage">
	&nbsp;
	<a class="btn btn-sm" href="javascript:history.back(-1);">返回</a>
</div>	
</body>
</html>
