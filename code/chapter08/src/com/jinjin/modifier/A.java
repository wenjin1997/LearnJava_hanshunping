package com.jinjin.modifier;

public class A {
    //四个属性
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    //同一个类中，可以访问public, protected, 默认, private修饰的属性或方法
    public void m1() {
        System.out.println("n1=" + n1 + " n2=" + n2 + " n3=" + n3 + " n4=" + n4);
    }
}
