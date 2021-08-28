package com.jinjin.list_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 文进
 * @version 1.0
 */
public class ListExercise {
    public static void main(String[] args) {
        /**
         * 添加10个以上的元素（比如`String "hello"`），
         * 在2号位插入一个元素"进进"，获得第5个元素，删除第6个元素，
         * 修改第7个元素，再使用迭代器遍历集合，要求：使用`List`实现类`ArrayList`完成。
         */
        List list = new ArrayList();
        for (int i = 0; i < 15; i++) {
            list.add("hello" + i);
        }
        System.out.println("list=" + list);

        list.add(1, "进进");
        System.out.println("list=" + list);

        System.out.println(list.get(4));

        list.remove(5);
        System.out.println("list=" + list);

        list.set(6, "jinjin");
        System.out.println("list=" + list);

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println("obj=" + obj);
        }
    }
}
