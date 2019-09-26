<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="3-2-1.jsp" method="post">
        用户名：<input type="text" name="name"><br>
        密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"><br>
        <input type="submit">
    </form>
    <%
        if(request.getParameter("name")!=null&&request.getParameter("name")!=null){
            response.sendRedirect(request.getContextPath()+"/3-2-2.jsp?name="+request.getParameter("name")+"&password="+request.getParameter("password"));
        }
    %>
</body>
</html>
