package com.jinjin.homework.homework03;

public class Lecturer extends Teacher{
    public Lecturer(String name, int age, String post, double salary, double grade) {
        super(name, age, post, salary, grade);
    }

    public void introduce() {
        System.out.print("讲师：");
        super.introduce();
    }
}
