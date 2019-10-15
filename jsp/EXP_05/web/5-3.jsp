<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/15
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Map<String,String> map = new HashMap<>();
        map.put("百度","http://www.baidu.com/");
        map.put("雅虎","http://cn.yahoo.com/");
        map.put("谷歌","http://www.google.com/");
        request.setAttribute("map",map);
    %>
    <c:forEach items="${requestScope.map}" var="map" >
        <c:out value="${map.key}"/>
        <c:out value="${map.value}"/>
        <br>
    </c:forEach>
</body>
</html>
