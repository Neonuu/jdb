<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>交单量排行</title>
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
	$("#btn17").attr("class","btn btn-sm");
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
		height:350px;
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
<form name="searchForm" method="post" action="/jiaodanph.do">
<input type="hidden" name="pagenum" id="pagenum"/>
</form>
  <div align="center">
<a href="/jiaodanph.do" class="btn bg-warning">交单量排行</a>
<a href="/chengjiaoph.do" class="btn bg-warning">成交量排行</a>
<a href="/moneyph.do" class="btn bg-warning">成交额排行</a>
</div>
<hr/>
<h1 style="text-align: center;">交单量排行</h1>
<div id="div1">
<table class="table table-striped table-bordered">
	<tr>
	<td>排名</td><td>姓名</td><td>手机号</td><td>交单笔数</td>
	</tr>
	<c:forEach items="${jdph}" var="jd">
	<tr>
		<td>${jd.pm}</td>
		<td>${jd.user_name}</td>
		<td>${jd.phoneNumber}</td>
		<td>${jd.zong }</td>
	</tr>
	</c:forEach>
</table>
</div>
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
	<input type="text" onkeyup="value=value.replace(/[^\d]/g,'')" placeholder="页码" style="width:60px;height:25px;" id="page"/>
	<a class="btn btn-sm"  id="jump">跳转</a>
	<input type="hidden" value="${svo.maxpage}" id="maxpage">
</div>	
  </body>
</html>
