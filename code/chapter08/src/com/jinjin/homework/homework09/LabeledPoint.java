package com.jinjin.homework.homework09;

/*
设计一个Point类，其x和y坐标可以通过构造器提供。
提供一个子类LabeledPoint，其构造器接受一个标签值和x,y坐标，
比如:`new LabeledPoint("Black", 1929, 230.07)`，写出对应的构造器即可。
 */
public class LabeledPoint extends Point{
    private String label; // 标签值

    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }
}
