package com.dlg.proj.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Advice {
    private Integer adviceId;

    private String adviceType;

    private String adviceContent;

    private Integer userId;


}