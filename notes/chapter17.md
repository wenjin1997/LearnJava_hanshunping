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
  - [线程终止](#线程终止)
    - [基本说明](#基本说明)
    - [应用案例](#应用案例)
  - [线程常用方法](#线程常用方法)
    - [常用方法第一组](#常用方法第一组)
    - [注意事项和细节](#注意事项和细节)
    - [常用方法第二组](#常用方法第二组)
    - [课堂练习](#课堂练习)
    - [用户线程和守护线程](#用户线程和守护线程)
  - [线程的生命周期](#线程的生命周期)
    - [JDK中Thread.State枚举线程的状态](#jdk中threadstate枚举线程的状态)
    - [🌟线程状态转换图](#线程状态转换图)
  - [Synchronized](#synchronized)
    - [线程同步机制](#线程同步机制)
    - [同步具体方法-Synchronized](#同步具体方法-synchronized)
  - [分析同步原理](#分析同步原理)
  - [互斥锁](#互斥锁)
  - [线程的死锁](#线程的死锁)
  - [释放锁](#释放锁)
    - [下面操作会释放锁](#下面操作会释放锁)
    - [下面操作不会释放锁](#下面操作不会释放锁)
  - [本章作业](#本章作业)
    - [作业1](#作业1)
    - [作业2](#作业2)
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
3. 售票系统，编程模拟三个售票窗口售票100张，分别使用继承Thread和实现Runnable方式，并分析有什么问题。[SellTicket.java](/code/chapter17/src/com/jinjin/ticket/SellTicket.java)
    * 会出现超卖现象，因为有多个线程同时进来判断。

## 线程终止
### 基本说明
1. 当线程完成任务后，会自动退出。
2. 还可以通过使用变量来控制run方法退出的方式停止线程，即通知方式。

### 应用案例
启动一个线程T，要求在main线程中去停止线程T。[ThreadExit_.java](/code/chapter17/src/com/jinjin/exit_/ThreadExit_.java)

## 线程常用方法
### 常用方法第一组
1. `setName` 设置线程名称，使之与参数name相同
2. `getName` 返回该线程的名称
3. `start` 使该线程开始执行，Java虚拟机底层调用该线程的start0方法
4. `run` 调用线程对象run方法
5. `setPriority` 更改线程的优先级
6. `getPriority` 获取线程的优先级
7. `sleep` 在指定的毫秒数内让当前正在执行的线程休眠（暂停执行）
8. `interrupt` 中断线程

### 注意事项和细节
[ThreadMethod01.java](/code/chapter17/src/com/jinjin/method/ThreadMethod01.java)
1. `start`底层会创建新的线程，调用run，run就是一个简单的方法调用，不会启动新线程
2. 线程优先级的范围
  ```java
  public final static int MIN_PRIORITY = 1;
  public final static int NORM_PRIORITY = 5;
  public final static int MAX_PRIORITY = 10;
  ```
3. `interrupt`，中断线程，但并没有真正的结束线程。所以一般用于正在休眠线程
4. `sleep`：线程的静态方法，使当前线程休眠

### 常用方法第二组
1. yield:线程的礼让。让出CPU，让其他线程执行，但礼让的时间不确定，所以也不一定礼让成功。
  <img src="/notes/img-ch17/yield.png">
2. join：线程的插队。插队的线程一旦插队成功，则肯定先执行完插入的线程所有任务。
  <img src="/notes/img-ch17/join.png">

案例：
* [ThreadMethod02.java](/code/chapter17/src/com/jinjin/method/ThreadMethod02.java)
* main线程创建一个子线程，每隔1s输出hello，输出20次，主线程每隔1秒，输出hi，输出20次。
* 要求：两个线程同时执行，当主线程输出5次后，就让子线程运行完毕，主线程再继续。

### 课堂练习
[ThreadMethodExercise.java](/code/chapter17/src/com/jinjin/method/ThreadMethodExercise.java)
* 主线程每隔1s，输出hi，一共10次
* 当输出到hi 5时，启动一个子线程（要求实现Runnable），每隔1s输出hello，等该线程输出10次hello后，退出
* 主线程继续输出hi，直到主线程退出。

### 用户线程和守护线程
1. 用户线程：也叫工作线程，当线程的任务执行完或通知方式结束
2. 守护线程：一般是为工作线程服务的，当所有的用户线程结束，守护线程自动结束
3. 常见的守护线程：垃圾回收机制

* 注意要先设置为守护线程，再让子线程开始。[ThreadMethod03.java](/code/chapter17/src/com/jinjin/method/ThreadMethod03.java)
  ```java
  MyDaemonThread myDaemonThread = new MyDaemonThread();
  //如果我们希望当main线程结束后，子线程自动结束
  //,只需将子线程设为守护线程即可
  myDaemonThread.setDaemon(true);
  myDaemonThread.start();
  ```

## 线程的生命周期
### JDK中Thread.State枚举线程的状态
<img src="/notes/img-ch17/ThreadState.png">

### 🌟线程状态转换图

<img src="/notes/img-ch17/ThreadState02.png">

* Ready和Running状态统称为Runnable状态。具体是Ready状态还是Running状态取决于操作系统的内核态。
* 程序查看线程状态：[ThreadState_.java](/code/chapter17/src/com/jinjin/state_/ThreadState_.java)

## Synchronized
### 线程同步机制
1. 在多线程编程，一些敏感数据不允许被多个线程同时访问，此时就使用同步访问技术，保证数据在任何同一个时刻，最多有一个线程访问，以保证数据的完整性。
2. 理解：线程同步，即当有一个线程在对内存进行操作时，其他线程都不可以对这个内存地址进行操作，直到该线程完成操作，其他线程才能对该内存地址进行操作。

### 同步具体方法-Synchronized
1. 同步代码块
  ```java
  synchronized(对象) { //得到对象的锁，才能操作同步代码
    //需要被同步代码;
  }
  ```
2. synchronized还可以放在方法声明中，表示整个方法为同步方法。
  ```java
  public synchronized void m(String name) {
    //需要被同步的代码
  }
  ```
3. 使用synchronized解决售票问题：[SellTicket.java](/code/chapter17/src/com/jinjin/syn/SellTicket.java)

## 分析同步原理

<img src="/notes/img-ch17/synchronized.png">

## 互斥锁
* Java语言中，引入了对象互斥锁的概念，来保证共享数据操作的完整性。
* 每个对象都对应于一个可称为“互斥锁”的标记，这个标记用来保证在任一时刻，只能有一个线程访问该对象。
* 关键字synchronized来与对象的互斥锁联系。当某个对象用synchronized修饰时，表明该对象在任一时刻只能由一个线程访问
* 同步的局限性：导致程序的执行效率要降低
* 同步方法（非静态的）的锁可以是this，也可以是其他对象（要求是同一个对象）
* 同步方法（静态的）的锁为当前类本身
* 使用互斥锁来解决售票问题：[SellTicket.java](/code/chapter17/src/com/jinjin/syn/SellTicket.java)
  * `public synchronized void sell() {}`就是一个同步方法，这时锁在this对象
  * 也可以在代码块上写 synchronize ,同步代码块, 互斥锁还是在this对象

注意事项和细节
* 同步方法如果没有static修饰：默认锁对象为this
* 如果方法使用static修饰，默认锁对象：当前类.class
* 实现的落地步骤：
  * 需要先分析上锁的代码
  * 选择同步代码块或同步方法
  * 要求多个线程的锁对象为同一个即可！

## 线程的死锁
* 多个线程都占用了对方的锁资源，但不肯想让，导致了死锁，在编程时一定要避免死锁的发生。
* 生活举例：
  * 妈妈：你先完成作业，才让你玩手机
  * 小明：你先让我玩手机，我才完成作业
* 应用案例：[DeadLock_.java](/code/chapter17/src/com/jinjin/syn/DeadLock_.java)

## 释放锁
### 下面操作会释放锁
1. 当前线程的同步代码块、同步方法执行结束
2. 当前线程在同步代码块、同步方法中遇到break、return
3. 当前线程在同步代码块、同步方法中出现了未处理的Error或Exception，导致异常结束
4. 当前线程在同步代码块、同步方法中执行了wait()方法，当前线程暂停，并释放锁。

### 下面操作不会释放锁
1. 线程执行同步代码块或同步方法时，程序调用Thread.sleep()、Thread.yield()方法暂停当前程序的执行，不会释放锁
2. 线程执行同步代码块时，其他线程调用了该线程的suspend()方法将该线程挂起，该线程不会释放锁。
  * 提示：应尽量避免使用suspend()和resume()来控制线程，方法不再推荐使用。

## 本章作业
### 作业1
* 在main方法中启动两个线程
* 第一个线程循环随机打印100以内的整数
* 直到第2个线程从键盘读取了Q命令

代码：[Homework01.java](/code/chapter17/src/com/jinjin/homework/Homework01.java)
* 线程2通过通知方式来控制线程1，需要在线程2中定义一个线程1的对象。
  ```java
  @Override
    public void run() {
        while (true) {
            System.out.println("请输入你的指令(Q)退出：");
            char key = scanner.next().toUpperCase().charAt(0);
            if (key == 'Q') {
                t1.setLoop(false);
                System.out.println("T2线程退出");
                break;
            }
        }
    }
  ```

### 作业2
* 有2个用户分别从同一个卡上取钱（总额：10000）
* 每次都取1000，当余额不足时，就不能取款了
* 不能出现超取现象->线程同步问题

代码：[Homework02.java](/code/chapter17/src/com/jinjin/homework/Homework02.java)
* 由于要共享资源，这里用Runnable方式实现。
* 实现同步时，锁用的是同一个对象。