package com.dlg.proj.demo.service;

import com.dlg.proj.demo.entity.Account;
import com.dlg.proj.demo.entity.Userinfo;

public interface RegisterService {
    public int register(Userinfo user);

    public int backPassword(Account account);
}
