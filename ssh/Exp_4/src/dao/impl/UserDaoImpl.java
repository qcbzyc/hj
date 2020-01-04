package dao.impl;

import dao.UserDao;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import po.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    //实例化一个hibernateTemplate对象，用于执行持久化操作
    private  HibernateTemplate ht = null;
    //Hibernate持久化操作所ɜ?SessionFactory
    private SessionFactory sessionFactory = null;
    //用于依赖注入的setter方法
    public  void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
    //初始化HibernateTemplate方法
    private HibernateTemplate getHibernateTemplate()
    {
        if (ht == null) {
            ht = new HibernateTemplate(sessionFactory);
        }
        return ht;
    }

    @Override
    public User get(Integer id) {
        //获取对应表中第几条数据，id为主键索ż?
        return getHibernateTemplate().get(User.class, id);
    }

    @Override
    public Integer save(User user) {
        return  (Integer)getHibernateTemplate().save(user);
    }

    @Override
    public List<User> findByName(String name) {
        //根据名称查找匹配的User
        return (List<User>)getHibernateTemplate().find("from User u where u.name = ? ",name);
    }

}
