package com.dzqc.cloud.entity;

import java.io.Serializable;
import java.util.Date;

public class Consultation implements Serializable {
    private Integer id;

    private String username;

    private String gender;

    private String symptom;

    private String drugsused;

    private String demand;

    private String feedback;

    private Integer empId;

    private Date createTime;

    private Date updateTime;

    private Integer delFlag;

    private static final long serialVersionUID = 1L;

    public Integer getDel_flag() {
        return delFlag;
    }

    public void setDel_flag(Integer del_flag) {
        this.delFlag = del_flag;
    }

    public Consultation(Integer id, String username, String gender, String symptom, String drugsused, String demand, String feedback, Integer empId, Date createTime, Date updateTime, Integer del_flag) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.symptom = symptom;
        this.drugsused = drugsused;
        this.demand = demand;
        this.feedback = feedback;
        this.empId = empId;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.delFlag = del_flag;
    }

    public Consultation() {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom == null ? null : symptom.trim();
    }

    public String getDrugsused() {
        return drugsused;
    }

    public void setDrugsused(String drugsused) {
        this.drugsused = drugsused == null ? null : drugsused.trim();
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand == null ? null : demand.trim();
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback == null ? null : feedback.trim();
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}