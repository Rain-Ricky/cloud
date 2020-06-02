package com.dzqc.cloud.entity;

import java.io.Serializable;

public class Departmentinfo implements Serializable {
    private Integer id;

    private String departmentname;

    private Integer institutionId;

    private static final long serialVersionUID = 1L;

    public Departmentinfo(Integer id, String departmentname, Integer institutionId) {
        this.id = id;
        this.departmentname = departmentname;
        this.institutionId = institutionId;
    }

    public Departmentinfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname == null ? null : departmentname.trim();
    }

    public Integer getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Integer institutionId) {
        this.institutionId = institutionId;
    }
}