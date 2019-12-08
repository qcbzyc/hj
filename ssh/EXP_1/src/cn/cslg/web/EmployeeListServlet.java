package cn.cslg.web;

import cn.cslg.dao.EmployeeDao;
import cn.cslg.until.ResponseUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/employeeList")
public class EmployeeListServlet extends HttpServlet {
    private EmployeeDao employeeDao = new EmployeeDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String search = request.getParameter("search");
        System.out.println(search);
        try{
            JSONObject result=new JSONObject();
            JSONArray jsonArray= JSON.parseArray(JSON.toJSONString(employeeDao.employeeList(search)));
            System.out.println(jsonArray);
            result.put("employees", jsonArray);
            ResponseUtil.write(response,result);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
