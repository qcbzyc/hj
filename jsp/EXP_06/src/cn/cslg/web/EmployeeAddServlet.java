package cn.cslg.web;

import cn.cslg.dao.EmployeeDao;
import cn.cslg.model.Employee;
import cn.cslg.model.User;
import cn.cslg.until.ResponseUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/employeeAdd")
public class EmployeeAddServlet extends HttpServlet {
    private EmployeeDao employeeDao = new EmployeeDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        Employee employee = (Employee)JSON.parseObject(request.getParameter("employee"),Employee.class);
        System.out.println(employee.toString());
        try{
            int saveNums=0;
            JSONObject result=new JSONObject();
            saveNums=employeeDao.employeeAdd(employee);
            if(saveNums>0) {
                result.put("success", "true");
            }else {
                result.put("success", "true");
                result.put("errorMsg", "保存失败");
            }
            ResponseUtil.write(response, result);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
