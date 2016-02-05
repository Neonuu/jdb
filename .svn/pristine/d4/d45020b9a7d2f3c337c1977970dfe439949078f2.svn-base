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
                 
                <input  type="hidden" id="id" value="${map.id}"/>
            <div class="widget-content">
              <table class="table table-striped table-bordered">
                <tr>
                  <td> 客户经理电话： </td><td><span>${map.name}</span></td>
                </tr>
                <tr>
                  <td> 订单号：</td><td><span>${map.order_number}</span></td>
                </tr>
                <tr>
                  <td> 客户身份身份：</td><td><span>${map.user_identity}</span></td>
                </tr>
                <tr>
                  <td> 产品名：</td><td><span id="prodect">${map.product}</span></td>
                </tr>
                <tr>
                  <td> 客户名：</td><td><span>${map.true_name}</span></td>
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
                  <td> 放款时间：</td><td><span>${map.add_time}</span></td>
                </tr>
              </table>
            </div>
            <div style="text-align: center;"><br/>
		        <input id="money" type="text" placeholder="放款金额(元)" onkeyup="value=value.replace(/[^\d.]/g,'')" />
    		</div>
            <div style="text-align: center;"><br/>
	          <a id="ok" class="btn bg-warning">返佣</a>
	          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	          <a id="back" class="btn bg-warning">返回</a>
	        </div>
        </div>
    </div> 
</body>
</html>