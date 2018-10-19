package com.bbg.BACKSTAGE.model;

import com.bbg.BACKSTAGE.common.Page;
import java.sql.Date;

public class UserInformation extends Page{
    private Integer id;

    private String username;

    private String password;

    private String realname;

    private String phonenumber;

    private String sex;

    private Date brithday;

    private Date joinday;

    private String department;

    private String position;

    private String workstage;

    private Integer authority;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public Date getJoinday() {
        return joinday;
    }

    public void setJoinday(Date joinday) {
        this.joinday = joinday;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getWorkstage() {
        return workstage;
    }

    public void setWorkstage(String workstage) {
        this.workstage = workstage == null ? null : workstage.trim();
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }
}