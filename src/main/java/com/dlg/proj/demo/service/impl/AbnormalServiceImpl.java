package com.dlg.proj.demo.service.impl;

import com.dlg.proj.demo.entity.Abnormal;
import com.dlg.proj.demo.entity.Order;
import com.dlg.proj.demo.entity.Result;
import com.dlg.proj.demo.entity.User;
import com.dlg.proj.demo.mapper.AbnormalMapper;
import com.dlg.proj.demo.mapper.GetorderMapper;
import com.dlg.proj.demo.mapper.OrderMapper;
import com.dlg.proj.demo.mapper.UserMapper;
import com.dlg.proj.demo.service.AbnormalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
@Service
public class AbnormalServiceImpl implements AbnormalService{
    @Autowired
    AbnormalMapper abnormalMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    GetorderMapper getorderMapper;
    @Override
    public Result addabnor(String uid, Integer oid, String reson,Integer getid) {
        User selectbyid = userMapper.selectbyid(Integer.parseInt(uid));
        Order order = orderMapper.selectById(oid);
        User selectbyid1 = userMapper.selectbyid(order.getUserid());
        Abnormal abnormal=new Abnormal("雇主",order.getOrderNumber(),selectbyid1.getUser_name(),selectbyid1.getUser_phone(),
                selectbyid.getUser_name(),selectbyid.getUser_phone(),reson,0);
        int insert = abnormalMapper.insert(abnormal);
        if (insert>0){
            int abnor = getorderMapper.abnor(getid);
            return  new Result(null,"1","添加异常单成功");
        }
        return  new Result(null,"2","添加异常单失败");
    }

    public Result addabnor2(String uid, Integer oid, String reson,Integer getid) {
        User selectbyid = userMapper.selectbyid(Integer.parseInt(uid));
        Order order = orderMapper.selectById(oid);
        User selectbyid1 = userMapper.selectbyid(order.getUserid());
        Abnormal abnormal=new Abnormal("雇员",order.getOrderNumber(),selectbyid1.getUser_name(),selectbyid1.getUser_phone(),
                selectbyid.getUser_name(),selectbyid.getUser_phone(),reson,0);
        int insert = abnormalMapper.insert(abnormal);
        if (insert>0){
            int abnor = getorderMapper.abnor(getid);
            return  new Result(null,"1","添加异常单成功");
        }
        return  new Result(null,"2","添加异常单失败");
    }

}
