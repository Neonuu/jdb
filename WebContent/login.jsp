<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>登陆页</title>
<link rel="stylesheet" href="assets/css/reset.css">
<link rel="stylesheet" href="assets/css/supersized.css">
<link rel="stylesheet" href="assets/css/style.css">
<script src="assets/js/jquery-1.8.2.min.js"></script>
<script src="assets/js/supersized.3.2.7.min.js"></script>
<script src="assets/js/supersized-init.js"></script>
<script src="assets/js/scripts.js"></script>
<script type="text/javascript">
$(document).ready(function(e) {
	$(document).keydown(function(event){
		if(event.keyCode==13){ 
			$("#login").click(); 
		} 
	}); 
	$("#lname").focus(function(){
		$("#show").html("");
	})
	$("#lpass").focus(function(){
		$("#show").html("");
	})
	$("#login").click(function (){
		var lname = $("#lname").val();
		var lpass = $("#lpass").val();
		if( lname == "" || lpass == ""){
			$("#show").html("帐号/密码不能为空");
			$("#show").css("color","red");
			return;
		}
	$.ajax({
		url:"/login.do",
		type:"POST",
		data:{"loginName":lname,"loginPass":lpass},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			alert(XMLHttpRequest.status);
			alert(XMLHttpRequest.readyState);
		},
		success: function(count){
			if(count == 1){
				$("#show").html("提示：登录中,请稍候......");
				$("#show").css("color","red");
				window.location.href="/zhuye.do";
			}else if(count == 0){
				$("#show").html("用户名/密码错误");
				$("#show").css("color","red");
				return;
			}
		},
		dataType:"json"
	});
});		
});
</script>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->
<style type="text/css">
body,a,input,span{font: 12px/1.5 Microsoft YaHei,arial,tahoma,sans-serif;}
</style>
</head>
<body>
<div class="page-container" style="margin-top: 15%">
	<div><img alt="" src="img/login_logo.png"></div>
	<input type="text" name="lname" id="lname" style="width:210px;height:40px;" placeholder="用户名"/><br>
	<input type="password" name="lpass" id="lpass" style="width:210px;height:40px;" placeholder="密码"/><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
	<span id="show"></span><br>
	<input id="login" style="width:100px;height:30px;background-color: #F00;" value="登录" type="button" />
	<a style="height: 30px;width:95px;padding-left:10px;" class="btn btn-sm" href="/zhaohui.do" >找回密码</a>
</div>
</body>
</html>