package com.jinjin.exception_;

/**
 * @author 文进
 * @version 1.0
 */
public class ArrayIndexOutOfBoundsException_ {
    public static void main(String[] args) {
        int[] arr = {1,2,4};
        for (int i = 0; i <= arr.length; i++) {//数组下标越界
            System.out.println(arr[i]);
        }
    }
}
