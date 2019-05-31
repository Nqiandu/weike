package com.dlg.proj.demo.controller;

import com.dlg.proj.demo.entity.*;
import com.dlg.proj.demo.mapper.GetorderMapper;
import com.dlg.proj.demo.mapper.OrderMapper;
import com.dlg.proj.demo.mapper.UserMapper;
import com.dlg.proj.demo.service.GetorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("get")
public class GetorderController {
    @Autowired
    GetorderMapper getorderMapper;
    @Autowired
    GetorderService getorderService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    OrderMapper orderMapper;
    @RequestMapping("ins/{Idd}/{userId}/{orderId}")
    public Result insert(@PathVariable("Idd") Integer Idd,@PathVariable("userId") String userId,@PathVariable("orderId") String orderId){
        //System.out.println(userId);
        //System.out.println(orderId);
        int i = getorderMapper.selectOrderByUidOid(Integer.parseInt(userId),Integer.parseInt(orderId));
        if(i==0) {
            Getorder getorder = new Getorder();
            getorder.setGetState(0);

            getorder.setOrderId(Idd);
            int aa = Integer.parseInt(userId);

            getorder.setUserId(aa);
            int insert = getorderMapper.insert(getorder);
            if (insert > 0) {
                return new Result(null, "1", "接单成功，请等待雇主同意！");
            } else {
                return new Result(null, "2", "接单失败，请重新接单");
            }
        }else{
            return new Result(null,"3","您已经接过单了");
        }
    }
    @RequestMapping("woget/{userid}")
    public Result getal(@PathVariable("userid") String userid){


      return getorderService.selectbyuserid(Integer.parseInt(userid));
    }
    @RequestMapping("qiugu/{userid}")
    public Result qiugu(@PathVariable("userid") String userid){
        List<Getorder> qiugu = getorderMapper.qiugu();

        List<QiuGu> list=new ArrayList<>();
        if (qiugu.size()>0){
            for (int i = 0; i <qiugu.size(); i++) {
                Getorder getorder = qiugu.get(i);
                Order order = orderMapper.selectById(getorder.getOrderId());
               if (order.getUserid()==Integer.parseInt(userid)){
                   QiuGu qiuGu=new QiuGu();
                   String orderName = order.getOrderName();
                   qiuGu.setOrdername(orderName);
                   qiuGu.setOrderid(order.getId());
                   Integer userId = getorder.getUserId();
                   User selectbyid = userMapper.selectbyid(userId);

                   qiuGu.setUserid(userId);
                   qiuGu.setUsername(selectbyid.getUser_name());
                   qiuGu.setGetid(getorder.getGetId());
                   list.add(qiuGu);
               }

            }

        }
        if (list.size()>0) {
            return new Result(list,"1",null);
        }else{
            return new Result(null,"2",null);
        }
    }

@RequestMapping("wgdr/{userid}")
public Result guren(@PathVariable("userid") String userid){

        return  getorderService.wgdr(userid);
}

    @RequestMapping("agree/{getid}/{orderid}")
    public Result getAgree(@PathVariable("getid") Integer getid,@PathVariable("orderid") int orderid){
        System.out.println(getid);
        System.out.println(orderid);
        Getorder getorder=new Getorder();
        getorder.setGetId(getid);
        getorder.setGetState(1);//同意为1
        int i = getorderMapper.updateByPrimaryKeySelective(getorder);
        if (i>0){
            Order order = orderMapper.selectById(orderid);
            String orderPnumber = order.getOrderPnumber();
            int newnumber=Integer.parseInt(orderPnumber)-1;
            order.setOrderPnumber(String.valueOf(newnumber));
            orderMapper.guren(order);
            return new Result(null,"1","已同意");
        }else{
            return new Result(null,"2","系统出错，请稍后再试。");
        }
    }

    @RequestMapping("disagree/{getid}")
    public Result getDisagree(@PathVariable("getid") Integer getid){
        Getorder getorder=new Getorder();
        getorder.setGetId(getid);
        getorder.setGetState(3);//不同意为2
        int i = getorderMapper.updateByPrimaryKeySelective(getorder);
        if (i>0){
            return new Result(null,"1","已驳回");
        }else{
            return new Result(null,"2","系统出错，请稍后再试。");
        }
    }


