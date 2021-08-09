package com.jinjin.homework.homework08;

/*
新类SavingAccount每个月都有利息产生（earnMonthlyInterest方法被调用），
并且有每月三次免手续费的存款或取款。在earnMonthlyInterest方法中重置交易计数
 */
public class SavingsAccount extends BankAccount{
    private double interest = 0.01; // 每月利率
    private int times = 3; // 每月免手续费次数
    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public void earnMonthlyInterest() {
        times = 3;
        // 每个月产生利息
        //setBalance(getBalance() + getBalance() * interest);
        super.deposit(getBalance() * interest);
    }

    // 每月三次免手续费的存款或取款

    //存款
    public void deposit(double amount) {
        if (times > 0) {
            super.deposit(amount);
        } else {
            super.deposit(amount - 1);
        }
        times --;
    }

    //取款
    public void withdraw(double amount) {
        if (times > 0) {
            super.withdraw(amount);
        } else {
            super.withdraw(amount + 1);
        }
        times --;
    }
}
