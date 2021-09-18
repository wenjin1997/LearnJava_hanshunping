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
        System.out.print("课程看到多少节？");
        int end = scanner.nextInt();
        int courses = 910 - end;
        System.out.println("剩余课程数：" + courses);

        //计算倒计时
        LocalDate now = LocalDate.now();
        LocalDate lastDate = LocalDate.of(2021, 9, 30);
        int day1 = lastDate.compareTo(now);
        int day = lastDate.compareTo(now) + 15;
        System.out.println("-----------");
        System.out.println("距离9-30剩余天数:"+ day1 + "\n每天应学习" + (courses/day1) + "节课，" +
                "补充" + (courses - (courses/day1) * day1) + "节课！");
        System.out.println("-----------");
        System.out.println("距离10-15剩余天数:"+ day + "\n每天应学习" + (courses/day) + "节课，" +
                "补充" + (courses - (courses/day) * day) + "节课！");
//        if ((courses/day1) != 18) {
        if ((courses/day) != 12) {
            System.out.print("按计划每天学习12节课程" + "(截止日期10-15)：");
//            System.out.print("按计划每天学习18节课程" + "(截止日期9-30)：");
            int planDay = courses - 12 * day;
//            int planDay = courses - 18 * day;
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
