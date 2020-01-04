package cn.cslg.dao;

import java.math.BigInteger;
import java.util.List;

import cn.cslg.model.PageBean;
import cn.cslg.model.Student;
import cn.cslg.util.HibernateUtil;
import cn.cslg.util.StringUtil;
import org.hibernate.Query;
import org.hibernate.Session;

public class StudentDao {

	public List<Student> studentList(PageBean pageBean, Student student, String bbirthday, String ebirthday)throws Exception{
		List<Student> studentList=null;
		StringBuffer sb=new StringBuffer("from Student s");
		if(StringUtil.isNotEmpty(student.getStuNo())){
			sb.append(" and s.stuNo like '%"+student.getStuNo()+"%'");
		}
		if(StringUtil.isNotEmpty(student.getStuName())){
			sb.append(" and s.stuName like '%"+student.getStuName()+"%'");
		}
		if(StringUtil.isNotEmpty(student.getSex())){
			sb.append(" and s.sex ='"+student.getSex()+"'");
		}
		if(student.getGradeId()!=-1){
			sb.append(" and s.gradeId ='"+student.getGradeId()+"'");
		}
		if(StringUtil.isNotEmpty(bbirthday)){
			sb.append(" and TO_DAYS(s.birthday)>=TO_DAYS('"+bbirthday+"')");
		}
		if(StringUtil.isNotEmpty(ebirthday)){
			sb.append(" and TO_DAYS(s.birthday)<=TO_DAYS('"+ebirthday+"')");
		}
		Session session= HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createQuery(sb.toString().replaceFirst("and", "where"));
		if(pageBean!=null){
			query.setFirstResult(pageBean.getStart());
			query.setMaxResults(pageBean.getRows());
		}
		studentList=(List<Student>)query.list();
		return studentList;
	}

	public int studentCount(Student student,String bbirthday,String ebirthday)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from t_student s,t_grade g where s.gradeId=g.id");
		if(StringUtil.isNotEmpty(student.getStuNo())){
			sb.append(" and s.stuNo like '%"+student.getStuNo()+"%'");
		}
		if(StringUtil.isNotEmpty(student.getStuName())){
			sb.append(" and s.stuName like '%"+student.getStuName()+"%'");
		}
		if(StringUtil.isNotEmpty(student.getSex())){
			sb.append(" and s.sex ='"+student.getSex()+"'");
		}
		if(student.getGradeId()!=-1){
			sb.append(" and s.gradeId ='"+student.getGradeId()+"'");
		}
		if(StringUtil.isNotEmpty(bbirthday)){
			sb.append(" and TO_DAYS(s.birthday)>=TO_DAYS('"+bbirthday+"')");
		}
		if(StringUtil.isNotEmpty(ebirthday)){
			sb.append(" and TO_DAYS(s.birthday)<=TO_DAYS('"+ebirthday+"')");
		}
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createSQLQuery(sb.toString());
		return ((BigInteger)query.uniqueResult()).intValue();
	}

	public int studentDelete(String delIds)throws Exception{
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createSQLQuery("delete from t_student where stuId in("+delIds+")");
		int count=query.executeUpdate();
		session.getTransaction().commit();
		return count;
	}

	public int studentSave(Student student)throws Exception{
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		/**
		 * 当调用merge()对象时，无需考虑session中是否已经包含同样id的实体对象，如果session中没有同样id的实体对象，
		 * hibernate会通过select语句，从数据库中查询出对应对象，如果数据库中没有对应对象，就新建一个。
		 * 同时，完成merge()操作后，会返回数据库中对应的persistent状态对象，而原有的，作为参数传入的实体对象，
		 * 仍然是detatch状态，后续代码对其的修改，无法合并到数据库中。
		 */
		session.merge(student);
		session.getTransaction().commit();
		return 1;
	}


	public boolean getStudentByGradeId(String gradeId)throws Exception{
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query query=session.createSQLQuery("select count(*) from t_student where gradeId=?");
		query.setParameter(0, gradeId);
		if(((BigInteger)query.uniqueResult()).intValue()>0){
			return true;
		}else{
			return false;
		}
	}
}
