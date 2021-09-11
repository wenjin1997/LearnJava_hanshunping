import javafx.util.converter.LocalDateStringConverter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * @author 文进
 * @version 1.0
 */
public class Plan {
    public static void main(String[] args) {
        /*
        计算学习Java课程的进度
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("第一部分课程看到多少节？");
        int end1 = scanner.nextInt();
        System.out.print("第二部分看到多少节？");
        int end2 = scanner.nextInt();
        int courses = 910 - end2 + 191 - end1;
        System.out.print("剩余课程数：" + courses);

        //计算倒计时
        LocalDate now = LocalDate.now();
        LocalDate lastDate = LocalDate.of(2021, 9, 30);
        int day = lastDate.compareTo(now) + 15;
        System.out.println("\t剩余天数:"+ day + "\n每天应学习" + (courses/day) + "节课，" +
                "补充" + (courses - (courses/day) * day) + "节课！");
        if ((courses/day) != 12) {
            System.out.print("按计划每天学习12节课程" + "(截止日期10-15)：");
            int planDay = courses - 12 * day;
            if (planDay < 0) {
                System.out.println("已超前完成" + (-planDay) + "节课！👍");
            } else if (planDay > 0) {
                System.out.println("需补充" + planDay + "节课！");
            } else {
                System.out.println("不需要补充课程！");
            }
        } else {
            System.out.println("加油~按照计划学习！📖");
        }
    }
}
