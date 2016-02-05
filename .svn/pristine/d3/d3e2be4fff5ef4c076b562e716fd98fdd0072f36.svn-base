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
<title>修改项目信息</title>
<link href="/jdb/css/style.css" type="text/css" rel="stylesheet">
<link href="/jdb/css/font.css" type="text/css" rel="stylesheet">
<link href="/jdb/css/grid.css" type="text/css" rel="stylesheet">
<script src="/jdb/js/jquery.min.js" type="text/javascript"></script>
<!--  <script type="text/javascript">
	$().ready(function(){
		//获得选中项的部门ID
		var deptid = $("#dpid").val();
		//让下拉列表选中
		$("#dept").val(deptid);
	});
</script>
-->
<script type="text/javascript">
  function goBack(){
	  history.go(-1);
  }
  function initradio(rName,rValue){
                var rObj = document.getElementsByName(rName);

                for(var i = 0;i < rObj.length;i++){
                    if(rObj[i].value == rValue){
                        rObj[i].checked =  'checked';
                    }
                }
            }
   function p_del() { 
        var msg = "您真的确定要保存修改吗？\n\n请确认！"; 
        if (confirm(msg)==true){ 
            return true; 
        }else{ 
              return false; 
             } 
}    
   
   $(function(){
		$("#btn5").attr("class","btn btn-sm");
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
<!--  <input type="hidden" id="dpid" value="${project.dept.deptid}"/> -->
<form action="updateOrg.do" onsubmit = "return p_del()" method="post">
	<input name="orgId" type="hidden" value="${organization.orgId}">
	<div class="widget-content">
	<table class="table table-striped table-bordered" align="center" width="544" border="1" cellspacing="1" cellpadding="1">
	  <tr>
	    <td width="186">机构名称</td>
	    <td width="345">
	    <input name="orgName" type="text" id="orgName" value="${organization.orgName}"></td>
	  </tr>
	  <tr>
	    <td>最高返点</td>
	    <td>
	    <input name="maxRebate" type="text" id="maxRebate" readonly="readonly" value="${organization.maxRebate}">%</td>
	    
	  </tr>
	  <tr>
	    <td>服务区域</td>
	    <td>
	    <input name="area" type="text" id="area" value="${organization.area}"></td>
	  </tr>
	  <tr>
	    <td>征信查询费</td>
	    <td>
	    <input name="creditEnquiryCost" type="text" id="creditEnquiryCost" value="${organization.creditEnquiryCost}"></td>
	    
	  </tr>
	  <tr>
	    <td>上门考察费</td>
	    <td>
	    <input name="doorServiceCost" type="text" id="doorServiceCost" value="${organization.doorServiceCost}"></td>
	    
	  </tr>
	  <tr>
	    <td>放款手续费</td>
	    <td>
	    <input name="loanHandCost" type="text" id="loanHandCost" value="${organization.loanHandCost}"></td>
	    
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