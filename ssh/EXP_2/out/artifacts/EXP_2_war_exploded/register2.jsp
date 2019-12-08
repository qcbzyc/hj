<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/7
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册页面</title>
</head>
<body>
	<center>
		请输入注册信息：
			<s:form action="register2" method="post">
				<table border="1">
					<tr>
						<td><s:textfield name="userName" label="姓名" size="16"></s:textfield></td>
					</tr>
					<tr>
						<td><s:password name="userPassword" label="密码" size="18"></s:password></td>
					</tr>
					<tr>
						<td><s:password name="ruserPassword" label="再次输入密码" size="18"></s:password></td>
					</tr>
					<tr>
						<td><s:textfield name="userAge" label="年龄" size="16"></s:textfield></td>
					</tr>
					<tr>
						<td><s:textfield name="userTelphone" label="电话" size="16"></s:textfield></td>
					</tr>
					<tr>
						<td><s:textfield name="userEmail" label="邮箱" size="16"></s:textfield></td>
					</tr>
					<tr>
						<td><s:submit value="提交"></s:submit>
					</tr>
				</table>
			</s:form>
	</center>
</body>
</html>