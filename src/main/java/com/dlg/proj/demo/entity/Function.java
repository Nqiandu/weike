package com.dlg.proj.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@ToString
public class Function implements Serializable {
    private Integer functionId;

    private Integer functionPid;

    private String functionName;

    private String functionUrl;

    private static final long serialVersionUID = 1L;
    private List<Function> list;



}