package com.dzqc.cloud.service;

import com.dzqc.cloud.entity.Empinfo;

import java.util.List;

public interface EmpinfoService {
    /**
     * 根据科室id 查询对应的医生信息
     * @param did
     * @return
     */
    public List<Empinfo> findByDid(Integer did);

    /**
     * 新增科室医生
     */
    void insertEmp(Empinfo empinfo);

}
