package com.dlg.proj.demo.controller;

import com.dlg.proj.demo.entity.Collectionn;
import com.dlg.proj.demo.entity.Order;
import com.dlg.proj.demo.entity.Result;
import com.dlg.proj.demo.mapper.CollectionMapper;
import com.dlg.proj.demo.mapper.OrderMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class CollectionController {
    @Autowired
    private CollectionMapper collectionMapper;
    @Autowired
    private OrderMapper orderMapper;
    @RequestMapping("collectionsel")
    public Result collectionsel(int userid, int orderid){
        System.out.println(userid);
        System.out.println(orderid);
        List<Collectionn> selectcol = collectionMapper.selectcol2(userid, orderid);
        if(selectcol.size() > 0){
            Integer state = selectcol.get(0).getState();
            if(state == 1){
                collectionMapper.updatecol(userid,orderid);  //取消收藏
                System.out.println(1);
                return new Result(null,"1","已取消收藏",0);
            }else {
                collectionMapper.updatecol2(userid,orderid);  //添加收藏
                System.out.println(2);
                return new Result(null,"2","已添加收藏",0);

            }
        }else {
            int insertcol = collectionMapper.insertcol(userid, orderid);  //添加收藏
            System.out.println(3);
            return new Result(null,"3","已添加收藏",0);

        }
    }


    @RequestMapping("collectionallsel/{userid}")
    public Result collectionallsel(@PathVariable("userid") int userid){
        System.out.println(userid);
        List<Order> list2=new ArrayList();

        List<Collectionn> selectallcol = collectionMapper.selectallcol(userid);
        System.out.println(selectallcol);
        for (int i = 0; i < selectallcol.size(); i++) {
            int a = selectallcol.get(i).getOrderid();
            System.out.println(a);
            Order order = orderMapper.selectById(a);
                list2.add(order);
        }
        System.out.println(list2);
        return new Result(list2,"1",null);

    }

    @RequestMapping("selcetcolstate")
        public Result selectsel(int userid,int orderid) {

        int selectcol = collectionMapper.selectcol(userid, orderid);
        System.out.println(selectcol);
        if(selectcol == 0){

            return new Result(null, "0", null);

        }
        else {
            List<Collectionn> collectionns = collectionMapper.selectcol2(userid, orderid);

            Integer state = collectionns.get(0).getState();

            if (state == 1) {
                return new Result(null, "1", null);
            } else {
                return new Result(null, "0", null);
            }
        }
    }

}
