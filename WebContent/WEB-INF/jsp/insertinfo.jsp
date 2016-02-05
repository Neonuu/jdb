<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>添加用户</title>
    
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
<script type="text/javascript">
$(document).ready(function(e) {
	$("#sbm1").hide();
	$("#span1").hide();
	$("#span2").hide();
	$("#loginName").blur(function(){
		var loginName = $("#loginName").val();
		$.ajax({
			url:"/loginName.do",
			type:"POST",
			data:{"loginName":loginName},
			error: function(XMLHttpRequest, textStatus, errorThrown){
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
			},
			success: function(msg){
				if(msg == 0){
					$("#sbm1").show();
					$("#span1").hide();
				}else if(msg > 0){
					alert("该用户名已被使用")
					$("#sbm1").hide();
					$("#span1").show();
				}
			},
			dataType:"text"
		});
	});		
});
$(function(){
	$("#btn2").attr("class","btn btn-sm");
});
function vloginName(){
	var loginName = $("#loginName").val();
	if(loginName == "" || loginName.length == 0){
		$("#sp1").show();
		return false;
	}else{
		$("#sp1").hide();
		return true;
	}
}
function vloginPass(){
	var loginPass = $("#loginPass").val();
	if(loginPass == "" || loginPass.length == 0){
		$("#sp2").show();
		return false;
	}else{
		$("#sp2").hide();
		return true;
	}
}
function vuser_name(){
	var user_name = $("#user_name").val();
	if(user_name == "" || user_name.length == 0){
		$("#sp3").show();
		return false;
	}else{
		$("#sp3").hide();
		return true;
	}
}
function vemail(){
	var email = $("#email").val();
	if(email == "" || email.length == 0){
		$("#sp4").show();
		return false;
	}else{
		$("#sp4").hide();
		var s = $("#email").val();
		var regu = "^(([0-9a-zA-Z]+)|([0-9a-zA-Z]+[_.0-9a-zA-Z-]*[0-9a-zA-Z]+))@([a-zA-Z0-9-]+[.])+([a-zA-Z]{2}|net|NET|com|COM|gov|GOV|mil|MIL|org|ORG|edu|EDU|int|INT)$"
		var re = new RegExp(regu);
		if (s.search(re) != -1) {
			$("#span2").hide();
			return true;
		} else {
			window.alert ("请输入有效合法的E-mail地址 ！")
			$("#span2").show();
			return false;
		}
	}
}
function vphoneNumber(){
	var phoneNumber = $("#phoneNumber").val();
	if(phoneNumber == "" || phoneNumber.length == 0){
		$("#sp5").show();
		return false;
	}else{
		$("#sp5").hide();
		return true;
	}
}
function init(){
	vloginName();
	vloginPass();
	vuser_name();
	vemail();
	vphoneNumber();
}
function vForm(){
	if(!vloginName()){
		return false;
	}
	if(!vloginPass()){
		return false;
	}
	if(!vuser_name()){
		return false;
	}
	if(!vemail()){
		return false;
	}
	if(!vphoneNumber()){
		return false;
	}
	return true;
}
function goback(){
	history.go(-1);
}
function p_del() { 
    var msg = "您确定提交？\n\n请确认！"; 
    if (confirm(msg)==true){ 
        return true; 
    }else{ 
          return false; 
         } 
}
</script>
  </head>
  <body onload="init();" >
  <c:forEach items="${kzlist}" var="kz">
  <c:forEach items="${alloperate_id}" var="cz">
  <c:if test="${kz.operate_id == cz}">
  <input type="button" style="width:150px" value="${kz.operate_name}" id="btn${kz.operate_id}" name="btn${kz.operate_id}" onclick="window.location.href='${kz.operate_url}'" />
  </c:if>
  </c:forEach>
  </c:forEach>
<hr/>
<form action="/zhuceguanli.do" method="post" onsubmit="return vForm();" >
<div class="widget-content">
<table style="margin-top: 5%; text-align: center; width: 40%;" align="left">
	<tr>
		<td width="20%">
			交单宝后台管理账号添加
		</td>
		<td width="20%"></td>
	</tr>
	<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
	<tr>
		<td>
			用户名：<input id="loginName" name="loginName" type="text" onblur="vloginName();"/>
		</td>
		<td>
			<span id="sp1" style="color: red;">请输入用户名！</span>
			<span id="span1" style="color: red;">用户名已存在！</span>
		</td>
	</tr>
	<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
	<tr>
		<td>
			密码：<input id="loginPass" name="loginPass" type="password" onblur="vloginPass();"/>
		</td>
		<td>
			<span id="sp2" style="color: red;">请输入密码！</span>
		</td>
	</tr>
	<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
	<tr>
		<td>
			姓名：<input id="user_name" name="user_name" type="text" onblur="vuser_name();"/>
		</td>
		<td>
			<span id="sp3" style="color: red;">请输入您的姓名！</span>
		</td>
	</tr>
	<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
	<tr>
		<td>
			邮箱：<input id="email" name="email" type="text" onblur="vemail();"/>
		</td>
		<td>
			<span id="sp4" style="color: red;">请输入邮箱！</span>
			<span id="span2" style="color: red;">邮箱格式不正确！</span>
		</td>
	</tr>
	<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
	<tr>
		<td>
			手机号码：
			<input pattern="^[1]\d{10}$" onkeyup="value=value.replace(/[^\d]/g,'')" id="phoneNumber" name="phoneNumber" type="text" onblur="vphoneNumber();"/>
		</td>
		<td>
			<span id="sp5" style="color: red;">请输入您的手机号！</span>
		</td>
	</tr>
	<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
	<tr>
		<td>
			<input id="sbm1" type="submit" value="提交"  class="btn bg-warning" style="width:80px;" onclick="javascript:return p_del()"/>
			<input type="reset" value="重置"  class="btn bg-warning" style="width:80px;"/>
			<input type=button value="返回" onclick="goback();" class="btn bg-warning" style="width:80px;"/> 
		</td>
		<td></td>
	</tr>
</table>
</div>
</form>
</body>
</html>