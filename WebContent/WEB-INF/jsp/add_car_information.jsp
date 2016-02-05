<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>车辆信息</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="/jdb/css/style.css" type="text/css" rel="stylesheet">
        <link href="/jdb/css/font.css" type="text/css" rel="stylesheet">
        <link href="/jdb/css/grid.css" type="text/css" rel="stylesheet">
        <link href="/jdb/css/SeleCar.css" type="text/css" rel="stylesheet">
        <script src="/jdb/js/jquery.min.js" type="text/javascript"></script> 
<script>
function hidden(){
	$("#sub1").hide();
	$("#res1").hide();
	$("#sub2").hide();
	$("#res2").hide();
}
function getFileshow1(){
	document.getElementById("showimg1").innerHTML = '';
	var f = new Array();
	f = document.getElementById("myfiles").files;
	for(var i = 0; i<f.length; i++){
		var fr = new FileReader();
		fr.readAsDataURL(f[i]);
		fr.onload = function (e){
			document.getElementById("showimg1").innerHTML += "<img style='width: 150px;height: 150px;' src='"+this.result+"'></img>";
		}
	}
}
function getFileshow2(){
	document.getElementById("showimg2").innerHTML = '';
	var f = new Array();
	f = document.getElementById("myfiles").files;
	for(var i = 0; i<f.length; i++){
		var fr = new FileReader();
		fr.readAsDataURL(f[i]);
		fr.onload = function (e){
			document.getElementById("showimg2").innerHTML += "<img style='width: 150px;height: 150px;' src='"+this.result+"'></img>";
		}
	}
}
    // 判断select是否为空  
    function checkEmpty() {
    	var flag = true;
    	$(".noempty").each(function(){
            if ($(this).val() == "-1" || $(this).val() == "") {
            	var dataId = $(this).data("id");
	            if(dataId == "carbrand") {
	            	alert("请选择车辆品牌！");
	            	flag = false;
	            	return flag;
		        } else if(dataId == "carxilie"){
		        	alert("请选择车系！");
		        	flag = false;
	            	return flag;
		        } else if(dataId == "carNiandai"){
		        	alert("请选择年份！");
		        	flag = false;
	            	return flag;
		        } else if (dataId == "myfiles") {
	            	alert("请上传图片！");
	            	flag = false;
	            	return flag;
		        } else if(dataId == "carModel"){
		        	alert("请填写车型！");
		        	flag = false;
	            	return flag;
		        } else if(dataId == "carframe"){
		        	alert("请填写车架号！");
		        	flag = false;
	            	return flag;
		        }
		        return flag;
	        }
 		});
    	return flag;
    }
    
        // 是否可以提交表单
    function checkInfo() {
    	if ($.trim($("#tbl1").html()) == "") {
       		alert("请新增车辆信息！");
       		return false;
       	} else {
	       	 if(checkEmpty()) {
	 	        $("#checkSubmit").submit();
	 	    }
       	}
	   
    }
    
        
    function checkEmpty2() {
    	var flag = true;
    	$(".noempty2").each(function(){
    		var dataId = $(this).data("id");
    		if ($(this).val() == "") {
                if(dataId == "housingName"){
		        	alert("请填写楼盘名称！");
		        	flag = false;
	            	return flag;
		        } else if(dataId == "housingAddress"){
		        	alert("请填写房屋地址！");
		        	flag = false;
	            	return flag;
		        } else if (dataId == "myfiles") {
	            	alert("请上传图片！");
	            	flag = false;
	            	return flag;
		        } else if(dataId == "housingFCZ"){
		        	alert("请填写房产证号！");
		        	flag = false;
	            	return flag;
		        } 
		        return flag;
    		}
	        
 		});
    	return flag;
    }
    
        // 是否可以提交表单
    function checkInfo2() {
       	if ($.trim($("#tbl2").html()) == "") {
       		alert("请新增房产信息！");
       		return false;
       	} else {
       		if(checkEmpty2()) {
       	        $("#checkSubmit2").submit();
       	    }
       	}
	    
    }
	
        var count = 0;
        var num = 0;
        var tempNum=0;
        function addByScript() {
          $("#sub1").show();
          $("#res1").show();
          $("#new1").hide();
          $("#new2").hide();
          $("#carColor").hide();
          $("#houseColor").hide();
          var table = document.getElementById("tbl1");
          var newRow = table.insertRow(table.rows.length);
          newRow.id = "row" + count;
          
          var contentCell = newRow.insertCell(-1);
          contentCell.innerHTML =   '<br/><span>&nbsp;<span/><br/>如未找到品牌、车系请<a class="btn btn-sm" href="/newcar.do">点击这里</a><br/><span>&nbsp;<span/><br/><select style="margin-top: 10px;" class="noempty" data-id="carbrand" id="carbrand'+num+'" tag='+num+' name="carbrand'+num+'">'+
          							'<option value="-1">请选择车辆品牌</option>'+'<c:forEach items="${brand}" var="t">'+
          							'<option value="${t.id}" data-name="${t.bName}">${t.bName}</option>'+
          							'</c:forEach>'+'</select>'+
          							'<select style="margin-top: 10px;" class="noempty" data-id="carxilie" id="carxilie'+num+'" name="carxilie'+num+'">'+'<option value="-1">请选择车系</option>'+'</select>'+
          							'<select style="margin-top: 10px;" class="noempty" data-id="carNiandai" placeholder="年代" id="carNiandai'+num+'"  name="carNiandai'+num+'">'+
          							'<option value="-1">请选择年份</option><% for(int i=1990;i<=2030;i++){%><option value=<%=i%>><%=i%></option><%}%></select>'+
          							'<br/><span>&nbsp;<span/><br/><input style="margin-top: 0px;" type="text" data-id="carModel" placeholder="车型"  class="inputgri noempty" name="carModel'+num+'" id="carModel" />'+
	  			                    '<input style="margin-top: 0px;" type="text" class="noinput noempty" placeholder="VIN/车架号" maxlength="17" data-id="carframe" id="carframe" name="carframe'+num+'"><br/>'+
	        	  					'<br/><span>&nbsp;<span/><br/>上传图片（请整理好图片同时上传）:<input style="margin-top: 0px;" class="noempty" data-id="myfiles"  type="file"  id="myfiles" name="myfiles" onchange="getFileshow1();" multiple/><br/>'+
	        	  					'<div id="showimg1"></div>'+
	        	  					'<br/><span>&nbsp;<span/><br/><textarea maxlength="200" name="cnotear'+num+'" placeholder="请填写备注"  style="width: 1000px;max-width: 1000px;height:50px;max-height: 50px;" cols="" rows="" class="sel" id="cnotear"></textarea><hr>'
          contentCell = newRow.insertCell(-1);
  								
//          var delBtn = document.createElement("input");
//          delBtn.type = "button";
//          delBtn.className = "button";
//          delBtn.id = "btnDel"+count;
//          delBtn.data_id = "delcar";
//          delBtn.value = "删除";
//          delBtn.onclick = new Function("del(this)");
//          contentCell.appendChild(delBtn);
          $("#hiddenValue").val(num);
          count++;
          
          $('#carbrand'+num).on('change', function(){
        	  tempNum = this.id.substr(this.id.length-1,1);
          	if(this.value==""){
          		return;
          	}
          	$.ajax({
          		url:"chexi.do",
          		type:"post",
          		data:{"id":this.value},
          		dataType:"json",
          		success:function(data){
          			var str="";
          			for(var i=0;i<data.length;i++){
          				str+="<option  value="+data[i].name+">"+data[i].name+"</option>";
          			}
          			
          			$("#carxilie"+tempNum).html(str);
          		}
          	});
          });
          
          num++;
        }
        
        function addByScript2() {
        	$("#sub2").show();
        	$("#res2").show();
        	$("#new1").hide();
        	$("#new2").hide();
            $("#carColor").hide();
            $("#houseColor").hide();
            var table = document.getElementById("tbl2");
            var newRow = table.insertRow(table.rows.length);
            newRow.id = "row" + count;
            
            var contentCell = newRow.insertCell(-1);
            contentCell.innerHTML = '<br/><span>&nbsp;<span/><br/><input type="text" placeholder="请输入楼盘名称" data-id="housingName"  class="inputgri noempty2" id="housingName'+num+'" tag='+num+' name="housingName'+num+'" />'+
									'<input type="text" placeholder="请输入房屋地址" data-id="housingAddress"  class="inputgri noempty2" id="housingAddress'+num+'" name="housingAddress'+num+'" />'+
									'<input type="text" placeholder="请输入房产证号" data-id="housingFCZ"  class="inputgri noempty2" id="housingFCZ'+num+'" name="housingFCZ'+num+'" /><br/>&nbsp;<br/>'+
									'上传图片（请整理好图片同时上传）:<input  class="noempty2" data-id="myfiles" type="file" id="myfiles" name="myfiles" onchange="getFileshow2();" multiple/>'+
									'<div id="showimg2"></div>'+
									'<br/><span>&nbsp;<span/><br/><textarea maxlength="200" name="cnotear'+num+'" placeholder="请填写备注" style="width: 1000px;max-width: 1000px;height:50px;max-height: 50px;" cols="" rows="" class="sel" id="cnotear"></textarea><hr>'
            contentCell = newRow.insertCell(-1);
            
//            var delBtn = document.createElement("input");
//            delBtn.type = "button";
//            delBtn.className = "button";
//            delBtn.id = "btnDel"+count;
//            delBtn.data_id = "delhouse";
//            delBtn.value = "删除";
//            delBtn.onclick = new Function("del(this)");
//            contentCell.appendChild(delBtn);
            $("#hiddenValue2").val(num);       
            count++;
            num++;
          }
        
        function del(obj) {
        	$("#sub1").hide();
        	$("#res1").hide();
        	$("#sub2").hide();
        	$("#res2").hide();
        	if(obj.data_id == 'delcar'){
        		$("#new1").show();
        	}
        	if(obj.data_id == 'delhouse'){
        		$("#new2").show();
        	}
          var row = obj.parentNode.parentNode;
          row.parentNode.removeChild(row);
        }      
        
        function changeDiv(flag) {
        	if (flag == 1) {
        		$('#tbl2').empty();
        		$("#addCar").show();
        		$("#addHouse").hide();
        		document.getElementById("carColor").style.background="#696969";
        		document.getElementById("houseColor").style.background="#cccccc";
        	} else {
        		$('#tbl1').empty();
        		$("#addHouse").show();
        		$("#addCar").hide();
        		document.getElementById("houseColor").style.background="#696969";
        		document.getElementById("carColor").style.background="#cccccc";
        	}
        	
        }
        
        //重置按钮
        function reset1(){
        	
        	$('#carbrand0').val("-1");
        	$('#carxilie0').val("-1");
        	$('#carNiandai0').val("-1");
        	$('#carModel').val("");
        	$('#carframe').val("");
        	$('#myfiles').val("");
        	$('#cnotear').val("");
        	$('#showimg1').hide();
        }
        
        //重置按钮
        function reset2(){
        	
        	$('#housingName0').val("");
        	$('#housingAddress0').val("");
        	$('#housingFCZ0').val("");
        	$('#myfiles').val("");
        	$('#cnotear').val("");
        	$('#showimg2').hide();
        }
	
	
