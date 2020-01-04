<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/15
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link  type='text/css' href="css/login/style.css" rel='stylesheet'/>
    <script type="text/javascript" src="jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript" src="js/system/login.js"></script>
</head>
<body>

<section class="login-form-wrap">
    <!--SIGN UP-->
    <h1>学生管理系统</h1>
    <div class="login-form">
        <div class="close"> </div>
        <div class="head-info">
            <label class="lbl-1"> </label>
            <label class="lbl-2"> </label>
            <label class="lbl-3"> </label>
        </div>
        <div class="clear"> </div>
        <div class="avtar">
            <img src="image/login/avtar.png" />
        </div>
        <div style="color: white"></div>
        <form action="login" method="post" id="form">
            <input type="text"  value="${user.userName }" name="user.userName" id="userName"  placeholder="用户名" >
            <input type="password"  value="${user.password }" name="user.password" id="password" placeholder="密码">
            <input type="text" value="${imageCode }" id="captcha" name="imageCode" placeholder="验证码">
            <div>
                <img style=" float:right;" title="点击更换" id="img_captcha" onclick="refreshCaptcha()" src="image.jsp">
            </div>
            <br/>
            <div id="errormsg" style="color: red">${error }</div>

        </form>
        <div class="signin">
            <input id="login" type="button" value="登陆" onclick="submitform()">
        </div>
    </div>
</section>

</body>
</html>
