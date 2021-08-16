package com.jinjin.homework;

/**
 * @author 文进
 * @version 1.0
 */
public class Homework04 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.testWork(new ICalculator() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        }, 12, 23);
    }
}


/**
 * 1. 计算器接口具有work方法，功能是运算，有一个手机类Cellphone，
 * 定义方法testWork测试计算功能，调用计算接口的work方法
 * 2. 要求调用CellPhone对象的testWork方法，使用上匿名内部类
 */
interface ICalculator { //计算器接口
    double work(double n1, double n2);
}

class Cellphone {
    public void testWork(ICalculator iCalculator, double n1, double n2) {
        double result = iCalculator.work(n1, n2); //动态绑定
        System.out.println("计算后的结果为 " + result);
    }
}
