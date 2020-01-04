package cn.cslg.dao;

import java.util.List;

import cn.cslg.model.User;
import cn.cslg.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;


public class UserDao {

	/**
	 *
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(User user) throws Exception{
		User resultUser=null;
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery("from User u where u.userName=? and u.password=?");
		query.setString(0, user.getUserName());
		query.setString(1, user.getPassword());
		List<User> userList=(List<User>)query.list();
		if(userList.size()>0){
			resultUser=userList.get(0);
		}
		return resultUser;
	}
}