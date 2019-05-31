package com.dlg.proj.demo.controller;

import com.aliyuncs.exceptions.ClientException;
import com.dlg.proj.demo.entity.Result;
import com.dlg.proj.demo.util.ShortMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/yzm")
public class ShortMessageController {

    @RequestMapping("/getyzm")
    public void service(HttpServletRequest request,String telephone) throws ClientException {
        System.out.println(telephone);
        ShortMessage shortMessage = new ShortMessage();
        String vcode = shortMessage.vcode();//获取验证码内容
        System.out.println(vcode);
        shortMessage.sendSms(vcode,telephone);
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
        StringBuffer randomCode = new StringBuffer();
        randomCode.append(vcode);
        // 将验证码保存到Session中。
        HttpSession session = request.getSession();
        session.setAttribute("code", randomCode.toString());

        String signcodeSession = (String) session.getAttribute("code");
        System.out.println(signcodeSession);
    }

    @RequestMapping("/checkyzm")
    public Result check(HttpServletRequest request, String yzm) {
        System.out.println(yzm);
        HttpSession session = request.getSession();
        String signcodeSession = (String) session.getAttribute("code");
        if (yzm == null) {
            return new Result(null,"-100","前台没有传过来参数！",0);
        }
        if (signcodeSession == null) {
            return new Result(null,"-100","没有取到sesson的值！",0);
        }
        //验证的时候不区分大小写
        if (yzm.equalsIgnoreCase(signcodeSession)) {
            return new Result(null,"200","验证成功！",0);
        }
        return new Result(null,"-100","验证失败！",0);
    }


}
