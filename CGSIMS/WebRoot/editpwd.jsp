<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	<title>IMS Main Page</title>
	
	<!-- Bootstrap -->
	<link href="lib/bootstrap-3.3.7-dist/css/bootstrap.min.css"
		rel="stylesheet">
	<link href="assets/css/mainpage.css" rel="stylesheet">
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
						<li><a href="#">库存查询</a></li>
						<li><a href="#">设备出库</a></li>
						<li><a href="#">设备调配</a></li>
						<li><a href="#">设备入库</a></li>
						<li role="presentation" class="dropdown active"><a
							class="dropdown-toggle" data-toggle="dropdown" href="#"
							role="button" aria-haspopup="true" aria-expanded="false">
								系统管理 <span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="#">修改密码</a></li>
								<li><a href="#">用户管理</a></li>
								<li><a href="#">权限管理</a></li>
								<li><a href="#">角色管理</a></li>
							</ul></li>
					</ul>
				</div>
				<div class="nav-a">
					<span class="glyphicon glyphicon-user glyphicon-sm" aria-hidden="true"></span>
					&nbsp;&nbsp;&nbsp;&nbsp; <b class="nav-username"><%=nickname%></b>
				</div>
			</div>
		</nav>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">密码修改</div>
		<div class="panel-body">
			<form action="index/editPwd" class="form-horizontal" role="form" method="post">
				<div class="form-group">
				    <label for="inputPassword2" class="col-sm-2 control-label">旧密码</label>
				    <div class="col-sm-6">
				      <input type="password" class="form-control" id="inputPassword2" name="inputPassword2" placeholder="Password">
				    </div>
				 </div>
				 <div class="form-group">
				    <label for="inputPassword3" class="col-sm-2 control-label">新密码</label>
				    <div class="col-sm-6">
				      <input type="password" class="form-control" id="inputPassword3" name="inputPassword3" placeholder="Password">
				    </div>
				 </div>
				 <div class="form-group">
				    <label for="inputPassword4" class="col-sm-2 control-label">确认新密码</label>
				    <div class="col-sm-6">
				      <input type="password" class="form-control" id="inputPassword4" name="inputPassword4" placeholder="Password">
				    </div>
				  </div>
				  <div>
				  	<button type="reset" class="btn btn-default" >取消</button>
				  	<button type="submit" class="btn btn-danger" onclick="checkpwd();">修改</button>
				  </div>				  
			</form>
		</div>
	</div>
	
	
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script src="lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script src="assets/js/checkpwd.js"></script>
</body>
</html>