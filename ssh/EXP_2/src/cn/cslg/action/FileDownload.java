package cn.cslg.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class FileDownload extends ActionSupport{
	private String path;
	private String getpath;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getGetpath() {
		return getpath;
	}

	public void setGetpath(String getpath) {
		this.getpath = getpath;
	}
   
	public InputStream getInputStream() throws Exception{
		File file = new File(path);
		InputStream is = new FileInputStream(file);
		return  is;
	}
	public String excute()throws Exception{
		return SUCCESS;
	}
}
