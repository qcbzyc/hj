<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2019/12/22
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>登录页面</title>
</head>
<body>
<h2>欢迎登录：</h2>
<div>
  <form action="login" method="post">
    <s:textfield name="username" label="账号"></s:textfield>
    <br>
    <s:password name="password" label="密码" ></s:password>
    <s:submit value="登录"></s:submit>
  </form>
</div>
</body>
</html>
