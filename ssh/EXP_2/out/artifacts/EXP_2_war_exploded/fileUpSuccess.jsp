<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/7
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件上传成功</title>
</head>
<body>
	<h3>文件上传成功</h3>
	<hr>
	文件标题：<s:property value="+title"/><br>
	<s:property value="uploadFileName"/><br>
	<img src="<s:property value="'../save/'+uploadFileName"/>">
	<br>
</body>
</html>