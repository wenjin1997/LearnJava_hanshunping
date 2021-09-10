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