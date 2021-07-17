package com.jinjin.extend_;

public class Pupil {
    public String name;
    public int age;
    private double scores;

    public void setScores(double scores) {
        this.scores = scores;
    }

    public void testing() {
        System.out.println("小学生 " + name + "正在考数学...");
    }

    public void showInfo() {
        System.out.println("学生名 " + name + " 年龄 " + age + " 成绩 " + scores);
    }
}
