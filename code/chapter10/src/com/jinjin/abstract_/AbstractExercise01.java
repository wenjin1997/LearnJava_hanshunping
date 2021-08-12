package com.jinjin.abstract_;

public class AbstractExercise01 {
    public static void main(String[] args) {
        CommonEmployee commonEmployee = new CommonEmployee("小张", 1, 1000);
        commonEmployee.work();

        Manager manager = new Manager("小李", 2, 10000);
        manager.work();
    }
}

