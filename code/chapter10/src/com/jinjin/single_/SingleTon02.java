package com.jinjin.single_;

public class SingleTon02 {
    public static void main(String[] args) {
        Cat cat1 = Cat.getInstance();
        System.out.println(cat1);

        Cat cat2 = Cat.getInstance();
        System.out.println(cat2);

        System.out.println(cat1 == cat2);
    }
}

class Cat {
    private String name;

    //单例模式-懒汉式
    private static Cat cat;

    private Cat(String name) {
        this.name = name;
    }

    public static Cat getInstance() {
        if (cat == null) {
            cat = new Cat("小花花");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
