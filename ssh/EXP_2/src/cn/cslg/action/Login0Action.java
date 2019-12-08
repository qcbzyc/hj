package cn.cslg.action;

import cn.cslg.dao.UserDao;
import cn.cslg.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Login0Action extends ActionSupport implements ServletRequestAware {
	@Autowired
	private UserDao userDao;

	private User user;

	private HttpServletRequest request;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void setServletRequest(HttpServletRequest httpServletRequest) {
		this.request = httpServletRequest;
	}

	public String excute()
	{
		System.out.println(user.toString());
		User currentUser=userDao.login(user);
		if(currentUser!=null){
			HttpSession session = request.getSession();
			session.setAttribute("userName", request.getParameter("user.userName"));
			session.setAttribute("password", request.getParameter("user.password"));
			return SUCCESS;
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("userName", request.getParameter("user.userName"));
			session.setAttribute("password", request.getParameter("user.password"));
			session.setAttribute("login_msg", "用户名或密码错误！");
			return ERROR;
		}
	}

}
