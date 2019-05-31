package com.dlg.proj.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ToString
@Getter
@Setter
public class Order {
    private Integer id;
    private String orderName;
    private String orderType;
    private String orderPercount;
    private String orderSex;
    private String orderMoneytype;
    private Double orderMoney;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date orderStarttime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date orderEndtime;
    private String orderJobdescription;
    private String orderJobspecification;
    private String orderState;
    private String orderIssue;
    private String orderNumber;
    private Integer userid;
    private String orderAddress;
    private int gstate;
    private String orderPnumber;
    private User list;
    private Address add;
    private Integer orderCollect;

    private String orderPhone;

    private String orderUsername;
    private Integer getid;
    private Integer uid;
    private Integer cun;


}
