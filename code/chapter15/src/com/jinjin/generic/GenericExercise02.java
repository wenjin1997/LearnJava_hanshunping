package com.jinjin.generic;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author 文进
 * @version 1.0
 */
public class GenericExercise02 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("王桂花", 20000, new MyDate(1996, 5, 20)));
        employees.add(new Employee("王桂花", 10000, new MyDate(2000, 3, 10)));
        employees.add(new Employee("谢小烦", 50000, new MyDate(1997, 10, 30)));

        System.out.println(employees);

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                int nameCompare = e1.getName().compareTo(e2.getName());
                if (nameCompare != 0) {
                    return nameCompare;
                }
                return e1.getBirthday().compareTo(e2.getBirthday());
            }
        });

        System.out.println("----排序后----");
        //遍历输出
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}