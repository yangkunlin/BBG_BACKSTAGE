package com.bbg.BACKSTAGE.model;

import com.bbg.BACKSTAGE.common.Page;

public class CivilAffairsBureauInformation extends Page{
    private Integer id;

    private String province;

    private String city;

    private String region;

    private String officephone;

    private String veteranphone;

    private String linkman;

    private String telephone;

    private String position;

    private String situation;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getOfficephone() {
        return officephone;
    }

    public void setOfficephone(String officephone) {
        this.officephone = officephone == null ? null : officephone.trim();
    }

    public String getVeteranphone() {
        return veteranphone;
    }

    public void setVeteranphone(String veteranphone) {
        this.veteranphone = veteranphone == null ? null : veteranphone.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation == null ? null : situation.trim();
    }
}