/**
 * @author 文进
 * @version 1.0
 */
public class Homework04 {
    public static void main(String[] args) {
        int[] arr = {10, 12, 45, 90};
        int insertNum = 900;
        int index = 0;
        int[] insertArr = new int[arr.length + 1];
        //定位插入元素的位置
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > insertNum) {
                index = i;
                break;
            }
        }
        //考虑插入的数最大
        if (arr[arr.length - 1] < insertNum) {
            index = arr.length;
        }

        //插入元素
        for (int i = 0; i < insertArr.length; i++) {
            if (i < index) {
                insertArr[i] = arr[i];
            } else if (i == index) {
                insertArr[i] = insertNum;
            } else {
                insertArr[i] = arr[i - 1];
            }
        }
        arr = insertArr;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
