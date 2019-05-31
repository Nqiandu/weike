package com.dlg.proj.demo.service;

import com.dlg.proj.demo.entity.Order;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface OrderService {
    List<Order> selectgo();
    Order selectById(int id);
    List<Order> selectjx(Order order, RowBounds rowBounds);
    int countjx(Order order);

}
