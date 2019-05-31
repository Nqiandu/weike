package com.dlg.proj.demo.mapper;

import com.dlg.proj.demo.entity.Account;

import java.util.List;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer countId);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer countId);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    int insertcount(Account account);

    List<Account> selectByName(Account account);

    Account selectByTel(String countName);
    int backPassword(Account account);
    Account login(Account account);
    Account getname(String accountName);
}