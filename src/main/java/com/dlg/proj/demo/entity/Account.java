package com.dlg.proj.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.websocket.server.ServerEndpoint;
import java.io.Serializable;
@Getter
@Setter
@ToString
public class Account {
    private Integer countId;

    private String countName;

    private String countPassword;

    private Integer userId;

    private Integer roleId;

    private Integer empId;

}