package com.jinjin.interface_;

public class ExtendsVsInterface {
    public static void main(String[] args) {
        LittleMonkey wukong = new LittleMonkey("悟空");
        wukong.climbing();
        wukong.flying();
        wukong.swimming();
    }
}

class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //猴子会爬树
    public void climbing() {
        System.out.println(name + " 会爬树...");
    }
}

class LittleMonkey extends Monkey implements Birdable,Fishable{
    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void flying() {
        System.out.println(getName() + " 通过学习，会像鸟儿一样飞翔...");
    }

    @Override
    public void swimming() {
        System.out.println(getName() + " 通过学习，会像鱼儿一样游泳...");
    }
}

interface Birdable {
    void flying();
}

interface Fishable {
    void swimming();
}