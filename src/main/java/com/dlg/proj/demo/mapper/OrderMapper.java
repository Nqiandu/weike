package com.dlg.proj.demo.mapper;


import com.dlg.proj.demo.entity.Order;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface OrderMapper {
        public int addOrder(Order order);
        public List<Order> selectAll(Integer userid);
        public List<Order> selectOrderLoadByState(Integer userid);
        public List<Order> selectOrderPassByState(Integer userid);
        public List<Order> selectOrderEndByState(Integer userid);
        List<Order> selectgo();
        int xiajia(int id);
        Order selectById(int id);
        int orderEdit(Order order);
        List<Order> selectjx(Order order, RowBounds rowBounds);
        int countjx(Order order);
        int agr(String orderNumber);
        int disagr(String orderNumber);
        Order selectbyid(int id);
        int guren(Order order);

        List<Order> selectAll2(Order order, RowBounds rowBounds);
        int count(Order order);

        /*我接的零工*/
        List<Order> selectByOrderid(int id);

        int edit0(Integer id);
        int edit1(Integer id);

        /*收藏*/
        List<Order> selectsc(Integer userid);
}
