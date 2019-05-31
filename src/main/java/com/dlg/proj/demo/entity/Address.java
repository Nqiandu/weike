package com.dlg.proj.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
@Getter
@Setter
@ToString
public class Address implements Serializable {
    private Integer adressId;

    private String adressName;

    private String adressTitle;
}