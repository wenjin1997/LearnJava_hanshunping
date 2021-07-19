package com.jinjin.extend_.exercise.exercise02;

public class ExtendsExercise02 {
    public static void main(String[] args) {
        new C();
    }
}
class A {
    public A() {
        System.out.println("我是A类");
    }
}
class B extends A{
    public B() {
        System.out.println("我是B类的无参构造");
    }
    
    public B(String name){
        System.out.println(name + "我是B类的有参构造");
    }
}

class C extends B {
    public C() {
        this("hello");
        System.out.println("我是C类的无参构造");
    }
    public C(String name){
        super("hahah");
        System.out.println("我是C类的有参构造");
    }
}


