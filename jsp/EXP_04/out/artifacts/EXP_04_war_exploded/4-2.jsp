<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/27
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:useBean id="car" class="com.cslg.bean.Car">
    <jsp:setProperty name="car" property="color" value="black"></jsp:setProperty>
    <jsp:setProperty name="car" property="ac" value="true"></jsp:setProperty>
</jsp:useBean>

<p>颜色：<jsp:getProperty name="car" property="color"></jsp:getProperty></p>
<p>空调：<jsp:getProperty name="car" property="ac"></jsp:getProperty></p>

</body>
</html>
