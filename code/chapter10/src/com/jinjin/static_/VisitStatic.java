package com.jinjin.static_;

public class VisitStatic {
    public static void main(String[] args) {
        System.out.println(A.name);
        A a = new A();
        System.out.println("a.name=" + a.name);
    }
}

class A {
    //类变量
    //类变量的访问，必须遵守相关的访问权限
    public static String name = "进进";
}