package cn.cslg.dao;

import java.math.BigInteger;
import java.util.List;

import cn.cslg.model.Grade;
import cn.cslg.model.PageBean;
import cn.cslg.util.HibernateUtil;
import cn.cslg.util.StringUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class GradeDao {

	public List<Grade> gradeList(PageBean pageBean, Grade grade)throws Exception{
		List<Grade> gradeList=null;
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		StringBuffer sb=new StringBuffer("from Grade g");
		if(grade!=null && StringUtil.isNotEmpty(grade.getGradeName())){
			sb.append(" and g.gradeName like '%"+grade.getGradeName()+"%'");
		}
		Query query=session.createQuery(sb.toString().replaceFirst("and", "where"));
		if(pageBean!=null){
			query.setFirstResult(pageBean.getStart());
			query.setMaxResults(pageBean.getRows());
		}
		gradeList=(List<Grade>)query.list();
		return gradeList;
	}

	public int gradeCount(Grade grade)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_grade");
		if(StringUtil.isNotEmpty(grade.getGradeName())){
			sb.append(" and gradeName like '%"+grade.getGradeName()+"%'");
		}
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		Query query=session.createSQLQuery(sb.toString().replaceFirst("and", "where"));
		return ((BigInteger)query.uniqueResult()).intValue();
	}

	/**
	 *
	 * @param delIds
	 * @return
	 * @throws Exception
	 */
	public int gradeDelete(String delIds)throws Exception{
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createSQLQuery("delete from t_grade where id in("+delIds+")");
		int count=query.executeUpdate();
		session.getTransaction().commit();
		return count;
	}

	public int gradeSave(Grade grade)throws Exception{
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.merge(grade);
		session.getTransaction().commit();
		return 1;
	}

	public Grade getGradeById(int gradeId)throws Exception{
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Grade grade=(Grade) session.get(Grade.class, gradeId);
		session.getTransaction().commit();
		return grade;
	}
}
