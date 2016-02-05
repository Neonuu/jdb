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
<script type="text/javascript" src="/jdb/js/layer/layer.js"></script>


</head>

<body >
  
	<div class="templatemo-content-wrapper">
        <div class="widget-table">
            <div class="widget-content">
                <h3>订单信息</h3>
                <table class="table table-striped table-bordered">
                <tr>
                  <td style="width:100px;"> 客户经理电话： </td><td><span>${map.phone_number}</span></td>
                </tr>
                <tr>
                  <td style="width:100px;"> 订单号：</td><td><span>${map.order_number}</span></td>
                </tr>
                <tr>
                  <td style="width:100px;"> 产品名：</td><td>${map.product}</td>
                </tr>
                <tr>
                 <td style="width:100px;"> 操作者：</td><td>${map.auditer_name}</td>
                </tr>
                <tr>
                 <td style="width:100px;"> 操作时间：</td><td>${map.add_time}</td>
                </tr>
                 <tr>
                 <td style="width:100px;"> 金额：</td><td>${map.money}</td>
                </tr>
              </table><br/>
              
              <c:forEach  items="${hoursing}" var="h">
              <h3>楼盘信息</h3>
              <table class="table table-striped table-bordered">
                <tr>
                  <td style="width:100px;"> 楼盘名称： </td><td><span>${h.housingName}</span></td>
                </tr>
                <tr>
                  <td style="width:100px;"> 房屋地址：</td><td><span>${h.housingAddress}</span></td>
                </tr>
                <tr>
                  <td style="width:100px;"> 房产证号：</td><td>${h.housingFCZ}</td>
                </tr>
                <tr>
                 <td style="width:100px;"> 照片：</td><td><c:forEach  items="${imgh}" var="imgh"><img style="width: 600px;" src="${imgh.img}"/></c:forEach></td>
                </tr>
              </table><br/>
              </c:forEach>
           <!-- 
              <table class="table table-striped table-bordered">
                <tr>
                  <td style="width:100px;"> 楼盘名称： </td><td><span>${map.housingName}</span></td>
                </tr>
                <tr>
                  <td style="width:100px;"> 房屋地址：</td><td><span>${map.housingAddress}</span></td>
                </tr>
                <tr>
                  <td style="width:100px;"> 房产证号：</td><td>${map.housingFCZ}</td>
                </tr>
                <tr>
                 <td style="width:100px;"> 照片：</td><td>${map.housePhoto}</td>
                </tr>
              </table><br/>
             -->   
              
              <c:forEach items="${car}" var="car">
               <h3>车辆信息</h3>
               <table class="table table-striped table-bordered">
                <tr>
                  <td style="width:100px;"> 车品牌： </td><td><span>${car.carbrand}</span></td>
                </tr>
                <tr>
                  <td style="width:100px;"> 车系列：</td><td><span>${car.carxilie}</span></td>
                </tr>
                <tr>
                  <td style="width:100px;"> 车型：</td><td>${car.carModel}</td>
                </tr>
                <tr>
                 <td style="width:100px;"> 车年代：</td><td>${car.carNiandai}</td>
                </tr>
                <tr>
                 <td style="width:100px;"> 车架号：</td><td>${car.carframe}</td>
                </tr>
                <tr>
                 <td style="width:100px;"> 照片：</td><td><c:forEach  items="${imgc}" var="imgc"><img style="width: 600px;" src="${imgc.img}"/></c:forEach></td>
                </tr>
              </table>
              </c:forEach>
             <!--  
               <table class="table table-striped table-bordered">
                <tr>
                  <td style="width:100px;"> 车品牌： </td><td><span>${map.Carbrand}</span></td>
                </tr>
                <tr>
                  <td style="width:100px;"> 车系列：</td><td><span>${map.Carxilie}</span></td>
                </tr>
                <tr>
                  <td style="width:100px;"> 车型：</td><td>${map.CarModel}</td>
                </tr>
                <tr>
                 <td style="width:100px;"> 车年代：</td><td>${map.CarNiandai}</td>
                </tr>
                <tr>
                 <td style="width:100px;"> 车架号：</td><td>${map.Carframe}</td>
                </tr>
                 <tr>
                 <td style="width:100px;"> 照片：</td><td>${map.carPhoto}</td>
                </tr>
              </table>
           -->
            </div>
        </div>
    </div> 
</body>
</html>