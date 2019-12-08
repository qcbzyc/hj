package cn.cslg.dao;

import cn.cslg.model.Employee;
import cn.cslg.until.DbUtil;
import cn.cslg.until.StringUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class EmployeeDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(DbUtil.getDataSource());

    //查 （有参无参共用）
    public List<Employee> employeeList(String search) throws Exception{
        StringBuffer sb=new StringBuffer("select * from employee where 1=1");
        if(StringUtil.isNotEmpty(search)){
            sb.append(" and JOB = "+"'"+search+"'");
        }
        System.out.println(sb);
        return template.query(sb.toString(), new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    //增
    public int employeeAdd(Employee employee) throws Exception{
        String sql = " insert into employee (EMP_NAME,JOB,SALARY,DEPT) values(?,?,?,?) ";
        return template.update(sql,employee.getEmpName(),employee.getJob(),employee.getSalary(),employee.getDept());
    }

    //改
    public int employeeModify(Employee employee) throws Exception{
        String sql = " update employee set EMP_NAME=?,JOB=?,SALARY=?,DEPT=? where EMPID=? ";
        return template.update(sql,employee.getEmpName(),employee.getJob(),employee.getSalary(),employee.getDept(),employee.getEmpID());
    }

    //删
    public int employeeDelete(Integer id) throws Exception{
        String sql=" delete from employee where EMPID=? ";
        return template.update(sql,id);
    }
}
