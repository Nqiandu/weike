package com.dlg.proj.demo.controller;

import com.dlg.proj.demo.entity.Abnormal;
import com.dlg.proj.demo.entity.Employ;
import com.dlg.proj.demo.entity.Result;
import com.dlg.proj.demo.entity.User;
import com.dlg.proj.demo.mapper.AbnormalMapper;
import com.dlg.proj.demo.mapper.UserMapper;
import com.dlg.proj.demo.service.AbnormalService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("abnor")
public class AbnormalController {
    @Autowired
    private AbnormalMapper abnormalMapper;
    @Autowired
    AbnormalService abnormalService;
    @RequestMapping("list/{currentPage}/{pageSize}")
    public Result list(@RequestBody Abnormal abnormal, @PathVariable("currentPage") int currentPage,
                       @PathVariable("pageSize") int pageSize){

        RowBounds rowBounds=new RowBounds((currentPage-1)*pageSize,pageSize);
        List<Abnormal> list=abnormalMapper.selectAll(abnormal,rowBounds);

        int count=abnormalMapper.count(abnormal);

        return new Result(list,"1",null,count);
    }

        @RequestMapping("add")
        public Result addAbnor(@PathParam("uid") String uid, @PathParam("oid") Integer oid,
                               @PathParam("reson") String reson,
                               @PathParam("getid") Integer getid){

            return  abnormalService.addabnor(uid, oid, reson,getid);
        }
        @RequestMapping("add2")
        public Result addAbnor2(@PathParam("uid") String uid, @PathParam("oid") Integer oid,
                               @PathParam("reson") String reson,
                               @PathParam("getid") Integer getid){
            System.out.println(111);
            return  abnormalService.addabnor2(uid, oid, reson,getid);
        }
}
