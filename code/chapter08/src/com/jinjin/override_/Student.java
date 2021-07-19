package com.jinjin.override_;

public class Student extends Person{
    private int id;
    private double score;

    public Student(String name, int age, int id, double score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String say() {
//        return " 你好，我叫" + getName() + "，今年" + getAge() +
//                "岁" + "我的id是：" + id + "，我考了" + score + "分。";
        return super.say() + "我的id是：" + id + "，我考了" + score + "分。";
    }
}
