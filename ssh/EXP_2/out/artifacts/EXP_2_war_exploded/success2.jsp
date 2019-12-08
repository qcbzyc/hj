<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/7
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>校验成功</title>
</head>
<body>
   校验通过，用户信息如下：
   <hr>
   姓名：<s:property value="userName"/><br>
   密码：<s:property value="userPassword"/><br>
   年龄：<s:property value="userAge"/></br>
   电话：<s:property value="userTelphone"/><br>
   邮箱：<s:property value="userEmail"/>
</body>
</html>