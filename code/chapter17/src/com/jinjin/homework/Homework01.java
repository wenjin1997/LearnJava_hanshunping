package com.jinjin.homework;

import java.util.Scanner;

/**
 * @author 文进
 * @version 1.0
 * 在main方法中启动两个线程
 * 第一个线程循环随机打印100以内的整数
 * 直到第2个线程从键盘读取了Q命令
 */
public class Homework01 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2(t1);
        t1.start();
        t2.start();
    }
}

class T1 extends Thread {
    private boolean loop = true;
    @Override
    public void run() {
        while (loop) {
            System.out.println((int)(Math.random() * 100 + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class T2 extends Thread {
    private  T1 t1;
    private Scanner scanner = new Scanner(System.in);

    public T2(T1 t1) {
        this.t1 = t1;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("请输入你的指令(Q)退出：");
            char key = scanner.next().toUpperCase().charAt(0);
            if (key == 'Q') {
                t1.setLoop(false);
                System.out.println("T2线程退出");
                break;
            }
        }
    }
}
