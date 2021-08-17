package com.jinjin.wrapper;

/**
 * @author 文进
 * @version 1.0
 */
public class WrapperVSString {
    public static void main(String[] args) {
        //包装类(Integer)->String
        Integer i = 100; //自动装箱
        //方式1
        String str = i + "";//这种情况下，i的类型不会改变
        //方式2
        String str2 = i.toString(); //Integer有toString()方法
        //方式3
        /*
        public static String valueOf(Object obj) {
            return (obj == null) ? "null" : obj.toString();
        }
         */
        String str3 = String.valueOf(i);

        //String -> 包装类(Integer)
        String str4 = "12345";
        Integer i1 = Integer.parseInt(str4);//使用到自动装箱
        Integer i3 = new Integer(str4);//构造器

        System.out.println("ok~~");

    }
}
