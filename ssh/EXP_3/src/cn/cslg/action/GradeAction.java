package cn.cslg.action;

import java.sql.Connection;
import java.util.List;

import cn.cslg.model.Grade;
import cn.cslg.model.PageBean;
import cn.cslg.util.ResponseUtil;
import cn.cslg.util.StringUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.struts2.ServletActionContext;

import cn.cslg.dao.GradeDao;
import cn.cslg.dao.StudentDao;
import cn.cslg.util.DbUtil;
import com.opensymphony.xwork2.ActionSupport;

public class GradeAction extends ActionSupport{
	private String page;
	private String rows;
	private String s_gradeName="";
	private Grade grade;
	private String delIds;
	private String id;

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


	public Grade getGrade() {
		return grade;
	}


	public void setGrade(Grade grade) {
		this.grade = grade;
	}


	public String getS_gradeName() {
		return s_gradeName;
	}


	public void setS_gradeName(String s_gradeName) {
		this.s_gradeName = s_gradeName;
	}


	public String getDelIds() {
		return delIds;
	}


	public void setDelIds(String delIds) {
		this.delIds = delIds;
	}



	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}



	DbUtil dbUtil=new DbUtil();
	GradeDao gradeDao=new GradeDao();
	StudentDao studentDao=new StudentDao();

	@Override
	public String execute() throws Exception {
		PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
		try{
			if(grade==null){
				grade=new Grade();
			}
			grade.setGradeName(s_gradeName);
			JSONObject result=new JSONObject();
			List<Grade> gradeList=gradeDao.gradeList(pageBean, grade);
			JSONArray jsonArray= JSON.parseArray(JSON.toJSONString(gradeList));
			System.out.println(jsonArray);
			int total=gradeDao.gradeCount(grade);
			result.put("rows", jsonArray);
			result.put("total", total);
			ResponseUtil.write(ServletActionContext.getResponse(), result);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}


	public String delete()throws Exception{
		try{
			JSONObject result=new JSONObject();
			String str[]=delIds.split(",");
			for(int i=0;i<str.length;i++){
				boolean f=studentDao.getStudentByGradeId(str[i]);
				if(f){
					result.put("errorIndex", i);
					result.put("errorMsg", "班级下面有学生，不能删除！");
					ResponseUtil.write(ServletActionContext.getResponse(), result);
					return null;
				}
			}
			int delNums=gradeDao.gradeDelete(delIds);
			if(delNums>0){
				result.put("success", "true");
				result.put("delNums", delNums);
			}else{
				result.put("errorMsg", "删除失败");
			}
			ResponseUtil.write(ServletActionContext.getResponse(), result);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public String save()throws Exception{
		if(StringUtil.isNotEmpty(id)){
			grade.setId(Integer.parseInt(id));
		}
		try{
			int saveNums=0;
			JSONObject result=new JSONObject();
			saveNums=gradeDao.gradeSave(grade);
			if(saveNums>0){
				result.put("success", "true");
			}else{
				result.put("success", "true");
				result.put("errorMsg", "保存失败");
			}
			ResponseUtil.write(ServletActionContext.getResponse(), result);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public String gradeComboList()throws Exception{
		Connection con=null;
		try{
			con=dbUtil.getCon();
			JSONArray jsonArray=new JSONArray();
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("id", "");
			jsonObject.put("gradeName", "请选择...");
			jsonArray.add(jsonObject);
			jsonArray.addAll(gradeDao.gradeList(null,null));
			System.out.println(jsonArray);
			ResponseUtil.write(ServletActionContext.getResponse(), jsonArray);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}