package com.dlg.proj.demo.mapper;

import com.dlg.proj.demo.entity.Employ;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface EmployMapper {
    int deleteEmploy(Integer empId);

    int insertEmploy(Employ employ);

    List<Employ> selectAll(Employ employ, RowBounds rowBounds);

    int updateEmploy(Employ employ);

    int count(Employ employ);
}