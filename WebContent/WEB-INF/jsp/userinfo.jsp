<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>修改用户资料</title>
<link href="/jdb/css/style.css" type="text/css" rel="stylesheet">
<link href="/jdb/css/font.css" type="text/css" rel="stylesheet">
<link href="/jdb/css/grid.css" type="text/css" rel="stylesheet">
<script src="/jdb/js/jquery.min.js" type="text/javascript"></script>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	function p_del() { 
        var msg = "您真的确定要保存修改吗？\n\n请确认！"; 
        if (confirm(msg)==true){ 
            return true; 
        }else{ 
              return false; 
             } 
}
	 $(function(){
	    	$("#btn14").attr("class","btn btn-sm");
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
<table align="center" border="1" cellspacing="1" cellpadding="1">
	<tr>
		<td align="right"  style="width:45%;">
			用户ID：
		</td>
		<td>
			<input type="text" value="${user.user_id }" disabled="disabled">
			<input type="hidden" name="user_id" id="user_id" value="${user.user_id }">
		</td>
	</tr>
	<tr>
		<td align="right">
			电话号码：
		</td>
		<td>
			<input type="text" name="phoneNumber" id="phoneNumber" value="${user.phoneNumber }" disabled="disabled">
		</td>
	</tr>
	<tr>
		<td align="right">
			用户姓名：
		</td>
		<td>
			<input type="text" name="user_name" id="user_name" value="${user.user_name }" disabled="disabled">
		</td>
	</tr>
	<tr>
		<td align="right">
			邮箱：
		</td>
		<td>
			<input type="text" name="email" id="email" value="${user.email }" disabled="disabled">
		</td>
	</tr>
	<tr>
		<td align="right">
			省：
		</td>
		<td>
			<input type="text" name="province" id="province" value="${user.province }" disabled="disabled">
		</td>
	</tr>
	<tr>
		<td align="right">
			市：
		</td>
		<td>
			<input type="text" name="city" id="city" value="${user.city }" disabled="disabled">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<a class="btn btn-sm" href="javascript:history.back(-1);">返回</a>
		</td>
	</tr>
</table>
</body>
</html>
