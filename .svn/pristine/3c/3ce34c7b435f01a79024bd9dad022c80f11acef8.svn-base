<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>订单管理</title>
	<link href="/jdb/css/style.css" type="text/css" rel="stylesheet">
	<link href="/jdb/css/font.css" type="text/css" rel="stylesheet">
	<link href="/jdb/css/grid.css" type="text/css" rel="stylesheet">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="/jdb/js/jquery.min.js"></script>
     <script type="text/javascript">
	   function myfun(){
             $("div input:first").click();
		         return;
	      }
	    window.onload=myfun;
	</script> 
  </head>
  
  <body>
	  <div style="text-align: left;"  class="templatemo-content-wrapper">
		  <c:forEach items="${kzlist}" var="kz">
		  <c:forEach items="${alloperate_id}" var="cz">
		  <c:if test="${kz.operate_id == cz}">
		  <input  style="width:150px" type="button" value="${kz.operate_name}" id="btn${kz.operate_id}" name="btn${kz.operate_id}" onclick="window.location.href='${kz.operate_url}'" />
		  </c:if>
		  </c:forEach>
		  </c:forEach>
	  </div>
  </body>
</html>
