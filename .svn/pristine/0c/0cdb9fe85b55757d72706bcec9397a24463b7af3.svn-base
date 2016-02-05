<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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

	
	function vProName(){
		var proName = $("#proName").val();
		if(proName == "" || proName.length == 0){
			$("#t2").show();
			return false;
		}else{
			$("#t2").hide();
			return true;
		}
	}
	
	
	function vOrgName(){
		var fitPeople = $("#fitPeople").val();
		if(fitPeople == "" || fitPeople.length == 0){
			$("#t3").show();
			return false;
		}else{
			$("#t3").hide();
			return true;
		}
	}
	
	function vRebateLimit(){
		var rebateLimit = $("#rebateLimit").val();
		if(rebateLimit == "" || rebateLimit.length == 0){
			$("#t4").show();
			return false;
		}else{
			$("#t4").hide();
			return true;
		}
	}
	
	function vApplynum(){
		var applyNum = $("#applyNum").val();
		if(applyNum == "" || applyNum.length == 0){
			$("#t5").show();
			return false;
		}else{
			$("#t5").hide();
			return true;
		}
	}
	
	function vArea(){
		var area = $("#area").val();
		if(area == "" || area.length == 0){
			$("#t9").show();
			return false;
		}else{
			$("#t9").hide();
			return true;
		}
	}
	
	function vOrgId(){
		var orgId = $("#orgId").val();
		if(orgId == "" || orgId.length == 0){
			$("#t10").show();
			return false;
		}else{
			$("#t10").hide();
			return true;
		}
	}
	
	
	function goback(){
		history.go(-1);
	}
	
	function init(){

		vProName();
		vOrgName();
		vRebateLimit();
		vApplynum();
		vArea();
		vOrgId();
		
	}
	function vForm(){
		
		if(!vProName()){
			return false;
		}
		if(!vOrgName()){
			return false;
		}
		if(!vApplynum()){
			return false;
		}
		if(!vArea()){
			return false;
		}
		if(!vOrgId()){
			return false;
		}
		return true;
	}
	
	$(function(){
		$("#btn6").attr("class","btn btn-sm");
	});
</script>

  </head>
  <body onload="init();" background="">
  <c:forEach items="${kzlist}" var="kz">
  <c:forEach items="${alloperate_id}" var="cz">
  <c:if test="${kz.operate_id == cz}">
  <input type="button" style="width:150px" value="${kz.operate_name}" id="btn${kz.operate_id}" name="btn${kz.operate_id}" onclick="window.location.href='${kz.operate_url}'" />
  &nbsp;&nbsp;
  </c:if>
  </c:forEach>
  </c:forEach>
 
<form action="insertPro.do" method="post" name="insertOrgForm" onsubmit="return vForm(); " enctype="multipart/form-data">
<div class="widget-content">
<table style="width:500;">
  <tr>
    <td colspan="3" align="center">
    	产品入驻
    </td>
  </tr>
  <tr>
    <td align="right" width="200">产品名称:</td>
    <td width="200">
      	<input type="text" id="proName" name="proName" onblur="vProName();" />
    </td>
    <td width="100"><p id="t2" style="color:red">请输入产品名称</p></td>
  </tr>
  
    <tr>
    <td align="right">适用人群:</td>
    <td>
      	<input type="text" id="fitPeople" name="fitPeople" onblur="vOrgName();" />
    </td>
    <td><p id="t3" style="color:red">请输入适用群人</p></td>
  </tr>
  <tr>
    <td align="right">返点额度:</td>
    <td>
      	<input type="text" id="rebateLimit" name="rebateLimit" onblur="vRebateLimit()" onKeypress="return (/[\d.]/.test(String.fromCharCode(event.keyCode)))"/>
      	%
    </td>
    <td><p id="t4" style="color:red">请输入返点额度</p></td>
  </tr>
  <tr>
    <td align="right">申请数量:</td>
    <td>
       <input type="text" id="applyNum" name="applyNum" onblur="vApplynum()" onkeyup="value=value.replace(/[^\d]/g,'')"/>
    </td>
    <td><p id="t5" style="color:red">请输入申请数量</p></td>
  </tr>
  <tr>
    <td align="right">服务区域:</td>
    <td>
       <input type = "text" id="area" name="area" onblur="vArea();"/>
    </td>
    <td><p id="t9" style="color:red">请输入服务区域</p></td>
  </tr>
  <tr>
    <td align="right">所属机构:</td>
    <td>
       <select name="orgId" id="orgId">
		        
		      	<c:forEach items="${olist}" var="o">
		      		<option value="${o.orgId}">${o.orgName}</option>
		      	</c:forEach>
		    </select>
    </td>
    <td><p id="t10" style="color:red">请输入所属机构</p></td>
  </tr>
  <tr>
  <td colspan="3">
  <div style="text-align: center;">
        <input type="submit" value="提交"  class="btn bg-warning" style="width:100px;"/>
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset" value="重置"  class="btn bg-warning" style="width:100px;"/>
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type=button value="返回" onclick="goback();" class="btn bg-warning" style="width:100px;"/> 
</div>
  
  </td>
  </tr>
  
 
</table>
</div>

</form>
</body>
</html>
