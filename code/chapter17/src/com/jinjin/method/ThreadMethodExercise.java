package com.jinjin.method;

/**
 * @author 文进
 * @version 1.0
 */
public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        T3 t3 = new T3();
        Thread thread = new Thread(t3);
        for (int i = 0; i < 10; i++) {
            System.out.println("hi" + (i+1));
            Thread.sleep(1000);
            if (i == 4) {
                thread.start();
                thread.join();
            }
        }
    }
}

class T3 implements Runnable {
    @Override
    public void run() {
        int count = 0;
        while (true) {
            System.out.println("hello" + (++count));
            if (count == 10) {
                break;
            }
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
