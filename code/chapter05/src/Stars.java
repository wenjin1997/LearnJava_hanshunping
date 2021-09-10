/**
 * @author 文进
 * @version 1.0
 */
public class Stars {
    public static void main(String[] args) {
        //打印空心金字塔
        int layer = 10;
        for (int i = 1; i <= layer ; i++) {
            for (int j = 1; j <= layer - i ; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                if (k == 1 || k == 2 * i - 1 || i == layer) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println("");
        }
    }
}
