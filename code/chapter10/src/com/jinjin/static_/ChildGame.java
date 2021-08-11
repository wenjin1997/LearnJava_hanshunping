package com.jinjin.static_;

public class ChildGame {
    public static void main(String[] args) {
        Child child1 = new Child("红孩儿");
        child1.join();
        child1.count++;

        Child child2 = new Child("猪八戒");
        child2.join();
        child2.count++;

        Child child3 = new Child("孙悟空");
        child3.join();
        child3.count++;

        System.out.println("共有" + Child.count + "个小孩加入游戏。");

    }
}

class Child {
    private String name;
    //类变量count，统计有多少小孩加入游戏
    public static int count = 0;

    public Child(String name) {
        this.name = name;
    }

    public void join() {
        System.out.println(name + " 加入游戏...");
    }
}
