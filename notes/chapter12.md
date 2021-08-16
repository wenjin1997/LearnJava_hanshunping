- [第12章 异常—Exception](#第12章-异常exception)
  - [实际问题](#实际问题)
  - [异常介绍](#异常介绍)
  - [异常体系图一览](#异常体系图一览)
  - [常见的运行时异常](#常见的运行时异常)
  - [编译异常](#编译异常)
  - [异常课堂练习](#异常课堂练习)
  - [异常处理](#异常处理)
  - [`try-catch`异常处理](#try-catch异常处理)
    - [`try-catch` 方式处理异常说明](#try-catch-方式处理异常说明)
    - [`try-catch` 方式处理异常-注意事项](#try-catch-方式处理异常-注意事项)
  - [异常处理课堂练习](#异常处理课堂练习)
    - [⭐️课堂练习1](#️课堂练习1)
    - [课堂练习2](#课堂练习2)
    - [⭐️⭐️课堂练习3](#️️课堂练习3)
    - [`try-catch-finally`执行顺序小结](#try-catch-finally执行顺序小结)
    - [⭐️课后练习题](#️课后练习题)
  - [`throws`异常处理](#throws异常处理)
    - [基本介绍](#基本介绍)
    - [注意事项和使用细节](#注意事项和使用细节)
  - [自定义异常](#自定义异常)
    - [基本概念](#基本概念)
    - [自定义异常的步骤](#自定义异常的步骤)
    - [自定义异常的应用案例](#自定义异常的应用案例)
  - [`throw`和`throws`的区别](#throw和throws的区别)
    - [一览表](#一览表)
    - [测试题](#测试题)
  - [本章作业](#本章作业)
    - [作业1](#作业1)
    - [作业2](#作业2)
    - [作业3](#作业3)
    - [作业4](#作业4)

# 第12章 异常—Exception
## 实际问题
对异常进行捕获，保证程序可以继续运行。快捷键方式：将该代码块->选中->快捷键 command + alt + t -> 选中 `try-catch`。[Exception01.java](/code/chapter12/src/com/jinjin/exception_/Exception01.java)
```java
try {
    int res = num1 / num2;
} catch (Exception e) {
//  e.printStackTrace();
    System.out.println("出现异常的原因：" + e.getMessage());
}
```

## 异常介绍
* 基本概念  
    Java语言中，将程序执行中发生的不正常情况称为"异常"。（开发过程中的语法错误和逻辑错误不是异常）
* 执行过程中所发生的异常事件可分为两大类
    1. Error(错误)：Java虚拟机无法解决的严重问题。如：JVM系统内部错误、资源耗尽等严重情况。比如：`StackOverflowError`[栈溢出]和OOM(out of memory),**Error是严重错误，程序会崩溃**。
    2. Exception：其他因编程错误或偶然的外在因素导致的一般性问题，可以使用针对性的代码进行处理。例如空指针访问，试图读取不存在的文件，网络连接中断，Exception分为两大类：**运行时异常**[程序运行时，发生的异常]和**编译时异常**[编程时，编译器检查出的异常]。
## 异常体系图一览
**异常体系图**

<img src="/notes/img-ch12/Throwable.png">

**异常体系图小结**：
1. 异常分为两大类：运行时异常和编译时异常
2. **运行时异常，编译器检查不出来**。一般是指编程时的逻辑错误，是程序员应该避免其出现的异常。java.lang.RuntimeException类及它的子类都是运行时异常。
3. 对于运行时异常，可以不作处理，因为这类异常很普遍，若全处理可能会对程序的可读性和运行效率产生影响。
4. 编译时异常，是编译器要求**必须**处置的异常。

## 常见的运行时异常
常见的运行时异常包括
1) `NullPointerException` 空指针异常
2) `ArithmeticException` 数学运算异常
3) `ArrayIndexOutOfBoundsException` 数组下标越界异常
4) `ClassCastException` 类型转换异常
5) `NumberFormatException` 数字格式不正确异常

常见的运行时异常举例
1) `NullPointerException` 空指针异常 [NullPointerException_.java](/code/chapter12/src/com/jinjin/exception_/NullPointerException_.java)  
    当应用程序试图在需要对象的地方使用`null`时，抛出该异常。
2) `ArithmeticException` 数学运算异常  
   当出现异常的运算条件时，抛出此异常。例如，一个整数“除以零”时，抛出此类的一个实例。
3) `ArrayIndexOutOfBoundsException` 数组下标越界异常 [ArrayIndexOutOfBoundsException_.java](/code/chapter12/src/com/jinjin/exception_/ArrayIndexOutOfBoundsException_.java)  
    用非法索引访问数组时抛出的异常。如果索引为负或大于等于数组大小，则该索引为非法索引。
4) `ClassCastException` 类型转换异常 [ClassCastException_.java](/code/chapter12/src/com/jinjin/exception_/ClassCastException_.java)  
   当试图将对象强制转换为不是实例的子类时，抛出该异常。
5) `NumberFormatException` 数字格式不正确异常 [NumberFormatException_.java](/code/chapter12/src/com/jinjin/exception_/NumberFormatException_.java)  
   当应用程序试图将字符串转换成一种数值类型，但该字符串不能转换为适当格式时，抛出该异常 => 使用异常我们可以确保输入是满足条件数字.

## 编译异常
介绍：  
编译异常是指在编译期间，就必须处理的异常，否则代码不能通过编译。

常见的编译异常：
1. `SQLException` 操作数据时，查询表可能发生异常
2. `IOException` 操作文件时，发生的异常
3. `FileNotFoundException` 当操作一个不存在的文件时，发生异常
4. `ClassNotFoundException` 加载类，而该类不存在时，异常
5. `EOFException` 操作文件，到文件末尾，发生异常
6. `IllegalArgumentException` 参数异常

## 异常课堂练习
看看下面代码是否正确，为什么?

<img src="/notes/img-ch12/exceptionExercise.png">

## 异常处理
基本介绍：  
异常处理就是当异常发生时，对异常处理的方式。

异常处理方式：  
1. `try-catch-finally`
   程序员在代码捕获发生的异常，自行处理
2. `throws`
   将发生的异常抛出，交给调用者（方法）来处理，最顶级的处理者就是JVM。

示意图：

<img src="/notes/img-ch12/try-catch-finally.png">

<img src="/notes/img-ch12/throws.png">

## `try-catch`异常处理
### `try-catch` 方式处理异常说明
1. Java提供`try`和`catch`块来处理异常。`try`块用于包含可能出错的代码。`catch`块用于处理`try`块中发生的异常。根据需要，在程序中可以有多个`try-catch`块。
2. 基本语法
   ```java
   try {
       //可疑代码
       //将异常生成对应的异常对象，传递给catch块
   }catch(异常){
       //对异常的处理
   }
   //如果没有finally，语法是可以通过
   ```

### `try-catch` 方式处理异常-注意事项 
1. **如果异常发生了，则异常发生后面的代码不会执行，直接进入到`catch`块**。
2. 如果异常没有发生，则顺序执行`try`的代码块，不会进入到`catch`。
3. 如果希望不管是否发生异常，都执行某段代码（比如关闭连接，释放资源等），则使用如下代码`finally{...}` [TryCatchDetail.java](/code/chapter12/src/com/jinjin/try_/TryCatchDetail.java)
   ```java
   try {
       //可疑代码
       //将异常生成对应的异常对象，传递给catch块
   }catch(异常){
       //对异常的处理
   }finally{
        //释放资源等...
   }
   ```
4. 可以有多个`catch`语句，捕获不同的异常（进行不同的业务处理），要求父类异常在后，子类异常在前，比如（`Exception`在后，`NullPointerException`在前），**如果发生异常，只会匹配一个`catch`**。[TryCatchDetail02.java](/code/chapter12/src/com/jinjin/try_/TryCatchDetail02.java)
5. 可以进行`try-finally`配合使用，这种方法相当于没有捕获异常，因此程序会直接崩掉/退出。应用场景，就是执行一段代码，不管是否发生异常，都必须执行某个业务逻辑。[TryCatchDetail03.java](/code/chapter12/src/com/jinjin/try_/TryCatchDetail03.java)

## 异常处理课堂练习
### ⭐️课堂练习1
判断输出什么？答案见[TryCatchExercise01.java](/code/chapter12/src/com/jinjin/try_/TryCatchExercise01.java)

```java
class Exception01 {
    public static int method() {
        try {
            String[] names = new String[3];
            if (names[1].equals("tom")) {
                System.out.println(names[1]);
            } else {
                names[3] = "hspedu";
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) {
            return 3;
        } finally {
            return 4;
        }
    }

    public static void main(String[] args) {
        System.out.println(method());
    }
}
```

* 在执行完`String[] names = new String[3];`后，字符串数组中的每个元素为`null`，所以后面会抛出空指针异常。

### 课堂练习2
判断输出什么？答案见[TryCatchExercise02.java](/code/chapter12/src/com/jinjin/try_/TryCatchExercise02.java)

```java
class Exception02 {
    public static int method() {
        int i = 1;
        try {
            i++;
            String[] names = new String[3];
            if (names[1].equals("tom")) {
                System.out.println(names[1]);
            } else {
                names[3] = "hspedu";
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) {
            return ++i;
        } finally {
            return ++i;
        }
    }

    public static void main(String[] args) {
        System.out.println(method());
    }
}
```

### ⭐️⭐️课堂练习3
判断输出什么？答案见[TryCatchExercise03.java](/code/chapter12/src/com/jinjin/try_/TryCatchExercise03.java)

```java
class ExceptionExe01 {
    public static int method() {
        int i = 1;
        try {
            i++;
            String[] names = new String[3];
            if (names[1].equals("tom")) { 
                System.out.println(names[1]);
            } else {
                names[3] = "hspedu";
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) {
            return ++i; 
        } finally {
            ++i; 
            System.out.println("i=" + i);
        }
    }

    public static void main(String[] args) {
        System.out.println(method());
    }
}
```

* 在执行到`catch (NullPointerException e) {return ++i;}`后，会有临时变量保存`i`的值，然后继续执行`finnally{}`中的语句，最后返回。

### `try-catch-finally`执行顺序小结
1. 如果没有出现异常，则执行`try`块中所有语句，不执行`catch`块中语句，如果有`finally`，最后还需要执行`finally`里面的语句
2. 如果出现异常，则`try`块异常发生后，**`try`块剩下的语句不再执行**。将执行`catch`块中的语句，如果有`finally`，最后还需要执行`finally`里面的语句！

### ⭐️课后练习题
如果用户输入的不是一个整数，就提示他反复输入，直到输入一个整数为止。[TryCatchExercise04.java](/code/chapter12/src/com/jinjin/try_/TryCatchExercise04.java)
* 接收输入
  ```java
   Scanner scanner = new Scanner(System.in);
   scanner.next();
  ```
* 将一个字符串转换为整数:`num = Integer.parseInt(inputStr);`
* 这里重要的是使用一个`while`循环，然后用`try-catch`
  ```java
  while (true) {
            System.out.print("请输入一个整数： ");
            inputStr = scanner.next();
            try {
                num = Integer.parseInt(inputStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("你输入的不是整数");
            }
        }
  ```

## `throws`异常处理
### 基本介绍
案例[Throws01.java](/code/chapter12/src/com/jinjin/throws_/Throws01.java)

1. 如果一个方法（中的语句执行时）可能生出某种异常，但是并不能确定如何处理这种异常，则此方法应显示地声明抛出异常，表明该方法将不对异常进行处理，而由该方法的**调用者负责处理**。
2. 在方法声明中用`throws`语句可以声明抛出异常列表，`throws`后面的异常类型可以是方法中产生的异常类型，也可以是它的父类。

### 注意事项和使用细节
1. 对于编译异常，程序中必须处理，比如`try-catch`或者`throws`
2. **对于运行时异常，程序中如果没有处理，默认就是throws的方式处理**
3. 子类重写父类的方法时，对抛出异常的规定:**子类重写的方法，所抛出的异常类型要么和父类抛出的异常一致，要么为父类抛出的异常类型的子类型**
4. 在`throws`过程中，如果有方法`try-catch`, 就相当于处理异常，就可以不必`throws`

⭐️⭐️**Remark**:
1. 这里`f3()`抛出的是编译异常，如果`f1()`调用`f3()`一定会报错，必须对编译异常进行处理。
```java
public static void f1() throws FileNotFoundException {
    //这里大家思考问题 调用f3() 报错
    //1. 因为f3() 方法抛出的是一个编译异常
    //2. 即这时，就要f1() 必须处理这个编译异常
    //3. 在f1() 中，要么 try-catch-finally ,或者继续throws 这个编译异常
    f3(); // 抛出异常
}
public static void f3() throws FileNotFoundException {
    FileInputStream fis = new FileInputStream("d://aa.txt");
}
```

2. 这里`f5()`抛出的是运行时异常，`f4()`调用`f5()`并不会报错，因为有默认的处理机制。
```java
public static void f4() {
    //1. 在f4()中调用方法f5() 是OK
    //2. 原因是f5() 抛出的是运行异常
    //3. 而java中，并不要求程序员显示处理,因为有默认处理机制
    f5();
}
public static void f5() throws ArithmeticException {

}
```

## 自定义异常
### 基本概念
当程序中出现了某些“错误”，但该错误信息并没有在`Throwable`子类中描述处理，这个时候可以自己设计异常，用于描述该错误信息。

### 自定义异常的步骤
1. 定义类：自定义异常类名（程序员自己写）继承`Exception`或`RuntimeException`
2. 如果继承`Exception`，属于编译异常
3. 如果继承`RuntimeException`，属于运行异常（一般来说，继承`RuntimeException`）

### 自定义异常的应用案例
当我们接收Person对象年龄时，要求范围在18-120之间，否则抛出一个自定义异常（要求 继承RuntimeException），并给出提示信息。[CustomException.java](/code/chapter12/src/com/jinjin/customexception_/CustomException.java)

**Remark**：
* 一般情况下，我们自定义异常是继承`RuntimeException`，即把自定义异常做成运行时异常，好处是，我们可以使用默认的处理机制，即比较方便。

## `throw`和`throws`的区别
### 一览表
|    |意义|位置|后面跟的东西|
|----|----|----|----|
|`throws`|异常处理的一种方式|方法声明处|异常类型|
|`throw`|手动生成异常对象的关键字|方法体中|异常对象|

### 测试题
下面输出什么？[ThrowException.java](/code/chapter12/src/com/jinjin/throws_/ThrowException.java)

输出结果：

<img src="/notes/img-ch12/throException.png">

**Remark**:
* 在`try-catch-finally`中，`catch`中抛出了一个异常对象，但是要先执行`finally`中的代码。

## 本章作业
### 作业1
[EcmDef.java](/code/chapter12/src/com/jinjin/homework/EcmDef.java)

编写应用程序`EcmDef.java`，接收命令行的两个参数(整数)，计算两数相除。计算两个数相除，要求使用方法`cal(int n1, int n2)`对数据格式不正确(`NumberFormatException`)、缺少命令行参数(`ArrayIndexOutOfBoundsException`)、除0进行异常处理(`ArithmeticException`)。

### 作业2
说出代码[Homework02.java](/code/chapter12/src/com/jinjin/homework/Homework02.java)是否会发生异常，如果会，是哪种异常？如果不会，则打印结果是什么？

可能会出现的异常：`ArrayIndexOutOfBoundsException`、`NullPointerException`   
一定会发生的异常：`ClassCastException`

### 作业3
写出程序结果：[Homework03.java](/code/chapter12/src/com/jinjin/homework/Homework03.java)  
答案是`B,C,D`。

### 作业4
写出程序结果：[Homework04.java](/code/chapter12/src/com/jinjin/homework/Homework04.java)  
答案是`B,C,D`。