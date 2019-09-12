<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/12
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <meta http-equiv="refresh" content="1">
  </head>
  <body>
  <% Date date=new Date();
     int hours=date.getHours();
     int minute=date.getMinutes();
     int second=date.getSeconds();
  %>
  <h1>当前时间:<%=hours%>:<%=minute%>:<%=second%></h1>
  </body>
</html>
