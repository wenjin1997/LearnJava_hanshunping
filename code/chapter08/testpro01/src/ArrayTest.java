import java.util.Scanner;

public class ArrayTest {
    public static void main(String[] args) {
        MyTools mt = new MyTools();
        Scanner myScanner = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        int n = 1 + 2 * 7;
        int[] arr = {10, -2, 12, 34};
        mt.bubble(arr);
        //输出排序后的arr，引用传递
        System.out.println("====排序后的arr===");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}

//创建一个类MyTools,编写一个方法，可以完成对int数组冒泡排序的功能
//要求从小到大
class MyTools {
    public void bubble(int[] arr) {
        //冒泡排序
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

class Person {
    String name;
    int age;
    //构造器-快捷键 command + N
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
