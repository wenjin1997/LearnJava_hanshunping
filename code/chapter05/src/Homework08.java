/**
 * @author 文进
 * @version 1.0
 */
public class Homework08 {
    public static void main(String[] args) {
        double sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                sum -= 1.0/i;
            } else {
                sum += 1.0/i;
            }
//            System.out.println("i="+i + "sum=" + sum);
        }
        System.out.println("1-1/2+1/3-1/4.....1/100的和为" + sum);
    }
}
