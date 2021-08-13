package com.jinjin.interface_.interfacePoly;

public class InterfacePolyArr {
    public static void main(String[] args) {
        Usb[] usbs = new Usb[2];
        usbs[0] = new Phone();
        usbs[1] = new Camera();

        /*
        给Usb数组中，存放Phone和Camera对象，Phone类还有一个特有的方法call()，
        请遍历Usb数组，如果是Phone对象，除了调用接口Usb定义的方法外，
        还需要调用Phone特有的方法call
         */
        for (int i = 0; i < usbs.length; i++) {
            usbs[i].work();
            if (usbs[i] instanceof Phone) { //向下转型
                ((Phone) usbs[i]).call();
            }
        }
    }
}

interface Usb {
    void work();
}

class Phone implements Usb {
    @Override
    public void work() {
        System.out.println("手机工作中...");
    }

    //手机特有的方法
    public void call() {
        System.out.println("手机可以打电话");
    }
}

class Camera implements Usb {
    @Override
    public void work() {
        System.out.println("相机工作中...");
    }
}