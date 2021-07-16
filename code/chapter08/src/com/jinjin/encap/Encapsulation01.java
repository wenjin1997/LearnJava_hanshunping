package com.jinjin.encap;

public class Encapsulation01 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("张三");
        person.setAge(23);
        person.setSalary(10000);
        System.out.println(person.info());
        Person smith = new Person("smith", 20, 20000);
        System.out.println(smith.info());

    }
}

/*
不能随便查看人的年龄，工资等隐私，并对设置的年龄进行合理的验证。
年龄合理就设置，否则给默认年龄，必须在1-120，年龄、工资不能直接查看，
name的长度在2-6个字符之间。
 */
class Person {
    private String name;
    private int age;
    private double salary;

    public Person() {
    }

    public Person(String name, int age, double salary) {
        setName(name);
        setAge(age);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() >= 2 && name.length() <= 6) {
            this.name = name;
        } else {
            System.out.println("设置的名字不对！必须在2-6个字符之间，默认名字为无名");
            this.name = "无名";
        }

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 1 && age <= 120) {
            this.age = age;
        }else {
            System.out.println("年龄设置的不对！需要在1-120之间，默认年龄18");
            this.age = 18;
        }

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        //可以在这里增加对当前对象的权限判断
        this.salary = salary;
    }

    public String info() {
        return "信息 姓名：" + name + " 年龄" + age + " 薪水" + salary;
    }
}