</script>
</head>
<body onload="hidden();">
<div style="height: 100%;">
                    <p>
						 &nbsp; &nbsp; &nbsp; 
						<input type="submit" id="carColor" class="button" 
						value="车辆信息" style="width:160px;height:35px;background-color:#cccccc;" onClick="changeDiv(1);"/>
						<input type="button" id="houseColor"  style="width:160px;height:35px;"value="房屋信息"onclick="changeDiv(0);" />
					</p>
                       <div id="addCar" style="display:block;">
                        <form action="carinfo.do" id="checkSubmit" name="add_car_informationForm" method="post" enctype="multipart/form-data">
                          <input id="ID" name="ID" type="hidden" value="${ID}"/>
                          <input id="user_id" name="user_id" type="hidden" value="${user_id }">
                      <fieldset>
                        <legend>请添加车辆信息</legend>
                    <input type="button" id="new1" class="button" value="新增" onclick="addByScript()"/>
                        <table id="tbl1"></table>
                      </fieldset>
                      <p>
						&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
						&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
						&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
						&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
						 
						<input type="button" class="button"value="提交" id="sub1" style="width:80px;height:35px;background-color:#cccccc;" onClick="checkInfo()"/>
						<input type="button" id="res1" value="重置" class="button" style="width:80px;height:35px;" onclick="reset1();">
						<input type="button"  style="width:80px;height:35px;"value="返回"onclick="location='javascript:history.back(-1);'" />
					  </p>
						<input type="hidden" id="hiddenValue" name="hiddenValue" value="" />
                      </form>
                     </div> 
                  <div id="addHouse" style="display:none;">
		           <div class="widget-content">
					<form action="houseinfo.do" id="checkSubmit2" name="add_house_informationForm" method="post" enctype="multipart/form-data">
					<input name="ID" type="hidden" value="${ID}"/>
					<input id="user_id" name="user_id" type="hidden" value="${user_id }">
					<input name="id" type="hidden" value="id"/>
					  <fieldset>
                       <legend>请添加房产信息</legend>
                         <input type="button" id="new2" class="button" value="新增" onclick="addByScript2()"/>
                           <table id="tbl2"> </table>
                      </fieldset>
        
					    <br></br>
						<p>
						&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
						&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
					 
						<input type="button" class="button" value="提交" id="sub2" style="width:80px;height:35px;background-color:#cccccc;" onClick="checkInfo2()"/>
						<input type="button" id="res2" value="重置" class="button" style="width:80px;height:35px;" onclick="reset2();">
						<input type="button"  style="width:80px;height:35px;"value="返回"onclick="location='javascript:history.back(-1);'" />
						</p>
						<input type="hidden" id="hiddenValue2" name="hiddenValue2" value="" />
					</form>
				</div>
     </div>
</div>
  </body>
</html>
