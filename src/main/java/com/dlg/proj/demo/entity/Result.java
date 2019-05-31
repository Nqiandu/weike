package com.dlg.proj.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Result {
    private Object object;
    private String code;
    private String message;
    private int total;
    private Object other;

    public Result(Object object, String code, String message, int total, Object other) {
        this.object = object;
        this.code = code;
        this.message = message;
        this.total = total;
        this.other = other;
    }

    public Result(Object object, String code, String message, int total) {
        this.object = object;
        this.code = code;
        this.message = message;
        this.total = total;
    }

    public Result(Object object, String code, String message) {
        this.object = object;
        this.code = code;
        this.message = message;
    }

    public Result(Object object) {
        this.object = object;
    }

    public Result() {
    }
}
