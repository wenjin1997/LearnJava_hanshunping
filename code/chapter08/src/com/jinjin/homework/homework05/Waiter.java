package com.jinjin.homework.homework05;

public class Waiter extends Employee{
    public Waiter(String name, double salPerMon) {
        super(name, salPerMon);
    }

    //打印全全年工资
    public void showSal() {
        System.out.print("服务生\t");
        super.showSal();
    }
}
