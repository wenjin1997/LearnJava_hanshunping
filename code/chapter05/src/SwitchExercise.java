import java.util.Scanner;

/**
 * @author 文进
 * @version 1.0
 */
public class SwitchExercise {
    public static void main(String[] args) {
        /**
         * 1) 使用 switch 把小写类型的 char 型转为大写(键盘输入)。只转换 a, b, c, d, e. 其它的输出 "other"。
         * 2) 对学生成绩大于60分的，输出"合格"。低于60分的，输出"不合格"。(注:输入的成绩不能大于100),提示成绩/60
         * 3) 根据用于指定月份，打印该月份所属的季节。3,4,5 春季 6,7,8 夏季
         * 9,10,11 秋季 12, 1, 2 冬季 [提示 使用穿透]
         */

        //1.使用 switch 把小写类型的 char 型转为大写(键盘输入)。只转换 a, b, c, d, e. 其它的输出 "other"。
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入字符a-e：");
        char c = scanner.next().charAt(0);
        switch (c) {
            case 'a':
                System.out.println("A");
                break;
            case 'b':
                System.out.println("B");
                break;
            case 'c':
                System.out.println("C");
                break;
            case 'd':
                System.out.println("D");
                break;
            case 'e':
                System.out.println("E");
                break;
            default:
                System.out.println("你的输入有误");
        }

        System.out.print("请输入月份1-12:");
        int month = scanner.nextInt();
        switch (month) {
            case 1:
            case 2:
            case 3:
                System.out.println("春季");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("夏季");
                break;
            case 7:
            case 8:
            case 9:
                System.out.println("秋季");
                break;
            case 10:
            case 11:
            case 12:
                System.out.println("冬季");
                break;
            default:
                System.out.println("输入月份有误");
        }
    }
}

