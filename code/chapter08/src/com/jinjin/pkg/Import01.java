package com.jinjin.pkg;

// 需要使用到哪个类，就导入哪个包，不建议使用*导入
import java.util.Arrays;

public class Import01 {
    public static void main(String[] args) {
        int[] arr = {100, 90, -1, 20};
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
