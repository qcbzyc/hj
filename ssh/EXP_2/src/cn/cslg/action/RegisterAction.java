package cn.cslg.action;

import cn.cslg.dao.UserDao;
import cn.cslg.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

    UserDao userDao=new UserDao();

    User user=new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String excute() throws Exception {
        int flag = 0;
        flag = userDao.userAdd(user);
        if(flag == 1){
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

}
