package com.dlg.proj.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Company {
    private Integer id;
    private String cusers;
    private String comp_type;
    private String comp_industry;

    private String comp_desc;


    private String comp_email;
    private Integer user_id;
    private String user_name;
    private String user_phone;
}
