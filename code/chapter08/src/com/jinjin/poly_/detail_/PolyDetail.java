package com.jinjin.poly_.detail_;

public class PolyDetail {
    public static void main(String[] args) {
        Animal animal = new Cat();
        Object obj = new Cat();

        animal.eat();
        animal.run();
        animal.show();
        animal.sleep();

    }
}

