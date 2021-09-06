package com.jinjin.generic;

import java.util.*;

/**
 * @author 文进
 * @version 1.0
 */
public class GenericExercise {
    public static void main(String[] args) {
        Student student1 = new Student("小米", 20);
        Student student2 = new Student("小明", 16);
        Student student3 = new Student("小红", 18);

        HashSet<Student> set = new HashSet<>();
        set.add(student1);
        set.add(student2);
        set.add(student3);
        //遍历
        System.out.println("---增强for遍历---");
        for (Student student : set) {
            System.out.println(student);
        }

        System.out.println("---迭代器遍历---");
        Iterator<Student> iterator = set.iterator();
        while (iterator.hasNext()) {
            Student next =  iterator.next();
            System.out.println(next);
        }


        HashMap<String, Student> map = new HashMap<>();
        map.put(student1.getName(), student1);
        map.put(student2.getName(), student2);
        map.put(student3.getName(), student3);
        System.out.println(map);

        //keySet遍历
        System.out.println("----keySet遍历----");
        Set<String> strings = map.keySet();
        for (String s :strings) {
            System.out.println(s + "-" + map.get(s));
        }

        //entrySet遍历
        System.out.println("----entrySet遍历----");
        Set<Map.Entry<String, Student>> entries = map.entrySet();
        for (Map.Entry entry : entries) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }


    }
}

/**
 * 创建  3个学生对象
 * 放入到HashSet中学生对象, 使用.
 * 放入到  HashMap中，要求 Key 是 String name, Value 就是 学生对象
 * 使用两种方式遍历
 */
class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
