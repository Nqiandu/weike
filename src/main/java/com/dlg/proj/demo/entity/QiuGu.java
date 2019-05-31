package com.dlg.proj.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@ToString
public class QiuGu {
    private Integer getid;
    private String ordername;
    private String username;
    private Integer userid;
    private Integer orderid;
}
