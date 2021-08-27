package com.jinjin.homework;

import java.util.Scanner;

/**
 * @author 文进
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) {
        /**
         * 输入用户名、密码、邮箱，如果信息录入正确，
         * 则提示注册成功，否则生成异常对象。要求：
         * 1. 用户名长度为2或3或4
         * 2. 密码长度为3，要求全是数字
         * 3. 邮箱中包含`@`和`.`，并且`@`在`.`的前面。
         */

        String name = "jack";
        String pwd = "123453";
        String email = "jinjin@qq.com";
        try {
            userRegister(name, pwd, email);
            System.out.println("恭喜注册成功~");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void userRegister(String name, String pwd, String email) {
        if (!(name != null && pwd != null && email != null)){
            throw new RuntimeException("参数不能为空！");
        }

        //验证用户名长度为2或3或4
        int length = name.length();
        if (!(length >= 2 && length <= 4)) {
            throw new RuntimeException("用户名长度为2或3或4!");
        }

        //密码长度为3，要求全是数字
        if (!(pwd.length() == 6 && isDigital(pwd))){
            throw new RuntimeException("密码长度为3，要求全是数字!");
        }

        //邮箱中包含@和.，并且@在.的前面。
        int i = email.indexOf('@');
        int j = email.indexOf('.');
        if (!(i > 0 && i < j)) {
            throw new RuntimeException("邮箱中包含@和.，并且@在.的前面!");
        }
    }

    //校验字符串中全由数字构成
    public static boolean isDigital(String str){
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }
}


