package com.dlg.proj.demo.controller;

import com.dlg.proj.demo.entity.Account;
import com.dlg.proj.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowCredentials = "true")
public class LoginController {
@Autowired
    LoginService loginService;
@RequestMapping("hlogin")
    public int login(Account account){
        Account login = loginService.login(account);
        if (login!=null){
            return 1;
        }
        return 0;
    }
}
