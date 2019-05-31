package com.dlg.proj.demo.controller;

import com.dlg.proj.demo.entity.Account;
import com.dlg.proj.demo.entity.Result;
import com.dlg.proj.demo.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowCredentials = "true")
public class SetupController {
    @Autowired
    AccountMapper accountMapper;

    @RequestMapping("updatema")
    public Result updatema(String p1, String p2){

        System.out.println(p1);
        Account account = accountMapper.selectByTel("17513252570");
        System.out.println(account);
        String countPassword = account.getCountPassword();
        System.out.println(countPassword);
        if(p1.equals(countPassword)){
            account.setCountPassword(p2);
            System.out.println(account);
            int i = accountMapper.updateByPrimaryKey(account);
            if(i > 0){
                return new Result(null,"200","密码正确",0);
            }

        }
        return new Result(null,"-100","密码错误",0);
    }

    @RequestMapping("updateName")
    public Result updateName(String name){
        System.out.println(name);
        Account account = accountMapper.selectByTel("17513252570");
        System.out.println(account);
        String countName = account.getCountName();
        System.out.println(countName);
        account.setCountName(name);
        int i = accountMapper.updateByPrimaryKey(account);
        if(i > 0){
            return new Result(null,"200","密码正确",0);
        }
        return new Result(null,"-100","密码错误",0);
    }


}
