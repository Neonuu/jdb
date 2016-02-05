<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>搜索用户</title>
</head>



<body>
	<form action="<c:url value='/user/queryUser.do'/>" method="post">
		<table border="0" width="40%">
			<tr>
				<td width="100px">用户姓名</td>
				<td width="40%"><input type="text" name="user_name">
				</td>
			</tr>
			<tr>
				<td width="100px">密码</td>
				<td width="40%"><input type="text" name="password">
				</td>
			</tr>
			<tr>
				<td width="100px">手机号</td>
				<td width="40%"><input type="text" name="phoneNumber">
				</td>
			</tr>
			<tr>
				<td width="100px">邮箱</td>
				<td width="40%"><input type="text" name="email">
				</td>
			</tr>
			<tr>
				<td width="100px">省份</td>
				<td width="40%"><input type="text" name="province">
				</td>
			</tr>
			<tr>
				<td width="100px">城市</td>
				<td width="40%"><input type="text" name="city">
				</td>
			</tr>
			<tr>
				<td>用户状态</td>
				<td><input type="radio" name="user_status" value=10 id="normal" />
					<label for="normal"> 正常 </label> <input type="radio"
					name="user_status" value=11 id="unnormal" /> <label for="unnormal">
						被冻结 </label>
				</td>
			</tr>

			<tr>
				<td>用户是否被注销</td>
				<td><input type="radio" name="isdel" value=10 id="undelete" />
					<label for="undelete"> 正常 </label> <input type="radio" name="isdel"
					value=11 id="delete" /> <label for="delete"> 被注销 </label>
				</td>
			</tr>

			<tr>
				<td>用户权限</td>
				<td><input type="radio" name="limit" value=10 id="limita" /> <label
					for="limita"> 权限0（默认） </label> <input type="radio" name="limit"
					value=11 id="limitb" /> <label for="limitb"> 权限1 </label> <input
					type="radio" name="limit" value=12 id="limitc" /> <label
					for="limitc"> 权限2 </label> <input type="radio" name="limit" value=13
					id="limitd" /> <label for="limitd"> 权限3 </label>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="搜索" /> <input type="reset"
					value="重置" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
