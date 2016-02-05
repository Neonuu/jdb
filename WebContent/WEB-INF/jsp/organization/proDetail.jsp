<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<title>产品详情</title>
<link href="/jdb/css/style.css" type="text/css" rel="stylesheet">
<link href="/jdb/css/font.css" type="text/css" rel="stylesheet">
<link href="/jdb/css/grid.css" type="text/css" rel="stylesheet">
<script src="/jdb/js/jquery.min.js" type="text/javascript"></script>

<script type="text/javascript">

$().ready(function(){
		//获得选中项的部门ID
		var orgId = $("#dpid").val();
		//让下拉列表选中
		$("#orgId").val(orgId);
	});

function p_del() { 
        var msg = "您真的确定要保存修改吗？\n\n请确认！"; 
        if (confirm(msg)==true){ 
            return true; 
        }else{ 
              return false; 
             } 
}

  function goBack(){
	  history.go(-1);
  }
  $(function(){
		$("#btn6").attr("class","btn btn-sm");
	});

</script>

</head>

<body background="">
<c:forEach items="${kzlist}" var="kz">
  <c:forEach items="${alloperate_id}" var="cz">
  <c:if test="${kz.operate_id == cz}">
  <input type="button" style="width:150px" value="${kz.operate_name}" id="btn${kz.operate_id}" name="btn${kz.operate_id}" onclick="window.location.href='${kz.operate_url}'" />
  &nbsp;&nbsp;
  </c:if>
  </c:forEach>
  </c:forEach>
<input type="hidden" id="dpid" value="${productionDetail.orgId}"/>
<form action="updateProDetail.do" onsubmit = "return p_del()" method="post">
	<input name="proId" type="hidden" value="${proId}">
	<div class="widget-content">
	<table class="table table-striped table-bordered" align="center" width="544" border="1" cellspacing="1" cellpadding="1">
	  <tr>
	    <td width="186" align="right">产品类型:</td>
	    <td width="345">
	    <input name="proType" type="text" id="proType" value="${productionDetail.proType}"></td>
	     <td align="right">产品期限:</td>
	    <td>
	    <input name="deadline" type="text" id="deadline" value="${productionDetail.deadline}"></td>
	  </tr>
	  <tr>
	    <td align="right">额度范围:</td>
	    <td>
	    <input name="limitScope" type="text" id="limitScope" value="${productionDetail.limitScope}"></td>
	     <td align="right">综合利率:</td>
	    <td>
	    <input name="synthesisRate" type="text" id="synthesisRate" value="${productionDetail.synthesisRate}">%</td>
	  </tr>
	 <tr>
	    <td align="right">还款方式:</td>
	    <td>
	    <input name="repaymentMode" type="text" id="repaymentMode" value="${productionDetail.repaymentMode}"></td>
	    <td align="right">适用人群:</td>
	    <td>
	    <input name="fitPeople" type="text" id="fitPeople" value="${productionDetail.fitPeople}"></td>
	  </tr><tr>
	    <td align="right">申请条件:</td>
	    <td>
	    <textarea id="applyCondition" name="applyCondition" cols="20" rows="6" >${productionDetail.applyCondition}</textarea>
	    </td>
	   <td align="right">所属机构:</td>
	    <td>
	    <select name="orgId" id="orgId">
		        
		      	<c:forEach items="${olist}" var="o">
		      		<option value="${o.orgId}">${o.orgName}</option>
		      	</c:forEach>
		    </select>
	    </td>
	  </tr>
	</table>
	</div>
	<div style="text-align: center;"><br>
	  <input type="submit" value="修改" class="btn bg-warning" style="width:100px;"/>
	  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  <input type=button value="返回" onclick="goBack();" class="btn bg-warning " style="width:100px;"/>
	</div>
</form>

</body>
</html>