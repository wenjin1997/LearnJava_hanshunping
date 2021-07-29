package com.jinjin.homework;

public class Homework01 {
    public static void main(String[] args) {
        Person[] persons = new Person[3];
        persons[0] = new Person("Jack", 10, "cook");
        persons[1] = new Person("Mary", 30, "teacher");
        persons[2] = new Person("Alice", 23, "student");

        //输出当前对象数组
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]); //默认对象的.toString()
        }

        //使用冒泡排序
        Person temp = null; //临时变量，用于交换
        for (int i = 0; i < persons.length; i++) {
            for (int j = 0; j < persons.length - 1 - i; j++) {
                if (persons[j].getAge() < persons[j+1].getAge()) {
                    temp = persons[j];
                    persons[j] = persons[j+1];
                    persons[j+1] = temp;
                }
            }
        }

        //输出排序后对象数组
        System.out.println("数组按照年龄排序：");
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]); //默认对象的.toString()
        }
    }
}

/*
定义一个Person类{name, age, job}，初始化Person对象数组，
有3个person对象，并按照age从大到小进行排序，提示，使用冒泡排序
 */
class Person {
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
