package cn.cslg.action;

import java.sql.Connection;
import java.util.List;

import cn.cslg.model.Grade;
import cn.cslg.model.Student;
import cn.cslg.util.ResponseUtil;
import cn.cslg.util.StringUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.struts2.ServletActionContext;

import cn.cslg.dao.GradeDao;
import cn.cslg.dao.StudentDao;
import cn.cslg.model.PageBean;
import cn.cslg.util.DateUtil;
import cn.cslg.util.DbUtil;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport {
    private Student student;
    private String s_stuNo;
    private String s_stuName;
    private String s_sex;
    private String s_bbirthday;
    private String s_ebirthday;
    private String s_gradeId;
    private String page;
    private String rows;
    private String delIds;
    private String stuId;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getS_stuNo() {
        return s_stuNo;
    }

    public void setS_stuNo(String s_stuNo) {
        this.s_stuNo = s_stuNo;
    }

    public String getS_stuName() {
        return s_stuName;
    }

    public void setS_stuName(String s_stuName) {
        this.s_stuName = s_stuName;
    }

    public String getS_sex() {
        return s_sex;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }

    public String getS_bbirthday() {
        return s_bbirthday;
    }

    public void setS_bbirthday(String s_bbirthday) {
        this.s_bbirthday = s_bbirthday;
    }

    public String getS_ebirthday() {
        return s_ebirthday;
    }

    public void setS_ebirthday(String s_ebirthday) {
        this.s_ebirthday = s_ebirthday;
    }

    public String getS_gradeId() {
        return s_gradeId;
    }

    public void setS_gradeId(String s_gradeId) {
        this.s_gradeId = s_gradeId;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public String getDelIds() {
        return delIds;
    }

    public void setDelIds(String delIds) {
        this.delIds = delIds;
    }

    public String getStuId() {
        return stuId;
    }
    
    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    DbUtil dbUtil = new DbUtil();
    StudentDao studentDao = new StudentDao();
    GradeDao gradeDao = new GradeDao();

    @Override
    public String execute() throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        student = new Student();
        if (s_stuNo != null) {
            student.setStuNo(s_stuNo);
            student.setStuName(s_stuName);
            student.setSex(s_sex);
            if (StringUtil.isNotEmpty(s_gradeId)) {
                student.setGradeId(Integer.parseInt(s_gradeId));
            }
        }
        try {
            JSONObject result = new JSONObject();
            List<Student> studentList = studentDao.studentList(pageBean, student, s_bbirthday, s_ebirthday);
            JSONArray jsonArray= JSON.parseArray(JSON.toJSONString(studentList));
            System.out.println(jsonArray);
            int total = studentDao.studentCount(student, s_bbirthday, s_ebirthday);
            result.put("rows", jsonArray);
            result.put("total", total);
            ResponseUtil.write(ServletActionContext.getResponse(), result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String delete() throws Exception {
        Connection con = null;
        try {
            JSONObject result = new JSONObject();
            int delNums = studentDao.studentDelete(delIds);
            if (delNums > 0) {
                result.put("success", "true");
                result.put("delNums", delNums);
            } else {
                result.put("errorMsg", "删除失败");
            }
            ResponseUtil.write(ServletActionContext.getResponse(), result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dbUtil.closeCon(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String save() throws Exception {
        if (StringUtil.isNotEmpty(stuId)) {
            student.setStuId(Integer.parseInt(stuId));
        }
        try {
            int saveNums = 0;
            JSONObject result = new JSONObject();
            saveNums = studentDao.studentSave(student);
            if (saveNums > 0) {
                result.put("success", "true");
            } else {
                result.put("success", "true");
                result.put("errorMsg", "保存失败");
            }
            ResponseUtil.write(ServletActionContext.getResponse(), result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
