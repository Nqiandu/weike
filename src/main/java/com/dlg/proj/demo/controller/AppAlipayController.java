package com.dlg.proj.demo.controller;

import com.alipay.api.AlipayApiException;
import com.dlg.proj.demo.entity.Result;
import com.dlg.proj.demo.mapper.OrderPayMapper;
import com.dlg.proj.demo.service.OrderPayService;
import com.dlg.proj.demo.util.AlipayOrder;
import com.dlg.proj.demo.util.PayNotify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Map;

/*
 * 支付*/
@RestController
@CrossOrigin
public class AppAlipayController {
    @Autowired
    OrderPayService orderPayService;
    @Autowired
    OrderPayMapper orderPayMapper;

    @RequestMapping("AliPayOrder/{orderid}/{days}/{fuwufei}/{userid}")
    public Result add(@PathVariable("orderid") Integer orderid, @PathVariable("days") Integer days, @PathVariable("fuwufei") Double fuwufei, @PathVariable("userid") Integer userid) {
        System.out.println(orderid);
        System.out.println(days);

        return orderPayService.addOrder(orderid, days, fuwufei, userid);

    }

    @RequestMapping("alipay/test/{orderid}")
    public String pay(@PathVariable("orderid") String orderid) {
        System.out.println(orderid);
        String s = AlipayOrder.alipayOrder(orderid);
        System.out.println(s);
        return s;
    }

    @RequestMapping("alipay/payNotify")
    public String payNotify(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, AlipayApiException {
        System.out.println(1111);
        Enumeration<String> enu = request.getParameterNames();
        System.out.println(enu);
        while (enu.hasMoreElements()) {
            String s = enu.nextElement();
            System.out.println(s + "------------");
        }
        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

        Map<String, String[]> requestParams = request.getParameterMap();
        boolean notify = PayNotify.payNotify(requestParams);
        if (notify) {
            System.out.println("false");
            return "false";
        } else {
            String orderid = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            System.out.println(orderid);
            orderPayMapper.editpay(orderid);


            orderPayService.insertMoney(orderid);
            System.out.println("大大大大大大大大啊大大");
            orderPayService.editGetOrder(orderid);
            System.out.println("success");
            return "success";
        }
    }
}
