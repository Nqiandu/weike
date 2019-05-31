package com.dlg.proj.demo.service.impl;

import com.dlg.proj.demo.mapper.UserAddressMapper;
import com.dlg.proj.demo.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAddressServiceImpl implements UserAddressService {
    @Autowired
    private UserAddressMapper userAddressMapper;
    @Override
    public int deleteByAdressId(Integer adressId) {
        return userAddressMapper.deleteByAdressId(adressId);
    }
}
