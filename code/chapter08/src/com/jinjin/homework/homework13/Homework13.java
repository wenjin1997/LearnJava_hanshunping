package com.jinjin.homework.homework13;

public class Homework13 {
    public static void main(String[] args) {
        Person[] persons = new Person[4];
        persons[0]  = new Student("jack", '男',18,"202001");
        persons[1] = new Student("marry", '女',20,"202002");
        persons[2] = new Teacher("rose", '女',38,10);
        persons[3] = new Teacher("kitty", '女',40,12);

        // 按照年龄从高到低排序


        //showInfo(persons[0]);
        System.out.println(((Student)persons[1]).play());
        ((Teacher)persons[2]).teach();
        System.out.println(((Teacher)persons[3]).play());

    }

    public void showInfo(Person p) {
        if (p instanceof Student) {
            Student s = (Student) p;
            System.out.println("学生的信息：");
            System.out.println("姓名：" + s.getName());
            System.out.println("年龄：" + s.getAge());
            System.out.println("性别：" + s.getSex());
            System.out.println("学号" + s.getStu_id());
            s.study();
            System.out.println(s.play());
        }

        if (p instanceof Teacher) {
            Teacher t = (Teacher) p;
            System.out.println("老师的信息：");
            System.out.println("姓名：" + t.getName());
            System.out.println("年龄：" + t.getAge());
            System.out.println("性别：" + t.getSex());
            System.out.println("工龄" + t.getWork_age());
            t.teach();
            System.out.println(t.play());
        }
    }
}
