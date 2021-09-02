- [第4章 运算符](#第4章-运算符)
  - [运算符介绍](#运算符介绍)
  - [算术运算符](#算术运算符)
    - [面试题](#面试题)

# 第4章 运算符
## 运算符介绍
运算符是一种特殊的符号，用以表示数据的运算、赋值和比较等。 
1) 算术运算符
2) 赋值运算符
3) 关系运算符 [比较运算符] 
4) 逻辑运算符
5) 位运算符 [需要二进制基础] 
6) 三元运算符

## 算术运算符

<img src="/notes/img-ch4/ArithmeticOperator.png">

[ArithmeticOperator.java](/code/chapter04/src/ArithmeticOperator.java)
* `%`取模：本质是 `a % b = a - a / b * b`
    ```java
    System.out.println(10 % 3); //1
    System.out.println(-10 % 3); // -1 
    System.out.println(10 % -3); //1 
    System.out.println(-10 % -3);//-1
    ```
* 自增：`++` 自减：`--`
  * 作为独立语言使用，前`++`和后`++`都完全等价于 `i = i + 1`
  * 前`++`: `++i`先自增后赋值
  * 后`++`: `i++`先赋值后自增

### 面试题
**面试题1**
```java
int i = 1;//i->1
i = i++; //规则使用临时变量: (1) temp=i;(2) i=i+1;(3)i=temp;
System.out.println(i); // 1
```

**面试题2**
```java
int i=1;
i=++i; //规则使用临时变量: (1) i=i+1;(2) temp=i;(3)i=temp;
System.out.println(i); //2
```

* 🚩注意上述两个面试题中，会使用到临时变量。