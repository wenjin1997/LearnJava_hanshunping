package com.jinjin.codeblock_;

public class CodeBlock01 {
    public static void main(String[] args) {
        Movie movie = new Movie("你好，李焕英");
        System.out.println("============");
        Movie movie2 = new Movie("唐人街探案3", 100);
    }
}

class Movie {
    private String name;
    private int price;
    private String director;

    {
        System.out.println("电影屏幕打开...");
        System.out.println("广告开始...");
        System.out.println("电影正式开始...");
    }

    public Movie(String name) {
        System.out.println("Movie(String name)被调用...");
        this.name = name;
    }

    public Movie(String name, int price) {
        System.out.println("Movie(String name, int price)被调用...");
        this.name = name;
        this.price = price;
    }

    public Movie(String name, int price, String director) {
        System.out.println("Movie(String name, int price, String director)被调用...");
        this.name = name;
        this.price = price;
        this.director = director;
    }
}
