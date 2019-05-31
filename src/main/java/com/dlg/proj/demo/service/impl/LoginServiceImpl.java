package com.dlg.proj.demo.service.impl;

import com.dlg.proj.demo.entity.Account;
import com.dlg.proj.demo.entity.EmpUtil;
import com.dlg.proj.demo.mapper.AccountMapper;
import com.dlg.proj.demo.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class LoginServiceImpl implements LoginService {
  @Autowired
    AccountMapper accountMapper;

    @Override
    public Account login(Account account) {
        Account login = accountMapper.login(account);
        EmpUtil.saveAcout(login);
/*
        Account acoutFromSession = EmpUtil.getAcoutFromSession();
*/
        return accountMapper.login(account);
    }
}
