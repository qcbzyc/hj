<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/19
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"%>
<%@ page import="bean.Student" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%   String s[]=new String[]{"学号","姓名","性别","班级","成绩"};
      out.println("<table border='1'>");
      for(int i=0;i<s.length;i++){
          out.println("<th>");
          out.println(s[i]);
          out.println("</th>");
      }
      ArrayList<Student>
              array=new ArrayList<Student>();
      array.add(new Student("001","李白","男","01",723.0));
      array.add(new Student("002","孟浩然","男","02",689.0));
      array.add(new Student("003","杨玉环","女","03",600.0));
      for(Student student:array){
      out.println("<tr>");
      out.println("<td>");
      out.println(student.getNum());
      out.println("</td>");
      out.println("<td>");
      out.println(student.getName());
      out.println("</td>");
      out.println("<td>");
      out.println(student.getSex());
      out.println("</td>");
      out.println("<td>");
      out.println(student.getCla());
      out.println("</td>");
      out.println("<td>");
      out.println(student.getMark());
      out.println("</td>");
      out.println("</tr>");
  }
    out.println("</table>");%>
  </body>
</html>
