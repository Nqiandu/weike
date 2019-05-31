package com.dlg.proj.demo.util;

import java.util.Random;

public class GetOrderTime {

    public static String getOrderIdByTime() {
        long millis = System.currentTimeMillis();
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            result += random.nextInt(10);
        }
        return millis + result;
    }
}
