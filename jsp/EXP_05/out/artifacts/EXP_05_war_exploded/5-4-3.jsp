<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/15
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%--捕获异常,并将异常信息存储在var变量中--%>
    <c:catch var="myexp">
      <%
            int i = 0;
            int j = 3 / 0;
      %>
    </c:catch>
    <h1>异常</h1>
    <hr>
    <c:out value="${myexp}"></c:out><%--输出异常--%>
    <hr>
    <h1>异常信息</h1>
    <c:out value="${myexp.message}"/><%--获取异常信息--%>
    <hr>
    <h1>引起原因</h1>
    <c:out value="${myexp.cause}"/><%--获取引起异常的原因--%>
    </body>
</html>
