package com.dlg.proj.demo.controller;

import com.dlg.proj.demo.entity.*;
import com.dlg.proj.demo.mapper.AccountMapper;
import com.dlg.proj.demo.mapper.AddressMapper;
import com.dlg.proj.demo.mapper.OrderMapper;
import com.dlg.proj.demo.mapper.UserMapper;
import com.dlg.proj.demo.service.OrderService;
import com.dlg.proj.demo.util.GetOrderTime;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("order")
@CrossOrigin(allowCredentials = "true")
public class OrderController {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderService orderService;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;

    @RequestMapping("add")
    public Result add(Order order) {
        //生成随机数

        //时间戳+随机数
        order.setOrderNumber(GetOrderTime.getOrderIdByTime());
        int i = orderMapper.addOrder(order);
        if (i == 0) {
            return new Result(null, "2", "发布订单失败");
        }
        return new Result(null, "1", "发布订单成功");
    }

    //肖亚娟S
    @RequestMapping("all/{userid}")
    public Result selectallorder(@PathVariable String userid) {
        // System.out.println("全部:"+userid);
        List<Order> list = orderMapper.selectAll(Integer.parseInt(userid));
        if (list.size() == 0) {
            return new Result(null, "2", "无订单");
        }
        return new Result(list, "1", "成功");
    }//肖亚娟E

    @RequestMapping("edit")
    public Result orderEdit(Order order) {
        int i = orderMapper.orderEdit(order);
        if (i == 0) {
            return new Result(null, "2", "修改订单失败");
        }
        return new Result(null, "1", "修改订单成功");
    }

    @RequestMapping("load/{userid}")
    public Result selectOrderLoadByState(@PathVariable("userid") String userid) {
        List<Order> list = orderMapper.selectOrderLoadByState(Integer.parseInt(userid));
        if (list == null) {
            return new Result(null, "2", "无订单");
        } else {
            return new Result(list, "1", "成功");
        }
    }

    //肖亚娟S
    @RequestMapping("end/{userid}")
    public Result selectOrderEndByState(@PathVariable("userid") String userid) {

        List<Order> list = orderMapper.selectOrderEndByState(Integer.parseInt(userid));
        if (list.size() == 0) {
            return new Result(null, "2", "无订单");
        } else {
            return new Result(list, "1", "成功");
        }
    }//肖亚娟E

    //肖亚娟S
    @RequestMapping("pass/{userid}")
    public Result selectOrderPassByState(@PathVariable("userid") String userid) {

        List<Order> list = orderMapper.selectOrderPassByState(Integer.parseInt(userid));

        if (list.size() == 0) {
            return new Result(null, "2", "无订单");
        } else {
            return new Result(list, "1", "成功");
        }
    }//肖亚娟E

    @RequestMapping("ordergo")
    public Result selectg() {
        List<Order> selectgo = orderService.selectgo();
        if (selectgo.size() > 0) {
            return new Result(selectgo, "1", "aaa");
        } else {
            return new Result(null, "2", "aaa");
        }
    }

    @RequestMapping("xiajia/{id}")
    public Result xiajia(@PathVariable("id") int id) {
        int xiajia = orderMapper.xiajia(id);
        if (xiajia > 0) {
            return new Result(null, "1", "下架成功");
        } else {
            return new Result(null, "2", "下架失败");
        }
    }

    @RequestMapping("xiugai/{id}")
    public Result xiugai(@PathVariable("id") int id) {
        Order order = orderService.selectById(id);
        if (order != null) {
            return new Result(order, "1", null);
        }
        return new Result(null, "2", "未查到该订单");
    }

    @RequestMapping("xiugai2")
    public Order xiugai2() {
        Order orderFromSession = EmpUtil.getOrderFromSession();
        return orderFromSession;
    }

