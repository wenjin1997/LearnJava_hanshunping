package com.jinjin.poly_.polyparameter;

public class Worker extends Employee{
    public Worker(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double getAnnual() {
        return super.getAnnual();
    }

    // 特有的方法
    public void work() {
        System.out.println("普通工人" + getName() + "正在工作...");
    }
}
