package com.dlg.proj.demo.service.impl;

import com.dlg.proj.demo.entity.Order;
import com.dlg.proj.demo.entity.OrderPay;
import com.dlg.proj.demo.entity.Result;
import com.dlg.proj.demo.mapper.OrderMapper;
import com.dlg.proj.demo.mapper.OrderPayMapper;
import com.dlg.proj.demo.service.OrderPayService;
import com.dlg.proj.demo.util.GetOrderTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderPayServiceImpl implements OrderPayService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderPayMapper orderPayMapper;

    //添加订单并支付
    @Override
    public Result addOrder(Integer orderid, Integer days, Double fuwufei, Integer userid) {
        System.out.println(orderid);
        System.out.println(userid);
        List<OrderPay> selectbyoiduid = orderPayMapper.selectbyoiduid(userid, orderid);
        if (selectbyoiduid.size() == 0) {
            Order order = orderMapper.selectById(orderid);
            //System.out.println(order);
            double price = order.getOrderMoney() * days;
            OrderPay orderPay = new OrderPay();
            orderPay.setOrderid(GetOrderTime.getOrderIdByTime());
            orderPay.setOrderdress(order.getOrderAddress());
            orderPay.setOrdername(order.getOrderName());
            orderPay.setOrderprice(price);
            orderPay.setFuwufei(fuwufei);
            orderPay.setOrderstarttime(order.getOrderStarttime());
            orderPay.setOrderendtime(order.getOrderEndtime());
            orderPay.setWorktime(days);
            orderPay.setUserid(userid);
            orderPay.setOid(orderid);
            orderPayMapper.addorderpay(orderPay);
            System.out.println(orderPay);
            return new Result(orderPay, "200", "");
        } else {
            return new Result(selectbyoiduid, "200", "");
        }

    }


    //修改 接单表中的状态
    @Override
    public void editGetOrder(String orderid) {
        int userid = 0;
        int order_id = 0;
        //  System.out.println(orderid);

        List list = orderPayMapper.selectUidOid(orderid);
        // System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            OrderPay orderPay = (OrderPay) list.get(i);
            //  System.out.println(orderPay);
            userid = orderPay.getUserid();
            order_id = orderPay.getOid();
        }
        // System.out.println( userid);
        // System.out.println(order_id);
        orderPayMapper.editGetOrder(userid, order_id);
    }

    @Override
    public void insertMoney(String orderid) {


        Double price = 0.0;
        int userid = 0;
        List<OrderPay> orderPays = orderPayMapper.selectMoney(orderid);
        userid = orderPays.get(0).getUserid();
        price = orderPays.get(0).getOrderprice();
        orderPayMapper.addUserMoney(userid, price);

    }
}
