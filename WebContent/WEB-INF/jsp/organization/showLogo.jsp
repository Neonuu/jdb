<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'showLogo.jsp' starting page</title>
    
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
    $(document).ready(function(){
    	
    	var imageCode = $("#imageCode").val();
    	if(imageCode == "-1"){
    		alert("上传失败");	
    	}else if(imageCode == "" || imageCode == null){
    		
    	}else if(imageCode == "1"){
    		alert("未选择文件，上传失败");
    	}else if(imageCode == "2"){
    		alert("文件过大，上传失败");
    	}else if(imageCode == "3"){
    		alert("文件格式不符，上传失败");
    	}
    	else if(imageCode == "0"){
    		alert("上传成功");
    	}
    	
    	
    	
    	
    });
    
    
  function goBack(){
	  history.go(-1);
  }
  $(function(){
		$("#btn5").attr("class","btn btn-sm");
	});
    
    
    </script>

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
  <br><br>
    <img height=300 width=300 src="${organization.orgLogo }">
    <br>
    <form action="updateOrgLogo.do" method="post" enctype="multipart/form-data">
    <input name="orgId" type="hidden" value="${organization.orgId}">
           请选择新的Logo：<input type="file" id="myfiles" name="myfiles"/>
                   <input type="submit" value="上传" class="btn4"/>
                   <input type="button" value="返回" onclick="goBack();"/>
                   <input type="hidden" id="imageCode" name="imageCode" value="${imageCode}">                  
    </form>               
  </body>
</html>
