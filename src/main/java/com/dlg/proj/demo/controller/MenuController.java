package com.dlg.proj.demo.controller;

import com.dlg.proj.demo.entity.*;
import com.dlg.proj.demo.mapper.FunctionMapper;
import com.dlg.proj.demo.mapper.RoleFunctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("menu")
public class MenuController {
    @Autowired
    RoleFunctionMapper roleFunctionMapper;
    @RequestMapping("menus")
    public Result getall(){
        List arr=new ArrayList();
        Account acoutFromSession = EmpUtil.getAcoutFromSession();
        Integer roleId = acoutFromSession.getRoleId();

        List<RoleFunction> selbyid = roleFunctionMapper.selbyid(roleId);
        for (int i = 0; i <selbyid.size() ; i++) {
            Function fun = selbyid.get(i).getFun();
            if (fun!=null){
             arr.add(fun);
            }

        }

        return new Result(arr);


    }
}
