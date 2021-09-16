package com.jinjin.threaduse;

/**
 * @author 文进
 * @version 1.0
 * 实现Runnable接口的方式创建线程
 */
public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Thread thread = new Thread(dog);
        thread.start();

        Tiger tiger = new Tiger();
        ThreadProxy threadProxy = new ThreadProxy(tiger);
        threadProxy.start();
    }
}

class Animal {
}

class Tiger extends Animal implements Runnable {

    @Override
    public void run() {
        System.out.println("老虎嗷嗷叫....");
    }
}

//模拟静态代理模式
class ThreadProxy implements Runnable {
    private Runnable target = null;

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    @Override
    public void run() {
        if (target != null) {
            target.run(); //动态绑定，运行类型是Tiger
        }
    }

    public void start() {
        start0();
    }

    public void start0() {
        run();
    }
}


class Dog implements Runnable {
    @Override
    public void run() {
        int count = 0; //小狗汪汪叫的次数
        while (true) {
            System.out.println("小狗汪汪叫" + (++count) + Thread.currentThread().getName());
            //快捷键 command+alt+T
            try {
                Thread.sleep(1000); //休眠1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) {
                break;
            }
        }
    }
}
