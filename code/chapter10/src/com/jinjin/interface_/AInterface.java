package com.jinjin.interface_;

public interface AInterface {
    //接口中可以有属性
    public int n1 = 100;

    //接口中的抽象方法
    public void work();

    //JDK8之后，接口中可以有实现的方法
    // 1.默认方法，必须加上default关键字,
    default public void hi() {
        System.out.println("hi");
    }
    //2.静态方法
    public static void say() {
        System.out.println("say");
    }
}
