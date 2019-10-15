<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/15
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--定义一个Color对象--%>

<jsp:useBean id="c" class="cn.cslg.Color"/>

<%--为Color对象设置属性--%>

<c:set value="blue" target="${c}" property="color"/>

<%--获取Color对象的属性值,并根据不同的属性值显示不同的颜色--%>

<c:out value="${c.color}"></c:out>

<c:choose>

<c:when test="${c.color eq 'red'}">

    <font color=red face="华文行楷">你选择的颜色是:<c:out value="${c.color}"/></font>

</c:when>

<c:when test="${c.color eq 'blue'}">

    <font color=blue face="华文行楷">你选择的颜色是:<c:out value="${c.color}"/></font>

</c:when>

<c:otherwise>

<font color=green face="华文行楷">你选择的颜色是:<c:out value="${c.color}"/>

    </c:otherwise>

    </c:choose>
</body>
</html>
