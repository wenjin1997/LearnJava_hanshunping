/**
 * @author 文进
 * @version 1.0
 */
public class Homework07 {
    public static void main(String[] args) {
        char ch1 = 'a';
        for (char i = ch1; i < ch1 + 26; i++) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
        char ch2 = 'Z';
        for (char i = ch2; i > ch2 - 26; i--) {
            System.out.print(i + " ");
        }
    }
}
