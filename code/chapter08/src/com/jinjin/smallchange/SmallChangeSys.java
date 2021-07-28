package com.jinjin.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
    //零钱通项目界面
    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";

        //2. 实现零钱通明细
        String details = "----------零钱通明细-----------";

        //3. 完成收益入账
        // 定义新的变量
        double money = 0;
        double balance = 0;
        Date date = null; //date 是 java.util.Date 类型，表示日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //可以用于日期格式化的

        // 4.消费
        //定义新的变量
        String note = "";

        do {

            System.out.println("\n========零钱通菜单========");
            System.out.println("\t\t1 零钱通明细");
            System.out.println("\t\t2 收益入账");
            System.out.println("\t\t3 消费");
            System.out.println("\t\t4 退     出");


            System.out.print("请选择(1-4):");
            key = scanner.next();

            switch (key) {
                case "1" :
                    System.out.println(details);
                    break;
                case "2" :
                    System.out.print("收益入账金额：");
                    money = scanner.nextDouble();
                    //money 的值范围应该校验
                    //找出不正确的金额条件，然后给出提示，就直接break
                    if (money <= 0) {
                        System.out.println("收益入账金额 需要 大于 0");
                        break;
                    }

                    balance += money;

                    //拼接收益入账信息到details
                    date = new Date(); // 获取当前日期
                    details += "\n收益入账\t" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "3" :
                    System.out.print("消费金额：");
                    money = scanner.nextDouble();

                    if (money <= 0 || money > balance) {
                        System.out.println("你的消费金额 应该在0-" + balance);
                        break;
                    }

                    System.out.print("消费说明：");
                    note = scanner.next();
                    balance -= money;
                    //拼接消费信息到details
                    date = new Date();
                    details += "\n" + note + "\t\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "4" :
                    //用户输入4退出时，给出提示"你确定要退出吗？y/n"，必须输入正确的y/n,
                    // 否则循环输入指令，直到输入y 或者 n
                    // (1) 定义一个变量 choice
                    // (2) 使用 while + break
                    // (3) 退出while后，再判断choice是y还是n,就可以决定是否退出
                    // (4) 建议一段代码，只实现一个小的功能
                    String choice = "";
                    while (true) {
                        System.out.print("你确定要退出吗？y/n ");
                        choice = scanner.next();
                        if("y".equals(choice) || "n".equals(choice)) {
                            break;
                        }
                    }

                    //当用户退出while，进行判断
                    if (choice.equals("y")) {
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
            }
        }while (loop);

        System.out.println("----退出了零钱通项目----");
    }
}
