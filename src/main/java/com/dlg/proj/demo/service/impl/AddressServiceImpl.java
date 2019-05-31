package com.dlg.proj.demo.service.impl;

import com.dlg.proj.demo.entity.Address;
import com.dlg.proj.demo.mapper.AddressMapper;
import com.dlg.proj.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressMapper addressMapper;
    @Override
    public List<Address> selectAll() {
        return addressMapper.selectAll();
    }

    @Override
    public int getDelete(Integer adressId) {

        return addressMapper.deleteByPrimaryKey(adressId);
    }
}
