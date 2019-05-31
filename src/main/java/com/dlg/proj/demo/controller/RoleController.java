package com.dlg.proj.demo.controller;

import com.dlg.proj.demo.entity.Result;
import com.dlg.proj.demo.entity.Role;
import com.dlg.proj.demo.mapper.RoleMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleMapper roleMapper;
    @RequestMapping("list/{currentPage}/{pageSize}")
    public Result list(@RequestBody Role role, @PathVariable("currentPage")
            int currentPage, @PathVariable("pageSize") int pageSize){
        RowBounds rowBounds=new RowBounds((currentPage-1)*pageSize,pageSize);
        List<Role> list=roleMapper.selectAll(role,rowBounds);
        System.out.println(list);
        int count=roleMapper.count(role);
        return  new Result(list,"1",null,count);
    }

    @RequestMapping("save")
    public Result save(@RequestBody Role role){
        System.out.println(role.getRole_id());
        if(role.getRole_id()==null||"".equals(role.getRole_id())){
            roleMapper.insertRole(role);
        }else{
            int i=roleMapper.updateRole(role);
            System.out.println(i);
        }
        return new Result(null,"1","保存成功");
    }

    @RequestMapping("delete/{id}")
    public Result delete(@PathVariable("id") int id){
        roleMapper.deleteRole(id);
        return new Result(null,"1","删除成功");
    }

}
