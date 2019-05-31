package com.dlg.proj.demo.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderUtil {
            //构造支付订单参数信息
        public static String buildOrderParam(Map<String,String> map){
            System.out.println(3333);
            List<String> keys = new ArrayList<>(map.keySet());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < keys.size() - 1; i++) {
                String key = keys.get(i);
                String value=map.get(key);
                sb.append(buildKeyValue(key,value,true));
                sb.append("&");
            }
            String tailKey = keys.get(keys.size() - 1);
            String tailValue = map.get(tailKey);
            sb.append(buildKeyValue(tailKey,tailValue,true));

            return sb.toString();
        }


        //拼接键值对
        private static String buildKeyValue(String key,String value,boolean isEnocode){
            System.out.println(4444);
            StringBuilder sb = new StringBuilder();
            sb.append(key);
            sb.append("=");
            if(isEnocode){
                try {
                    sb.append(URLEncoder.encode(value,"UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    sb.append(value);
                }
            }else{
                    sb.append(value);
            }
            return sb.toString();
        }
}
