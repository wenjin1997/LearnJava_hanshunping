package com.jinjin.homework.homework04;

public class Worker extends Employee{
    public Worker(String name, double salaryPerDay, int workDays, double grade) {
        super(name, salaryPerDay, workDays, grade);
    }

    //员工方法：打印工资
    public void showSalary() {
        System.out.print("普通员工\t" );
        super.showSalary();
    }
}
