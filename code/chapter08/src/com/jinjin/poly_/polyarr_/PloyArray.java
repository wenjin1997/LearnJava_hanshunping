package com.jinjin.poly_.polyarr_;

public class PloyArray {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("jack", 10);
        persons[1] = new Student("marry",22, 100);
        persons[2] = new Student("tom",22, 80);
        persons[3] = new Teacher("alice",30,20000);
        persons[4] = new Teacher("king",33,25000);

        //遍历多态数组，调用say
        for (int i = 0; i < persons.length; i++) {
            //person[i]编译类型是Person,运行类型是根据实际情况有JVM来判断
            System.out.println(persons[i].say());//动态绑定机制

            //使用 类型判断 + 向下转型
            if(persons[i] instanceof Student) {//判断person[i]的运行类型是不是Student
                ((Student)persons[i]).study();//向下转型
            } else if(persons[i] instanceof Teacher) {
                ((Teacher)persons[i]).teach();//向下转型
            } else if(persons[i] instanceof Person) {

            } else {
                System.out.println("你的类型有误，请自己检查...");
            }
        }
    }
}
