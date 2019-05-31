package com.dlg.proj.demo.mapper;

import com.dlg.proj.demo.entity.Userinfo;

public interface LoginMapper {
    public int register(Userinfo user);

    public Userinfo selectByTel(String phone);
    
}
