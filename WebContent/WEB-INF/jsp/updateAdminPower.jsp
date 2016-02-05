<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>修改管理员信息</title>
<link href="/jdb/css/style.css" type="text/css" rel="stylesheet">
<link href="/jdb/css/font.css" type="text/css" rel="stylesheet">
<link href="/jdb/css/grid.css" type="text/css" rel="stylesheet">
<script src="/jdb/js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
	function changePage(pagenum) {
		document.getElementById("pagenum").value = pagenum;
		document.searchForm.submit();
	}
	function getpower(t) {
		var power = $("input:checkbox[name='power']:checked");
		$("#p1").text("");
		power.each(function() {
			var a = $(this).val() + ",";
			$("#p1").append(a);
		});
		var p1 = $("#p1").text();
		var p2 = $("#p2").text();

		if (t.checked == true) {
			var id = t.id.split("_")[1];
			var idd = $("input[data_id='" + id + "']");
			if (idd.length > 0) {
				for (var i = 0; i < idd.length; i++) {
					idd[i].checked = true;
				}
			}
		} else {
			var id = t.id.split("_")[1];
			var idd = $("input[data_id='" + id + "']");
			if (idd.length > 0) {
				for (var i = 0; i < idd.length; i++) {
					idd[i].checked = false;
				}
			}
		}
		
		
	}
	function getoperate(t) {
		var operate = $("input:checkbox[name='operate']:checked");
		$("#p2").text("");
		operate.each(function() {
			var a = $(this).val() + ",";
			$("#p2").append(a);
		});
		var p1 = $("#p1").text();
		var p2 = $("#p2").text();
		
		if (t.checked == true) {
			var id = t.id.split("_")[1];
			var idd = $("input[id='check_" + id + "']");
			if (idd.length > 0) {
				for (var i = 0; i < idd.length; i++) {
					idd[i].checked = true;
				}
			}
		}
		else {
			var id = t.id.split("_")[1];
			var idd = $("input[id='check_" + id + "']");
			var num = $("input[data_id='" + id + "']:checked").length;
			if(num == 0){
				if (idd.length > 0) {
					for (var i = 0; i < idd.length; i++) {
						idd[i].checked = false;
					}
				}
			}
		}
		
	}

	function fun1() {
		var val = document.getElementById("val1").value.split(",");
		var boxes = document.getElementsByName("power");
		for (i = 0; i < boxes.length; i++) {
			for (j = 0; j < val.length; j++) {
				if (boxes[i].value == val[j]) {
					boxes[i].checked = true;
					break;
				}
			}
		}
	}
	function fun2() {
		var val = document.getElementById("val2").value.split(",");
		var boxes = document.getElementsByName("operate");
		for (i = 0; i < boxes.length; i++) {
			for (j = 0; j < val.length; j++) {
				if (boxes[i].value == val[j]) {
					boxes[i].checked = true;
					break;
				}
			}
		}
	}
	function fun3() {
		var val = document.getElementById("dpid").value.split(",");
		var boxes = document.getElementsByName("org");
		for (i = 0; i < boxes.length; i++) {
			for (j = 0; j < val.length; j++) {
				if (boxes[i].value == val[j]) {
					boxes[i].checked = true;
					break;
				}
			}
		}
	}
	function hidden() {
		document.getElementById("divhide").style.display = "none";
	}
	function text() {
		var p1 = $("#p1").text();
		var p2 = $("#p2").text();
		var id = $("#hid1").val();
		$("#hid2").val(id);
	}
	function p_del() {
		 var checks = document.getElementsByName("org");
		 var orgId = "";
		 for(var i in checks){
		 	if(checks[i].checked){
		 		orgId += checks[i].value+",";
		 	}
		 }
		 if(orgId == ""){
			 orgId = "-1,";
		 }
		 $("#orgId").val(orgId);
		 
		 
		 var checks = document.getElementsByName("power");
		 var power = "";
		 for(var i in checks){
		 	if(checks[i].checked){
		 		power += checks[i].value+",";
		 	}
		 }
		 $("#val3").val(power);
		 
		 var checks = document.getElementsByName("operate");
		 var action = "";
		 for(var i in checks){
		 	if(checks[i].checked){
		 		action += checks[i].value+",";
		 	}
		 }
		 
		 var orgid = $("#orgId").val();
		 if(orgid == "-1,"){
			 alert("请选择所属机构");
			 return false;
		 }
		 $("#val4").val(action);
		var msg = "您真的确定要保存修改吗？\n\n请确认！";
		if (confirm(msg) == true) {
			return true;
		} else {
			return false;
		}
	}
	$(function() {
		$("#btn4").attr("class", "btn btn-sm");
	});
