package com.jinjin.homework;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 文进
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) {
        Car car = new Car("宝马", 400000);
        Car car2 = new Car("宾利", 5000000);
        ArrayList arrayList = new ArrayList();
        arrayList.add(car);
        arrayList.add(car2);
        System.out.println("添加元素后arrayList= " + arrayList);

        arrayList.remove(car);
        System.out.println("删除元素后arrayList= " + arrayList);

        System.out.println("contains car2? " + arrayList.contains(car2));
        System.out.println("arrayList size = " + arrayList.size());
        System.out.println("is arrayList empty ? " + arrayList.isEmpty());
        arrayList.clear();
        System.out.println("is arrayList empty ? " + arrayList.isEmpty());

        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(car);
        arrayList2.add(car2);

        arrayList.addAll(arrayList2);
        System.out.println("addAll之后，arrayList=" + arrayList);

        arrayList.add("元素");
        System.out.println("查找arrayList2是否存在？" + arrayList.containsAll(arrayList2));

        arrayList.removeAll(arrayList2);
        System.out.println("删除多个元素arrayList2后arrayList= " + arrayList);

        arrayList.add(car);
        arrayList.add(car2);
        arrayList.remove("元素");

        System.out.println("----增强for遍历----");
        for (Object o : arrayList) {
            Car cars = (Car) o;
            System.out.println(cars);
        }

        System.out.println("----迭代器遍历----");
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            Car cars = (Car) next;
            System.out.println(cars);
        }


    }
}

class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
