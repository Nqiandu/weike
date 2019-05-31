package com.dlg.proj.demo.mapper;

import com.dlg.proj.demo.entity.Getorder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GetorderMapper {
    int deleteByPrimaryKey(Integer getId);

    int insert(Getorder record);

    int insertSelective(Getorder record);

    Getorder selectByPrimaryKey(Integer getId);

    int updateByPrimaryKeySelective(Getorder record);

    int updateByPrimaryKey(Getorder record);
    List<Getorder> selectbyuserid(Integer userId);
    List<Getorder> qiugu();
    List<Getorder> wgdr();
    int abnor(Integer getId);

    /*  我接的零工*/
    List<Integer> selectByUserid(Integer userId);
    List<Integer> selectByState1(Integer userId);
    List<Integer> selectByState2(Integer userId);
    List<Integer> selectByState3(Integer userId);
    /*  我发的零工*/
    List<Getorder> jiedandetails(Integer oid);
    List<Getorder> jiedandetails2(Integer oid);
    List<Getorder> jiedandetails3(Integer oid);
    int updateState(int getid);
    int updateState2(int getid);

    /*接单验证*/
    int selectOrderByUidOid(@Param("userId")Integer userId,@Param("orderId") Integer orderId);
}