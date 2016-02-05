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
$(document).ready(function(e) {
$("#sb1").hide();
$("#loginName").blur(function(){
	var loginName = $("#loginName").val();
	var phoneNumber = $("#phoneNumber").val();
	$.ajax({
		url:"/detection.do",
		type:"POST",
		data:{"loginName":loginName,"phoneNumber":phoneNumber},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			alert(XMLHttpRequest.status);
			alert(XMLHttpRequest.readyState);
		},
		success: function(msg){
			if(msg == 1){
				$("#bcode").show();
				$("#sp1").html("");
			}else if(msg != 1){
				$("#sp1").html("用户名/手机号码不匹配！");
				$("#sp1").css("color","red");
				$("#bcode").hide();
			}
		},
		dataType:"text"
	});
});
$("#phoneNumber").blur(function(){
	var loginName = $("#loginName").val();
	var phoneNumber = $("#phoneNumber").val();
	$.ajax({
		url:"/detection.do",
		type:"POST",
		data:{"loginName":loginName,"phoneNumber":phoneNumber},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			alert(XMLHttpRequest.status);
			alert(XMLHttpRequest.readyState);
		},
		success: function(msg){
			if(msg == 1){
				$("#sb1").show();
				$("#sp1").html("");
			}else if(msg != 1){
				$("#sp1").html("用户名/手机号码不匹配！");
				$("#sp1").css("color","red");
				$("#sb1").hide();
			}
		},
		dataType:"text"
	});
});

$("#getcode").click(function(){
	var loginName = $("#loginName").val();
	var phoneNumber = $("#phoneNumber").val();
	$.ajax({
		url:"/getcode.do",
		type:"POST",
		data:{"phoneNumber":phoneNumber},
		error: function(XMLHttpRequest, textStatus, errorThrown){
			alert(XMLHttpRequest.status);
			alert(XMLHttpRequest.readyState);
		},
		dataType:"text"
	});
});
});
function vloginName(){
	var loginName = $("#loginName").val();
	if(loginName == "" || loginName.length == 0){
		$("#sp2").show();
		return false;
	}else{
		$("#sp2").hide();
		return true;
	}
}
function vphoneNumber(){
	var phoneNumber = $("#phoneNumber").val();
	if(phoneNumber == "" || phoneNumber.length == 0){
		$("#sp3").show();
		return false;
	}else{
		$("#sp3").hide();
		return true;
	}
}
function vcode(){
	var code = $("#code").val();
	if(code == "" || code.length == 0){
		$("#sp4").show();
		return false;
	}else{
		$("#sp4").hide();
		return true;
	}
}
function init(){
	vliginName();
	vphoneNumber();
	vcode();
}
function vForm(){
	if(!code()){
		return false;
	}
	if(!vphoneNumber()){
		return false;
	}
	if(!vliginName()){
		return false;
	}
	return true;
}

var countdown=60; 
function settime(val) { 
if (countdown == 0) { 
val.removeAttribute("disabled");    
val.value="免费获取验证码"; 
countdown = 60; 
} else { 
val.setAttribute("disabled", true); 
val.value="重新发送(" + countdown + ")"; 
countdown--; 
} 
setTimeout(function() { 
settime(val) 
},1000) 
} 

function denglu(){
	window.location.href="login.jsp";
}
</script>
</head>
  
<body>
<form action="/vcode.do" method="post" onsubmit="return vForm();">
	<table style="text-align: center; margin-top: 10%;width: 350px;" align="center">
		<tr>
			<td align="center">
				找回管理员密码
			</td>
		</tr>
		<tr>
			<td>
				&nbsp;
			</td>
		</tr>
		<tr>
			<td align="left">
				　　　用户名：　<input type="text" id="loginName" name="loginName" onblur="vloginName();" >
				<span id="sp2" style="color: red;">请输入用户名！</span>
			</td>
		</tr>
		<tr>
			<td>
				&nbsp;
			</td>
		</tr>
		<tr>
			<td align="left">
				　　　手机号码：<input pattern="^[1]\d{10}$" onkeyup="value=value.replace(/[^\d]/g,'')" type="text" id="phoneNumber" name="phoneNumber" onblur="vphoneNumber();" >
				<span id="sp3" style="color: red;">请输入手机号码！</span>
			</td>
		</tr>
		<tr>
			<td>
				&nbsp;
			</td>
		</tr>
		<tr>
			<td align="left">
				　　　验证码：　<input onkeyup="value=value.replace(/[^\d]/g,'')" type="text" id="code" name="code" onblur="vcode();" >
				<span id="sp4" style="color: red;">请输入验证码！</span>
				<br>
				　　　　　　　　<input type="button" value="获取验证码" id="getcode" name="getcode" onclick="settime(this)" >
				
			</td>
		</tr>
		<tr height="50px">
			<td><span id="sp1"></span></td>
		</tr>
		<tr>
			<td>
				<input id="sb1" style="height: 30px;width: 80px; margin-top: 10px;" class="btn btn-sm" type="submit" value="确定">
				<input id="sb2" style="height: 30px;width: 80px; margin-top: 10px;" class="btn btn-sm" type="button" value="取消" onclick="denglu();">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
