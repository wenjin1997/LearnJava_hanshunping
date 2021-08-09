package com.jinjin.homework.homework10;

public class Homework10 {
    public static void main(String[] args) {
        //测试
        Doctor doctor1 = new Doctor("jack", 20, "医生", '男', 20000);
        Doctor doctor2 = new Doctor("jack", 20, "医生", '男', 20000);
        System.out.println(doctor1.equals(doctor2));
    }
}
