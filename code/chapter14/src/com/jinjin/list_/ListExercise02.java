package com.jinjin.list_;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * @author 文进
 * @version 1.0
 */
public class ListExercise02 {
    public static void main(String[] args) {
//      List list = new ArrayList();
        List list = new Vector();
//      List list = new LinkedList();
        list.add(new Book("红楼梦", 90, "曹雪芹"));
        list.add(new Book("西游记", 70, "吴承恩"));
        list.add(new Book("水浒传", 80, "施耐庵"));
        sort(list);
        for (Object o : list) {
            System.out.println(o);
        }

    }

    public static void sort(List list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                Book book1 = (Book) list.get(j);
                Book book2 = (Book) list.get(j + 1);
                if (book1.getPrice() > book2.getPrice()) {
                    list.set(j + 1, book1);
                    list.set(j, book2);
                }
            }
        }
    }
}

class Book {
    private String name;
    private double price;
    private String author;

    public Book(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "名称：" + name + "\t\t\t价格：" + price + "\t\t\t作者：" + author;
    }
}