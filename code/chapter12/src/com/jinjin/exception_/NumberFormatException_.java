package com.jinjin.exception_;

/**
 * @author 文进
 * @version 1.0
 */
public class NumberFormatException_ {
    public static void main(String[] args) {
        String name = "进进";
        //将String 转成 int
        int num = Integer.parseInt(name);//抛出NumberFormatException
        System.out.println(num);//1234
    }
}
