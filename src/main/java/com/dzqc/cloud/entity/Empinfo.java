package com.dzqc.cloud.entity;

import java.io.Serializable;

public class Empinfo implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String birthday;

    private String phone;

    private String address;

    private Integer roleId;

    private Integer depId;

    private Integer titleId;

    private String comment;

    private String headimg;

    private String experience;

    private Integer state;

    private static final long serialVersionUID = 1L;

    public Empinfo(Integer id, String username, String password, String birthday, String phone, String address, Integer roleId, Integer depId, Integer titleId, String comment, String headimg, String experience, Integer state) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.roleId = roleId;
        this.depId = depId;
        this.titleId = titleId;
        this.comment = comment;
        this.headimg = headimg;
        this.experience = experience;
        this.state = state;
    }

    public Empinfo() {
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience == null ? null : experience.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}