/**
 * @author 文进
 * @version 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {56, 32, 21, 5678, 12, 333};
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                     temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("====冒泡排序后的数组====");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
