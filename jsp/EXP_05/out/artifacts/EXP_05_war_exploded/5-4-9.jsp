<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/15
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--将一个url存放到一个变量中,并输出url--%>

<c:url var="myurl" value="5-1.jsp" scope="session">

    <c:param name="name" value="jgl"/>

</c:url>

<c:out value="${myurl}"/>
</body>
</html>
