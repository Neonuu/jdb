<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>修改用户</title>

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
	<form action="<c:url value='/user/updataUser.do'/>" method="post">
		<input type="hidden" name="phoneNumber" value="${user.phoneNumber}" />

		<table border="0" align="center" width="40%"
			style="margin-left: 100px;">
			<tr>
				<td width="100px">用户姓名</td>
				<td width="40%"><input type="text" name="user_name"
					value="${user.user_name }" />
				</td>
			</tr>
			<tr>
				<td width="100px">密码</td>
				<td width="40%"><input type="text" name="password"
					value="${user.password }" />
				</td>
			</tr>
			<tr>
				<td width="100px">手机号</td>
				<td width="40%">${user.phoneNumber}</td>
			</tr>
			<tr>
				<td width="100px">邮箱</td>
				<td width="40%"><input type="text" name="email"
					value="${user.email}" />
				</td>
			</tr>
			<tr>
				<td width="100px">省份</td>
				<td width="40%"><input type="text" name="province"
					value="${user.province}" />
				</td>
			</tr>
			<tr>
				<td width="100px">城市</td>
				<td width="40%"><input type="text" name="city"
					value="${user.city}" />
				</td>
			</tr>
			<tr>
				<td>冻结用户</td>
				<td><input type="radio" name="user_status" value=0 id="normal"
					<c:if test="${user.user_status eq 0 }">checked='checked'</c:if> />
					<label for="normal"> 正常 </label> <input type="radio"
					name="user_status" value=1 id="unnormal"
					<c:if test="${user.user_status eq 1 }">checked='checked'</c:if> />
					<label for="unnormal"> 冻结 </label>
				</td>
			</tr>

			<tr>
				<td>是否注销此用户</td>
				<td><input type="radio" name="isdel" value=0 id="undelete"
					<c:if test="${user.isdel eq 0 }">checked='checked'</c:if> /> <label
					for="undelete"> 恢复此用户 </label> <input type="radio" name="isdel"
					value=1 id="delete"
					<c:if test="${user.isdel eq 1 }">checked='checked'</c:if> /> <label
					for="delete"> 注销此用户 </label>
				</td>
			</tr>

			<tr>
				<td>修改此用户权限</td>
				<td><input type="radio" name="limit" value=0 id="limita"
					<c:if test="${user.isdel eq 0 }">checked='checked'</c:if> /> <label
					for="limita"> 权限0（默认） </label> <input type="radio" name="limit"
					value=1 id="limitb"
					<c:if test="${user.isdel eq 1 }">checked='checked'</c:if> /> <label
					for="limitb"> 权限1 </label> <input type="radio" name="limit" value=2
					id="limitc"
					<c:if test="${user.isdel eq 2 }">checked='checked'</c:if> /> <label
					for="limitc"> 权限2 </label> <input type="radio" name="limit" value=3
					id="limitd"
					<c:if test="${user.isdel eq 3 }">checked='checked'</c:if> /> <label
					for="limitd"> 权限3 </label>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="修改客户" /> <input type="reset"
					value="重置" />
				</td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</form>
</body>
</html>
