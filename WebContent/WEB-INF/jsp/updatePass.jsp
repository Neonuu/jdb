<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    
<title>找回密码</title>
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
<link href="/jdb/css/style.css" rel="stylesheet" type="text/css"/>
<link href="/jdb/css/grid.css" rel="stylesheet" type="text/css"/>
<link href="/jdb/css/font.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="/jdb/js/jquery.min.js"></script>

<script type="text/javascript">
function vPass(){
	var loginPassNew = document.getElementById("loginPassNew").value;
	var t1 = document.getElementById("t1");
	if(loginPassNew == "" || loginPassNew.length == 0){
		t1.innerHTML = "<font color='red'>请输入密码</font>";
		return false;
	}else{
		t1.innerHTML = "";
		return true;
	}
}
//两次输入的密码必须一致
function vRepass(){
	var loginPassNew = document.getElementById("loginPassNew").value;
	var loginPass = document.getElementById("loginPass").value;
	var t2 = document.getElementById("t2");
	if(loginPassNew != loginPass){
		t2.innerHTML = "<font color='red'>两次输入的密码不一致</font>";
		return false;
	}else{
		t2.innerHTML = "";
		return true;
	}
}
function init(){
	vPass();
	vRepass();
}
function vForm(){
	if(!vPass()){
		return false;
	}
	if(!vRepass()){
		return false;
	}
	return true;
}
</script>
</head>
<body>
<form action="/updatePass.do" method="post" onsubmit="return vForm();">
	<table style="text-align: center; margin-top: 10%;">
		<tr>
			<td>
				填写新密码
			</td>
		</tr>
		<tr>
			<td>
				&nbsp;
				<input type="hidden" id="user_id" name="user_id" value="<%=session.getAttribute("detUser_id") %>">
			</td>
		</tr>
		<tr>
			<td>
				&nbsp;
			</td>
		</tr>
		<tr>
			<td>
				新密码：<input type="password" id="loginPassNew" name="loginPassNew" onblur="vPass();">
				<span id="t1"></span>
			</td>
		</tr>
		<tr>
			<td>
				&nbsp;
			</td>
		</tr>
		<tr>
			<td>
				重复密码：<input type="password" id="loginPass" name="loginPass" onblur="vRepass();">
				<span id="t2"></span>
			</td>
		</tr>
		<tr height="50px">
			<td><span id="sp1"></span></td>
		</tr>
		<tr>
			<td>
				<input style="height: 30px;width: 80px;" class="btn btn-sm" type="submit" value="确定">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
