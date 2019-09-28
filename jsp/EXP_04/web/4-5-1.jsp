<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/27
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script language="JavaScript">
        function check()
        {
            if (document.form.username.value.length == 0)
            {
                alert("请输入用户名！");
                return false;
            }
            if (document.form.password.value.length == 0)
            {
                alert("请输入密码！");
                return false;
            }
            var pwd1=document.getElementById("p1").value;
            var pwd2=document.getElementById("p2").value;
            if (pwd1!=pwd2)
            {
                alert("两次密码不一致！");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <form name="form" action="4-5-2.jsp" method="post" onSubmit="return check()">
        用户昵称：<input type="text" name="username"><br>
        密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" id="p1"><br>
        确认密码：<input type="password" id="p2"><br>
        性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：
            <input type="radio" name="sex" value="男" checked="checked"> 男
            <input type="radio" mame="sex" value="女"> 女<br>
        爱&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;好：
            <input name="hobby" value="体育" type="checkbox" checked="checked"/>体育
            <input name="hobby" value="美术" type="checkbox"/>美术
            <input name="hobby" value="音乐" type="checkbox"/>音乐
            <input name="hobby" value="旅游" type="checkbox"/>旅游<br>
        <td><input type="submit" name="submit" value="提交" ></td>
        <td><input type="reset" name="reset" value="重置"></td>
    </form>
</body>
</html>
