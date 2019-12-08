<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/7
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form action="savestrutsform" method="post">
    <s:label value="Action对struts2表单元素进行获取" ></s:label>
    <table border="1">
        <s:checkboxlist label="复选框checkbox"
                        list="{1,2,3,4}"
                        value="1,2" name="ck" />
        <s:textfield label="文本框text" name="text" value="" />
        <s:radio list="{1,2,3,4}" name="radio" label="单选radio(list)"></s:radio>
        <s:radio list="#{'1':'one','2':'two','3':'three','4':'four'}"
                 name="radio" label="单选radio(map)"></s:radio>
        <!-- value中设置默认选中 -->
        <s:select label="单选下拉select" list="{1,2,3,4}" value="1"
                  name="select" />
        <s:select label="多选下拉select" list="#{'1':'one','2':'two'}"
                  value="1" name="multiple" multiple="true" />
        <s:textarea label="文本域textarea" name="textarea" value="" cols="2"
                    rows="3"></s:textarea>
        <s:submit value="保存表单"></s:submit>
    </table>
</s:form>
</body>
</html>
