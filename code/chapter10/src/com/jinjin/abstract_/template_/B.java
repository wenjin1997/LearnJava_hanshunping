package com.jinjin.abstract_.template_;

public class B extends Template{
    @Override
    public void job() {
        long ans = 0;
        for (long i = 1; i <= 100000; i++) {
            ans += Math.sqrt(i);
        }
    }
}
