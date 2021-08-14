package com.jinjin.enum_.enum2;

/**
 * @author 文进
 * @version 1.0
 */
public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.AUTUMN);
    }
}

//自定义枚举实现
class Season {
    private String name;
    private String desc; //描述

    //定义四个对象，固定
    public static final Season SPRING= new Season("春天", "温暖");
    public static final Season SUMMER= new Season("夏天", "炎热");
    public static final Season AUTUMN= new Season("秋天", "凉爽");
    public static final Season WINNER= new Season("冬天", "炎热");

    //1. 将构造器私有化,目的防止 直接 new
    //2. 去掉setXxx方法, 防止属性被修改
    //3. 在Season 内部，直接创建固定的对象
    //4. 优化，可以加入 final 修饰符
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