    @RequestMapping("list/{currentPage}/{pageSize}")
    public Result shenhe(@RequestBody Order order,
                         @PathVariable("currentPage") int currentPage,
                         @PathVariable("pageSize") int pageSize) {
        RowBounds rowBounds = new RowBounds((currentPage - 1) * pageSize, pageSize);
        List<Order> selectjx = orderService.selectjx(order, rowBounds);
        int countjx = orderService.countjx(order);
        return new Result(selectjx, null, null, countjx);
    }

    @RequestMapping("agr/{orderNumber}")
    public Result agr(@PathVariable("orderNumber") String orderNumebr) {
        int agr = orderMapper.agr(orderNumebr);
        if (agr > 0) {
            return new Result(null, "1", "操作成功");
        }
        return new Result(null, "2", "操作失败");
    }

    @RequestMapping("disagr/{orderNumber}")
    public Result disagr(@PathVariable("orderNumber") String orderNumebr) {
        int agr = orderMapper.disagr(orderNumebr);
        if (agr > 0) {
            return new Result(null, "1", "操作成功");
        }
        return new Result(null, "2", "操作失败");
    }

    @RequestMapping("orderdetail/{oid}/{uid}")
    public Map<String, Object> odetail(@PathVariable("oid") Integer oid, @PathVariable("uid") String uid) {

        User selectbyid = userMapper.selectbyid(Integer.parseInt(uid));
        Order order = orderMapper.selectById(oid);
        String orderAddress = order.getOrderAddress();
        Address address = addressMapper.selectByPrimaryKey(Integer.parseInt(orderAddress));
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date orderStarttime = order.getOrderStarttime();
        String data1 = simpleDateFormat.format(orderStarttime);
        System.out.println(data1);
        Date orderEndtime = order.getOrderEndtime();
        String data2 = simpleDateFormat.format(orderEndtime);
        System.out.println(data2);

        long days = (orderEndtime.getTime() - orderStarttime.getTime()) / (1000 * 60 * 60 * 24) + 1;


        System.out.println(days);
        DecimalFormat orderfu = new DecimalFormat();
        String format = orderfu.format(order.getOrderMoney() * days * 0.04);
        String formatM = orderfu.format(order.getOrderMoney() * days);
        map.put("fuwufei", format);
        map.put("orderid", order.getId());
        map.put("days", days);
        map.put("orname", order.getOrderName());
        map.put("ordermoney", formatM);
        map.put("username", selectbyid.getUser_name());
        map.put("userid", selectbyid.getUser_id());
        map.put("userphone", selectbyid.getUser_phone());
        map.put("addr", address.getAdressName());
        map.put("stime", data1);
        map.put("etime", data2);
        map.put("count", order.getOrderPercount());
        map.put("number", order.getOrderNumber());
        map.put("type", order.getOrderType());
        list.add(map);
        System.out.println(list);
        return map;
    }


    /**
     * 单子详情
     *
     * @param oid
     * @return
     */
    @RequestMapping("detail/{oid}")
    public Order getdetail(@PathVariable("oid") String oid) {
        Order order = orderMapper.selectById(Integer.parseInt(oid));
        System.out.println(order);

        return orderMapper.selectById(Integer.parseInt(oid));
    }

    @RequestMapping("allorder/{currentPage}/{pageSize}")
    public Result list(@RequestBody Order order, @PathVariable("currentPage") int currentPage,
                       @PathVariable("pageSize") int pageSize) {
        RowBounds rowBounds = new RowBounds((currentPage - 1) * pageSize, pageSize);
        List<Order> list = orderMapper.selectAll2(order, rowBounds);

        int count = orderMapper.count(order);

        return new Result(list, "1", null, count);
    }


    @RequestMapping("editCollect")
    public Result edit(Integer order_collect, Integer id) {
        System.out.println(order_collect);
        System.out.println(id);
        if (order_collect == 0) {
            orderMapper.edit0(id);
            return new Result(null, "1", null);
        } else {
            orderMapper.edit1(id);
            return new Result(null, "2", null);
        }
    }
}
