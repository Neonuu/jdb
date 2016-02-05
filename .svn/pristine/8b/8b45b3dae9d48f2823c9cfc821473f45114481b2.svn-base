<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>My JSP 's.jsp' starting page</title>


</head>

<body>
<body>
	<table border="1" cellspacing="0" width="100%" align="center">
		<caption>用户信息</caption>
		<tr>
			<th>id</th>
			<th>手机号</th>
			<th>姓名</th>
			<th>密码</th>
			<th>邮箱</th>
			<th>省份</th>
			<th>城市</th>
			<th>等级</th>
			<th>状态</th>
		</tr>
		<tr>
			<td align="center">${user.user_id}</td>
			<td align="center">${user.phoneNumber}</td>
			<td align="center">${user.user_name}</td>
			<td align="center">${user.password}</td>
			<td align="center">${user.email}</td>
			<td align="center">${user.province}</td>
			<td align="center">${user.city}</td>
			<td align="center">${user.limit}</td>
			<td align="center"><c:if test="${user.user_status==1}">
					<font color="red">冻结</font>
				</c:if> <c:if test="${user.isdel==1}">
					<font color="red">注销</font>
				</c:if>
			</td>
			<td style="border-style:none" ><a
				href="<c:url value='/user/updata.do?user_id=${user.user_id}'/>">修改</a>
			</td>
		</tr>
	</table>
	<br />
	<br />

	<c:if test="${empty orderList}">
		<h3>用户没有订单</h3>
	</c:if>
	<c:if test="${!empty orderList}">
		<table border="1" cellspacing="0" width="70%" align="left">
			<caption>用户订单</caption>
			<tr>
				<th>id</th>
				<th>订单号</th>
				<th>金额</th>
				<th>订单提交时间</th>
				<th>订单成交时间</th>
				<th>订单的客户</th>
				<th>订单状态</th>
				<th>状态</th>
			</tr>
			<c:forEach items="${orderList}" var="order" varStatus="od">
				<tr>
					<td align="center">${order.order_id}</td>
					<td align="center">${order.number}</td>
					<td align="center">${order.money}</td>
					<td align="center">${order.order_p}</td>
					<td align="center">${order.order_s}</td>
					<td align="center">${order.customer_id}</td>
					<td align="center"><c:if test="${order.order_status==1}">
							<font color="green">成交</font>
						</c:if>
					</td>
					<td align="center"><c:if test="${order.isdel==1}">
							<font color="red">取消</font>
						</c:if></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />

	<c:if test="${empty customerList}">
		<h3>用户没有客户</h3>
	</c:if>
	<c:if test="${!empty customerList}">
		<table border="1" cellspacing="0" align="left">
			<caption>用户客户</caption>
			<tr>
				<th>id</th>
				<th>姓名</th>
				<th>身份证号</th>
				<th>状态</th>
			</tr>
			<tr>
				<c:forEach items="${customerList}" var="customer" varStatus="cs">
					<td align="center">${customer.customer_id}</td>
					<td align="center">${customer.customer_name}</td>
					<td align="center">${customer.customer_cid}</td>
					<td align="center"><c:if test="${customer.isdel==1}">
							<font color="red">注销</font>
						</c:if></td>
				</c:forEach>
			</tr>
		</table>
	</c:if>
</body>
</html>
