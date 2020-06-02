package com.dzqc.cloud.service;

import com.dzqc.cloud.entity.Medicalrecord;
import com.github.pagehelper.PageInfo;

public interface MedicalrecordService {
    /**
     * 添加电子病历
     * @param medicalrecord
     */
    public void insertMedicalrecord(Medicalrecord medicalrecord);

    /**
     * 分页查询所有的电子病历
     * @param
     * @param
     * @param page
     * @param limit
     * @return
     */
    public PageInfo<Medicalrecord> selectByPage(String username, String seekTime, Integer page, Integer limit);

    public Medicalrecord selectById(Integer id);

    /**
     * 批量删除
     * @param ids
     */
    public void batchDelete(Integer[] ids);

    public void update(Medicalrecord medicalrecord);
}
