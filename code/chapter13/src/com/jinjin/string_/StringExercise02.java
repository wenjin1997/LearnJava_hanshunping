package com.jinjin.string_;

/**
 * @author 文进
 * @version 1.0
 */
public class StringExercise02 {
    public static void main(String[] args) {
        String a = new String("abc");
        String b =new String("abc");
        System.out.println(a.equals(b));//T
        System.out.println(a==b); //F
    }
}
