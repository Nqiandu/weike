package com.dlg.proj.demo.mapper;

import com.dlg.proj.demo.entity.Company;
import com.dlg.proj.demo.entity.HomeOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeShowMapper {
  /** home页面展示单子列表 @return */
  public List<HomeOrder> selectHomeShow(Integer order_userid);

  /**
   * 查看单子的详情
   *
   * @param id
   * @return
   */
  public HomeOrder getIdSelect(@Param("id") Integer id);

  /**
   * 金额逆序
   *
   * @param order_userid
   * @return
   */
  public List<HomeOrder> selectMoneyBig(Integer order_userid);

  /**
   * 其他类型逆序
   *
   * @param order_userid
   * @return
   */
  public List<HomeOrder> selectOther(Integer order_userid);

  List<Company> selectByid(@Param("user_id") Integer user_id);
}
