<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>${loginTitle}</title>
	<!-- 1. 导入CSS的全局样式 -->
	<link href="bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<!-- 2. jQuery导入 -->
	<script type="text/javascript" src="pluges/jquery-3.4.1.min.js" charset="UTF-8"></script>
	<!-- 3. 导入bootstrap的js文件 -->
	<script type="text/javascript" src="bootstrap-3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
	<h3 style="text-align: center;">登录</h3>
	<form action="checklogin" method="post">
		<div class="form-group">
			<label for="userName">${username}</label>
			<input type="text" name="user.userName" class="form-control" id="userName" placeholder="请输入用户名"/>
		</div>

		<div class="form-group">
			<label for="password">${userPassword}</label>
			<input type="password" name="user.password" class="form-control" id="password" placeholder="请输入密码"/>
		</div>

		<hr/>
		<div class="form-group" style="text-align: center;">
			<input class="btn btn btn-primary" type="submit" value="登录">
		</div>

	</form>



</div>
</body>
</html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${loginTitle}</title>
</head>
<body>
	<form action="checklogin" method="post">
		<s:textfield name="username" key="loginName" size="20"></s:textfield>
		<s:password name="userPassword" key="loginPassword" size="20"></s:password>
		<s:submit key="loginSubmit"></s:submit>
	</form>
</body>
</html>