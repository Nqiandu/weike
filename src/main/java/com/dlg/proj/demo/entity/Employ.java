package com.dlg.proj.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.Date;
@Getter
@Setter
@ToString
public class Employ {
    private Integer empId;

    private String empName;

    private String empPhone;

    private String empSex;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date empEntrytime;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date empResigntime;

    private String empAddress;

    private String empEmail;


}