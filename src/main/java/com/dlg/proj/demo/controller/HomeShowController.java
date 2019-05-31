package com.dlg.proj.demo.controller;

import com.dlg.proj.demo.entity.HomeOrder;
import com.dlg.proj.demo.entity.Result;
import com.dlg.proj.demo.mapper.HomeShowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("home")
public class HomeShowController {
    @Autowired private HomeShowMapper homeShowMapper;

    /**
     * 主页面显示所有数据，时间逆序
     *
     * @param id
     * @return
     */
    @RequestMapping("homeShow/{order_userid}")
    public Result selectHome(@PathVariable("order_userid") String id) {
        List<HomeOrder> list = homeShowMapper.selectHomeShow(Integer.parseInt(id));
        return new Result(homeShowMapper.selectHomeShow(Integer.parseInt(id)));
    }

    /**
     * 根据订单金额逆序排序
     *
     * @param id
     * @return
     */
    @RequestMapping("showMoney/{order_userid}")
    public Result selectMoneyBig(@PathVariable("order_userid") String id) {
        List<HomeOrder> list = homeShowMapper.selectMoneyBig(Integer.parseInt(id));
        return new Result(homeShowMapper.selectMoneyBig(Integer.parseInt(id)));
    }

    /**
     * 查询类型为‘其他’，时间逆序
     *
     * @param id
     * @return
     */
    @RequestMapping("showOther/{order_userid}")
    public Result selectOther(@PathVariable("order_userid") String id) {
        List<HomeOrder> list = homeShowMapper.selectOther(Integer.parseInt(id));
        return new Result(homeShowMapper.selectOther(Integer.parseInt(id)));
    }

    @RequestMapping("selectById/{id}")
    public HomeOrder selectById(@PathVariable("id") Integer id) {
        // HomeOrder order = homeShowMapper.getIdSelect(id);
        // System.out.println(order);
        return homeShowMapper.getIdSelect(id);
    }

    @RequestMapping("selectByid/{user_id}")
    public Result Company(@PathVariable("user_id") Integer user_id) {

        List list = homeShowMapper.selectByid(user_id);

        return new Result(list, "1", "成功");
    }
}
