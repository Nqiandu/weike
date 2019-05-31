package com.dlg.proj.demo.controller;

import com.dlg.proj.demo.entity.Address;
import com.dlg.proj.demo.entity.Result;
import com.dlg.proj.demo.entity.UserAddress;
import com.dlg.proj.demo.mapper.AddressMapper;
import com.dlg.proj.demo.mapper.UserAddressMapper;
import com.dlg.proj.demo.service.AddressService;
import com.dlg.proj.demo.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("address")
@CrossOrigin(allowCredentials = "true")
public class AddressController {
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private UserAddressMapper userAddressMapper;
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserAddressService userAddressService;
    @RequestMapping("getinsert/{userid}")
    /* 动态的获取了userid*/
    public Result insertaddress(@RequestBody Address address,@PathVariable("userid") String userid){
        int a = addressMapper.insert(address);
        if (a>0){
            Integer adressId = address.getAdressId();
            UserAddress userAddress=new UserAddress();
            userAddress.setUserId(Integer.parseInt(userid));
            userAddress.setAdressId(adressId);
            int i = userAddressMapper.insertSelective(userAddress);
            if (i>0){
                return new Result(null,"1","插入useraddress成功！");
            }else {
                return new Result(null,"-1","插入useraddress失败！");
            }

        }else {
            return new Result(null,"-1","插入address失败");
        }
    }
    /* 动态的获取了userid*/
    @RequestMapping("getAllAddress/{userid}")
    public Result getAllAddress(@PathVariable("userid") String userid){
        List<UserAddress> uads = userAddressMapper.selectByUserId(Integer.parseInt(userid));
        List<Address> addresses=new ArrayList<>();
        if (uads.size()>0){
            for (int i = 0; i <uads.size() ; i++) {
                Integer addressId=uads.get(i).getAdressId();
                Address address = addressMapper.selectByPrimaryKey(addressId);
                addresses.add(address);
            }
            return new Result(addresses,"1","查询成功");
        }else{
            System.out.println("查询失败");
            return new Result(null,"2","查询失败");
        }


    }
    @RequestMapping("getdelete/{adressId}")
    public Result getDelete(@PathVariable Integer adressId){
        int i = addressService.getDelete(adressId);
        if (i>0){
            int j = userAddressService.deleteByAdressId(adressId);
            if (j>0){
                return new Result(null,"1","删除成功");
            }else{
                return new Result(null,"-1","删除失败");
            }

        }else{
            return new Result(null,"-1","删除失败");
        }

    }
}

