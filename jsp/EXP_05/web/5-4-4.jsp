<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/15
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--jsp页面默认是true,EL表达式被忽略--%>

<%@ page isELIgnored="false"%>

<%--定义一个javaBean对象--%>

<jsp:useBean id="stu" class="cn.cslg.Student"/>

<%--通过<c:set>标签给javaBean对象的age属性设值--%>

<c:set value="16" target="${stu}" property="age"/>

<%--输出javaBean对象的属性值--%>

年龄:<c:out value="${stu.age}"/>

<%--当if判断为true时,输出标签体的内容--%>

<c:if test="${stu.age<18}" var="young" scope="session">对不起,未成年,不能访问这个网站...</c:if>

<%--输出if语句的判断结果--%>

判断结果:<c:out value="${sessionScope.young}"/>
</body>
</html>
