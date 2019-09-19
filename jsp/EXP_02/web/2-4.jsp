<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/19
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% String id[] = {"010020199601026929", "010020199711126928"}; %>
<table border="1">
    <tr>
        <td>身份证</td>
        <td>生日</td>
    </tr>
    <% for (int i = 0; i < id.length; i++) {%>
    <tr>
        <td><%= id[1] %>
        </td>
        <td><%= id[i].substring(6,10)%>-<%= id[i].substring(10,12)%>-<%= id[i].substring(12,14) %>
        </td>
    </tr>
    <%} %></table>
</body>
</html>
