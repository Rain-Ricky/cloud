package com.dzqc.cloud.entity;

import java.io.Serializable;
import java.util.Date;

public class Userinfo implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private Integer roleid;

    private String phone;

    private String validatecode;

    private String cid;

    private Date birthday;

    private String gender;

    private Integer diType;

    private String frontimg;

    private String backimg;

    private String address;

    private String bedno;

    private Integer departmentid;

    private Integer doctorid;

    private Integer nurseid;

    private Integer instatus;

    private Integer state;

    private static final long serialVersionUID = 1L;

    public Userinfo(Integer id, String username, String password, Integer roleid, String phone, String validatecode, String cid, Date birthday, String gender, Integer diType, String frontimg, String backimg, String address, String bedno, Integer departmentid, Integer doctorid, Integer nurseid, Integer instatus, Integer state) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roleid = roleid;
        this.phone = phone;
        this.validatecode = validatecode;
        this.cid = cid;
        this.birthday = birthday;
        this.gender = gender;
        this.diType = diType;
        this.frontimg = frontimg;
        this.backimg = backimg;
        this.address = address;
        this.bedno = bedno;
        this.departmentid = departmentid;
        this.doctorid = doctorid;
        this.nurseid = nurseid;
        this.instatus = instatus;
        this.state = state;
    }

    public Userinfo() {
        super();
    }

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

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getValidatecode() {
        return validatecode;
    }

    public void setValidatecode(String validatecode) {
        this.validatecode = validatecode == null ? null : validatecode.trim();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Integer getDiType() {
        return diType;
    }

    public void setDiType(Integer diType) {
        this.diType = diType;
    }

    public String getFrontimg() {
        return frontimg;
    }

    public void setFrontimg(String frontimg) {
        this.frontimg = frontimg == null ? null : frontimg.trim();
    }

    public String getBackimg() {
        return backimg;
    }

    public void setBackimg(String backimg) {
        this.backimg = backimg == null ? null : backimg.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getBedno() {
        return bedno;
    }

    public void setBedno(String bedno) {
        this.bedno = bedno == null ? null : bedno.trim();
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    public Integer getNurseid() {
        return nurseid;
    }

    public void setNurseid(Integer nurseid) {
        this.nurseid = nurseid;
    }

    public Integer getInstatus() {
        return instatus;
    }

    public void setInstatus(Integer instatus) {
        this.instatus = instatus;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}