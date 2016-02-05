<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>业绩统计</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="/jdb/css/style.css" type="text/css" rel="stylesheet">
    <link href="/jdb/css/font.css" type="text/css" rel="stylesheet">
    <link href="/jdb/css/grid.css" type="text/css" rel="stylesheet">
    <script src="/jdb/js/jquery.min.js" type="text/javascript"></script>
<style type="text/css">
	#div1{
		width:100%;
		height:400px;
	}
	#divye{
		height:20px;
		text-align:center;
	}
</style>
<script type="text/javascript">
function submitInfo(){
	 $("#searchForm").submit();
}
	function changePage(pagenum){
		document.getElementById("pagenum").value = pagenum;
		document.searchForm.submit();
	}
	function submitPage(){
		$("#pagenum").val($("#page").val()); 
	    document.searchForm.submit();
	}
   
    function shuRuPage() {
       var page = $("#page").val();
       var allPage = $("#tatolpagenum").val();
       if (parseInt(page) > parseInt(allPage)){
          $("#page").val("");
       }
       }
    $(function(){
    	$("#btn16").attr("class","btn btn-sm");
    	$("#jump").click(function (){
    		var a = document.getElementById("page").value;
    		var b = document.getElementById("maxpage").value;
    		if(Number(a) > Number(b)){
    			a = b;
    		}
			document.getElementById("pagenum").value = a;
			document.searchForm.submit();
    	});
    });
</script> 
<script language="javascript" type="text/javascript" src="/jdb/js/My97DatePicker/WdatePicker.js"></script> 
<link href="/jdb/js/My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css"/>  
<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body>
  <div style="text-align: left;"  class="templatemo-content-wrapper">
  <c:forEach items="${kzlist}" var="kz">
  <c:forEach items="${alloperate_id}" var="cz">
  <c:if test="${kz.operate_id == cz}">
  <input style="width:150px" type="button" value="${kz.operate_name}" id="btn${kz.operate_id}" name="btn${kz.operate_id}" onclick="window.location.href='${kz.operate_url}'" />
  &nbsp;&nbsp;
  </c:if>
  </c:forEach>
  </c:forEach>
  <hr/>
  </div>
  <form id="searchForm" name="searchForm" action="tongji.do" method="post">
  <input type="hidden" name="pagenum" id="pagenum"/>
  <h1 style="text-align: center;">业绩统计
  </h1>
  <input id="add_time" name="add_time" type="text" class="Wdate" value="${add_time}" onclick="WdatePicker({dateFmt:'yyyy-MM'})"placeholder="选择月份" style="width:100px;" />
  <input type="button"style="width:42px;height:32px;" onclick="submitInfo()" value="查询"/><br></br>
  
 <div id="div1">
<table class="table table-striped table-bordered">
	<tr>
	<td>用户</td><td>成单数</td><td>金额</td><td>月份</td>
	</tr>
	<c:forEach items="${jdph}" var="jd">
	<c:forEach items="${user}" var="us">
	<c:if test="${jd.user_id == us.user_id }">
	<tr>
		<td>${us.user_name}</td>
		<td>${jd.c}</td>
		<td>${jd.s}</td>
		<td>${jd.month}</td>
	</tr>
	</c:if>
	</c:forEach>
	</c:forEach>
</table>
</div> 
<div id="divye" class="templatemo-content-wrapper" >
	<a class="btn btn-sm" href="javascript:changePage(1)" >首页</a>
	<c:choose>
   	<c:when test="${svo.pagenum == 1}">
   	上一页
   	</c:when>  
   	<c:otherwise>
   	<a class="btn btn-sm" href="javascript:changePage(${svo.pagenum - 1})">上一页</a>
   	</c:otherwise>  
	</c:choose>  
	第${svo.pagenum}/${svo.maxpage}页
	<c:choose>
   	<c:when test="${svo.pagenum == svo.maxpage}">
   	下一页
   	</c:when>  
   	<c:otherwise>
   	<a class="btn btn-sm" href="javascript:changePage(${svo.pagenum + 1})">下一页</a>
   	</c:otherwise>  
	</c:choose>  
	<a class="btn btn-sm" href="javascript:changePage(${svo.maxpage})">尾页</a>
	<input type="text" onkeyup="value=value.replace(/[^\d]/g,'')" placeholder="页码" style="width:60px;height:25px;" id="page"/>
	<a class="btn btn-sm"  id="jump">跳转</a>
	<input type="hidden" value="${svo.maxpage}" id="maxpage">
	&nbsp;
	<a class="btn btn-sm" href="javascript:history.back(-1);">返回</a>
</div>
 </form>
  </body>
</html>
