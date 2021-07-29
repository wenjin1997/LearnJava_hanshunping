package com.jinjin.homework.homework05;

public class Employee {
    private String name;
    private double salPerMon; //每月工资
    private int salMonth = 12; //带薪月份

    public Employee(String name, double salPerMon) {
        this.name = name;
        this.salPerMon = salPerMon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalPerMon() {
        return salPerMon;
    }

    public void setSalPerMon(double salPerMon) {
        this.salPerMon = salPerMon;
    }

    public int getSalMonth() {
        return salMonth;
    }

    public void setSalMonth(int salMonth) {
        this.salMonth = salMonth;
    }

    //打印全全年工资
    public void showSal() {
        System.out.println(name + "\t全年工资 " + (salPerMon * salMonth));
    }
}
