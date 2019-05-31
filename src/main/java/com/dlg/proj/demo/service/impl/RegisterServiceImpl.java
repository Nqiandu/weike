package com.dlg.proj.demo.service.impl;

import com.dlg.proj.demo.entity.Account;
import com.dlg.proj.demo.entity.Userinfo;
import com.dlg.proj.demo.mapper.AccountMapper;
import com.dlg.proj.demo.mapper.LoginMapper;
import com.dlg.proj.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public int register(Userinfo user) {
        int register = loginMapper.register(user);
        if(register > 0){
            String number = user.getPhone();
            Userinfo users = loginMapper.selectByTel(number);

            if(users != null){
                Account account = new Account();
                account.setUserId(users.getId());
                account.setCountPassword(user.getPassword());
                account.setCountName(users.getPhone());
                return accountMapper.insertcount(account);
            }

        }
        return 0;
    }

    @Override
    public int backPassword(Account account) {
        Account account1 = accountMapper.selectByTel(account.getCountName());
        if(account1 != null){
            return accountMapper.backPassword(account);
        }
        return 0;
    }
}
