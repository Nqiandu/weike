package com.dlg.proj.demo.service.impl;

import com.dlg.proj.demo.entity.EmpUtil;
import com.dlg.proj.demo.entity.Order;
import com.dlg.proj.demo.mapper.OrderMapper;
import com.dlg.proj.demo.service.OrderService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderMapper orderMapper;
    @Override
    public List<Order> selectgo() {

        return orderMapper.selectgo();
    }

    @Override
    public Order selectById(int id) {
        Order order = orderMapper.selectById(id);
        EmpUtil.saveOrder(order);
        return  orderMapper.selectById(id);
    }

    @Override
    public List<Order> selectjx(Order order, RowBounds rowBounds) {

        return orderMapper.selectjx(order,rowBounds);
    }

    @Override
    public int countjx(Order order) {
        return orderMapper.countjx(order);
    }
}
