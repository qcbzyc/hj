<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/15
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--将变量定义在Jsp范围内--%>
    <%--value属性的两钟使用方式--%>
    <c:set var="username" value="jack" scope="session"/>
    <c:set var="pwd" scope="session">000</c:set>
    <%--通过el表达式语言输出--%>
    ${sessionScope.username}
    ${sessionScope.pwd}
    <%--通过jstl中<c:out>标签输出--%>
    <c:out value="${sessionScope.username}"/>
</body>
</html>
