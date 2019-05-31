package com.dlg.proj.demo.mapper;

import com.dlg.proj.demo.entity.RoleFunction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleFunctionMapper {
    int insert(RoleFunction record);

    int insertSelective(RoleFunction record);
    List<RoleFunction> selbyid(int id);
    List<RoleFunction> selbyiddd(int id);
}