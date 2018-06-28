package com.common.utils;

/**
 * Created by Administrator on 2017/6/14.
 */
public class Util {

    /**
     * 获取随机码
     *
     * @param len
     * @return
     */
    public static String getRandom(int len) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < len; i++) {
            stringBuffer.append(chars.charAt((int) (Math.random() * 26)));
        }
        return stringBuffer.toString();
    }

    /**
     * 判断是否为空或者为NULL
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        }
        return false;
    }

}
