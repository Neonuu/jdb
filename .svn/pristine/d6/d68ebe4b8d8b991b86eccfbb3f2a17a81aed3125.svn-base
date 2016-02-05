
<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">  
<title>机构信息维护</title>
<link href="/jdb/css/style.css" type="text/css" rel="stylesheet">
<link href="/jdb/css/font.css" type="text/css" rel="stylesheet">
<link href="/jdb/css/grid.css" type="text/css" rel="stylesheet">
<script src="/jdb/js/jquery.min.js" type="text/javascript"></script>

<script type="text/javascript">
function changePage(pagenum){
	    
		document.getElementById("page").value = pagenum;
		document.searchForm.submit();
	}
	
function changePage2(){
	var a = document.getElementById("page2").value;
	var b = document.getElementById("maxpage").value;
	if(Number(a) > Number(b)){
		a = b;
	}if(Number(a) < 1){
		a = 1;
	}
	document.getElementById("page").value = a;
	document.searchForm.submit();
}
	
	function p_del() { 
        var msg = "您真的确定要删除吗？\n\n请确认！"; 
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
	$("#btn5").attr("class","btn btn-sm");
});

</script>
</head>

<body STYLE="BACKGROUND-COLOR:#;">

    
    
    <c:forEach items="${kzlist}" var="kz">
  <c:forEach items="${alloperate_id}" var="cz">
  <c:if test="${kz.operate_id == cz}">
  <input type="button" style="width:150px" value="${kz.operate_name}" id="btn${kz.operate_id}" name="btn${kz.operate_id}" onclick="window.location.href='${kz.operate_url}'" />
  &nbsp;&nbsp;
  </c:if>
  </c:forEach>
  </c:forEach>
<hr/>  
<input type=button style="width:150px" value="机构入驻"  onclick="window.location.href='insertOrgjsp.do'">
 <hr/>
<form name="searchForm" method="post" action="select.do">
<input type="hidden" name="page" id="page"/>
 
    	<input type="text" name="orgId" id="orgId" placeholder="机构ID" onkeyup="value=value.replace(/[^\d]/g,'')">
   
    	<input type="text" name="orgName" id="orgName" placeholder="机构名称" value="${svo.orgName}">
    	
    	<input type="text" name="area" id="area" placeholder="服务区域" value="${svo.area}">
  
    	<input type="submit" value="查询" class="btn bg-warning " style="width:68px;"/>
 

</form>
<div class="widget-content">
<table class="table table-striped table-bordered" width="100%" border="1" align="center" cellspacing="1">
	<tr>
    	<td>机构ID</td>
        <td>机构名称</td>
        <td>最大返点</td>
        <td>服务区域</td>
        <td>状态说明</td>
        <td>征信查询费</td>
        <td>上门考察费</td>
        <td>放款手续费</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${plist}" var="p">
    	<tr>
	    	<td>${p.orgId }</td>
	        <td>${p.orgName }</td>
	        <td>${p.maxRebate }%</td>
	        <td>${p.area }</td>
	        
	        <c:choose>
	          <c:when test="${p.statements == 0}">
	          <td>已开通</td>
	          </c:when>
	          <c:when test="${p.statements == 1}">
	          <td>未开通</td>
	          </c:when>
	          <c:when test="${p.statements == 2}">
	          <td>伪开通</td>
	          </c:when>
	        </c:choose>
	        
	        <td>${p.creditEnquiryCost }</td>
	        <td>${p.doorServiceCost }</td>
	        <td>${p.loanHandCost }</td>
	       
	        <td>
	        	<a href="entryUpdate.do?orgId=${p.orgId}" class="btn btn-sm">修改</a>
	        	<c:choose>
	        		<c:when test="${p.isdel == 0}">
	        		    
	        			<a href="updateOrgIsdel.do?orgId=${p.orgId}&isdel=1" onclick="javascript:return p_del()" class="btn btn-sm">删除</a>
	        		</c:when>
	        		<c:otherwise>
	        			<a href="updateOrgIsdel.do?orgId=${p.orgId}&isdel=0" class="btn btn-sm">恢复</a>
	        		</c:otherwise>
	        	</c:choose>
	        	<a href="showLogo.do?orgId=${p.orgId}" class="btn btn-sm">查看机构Logo</a>
	        	<a href="selectAllPro.do?orgId=${p.orgId}" class="btn btn-sm">管理机构产品</a>
	        </td>
	    </tr>
    </c:forEach>
</table>
</div>
<div style="text-align:center">
    <a href="javascript:changePage(1)" class="btn btn-sm">首页</a>
	<c:choose>
	<c:when test="${svo.page != 1}">
	<a href="javascript:changePage(${svo.page-1})" class="btn btn-sm">上一页</a>
	</c:when>
	<c:otherwise>上一页</c:otherwise>
	</c:choose>
	第${svo.page}/${svo.maxpage}页
	<c:choose>
	<c:when test="${svo.page != svo.maxpage}">
	<a href="javascript:changePage(${svo.page+1})" class="btn btn-sm">下一页</a>
	</c:when>
	<c:otherwise>下一页</c:otherwise>
	</c:choose>
	<a href="javascript:changePage(${svo.maxpage})" class="btn btn-sm">尾页</a>
	<input type="text" placeholder="页码" style="width:60px;height:25px;" id="page2" onkeyup="value=value.replace(/[^\d]/g,'')"/>
	<a href="javascript:changePage2()" class="btn btn-sm"  id="jump" >跳转</a>
	<input type="hidden" value="${svo.maxpage}" id="maxpage">
	<a href="javascript:goBack()" class="btn btn-sm">返回</a>
</div>	

</body>
</html>
