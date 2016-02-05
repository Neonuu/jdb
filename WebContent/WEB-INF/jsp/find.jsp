<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>短信列表</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="/jdb/css/style.css" type="text/css" rel="stylesheet">
        <link href="/jdb/css/font.css" type="text/css" rel="stylesheet">
        <link href="/jdb/css/grid.css" type="text/css" rel="stylesheet">
       <script src="/jdb/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
	 $(function(){
	    	$("#btn19").attr("class","btn btn-sm");
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
<script language="JavaScript" type="text/JavaScript">
	function changePage(pagenum){
		document.getElementById("pagenum").value = pagenum;
		$("#searchForm").submit();
	}
	
	function submitInfo(){
        $("#searchForm").submit();
    }
	function submitPage(){
		$("#pagenum").val($("#page").val()); 
	    $("#searchForm").submit();
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
			$("#searchForm").submit();
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
		<form id="searchForm" action="listPage.do" method="post">
		<input type="hidden" value="" id="pagenum" name="pagenum"/>
		<input type="hidden" value="${svo.maxpage}" id="tatolpagenum" name="tatolpagenum"/>
					<h1>短信列表</h1>
						<h2>&nbsp;&nbsp;&nbsp;&nbsp;类型：<select name="info" id="s1" style="width:120px;height:35px;">
						  
		                  
                          <c:if test="${info_type=='' || info_type==null}">
                          <option value="${info_type}">全部</option>
                          </c:if> 
                          
                          <c:if test="${info_type!='' && info_type!=null}">
                          <option value="${info_type}">${info_type}</option>
                          <option value="">全部</option>
                          </c:if>
						    <c:forEach items="${info}" var="t" 
										varStatus="s">
							<option value="${t.sms_type}">${t.sms_type}</option>
							</c:forEach>
						</select>
						<input type="button"style="width:45px;height:38px;" onclick="submitInfo()" value="查找"/>
					</h2>
					<div id="div1">
					<table class="table table-striped table-bordered">
						<tr class="table_header">
							<td>
								短信ID
							</td>
							<td>
								主叫
							</td>
							
							<td>
								被叫
							</td>
							<td width="300px;">
								短信的内容
							</td>
							<td>
								发送时间
							</td>
							<td>
								返回code码
							</td>
							<td>
								用户名
							</td>
							<td>
								发送类型
							</td>
							
						</tr>
						
						
						<c:forEach items="${alist}" var="e" >
						
						<tr>
							<td>
								${e.tran_id}
							</td>
							<td>
								${e.callback}
							</td>
							<td>
								${e.phone_num}
							</td>
							<td>
								<div style='width:180px;overflow: hidden;height:20px;'onmouseover='this.style.width=""' onmouseout='this.style.width="180px"'>${e.sms_msg}</div>
							</td>
							<td>
								${e.send_time}
							</td>
							<td>
							<c:if test="${e.stauts == 0}">
                              OK
                            </c:if>
                            <c:if test="${e.stauts == 1}">
                                                                   请求参数缺失
                            </c:if>
                            <c:if test="${e.stauts == 2}">
                                                                  请求参数格式错误
                            </c:if>
                            <c:if test="${e.stauts == 3}">
                                                                  账户余额不足
                            </c:if>
                            <c:if test="${e.stauts == 4}">
                                                                  关键词屏蔽
                            </c:if>
                            <c:if test="${e.stauts == 5}">
                                                                  未找到对应id的模板
                            </c:if>
                            <c:if test="${e.stauts == 6}">
                                                                  添加模板失败
                            </c:if>
                            <c:if test="${e.stauts == 7}">
                                                                   模板不可用
                            </c:if>
                            <c:if test="${e.stauts == 8}">
                                                                  同一手机号30秒内重复提交相同的内容
                            </c:if>
                            <c:if test="${e.stauts == 9}">
                                                                  同一手机号5分钟内重复提交相同的内容超过3次
                            </c:if>
                            <c:if test="${e.stauts == 10}">
                                                                  手机号黑名单过滤
                            </c:if>
                            <c:if test="${e.stauts == 11}">
                                                                  接口不支持GET方式调用
                            </c:if>
                            <c:if test="${e.stauts == 12}">
                                                                  接口不支持POST方式调用
                            </c:if>
                            <c:if test="${e.stauts == 13}">
                                                                  营销短信暂停发送
                            </c:if>
                            <c:if test="${e.stauts == 14}">
                                                                  解码失败
                            </c:if>
                            <c:if test="${e.stauts == 15}">
                                                                  签名不匹配
                            </c:if>
                            <c:if test="${e.stauts == 16}">
                                                                  签名格式不正确
                            </c:if>
                            <c:if test="${e.stauts == 17}">
                             24小时内同一手机号发送次数超过限制
                            </c:if>
                            <c:if test="${e.stauts == 18}">
                                                                  签名校验失败
                            </c:if>
                            <c:if test="${e.stauts == 19}">
                                                                  请求已失效
                            </c:if>
                            <c:if test="${e.stauts == 20}">
                                                                  不支持的国家地区
                            </c:if>
                            <c:if test="${e.stauts == 21}">
                                                                  解密失败
                            </c:if>
                            <c:if test="${e.stauts == 22}">
                             1小时内同一手机号发送次数超过限制
                            </c:if>
                            <c:if test="${e.stauts == 23}">
                                                                  发往模板支持的国家列表之外的地区
                            </c:if>
                            <c:if test="${e.stauts == 24}">
                                                                  添加告警设置失败
                            </c:if>
                            <c:if test="${e.stauts == 25}">
                                                                   手机号和内容个数不匹配
                            </c:if>
                            <c:if test="${e.stauts == -1}">
                                                                  非法的apikey
                            </c:if>
                            <c:if test="${e.stauts == -2}">
                             API没有权限
                            </c:if>
                            <c:if test="${e.stauts == -3}">
                             IP没有权限
                            </c:if>
                            <c:if test="${e.stauts == -4}">
                                                                  访问次数超限
                            </c:if>
                            <c:if test="${e.stauts == -5}">
                                                                  访问频率超限
                            </c:if>
                            <c:if test="${e.stauts == -50}">
                                                                   未知异常
                            </c:if>
                            <c:if test="${e.stauts == -51}">
                                                                  系统繁忙
                            </c:if>
                            <c:if test="${e.stauts == -52}">
                                                                  充值失败
                            </c:if>
                            <c:if test="${e.stauts == -53}">
                                                                  提交短信失败
                            </c:if>
                            <c:if test="${e.stauts == -54}">
                                                                  记录已存在
                            </c:if>
                            <c:if test="${e.stauts == -55}">
                                                                  记录不存在
                            </c:if>
                            <c:if test="${e.stauts == -57}">
                                                                  用户开通过固定签名功能，但签名未设置
                            </c:if>
							</td>
							<td>
								${e.users}
							</td>
							<td>
								${e.info}
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
				
			
</form>
	</body>
</html>
