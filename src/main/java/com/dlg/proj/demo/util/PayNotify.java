package com.dlg.proj.demo.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PayNotify {
    private static final String ALIPAYPUBLICKEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyllTZz0y+AEp8ACdC/oAArpLnzxVfhXADMmKTLKHxcxdxFH77mYTYE8ZNCar0MAgM1edQDsY2WH3DGX4FEyu4EjwETdGW72wM9XQIGiTyjsi6ubtSwxmZKF8UaBo/QzYNSjnuwIE/uNTCcITR/JQQFxgg2gHw29UcXj8raHXbeHnOTu9jADEqo5KOAqgLvIu94ngNiNiDx7D9NDweIKQ8WWdvGanXNf66zXYjvmkEu9HVpz3TGEJqlDVf6HITRk9w1hq8+5ReBTDUW5ODztU6K/4ZHFV+Jfd0EX+RYirc4dvQlb5UP48x2a1xzB5ubBjk0ZCuQnykuEK9fLMiVTltQIDAQAB";

    public static boolean payNotify(Map requestParams) throws AlipayApiException {
        System.out.println(222);
        HashMap<String, String> params = new HashMap<>();

        for (Iterator iter = requestParams.keySet().iterator();iter.hasNext();){
            String name = (String)iter.next();
            String[] values=(String[])requestParams.get(name);
            String valueStr="";
            for (int i = 0; i < values.length; i++) {
                valueStr =(i==values.length-1)?valueStr+values[i]:valueStr+values[i]+",";
            }
            params.put(name,valueStr);
        }

        String s= OrderUtil.buildOrderParam(params);
        System.out.println(s);
        boolean flag = AlipaySignature.rsaCheckV1(params, ALIPAYPUBLICKEY, "utf-8", "RSA2");
        System.out.println(flag);
        return flag;
    }
}
