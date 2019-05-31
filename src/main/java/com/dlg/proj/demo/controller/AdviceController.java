package com.dlg.proj.demo.controller;

import com.dlg.proj.demo.entity.Advice;
import com.dlg.proj.demo.entity.Result;
import com.dlg.proj.demo.mapper.AdviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("advice")
@CrossOrigin(allowCredentials = "true")
public class AdviceController {
    @Autowired
    private AdviceMapper adviceMapper;
    @RequestMapping("save/{userid}")
    public Result insertAdvice(@RequestBody Advice advice, @PathVariable("userid") String userid){
        advice.setUserId(Integer.parseInt(userid));
        //这个没有用户的id号，等之后获取后再插入
        int i = adviceMapper.insertSelective(advice);
        if (i>0){
            return new Result(null,"1","保存成功！");
        }else{
            return new Result(null,"-1","保存失败！");
        }
    }
}
