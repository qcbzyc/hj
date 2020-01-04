package action;

import com.opensymphony.xwork2.ActionSupport;
import dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import po.User;

import java.util.List;

public class LoginServiceAction extends ActionSupport {
    private String username;
    private String password;
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    UserDao userDao = (UserDao)ctx.getBean("userDao");

    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    public String execute() {
        //查找账号相等的用户?
        List<User> userList = userDao.findByName(username);
        //遍历集合比较用户的密码?
        for (User user : userList) {
            if (user.getPassword().equals(password)) {
                return  SUCCESS;
            }
            else
            {
                return ERROR;
            }
        }
        return  ERROR;
    }

}
