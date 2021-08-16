package com.jinjin.homework;

/**
 * @author 文进
 * @version 1.0
 */
public class Homework07 {
    public static void main(String[] args) {
        Car car1 = new Car(-10);
        car1.getAir().flow();

        Car car2 = new Car(50);
        car2.getAir().flow();

        Car car3 = new Car(23);
        car3.getAir().flow();
    }
}

/**
 * 有一个Car类，有属性temperature(温度),车内有Air(空调)类，有吹风的功能flow，Air会监视车内的温度，
 * 如果温度超过40度则吹冷风。如果温度低于0度则吹暖风，如果在这之间则关掉空调。
 * 实例化具有不同温度的Car对象，调用空调的flow方法，测试空调吹的风是否正确。
 */

class Car {
    private double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
    }

    class Air {
        public void flow() {
            if (temperature > 40) {
                System.out.println("当前温度为："+ temperature +" 温度大于40，冷气...");
            } else if (temperature < 0) {
                System.out.println("当前温度为："+ temperature + " 温度小于0，暖气...");
            } else {
                System.out.println("当前温度为："+ temperature + " 温度正常，空调关闭");
            }
        }
    }

    public Air getAir() {
        return new Air();
    }
}
