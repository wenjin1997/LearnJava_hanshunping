/**
 * @author 文进
 * @version 1.0
 */
public class ForExercise {
    public static void main(String[] args) {
        //打印1~100之间所有是9的倍数的整数，统计个数 及总和
        int sum = 0;
        int num = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 9 == 0) {
                System.out.println("i = " + i);
                num++;
                sum += i;
            }
        }
        System.out.println("1-100之间所有9的倍数整数有" + num + "个，其和为" + sum);
    }
}
