package com.dzqc.cloud.controller;

import com.dzqc.cloud.common.Message;
import com.dzqc.cloud.common.ResultObject;
import com.dzqc.cloud.entity.Userinfo;
import com.dzqc.cloud.service.UserService;
import com.dzqc.cloud.util.SendSmsUtil;
import com.dzqc.cloud.util.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserinfoController {
    @Autowired
    private SendSmsUtil sendSmsUtil;
    @Autowired
    private UserService userService;
    /**
     * 根据手机号查询用户信息
     * @return
     */
    @RequestMapping("/user/findByPhone")
    /**
     * RequestMapping 是一个用来处理请求地址映射的注解，可用于类或方法上。
     *  用于类上：表示类中的所有响应请求的方法都是以该地址作为父路径
     *  用于方法上: 提供进一步的细分映射信息
     */
    public ResultObject findByPhone(String phone) {
        try {
            Userinfo userinfo = this.userService.selectByPhone(phone);
            //
            if (userinfo != null) {
                return ResultObject.success(userinfo);
            } else {
                return ResultObject.error("查询的" + phone + "手机号不存在");
            }
        } catch (Exception e) {
            return ResultObject.error(Message.SERVER_ERROR);
        }
    }
    /**
     * 退出
     * @param request
     * @returnd
     */
    @RequestMapping("/shiro/logout")
    public ResultObject logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("userinfo");
        return ResultObject.success("成功注销");
    }

    /**
     * 用户登陆
     * @param phone 手机号
     * @param code 验证码
     * @return
     */
    @PostMapping("/shiro/login")
    public ResultObject login(String phone,String code,HttpServletRequest request){

        HttpSession session = request.getSession();
        //从session中获取验证码
        String sessionCode = (String)session.getAttribute(phone);
        //对验证码进行校验
        if(sessionCode != null && sessionCode.equals(code)){
            Userinfo userinfo = userService.selectByPhone(phone);
            if(userinfo == null){
                return ResultObject.error("号码未注册，请联系管理员");
            }else{
                session.setAttribute("userinfo",userinfo);
                return ResultObject.success(userinfo);
            }
        }else{
            return ResultObject.error("验证码错误或者已经过期");
        }
    }

    /**
     * 发送验证码
     * @param phone 手机号
     * @return
     */
    @RequestMapping(value = "/shiro/getCode",method = RequestMethod.GET)
    public ResultObject sendSms(String phone, HttpServletRequest request){
        Userinfo userinfo=userService.selectByPhone(phone);
        if(userinfo != null) {
            HttpSession session = request.getSession();
            //随机生成验证码
            String numeral = VerificationCode.getNumeral();
            //String information = sendSmsUtil.aliSendSms(phone, numeral);
            //session.setAttribute(phone, numeral);
            session.setAttribute(phone, numeral);
            //验证码过期时间，三分钟
            session.setMaxInactiveInterval(3 * 60);
            /*if (information.equals("ok")) {
                return ResultObject.success(numeral);
            }*/
            if (numeral!=null){
                 return ResultObject.success(numeral);
            }
            return ResultObject.error("手机验证码发送失败");
        }else{
            return ResultObject.error("号码未注册，请联系管理员");
        }
    }
}