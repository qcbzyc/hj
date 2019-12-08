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

    <script type="text/javascript">
       function validate(){
       var word1= document.getElementById("password").value;
       var word2 = document.getElementById("password0").value;
       if(word1 != word2){
         window.alert("两次输入的密码不一致！");
         return false;
       }
       return true;
       }    
    </script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">注册</h3>
    <form action="register" method="post">
        <div class="form-group">
            <label for="userName">用户名：</label>
            <input type="text" value="${userName }" name="user.userName" class="form-control" id="userName" placeholder="请输入用户名"/>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" value="${password }" name="user.password" class="form-control" id="password" placeholder="请输入密码"/>
        </div>

        <div class="form-group">
            <label for="password0">确认密码：</label>
            <input type="password" value="${password0 }" name="user.password0" class="form-control" id="password0" placeholder="请确认密码"/>
        </div>

        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary"  type="submit" value="注册" onclick="validate()">
        </div>
    </form>

</div>
</body>
</html>
