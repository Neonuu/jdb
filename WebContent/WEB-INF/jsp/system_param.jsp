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
<script type="text/javascript">
   $(function(){
   
      $("#add").click(function(){
          window.location.href="toAddSystemParamIndex.do";
      });
      
      
      $("#change").click(function(){
          window.location.href="toChangeSystemParamIndex.do";
      });   
         
       $("#select").click(function(){
          window.location.href="toChangeSystemParamRecordIndex.do";
      }); 
       
      
       $(function(){
       	   $("#btn8").attr("class","btn btn-sm");
       });
     
   });



</script>
</head>

<body style="text-align: center;">
   
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
    <div class="templatemo-content-wrapper">
        <div class="widget-table">
            <div class="widget-content">
              <table class="table table-striped table-bordered">
                <tr>
                  <td> 用户返佣比例： </td><td><span>${map.user_scale}&nbsp;%</span></td>
                </tr>
                <tr>
                  <td> 推荐人返佣比例：</td><td><span>${map.recommend_scale}&nbsp;%</span></td>
                </tr>
                <tr>
                  <td> 用户提现额度百分比：</td><td><span>${map.commission_quota}&nbsp;%</span></td>
                </tr>
              </table>
            </div>
            <hr/>
            <div><br/>
	            <c:if test="${map.status == '1'}">
					<a id="add" class="btn bg-warning" style="width:80px;height:35px;">添加</a>
			    </c:if>
			    <c:if test="${map.status == '0'}">
					<a id="change" class="btn bg-warning" style="width:80px;height:35px;">修改</a>
			    </c:if>
			        <a id="select" class="btn bg-warning" style="height:35px;">查询修改记录</a>
	        </div>
        </div>
    </div> 
</body>
</html>