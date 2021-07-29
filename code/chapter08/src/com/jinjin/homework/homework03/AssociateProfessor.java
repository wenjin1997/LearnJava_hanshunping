package com.jinjin.homework.homework03;

public class AssociateProfessor extends Teacher{
    public AssociateProfessor(String name, int age, String post, double salary, double grade) {
        super(name, age, post, salary, grade);
    }

    public void introduce() {
        System.out.print("副教授：");
        super.introduce();
    }
}
