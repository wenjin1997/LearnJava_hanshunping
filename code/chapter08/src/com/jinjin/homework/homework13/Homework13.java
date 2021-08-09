package com.jinjin.homework.homework13;

public class Homework13 {
    public static void main(String[] args) {
        // 测试
        Teacher teacher = new Teacher("rose1", '女', 38, 10);
        teacher.printInfo();
        Student student = new Student("jack1", '男', 28, "202001");
        System.out.println("-------------");
        student.printInfo();


        Person[] persons = new Person[4];
        persons[0] = new Student("jack", '男', 28, "202001");
        persons[1] = new Student("marry", '女', 20, "202002");
        persons[2] = new Teacher("rose", '女', 38, 10);
        persons[3] = new Teacher("kitty", '女', 40, 12);

        Homework13 homework13 = new Homework13();
        homework13.sort(persons);
        System.out.println("排序后的数组：");
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
        }

        //遍历多态数组
        for (int i = 0; i < persons.length; i++) {
            homework13.test(persons[i]);
        }

//        Homework13 h = new Homework13();
//        // 按照年龄排序
//        h.sort(persons);
//        h.showInfo(persons[0]);
//        System.out.println("-----------------");
//        h.showInfo(persons[1]);
//        System.out.println("-----------------");
//        h.showInfo(persons[2]);
//        System.out.println("-----------------");
//        h.showInfo(persons[3]);
    }

    // 按照年龄从高到低排序
    // 冒泡排序
    public void sort(Person[] persons) {
        Person temp = null;
        for (int i = 0; i < persons.length - 1; i++) {
            for (int j = 0; j < persons.length - i - 1; j++) {
                if (persons[j].getAge() < persons[j + 1].getAge()) {
                    temp = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = temp;
                }
            }
        }
    }

    //定义方法, 形参为Person类型，功能：调用学生的study或教师的teach
    public void test(Person p) {
        if (p instanceof Student) {
            ((Student)p).study();
        } else if (p instanceof Teacher) {
            ((Teacher) p).teach();
        } else {
            System.out.println("do nothing...");
        }
    }

//    // 展示信息
//    public void showInfo(Person p) {
//        if (p instanceof Student) {
//            Student s = (Student) p;
//            System.out.println("学生的信息：");
//            System.out.println("姓名：" + s.getName());
//            System.out.println("年龄：" + s.getAge());
//            System.out.println("性别：" + s.getSex());
//            System.out.println("学号：" + s.getStu_id());
//            s.study();
//            System.out.println(s.play());
//        }
//
//        if (p instanceof Teacher) {
//            Teacher t = (Teacher) p;
//            System.out.println("老师的信息：");
//            System.out.println("姓名：" + t.getName());
//            System.out.println("年龄：" + t.getAge());
//            System.out.println("性别：" + t.getSex());
//            System.out.println("工龄：" + t.getWork_age());
//            t.teach();
//            System.out.println(t.play());
//        }
//    }
}