    /*我接的零工*/
    @RequestMapping("selectByUserid/{userId}")
    public Result selectByUserid(@PathVariable("userId") String userId){
        System.out.println(userId);
        List<Order> list2=new ArrayList();
        List<Integer> list = getorderMapper.selectByUserid(Integer.parseInt(userId));

        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            List<Order> orders = orderMapper.selectByOrderid(list.get(i));
            System.out.println(orders);
            if (orders.size()>0){
                list2.add(orders.get(0));
            }
            System.out.println(orders);

        }
        System.out.println(list2);
        return new Result(list2,"1",null);
    }

    @RequestMapping("selectByState1/{userId}")
    public Result selectByState1(@PathVariable("userId") String userId){
        System.out.println(userId);
        List<Order> list2=new ArrayList();
        List<Integer> list = getorderMapper.selectByState1(Integer.parseInt(userId)); //获取我接的所有订单
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            List<Order> orders = orderMapper.selectByOrderid(list.get(i));
            System.out.println(orders);
            if (orders.size()>0){
                list2.add(orders.get(0));
            }
            System.out.println(orders);
        }
        System.out.println(list2);
        return new Result(list2,"1",null);
    }

    @RequestMapping("selectByState2/{userId}")
    public Result selectByState2(@PathVariable("userId") String userId){
        System.out.println(userId);
        List<Order> list2=new ArrayList();
        List<Integer> list = getorderMapper.selectByState2(Integer.parseInt(userId)); //获取我接的所有订单
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            List<Order> orders = orderMapper.selectByOrderid(list.get(i));
            System.out.println(orders);
            if (orders.size()>0){
                list2.add(orders.get(0));
            }
            System.out.println(orders);

        }
        System.out.println(list2);
        return new Result(list2,"1",null);
    }

    @RequestMapping("selectByState3/{userId}")
    public Result selectByState3(@PathVariable("userId") String userId){
        System.out.println(userId);
        List<Order> list2=new ArrayList();
        List<Integer> list = getorderMapper.selectByState3(Integer.parseInt(userId)); //获取我接的所有订单
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            List<Order> orders = orderMapper.selectByOrderid(list.get(i));
            System.out.println(orders);
            if (orders.size()>0){
                list2.add(orders.get(0));
            }
        }
        return new Result(list2,"1",null);
    }

    //根据order订单id查谁接的单

    @RequestMapping("jiedandetails/{oid}")
    public Result jiedandetails(@PathVariable("oid") String oid){
        List<User> list2=new ArrayList();
        System.out.println(oid);
        List<Getorder> list = getorderMapper.jiedandetails(Integer.parseInt(oid));
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            int o = list.get(i).getUserId();
            int a = list.get(i).getGetId();
            System.out.println(o);
            List<User> users = userMapper.selectByUserid(o);
            System.out.println(users);
            if (users.size()>0){
                users.get(0).setGetid(a);
                list2.add(users.get(0));
            }
        }
        System.out.println(list2);
        return new Result(list2,"1",null);

    }

    @RequestMapping("jiedandetails2/{oid}")
    public Result jiedandetails2(@PathVariable("oid") String oid){
        List<User> list2=new ArrayList();
        System.out.println(oid);
        List<Getorder> list = getorderMapper.jiedandetails2(Integer.parseInt(oid));
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            int o = list.get(i).getUserId();
            int a = list.get(i).getGetId();
            System.out.println(o);
            List<User> users = userMapper.selectByUserid(o);
            System.out.println(users);
            if (users.size()>0){
                users.get(0).setGetid(a);
                list2.add(users.get(0));
            }
        }
        System.out.println(list2);
        return new Result(list2,"1",null);

    }

    /*下架时判断有没有人在接单*/
@RequestMapping("yzjd")

public Result yzjd(String oid){

    System.out.println(oid);
    List<Getorder> list = getorderMapper.jiedandetails2(Integer.parseInt(oid));
    System.out.println(list);
    if(list.size() > 0){
        return new Result(null,"1",null);
    }else {
        return new Result(null,"-1",null);
    }
}






    @RequestMapping("jiedandetails3/{oid}")
    public Result jiedandetails3(@PathVariable("oid") String oid){
        List<User> list2=new ArrayList();
        System.out.println(oid);
        List<Getorder> list = getorderMapper.jiedandetails3(Integer.parseInt(oid));
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            int o = list.get(i).getUserId();
            int a = list.get(i).getGetId();
            System.out.println(o);
            List<User> users = userMapper.selectByUserid(o);
            System.out.println(users);
            if (users.size()>0){
                users.get(0).setGetid(a);
                list2.add(users.get(0));
            }
        }
        System.out.println(list2);
        return new Result(list2,"1",null);

    }

    //当同意后修改订单状态
    @RequestMapping("editstate")
    public Result editstate(int getid){
        System.out.println(getid);
        int aa = getorderMapper.updateState(getid);
        if (aa > 0){
            return new Result(null,"1","已同意");
        }else{
            return new Result(null,"2","系统出错，请稍后再试。");
        }

    }

    //当拒绝后修改订单状态
    @RequestMapping("editstate2")
    public Result editstate2(int getid){
        System.out.println(getid);
        int aa = getorderMapper.updateState2(getid);
        if (aa > 0){
            return new Result(null,"1","已拒绝");
        }else{
            return new Result(null,"2","系统出错，请稍后再试。");
        }

    }



}
