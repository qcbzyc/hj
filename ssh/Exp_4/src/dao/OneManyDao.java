package dao;

import util.HibernateSessionFactory;
import org.hibernate.*;
import po.*;

public class OneManyDao {
    public void addCustomer(Customer customer) {
        Session session = HibernateSessionFactory.currentSession();
        Transaction ts = null;
        try{
            ts = session.beginTransaction();
            session.save(customer);
            ts.commit();
        }catch(Exception ex){
            ts.rollback();
            System.out.println("添加客户失败!");
            ex.printStackTrace();
        }finally{
            HibernateSessionFactory.closeSession();
        }
    }

    public Customer loadCustomer(Integer id) {
        Session session = HibernateSessionFactory.currentSession();
        Transaction ts = null;
        Customer customer = null;
        try{
            ts = session.beginTransaction();
            customer = (Customer)session.get(Customer.class,id);
            ts.commit();
        }catch(Exception ex){
            ts.rollback();
            System.out.println("获取客户失败！");
            ex.printStackTrace();
        }finally{
            HibernateSessionFactory.closeSession();
        }
        return customer;
    }

//	public void updateCustomer(Customer customer) {
//		Session session = MySessionFactory.currentSession();
//		Transaction ts = null;
//		try{
//			ts = session.beginTransaction();
//			session.update(customer);
//			ts.commit();
//		}catch(Exception ex){
//			ts.rollback();
//			System.out.println("修改客户信息失败！");
//			ex.printStackTrace();
//		}finally{
//			MySessionFactory.closeSession();
//		}
//	}

    public void addOrders(Orders order) {
        Session session = HibernateSessionFactory.currentSession();
        Transaction ts = null;
        try{
            ts = session.beginTransaction();
            session.save(order);
            ts.commit();
        }catch(Exception ex){
            ts.rollback();
            System.out.println("添加订单失败！");
            ex.printStackTrace();
        }finally{
            HibernateSessionFactory.closeSession();
        }
    }

    public Orders loadOrders(Integer id) {
        Session session = HibernateSessionFactory.currentSession();
        Transaction ts = null;
        Orders order = null;
        try{
            ts = session.beginTransaction();
            order = (Orders)session.get(Orders.class,id);
            ts.commit();
        }catch(Exception ex){
            ts.rollback();
            System.out.println("获取订单失败！");
            ex.printStackTrace();
        }finally{
            HibernateSessionFactory.closeSession();
        }
        return order;
    }
//
//	public void updateOrders(Orders order) {
//		Session session = MySessionFactory.currentSession();
//		Transaction ts = null;
//		try{
//			ts = session.beginTransaction();
//			session.update(order);
//			ts.commit();
//		}catch(Exception ex){
//			ts.rollback();
//			System.out.println("更新订单失败！");
//			ex.printStackTrace();
//		}finally{
//			MySessionFactory.closeSession();
//		}
//	}

}
