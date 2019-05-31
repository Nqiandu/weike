package com.dlg.proj.demo.mapper;

import com.dlg.proj.demo.entity.Address;

import java.util.List;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer adressId);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer adressId);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    List<Address> selectAll();
}