package com.jinjin.generic;

/**
 * @author 文进
 * @version 1.0
 */

public class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }


    @Override
    public int compareTo(MyDate o) {
        if (year != o.getYear()) {
            return year - o.getYear();
        }
        if (month != o.getMonth()) {
            return month - o.getMonth();
        }
        if (day != o.getDay()) {
            return day - o.getDay();
        }
        return 0;
    }
}

