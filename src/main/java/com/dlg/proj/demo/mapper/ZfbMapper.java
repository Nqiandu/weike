package com.dlg.proj.demo.mapper;


import com.dlg.proj.demo.entity.Zfb;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface ZfbMapper {
    int insertinto(@Param("zfbNum")String zfbNum, @Param("userid")Integer userid,@Param("money")Double money);
     List<Zfb> selectAll(Zfb zfb, RowBounds rowBounds);
    int count(Zfb zfb);
    int zz(int id);

}
