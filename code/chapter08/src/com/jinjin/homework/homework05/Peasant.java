package com.jinjin.homework.homework05;

public class Peasant extends Employee{
    public Peasant(String name, double salPerMon) {
        super(name, salPerMon);
    }

    //打印全全年工资
    public void showSal() {
        System.out.print("农民\t\t");
        super.showSal();
    }
}
