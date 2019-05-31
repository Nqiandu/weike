package com.dlg.proj.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
public class RoleFunction {
    private Integer roleId;

    private Integer functionId;
    private Function fun;


}