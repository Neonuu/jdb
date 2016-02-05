<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
<title>客户列表</title>
<link href="/jdb/css/style.css" type="text/css" rel="stylesheet">
<link href="/jdb/css/font.css" type="text/css" rel="stylesheet">
<link href="/jdb/css/grid.css" type="text/css" rel="stylesheet">
<script src="/jdb/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
	function changePage(pagenum){
		document.getElementById("pagenum").value = pagenum;
		document.searchForm.submit();
	}
	 $(function(){
	    	$("#btn27").attr("class","btn btn-sm");
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

<form name="searchForm" method="post" action="/selectAllKehu.do">
<input type="hidden" name="pagenum" id="pagenum"/>
<table>
<tr>
<td>
<input type="text" name="customer_name" id="customer_name" placeholder="客户姓名" value="${svo.customer_name}" />
<input type="text" name="phone" id="phone" placeholder="客户电话" value="${svo.phone}" />
<input style="width:68px;" class="btn bg-warning" type="submit" value="查询"/>
</td>
</tr>
</table>
</form>
<hr>
<div id="div1" class="templatemo-content-wrapper">
<table class="table table-striped table-bordered" >
	<tr>
        <td>客户姓名</td>
        <td>电话号码</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${clist}" var="kh">
    	<tr>
	        <td>${kh.customer_name }</td>
	        <td>${kh.phone }</td>
	        <td>
	        <a class="btn btn-sm" href="/kehuxiangqing2.do?id=${kh.id}">查看详细信息</a>
	        </td>
	    </tr>
    </c:forEach>
</table>
</div>
<hr/>
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
	&nbsp;
	<a class="btn btn-sm" href="javascript:history.back(-1);">返回</a>
	<input type="text" onkeyup="value=value.replace(/[^\d]/g,'')" placeholder="页码" style="width:60px;height:25px;" id="page"/>
	<a class="btn btn-sm"  id="jump">跳转</a>
	<input type="hidden" value="${svo.maxpage}" id="maxpage">
</div>	
</body>
</html>
