<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/15
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--引入绝对路径的文件--%>

<%--注意:被引入的文件将被解析为html的形式嵌入引用文件--%>

<h1>引入绝对路径的文件</h1>

<c:import url="http://127.0.0.1:8080/EXP_05/5-4-8-1.jsp" var="file" charEncoding="gbk"/>

<blockquote>

<pre>

<c:out value="${file}"></c:out>

</pre>

</blockquote>



<%--引入相对路径的文件--%>

<h1>引入相对路径的文件</h1>

<blockquote>

<pre>

<c:import url="5-4-8-1.jsp" var="f"/>

<c:out value="${f}"></c:out>

</pre>

</blockquote>



<%--传递参数到被引入文件--%>

<h1>传递参数到被引入文件</h1>

<blockquote>

<pre>

<c:import url="5-4-8-1.jsp" var="ff">

    <c:param name="name" value="jack"/>

</c:import>

<c:out value="${ff}"></c:out>

</pre>

</blockquote>
</body>
</html>
