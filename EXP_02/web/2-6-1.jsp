<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/19
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 align="center">欢迎注册Web前端编程学习网站</h2>
<div align="center">
    <form action="2-6-2.jsp" method="post">
        <table width="500px" border="1px">
            <tr>
                <td>用户名</td>
                <td><input name="name"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <input type="radio" value="男" name="gender">男&nbsp;&nbsp;
                    <input type="radio" value="女" name="gender">女
                </td>
            </tr>
            <tr>
                <td>爱好</td>
                <td>
                    <input type="checkbox" value="唱歌" name="hobby">唱歌
                    <input type="checkbox" value="跳舞" name="hobby">跳舞
                    <input type="checkbox" value="运动" name="hobby">运动
                    <input type="checkbox" value="阅读" name="hobby">阅读
                </td>
            </tr>
            <tr>
                <td>学历</td>
                <td>
                    <select name="education">
                        <option value="">--请选择--</option>
                        <option value="专科以下">专科以下</option>
                        <option value="专科">专科</option>
                        <option value="本科">本科</option>
                        <option value="硕士">硕士</option>
                        <option value="博士">博士</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>备注说明</td>
                <td>
                    <textarea name="advice"></textarea>
                </td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <input type="submit">&nbsp;&nbsp;
                    <input type="reset">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
