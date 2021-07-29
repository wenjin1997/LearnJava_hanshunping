package com.jinjin.homework.homework05;

public class Teacher extends Employee{
    private int classDay;
    private double classSal;

    public Teacher(String name, double salPerMon) {
        super(name, salPerMon);
    }

    public int getClassDay() {
        return classDay;
    }

    public void setClassDay(int classDay) {
        this.classDay = classDay;
    }

    public double getClassSal() {
        return classSal;
    }

    public void setClassSal(double classSal) {
        this.classSal = classSal;
    }

    //打印全全年工资
    public void showSal() {
        System.out.print("教师\t\t");
        System.out.println(getName() + "\t全年工资 " +
                (getSalPerMon() * getSalMonth() + classSal * classDay));
    }
}
