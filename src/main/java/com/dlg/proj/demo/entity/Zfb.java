package com.dlg.proj.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Zfb {
    private Integer id;
    private Integer userid;
    private  String zfbNum;
    private Integer payState;
    private Double money;
    private String user_name;
}
