package com.dlg.proj.demo.mapper;

import com.dlg.proj.demo.entity.Abnormal;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface AbnormalMapper {
    int deleteByPrimaryKey(Integer abnorId);

    int insert(Abnormal record);

    int insertSelective(Abnormal record);

    Abnormal selectByPrimaryKey(Integer abnorId);

    int updateByPrimaryKeySelective(Abnormal record);

    int updateByPrimaryKey(Abnormal record);

    List<Abnormal> selectAll(Abnormal abnormal, RowBounds rowBounds);
    int count(Abnormal abnormal);
    List<Abnormal> selectAll2(Abnormal abnormal, RowBounds rowBounds);
    int count2(Abnormal abnormal);

}