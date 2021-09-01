package com.jinjin.set_.exercise2;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author 文进
 * @version 1.0
 */
public class HashSetExercise02 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("小明", 20000, new MyDate(1998, 12, 1)));
        hashSet.add(new Employee("小蓝", 20000, new MyDate(1998, 12, 1)));
        hashSet.add(new Employee("小明", 20000, new MyDate(1998, 12, 1)));
        System.out.println("hashSet=" + hashSet);

    }
}

/*
定义一个`Employee`类，该类包含：：`private`成员属性`name`，
`sal`，`birthday`(`MyDate`类型)，其中`birthday`为`MyDate`类型（
属性包括：`year`、`month`、`day`）。要求：
1. 创建3个`Employee`对象放入`HashSet`中
2. 当`name`和`birthday`的值相同时，认为是相同员工，不能添加到`HashSet`集合中。
 */
class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}

class Employee {
    private String name;
    private double sal;
    private MyDate myDate;

    public Employee(String name, double sal, MyDate myDate) {
        this.name = name;
        this.sal = sal;
        this.myDate = myDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getMyDate() {
        return myDate;
    }

    public void setMyDate(MyDate myDate) {
        this.myDate = myDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", myDate=" + myDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(myDate, employee.myDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, myDate);
    }
}