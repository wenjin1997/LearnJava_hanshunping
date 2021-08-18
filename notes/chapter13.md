- [第13章 常用类](#第13章-常用类)
  - [包装类](#包装类)
    - [包装类的分类](#包装类的分类)
    - [包装类和基本数据的转换](#包装类和基本数据的转换)
    - [⭐️⭐️课堂测试题](#️️课堂测试题)
    - [包装类型和`String`类型的相互转换](#包装类型和string类型的相互转换)
    - [`Integer`类和`Character`类的常用方法](#integer类和character类的常用方法)
    - [⭐️⭐️⭐️`Integer`类面试题](#️️️integer类面试题)
    - [🚩`Intege`类面试题总结](#intege类面试题总结)
  - [`String`类](#string类)
    - [`String`类的理解和创建对象](#string类的理解和创建对象)
    - [创建`String`对象的两种方式](#创建string对象的两种方式)
    - [两种创建`String`对象的区别](#两种创建string对象的区别)
    - [课堂测试题](#课堂测试题)
    - [面试题](#面试题)

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

## `String`类
### `String`类的理解和创建对象
[String01.java](/code/chapter13/src/com/jinjin/string_/String01.java)
1. `String`对象用于保存字符串，也就是一组字符序列
2. 字符串常量对象是用双引号括起的字符序列。例如：`"jack"`
3. 字符串的字符使用Unicode字符编码，一个字符(不区分字母还是汉字)占两个字节
4. `String`类有很多构造器，构造器的重载常用的有
    ```java
    String  s1 = new String();
    String  s2 = new String(String original);
    String  s3 = new String(char[] a);
    String  s4 = new String(char[] a,int startIndex,int count);
    String  s5 = new String(byte[] b);
    ```
5. `String`类实现了接口`Serializable`(`String`可以串行化:可以在网络传输),以及接口`Comparable`(`String`对象可以比较大小)
6. `String`是`final`类，不能被其他的类继承
7. `String`有属性`private final char value[];`用于存放字符串内容
8. 一定要注意：`value`是一个`final`类型，不可以修改(需要功力)：即`value`不能指向新的地址，但是单个字符内容是可以变化

<img src="/notes/img-ch13/String01.png">

### 创建`String`对象的两种方式
1. 方式一：直接赋值`String s = "hsp";`
2. 方式二：调用构造器`String s = new String("hsp");`

### 两种创建`String`对象的区别
1. 方式一：先从常量池查看是否有"jinjin"数据空间，如果有，直接指向；如果没有则重新创建，然后指向。`s`最终指向的是常量池的空间地址。
2. 方式二：先在堆中创建空间，里面维护了`value`属性，指向常量池的`hsp`空间。如果常量池没有`hsp`，重新创建，如果有，直接通过`value`指向。最终指向的是堆中的空间地址。
3. 内存分布图
   
   <img src="/notes/img-ch13/string02.png">

### 课堂测试题
1. 测试题1 [StringExercise01.java](/code/chapter13/src/com/jinjin/string_/StringExercise01.java)
   ```java
    String a = "abc";
    String b ="abc";
    System.out.println(a.equals(b));
    System.out.println(a==b); 
   ```

   <img src="/notes/img-ch13/StringExercise/ex1.png">

2. 测试题2 [StringExercise02.java](/code/chapter13/src/com/jinjin/string_/StringExercise02.java)
    ```java
    String a = new String("abc");
    String b =new String("abc");
    System.out.println(a.equals(b));
    System.out.println(a==b);
    ```
3. 🚩测试题3 [StringExercise03.java](/code/chapter13/src/com/jinjin/string_/StringExercise03.java)
    ```java
    String a = "hsp";
    String b =new String("hsp");
    System.out.println(a.equals(b)); 
    System.out.println(a==b); 
    System.out.println(a==b.intern());
    System.out.println(b==b.intern());
    ```

    <img src="/notes/img-ch13/StringExercise/ex3.png">

    * 当调用`intern`方法时，如果池已经包含一个等于此`String`对象的字符串（用`equals(Object)`方法确定），则返回池中的字符串。否则，将此`String`对象添加到池中，并返回此`String`对象的引用。
    * `b.intern()`方法最终返回的是常量池的地址（对象）。
4. 测试题4 [StringExercise04.java](/code/chapter13/src/com/jinjin/string_/StringExercise04.java)
    ```java
    String s1 = "hspedu";
    String s2 = "java"; 
    String s4 = "java";
    String s3 = new String("java");
    System.out.println(s2 == s3);
    System.out.println(s2 == s4); 
    System.out.println(s2.equals(s3));
    System.out.println(s1 == s2);
    ```

    <img src="/notes/img-ch13/StringExercise/ex4.png">

5. 测试题5 [StringExercise05.java](/code/chapter13/src/com/jinjin/string_/StringExercise05.java)
   ```java
   Person p1 = new Person();
    p1.name = "hspedu";
    Person p2 = new Person();
    p2.name = "hspedu";


    System.out.println(p1.name.equals(p2.name));
    System.out.println(p1.name == p2.name);  
    System.out.println(p1.name == "hspedu");   

    String s1 = new String("bcde");
    String s2 = new String("bcde");
    System.out.println(s1==s2); 
   ```

   <img src="/notes/img-ch13/StringExercise/ex5.png">

### 面试题
1. 🚩题1
   ```java
   String a = "hello" + "abc";
   ```
   创建了几个对象？
   * 只有1个对象
   * 编译器不傻，会做一个优化，判断创建的常量池对象，是否有引用指向
   * `String a = "hello" + "abc";`优化定价于`String a = "helloabc";`
2. 🚩🚩题2 [StringExercise08.java](/code/chapter13/src/com/jinjin/string_/StringExercise08.java)
    ```java
    String a = "hello";
    String b = "abc";
    String c = a + b;
    ```
    上述语句创建了几个对象？画出内存图。
    * 底层是
    ```java
    StringBuilder sb = new StringBuilder();
    sb.append(a);
    sb.append(b);
    ```
    <img src="/notes/img-ch13/StringExercise/ex8.png">

    `sb`是在堆中，并且`append`是在原来字符串的基础上追加的。
    * `String c1 = "ab" + "cd";`常量相加，看的是池。`String c1 = a + b;`变量相加，是在堆中。
3. 题3 下面的代码输出什么？并说明原因。答案见[StringExercise09.java](/code/chapter13/src/com/jinjin/string_/StringExercise09.java)
    ```java
    String s1 = "hspedu";
    String s2 = "java";
    String s5 = "hspedujava";
    String s6 = (s1 + s2).intern();
    System.out.println(s5 == s6);
    System.out.println(s5.equals(s6));
    ```
4. 题4 下列程序运行的结果是什么，尝试画出内存布局图。答案见[StringExercise10.java](/code/chapter13/src/com/jinjin/string_/StringExercise10.java)
    ```java
    public class Test1 {
        String str = new String("hsp");
        final char[] ch = {'j', 'a', 'v', 'a'};

        public void change(String str, char ch[]) {
            str = "java";
            ch[0] = 'h';
        }

        public static void main(String[] args) {
            Test1 ex = new Test1();
            ex.change(ex.str, ex.ch);
            System.out.print(ex.str + " and ");
            System.out.println(ex.ch);
        }
    }
    ```

    <img src="/notes/img-ch13/StringExercise/ex10.png">