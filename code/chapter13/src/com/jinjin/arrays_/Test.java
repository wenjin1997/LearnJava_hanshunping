package com.jinjin.arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 文进
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Integer[] arrs = {1, 0, 2, 9, -1, -10};
//        bubble01(arrs);
        bubble02(arrs, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                return i2 - i1;
            }
        });
        System.out.println(Arrays.toString(arrs));

    }

    public static void bubble01(Integer[] arrs) {
        for (int i = 0; i < arrs.length - 1; i++) {
            int temp = 0;
            for (int j = 0; j < arrs.length - 1 - i; j++) {
                //从小到大排序
                if (arrs[j] > arrs[j+1]) {
                    temp = arrs[j+1];
                    arrs[j+1] = arrs[j];
                    arrs[j] = temp;
                }
            }
        }
    }

    public static void bubble02(Integer[] arrs, Comparator c) {
        for (int i = 0; i < arrs.length - 1; i++) {
            int temp = 0;
            for (int j = 0; j < arrs.length - 1 - i; j++) {
                //从小到大排序
                if (c.compare(arrs[j], arrs[j+1]) > 0) {
                    temp = arrs[j+1];
                    arrs[j+1] = arrs[j];
                    arrs[j] = temp;
                }
            }
        }
    }
}
