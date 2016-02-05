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
function changePage(page){
	document.getElementById("page").value = page;
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
$(function(){
	$("#btn30").attr("class","btn btn-sm");
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
<c:forEach items="${kzlist}" var="kz">
  <c:forEach items="${alloperate_id}" var="cz">
  <c:if test="${kz.operate_id == cz}">
  <input type="button" style="width:150px" value="${kz.operate_name}" id="btn${kz.operate_id}" name="btn${kz.operate_id}" onclick="window.location.href='${kz.operate_url}'" />
  &nbsp;&nbsp;
  </c:if>
  </c:forEach>
  </c:forEach>
  <hr/>
  
  <form name="searchForm" method="post" action="/carRecord.do">
<input type="hidden" name="page" id="page"/>
<table>
<tr>
<td>
<input type="text" name="carframe" id="carframe" placeholder="车架号" value="${svo.carframe}" />
<input style="width:68px;" class="btn bg-warning" type="submit" value="查询"/>
</td>
</tr>
</table>
</form>
<hr>
<div id="div1" class="templatemo-content-wrapper">
<table class="table table-striped table-bordered" >
	<tr>
	    <td>ID</td>
	    <td>客户姓名</td>
	    <td>电话号码</td>
        <td>身份证号</td>
        <td>处理时间</td>
        <td>历史状态</td>
        <td>车品牌</td>
        <td>车系</td>
        <td>车型</td>
        <td>车年代</td>
        <td>车架号</td>
        <td>操作</td>
        
        
    </tr>
    <c:forEach items="${crlist}" var="kh">
    	<tr>
    	    <td>${kh.carID }</td>
    	    <td>${kh.true_name }</td>
    	    <td>${kh.tel_number }</td>
    	    <td>${kh.user_idCardNumber }</td>
    	    <td><fmt:formatDate value="${kh.add_time }" type="date" pattern="yyyy-MM-dd"/></td>
    	    <td>
    	    <c:choose>
	          <c:when test="${kh.status == 3}">
	          成功
	          </c:when>
	          <c:when test="${kh.status == 4}">
	          成功
	          </c:when>
	          <c:when test="${kh.status == 5}">
	          失败
	          </c:when>
	        </c:choose>
	        </td>
	        <td>${kh.carbrand }</td>
	        <td>${kh.carxilie }</td>
	        <td>${kh.carModel }</td>
	        <td>${kh.carNiandai }</td>
	        <td>${kh.carframe }</td>
	        <td><a href="carPhoto.do?order_number=${kh.order_number }" class="btn btn-sm">图片</a></td>	      
	    </tr>
    </c:forEach>
</table>

<hr/>
<div id="divye" class="templatemo-content-wrapper" >
	<a class="btn btn-sm" href="javascript:changePage(1)" >首页</a>
	<c:choose>
   	<c:when test="${svo.page == 1}">
   	上一页
   	</c:when>  
   	<c:otherwise>
   	<a class="btn btn-sm" href="javascript:changePage(${svo.page - 1})">上一页</a>
   	</c:otherwise>  
	</c:choose>  
	第${svo.page}/${svo.maxpage}页
	<c:choose>
   	<c:when test="${svo.page == svo.maxpage}">
   	下一页
   	</c:when>  
   	<c:otherwise>
   	<a class="btn btn-sm" href="javascript:changePage(${svo.page + 1})">下一页</a>
   	</c:otherwise>  
	</c:choose>  
	<a class="btn btn-sm" href="javascript:changePage(${svo.maxpage})">尾页</a>
	&nbsp;
	<a class="btn btn-sm" href="javascript:history.back(-1);">返回</a>
	<input type="text" onkeyup="value=value.replace(/[^\d]/g,'')" placeholder="页码" style="width:60px;height:25px;" id="page2"/>
	<a href="javascript:changePage2()" class="btn btn-sm"  id="jump">跳转</a>
	<input type="hidden" value="${svo.maxpage}" id="maxpage">
</div>

</div>

 	
</body>
</html>
