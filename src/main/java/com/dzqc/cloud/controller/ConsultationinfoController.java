package com.dzqc.cloud.controller;
import com.dzqc.cloud.entity.Consultation;
import com.dzqc.cloud.service.ConsultationService;
import com.dzqc.cloud.common.ResultObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@RestController
public class ConsultationinfoController {

    @Autowired
    private ConsultationService consultationService;
    /**
     * 查询所有病人  使用POST请求
     */
    @RequestMapping("/consultationinfo/patientList")
    public ResultObject patientList(Integer pageNO,Integer pageSize){
        PageInfo<Consultation> pageInfo = consultationService.selectByPage(pageNO, pageSize);
        if (pageInfo.getTotal() == 0){
            return ResultObject.success("找不到对应的病人");
        }
        return ResultObject.success(pageInfo);
    }
    /**
     * 根据id查询指定病人数据GET请求   病人详情【id跟在url后面】
     */
    @GetMapping("/consultationinfo/detail")
    public ResultObject queryPatient(Integer consultationId){
        Consultation consultation = consultationService.selectById(consultationId);
        return ResultObject.success(consultation);
    }
    /**
     * 修改病人数据
     */
    @PutMapping("/consultationinfo/patient")
    public ResultObject updatePatient(Consultation consultation){
        int result = consultationService.updateById(consultation);
        if (result != 1){
            throw new RuntimeException("根据id修改病人失败");
        }
        return ResultObject.success();
    }
    /**
     * 根据id删除病人数据  DELETE删除
     */
    @DeleteMapping("/consultationinfo/patient")
    public ResultObject deletePatientById(@RequestParam Integer consultationId){
        int result = consultationService.deleteById(consultationId);
        if (result != 1){
            throw new RuntimeException("删除单个病人失败！！！");
        }
        return ResultObject.success();
    }
    /**
     * 添加病人
     */
    @PostMapping("/consultationinfo/insert")
    public ResultObject insertPatient(Consultation consultation){
        try {
            consultation.setDel_flag(0);
            consultation.setCreateTime(new Date());
            consultation.setCreateTime(consultation.getCreateTime());
            this.consultationService.insertConsultation(consultation);
            return ResultObject.success("添加病人成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.error("添加病人失败");
        }
    }
    /**
     * 批量删除病人
     */
    @DeleteMapping("/consultationinfo/patients")
    public ResultObject deletePatients(Integer[] consultationIds){
        int result = consultationService.deletePatients(consultationIds);
        if (result != consultationIds.length){
            throw new RuntimeException("批量删除失败！！！");
        }
        return ResultObject.success();
    }
}
