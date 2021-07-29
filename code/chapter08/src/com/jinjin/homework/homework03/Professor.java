package com.jinjin.homework.homework03;

public class Professor extends Teacher{
    public Professor(String name, int age, String post, double salary, double grade) {
        super(name, age, post, salary, grade);
    }

    public void introduce() {
        System.out.print("教授：");
        super.introduce();
    }
}
