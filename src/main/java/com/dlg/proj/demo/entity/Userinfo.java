package com.dlg.proj.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Userinfo {
    private int id;
    private String username;
    private String password;
    private String phone;
    private String sex;
}
