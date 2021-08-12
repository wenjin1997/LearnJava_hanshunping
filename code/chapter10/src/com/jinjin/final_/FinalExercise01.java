package com.jinjin.final_;

public class FinalExercise01 {
    public static void main(String[] args) {
        Circle circle = new Circle(1);
        System.out.println(circle.showArea());
    }
}
class Circle {
    private double radius;
    private final double PI = 3.14;
//  private final double PI;

//    {
//        PI = 3.14;
//    }

    public Circle(double radius) {
//        PI = 3.14;
        this.radius = radius;
    }

    public double showArea() {
        return PI * radius * radius;
    }
}
