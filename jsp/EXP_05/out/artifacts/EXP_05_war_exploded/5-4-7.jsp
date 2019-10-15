<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/15
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--通过一个分割符将字符串划分为数组,并遍历出来--%>

<c:forTokens var="ele" items="blue,red,green|yellow|pink,black|white" delims="|">

    <c:out value="${ele}"/>||

</c:forTokens>

<br>

<%--通过多个分割符将字符串划分问数组,并遍历出来--%>

<c:forTokens var="ele" items="blue,red!green|yellow;pink;black|white" delims="|;,!">

    <c:out value="${ele}"/>||

</c:forTokens>
</body>
</html>
