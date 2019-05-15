<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	<title>IMS Main Page</title>
	
	<!-- Bootstrap -->
	<link href="../lib/bootstrap-3.3.7-dist/css/bootstrap.min.css"
		rel="stylesheet">
	<link href="../assets/css/mainpage.css" rel="stylesheet">

</head>
<%
	String nickname = (String) session.getAttribute("loginUser");//获取session中的用户昵称
%>
<body class="container-fluid">
	<div class="page-head">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<!--IMS: Inventory Management System -->
					<a class="navbar-brand" href="#">IMS</a>
				</div>
				<div>
					<ul class="nav navbar-nav">
						<li class="active"><a href="../devicestorage/storagePaginate">库存查询</a></li>
						<li><a href="#">设备出库</a></li>
						<li><a href="#">设备调配</a></li>
						<li><a href="#">设备入库</a></li>
						<li role="presentation" class="dropdown"><a
							class="dropdown-toggle" data-toggle="dropdown" href="#"
							role="button" aria-haspopup="true" aria-expanded="false">
								系统管理 <span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="#">修改密码</a></li>
								<li><a href="#">权限管理</a></li>
								<li><a href="#">角色管理</a></li>
							</ul></li>
					</ul>
				</div>
				<div class="nav-a">
					<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
					&nbsp;&nbsp;&nbsp;&nbsp; <b class="nav-username">
					<%=nickname%></b>
				</div>
			</div>
		</nav>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">设备查询条件</div>
		<div class="panel-body">
			<label for="device-name">设备名称</label> 
			<input type="text" id="device-name">
			<button type="button" class="btn btn-default">
				<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
				查询
			</button>
		</div>
	</div>
	
	<table class="table table-bordered">
		<tr>
			<th>序号</th>
			<th>设备名称</th>
			<th>设备品牌</th>
			<th>设备型号</th>
			<th>设备数量</th>
			<th>设备地点</th>
			<th>备注</th>
			<th>修改操作</th>
		</tr>
		<tr>
			<td>1</td>
			<td>U盘</td>
			<td>闪迪</td>
			<td>16G</td>
			<td>8</td>
			<td>02189库房</td>
			<td></td>
			<td>
				<button type="button" class="btn btn-default">
					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
					修改
				</button>
				<button type="button" class="btn btn-default">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					删除
				</button>
			</td>
		</tr>
	</table>
	
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script src="../lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>