package com.dzqc.cloud.service.impl;

import com.dzqc.cloud.dao.ConsultationMapper;
import com.dzqc.cloud.entity.Consultation;
import com.dzqc.cloud.service.ConsultationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ConsultationServiceImpl implements ConsultationService {
    @Autowired
    private ConsultationMapper consultationMapper;

    @Override
    public PageInfo<Consultation> selectByPage(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<Consultation> consultations = consultationMapper.selectByAll();
        return new PageInfo<Consultation>(consultations);
    }

    @Override
    public Consultation selectById(Integer consultationId) {
        return consultationMapper.selectByPrimaryKey(consultationId);
    }

    @Override
    public int updateById(Consultation consultation) {
        return consultationMapper.updateByPrimaryKeySelective(consultation);
    }

    @Override
    public int deleteById(Integer consultationId) {
        Consultation consultation = new Consultation();
        consultation.setId(consultationId);
        consultation.setDel_flag(1);
        return consultationMapper.updateByPrimaryKeySelective(consultation);
    }

    @Override
    public int deletePatients(Integer[] consultationIds) {
        int count = 0;
        for (Integer consultationId : consultationIds) {
            int result = deleteById(consultationId);
            if (result != 1){
                throw new RuntimeException("删除失败");
            }
            count++;
        }
        return count;
    }

    @Override
    public void insertConsultation(Consultation consultation) {
        this.consultationMapper.insertSelective(consultation);
    }
}
