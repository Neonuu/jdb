<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加系统参数管理</title>
<link href="/jdb/css/style.css" rel="stylesheet" type="text/css"/>
<link href="/jdb/css/grid.css" rel="stylesheet" type="text/css"/>
<link href="/jdb/css/font.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="/jdb/js/jquery.min.js"></script>
<script type="text/javascript">
       $(function(){
          $("#ok").click(function(){
              var commission_quota=100;
	          var user_scale=$("#user_scale").val();
	          var recommend_scale=$("#recommend_scale").val();
	          if(commission_quota=="" && user_scale=="" && recommend_scale==""){
	            alert("用户及推广人返佣百分比不能同时为空");
	            return;
	          }
	          if((user_scale!="" && user_scale<=0) || (user_scale!="" && user_scale>=100)){
	            alert("请输入小于100的正数！");
	            return;
	          }
	          if((recommend_scale!="" && recommend_scale<=0) || (recommend_scale!="" && recommend_scale>=100)){
	            alert("非法输入！");
	            return;
	          }
	       if(confirm("您确定要修改系统参数？")){   
             $.ajax({
               url:"changeSystemParamIndex.do",
               data:{"commission_quota":commission_quota,"user_scale":user_scale,"recommend_scale":recommend_scale},
               dataType:"json",
               type:"post",
               success:function(data){
                 if(data.err){
                   alert(data.err);
                 }else{
                   alert("添加成功");
                  window.location.href="toSystemParamIndex.do";
                 }
               },
               error:function(){
                  alert("修改失败！");
               }
             });
            }
          });
          
          $("#back").click(function(){
             window.location.href="toSystemParamIndex.do";
          });
          
          $(function(){
          	$("#btn8").attr("class","btn btn-sm");
          });
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
   <div class="templatemo-content-wrapper">
        <div class="widget-table">
            <div class="widget-content"  style="height:150px;">
              <table class="table table-striped table-bordered">
                <tr>
                  <td>修改前用户返佣百分比：</td><td><input readonly= "readonly " value= "${map.user_scale } "/>&nbsp;<span>%</span></td>
                </tr>
                <tr>
                  <td>修改前推荐人返佣百分比：</td><td><input readonly= "readonly " value= "${map.recommend_scale } "/>&nbsp;<span>%</span></td>
                </tr>
                 <tr>
                  <td>修改前用户提现额度百分比：</td><td><input readonly= "readonly " value= "${map.commission_quota } "/>&nbsp;<span>%</span></td>
                </tr>
              </table>
            </div>
            
            <div class="widget-content"  style="height:100px;">
              <table class="table table-striped table-bordered">
                <tr>
                  <td style="width:849px;">修改后用户返佣百分比：</td><td><input id="user_scale" type="number" placeholder="请输入小于100的正数"/>&nbsp;<span>%</span></td>
                </tr>
                <tr>
                  <td style="width:849px;">修改后推荐人返佣百分比：</td><td><input id="recommend_scale" type="number" placeholder="请输入小于100的正数"/>&nbsp;<span>%</span></td>
                </tr>
              </table>
            </div>
            <hr/>
            <div style="text-align: center;"><br/>
	          <a id="ok" class="btn bg-warning" style="width:80px;height:30px;">确定</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	          <a id="back" class="btn bg-warning" style="width:80px;height:30px;">返回</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        </div>
        </div>
    </div>
</body>
</html>