package com.dlg.proj.demo.mapper;

import com.dlg.proj.demo.entity.Role;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface RoleMapper {
    List<Role> selectAll(Role role, RowBounds rowBounds);
    int insertRole(Role role);
    int deleteRole(int id);
    int updateRole(Role role);
    int count(Role role);
}
