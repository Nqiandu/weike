package com.dlg.proj.demo.mapper;

import com.dlg.proj.demo.entity.UserAddress;

import java.util.List;

public interface UserAddressMapper {
    int deleteByPrimaryKey(Integer uAId);

    int deleteByAdressId(Integer adressId);

    int insert(UserAddress record);

    int insertSelective(UserAddress record);

    UserAddress selectByPrimaryKey(Integer uAId);
    List<UserAddress> selectByUserId(Integer userId);


    int updateByPrimaryKeySelective(UserAddress record);

    int updateByPrimaryKey(UserAddress record);
}