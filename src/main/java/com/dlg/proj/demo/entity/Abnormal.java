package com.dlg.proj.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@ToString
public class Abnormal {
    private Integer abnorId;

    private String abnorSend;

    private String orderNumber;

    private String orderName;

    private String orderPhone;

    private String userName;

    private String userPhone;

    private String abnorReson;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date abnorTime;

    private Integer abnorState;

    public Abnormal() {
    }

    public Abnormal(String abnorSend, String orderNumber, String orderName, String orderPhone, String userName, String userPhone, String abnorReson, Integer abnorState) {
        this.abnorSend = abnorSend;
        this.orderNumber = orderNumber;
        this.orderName = orderName;
        this.orderPhone = orderPhone;
        this.userName = userName;
        this.userPhone = userPhone;
        this.abnorReson = abnorReson;
        this.abnorState = abnorState;
    }
}