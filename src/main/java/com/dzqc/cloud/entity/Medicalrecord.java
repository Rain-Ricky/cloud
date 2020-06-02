package com.dzqc.cloud.entity;

import java.io.Serializable;
import java.util.Date;

public class Medicalrecord implements Serializable {
    private Integer id;

    private String recordCode;

    private String phone;

    private Integer departmentId;

    private String seektime;

    private String description;

    private String guomishi;

    private String diagnosis;

    private String prescription;

    private Integer userId;

    private Integer docId;

    private String comment;

    private String remark;

    private Integer state;

    private Date createTime;

    private Date updateTime;
    //诊断类型
    private String diagnostictype;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    // 员工信息表
    private Empinfo empinfo;
    //用户信息表
    private Userinfo userinfo;
    //部门表信息
    private Departmentinfo departmentinfo;

    public void setDepartmentinfo(Departmentinfo departmentinfo){
        this.departmentinfo=departmentinfo;
    }
    public Departmentinfo getDepartmentinfo(){
        return this.departmentinfo;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    public String getDiagnostictype() {
        return diagnostictype;
    }

    public void setDiagnostictype(String diagnostictype) {
        this.diagnostictype = diagnostictype;
    }

    public Empinfo getEmpinfo() {
        return empinfo;
    }

    public void setEmpinfo(Empinfo empinfo) {
        this.empinfo = empinfo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private static final long serialVersionUID = 1L;

    public Medicalrecord(Integer id, String recordCode, String phone, Integer departmentId, String seektime, String description, String guomishi, String diagnosis, String prescription, String comment, String remark) {
        this.id = id;
        this.recordCode = recordCode;
        this.phone = phone;
        this.departmentId = departmentId;
        this.seektime = seektime;
        this.description = description;
        this.guomishi = guomishi;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.comment = comment;
        this.remark = remark;
    }

    public Medicalrecord() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode == null ? null : recordCode.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getSeektime() {
        return seektime;
    }

    public void setSeektime(String seektime) {
        this.seektime = seektime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getGuomishi() {
        return guomishi;
    }

    public void setGuomishi(String guomishi) {
        this.guomishi = guomishi == null ? null : guomishi.trim();
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis == null ? null : diagnosis.trim();
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription == null ? null : prescription.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}