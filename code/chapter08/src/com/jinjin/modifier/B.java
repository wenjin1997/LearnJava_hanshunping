package com.jinjin.modifier;

public class B {
    public void say() {
        A a = new A();
        //在同一个包中，可以访问public,protected和默认修饰的属性和方法,
        // 不能访问private修饰的属性和方法
        System.out.println("n1=" + a.n1 + " n2=" + a.n2 + " n3=" + a.n3);
    }
}
