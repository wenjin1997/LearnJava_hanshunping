package com.jinjin.homework;

/**
 * @author 文进
 * @version 1.0
 */
public class Homework04 {
    public static void main(String[] args) {
        String str = "ABC123ew234c";
        count(str);
    }

    /**
     * 输入字符串，判断里面有多少个大写字母，多少个小写字母，多少个数字？
     */
    public static void count(String str) {
        if (str == null) {
            System.out.println("字符串不能为空！");
            return;
        }

        int upperLetter = 0;
        int lowerLetter = 0;
        int digitalNum = 0;
        int otherNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                upperLetter++;
            } else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                lowerLetter++;
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                digitalNum++;
            } else {
                otherNum++;
            }
        }
        System.out.println("大写字母：" + upperLetter);
        System.out.println("小写字母：" + lowerLetter);
        System.out.println("数字：" + digitalNum);
        System.out.println("其他：" + otherNum);
    }
}
