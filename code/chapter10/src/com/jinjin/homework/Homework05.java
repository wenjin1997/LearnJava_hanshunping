package com.jinjin.homework;

/**
 * @author 文进
 * @version 1.0
 */
public class Homework05 {
    public static void main(String[] args) {
        new A().f1();
    }
}

/**
 * 1. 编一个类A，在类中定义局部内部类B，B中有一个私有final常量name，
 * 有一个方法show()打印常量name。进行测试
 * 2. 进阶：A中定义一个私有的变量name，在show方法中打印测试
 */
class A {
    private String name = "小烦";
    public void f1() {
        class B { //局部内部类B
            private final String name = "进进";
            public void show() {
                System.out.println(name);
                System.out.println("A类中的name= " + A.this.name);
            }
        }
        new B().show();
    }
}
