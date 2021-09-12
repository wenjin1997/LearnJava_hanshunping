public class Homework03 {
    public static void main(String[] args) {
        int year = 2000;
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            System.out.println(year + "年是闰年！");
        } else {
            System.out.println(year + "年不是闰年");
        }
    }
}
