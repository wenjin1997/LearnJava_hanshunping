package com.jinjin.homework.homework05;

public class Scientist extends Employee{
    private double bonus;

    public Scientist(String name, double salPerMon) {
        super(name, salPerMon);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void showSal() {
        System.out.print("科学家\t");
        System.out.println(getName() + "\t全年工资 " +
                (getSalPerMon() * getSalMonth() + bonus));
    }
}
