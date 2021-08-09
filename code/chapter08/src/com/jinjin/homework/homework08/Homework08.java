package com.jinjin.homework.homework08;

public class Homework08 {
    public static void main(String[] args) {
        //测试SavingAccount()
        SavingsAccount savingsAccount = new SavingsAccount(100);
        savingsAccount.deposit(100);
        savingsAccount.withdraw(50);
        savingsAccount.deposit(1000);
        System.out.println(savingsAccount.getBalance());

        savingsAccount.deposit(100);
        System.out.println(savingsAccount.getBalance());


        savingsAccount.earnMonthlyInterest();
        System.out.println(savingsAccount.getBalance());

        savingsAccount.deposit(100); // 免手续费
        System.out.println(savingsAccount.getBalance());
    }
}