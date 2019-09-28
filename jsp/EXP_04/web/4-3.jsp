<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/27
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:useBean id="student" class="com.cslg.bean.Student">
    <jsp:setProperty name="student" property="a" value="96.5"></jsp:setProperty>
    <jsp:setProperty name="student" property="b" value="89"></jsp:setProperty>
    <jsp:setProperty name="student" property="c" value="77.5"></jsp:setProperty>
    <jsp:setProperty name="student" property="d" value="86"></jsp:setProperty>
    <jsp:setProperty name="student" property="e" value="94"></jsp:setProperty>
</jsp:useBean>

语文：${student.a}<br>
数学：${student.b}<br>
英语：${student.c}<br>
物理：${student.d}<br>
化学：${student.e}<br>
总分：${(student.a+student.b+student.c+student.d+student.e)}<br>
均分：${(student.a+student.b+student.c+student.d+student.e)/5.0}<br>

</body>
</html>
