package com.dlg.proj.demo.mapper;

import com.dlg.proj.demo.entity.OrderPay;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderPayMapper {
    //添加支付订单
    public int addorderpay(OrderPay orderPay);

    //支付成功后修改支付状态
    public int editpay(String orderid);

    /**
     * 修改user表金额
     *
     * @param userid
     * @return
     */
    public int addUserMoney(Integer userid, @Param("price") Double price);

    /**
     * 根据支付流水号查询金额
     *
     * @param orderid
     * @return
     */
    public List<OrderPay> selectMoney(String orderid);

    /**
     * 查原来的钱数
     *
     * @param userid
     * @return
     */
    public Double selectMoney(Integer userid);

    //查询uid和oid
    public List selectUidOid(String orderid);

    //根据uid和oid修改getorder里得状态
    public int editGetOrder(Integer userid, Integer order_id);

    //根据uid和oid获取订单支付状态
    List<OrderPay> getpaystate(@Param("uid") Integer uid, @Param("oid") Integer oid);

    List<OrderPay> selectbyoiduid(@Param("userid") Integer userid, @Param("orderid") Integer orderid);
}
