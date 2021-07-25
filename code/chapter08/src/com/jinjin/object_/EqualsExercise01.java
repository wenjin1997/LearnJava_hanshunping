package com.jinjin.object_;

public class EqualsExercise01 {
    public static void main(String[] args) {
        Person p1 = new Person("mary",10, '女');
        Person p2 = new Person("mary",10, '女');
        System.out.println(p1.equals(p2));
    }
}

/*
重写equals方法：
判断两个Person对象的内容是否相等，如果两个Person对象的各个属性值都一样，
则返回true，反之false。
 */
class Person {
    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    //重写Object 的 equals 方法
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if(obj instanceof Person) {//是Person,才进行比较
            Person aPerson = (Person)obj; // 向下转型
            return aPerson.age == this.age &&
                    aPerson.name.equals(this.name) &&
                    aPerson.gender == this.gender;
        }
        return false;
    }
}
