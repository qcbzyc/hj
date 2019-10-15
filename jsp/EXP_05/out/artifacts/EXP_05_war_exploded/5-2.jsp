<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/15
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="5-2.jsp">
        <input type="text" name="number">
        <input type="submit">
    </form>
    <%
        int number = 0;
        if(request.getParameter("number")!=null){
            number = Integer.parseInt(request.getParameter("number"));
        }
        for (int i = 1;i <= number;i++){
            for (int j = 1;j <= i;j++){
                out.print(j+"*"+i+"="+i*j+"&nbsp;&nbsp;");
            }
            out.print("<br>");
        }
    %>
</body>
</html>
