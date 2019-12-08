package cn.cslg.dao;

import cn.cslg.model.Employee;
import cn.cslg.model.User;
import cn.cslg.until.DbUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中User表的类
 */
public class UserDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(DbUtil.getDataSource());

    /**
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return user包含用户全部数据,没有查询到,返回null
     */
    public User login(User loginUser){
        try {
            //1.编写sql
            String sql = "select * from user where username = ? and password = ?";
            //2.调用query方法
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUserName(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            System.out.println("查无此人");//记录日志
            return null;
        }
    }

    //增
    public int userAdd(User user) throws Exception{
        String sql = " insert into user (username,password) values(?,?) ";
        return template.update(sql,user.getUserName(),user.getPassword());
    }
}
