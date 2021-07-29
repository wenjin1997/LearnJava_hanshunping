package com.jinjin.homework.homework05;

/*
设计父类——员工类。子类：工人类(Worker)、农民类(Peasant)、
教师类(Teacher)、科学家类(Scientist)、服务生类(Waiter)。
1. 其中工人、农民、服务生只有基本工资sal
2. 教师除基本工资外，还有课酬（元/天）classDay,classSal
3. 科学家除基本工资外，还有年终奖bonus
4. 编写一个测试类，将各种类型的员工的全年工资打印出来
 */
public class homework05 {
    public static void main(String[] args) {
        Worker worker = new Worker("小明", 5500);
        worker.showSal();

        Peasant peasant = new Peasant("小李", 1000);
        peasant.showSal();

        Teacher teacher = new Teacher("小张", 5000);
        teacher.setClassDay(200);
        teacher.setClassSal(300);
        teacher.showSal();

        Scientist scientist = new Scientist("小吴", 6000);
        scientist.setBonus(200000);
        scientist.showSal();

        Waiter waiter = new Waiter("小鱼", 5000);
        waiter.showSal();
    }

}
