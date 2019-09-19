<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/19
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>

</head>
<body>
<% String[] colors=new String[]{"green","cyan","black","red","yellow","pink"};
    for(int i=0;i<6;++i)     {  %>
        <hr color=<%=colors[i]%> size="20px"/>
 <%   }   %>
</body>
</html>
