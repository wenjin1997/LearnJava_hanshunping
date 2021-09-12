- [第5章 程序控制结构](#第5章-程序控制结构)
  - [程序流程控制介绍](#程序流程控制介绍)
  - [顺序控制](#顺序控制)
  - [分支控制](#分支控制)
  - [嵌套分支](#嵌套分支)
  - [switch分支结构](#switch分支结构)
  - [for循环控制](#for循环控制)
    - [基本语法](#基本语法)
    - [for循环执行流程分析](#for循环执行流程分析)
    - [注意事项和细节](#注意事项和细节)
    - [练习](#练习)
  - [while循环控制](#while循环控制)
    - [基本语法](#基本语法-1)
    - [while循环执行流程](#while循环执行流程)
    - [注意事项和细节说明](#注意事项和细节说明)
  - [do..while循环控制](#dowhile循环控制)
    - [基本语法](#基本语法-2)
  - [多重循环控制](#多重循环控制)
  - [跳转控制语句-break](#跳转控制语句-break)
  - [跳转控制语句-continue](#跳转控制语句-continue)
  - [跳转控制语句-return](#跳转控制语句-return)
  - [本章作业](#本章作业)
# 第5章 程序控制结构
## 程序流程控制介绍
主要有三大流程控制语句：
* 顺序控制
* 分支控制
* 循环控制

## 顺序控制
* 程序从上到下顺序地执行，中间没有任何判断和跳转。
* Java中定义变量时采用合法的**前向引用**。

## 分支控制
分支控制有三种：
* 单分支 if
* 双分支 if-else
* 多分支 if-else if-...-else
  * 多分支可以没有else，如果所有条件表达式都不成立，则一个执行入口都没有

## 嵌套分支
在一个分支结构中又完整的嵌套了另一个完整的分支结构，里面的分支的结构称为内层分支外面的分支结构称为外 层分支。建议: 不要超过 3 层 (可读性不好)

## switch分支结构
```java
switch(表达式){
    case 常量1:
    语句块1;
    break;
    case 常量2:
    语句块2;
    break;
    ...
    case 常量n:
    语句块n;
    break;
    default:
    default语句块;
    break;
}
```
* switch关键字，表示switch分支
* 表达式对应一个值
* 如果一个都没有匹配上，执行default

▶️  🌟流程图

<img src="/notes/img-ch5/switch.png">

▶️  细节
* 表达式数据类型，应和case后的常量**类型一致**，或者是可以**自动转成**可以相互比较的类型，比如输入的是字符，而常量是int。
* switch（表达式）中表达式的**返回值必须是**：byte,short,int,char,enum[枚举],String
* case子句中的值必须是常量，而不能是变量
* default子句是可选的，当没有匹配的case时，执行default
* break语句用来在执行完一个case分支后使程序跳出swtich语句块；**如果没有写break，程序会顺序执行到switch结尾，除非遇到`break;`**

▶️  课堂练习
[SwitchExercise.java](/code/chapter05/src/SwitchExercise.java)
1) 使用 switch 把小写类型的 char 型转为大写(键盘输入)。只转换 a, b, c, d, e. 其它的输出 "other"。
2) 对学生成绩大于60分的，输出"合格"。低于60分的，输出"不合格"。(注:输入的成绩不能大于100),提示成绩/60 
3) 根据用于指定月份，打印该月份所属的季节。3,4,5 春季 6,7,8 夏季 9,10,11 秋季 12, 1, 2 冬季 [提示 使用穿透]

✏️  Remark
* 在练习1中，注意如何获得一个char类型字符，用`String.charAt(0);`
```java
Scanner scanner = new Scanner(System.in);
System.out.print("请输入字符a-e：");
char c = scanner.next().charAt(0);
```
* 在练习3中，可以使用穿透来解决。
```java
System.out.print("请输入月份1-12:");
int month = scanner.nextInt();
switch (month) {
    case 1:
    case 2:
    case 3:
        System.out.println("春季");
        break;
    case 4:
    case 5:
    case 6:
        System.out.println("夏季");
        break;
    case 7:
    case 8:
    case 9:
        System.out.println("秋季");
        break;
    case 10:
    case 11:
    case 12:
        System.out.println("冬季");
        break;
    default:
        System.out.println("输入月份有误");
}
```
▶️  switch和if的比较
1) 如果判断的具体数值不多，而且符合byte、short、int、char,enum[枚举],String这6种类型。虽然两个语句都可 以使用，建议使用 swtich 语句。
2) 其他情况:对区间判断，对结果为boolean类型判断，使用if，if的使用范围更广

## for循环控制
### 基本语法
```java
for(循环遍历初始化;循环条件;循环变量迭代){
    循环操作(可以多条语句);
}
```
1. for 关键字，表示循环控制
2. for 有四要素: 
   1. 循环变量初始化
   2. 循环条件
   3. 循环操作
   4. 循环变量迭代 
3. 循环操作, 这里可以有多条语句，也就是我们要循环执行的代码
4. 如果 循环操作(语句) 只有一条语句，可以省略 {}, 建议不要省略

### for循环执行流程分析

<img src="/notes/img-ch5/for.png">

### 注意事项和细节
1) 循环条件是返回一个布尔值的表达式
2) for(;循环判断条件;) 中的初始化和变量迭代可以写到其它地方，但是两边的分号不能省略。`for(;;){}`为死循环。
```java
int i = 1;
for( ; i <= 10; ){
    System.out.println("你好" + i);
    i++;
}
```
3) 循环初始值可以有多条初始化语句，但要求类型一样，并且中间用逗号隔开，循环变量迭代也可以有多条变量迭代 语句，中间用逗号隔开。
```java
int count = 3;
for (int i = 0, j = 0; i < count; i++, j+=2){
    System.out.println("i=" + i + "j=" + j);
}
```
### 练习
1. 打印1~100之间所有是9的倍数的整数，统计个数 及总和 [ForExercise.java](/code/chapter05/src/ForExercise.java)
2. 完成下面的表达式输出 [ForExercise02.java](/code/chapter05/src/ForExercise02.java)
```
0 + 5 = 5
1 + 4 = 5
2 + 3 = 5
3 + 2 = 5
4 + 1 = 5
5 + 0 = 5
```

## while循环控制
### 基本语法
```java
循环变量初始化;
while(循环条件) {
    循环体(语句);
    循环遍历迭代;
}
```
* while循环也有四要素
* 知识四要素放的位置和for不一样

### while循环执行流程

<img src="/notes/img-ch5/while.png">

### 注意事项和细节说明
1) 循环条件是返回一个布尔值的表达式
2) **while 循环是先判断再执行语句**

## do..while循环控制
### 基本语法
```java
循环变量初始化;
do{
    循环体(语句);
    循环变量迭代;
}while(循环条件);
```
1. do while 是关键字
1. 也有循环四要素, 只是位置不一样
2. **先执行，再判断**，也就是说，**一定会至少执行一次** 
3. 最后有一个分号 ;

<img src="/notes/img-ch5/dowhile.png">

## 多重循环控制
打印空心金字塔 [Stars.java](/code/chapter05/src/Stars.java)
```java
    *
   * *
  *   *
 *     *
*********
```
分析思路，一步步完成，不断改进，找出其中的规律。注意到中间可以先打印出空格，再打印星星。

<img src="/notes/img-ch5/stars.png">

## 跳转控制语句-break
▶️  基本介绍
break语句用于终止某个语句块的执行，一般使用在 switch 或者循环[for , while , do-while]中。

▶️  基本语法
```java
{
    ......
    break;
    ......
}
```

<img src="/notes/img-ch5/break.png">

▶️  注意事项和细节说明
1. break语句出现在多层嵌套的语句块中时，可以通过**标签**指明要终止的是哪一层语句块。
2. 标签的基本使用
    ```java
    label1:{.....
    label2: {......
    label3:     {   ......
                    break labelx;
            }
        }
    }
    ```
3. break语句可以指定退出哪层
4. label1是标签，名字由程序员指定
5. break后指定到哪个label就退出到哪里
6. 在实际开发中，尽量不要使用标签
7. **如果没有指定break，默认退出最近的循环体**

## 跳转控制语句-continue
▶️  基本介绍
1) continue 语句用于结束本次循环，继续执行下一次循环。
2) continue 语句出现在多层嵌套的循环语句体中时，可以通过标签指明要跳过的是哪一层循环 , 这个和前面的标签的
使用的规则一样.

▶️  基本语法
```java
{   ......
    continue;
    ......
}
```

<img src="/notes/img-ch5/continue.png">

## 跳转控制语句-return
return使用在方法，表示跳出所在的方法。注意：如果return写在main方法，则退出程序。

## 本章作业
▶️  作业1 [Homework01.java](/code/chapter05/src/Homework01.java)
某人有100，000元，每经过一次路口，需要交费，规则如下：
* 当现金>50000时，每次交5%
* 当现金<=50000时，每次交1000
编程计算该人可以经过多少次路口。

▶️  作业2 [Homework02.java](/code/chapter05/src/Homework02.java)
实现判断一个整数，属于哪个范围：大于0；小于0；等于0

▶️  作业3 [Homework03.java](/code/chapter05/src/Homework03.java)
判断一个年份是否为闰年

▶️  作业4 [Homework04.java](/code/chapter05/src/Homework04.java)
判断一个整数是否是水仙花数，所谓水仙花数是指一个3位数，其个位数上数字立方和等于其本身。例如：153 = 1\*1*1 + 3\*3*3 + 5\*5*5

▶️  作业6 [Homework06.java](/code/chapter05/src/Homework06.java)
输出1-100之间不能被5整除的数，每5个一行

▶️  作业7 [Homework06.java](/code/chapter05/src/Homework07.java)
输出小写的a-z以及大写的Z-A

▶️  作业6 [Homework06.java](/code/chapter05/src/Homework06.java)
求出1-1/2+1/3-1/4.......1/100的和

▶️  作业6 [Homework06.java](/code/chapter05/src/Homework06.java)
求1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+100)的结果