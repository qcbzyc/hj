<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/26
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    用户名：<%= request.getParameter("name")%><br>
    密&nbsp;&nbsp;&nbsp;码：<%= request.getParameter("password")%><br>
    使用的协议:<%= request.getProtocol()%><br>
    请求的URI: <%= request.getServletPath()%><br>
    请求方法: <%= request.getMethod()%><br>
    远程地址: <%= request.getRemoteAddr()%>
</body>
</html>
