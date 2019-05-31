package com.dlg.proj.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class User {
    private Integer user_id;
    private String user_name;
    private String user_password;
    private String user_phone;
    private String user_sex;
    private String user_carid;
    private String user_address;
    private Integer getid;
    private Double money;
    private Order list1;
    private Getorder list2;


}
