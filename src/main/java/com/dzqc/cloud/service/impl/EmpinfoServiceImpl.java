package com.dzqc.cloud.service.impl;

import com.dzqc.cloud.dao.EmpinfoMapper;
import com.dzqc.cloud.entity.Empinfo;
import com.dzqc.cloud.service.EmpinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpinfoServiceImpl implements EmpinfoService {
    @Autowired
    private EmpinfoMapper empinfoMapper;

    @Override
    public List<Empinfo> findByDid(Integer did) {
        return empinfoMapper.selectByDid(did);
    }

    @Override
    public void insertEmp(Empinfo empinfo) {
        empinfoMapper.insert(empinfo);
    }
}
