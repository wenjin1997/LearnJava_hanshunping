package com.jinjin.arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 文进
 * @version 1.0
 */
public class ArraysExercise {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅新", 90);
        books[2] = new Book("青年文摘20年", 5);
        books[3] = new Book("java从入门到放弃", 300);


//       //自己写的定制排序方法，也可以直接调用Arrays.sort()
//        compareName(books, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                int i1 = (Integer) o1;
//                int i2 = (Integer) o2;
//                return i2 - i1;
//            }
//        });

        //使用Arrays.sort()
        //1. 按照price从大到小排序
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                double priceValue = book1.getPrice() - book2.getPrice();
                if (priceValue > 0) {
                    return -1;
                } else if (priceValue < 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });


        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }
    }

    //定制排序,按照价格排序
    public static void compare(Book[] books, Comparator c) {
        for (int i = 0; i < books.length - 1; i++) {
            Book temp;
            for (int j = 0; j < books.length - 1 - i; j++) {
                if (c.compare(books[j].getPrice(), books[j+1].getPrice()) > 0) {
                    temp = books[j+1];
                    books[j+1] = books[j];
                    books[j] = temp;
                }
            }
        }
    }

    //按照书名长度进行排序
    public static void compareName(Book[] books, Comparator c) {
        for (int i = 0; i < books.length - 1; i++) {
            Book temp;
            for (int j = 0; j < books.length - 1 - i; j++) {
                if (c.compare(books[j].getName().length(), books[j+1].getName().length()) > 0) {
                    temp = books[j+1];
                    books[j+1] = books[j];
                    books[j] = temp;
                }
            }
        }
    }

}

/**
 * 自定义Book类，里面包含name和price，按price排序（从大到小）。
 * 要求使用两种方式排序，有一个`Book[] books = 4本书对象`。
 *
 * 使用前面学过的传递实现`Comparator`接口匿名内部类，也称为定制排序，
 * 可以按照价格从大到小、价格从小到大、书名长度从大到小排序。
 */
class Book {
    private String name;
    private double price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
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

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
