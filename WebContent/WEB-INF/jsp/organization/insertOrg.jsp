<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>机构入驻</title>
    
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
	
	function vOrgName(){
		var orgName = $("#orgName").val();
		if(orgName == "" || orgName.length == 0){
			$("#t3").show();
			return false;
		}else{
			$("#t3").hide();
			return true;
		}
	}
	
	function vMaxRebate(){
		var maxRebate = $("#maxRebate").val();
		if(maxRebate == "" || maxRebate.length == 0){
			$("#t4").show();
			return false;
		}else{
			$("#t4").hide();
			return true;
		}
	}
	
	function vArea(){
		var area = $("#area").val();
		if(area == "" || area.length == 0){
			$("#t5").show();
			return false;
		}else{
			$("#t5").hide();
			return true;
		}
	}
	
	function vCreditEnquiryCost(){
		var creditEnquiryCost = $("#creditEnquiryCost").val();
		if(creditEnquiryCost == "" || creditEnquiryCost.length == 0){
			$("#t6").show();
			return false;
		}else{
			$("#t6").hide();
			return true;
		}
	}
	
	function vDoorServiceCost(){
		var doorServiceCost = $("#doorServiceCost").val();
		if(doorServiceCost == "" || doorServiceCost.length == 0){
			$("#t7").show();
			return false;
		}else{
			$("#t7").hide();
			return true;
		}
	}
	
	function vLoanHandCost(){
		var loanHandCost = $("#loanHandCost").val();
		if(loanHandCost == "" || loanHandCost.length == 0){
			$("#t8").show();
			return false;
		}else{
			$("#t8").hide();
			return true;
		}
	}
	
	
	function goback(){
		history.go(-1);
	}
	
	function init(){
		
		vOrgName();
		vArea();
		vCreditEnquiryCost();
		vDoorServiceCost();
		vLoanHandCost();
		
	}
	function vForm(){
		if(!vOrgName()){
			return false;
		}
		
		if(!vArea()){
			return false;
		}
		
		if(!vCreditEnquiryCost){
			return false;
		}
		
		if(!vDoorServiceCost){
			return false;
		}
		
		if(!vLoanHandCost){
			return false;
		}
		return true;
	}
	
	$(function(){
		$("#btn5").attr("class","btn btn-sm");
	});
</script>

  </head>
  <body onload="init();" STYLE="BACKGROUND-COLOR:#;">
  <c:forEach items="${kzlist}" var="kz">
  <c:forEach items="${alloperate_id}" var="cz">
  <c:if test="${kz.operate_id == cz}">
  <input type="button" style="width:150px" value="${kz.operate_name}" id="btn${kz.operate_id}" name="btn${kz.operate_id}" onclick="window.location.href='${kz.operate_url}'" />
  &nbsp;&nbsp;
  </c:if>
  </c:forEach>
  </c:forEach>

<form action="insertOrg.do" method="post" name="insertOrgForm" onsubmit="return vForm(); " enctype="multipart/form-data">
<div class="widget-content">
<table style="width:500;">
  <tr>
    <td colspan="3" align="center">
    	机构入驻
    </td>
  </tr>
  
  <tr>
    <td align="right" width="200">机构Logo:</td>
    <td width="200">
      	<input type="file" id="myfiles" name="myfiles"/> 
    </td>
    <td id="t2" width="100"></td>
  </tr>
    <tr>
    <td align="right">机构名称:</td>
    <td>
      	<input type="text" id="orgName" name="orgName" onblur="vOrgName();" />
    </td>
    <td id="t3"><p style="color:red">请输入机构名称</p></td>
  </tr>
  <tr>
    <td align="right">最高返点:</td>
    <td>
      	<input type="text" id="maxRebate" name="maxRebate" disabled="disabled" />
    </td>
    <td id="t4"></td>
  </tr>
  <tr>
    <td align="right">服务区域:</td>
    <td>
       <input type = "text" id="area" name="area" onblur="vArea()"/>
    </td>
    <td id="t5"><p style="color:red">请输入服务区域</p></td>
  </tr>
    <tr>
    <td align="right">征信查询费:</td>
    <td>
       <input type = "text" id="creditEnquiryCost" name="creditEnquiryCost" onblur="vCreditEnquiryCost()"/>
    </td>
    <td id="t6"><p style="color:red">请输入征信查询费</p></td>
  </tr>
    <tr>
    <td align="right">上门考察费:</td>
    <td>
       <input type = "text" id="doorServiceCost" name="doorServiceCost" onblur="vDoorServiceCost()"/>
    </td>
    <td id="t7"><p style="color:red">请输入上门考察费</p></td>
  </tr>
    <tr>
    <td align="right">放款手续费:</td>
    <td>
       <input type = "text" id="loanHandCost" name="loanHandCost" onblur="vLoanHandCost()"/>
    </td>
    <td id="t8"><p style="color:red">请输入放款手续费</p></td>
  </tr>
  <tr>
    <td align="right"></td>
    <td>
   <div style="display:none">
       <input width="10px" height="10px" name="statements" id="statements" type="radio" value="0" />开通
       <input name="statements" id="statements" type="radio" value="1" />未开通
       <input name="statements" id="statements" type="radio" value="2" checked="checked"/>伪开通
    </div>   
    </td>
  </tr>
  <tr>
  <td colspan="3">
  <div style="text-align: center;">
        <input type="submit" value="提交" class="btn bg-warning" style="width:100px;"/>
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset" value="重置"   class="btn bg-warning" style="width:100px;"/>
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type=button value="返回" onclick="goback();"  class="btn bg-warning" style="width:100px;"/> 
</div>
</td>
  </tr>
</table>
</div>

</form>
</body>
</html>
