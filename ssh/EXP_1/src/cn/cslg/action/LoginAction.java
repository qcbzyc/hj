package cn.cslg.action;

import cn.cslg.dao.UserDao;
import cn.cslg.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class LoginAction extends ActionSupport {

    UserDao userDao=new UserDao();

    User user=new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String excute()
    {
        User currentUser=userDao.login(user);
        if(currentUser!=null){
            return SUCCESS;
        }else{
            ActionContext ac=ActionContext.getContext();
            Map request = (Map)ActionContext.getContext().get("request");
            ac.getSession().put("userName", request.get("user.userName"));
            ac.getSession().put("password", request.get("user.password"));
            ac.getSession().put("login_msg", "用户名或密码错误！");
            return ERROR;
        }
    }

}
