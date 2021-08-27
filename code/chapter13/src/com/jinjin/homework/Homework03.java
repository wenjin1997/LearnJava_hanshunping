package com.jinjin.homework;

import java.util.Locale;

/**
 * @author 文进
 * @version 1.0
 */
public class Homework03 {
    public static void main(String[] args) {
        String name = "Willian Jefferson Clinton";
        printName(name);
    }
    public static void printName(String name) {
        if (name == null) {
            System.out.println("字符串不能为空！");
            return;
        }
        String[] names = name.split(" ");

        if (names.length != 3) {
            System.out.println("输入的姓名格式不正确！");
            return;
        }

        String format = String.format("%s,%s. %c", names[2], names[0], names[1].toUpperCase().charAt(0));
        System.out.println(format);
    }
}
