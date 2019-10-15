<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/15
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:useBean id="stu" class="cn.cslg.Student"/>
    <%--通过<c:set>标签给javaBean对象的age属性设值--%>
    <c:set value="16" target="${stu}" property="age"/>
    <%--输出javaBean对象的属性值--%>
    年龄:<c:out value="${stu.age}"/>
</body>
</html>
