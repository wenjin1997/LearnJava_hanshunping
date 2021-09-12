/**
 * @author 文进
 * @version 1.0
 */
public class Homework09 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= i; j++) {
                sum += j;
            }
        }
        System.out.println("1+(1+2)+...+(1+2+...+100)的和为" + sum);
    }
}
