package com.bbg.BACKSTAGE.model;

import com.bbg.BACKSTAGE.common.Page;

import java.sql.Date;

public class CompanyInformation extends Page{
    private Integer id;

    private String province;

    private String company;

    private String position;

    private String linkman;

    private String phone;

    private String type;

    private String location;

    private Date linkdate;

    private String iswechat;

    private String iscircle;

    private String isattention;

    private String isjoin;

    private String comment;

    private String chargeman;

    public String getChargeman() {
        return chargeman;
    }

    public void setChargeman(String chargeman) {
        this.chargeman = chargeman;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Date getLinkdate() {
        return linkdate;
    }

    public void setLinkdate(Date linkdate) {
        this.linkdate = linkdate;
    }

    public String getIswechat() {
        return iswechat;
    }

    public void setIswechat(String iswechat) {
        this.iswechat = iswechat == null ? null : iswechat.trim();
    }

    public String getIscircle() {
        return iscircle;
    }

    public void setIscircle(String iscircle) {
        this.iscircle = iscircle == null ? null : iscircle.trim();
    }

    public String getIsattention() {
        return isattention;
    }

    public void setIsattention(String isattention) {
        this.isattention = isattention == null ? null : isattention.trim();
    }

    public String getIsjoin() {
        return isjoin;
    }

    public void setIsjoin(String isjoin) {
        this.isjoin = isjoin == null ? null : isjoin.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}