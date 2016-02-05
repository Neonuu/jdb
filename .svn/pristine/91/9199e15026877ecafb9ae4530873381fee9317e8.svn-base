<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>72小时外订单审核管理</title>
<link href="/jdb/css/style.css" rel="stylesheet" type="text/css"/>
<link href="/jdb/css/grid.css" rel="stylesheet" type="text/css"/>
<link href="/jdb/css/font.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="/jdb/js/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
    $("#ok").click(function(){
       if($("#remark").val()=="" || $("#money").val()==""){
          alert("审核备注和金额不能为空！");
          return;
       }
       if(confirm("您确定要提交审核结果吗？")){
	       $.ajax({
	         url:"confirmCheckXinShenOrder.do",
	         type:"post",
	         data:{"id":$("#id").val(),"remarks":$("#remark").val(),"status":3,"money":$("#money").val()},
	         dataType:"json",
	         success:function(data){
	            if(data.msg){
	             alert(data.msg);
	            }else{
	             alert("修改成功");
	              window.location.href="toAuditingOrder.do";
	            }
	         },
	         error:function(){
	             alert("修改失败了！");
	         }
	       });
       }
    });



    $("#no").click(function(){
       if($("#remark").val()==""){
          alert("请输入审核备注！");
          return;
       }
       if(confirm("您确定要提交审核结果吗？")){
	       $.ajax({
	         url:"confirmCheckXinShenOrder.do",
	         type:"post",
	         data:{"id":$("#id").val(),"remarks":$("#remark").val(),"status":5,"money":0},
	         dataType:"json",
	         success:function(data){
	            if(data.msg){
	             alert(data.msg);
	            }else{
	             alert("修改成功");
	              window.location.href="toAuditingOrder.do";
	            }
	         },
	         error:function(){
	             alert("修改失败了！");
	         }
	       });
       }
    });
    
    
    $(function(){
    	$("#btn12").attr("class","btn btn-sm");
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
                <input  type="hidden" id="id" value="${map.id}"/>
            <div class="widget-content">
              <table class="table table-striped table-bordered">
                <tr>
                  <td> 用户名： </td><td><span>${map.name}</span></td>
                </tr>
                <tr>
                  <td> 订单号：</td><td><span>${map.order_number}</span></td>
                </tr>
                <tr>
                  <td> 用户身份：</td><td><span>${map.user_identity}</span></td>
                </tr>
                <tr>
                  <td>产品名：</td><td><span id="prodect">${map.product}</span></td>
                </tr>
                <tr>
                  <td> 真实姓名：</td><td><span>${map.true_name}</span></td>
                </tr>
                <tr>
                  <td> 身份证号：</td><td><span>${map.user_idCardNumber}</span></td>
                </tr>
                <tr>
                  <td> 电话：</td><td><span>${map.tel_number}</span></td>
                </tr>
                <tr>
                  <td> 省份：</td><td><span>${map.province}</span></td>
                </tr>
                <tr>
                  <td>  城市：</td><td><span>${map.city}</span></td>
                </tr>
                <tr>
                  <td> 信审时间：</td><td><span>${map.add_time}</span></td>
                </tr>
                <tr>
                  <td> 信审人：</td><td><span>${map.recommend_name}</span></td>
                </tr>
              </table>
            </div>
            <div style="text-align: center;"><br/>
		        <input id="money" type="number" placeholder="产品金额(圆)" />
    		</div>
    		<div style="text-align: center;"><br/>
    		    <textarea  id="remark"  maxlength=100 style="height:100px;width:300px;" placeholder="审核备注：限100字以内"></textarea>
    		</div>
            <div style="text-align: center;"><br/>
	          <a id="ok" class="btn bg-warning">通过</a>
	          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	          <a id="no" class="btn bg-warning">拒绝</a>
	        </div>
        </div>
    </div> 
</body>
</html>