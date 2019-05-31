package com.dlg.proj.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class OrderPay {
    private Integer id;
    private String orderid;
    private String orderdress;
    private Date orderstarttime;
    private Date orderendtime;
    private Double orderprice;
    private Integer worktime;
    private String ordername;
    private Integer paystate;
    private Double fuwufei;
    private Integer userid;
    private Integer oid;
}
