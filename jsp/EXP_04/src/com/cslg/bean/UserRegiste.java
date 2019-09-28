package com.cslg.bean;

import java.util.List;

public class UserRegiste {
    private String username;
    private String password;
    private String sex;
    private String[] hobby;

    public UserRegiste() {
    }

    public UserRegiste(String username, String password, String sex, String[] hobby) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.hobby = hobby;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }
}
