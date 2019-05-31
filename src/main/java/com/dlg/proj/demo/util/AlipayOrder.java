package com.dlg.proj.demo.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;

public class AlipayOrder {
    private static final String SERVERURL="https://openapi.alipay.com/gateway.do";
    private static final String APPID="2019042764380156";
    private static final String PRIVATEKEY="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDKWVNnPTL4ASnwAJ0L+gACukufPFV+FcAMyYpMsofFzF3EUfvuZhNgTxk0JqvQwCAzV51AOxjZYfcMZfgUTK7gSPARN0ZbvbAz1dAgaJPKOyLq5u1LDGZkoXxRoGj9DNg1KOe7AgT+41MJwhNH8lBAXGCDaAfDb1RxePytoddt4ec5O72MAMSqjko4CqAu8i73ieA2I2IPHsP00PB4gpDxZZ28Zqdc1/rrNdiO+aQS70dWnPdMYQmqUNV/ochNGT3DWGrz7lF4FMNRbk4PO1Tor/hkcVX4l93QRf5FiKtzh29CVvlQ/jzHZrXHMHm5sGOTRkK5CfKS4Qr18syJVOW1AgMBAAECggEAOUYrW09xO81oh2xFB3zNv/fnK70yHaweXgA1yxvFXnFIISdrfcEavunkomRHwaB//MhR1DpmADHAcZvzKhvCa+15NgZFPfZlB2b/sAypuFYgvgh7JgDugpFK1Pfof6fBEtrvLHmX3GWPvXVXa8fkezMqhkdN2z2J00yBiMwEZC9J9wj4R2UGuUJ52VZNjEBdz063Am/oRVas5hTz01IjPv/gY2G+IQDpeJo81KJYpme0yWiuLY0wqCtLEKjyf28QirfIyDInrgnmpFSyyUf3WGqWYWgWNJN7JrnLkLdpYuZqIHwBgmslmG0Su96aupYGUjESxevcr9x1EhXBkW0wiQKBgQDvatJNMTa5FALA+WJWGbPq5oEZTYwnWKPJSyeLBPYnrwUL6piwP7plaFFNBztUT/4FAybQIX0Ln4jbO2e+l0HnD8UeaixdPoIZ8o30zKt3WVQ8hAxHuLVDFxKzbtEDWXV6V/Fwe31y//fLlJ6Fj3VLLrFvSVk+ahi6GjOrTuCd1wKBgQDYXTwLaZfPRpiFWwd5KatRIFh8Cd1vzNL+5yGgvBWp25NH/zTebZYAQFm/Ph12XXLGRXmi7XWVzTtAEf4ZmnB4RHLuCESehVf46el/LyXlctjr3/lqtDphLB5BnOhCvxJ3igMGvoepIgLB/1L1uMeuwrWaSdAT6UjCJ0ByFUrvUwKBgHJa3H5AXnoCY9pWg7DKcBRn6wvx7VqxzPGNsyKEySplP4zUjf/JQLfFHugi5yS7XIJ6YeSRyk9t8Ql+E2yGhNTfxHBlmDEldTD9mO5vgAruoPySuebcA8A62hTYfn8SELnSHaFzapUuS+ZyY1E6F3VEpT2ZlEXqmUryzvEpKMJbAoGAGBtbQ1JCjd+pwsH/tSpFYkaeVUOsHnbN04ThJE2QhFposI7ozxearPB+j2ZWVgfXb+vxv4uBnG0/esYGb8fbXCsUOx1Et/zXbm5xi7AvIr+HF9Des1rdXlJSFLFs13L+lb8U0z2LU/bsI71U+vfZl8kt/sDWpEFL0AYbkhp5PO0CgYEA1NDkMgJYSBAOb5i9rrEAxPc8aw7nY9qInAY0F1LWWBZK98+t2aEzbwqry1cnZbKWvy7XlUXjaU9K7waAyAo1cpKpskdS4JeQ5kE7OFR6560vVI4vIUTCi3oqdJbHgaAhNN7tEBvbBrt4ncUyKDELl9kWntb7YiA4wV8QHpfoFsQ=";
    private static final String ALIPAYPUBLICKEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyllTZz0y+AEp8ACdC/oAArpLnzxVfhXADMmKTLKHxcxdxFH77mYTYE8ZNCar0MAgM1edQDsY2WH3DGX4FEyu4EjwETdGW72wM9XQIGiTyjsi6ubtSwxmZKF8UaBo/QzYNSjnuwIE/uNTCcITR/JQQFxgg2gHw29UcXj8raHXbeHnOTu9jADEqo5KOAqgLvIu94ngNiNiDx7D9NDweIKQ8WWdvGanXNf66zXYjvmkEu9HVpz3TGEJqlDVf6HITRk9w1hq8+5ReBTDUW5ODztU6K/4ZHFV+Jfd0EX+RYirc4dvQlb5UP48x2a1xzB5ubBjk0ZCuQnykuEK9fLMiVTltQIDAQAB";

    public static String alipayOrder(String outtradeno){
        System.out.println(outtradeno);
        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient(SERVERURL, APPID, PRIVATEKEY, "json", "utf-8", ALIPAYPUBLICKEY, "RSA2");
//实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
//SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();

        model.setBody("我是测试数据");
        model.setSubject("威客App支付");
        model.setOutTradeNo(outtradeno);
        model.setTimeoutExpress("30m");
        model.setTotalAmount("0.01");
        model.setProductCode("QUICK_MSECURITY_PAY");
        request.setBizModel(model);
        request.setNotifyUrl("http://2478899af8.wicp.vip:26961/alipay/payNotify");
        try {
            //这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            System.out.println(response.getBody());//就是orderString 可以直接给客户端请求，无需再做处理。
            return  response.getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return null;
    }

}
