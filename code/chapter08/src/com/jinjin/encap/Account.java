package com.jinjin.encap;

/*
Account类要求具有属性：姓名（长度为2位3位或4位）、
余额（必须>20）、密码（必须是六位），
如果不满足，则给出提示信息，并给默认值。
 */
public class Account {
    private String name;
    private double balance;
    private String pwd;

    public Account() {
    }

    public Account(String name, double balance, String pwd) {
        setName(name);
        setBalance(balance);
        setPwd(pwd);
    }

    public String getName() {
        return name;
    }

    //姓名（长度为2位3位或4位）
    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 4) {
            this.name = name;
        } else {
            System.out.println("姓名（长度为2位3位或4位），默认：无名");
            this.name = "无名";
        }
    }

    public double getBalance() {
        return balance;
    }

    //余额（必须>20）
    public void setBalance(double balance) {
        if (balance > 20) {
            this.balance = balance;
        } else {
            System.out.println("余额（必须>20），默认余额为0");
        }
    }

    public String getPwd() {
        return pwd;
    }

    //密码（必须是六位）
    public void setPwd(String pwd) {
        if (pwd.length() == 6) {
            this.pwd = pwd;
        } else {
            System.out.println("密码（必须是六位），默认密码：000000");
            this.pwd = "000000";
        }
    }

    //显示信息
    public void info(){
        System.out.println("姓名：" + name + " 余额：" + balance + " 密码：" + pwd);
    }
}
