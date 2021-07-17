package com.jinjin.extend_.improve_;

public class Student {
    public String name;
    public int age;
    private double scores;

    public void setScores(double scores) {
        this.scores = scores;
    }

    public void showInfo() {
        System.out.println("学生名 " + name + " 年龄 " + age + " 成绩 " + scores);
    }
}
