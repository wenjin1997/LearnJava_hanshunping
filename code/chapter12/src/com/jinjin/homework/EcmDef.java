package com.jinjin.homework;

/**
 * @author 文进
 * @version 1.0
 */
public class EcmDef {
    public static void main(String[] args) {
        try {
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);
            System.out.println("计算结果为：" + cal(n1, n2));
        } catch (NumberFormatException e) {
            System.out.println("数据格式不正确");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("缺少命令行参数");
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0");
        }
    }

    public static int cal(int n1, int n2) {
        return n1/n2;
    }
}
