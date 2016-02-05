<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>短信模板列表</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="/jdb/css/style.css" type="text/css" rel="stylesheet">
        <link href="/jdb/css/font.css" type="text/css" rel="stylesheet">
        <link href="/jdb/css/grid.css" type="text/css" rel="stylesheet">
        <script src="/jdb/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
	 $(function(){
	    	$("#btn18").attr("class","btn btn-sm");
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
		<script type="text/javascript">
	function changePage(pagenum){
		document.getElementById("pagenum").value = pagenum;
		document.searchForm.submit();
		aleart(page);
	}
	
	$(function(){
    	$("#btn2").attr("class","btn btn-sm");
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
	</head>
	<body>
<div style="text-align:left;"  class="templatemo-content-wrapper">
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
<p>
						<input type="button" style="width:150px"
						class="button" 
						value="添加模板" 
						onclick="location='add.do'"/>
						
					</p>
					<hr/>
<form name="searchForm" method="post" action="find.do">
<input type="hidden" name="pagenum" id="pagenum"/>
</form>
		<div id="div1">
					<h1>
						短信模板列表
					</h1>
					<table class="table table-striped table-bordered">
						<tr>
						    <td>
								编号
							</td>
							<td width="600px;">
								短信内容
							</td>
							
							<td >
								类型
							</td>
							<td>
								操作
							</td>
							
						</tr>
						<% 
						int i = 1;
						Integer j = (Integer)session.getAttribute("page");
						Integer c = (Integer)session.getAttribute("count");
						%>
						<c:forEach items="${alist}" var="e">
						
						<tr>
						    <td>	
                            	                        <%=i+((j-1)*c)%>
                                                        <%i+=1;%>
                                                        </td>
							<td>
								<div style='width:300px;overflow: hidden;height:20px;'onmouseover='this.style.width=""' onmouseout='this.style.width="300px"'>${e.sms_msg}</div>
							</td>
							<td>
								${e.sms_type}
							</td>
							
							<td>
								<a class="btn btn-sm btn-gray" href="del.do?tid=${e.tid}" 
								onclick="return confirm('是否确定删除${e.sms_msg}');">删除</a>
								&nbsp;<a class="btn btn-sm" href="modify.do?tid=${e.tid}">修改</a>
							</td>
						</tr>
						
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
	&nbsp;
	<input type="text" onkeyup="value=value.replace(/[^\d]/g,'')" placeholder="页码" style="width:60px;height:25px;" id="page"/>
   	<a class="btn btn-sm"  id="jump">跳转</a>
   	<input type="hidden" value="${svo.maxpage}" id="maxpage">
	<a class="btn btn-sm" href="javascript:history.back(-1);">返回</a>
</div>	
					
	</body>
</html>
