package com.jinjin.poly_.polyparameter;

public class PolyParameter {
    public static void main(String[] args) {
        Worker tom = new Worker("tom", 1000);
        Manager milan = new Manager("milan", 10000, 20000);
        PolyParameter polyParameter = new PolyParameter();
        polyParameter.showEmpAnnual(tom);
        polyParameter.testWork(tom);
        polyParameter.showEmpAnnual(milan);
        polyParameter.testWork(milan);
    }

    //测试类中添加一个方法showEmpAnnual(Employee e)，
    // 实现获取任何员工对象的年工资，并在main方法中调用该方法。
    public void showEmpAnnual(Employee e) {
        System.out.println(e.getAnnual());//动态绑定机制
    }

    //测试类中添加一个方法，testWork，如果是普通员工，则调用work方法，
    // 如果是经理，则调用manage方法。
    public void testWork(Employee e) {
        if (e instanceof Worker) {
            ((Worker) e).work();//向下转型
        } else if (e instanceof Manager) {
            ((Manager) e).manager();//向下转型
        } else {
            System.out.println("不做处理...");
        }
    }
}



