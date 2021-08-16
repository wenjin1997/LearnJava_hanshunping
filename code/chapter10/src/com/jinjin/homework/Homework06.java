package com.jinjin.homework;

import com.jinjin.abstract_.template_.B;

/**
 * @author 文进
 * @version 1.0
 */
public class Homework06 {
    public static void main(String[] args) {
        Person tang = new Person("唐僧", new Horse());
        tang.common();
        tang.passRiver();
        tang.common();
        tang.passRiver();
        tang.passFireHill();
        tang.passFireHill();
    }
}

/**
 * 1. 有一个交通工具接口类Vehicles，有work接口
 * 2. 有Horse类和Boat类分别实现Vehicles
 * 3. 创建交通工具工厂类。有两个方法分别获得交通工具Horse和Boat
 * 4. 有Person类，有name和Vehicles属性，在构造器中为两个属性赋值
 * 5. 实例化Person对象"唐僧"，要求一般情况下用Horse作为交通工具，遇到大河时用Boat作为交通工具
 * 6. 使用代码实现上面的要求
 * 7. 增加一个交通工具 飞机，在过火焰山时使用飞机
 */

interface Vehicles {
    void work();
}

class Horse implements Vehicles {
    @Override
    public void work() {
        System.out.println("一般情况下，使用马儿...");
    }
}

class Boat implements Vehicles {
    @Override
    public void work() {
        System.out.println("遇到河流，使用小船...");
    }
}

//增加交通工具飞机，体会程序的扩展性
class AirPlane implements Vehicles {
    @Override
    public void work() {
        System.out.println("遇到火焰山，使用飞机...");
    }
}

class VehiclesFactory {
    //1. 为了方便直接调用，将makeHorse()和makeBoat()
    //   两个方法设置为static
    //2. 我们知道唐僧一直用的是同一匹马西天取经，
    //   那么这里不用每次都new一个Horse,这里使用饿汉式
    private static Horse horse = new Horse();
    public static Horse makeHorse() {
        return horse;
    }

    public static Boat makeBoat() {
        return new Boat();
    }

    //增加情况，制造飞机
    public static AirPlane makeAirPlane() {
        return new AirPlane();
    }
}

class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicles getVehicles() {
        return vehicles;
    }

    //一般情况下，使用马儿
    public void common() {
        //如果现在有的交通工具不是下列情况：
        //  1.马儿或马儿的子类
        //  2.没有马儿
        //才获取一批马。
        if (!(vehicles instanceof Horse)) {
            vehicles = VehiclesFactory.makeHorse(); //向上转型
        }
        vehicles.work();
    }

    //遇到河流，使用船只
    public void passRiver() {
        if (!(vehicles instanceof Boat)) {
            vehicles = VehiclesFactory.makeBoat(); //向上转型
        }
        vehicles.work();
    }

    //增加一种情况，遇到火焰山，使用飞机
    public void passFireHill() {
        if (!(vehicles instanceof AirPlane)) {
            vehicles = VehiclesFactory.makeAirPlane(); //向上转型
        }
        vehicles.work();
    }
}