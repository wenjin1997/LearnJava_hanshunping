import java.util.ArrayList;

/**
 * @author 文进
 * @version 1.0
 */
public class ArrayCopy {
    public static void main(String[] args) {
        int[] arr1 = {10, 20, 30};
        int[] copyArr = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            copyArr[i] = arr1[i];
        }

        for (Integer integer : arr1) {
            System.out.print(integer);
            System.out.print(" ");
        }
        System.out.println(" ");

        for (Integer integer : copyArr) {
            System.out.print(integer);
            System.out.print(" ");
        }

    }
}
