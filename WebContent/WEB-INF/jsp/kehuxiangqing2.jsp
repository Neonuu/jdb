<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>客户资料</title>
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
	    	$("#btn27").attr("class","btn btn-sm");
	    });
	</script>

  </head>
  
<body>
<form action="/xiugaikehuziliao2.do" onsubmit="return p_del()" method="post" enctype="multipart/form-data">
<table align="left" style="width:30%;" >
	<tr>
		<td align="center">
			客户姓名：
		</td>
		<td>
			<input type="text" name="customer_name" id="customer_name" value="${kehu.customer_name}">
		</td>
	</tr>
	
	<tr>
		<td align="center">
			身份证号：
		</td>
		<td>
			<input type="text" name="passport" id="passport" value="${kehu.passport}">
		</td>
	</tr>
	<tr>
		<td align="center">
			电话号：
		</td>
		<td>
			<input type="text" name="phone" id="phone" value="${kehu.phone}">
		</td>
	</tr>
	<tr>
		<td align="center">
			公司信息：
		</td>
		<td>
			<input type="text" name="company_info" id="company_info" value="${kehu.company_info}">
		</td>
	</tr>
	<!--  
	<tr>
		<td align="center">
			邮箱：
		</td>
		<td>
			<input type="text" name="email" id="email" value="${kehu.email}">
		</td>
	</tr>
	-->
	<tr>
		<td align="center">
			上次修改时间：
		</td>
		<td>
			<input type="text" value="${kehu.add_time }" readonly="readonly;">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="hidden" name="id" id="id" value="${kehu.id}">
			<input style="width:100px;height:25px;" class="btn bg-warning" type="submit">
			<a style="width:100px;height:25px;" class="btn bg-warning" href="javascript:history.back(-1);">返回</a>
		</td>
	</tr>
</table>
</form>
</body>
</html>
