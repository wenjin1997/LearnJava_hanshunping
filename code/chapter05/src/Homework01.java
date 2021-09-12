public class Homework01 {
    public static void main(String[] args) {
        double money = 100000;
        int time = 0;
        while (money >= 1000) {
            if (money > 50000) {
                money -= money * 0.05;
            } else {
                money -= 1000;
            }
            time++;
        }
        System.out.println("可以经过" + time +"次路口");
    }
}
