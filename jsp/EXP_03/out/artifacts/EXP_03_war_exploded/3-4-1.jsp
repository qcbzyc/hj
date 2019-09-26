<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/26
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    if(application.getAttribute("counter")==null){
        String counter="1";
        application.setAttribute("counter",counter);
    }
    else{
        int count=Integer.valueOf((String)application.getAttribute("counter")).intValue();
        application.setAttribute("counter",++count +"");
    }
%>
<body>
    该网站被访问：<%=application.getAttribute("counter") %>次。
</body>
</html>
