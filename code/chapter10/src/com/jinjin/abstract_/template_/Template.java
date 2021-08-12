package com.jinjin.abstract_.template_;

public abstract class Template {
    public abstract void job();

    public void calculateTime() {
        long start = System.currentTimeMillis();
        job();//动态绑定机制
        long end = System.currentTimeMillis();
        System.out.println("任务运行时间 " + (end - start));
    }
}
