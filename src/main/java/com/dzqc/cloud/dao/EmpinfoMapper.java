package com.dzqc.cloud.dao;

import com.dzqc.cloud.entity.Empinfo;

import java.util.List;

public interface EmpinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Empinfo record);

    int insertSelective(Empinfo record);

    Empinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Empinfo record);

    int updateByPrimaryKey(Empinfo record);
    /**
     * 根据科室id查询对应的医生
     * @param did
     * @return
     */
    List<Empinfo> selectByDid(Integer did);
}