package com.dlg.proj.demo.service;

import com.dlg.proj.demo.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> selectAll();
    int getDelete(Integer adressId);
}
