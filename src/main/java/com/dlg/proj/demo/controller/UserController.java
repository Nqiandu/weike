package com.dlg.proj.demo.controller;

import com.dlg.proj.demo.entity.Result;
import com.dlg.proj.demo.entity.User;
import com.dlg.proj.demo.mapper.UserMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @RequestMapping("list/{currentPage}/{pageSize}")
    public Result list(@RequestBody User user, @PathVariable("currentPage")
                       int currentPage,@PathVariable("pageSize") int pageSize){
        RowBounds rowBounds=new RowBounds((currentPage-1)*pageSize,pageSize);
        List<User> list=userMapper.selectAll(user,rowBounds);
        System.out.println(list);
        int count=userMapper.count(user);
        return new Result(list,"1",null,count);
    }
  //echars图
    @RequestMapping("echars1")
    public List<User>  echars1(){
        System.out.println(userMapper.selechar());
        return userMapper.selechar();
    }

    @RequestMapping("save")
    public Result save(@RequestBody User user){
        System.out.println(user.getUser_id());
        if(user.getUser_id()==null||"".equals(user.getUser_id())){
            userMapper.insertUser(user);
        }else{
            int i=userMapper.updateUser(user);
            System.out.println(i);
        }
        return new Result(null,"1","保存成功");
    }

    @RequestMapping("delete/{id}")
    public Result delete(@PathVariable("id") int id){
        userMapper.deleteUser(id);
        return new Result(null,"1","删除成功");
    }
    @RequestMapping("ljcr/{uid}")
    public Result ljcr(@PathVariable("uid") String uid){
        User selectbyid = userMapper.selectbyid(Integer.parseInt(uid));

        return new Result(selectbyid);
    }
    @RequestMapping("getUser/{userid}")
    public Result getLoad(@PathVariable("userid") String userid){
        User user = userMapper.selectbyid(Integer.parseInt(userid));
        System.out.println(user);
        if (user!=null){
            return new Result(user,"1","查询成功");
        }else{
            return new Result(user,"-1","查询失败");
        }
    }//肖亚娟E

    //肖亚娟S
    @RequestMapping("isCheckRealName/{userid}")
    public Result isCheckRealName(@PathVariable("userid") String userid){
        User user = userMapper.selectbyid(Integer.parseInt(userid));
        String user_carid = user.getUser_carid();
        if (user_carid==null||"".equals(user_carid)){

            return new Result(null,"2","未认证");
        }else{

            return new Result(null,"1","已认证");
        }
    }//肖亚娟E

    @RequestMapping("isCheckCarid")
    public Result isCheckCarid(String userid){
        System.out.println(userid);
        User user = userMapper.selectbyid(Integer.parseInt(userid));
        String user_carid = user.getUser_carid();
        if (user_carid==null||"".equals(user_carid)){

            return new Result(null,"2","未认证");
        }else{

            return new Result(null,"1","已认证");
        }
    }
}
