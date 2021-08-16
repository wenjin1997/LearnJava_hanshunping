package com.jinjin.try_;

import java.util.Scanner;

/**
 * @author 文进
 * @version 1.0
 */
public class TryCatchExercise04 {
    public static void main(String[] args) {
        //如果用户输入的不是一个整数，就提示他反复输入，
        // 直到输入一个整数为止
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        String inputStr = "";
        while (true) {
            System.out.print("请输入一个整数： ");
            inputStr = scanner.next();
            try {
                num = Integer.parseInt(inputStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("你输入的不是整数");
            }
        }
        System.out.println("输入正确，你输入的数是： " + num);

    }
}
