package com.jinjin;

/**
 * @author 文进
 * @version 1.0
 */
public class CpuNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        //获取当前电脑的cpu数量
        int cpuNum = runtime.availableProcessors();
        System.out.println(cpuNum); //4，有4核
    }
}
