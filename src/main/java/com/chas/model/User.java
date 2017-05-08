package com.chas.model;

/**
 * Created by ShirUshI on 2017/5/8.
 */
public class User {

    //用户名
    private String userName;
    //密码
    private String password;
    //邮箱
    private String email;
    //联系号码
    private String phone;
    //权限
    private int right;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }
}
