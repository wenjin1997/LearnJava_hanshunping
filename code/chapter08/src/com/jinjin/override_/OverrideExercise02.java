package com.jinjin.override_;

public class OverrideExercise02 {
    public static void main(String[] args) {
        Person person = new Person("Tom",20);
        System.out.println(person.say());
        Student student = new Student("jack",22,202001,80);
        System.out.println(student.say());
    }
}
