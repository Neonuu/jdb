<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!doctype html>
<html>
  <head>

    
    <title>产品入驻</title>
    
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
	
<script>

	
	function goback(){
		history.go(-1);
	}
	
	
	$(function(){
		$("#btn6").attr("class","btn btn-sm");
	});
</script>

  </head>
  <body background="">
 

<div class="widget-content" style="width: 300px">
<table style="width:300;">
  <tr>
    <td colspan="3" align="center">
    	订单详情
    </td>
  </tr>
  <tr>
    <td align="center" width="150">楼盘名称:</td>
    <td width="150">
      	<input type="text" id="carbrand" name="carbrand" value="${house.housingName }" />
    </td>
  </tr>
  
    <tr>
    <td align="center">地址:</td>
    <td>
      	<input type="text" id="carxilie" name="carxilie" value="${house.housingAddress }" />
    </td>
 
  </tr>
  <tr>
    <td align="center">房产证号:</td>
    <td>
      	<input type="text" id="carModel" name="carModel" value="${house.housingFCZ }"/> 	
    </td>
  </tr>
  
  <tr>
  <td colspan="3">
  <div style="text-align: center;">
		<input type=button value="返回" onclick="goback();" class="btn bg-warning" style="width:100px;"/> 
</div>
  
  </td>
  </tr>
</table>
</div>
</body>
</html>