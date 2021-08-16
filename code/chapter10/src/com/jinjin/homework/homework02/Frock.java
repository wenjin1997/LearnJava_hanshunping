package com.jinjin.homework.homework02;

/**
 * @author 文进
 * @version 1.0
 */
public class Frock {
    private int serialNumber;
    private static int currentNum = 100000; //衣服出厂的序列号起始值

    public Frock() {
        this.serialNumber = getNextNum();
    }

    public static int getNextNum() {
        currentNum += 100;
        return currentNum;
    }

    public int getSerialNumber() {
        return serialNumber;
    }
}
