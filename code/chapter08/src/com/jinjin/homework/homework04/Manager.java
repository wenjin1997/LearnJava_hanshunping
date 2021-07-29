package com.jinjin.homework.homework04;

public class Manager extends Employee{
    //特有属性
    private double bonus;

    public Manager(String name, double salaryPerDay, int workDays, double grade) {
        super(name, salaryPerDay, workDays, grade);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    //员工方法：打印工资
    public void showSalary() {
        System.out.print("经理\t\t" );
        System.out.println("姓名：" + getName() + "\t单日工资：" + getSalaryPerDay()
                + "\t工作天数：" + getWorkDays() + "\t工资：" +
                (bonus + getWorkDays() * getSalaryPerDay() * getGrade()));
    }
}
