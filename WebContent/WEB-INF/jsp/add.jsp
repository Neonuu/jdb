<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>添加模板</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="/jdb/css/style.css" type="text/css" rel="stylesheet">
        <link href="/jdb/css/font.css" type="text/css" rel="stylesheet">
        <link href="/jdb/css/grid.css" type="text/css" rel="stylesheet">
        <script src="/jdb/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
	 $(function(){
	    	$("#btn18").attr("class","btn btn-sm");
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
		<div id="div1">
					<h1>
						添加模板:
					</h1>
					<form action="insertMsg.do" method="post">
						<table cellpadding="10" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									短信内容:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="sms_msg" style="width:400px;height:70px;"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									类型:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="sms_type" />
								</td>
							</tr>
						</table>
						
						<p>
						&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
						&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
						&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
						&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
						&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
						<input type="submit" class="button" 
						value="提交" style="width:80px;height:35px;"/>
						<input type="button"  style="width:80px;height:35px;"value="返回"
							 onclick="location='javascript:history.back(-1);'" />
						</p>
					</form>
				</div>
	</body>
</html>
