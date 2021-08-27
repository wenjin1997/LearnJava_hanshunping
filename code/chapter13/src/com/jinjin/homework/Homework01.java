package com.jinjin.homework;

/**
 * @author 文进
 * @version 1.0
 */
public class Homework01 {
    public static void main(String[] args) {
        String str = "abcdef";
        System.out.print("字符串反转前：");
        System.out.println(str);
        try {
            str = reverse(str, 0, 3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.print("字符串反转后：");
        System.out.println(str);
    }

    //将字符串中指定部分进行反转
    //思路：将字符串转换成char[]数组
    public static String reverse(String str, int start, int end) {
        if (!(str != null && start < end && start >= 0 && end < str.length())){
            throw new RuntimeException("参数不正确");
        }

        char[] chars = str.toCharArray();
        char temp = ' ';
        //进行反转交换
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}
