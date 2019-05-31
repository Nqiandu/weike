package com.dlg.proj.demo.controller;

import com.dlg.proj.demo.entity.Employ;
import com.dlg.proj.demo.entity.Result;
import com.dlg.proj.demo.mapper.EmployMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("employ")
public class EmployController {
    @Autowired
    private EmployMapper employMapper;

    @RequestMapping("list/{currentPage}/{pageSize}")
    public Result list(@RequestBody Employ employ, @PathVariable("currentPage") int currentPage,
                       @PathVariable("pageSize") int pageSize){


        RowBounds rowBounds=new RowBounds((currentPage-1)*pageSize,pageSize);
        List<Employ> list=employMapper.selectAll(employ,rowBounds);

        int count=employMapper.count(employ);

        return new Result(list,"1",null,count);
    }

    @RequestMapping("save")
    public Result save(@RequestBody Employ employ) {
        Date empEntrytime = employ.getEmpEntrytime();
        System.out.println(empEntrytime);
        System.out.println(employ);
        if(employ.getEmpId()==null||"".equals(employ.getEmpId())){
            employMapper.insertEmploy(employ);

        }else{
            employMapper.updateEmploy(employ);
        }
        return new Result(null,"1","保存成功");
    }

    @RequestMapping("delete/{empId}")
    public Result delete(@PathVariable("empId") int empId){
        employMapper.deleteEmploy(empId);

        return new Result(null,"1","删除成功");
    }


}
