package com.jinjin.homework.homework06;

public class Homework06 {
}

class Grand{ //超类
    String name = "AA";
    private int age = 100;
    public void g1(){ }
}

class Father extends Grand{ // 父类
    String id = "001";
    private double score;
    public void f1() {
        // super可以调用哪些属性和方法？
        // super.name;super.g1();

        // this可以调用哪些属性和方法？
        // this.id;this.score;this.f1();this.name;this.g1();

    }
}

class Son extends Father{ //子类
    String name = "BB";
    public void g1() {
    }
    public void show(){
        // super可以调用哪些属性和方法？
        // super.id;super.f1();super.name;super.g1();

        // this可以调用哪些属性和方法？
        // this.name;this.g1();this.show();this.id;this.f1();
    }
}
