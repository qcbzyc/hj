package cn.cslg.action;

import com.opensymphony.xwork2.ActionSupport;

public class Register0Action extends ActionSupport{
	private String userName;
	private String userPassWord;
	private String ruserPassWord;
	private int userAge;
	private int userTelphone;
	private String userEmail;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassWord() {
		return userPassWord;
	}
	public void setUserPassWord(String userPassWord) {
		this.userPassWord = userPassWord;
	}
	public String getRuserPassWord() {
		return ruserPassWord;
	}
	public void setRuserPassWord(String ruserPassWord) {
		this.ruserPassWord = ruserPassWord;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public int getUserTelphone() {
		return userTelphone;
	}
	public void setUserTelphone(int userTelphone) {
		this.userTelphone = userTelphone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String excute(){
		return SUCCESS;
	}
}
