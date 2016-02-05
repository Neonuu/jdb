<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>My JSP 's.jsp' starting page</title>
<style type="text/css">
#input {
	line-height: 150%;
}

#fy { /* 字体间距*/
	word-spacing: 5px;
	/* 字体行间距*/
	line-height: 300%;
}

a.gjss {
	font-size: 80%
}

input.input {
	height: 30px;
}
</style>

</head>

<body>
<body>

	<form>
		<div id="input" align="center">
			输入手机号查询 <input class="input" type="text" size="80" /> &nbsp; &nbsp;<a
				class="gjss" href="<c:url value='query.do'/>">高级搜索</a>&nbsp; &nbsp;<a
				class="gjss" href="<c:url value='add.do'/>">添加用户</a>
		</div>

	</form>


	<div id="table">
		<table border="1" cellspacing="0" width="100%" align="center">
			<tr>
				<th></th>
				<th>手机号</th>
				<th>姓名(点击查看详情)</th>
				<th>密码</th>
				<th>邮箱</th>
				<th>省份</th>
				<th>城市</th>
				<th>等级</th>
				<th>状态</th>
			</tr>
			<c:forEach items="${fyPb_User.pagedatas}" var="user" varStatus="vs">
				<tr>
					<td align="center">${user.user_id}</td>
					<td align="center">${user.phoneNumber}</td>
					<td align="center"><a
						href="<c:url value='/user/showDetail.do?user_id=${user.user_id}'/>">${user.user_name}</a>
					</td>
					<td align="center">${user.password}</td>
					<td align="center">${user.email}</td>
					<td align="center">${user.province}</td>
					<td align="center">${user.city}</td>
					<td align="center">${user.limit}</td>
					<td align="center"><c:if test="${user.user_status==1}">
							<font color="red">冻结</font>
						</c:if> <c:if test="${user.isdel==1}">
							<font color="red">注销</font>
						</c:if></td>
					<td style="border-style:none"><a
						href="<c:url value='/user/updata.do?user_id=${user.user_id}'/>">修改</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div id="fy" align="center">
		<c:choose>
			<c:when test="${fyPb_User.tp<10 }">
				<!-- 当总页数<10 -->
				<c:set var="begin" value="1" />
				<c:set var="end" value="${fyPb_User.tp }" />
			</c:when>

			<c:otherwise>
				<!-- 其他，总页数>10 -->
				<c:set var="begin" value="${fyPb_User.pc-5 }" />
				<c:set var="end" value="${fyPb_User.pc+4 }" />
				<!-- 头溢出 -->
				<c:if test="${begin<1 }">
					<c:set var="begin" value="1" />
					<c:set var="end" value="10" />
				</c:if>
				<!-- 尾溢出 -->
				<c:if test="${end>fyPb_User.tp	}">
					<c:set var="end" value="${fyPb_User.tp }" />
					<c:set var="begin" value="${fyPb_User.tp-9}" />
				</c:if>
			</c:otherwise>
		</c:choose>

		<!-- 给出分页相应的链接 -->
		<a
			href="<c:url value='/user/showListFy.do?pc=1&ps=${fyPb_User.ps }'/>">首页</a>
		<!-- 如果当前页是首页，不显示上一页 -->
		<c:if test="${pb.pc>1 }">
			<a
				href="<c:url value='/user/showListFy.do?pc=${fyPb_User.pc-1 }&ps=${fyPb_User.ps }'/>">上一页</a>
		</c:if>

		<!-- 计算完了，显示12345678910 -->
		<c:forEach var="i" begin="${begin}" end="${end }">
			<c:choose>
				<c:when test="${i eq fyPb_User.pc }">[${i }]
				</c:when>
				<c:otherwise>
					<a href="<c:url value='/user/showListFy.do?pc=${i }&ps=${fyPb_User.ps }'/>">[${i }]</a>
				</c:otherwise>
			</c:choose>

		</c:forEach>

		<!-- 如果当前页是尾页，不显示下一页 -->
		<c:if test="${fyPb_User.pc<fyPb_User.tp }">
			<a href="<c:url value='/user/showListFy.do?pc=${fyPb_User.pc+1 }&ps=${fyPb_User.ps }'/>">下一页</a>
		</c:if>
		<a href="<c:url value='/user/showListFy.do?pc=${fyPb_User.tp }&ps=${fyPb_User.ps }'/>">尾页</a>
		第${fyPb_User.pc }页/共${fyPb_User.tp
		}页&nbsp;&nbsp;&nbsp;&nbsp;共${fyPb_User.tr}条记录数
	</div>



</body>



</html>
