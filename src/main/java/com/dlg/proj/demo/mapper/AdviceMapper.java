package com.dlg.proj.demo.mapper;

import com.dlg.proj.demo.entity.Advice;

public interface AdviceMapper {
    int deleteByPrimaryKey(Integer adviceId);

    int insert(Advice record);

    int insertSelective(Advice record);

    Advice selectByPrimaryKey(Integer adviceId);

    int updateByPrimaryKeySelective(Advice record);

    int updateByPrimaryKey(Advice record);
}