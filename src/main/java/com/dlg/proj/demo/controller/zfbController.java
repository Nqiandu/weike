package com.dlg.proj.demo.controller;

import com.dlg.proj.demo.entity.Result;
import com.dlg.proj.demo.entity.Zfb;
import com.dlg.proj.demo.mapper.UserMapper;
import com.dlg.proj.demo.mapper.ZfbMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("zfb")
public class zfbController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ZfbMapper zfbMapper;

    @RequestMapping("zfbinfo")
   public Result zfbinfo(Integer userid,Double money,String zfbNum){
        int updatemoney = userMapper.updatemoney(userid, money);
        if(updatemoney > 0){
            int insertinto = zfbMapper.insertinto(zfbNum, userid,money);
            return new Result(null,"200",null);
        }else {
            return new Result(null,"-100",null);
        }
    }

    @RequestMapping("list/{currentPage}/{pageSize}")
    public Result list(@RequestBody Zfb zfb, @PathVariable("currentPage")
            int currentPage, @PathVariable("pageSize") int pageSize){
        RowBounds rowBounds=new RowBounds((currentPage-1)*pageSize,pageSize);
        List<Zfb> list=zfbMapper.selectAll(zfb,rowBounds);
        System.out.println(list);
        int count=zfbMapper.count(zfb);
        return new Result(list,"1",null,count);
    }
    @RequestMapping("zz/{id}")
    public Result zz(@PathVariable("id") Integer id){
        int zz=zfbMapper.zz(id);
        if (zz>0){
            return new Result(null,"1","已转账");
        }
        return new Result(null,"2","转账失败");
    }

}
