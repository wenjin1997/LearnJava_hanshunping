package com.jinjin.homework.homework05;

public class Worker extends Employee{
    public Worker(String name, double salPerMon) {
        super(name, salPerMon);
    }

    //打印全全年工资
    public void showSal() {
        System.out.print("工人\t\t");
        super.showSal();
    }
}
