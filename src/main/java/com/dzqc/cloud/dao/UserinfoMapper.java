package com.dzqc.cloud.dao;

import com.dzqc.cloud.entity.Userinfo;

public interface UserinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);

    /**
     * 根据手机号查询用户
     * @param phone
     * @return
     */
    Userinfo selectByPhone(String phone);
}