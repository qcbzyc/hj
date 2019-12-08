package cn.cslg.web;

import cn.cslg.dao.UserDao;
import cn.cslg.model.User;
import cn.cslg.until.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

	UserDao userDao=new UserDao();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		request.setAttribute("userName", userName);
		request.setAttribute("password", password);
		if(StringUtil.isEmpty(userName)|| StringUtil.isEmpty(password)){
			request.setAttribute("login_msg", "请输入用户名和密码！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		User user=new User(userName,password);
		try {
			User currentUser=userDao.login(user);
			if(currentUser==null){
				request.setAttribute("login_msg", "用户名或密码错误！");
				// 服务器跳转
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else{
				//将用户登录信息缓存在Session中
				HttpSession session=request.getSession();
				session.setAttribute("currentUser", currentUser);
				// 客户端跳转
				if(currentUser.getFlag()==0) {
					response.sendRedirect("main.jsp");
				}else if(currentUser.getFlag()==1){
					PrintWriter out = response.getWriter();
					out.println("HelloWorld I am Servlet");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}
