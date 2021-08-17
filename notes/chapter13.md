- [第13章 常用类](#第13章-常用类)
  - [包装类](#包装类)
    - [包装类的分类](#包装类的分类)
    - [包装类和基本数据的转换](#包装类和基本数据的转换)
    - [⭐️⭐️课堂测试题](#️️课堂测试题)
    - [包装类型和`String`类型的相互转换](#包装类型和string类型的相互转换)
    - [`Integer`类和`Character`类的常用方法](#integer类和character类的常用方法)
    - [⭐️⭐️⭐️`Integer`类面试题](#️️️integer类面试题)
    - [🚩`Intege`类面试题总结](#intege类面试题总结)

# 第13章 常用类
## 包装类
### 包装类的分类
1) 针对八种基本数据类型相应的引用类型—包装类 
2) 有了类的特点，就可以调用类中的方法。
3) 如图:

<img src="/notes/img-ch13/wrapper01.png">

<img src="/notes/img-ch13/Character.png">

<img src="/notes/img-ch13/Boolean.png">

<img src="/notes/img-ch13/Number.png">

### 包装类和基本数据的转换
1. jdk5 前的手动装箱和拆箱方式，**装箱**：基本类型->包装类型，反之，拆箱
2. jdk5 以后（含jdk5）的自动装箱和拆箱方式
3. 自动装箱底层调用的是`valueOf`方法，比如`Integer.valurOf()`
4. 其它包装类的用法类似

案例：[Integer01.java](/code/chapter13/src/com/jinjin/wrapper/Integer01.java)
* 手动装箱和拆箱
    ```java
    //jdk5前是手动装箱和拆箱
    //手动装箱 int->Integer
    int n1 = 100;
    Integer integer = new Integer(n1); //第一种方式
    Integer integer1 = Integer.valueOf(n1); //第二种方式

    //手动拆箱
    //Integer -> int
    int i = integer.intValue();
    ```
* 自动装箱和拆箱
    ```java
    //jdk5后，就可以自动装箱和自动拆箱
    int n2 = 200;
    //自动装箱 int->Integer
    Integer integer2 = n2; //底层使用的是 Integer.valueOf(n2)
    //自动拆箱 Integer->int
    int n3 = integer2; //底层仍然使用的是 intValue()方法
    ```

### ⭐️⭐️课堂测试题

<img src="/notes/img-ch13/Wrapperex1.png">

* 注意第二题，这是一个三元运算符，要提升优先级，输出的是1.0，而不是1。

### 包装类型和`String`类型的相互转换
案例演示, 以`Integer`和`String`转换为例，其它类似。[WrapperVSString.java](/code/chapter13/src/com/jinjin/wrapper/WrapperVSString.java)

* 包装类(`Integer`)->`String`，有三种方式
* `String` -> 包装类(`Integer`)，有两种方式

### `Integer`类和`Character`类的常用方法
[WrapperMethod.java](/code/chapter13/src/com/jinjin/wrapper/WrapperMethod.java)
* 重点是碰到问题，会自己查找用什么方法。可以在类图中显示方法。

### ⭐️⭐️⭐️`Integer`类面试题
看看下面代码，输出什么结果? 为什么?[WrapperExercise02.java](/code/chapter13/src/com/jinjin/wrapper/WrapperExercise02.java)

```java
Integer i = new Integer(1);
Integer j = new Integer(1);
System.out.println(i == j);

Integer m = 1;
Integer n = 1;
System.out.println(m == n);

Integer x = 128;
Integer y = 128;
System.out.println(x == y);
```

### 🚩`Intege`类面试题总结
看看下面代码，输出什么结果？[WrapperExercise03.java](/code/chapter13/src/com/jinjin/wrapper/WrapperExercise03.java)

```java
//示例一
Integer i1 = new Integer(127);
Integer i2 = new Integer(127);
System.out.println(i1 == i2);

//示例二
Integer i3 = new Integer(128);
Integer i4 = new Integer(128);
System.out.println(i3 == i4);

//示例三
Integer i5 = 127;
Integer i6 = 127;
System.out.println(i5 == i6);

//示例四
Integer i7 = 128;
Integer i8 = 128;
System.out.println(i7 == i8);

//示例五
Integer i9 = 127;
Integer i10 = new Integer(127);
System.out.println(i9 == i10);

//示例六
Integer i11=127;
int i12=127;
System.out.println(i11==i12); 

//示例七
Integer i13=128;
int i14=128;
System.out.println(i13==i14);
```

* 注意`==`判断时，只要有基本数据类型，判断的就是值是否相等。