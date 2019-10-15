<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/15
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="post" action="5-1.jsp">
    <table border="${param.boder}px" cellspacing="${param.boder}px" style="background-color: ${param.color}; font-size: ${param.size}px;width:${param.width}px;">
      <tr>
        <td>背景色</td>
        <td><input type="text" name="color"></td>
      </tr>
      <tr>
        <td>字号大小</td>
        <td><input type="text" name="size"></td>
      </tr>
      <tr>
        <td>表格宽度</td>
        <td><input type="text" name="width"></td>
      </tr>
      <tr>
        <td>边框</td>
        <td><input type="text" name="boder"></td>
      </tr>
        <td colspan="2" align="center"><input type="submit"></td>
      </tr>
    </table>
  </form>
  </body>
</html>
