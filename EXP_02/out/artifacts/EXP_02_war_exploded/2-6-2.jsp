<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/19
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>注册成功啦，恭喜！！！</h1>
<%
    request.setCharacterEncoding("UTF-8");
%>
用户名：<%= request.getParameter("name")%><br/>
密码：<%= request.getParameter("password")%><br/>
性别：<%= request.getParameter("gender")%><br/>
<% String [] hobbys=request.getParameterValues("hobby");%>
爱好：<%
    for(int i=0;i<hobbys.length;i++){
        String hobby=hobbys[i];
        out.print(hobby);
%>
&nbsp;&nbsp;
<%
    }
%><br/>
学历：<%= request.getParameter("education")%><br/>
备注说明：<%= request.getParameter("advice")%>
</body>
</html>
