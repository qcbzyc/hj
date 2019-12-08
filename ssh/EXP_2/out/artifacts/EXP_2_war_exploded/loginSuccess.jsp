<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%> 
    <%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="successPage"></s:text></title>
</head>
<body>
	<hr>
	<s:text name="loginName"/>${useName}<br>
	<s:text name="loginPassword"/>${password}
</body>
</html>