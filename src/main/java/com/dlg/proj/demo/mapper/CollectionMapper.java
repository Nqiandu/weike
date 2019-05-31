package com.dlg.proj.demo.mapper;

import com.dlg.proj.demo.entity.Collectionn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectionMapper {
   int selectcol(@Param("userid") int userid,@Param("orderid") int orderid);
    List<Collectionn> selectcol2(@Param("userid") int userid,@Param("orderid") int orderid);
    int insertcol(@Param("userid")int userid,@Param("orderid")int orderid);
    int updatecol(@Param("userid")int userid,@Param("orderid")int orderid);
    int updatecol2(@Param("userid")int userid,@Param("orderid")int orderid);
    List<Collectionn> selectallcol(int userid);
}
