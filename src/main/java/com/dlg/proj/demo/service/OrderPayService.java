package com.dlg.proj.demo.service;

import com.dlg.proj.demo.entity.Result;

public interface OrderPayService {
    //添加订单
    public Result addOrder(Integer orderid, Integer days, Double fuwufei, Integer userid);

    //修改接单表状态
    public void editGetOrder(String orderid);

    /**
     * 根据userid插入金额
     *
     * @param orderid
     * @return
     */
    public void insertMoney(String orderid);
}
