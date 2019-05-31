package com.dlg.proj.demo.controller;

import com.dlg.proj.demo.entity.OrderPay;
import com.dlg.proj.demo.entity.Result;
import com.dlg.proj.demo.mapper.OrderPayMapper;
import javafx.scene.control.Alert;
import org.ietf.jgss.Oid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class OrderPayController {
    @Autowired
    private OrderPayMapper orderPayMapper;

    @RequestMapping("getpaystate/{oid}/{uid}")
    public Result getpaystate(@PathVariable("oid") String oid, @PathVariable("uid") String uid){
        System.out.println("oid"+oid+"-----"+"uid"+uid);
        List<OrderPay> getpaystate = orderPayMapper.getpaystate(Integer.parseInt(uid), Integer.parseInt(oid));
        if(getpaystate.size() == 0){
            return new Result(null, "0", null);
        }else {
            Integer paystate = getpaystate.get(0).getPaystate();
            if(paystate == 1){
                return new Result(null, "1", null);
            }else {
                return new Result(null, "0", null);
            }
        }




    }




}
