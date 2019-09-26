<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%double result=0.0;%>
  <h1>我的计算器</h1>
  <hr>
  <form name = "form1" action="3-1.jsp">请输入第一个数：
    <input type="text" name="num1"><br>
    请输入运算方式：
    <select name = "operator">
      <option value=+>+</option>
      <option value=->-</option>
      <option value=*>*</option>
      <option value=/>/</option>
    </select><br>
    请输入第二个数：
    <input type="text" name="num2"><br>
    <input type="submit" value="计算">
    <input type="reset">
  </form>

  <%
      String strNum1 = request.getParameter("num1");
      String strNum2 = request.getParameter("num2");
      String operator = request.getParameter("operator");
      if(strNum1.equals("")|| strNum2.equals("") || operator.equals("")) {
          out.println("不能为空");
      }else if(!strNum1.matches("^[0-9]*$")||!strNum2.matches("^[0-9]*$")){
          out.println("请输入数字");
      }else if(operator.equals("/")&&Integer.parseInt(strNum2)==0){
          out.println("不能除以0");
      }else{
          try{
              double num11 = Double.parseDouble(strNum1);
              double num22 = Double.parseDouble(strNum2);
              if(operator.equals("+")){
                  result = num11 + num22;
              }else if(operator.equals("-")){
                  result = num11 - num22;
              }else if(operator.equals("*")){
                  result = num11 * num22;
              }else if(operator.equals("/")){
                  result = num11/num22;
              }
          }catch(Exception e){
              e.printStackTrace();
          }
      }
  %>

  结果：<input type="text" value="<%=result%>">
  </body>

</html>
