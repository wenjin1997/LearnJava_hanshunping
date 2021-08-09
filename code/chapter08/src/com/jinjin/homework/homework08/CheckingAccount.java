package com.jinjin.homework.homework08;

// 扩展新类CheckingAccount,
// 对每次存款和取款都收取1美元的手续费。
public class CheckingAccount extends BankAccount{
    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    //存款
    @Override
    public void deposit(double amount) {
        // setBalance(getBalance() + amount - 1);
        super.deposit(amount - 1);
    }

    //取款
    @Override
    public void withdraw(double amount) {
        // setBalance(getBalance() - amount - 1);
        super.withdraw(amount + 1);
    }
}
