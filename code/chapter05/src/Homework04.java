/**
 * @author 文进
 * @version 1.0
 */
public class Homework04 {
    public static void main(String[] args) {
        //水仙花数
        int num = 153;
        int i = num / 100;  //百位
        int j = (num - 100 * i) / 10; //十位
        int k = num - 100 * i - 10 * j; //个位
        if (num == Math.pow(i, 3) + Math.pow(j, 3) + Math.pow(k, 3)) {
            System.out.println(num + "是水仙花数");
        }else{
            System.out.println(num + " 不是水仙花数");
        }
    }
}
