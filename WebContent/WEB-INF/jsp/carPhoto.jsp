<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'showLogo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="/jdb/css/style.css" type="text/css" rel="stylesheet">
    <link href="/jdb/css/font.css" type="text/css" rel="stylesheet">
    <link href="/jdb/css/grid.css" type="text/css" rel="stylesheet">
    <script src="/jdb/js/jquery.min.js" type="text/javascript"></script>
    <script>
    
    
  function goBack(){
	  history.go(-1);
  }
  $(function(){
		$("#btn30").attr("class","btn btn-sm");
	});
    
    
    </script>

  </head>
  
  <body>
  <c:forEach items="${kzlist}" var="kz">
  <c:forEach items="${alloperate_id}" var="cz">
  <c:if test="${kz.operate_id == cz}">
  <input type="button" style="width:150px" value="${kz.operate_name}" id="btn${kz.operate_id}" name="btn${kz.operate_id}" onclick="window.location.href='${kz.operate_url}'" />
  &nbsp;&nbsp;
  </c:if>
  </c:forEach>
  </c:forEach>
  <br><br>
  <c:forEach items="${clist}" var="p">
    <img height=300 width=300 src="${p.img }">
   </c:forEach> 
    <br>
<input type="button" value="返回" onclick="goBack();"/>               
  </body>
</html>
