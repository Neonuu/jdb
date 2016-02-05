<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>车辆信息</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="/jdb/css/style.css" type="text/css" rel="stylesheet">
        <link href="/jdb/css/font.css" type="text/css" rel="stylesheet">
        <link href="/jdb/css/grid.css" type="text/css" rel="stylesheet">
        <link href="/jdb/css/SeleCar.css" type="text/css" rel="stylesheet">
        <script src="/jdb/js/jquery.min.js" type="text/javascript"></script> 
        <script type="text/javascript">
        	function newxilie(){
        		var id = $("#carbrand").val();
        		$("#BID").val(id);
        	}
        </script>
</head>
<body>
	<form action="/addname.do" method="post">
	添加品牌：<br>&nbsp;<br><input type="text" id="BName" name="BName" ><br>&nbsp;<br><input style="width: 100px; height: 25px;" type="submit" value="添加该品牌">
	<br>&nbsp;<br><br>&nbsp;<br>
	</form>
	
	
	添加车系：<br>&nbsp;<br><select style="margin-top: 10px;" class="noempty" id="carbrand" name="carbrand">
		<option value="-1">请选择车辆品牌</option>
		<c:forEach items="${brand}" var="t">
		<option value="${t.id}">${t.bName}</option>
		</c:forEach>
	</select><br>&nbsp;<br>
	<form action="/addxilie.do" method="post">
	<input type="hidden" id="BID" name="BID">
	<input type="text" id="Name" name="Name" ><br>&nbsp;<br><input style="width: 100px; height: 25px;" type="submit" value="添加该车系" onclick="newxilie();">
	<a style="width: 100px; height: 25px;" class="btn bg-warning" href="/fanhuiBuChongCaiLiao.do">返回</a>
	</form>
</body>
</html>