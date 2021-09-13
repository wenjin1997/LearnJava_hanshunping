import java.util.Scanner;

/**
 * @author 文进
 * @version 1.0
 */
public class ArrayAdd {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        do {
            int[] addArr = new int[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                addArr[i] = arr[i];
            }
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入你要添加的元素：");
            addArr[arr.length] = scanner.nextInt();
            arr = addArr;

            System.out.println("====扩容后的数组====");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }

            System.out.print("请问还需要添加元素吗?(y/n)");
            char choice = scanner.next().charAt(0);
            if (choice == 'n') {
                break;
            }
        } while (true);
        System.out.println("你退出了添加元素...");
    }
}
