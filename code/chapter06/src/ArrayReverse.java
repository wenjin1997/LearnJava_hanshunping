/**
 * @author 文进
 * @version 1.0
 */
public class ArrayReverse {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44, 55, 66, 77};
        int temp = 0;
        for (int i = 0; i < arr.length/2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

        for (Integer integer : arr) {
            System.out.print(integer);
            System.out.print(" ");
        }

    }
}
