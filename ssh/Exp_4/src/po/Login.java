package po;

import java.io.Serializable;

public class Login implements Serializable{
    private Integer id;
    private String loginname;//登录帐号
    private String loginpwd;//登录密码
    private Company company;//关联关系需要在Login类关联另外一个类Company
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLoginname() {
        return loginname;
    }
    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }
    public String getLoginpwd() {
        return loginpwd;
    }
    public void setLoginpwd(String loginpwd) {
        this.loginpwd = loginpwd;
    }
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
}
