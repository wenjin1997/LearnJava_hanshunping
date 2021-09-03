package com.jinjin.map_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 文进
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class MapExercise {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        Employee employee1 = new Employee(1, "小明", 20000);
        Employee employee2 = new Employee( 2,"小花", 10000);
        Employee employee3 = new Employee(3,"小白", 30000);
        hashMap.put(employee1.getId(),employee1);
        hashMap.put(employee2.getId(),employee2);
        hashMap.put(employee3.getId(),employee3);

        //遍历显示工资>180000的员工（遍历方式最少两种）
        //第一组：使用key
        Set set = hashMap.keySet();
        //(1)增强for
        System.out.println("----key 增强for----");
        for (Object key :set) {
            Employee e = (Employee) hashMap.get(key);
            if (e.getSal() > 18000) {
                System.out.println(e);
            }
        }
        //(2)迭代器
        System.out.println("----key 迭代器----");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object key =  iterator.next();
            Employee e = (Employee) hashMap.get(key);
            if (e.getSal() > 18000) {
                System.out.println(e);
            }
        }

        //第二组 使用EntrySet
        Set set1 = hashMap.entrySet();
        //(1) 增强for
        System.out.println("---EntrySet 增强for---");
        for (Object entry :set1) {
            Map.Entry m = (Map.Entry) entry;
            Employee e = (Employee) m.getValue();
            if (e.getSal() > 18000) {
                System.out.println(e);
            }
        }
        //(2)迭代器
        System.out.println("---EntrySet 迭代器---");
        Iterator iterator2 = set1.iterator();
        while (iterator2.hasNext()) {
            Object entry =  iterator2.next();
            Map.Entry m = (Map.Entry) entry;
            Employee e = (Employee) m.getValue();
            if (e.getSal() > 18000) {
                System.out.println(e);
            }
        }


    }
}

class Employee {
    private int id;
    private String name;
    private double sal;

    public Employee(int id, String name, double sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sal=" + sal +
                '}';
    }
}
