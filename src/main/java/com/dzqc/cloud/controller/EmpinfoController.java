package com.dzqc.cloud.controller;

import com.dzqc.cloud.common.ResultObject;
import com.dzqc.cloud.service.EmpinfoService;
import com.dzqc.cloud.common.Message;
import com.dzqc.cloud.entity.Empinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpinfoController {
    @Autowired
    private EmpinfoService empinfoService;
    /**
     * 根据科室查询 该科室的医生
     * @param depid 部门id
     * @return
     */
    @RequestMapping("empinfo/findByDid")
    public ResultObject findByDid(@RequestParam("id") Integer depid){
       try {
    	   List<Empinfo> empinfolist = empinfoService.findByDid(depid);
    	   return ResultObject.success(empinfolist);
       }catch (Exception e){
           return ResultObject.error(Message.SERVER_ERROR);
       }
    }
    /**
     * 新增科室医生
     */
    @RequestMapping("empinfo/insertEmp")
    public ResultObject insertEmp(Empinfo empinfo){
        try {
            empinfoService.insertEmp(empinfo);
            return ResultObject.success("添加医生成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.error("添加医生失败");
        }
    }
}
