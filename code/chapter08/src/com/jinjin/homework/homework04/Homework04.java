package com.jinjin.homework.homework04;

/*
通过继承实现员工工资核算打印功能：
父类：员工类(Employee)
子类：部门经理类(Manager)、普通员工类(Worker)
1. 部门经理工资 = 1000+单日工资 \* 天数 * 等级(1.2)
2. 普通员工工资 = 单日工资 \* 天数 * 等级(1.0)
3. 员工属性：姓名、单日工资、工作天数
4. 员工方法：打印工资
5. 普通员工及部门经理都是员工子类，需要重写打印工资方法。
6. 定义并初始化普通员工对象，调用打印工资方法输出工资，定义并初始化部门经理对象，调用打印工资方法输出工资。
 */
public class Homework04 {
    public static void main(String[] args) {
        Worker worker = new Worker("jack", 100, 30, 1.0);
        worker.showSalary();
        Manager manager = new Manager("smith", 100, 50, 1.2);
        manager.setBonus(1000);
        manager.showSalary();
    }
}
