package com.jinjin.homework.homework04;

/*
3. 员工属性：姓名、单日工资、工作天数
4. 员工方法：打印工资
 */
public class Employee {
    private String name;
    private double salaryPerDay;
    private int workDays;
    private double grade;

    public Employee(String name, double salaryPerDay, int workDays, double grade) {
        this.name = name;
        this.salaryPerDay = salaryPerDay;
        this.workDays = workDays;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalaryPerDay() {
        return salaryPerDay;
    }

    public void setSalaryPerDay(double salaryPerDay) {
        this.salaryPerDay = salaryPerDay;
    }

    public int getWorkDays() {
        return workDays;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }


    //员工方法：打印工资
    public void showSalary() {
        System.out.println("姓名：" + name + "\t单日工资：" + salaryPerDay
        + "\t工作天数：" + workDays + "\t工资：" + salaryPerDay * workDays * grade);
    }

}
