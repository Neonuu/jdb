
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
<title>管理机构产品</title>
<link href="/jdb/css/style.css" type="text/css" rel="stylesheet">
<link href="/jdb/css/font.css" type="text/css" rel="stylesheet">
<link href="/jdb/css/grid.css" type="text/css" rel="stylesheet">
<script src="/jdb/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
function changePage(pagenum){
	    
		document.getElementById("page").value = pagenum;
		document.searchProForm.submit();
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
	document.searchProForm.submit();
}	
	
function p_del() { 
        var msg = "您确定要下架吗？\n\n请确认！"; 
        if (confirm(msg)==true){ 
            return true; 
        }else{ 
              return false; 
             } 
}

function p_del2() { 
    var msg = "您确定要冻结吗？\n\n请确认！"; 
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

<hr/>
<input type=button style="width:150px" value="产品入驻"  onclick="window.location.href='insertProjsp.do'">
<hr/>

<form name="searchProForm" method="post" action="selectPro.do">
<input type="hidden" name="page" id="page"/>

    	<input type="text" name="proId" id="proId" value="${svo.proId}" placeholder="产品ID" onkeyup="value=value.replace(/[^\d]/g,'')">
  
    	<input type="text" name="proName" id="proName" placeholder="产品名称" value="${svo.proName}">
    	
    	<input type="text" name="area" id="area" placeholder="服务区域" value="${svo.area}">
   
    	<input type="submit" value="查询" class="btn bg-warning " style="width:68px;"/>
   
</form>
<div class="widget-content">
<table class="table table-striped table-bordered" width="100%" border="1" align="center" cellpadding="1" cellspacing="1">
	<tr>
	    <td>产品ID</td>
    	<td>产品名称</td>
        <td>适用人群</td>
        <td>返点额度</td>
        <td>申请数量</td>
        <td>服务区域</td>
        <td>所属机构</td>
        <td>产品状态</td>
        <td>操作</td>
        
    </tr>
    <c:forEach items="${plist}" var="p">
    	<tr>
    	    <td>${p.proId }</td>
	    	<td>${p.proName }</td>
	        <td>${p.fitPeople }</td>
	        <td>${p.rebateLimit }%</td>
	        <td>${p.applyNum }</td>
	        <td>${p.area }</td>
	        <td>${p.orgName }</td>
	        
	        <c:choose>
	        <c:when test="${p.statements == 1}"><td>未上架</td></c:when>
	        <c:when test="${p.statements == 2}"><td>上架</td></c:when>
	        <c:when test="${p.statements == 3}"><td>下架</td></c:when>
	        <c:when test="${p.statements == 4}"><td>被冻结</td></c:when>
	        </c:choose>
	        
	        <td>
	        	<a href="entryUpdatePro.do?proId=${p.proId}" class="btn btn-sm">修改</a>
	        	<c:choose>
	        		<c:when test="${p.statements == 2}">
	        			<a href="updateProState.do?proId=${p.proId}&orgId=${p.orgId}&statements=3" onclick="javascript:return p_del()" class="btn btn-sm">下架</a>
	        		</c:when>
	        		<c:when test="${p.statements == 3}">
	        			<a href="updateProState.do?proId=${p.proId}&orgId=${p.orgId}&statements=2" class="btn btn-sm">上架</a>
	        			<a href="updateProState.do?proId=${p.proId}&orgId=${p.orgId}&statements=4" onclick="javascript:return p_del2()" class="btn btn-sm">冻结</a>
	        		</c:when>
	        	</c:choose>
	        	
	        	<a href="proDetail.do?proId=${p.proId}&orgId=${p.orgId}" class="btn btn-sm">产品详情</a>
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