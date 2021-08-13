package com.jinjin.interface_;

import com.jinjin.abstract_.template_.A;

public class Interface02 {
    public static void main(String[] args) {
        AA aa = new AA();
        aa.work();
    }
}

class AA implements AInterface {
    @Override
    public void work() {
        System.out.println("work...");
    }
}