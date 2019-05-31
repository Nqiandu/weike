package com.dlg.proj.demo.service.impl;

import com.dlg.proj.demo.entity.*;
import com.dlg.proj.demo.mapper.GetorderMapper;
import com.dlg.proj.demo.mapper.OrderMapper;
import com.dlg.proj.demo.mapper.UserMapper;
import com.dlg.proj.demo.service.GetorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetorderServiceImpl implements GetorderService{
    @Autowired
    GetorderMapper getorderMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public Result selectbyuserid(Integer userId) {
        List<Getorder> selectbyuserid = getorderMapper.selectbyuserid(userId);
        List list=new ArrayList();
        if (selectbyuserid.size()>0){
            for (int i = 0; i <selectbyuserid.size() ; i++) {
                    int id=selectbyuserid.get(i).getOrderId();
                Order order = orderMapper.selectById(id);
                order.setGetid(selectbyuserid.get(i).getGetId());
                order.setUid(userId);
                order.setGstate(selectbyuserid.get(i).getGetState());
                list.add(order);
            }
            return new Result(list,"1",null,0);
        }else{
            return new Result(null,"2",null);
        }

    }

    @Override
    public Result wgdr(String userid) {
        List<Getorder> qiugu = getorderMapper.wgdr();

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
}
