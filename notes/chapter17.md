- [第17章 多线程基础](#第17章-多线程基础)
  - [线程相关概念](#线程相关概念)
    - [程序](#程序)
    - [进程](#进程)
    - [线程](#线程)
    - [其他相关概念](#其他相关概念)
  - [线程基本使用](#线程基本使用)
    - [创建线程的两种方式](#创建线程的两种方式)
    - [线程应用案例-继承Thread类](#线程应用案例-继承thread类)
    - [线程应用案例2-Runnable接口](#线程应用案例2-runnable接口)
    - [线程使用应用案例-多线程执行](#线程使用应用案例-多线程执行)
    - [线程如何理解](#线程如何理解)
  - [继承Thread与实现Runnable的区别](#继承thread与实现runnable的区别)
# 第17章 多线程基础
## 线程相关概念
### 程序
程序是为完成特定任务、用某种语言编写的一组指令的集合。简单的说，就是我们写的代码。

### 进程
1. 进程是指运行中的程序，比如我们使用QQ，就启动了一个进程，操作系统就会为该进程分配内存空间。
2. 进程是程序的一次执行过程，或是正在运行一个程序。进程是动态过程：有它自身的产生、存在和消亡过程。

### 线程
1. 线程由进程创建，是进程的一个实体。
2. 一个进程可以拥有多个线程。

### 其他相关概念
1. 单线程：同一个时刻，只允许执行一个线程
2. 多线程：同一个时刻，可以执行多个线程。比如：一个qq进程，可以同时打开多个聊天窗口，一个迅雷进程，可以同时下载多个文件。
3. 并发：同一个时刻，多个任务交替执行，造成一种“貌似同时”的错觉，简单的说，单核CPU实现的多任务就是并发。
4. 并行：同一个时刻，多个任务同时进行。多核CPU可以实现并行。
5. 并发和并行可以同时存在。

查看电脑有几核的代码：[CpuNum.java](/code/chapter17/src/com/jinjin/CpuNum.java)

## 线程基本使用
### 创建线程的两种方式
1. 继承Thread类，重写run方法
2. 实现Runnable接口，重写run方法

* Thread类图
    <img src="/notes/img-ch17/Thread.png">

### 线程应用案例-继承Thread类
* 请编写程序，开启一个线程，该线程每隔1秒，在控制台输出“喵喵，我是小猫咪” [Thread01.java](/code/chapter17/src/com/jinjin/threaduse/Thread01.java)
* 线程关系图

    <img src="/notes/img-ch17/Thread01.png">

* 如何使用JConsole监控线程执行情况
  1. 先运行[Thread01.java](/code/chapter17/src/com/jinjin/threaduse/Thread01.java)
  2. 在终端输入`jconsole`

    <img src="/notes/img-ch17/Terminal.png">

    <img src="/notes/img-ch17/JConsole01.png">

    <img src="/notes/img-ch17/JConsole02.png">

* 为什么在main方法中执行的是`cat.start()`而不是`cat.run()`
  * 执行`cat.run()`方法，是调用普通方法，没有真正的启动一个线程，就会把run方法执行完毕，才向下执行
  * 真正实现多线程的效果，是start0(), 而不是 run
* `cat.start()`底层
    1. start()方法：
    ```java
    public synchronized void start() {
        //...
        start0();
        //...
    }
    ```
    2. start0()方法:start0() 是本地方法，是JVM调用, 底层是c/c++实现。
    ```java
    private native void start0();
    ```
* `start0()`调用示意图
    <img src="/notes/img-ch17/start0.png">

### 线程应用案例2-Runnable接口
1. java是单继承的，在某些情况下一个类可能已经继承了某个父类，这时在用继承Thread类方法来创建线程显然不可能了。
2. java设计者们提供了另外一个方式创建线程，就是通过实现Runnable接口来创建线程。

▶️  应用案例
* 请编写程序，该程序每隔一秒。在控制台输出“小狗汪汪叫”，当输出10次后，自动退出。请使用Runnable接口的方式来实现。[Thread02.java](/code/chapter17/src/com/jinjin/threaduse/Thread02.java)
* 设计模式：代理模式，看[Thread02.java](/code/chapter17/src/com/jinjin/threaduse/Thread02.java)中的模拟。

### 线程使用应用案例-多线程执行
请编写一个程序，创建两个线程，一个线程每隔1秒输出"hello,world"，输出10次，退出。一个线程每隔1秒输出"hi"，输出5次退出。[Thread03.java](/code/chapter17/src/com/jinjin/threaduse/Thread03.java)

### 线程如何理解

<img src="/notes/img-ch17/ThreadUnderstand01.png">

<img src="/notes/img-ch17/ThreadUnderstand02.png">

## 继承Thread与实现Runnable的区别
1. 从java的设计来看，通过继承Thread或者实现Runnable接口来创建线程本质上没有区别，从JDK帮助文档我们可以看到Thread类本身就实现了Runnable接口。
2. 实现Runnable接口方式更加适合多个线程共享一个资源的情况，并且避免了单继承的限制，建议使用Runnable。
3. 售票系统，编程模拟三个售票窗口售票100长，分别使用继承Thread和实现Runnable方式，并分析有什么问题。[SellTicket.java](/code/chapter17/src/com/jinjin/ticket/SellTicket.java)
    * 会出现超卖现象，因为有多个线程同时进来判断。