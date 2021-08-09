package com.jinjin.homework.homework10;

/*
编写Doctor类`{name, age, job, gender, sal}`
相应的getter()和setter()方法，5个参数构造器，
重写父类(Object)的equals()方法:`public boolean equals(Object obj)`，
并判断测试类中创建的两个对象是否相等。相等就是判断属性是否相同。
 */
public class Doctor {
    private String name;
    private int age;
    private String job;
    private char gender;
    private double sal;

    public Doctor(String name, int age, String job, char gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    // 重写父类(Object)的equals()方法:`public boolean equals(Object obj)`
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Doctor) {
            Doctor aDoctor = (Doctor)obj; // 向下转型
            return aDoctor.name.equals(this.name) &&
                    aDoctor.age == this.age &&
                    aDoctor.gender == this.gender &&
                    aDoctor.job.equals(this.job) &&
                    aDoctor.sal == this.sal;
        }
        return false;
    }
}
