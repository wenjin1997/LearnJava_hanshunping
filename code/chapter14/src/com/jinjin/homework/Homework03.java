package com.jinjin.homework;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 文进
 * @version 1.0
 */
public class Homework03 {
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("jack", 650);
        m.put("tom", 1200);
        m.put("smith",2900);
        System.out.println(m);

        System.out.println("----将jack的工资更改为2600----");
//        m.replace("jack",2600);
        m.put("jack", 2600);
        System.out.println(m);

        System.out.println("----将所有员工工资加薪100----");
        Set keySet = m.keySet();
        for (Object key : keySet) {
            m.put(key, (Integer)m.get(key) + 100);
        }
        System.out.println(m);

        //遍历集合中所有员工
        System.out.println("----遍历员工----");
        Set set = m.keySet();
        for (Object o : set) {
            System.out.println(o + "-" + m.get(o));
        }

        //遍历集合中所有的工资
        System.out.println("----遍历工资----");
        Collection values = m.values();
        for (Object o : values) {
            System.out.println(o);
        }


    }
}
