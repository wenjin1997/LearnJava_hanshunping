/**
 * @author 文进
 * @version 1.0
 */
public class Homework06 {
    public static void main(String[] args) {
        int times = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 5 != 0) {
                System.out.print(i + "\t");
                times ++;
            }
            if (times == 5) {
                System.out.println("");
                times = 0;
            }
        }
    }
}
