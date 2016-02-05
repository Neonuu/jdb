<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统参数管理</title>
<link href="/jdb/css/style.css" rel="stylesheet" type="text/css"/>
<link href="/jdb/css/grid.css" rel="stylesheet" type="text/css"/>
<link href="/jdb/css/font.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="/jdb/js/jquery.min.js"></script>
<script type="text/javascript"  src="/jdb/js/change_system_param_record.js"></script>
<script type="text/javascript">
    $(function(){
    	$("#btn8").attr("class","btn btn-sm");
    });
</script>
</head>

<body >
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
   <div class="templatemo-content-wrapper" >
        <div class="widget-table">
            <div class="widget-content" style="height: 400px;">
               <table border='1px' id="table1" class="table table-striped table-bordered">
		           <thead>
			           <tr>
			           	   <td>原用户返佣比例</td><td>修改后用户返佣比例</td>
			           	   <td>原推广人返佣比例</td><td>修改后推广人返佣比例</td>
			           	   <td>原用户可提佣金余额比例</td><td>修改后用户可提佣金余额比例</td>
			           	   <td>修改时间</td><td>修改人</td>
			           </tr>
		           </thead>
		           <tbody id="tbody1"></tbody>
      		   </table>
            </div>
        </div>
        <hr/>
        <div  style="text-align: center;"><br/>
    		<a id="btn1" href="#" class="btn btn-sm" >上一页</a>&nbsp;
	        <span id="btn2">第1</span>/<span id="span">${totalCount}</span><span>页</span>
	        <a id="btn3" href="#" class="btn btn-sm" >下一页</a>&nbsp;&nbsp;
	        <a id="btn4" href="#" class="btn btn-sm" >返回</a>&nbsp;
       </div>
    </div>
</body>
</html>