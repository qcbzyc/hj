<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/27
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="userRegiste" class="com.cslg.bean.UserRegiste">
    <jsp:setProperty name="userRegiste" property="username" value="${param.username}"></jsp:setProperty>
    <jsp:setProperty name="userRegiste" property="password" value="${param.password}"></jsp:setProperty>
    <jsp:setProperty name="userRegiste" property="sex" value="${param.sex}"></jsp:setProperty>
    <jsp:setProperty name="userRegiste" property="hobby" value="${paramValues.hobby}"></jsp:setProperty>
</jsp:useBean>

用户昵称：${userRegiste.username}<br>
密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：${userRegiste.password}<br>
性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：${userRegiste.sex}<br>
爱&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;好：${userRegiste.hobby[0]}&nbsp;${userRegiste.hobby[1]}&nbsp;${userRegiste.hobby[2]}&nbsp;${userRegiste.hobby[3]}

</body>
</html>
