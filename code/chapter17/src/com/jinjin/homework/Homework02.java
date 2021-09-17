package com.jinjin.homework;

/**
 * @author 文进
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) {
        User user1 = new User();
        new Thread(user1).start();
        new Thread(user1).start();
    }
}

//因为要共享资源，使用实现Runnable接口的方式
class User implements Runnable {
    private double balance = 10000;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (balance < 1000) {
                    System.out.println("余额不足");
                    break;
                }

                balance -= 1000;
                System.out.println(Thread.currentThread().getName() + "取出1000，剩余" + balance);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
