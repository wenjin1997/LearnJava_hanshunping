package com.jinjin.pkg;

import com.jinjin.modifier.A;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        //在不同的包中，只能访问public修饰的属性和方法
        System.out.println("n1=" + a.n1);
    }
}
