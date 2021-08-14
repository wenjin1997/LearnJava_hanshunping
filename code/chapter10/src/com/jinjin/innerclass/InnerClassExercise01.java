package com.jinjin.innerclass;

public class InnerClassExercise01 {
    public static void main(String[] args) {
        f1(new IL() {
            @Override
            public void show() {
                System.out.println("这是一幅名画...");
            }
        });

        f1(new Picture());
    }

    //静态方法，形参是接口类型
    public static void f1(IL il) {
        il.show();
    }
}

//接口
interface IL{
    void show();
}

//传统方法
class Picture implements IL{

    @Override
    public void show() {
        System.out.println("这是一幅名画...");
    }
}
