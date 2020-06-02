package com.dzqc.cloud.controller;

import com.dzqc.cloud.service.MedicalrecordService;
import com.dzqc.cloud.common.Message;
import com.dzqc.cloud.common.ResultObject;
import com.dzqc.cloud.entity.Medicalrecord;
import com.dzqc.cloud.entity.Userinfo;
import com.dzqc.cloud.service.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 病例报告控制层
 */
@RestController
public class MedicalrecordController {

    @Autowired
    private MedicalrecordService medicalrecordService;

    @Autowired
    private UserService userService;
    /**
     * 添加电子病历
     * @param medicalrecord
     * @return
     */
    @PostMapping("/medicalrecord/insert")
    public ResultObject insertMedicalRecord(Medicalrecord medicalrecord){

        if (medicalrecord.getPhone() == null){
        	return ResultObject.error("添加病历失败,手机号码不能为空");
        }
        Userinfo userinfo = userService.selectByPhone(medicalrecord.getPhone());
        if (userinfo != null){
        	return ResultObject.error("添加病历失败,手机号码重复，请确认后添加");
        }
        try {
            medicalrecord.setRecordCode(RandomStringUtils.random(11,false,true));
            medicalrecord.setState(1);
            medicalrecord.setCreateTime(new Date());
            medicalrecord.setCreateTime(medicalrecord.getCreateTime());
            this.medicalrecordService.insertMedicalrecord(medicalrecord);
            return ResultObject.success("添加电子病历成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResultObject.error("添加电子病历失败");
        }
    }
    /**
     * 分页查询所有的病历信息
     * @param
     * @param
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/medicalrecord/list")
    public ResultObject list(String username, String seektime,
                             @RequestParam(defaultValue = "1") Integer pageNo,
                             @RequestParam(defaultValue = "5")Integer pageSize){
           try{
               PageInfo<Medicalrecord> pageinfo = medicalrecordService.selectByPage(username,seektime, pageNo, pageSize);
               if(pageinfo.getTotal() == 0){
                   return ResultObject.success("找不到对应的病历信息~");
               }else {
                   return ResultObject.success(pageinfo);
               }
           }catch (Exception e){
               e.printStackTrace();
               return ResultObject.error(Message.SERVER_ERROR);
           }
    }

    /**
     * 查询电子病历详情
     * @param id
     * @return
     */
    @RequestMapping("/medicalrecord/detail")
    public ResultObject detail(Integer id){
        try{
            Medicalrecord medicalrecord = this.medicalrecordService.selectById(id);

            if (medicalrecord == null){
                return ResultObject.success("找不到对应的病历详细信息~");
            }else{
            	return ResultObject.success(medicalrecord );
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultObject.error(Message.SERVER_ERROR);
        }
    }

    /**
     * 批量删除电子病历
     * @param ids
     * @return
     */
    @RequestMapping("/medicalrecord/batchDelete")
    public ResultObject batchDelete(Integer [] ids){
        try {
            this.medicalrecordService.batchDelete(ids);
            return ResultObject.success("删除电子病历成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResultObject.error("删除电子病历失败");
        }
    }

    /**
     * 修改电子病历
     * @return
     */
    @PostMapping("/medicalrecord/update")
    public ResultObject update(Medicalrecord medicalrecord, Userinfo userinfo){
        try {
            userinfo.setId(medicalrecord.getUserId());
            medicalrecord.setUpdateTime(new Date());
            medicalrecord.setUserinfo(userinfo);
            this.medicalrecordService.update(medicalrecord);
            return ResultObject.success("修改电子病历成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResultObject.error("修改电子病历失败");
        }
    }
}
