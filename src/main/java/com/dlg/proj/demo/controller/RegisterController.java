package com.dlg.proj.demo.controller;

import com.dlg.proj.demo.entity.Account;
import com.dlg.proj.demo.entity.EmpUtil;
import com.dlg.proj.demo.entity.Result;
import com.dlg.proj.demo.entity.Userinfo;
import com.dlg.proj.demo.mapper.AccountMapper;
import com.dlg.proj.demo.service.RegisterService;
import com.dlg.proj.demo.util.LogUtils;
import com.dlg.proj.demo.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true")
public class RegisterController {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private RegisterService registerService;
    @RequestMapping("loginq")
    public Result login(Account account){
        String s = StringUtil.MD5(account.getCountPassword());
        account.setCountPassword(s);
        System.out.println(account);
        List<Account> accounts = accountMapper.selectByName(account);
        if (accounts.size()>0){
            LogUtils.logInfo(account+"登录成功");
            return new Result(accounts.get(0),"1","登录成功",0);
        }else{
            LogUtils.logError(account+"登录失败");
            return new Result(null,"-1","登陆失败",0);

        }
    }
    @RequestMapping("register")
    public Result register(Userinfo user){
        String s = StringUtil.MD5(user.getPassword());
        user.setPassword(s);
        int reg = registerService.register(user);
            if(reg > 0){
                LogUtils.logInfo("注册成功");
                return new Result(null,"1","注册成功",0);
            }
                LogUtils.logError("注册失败");
        return new Result(null,"-1","注册失败",0);
    }

@RequestMapping("yzzh") //验证账号是否存在
public Result yzzh(String countName){
    Account account = accountMapper.selectByTel(countName);
    if(account != null){
        return new Result(null,"1","账号已存在",0);
    }
    return new Result(null,"-1","账号注册",0);
}

@RequestMapping("backPassword")
public Result backPassword(Account account){
    int i = registerService.backPassword(account);
    if(i > 0){
        return new Result(null,"1","注册成功",0);
    }
    return new Result(null,"-1","注册失败",0);
}

}
