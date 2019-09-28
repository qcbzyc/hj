<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/27
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <jsp:useBean id="user" class="com.cslg.bean.User">
  <jsp:setProperty name="user" property="name" value="ZB1018105"></jsp:setProperty>
  </jsp:useBean>

  <p>姓名：<jsp:getProperty name="user" property="name"></jsp:getProperty></p>

  </body>
</html>