</script>
<style type="text/css">
#div1 {
	height: 452px;
}
</style>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body onload="text();fun3();fun2();fun1();hidden();"
	background="/img/body-bg.png">
	<div style="text-align: left;" class="templatemo-content-wrapper">
		<c:forEach items="${kzlist}" var="kz">
			<c:forEach items="${alloperate_id}" var="cz">
				<c:if test="${kz.operate_id == cz}">
					<input style="width: 150px;" type="button"
						value="${kz.operate_name}" id="btn${kz.operate_id}"
						name="btn${kz.operate_id}"
						onclick="window.location.href='${kz.operate_url}'" />
  &nbsp;&nbsp;
  </c:if>
			</c:forEach>
		</c:forEach>
		<hr />
	</div>

	<div id="div1">
		<input type="hidden" id="dpid" value="${user_org.orgId}" />
		<form action="/updatePower.do" method="post" onsubmit="return p_del()">
			<table id="table1" align="center"
				style="text-align: center; width: 30%" border="1" cellspacing="1"
				cellpadding="1">
				<tr>
					<td>用户ID</td>
					<td>用户姓名</td>
				</tr>
				<c:forEach items="${alist}" var="a">
					<tr>
						<td>${a.user_id }</td>
						<input type="hidden" value="${a.user_id }" id="user_id"
							name="user_id" />
						<td>${a.user_name }<input type="hidden" id="hid1"
							value="${a.user_id}" /></td>
					</tr>
				</c:forEach>
			</table>
			<hr />
			<table>
				<tr>
				<td>
					<span style="color: red">选择所属机构：</span>
				</td>
				</tr>
				<tr>
				<td>
				<c:forEach items="${olist}" var="o">
					&nbsp;<input style="width: 20px; height: 20px;" type="checkbox" name="org" value="${o.orgId}">${o.orgName}&nbsp;&nbsp;
				</c:forEach>
				</td>
				</tr>
			</table>
			<table id="table2" width="100%" align="center"
				style="text-align: left; margin-top: 10px;" border="1"
				cellspacing="1" cellpadding="1">
				<tr style="color: red">
					<td style="text-align: center;">进入页面的权限</td>
					<td style="text-align: center;">进入页面后能够进行的操作</td>
				</tr>
				<c:if test="${beixuanadmin == 2}">
					<c:forEach items="${plist}" var="p">
						<tr id="tr${p.power_id}">
				<td>
<input type="checkbox" style="width: 20px; height: 20px;" name="power" value="${p.power_id}" id="check_${p.power_id}"  onchange="getpower(this);"/>${p.power_name}</td>
				<td><c:forEach items="${polist}" var="po">
				<c:if test="${po.power_id == p.power_id}">
<input type="checkbox" style="width: 20px; height: 20px;" name="operate" value="${po.operate_id}" data_id="${po.power_id}" id="ope_${po.power_id}_${po.operate_id}" onchange="getoperate(this);" />${po.operate_name}
				</c:if>
								</c:forEach></td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${beixuanadmin == 3}">
					<c:forEach items="${jigouplist}" var="p">
						<tr id="tr${p.power_id}">
							<td>
<input type="checkbox" style="width: 20px; height: 20px;" name="power" value="${p.power_id}" id="check_${p.power_id}"  onchange="getpower(this);"/>${p.power_name}</td>
							<td>
							<c:forEach items="${polist}" var="po">
							<c:if test="${po.power_id == p.power_id}">
<input type="checkbox" style="width: 20px; height: 20px;" name="operate" value="${po.operate_id}" data_id="${po.power_id}" id="ope_${po.power_id}_${po.operate_id}"  onchange="getoperate(this);" />${po.operate_name}
			</c:if>
								</c:forEach></td>
						</tr>
					</c:forEach>
				</c:if>
				<tr>
					<td colspan="2" style="text-align: center; color: red;">如进入页面权限未勾选，之后操作勾选无效</td>
				</tr>
			</table>
			<div>

				<div id="divhide">
					<input type="hidden" id="val1" value="${aplist}">
					<input type="hidden" id="val2" value="${aolist}">
					<p id="p1">${aplist}</p>
					<p id="p2">${aolist}</p>
					<input type="hidden" id="val3" name="allpower_id" />
					<input type="hidden" id="val4" name="alloperate_id" />
					<input type="hidden" id="orgId" name="orgId" />
					<input type="hidden" id="hid2" name="user_id" value="${a.user_id }" />
				</div>
				<br />
				<hr />
				<br />
				<div>
					<table align="center">
						<tr>
							<td style="text-align: center;">
							<input type="submit" style="width: 100px; height: 25px;" class="btn bg-warning" value="提交修改">
							<a style="width: 100px; height: 25px;" class="btn bg-warning" href="javascript:history.back(-1);">返回</a>
							</td>
						</tr>
					</table>
				</div>
		</form>
	</div>
	</div>
</body>
</html>