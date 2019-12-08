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
<title>文件上传</title>
</head>
<body>
	<s:form action="upLoad" enctype="multipart/form-data">
		<s:textfield name="title" label="文件标题"></s:textfield><br>
		<s:file name="upload" label="选择文件"></s:file><br>
		<s:submit value="上传"></s:submit>
	</s:form>
</body>
</html>