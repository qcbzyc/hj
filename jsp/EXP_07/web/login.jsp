<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/30
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
    <form action="${pageContext.request.contextPath}/login" method="post">
        <div class="form-group">
            <label for="userName">用户名：</label>
            <input type="text" value="${userName }" name="userName" class="form-control" id="userName" placeholder="请输入用户名"/>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" value="${password }" name="password" class="form-control" id="password" placeholder="请输入密码"/>
        </div>

        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="登录">
        </div>
    </form>

    <!-- 出错显示的信息框 -->
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" >
            <span>&times;</span>
        </button>
        <strong>${login_msg}</strong>
    </div>

</div>
</body>
</html>
