/**
 * @author 文进
 * @version 1.0
 */
public class TernaryOperatorExercise {
    public static void main(String[] args) {
        System.out.println(max(102, 31, 500));
    }

    public static int max(int num1, int num2, int num3) {
        int res1 = num1 > num2 ? num1 : num2;
        return res1 > num3 ? res1 : num3;
    }
}
