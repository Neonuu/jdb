<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>主页</title>
    <link href="/jdb/css/style.css" rel="stylesheet" type="text/css"/>
	<link href="/jdb/css/grid.css" rel="stylesheet" type="text/css"/>
	<link href="/jdb/css/font.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="/jdb/js/jquery.min.js"></script>
    
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
    $(function(){
	//菜单隐藏展开
	var tabs_i=0
	$('.vtitle').click(function(){
		var _self = $(this);
		var j = $('.vtitle').index(_self);
		if (tabs_i == j) return false; tabs_i = j;
		_self.addClass('active').siblings().removeClass('active');
		
		$('.vcon').slideUp().eq(tabs_i).slideDown();
		$("#divshow a:first").click();
	});
	$('#divs').css("display","");
})
</script>
<script type="text/javascript" language="javascript">   
function iFrameHeight() {   
var ifm= document.getElementById("iframepage");   
var subWeb = document.frames ? document.frames["iframepage"].document : ifm.contentDocument;   
if(ifm != null && subWeb != null) {
   ifm.height = subWeb.body.scrollHeight;
   ifm.width = subWeb.body.scrollWidth;
} 
function s_sms(){
	var s_page = document.getElementById("iframepage");
	
}
}
function loadcli(){
    $("a")[3].click();
        return;
 }
window.onload=loadcli;
</script>
</head>
<body>
<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="clearfix">
		<a class="brand"><img alt="" src="../img/top_logo.png"></a>
			<div class="nav-collapse ">
              <ul class="nav pull-right">
                <li>
                  <span class="e-icon-user warning h2 mr10"></span>
                  <a>欢迎您，<%=session.getAttribute("user_name") %></a>
                </li>
                <li class="divider-vertical"></li>
                <li><a style="color:white;" href="/login.jsp">注销</a></li>
              </ul>
            </div> <!-- /nav-collapse -->
		</div> <!-- /container -->
	</div> <!-- /navbar-inner -->
</div>
<div style="margin-top:60px;width:20%;">
<div id="divshow" class="navbar-collapse collapse templatemo-sidebar clearfix">
<c:forEach items="${glist}" var="g">
<c:forEach items="${inglist}" var="ing">
<c:if test="${g.group_id == ing}">
	<div class="vtitle active">${g.group_name}</div>
	<div id="divs" class="vcon" style="display:none;">
		<ul class="vconlist clearfix">
			<c:forEach items="${gplist}" var="gp">
			<c:if test="${g.group_id == gp.group_id}">
			<c:forEach items="${allplist}" var="allp">
			<c:if test="${gp.power_id == allp}">
				<li class="select"><a href="${gp.power_url}?power_id=${gp.power_id}" target=iframepage>${gp.power_name}</a></li>
			</c:if>
			</c:forEach>
			</c:if>
			</c:forEach>	
		</ul>
	</div>
</c:if>
</c:forEach>
</c:forEach>
</div>
</div>
  <div class="templatemo-content-wrapper" >
    <div class="templatemo-content">
      <div style="color:#999; line-height:300px; text-align:center;">
      <iframe width="100%" height="100%" id="iframepage" name="iframepage" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" onLoad="iFrameHeight()">
      </iframe>
    </div>
  </div>
</div>
</body>
</html>