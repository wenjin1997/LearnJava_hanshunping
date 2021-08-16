package com.jinjin.homework.homework02;

/**
 * @author 文进
 * @version 1.0
 */
public class TestFrock {
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());

        System.out.println("===============");
        Frock[] frocks = new Frock[3];
        for (int i = 0; i < frocks.length; i++) {
            frocks[i] = new Frock();
            System.out.println(frocks[i].getSerialNumber());
        }
    }
}
