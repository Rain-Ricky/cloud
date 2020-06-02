package com.dzqc.cloud.service;

import com.dzqc.cloud.entity.Consultation;
import com.github.pagehelper.PageInfo;

/**
 * @author Bob
 * @version 1.0 2020/5/9
 */
public interface ConsultationService {
    /**
     * 分页查询所有的病人
     * @param
     * @param page
     * @param limit
     * @return
     */
    PageInfo<Consultation> selectByPage(Integer page, Integer limit);

    /**
     * 根据id查询单个病人
     * @param consultationId
     * @return
     */
    Consultation selectById(Integer consultationId);

    /**
     * 修改病人
     * @param consultation
     * @return
     */
    int updateById(Consultation consultation);

    /**
     * 根据id删除单个病人
     * @param consultationId
     * @return
     */
    int deleteById(Integer consultationId);

    /**
     * 批量删除病人
     * @param consultationIds
     * @return
     */
    int deletePatients(Integer[] consultationIds);

    /**
     * 添加病人
     * @param consultation
     */
    void insertConsultation(Consultation consultation);
}
