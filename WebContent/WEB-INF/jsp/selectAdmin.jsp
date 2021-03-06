<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
<title>查看管理员信息</title>
<link href="/jdb/css/style.css" type="text/css" rel="stylesheet">
<link href="/jdb/css/font.css" type="text/css" rel="stylesheet">
<link href="/jdb/css/grid.css" type="text/css" rel="stylesheet">
<script src="/jdb/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
	function changePage(pagenum){
		document.getElementById("pagenum").value = pagenum;
		document.searchForm.submit();
	}
	 $(function(){
	    	$("#btn1").attr("class","btn btn-sm");
	    	$("#jump").click(function (){
	    		var a = document.getElementById("page").value;
	    		var b = document.getElementById("maxpage").value;
	    		if(Number(a) > Number(b)){
	    			a = b;
	    		}
    			document.getElementById("pagenum").value = a;
    			document.searchForm.submit();
	    	});
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
<div style="text-align:left;"  class="templatemo-content-wrapper">
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
<form name="searchForm" method="post" action="/selectAdmin.do">
<input type="hidden" name="pagenum" id="pagenum"/>
<table>
<tr>
<td>
<input type="text" onkeyup="value=value.replace(/[^\d]/g,'')" name="user_id" id="user_id" placeholder="用户ID" value="${svo.user_id}" />
<input type="text" name="user_name" id="user_name" placeholder="用户姓名" value="${svo.user_name}" />
<input  type="submit" value="查询" style="width:68px;" class="btn bg-warning"/>
</td>
</tr>
</table>
</form>
<hr>
<div id="div1" class="templatemo-content-wrapper">
<table class="table table-striped table-bordered" >
	<tr>
    	<td>用户ID</td>
        <td>用户姓名</td>
        <td>电话号码</td>
        <td>邮箱</td>
        <td>等级</td>
    </tr>
    <c:forEach items="${alist}" var="a">
    	<tr>
	    	<td>${a.user_id }</td>
	        <td>${a.user_name }</td>
	        <td>${a.phoneNumber }</td>
	        <td>${a.email }</td>
	        <td>
	        <c:choose>
	        <c:when test="${a.admin == 1}">
	        	系统管理员
	        </c:when>
	        <c:when test="${a.admin == 2}">
	        	管理员
	        </c:when>
	        <c:when test="${a.admin == 3}">
	        	机构管理员
	        </c:when>
	        </c:choose>
	        </td>
	    </tr>
    </c:forEach>
</table>
</div>
<hr/>
<div id="divye" class="templatemo-content-wrapper" >
	<a class="btn btn-sm" href="javascript:changePage(1)" >首页</a>
	<c:choose>
   	<c:when test="${svo.pagenum == 1}">
   	上一页
   	</c:when>  
   	<c:otherwise>
   	<a class="btn btn-sm" href="javascript:changePage(${svo.pagenum - 1})">上一页</a>
   	</c:otherwise>  
	</c:choose>  
	第${svo.pagenum}/${svo.maxpage}页
	<c:choose>
   	<c:when test="${svo.pagenum == svo.maxpage}">
   	下一页
   	</c:when>  
   	<c:otherwise>
   	<a class="btn btn-sm" href="javascript:changePage(${svo.pagenum + 1})">下一页</a>
   	</c:otherwise>  
	</c:choose>  
	<a class="btn btn-sm" href="javascript:changePage(${svo.maxpage})">尾页</a>
	<input type="text" onkeyup="value=value.replace(/[^\d]/g,'')" pattern="^\d$" placeholder="页码" style="width:60px;height:25px;" id="page"/>
	<a class="btn btn-sm"  id="jump">跳转</a>
	<input type="hidden" value="${svo.maxpage}" id="maxpage">
	&nbsp;
	<a class="btn btn-sm" href="javascript:history.back(-1);">返回</a>
</div>	
</body>
</html>
