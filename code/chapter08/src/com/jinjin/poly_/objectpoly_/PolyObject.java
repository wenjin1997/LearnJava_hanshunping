package com.jinjin.poly_.objectpoly_;

public class PolyObject {
    public static void main(String[] args) {
        //体验多态的特点
        //animal编译类型就是 Animal，运行类型是Dog
        Animal animal = new Dog();
        //因为运行时，执行到该行时，animal运行类型是Dog，所以cry就是Dog的cry
        animal.cry();

        //animal编译类型就是 Animal，运行类型是 Cat
        animal = new Cat();
        animal.cry(); // 小猫喵喵叫
    }
}
