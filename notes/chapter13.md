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
  - [`String`类的常见方法](#string类的常见方法)
    - [说明](#说明)
    - [`String`类的常见方法一览](#string类的常见方法一览)
  - [`StringBuffer`类](#stringbuffer类)
    - [基本介绍](#基本介绍)
    - [`String` VS `StringBuffer`](#string-vs-stringbuffer)
    - [`String`和`StringBuffer`相互转换](#string和stringbuffer相互转换)
    - [`StringBuffer`类常见方法](#stringbuffer类常见方法)
    - [🚩🚩🚩`StringBuffer`类课后练习](#stringbuffer类课后练习)
  - [`StringBuilder`类](#stringbuilder类)
    - [基本介绍](#基本介绍-1)
    - [`StringBuilder`常用方法](#stringbuilder常用方法)
    - [`String`、`StringBuffer`和`StringBuilder`的比较](#stringstringbuffer和stringbuilder的比较)
    - [`String`、`StringBuffer`和`StringBuilder`的效率测试](#stringstringbuffer和stringbuilder的效率测试)
    - [`String`、`StringBuffer`和`StringBuilder`的选择](#stringstringbuffer和stringbuilder的选择)
  - [`Math`类](#math类)
    - [基本介绍](#基本介绍-2)
    - [方法一览（均为静态方法）](#方法一览均为静态方法)
  - [`Arrays`类](#arrays类)
    - [`Arrays`类常见方法应用案例](#arrays类常见方法应用案例)
    - [`Arrays`类课堂练习](#arrays类课堂练习)
  - [`System`类](#system类)
    - [`System`类常见方法和案例](#system类常见方法和案例)
  - [`BigInteger`和`BigDecimal`类](#biginteger和bigdecimal类)
    - [`BigInteger`和`BigDecimal`介绍](#biginteger和bigdecimal介绍)
    - [`BigInteger`和`BigDecimal`常见方法](#biginteger和bigdecimal常见方法)
  - [日期类](#日期类)
    - [第一代日期类](#第一代日期类)
    - [第二代日期类](#第二代日期类)
    - [第三代日期类](#第三代日期类)
    - [`DateTimeFormatter`格式日期类](#datetimeformatter格式日期类)
    - [`Instant`时间戳](#instant时间戳)
    - [第三代日期类的更多方法](#第三代日期类的更多方法)
  - [本章作业](#本章作业)
    - [⭐️⭐️作业1](#️️作业1)
    - [⭐️⭐️作业2](#️️作业2)
    - [⭐️作业3](#️作业3)
    - [⭐️作业4](#️作业4)
    - [作业5](#作业5)

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
1. 方式一：先从常量池查看是否有`hsp`数据空间，如果有，直接指向；如果没有则重新创建，然后指向。`s`最终指向的是常量池的空间地址。
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
4. 🚩🚩🚩题4 下列程序运行的结果是什么，尝试画出内存布局图。答案见[StringExercise10.java](/code/chapter13/src/com/jinjin/string_/StringExercise10.java)
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

## `String`类的常见方法
### 说明
`String`类是保存字符串常量的。每次更新都需要重新开辟空间，效率较低，因此java设计者还提供了`StringBuilder`和`StringBuffer`来增强`String`的功能，并提高效率。例如下面这段代码：  
```java
String s = new String("");
for (int i = 0; i < 80000; i++) {
    s += "hell0";
}
```

### `String`类的常见方法一览
* `equals` 区分大小写，判断内容是否相等
* `equalsIgnoreCase` 忽略大小写的判断内容是否相等
* `length` 获取字符的个数，字符串长度
* `indexOf` 获取字符在字符串中第1次出现的索引，索引是从0开始，如果找不到，返回-1
* `lastIndexOf` 获取字符在字符串中最后1次出现的索引，索引是从0开始，如果找不到，返回-1
* `substring` 截取指定范围的字符串
* `trim` 去前后空格
* `charAt` 获取某索引处的字符，注意不能使用`Str[index]`这种方式。

上述方法的使用案例见[StringMethod01.java](/code/chapter13/src/com/jinjin/string_/StringMethod01.java)

* `toUpperCase` 转换成大写
* `toLowerCase` 转换成小写
* `concat` 拼接字符串
* `replace` 替换字符串中的字符，注意`s1.replace()`方法执行后，返回的结果才是替换过的，对s1没有影响
* `spilt` 分割字符串，对于某些分割字符，我们需要转义，比如`|` `\\`等
* `compareTo` 比较两个字符串的大小，如果前者大，则返回正数，后者大，则返回负数，如果相等，返回0
  * 如果长度相同，并且每个字符也相同，就返回`0`
  * 如果长度相同或者不相同，但是在进行比较时，可以区分大小就返回 
    ```java
    if (c1 != c2) {
        return c1 - c2;
    }
    ```
  * 如果前面的部分都相同，就返回`str1.len - str2.len`
* `toCharArray` 转换成字符数组
* `format` 格式化字符串，`%s`字符串，`%c` 字符，`%d`整型，`%.2f`浮点数

上述方法的使用案例见[StringMethod02.java](/code/chapter13/src/com/jinjin/string_/StringMethod02.java)

## `StringBuffer`类
### 基本介绍
* `java.lang.StringBuffer`代表可变的字符序列，可以对字符串内容进行增删。
* 很多方法与`String`相同，但`StringBuffer`是可变长度的。
* `StringBuffer`是一个容器。

举例[StringBuffer01.java](/code/chapter13/src/com/jinjin/stringbuffer_/StringBuffer01.java)
1. `StringBuffer`的直接父类是`AbstractStringBuilder`
2. `StringBuffer`实现了`Serializable`, 即`StringBuffer`的对象可以串行化
3. 在父类`AbstractStringBuilder`中有属性`char[] value`,不是`final`,该 `value`数组存放字符串内容，引出存放在堆中的
4. `StringBuffer`是一个`final`类，不能被继承
5. 因为`StringBuffer`字符内容是存在`char[] value`, 所以在变化(增加/删除)不用每次都更换地址(即不是每次创建新对象)， 所以效率高于`String`

`StringBuffer`类图：

<img src="/notes/img-ch13/StringBuffer.png">

### `String` VS `StringBuffer`
1. `String`保存的是字符串常量，里面的值不能更改，每次`String`类的更新实际上就是地址，效率较低。
   ```java
   private final char value[]
   ```
2. `StringBuffer`保存的是字符串常量，里面的值可以更改，每次`StringBuffer`的更新实际上可以更新内容，不用每次更新地址，效率更高。
   ```java
   char[] value; //这个放在堆中
   ```

### `String`和`StringBuffer`相互转换
[StringAndStringBuffer.java](/code/chapter13/src/com/jinjin/stringbuffer_/StringAndStringBuffer.java)
* `String`->`StringBuffer`
  1. 使用构造器
  2. 使用`append`方法
* `StringBuffer`->`String`
  1. 使用`StringBuffer`提供的`toString`方法
  2. 使用构造器

### `StringBuffer`类常见方法
[StringBufferMethod.java](/code/chapter13/src/com/jinjin/stringbuffer_/StringBufferMethod.java)

主要掌握以下方法：
* `s.append("张三丰");` 增加字符串
* `s.delete(11,14);` 删除索引为[11,14)的字符
* `s.repalce(9,11,"周芷若");` 使用“周芷若”替换索引为[9,11)处的字符
* `s.indexOf("张三丰");` 查找指定的子串在字符串中第一次出现的索引，如果找不到返回-1
* `s.insert(9,"赵敏");` 在索引为9的位置插入“赵敏”，原来索引为9的内容自动后移
* `s.length()` 长度

### 🚩🚩🚩`StringBuffer`类课后练习
**题1** 

下面代码会输出什么？有没有错误？[StringBufferExercise01.java](/code/chapter13/src/com/jinjin/stringbuffer_/StringBufferExercise01.java)
```java
String str = null;
StringBuffer sb = new StringBuffer();
sb.append(str);
System.out.println(sb.length());

System.out.println(sb);
StringBuffer sb1 = new StringBuffer(str);
System.out.println(sb1);
```

🚩🚩**题2**

输入商品名称和价格，要求打印效果示例，使用前面学习的方法完成，答案见[StringBufferExercise02.java](/code/chapter13/src/com/jinjin/stringbuffer_/StringBufferExercise02.java) 
```
商品名  商品价格  
手机    123,564.59 //比如价格3,456,789,88 
``` 
要求：价格的小数点前面每三位用逗号隔开，再输出。

## `StringBuilder`类
### 基本介绍
1. 一个可变字符序列。此类提供一个与`StringBuffer`兼容的API，但不保证同步（`StringBuilder`不是线程安全）。该类被设计用作`StringBuffer`的一个简易替换，**用在字符串缓冲区被单个线程使用的时候**。如果可能，建议优先采用该类，因为在大多数实现中，它比`StringBuffer`要快。
2. 在`StringBuilder`上的主要操作是`append`和`insert`方法，可重载这些方法，以接受任意类型的数据。

关于`StringBuilder`要掌握的几点内容：
1. `StringBuilder`继承`AbstractStringBuilder`类
2. 实现了`Serializable`,说明`StringBuilder`对象是可以串行化(对象可以网络传输,可以保存到文件)
3. `StringBuilder`是`final`类, 不能被继承
4. `StringBuilder`对象字符序列仍然是存放在其父类`AbstractStringBuilder`的`char[] value;`因此，字符序列是堆中
5. `StringBuilder`的方法，没有做互斥的处理,即没有`synchronized`关键字,因此在单线程的情况下使用`StringBuilder`

`StringBuilder`的类图

<img src="/notes/img-ch13/StringBuilder.png">

### `StringBuilder`常用方法
`StringBuilder`和`StringBuffer`均代表可变的字符序列，方法是一样的，所以使用和`StringBuffer`一样。

* `StringBuilder`是`final`
* `StringBuilder`继承了`AbstractStringBuilder`，属性`char[] value`，内容存到`value`
* 实现了`Serializable`接口，序列化

### `String`、`StringBuffer`和`StringBuilder`的比较
1. `StrungBuilder`和`StringBuffer`非常类似，均代表可变字符序列，而且方法也一样
2. `String`：不可变字符序列，效率低，**但是复用率高**（要明白复用率高是什么意思，即在常量池中已经存在的字符，不用再创建）。
3. `StringBuffer`：可变字符序列，效率较高（增删）、线程安全。
4. `StringBuilder`：可变字符序列，效率最高、线程不安全。
5. `String`使用注意说明
    ```java
    String s = "a"; //创建了一个组反映
    s += "b"; 
    ```
    执行`s += "b";`时，实际上原来的"a"字符串对象已经丢弃了，现在又产生了一个字符串`s+"b"`(也就是`"ab"`)。如果多次执行这些改变串内容的操作，会导致大量副本字符串对象存留在内存中，降低效率。如果这样的操作放到循环中，会极大地影响程序的性能。 

    因此，**如果我们对字符串做大量的修改，不能使用`String`**。

### `String`、`StringBuffer`和`StringBuilder`的效率测试
效率：`StringBuilder` > `StringBuffer` > `String`  

案例见:[StringVsStringBufferVsStringBuilder.java](/code/chapter13/src/com/jinjin/stringbuilder_/StringVsStringBufferVsStringBuilder.java)

### `String`、`StringBuffer`和`StringBuilder`的选择
使用原则，结论：
1. 如果字符串存在大量的修改操作，一般使用`StringBuffer`或`StringBuilder`
2. 如果字符串存在大量的修改操作，并在单线程的情况，使用`StringBuilder`
3. 如果字符串存在大量的修改操作，并在多线程的情况，使用`StringBuffer`
4. 如果我们对字符串很少修改，被多个对象引用，使用`String`，比如配置信息等

## `Math`类
### 基本介绍
`Math`类包含用于执行基本数学运算的方法，比如初等指数、对数、平方根和三角函数。
### 方法一览（均为静态方法）
基本均为静态方法。

案例见[MathMethod.java](/code/chapter13/src/com/jinjin/math_/MathMethod.java)

**取随机数**：
`random`返回的是0<=x<1之间的一个随机小数，如果想返回[a,b)之间的随机整数，可以这样进行计算：
```java
(int)(a + Math.random * (b - a + 1))
```

## `Arrays`类
### `Arrays`类常见方法应用案例
`Arrays`里面包含了一系列静态方法，用于管理或操作数组（比如排序和搜索）。
1. `toString` 返回数组的字符串形式，如`Arrays.toString(str);`
2. `sort`排序（自然排序和定制排序）
3. `binarySearch`通过二分搜索进行查找，要求必须排好序
    ```java
    int index = Arrays.binarySearch(arr, 3);
    ```
4. `copyOf` 数组元素的复制
    ```java
    Integer[] newArr = Arrays.copyOf(arr, arr.length);
    ```
5. `fill`数组元素的填充
    ```java
    Integer[] num = new Integer[]{9, 3, 2};
    Arrays.fill(num, 99);
    ```
6. `equals`比较两个数值元素内容是否完全一致
    ```java
    boolean equals = Arrays.equals(arr, arr2);
    ```
7. `asList`将一组值，转换成`list`
    ```java
    List<Integer> asList = Arrays.asList(2, 3, 4, 5, 6, 1);
    System.out.println("asList=" + asList);
    ```

**`Arrays`类中的定制排序方法：**
[ArraysMethod01.java](/code/chapter13/src/com/jinjin/arrays_/ArraysMethod01.java)
```java
Arrays.sort(arr, new Comparator() {
    @Override
    public int compare(Object o1, Object o2) {
        Integer i1 = (Integer) o1;
        Integer i2 = (Integer) o2;
        return i2 - i1;
    }
});
```
这里体现了接口编程的方式 , 看看源码，就明白

源码分析:

(1) `Arrays.sort(arr, new Comparator()`

(2) 最终到`TimeSort`类的`private static <T> void binarySort(T[] a, int lo, int hi, int start,Comparator<? super T> c)()`

(3) 执行到`binarySort`方法的代码, 会根据动态绑定机制`c.compare()`执行我们传入的匿名内部类的 `compare ()`

```java
while (left < right) {
    int mid = (left + right) >>> 1;
    if (c.compare(pivot, a[mid]) < 0)
        right = mid;
    else
        left = mid + 1;
}
```

<img src="/notes/img-ch13/Arrays/compare.png">

(4) 根据动态绑定，执行重写后的`compare`方法
```java
new Comparator() {
    @Override
    public int compare(Object o1, Object o2) {
        Integer i1 = (Integer) o1;
        Integer i2 = (Integer) o2;
        return i2 - i1;
    }
}
```
(5) `public int compare(Object o1, Object o2)`返回的值`>0`还是`<0`会影响整个排序结果, 这就充分体现了接口编程+动态绑定+匿名内部类的综合使用,将来的底层框架和源码的使用方式，会非常常见。

**`Arrays`类中定制排序+冒泡排序：**
[ArraysSortCustom.java](/code/chapter13/src/com/jinjin/arrays_/ArraysSortCustom.java)


代码：
- [ArraysMethod01.java](/code/chapter13/src/com/jinjin/arrays_/ArraysMethod01.java)
- [ArraysMethod02.java](/code/chapter13/src/com/jinjin/arrays_/ArraysMethod02.java)
- [ArraysSortCustom.java](/code/chapter13/src/com/jinjin/arrays_/ArraysSortCustom.java)

### `Arrays`类课堂练习
[ArraysExercise.java](/code/chapter13/src/com/jinjin/arrays_/ArraysExercise.java)

自定义Book类，里面包含name和price，按price排序（从大到小）。要求使用两种方式排序，有一个`Book[] books = 4本书对象`。

使用前面学过的传递实现`Comparator`接口匿名内部类，也称为定制排序，可以按照价格从大到小、价格从小到大、书名长度从大到小排序。

**Remark**：
* 可以直接调用`Arrays.sort()`方法，因为这里`books`也是一个数组。由于`price`设置为`double`类型，而`compare`方法要求返回一个整型，可以进行如下处理：

```java
//1. 按照price从大到小排序
Arrays.sort(books, new Comparator() {
    @Override
    public int compare(Object o1, Object o2) {
        Book book1 = (Book) o1;
        Book book2 = (Book) o2;
        double priceValue = book1.getPrice() - book2.getPrice();
        if (priceValue > 0) {
            return -1;
        } else if (priceValue < 0) {
            return 1;
        } else {
            return 0;
        }
    }
});
```


## `System`类
### `System`类常见方法和案例
1. `exit` 退出当前程序，0表示状态，正常退出：
    ```java
    System.exit(0);
    ```
1. `arraycopy` 复制数组元素，比较适合底层调用，一般使用`Arrays.copyOf`完成复制数组。
    ```java
    int[] src ={1, 2, 3};
    int[] dest = new int[3];
    System.arraycopy(src, 0, dest, 0, 3);
    ```
2. `currentTimeMillens` 返回当前时间距离1970-1-1的毫秒数
3. `gc` 运行垃圾回收机制 `System.gc();`

案例代码：[System_.java](/code/chapter13/src/com/jinjin/system_/System_.java)

## `BigInteger`和`BigDecimal`类
### `BigInteger`和`BigDecimal`介绍
应用场景：
1. `BigInteger`适合保存比较大的整型
2. `BigDecimal`适合保存精度更高的浮点数（小数）

### `BigInteger`和`BigDecimal`常见方法
1. `add`加
2. `subtract` 减
3. `multiply` 乘
4. `divide` 除


**Remark:**
* 在小数进行除法时，有可能有无限循环小数，这时需要指定保留的精度，否则会出现`ArithmeticExceotion`异常。
```java
//System.out.println(bigDecimal.divide(bigDecimal2));//可能抛出异常ArithmeticException
//在调用divide 方法时，指定精度即可. BigDecimal.ROUND_CEILING
//如果有无限循环小数，就会保留 分子 的精度
System.out.println(bigDecimal.divide(bigDecimal2, BigDecimal.ROUND_CEILING));
```

代码：
- [BigInteger_.java](/code/chapter13/src/com/jinjin/bignum/BigInteger_.java)
- [BigDecimal_.java](/code/chapter13/src/com/jinjin/bignum/BigDecimal_.java)

## 日期类
### 第一代日期类
[Date01.java](/code/chapter13/src/com/jinjin/date_/Date01.java)
1. `Date`: 精确到毫秒，表示特定的瞬间
2. `SimpleDateFormat`: 格式化和解析日期的具体类。它允许进行格式化（日期 -> 文本）、解析（文本 -> 日期）和规范化。

<img src="/notes/img-ch13/Date/SimpleDateFormat.png">

```java
//1. 可以把一个格式化的String转成对应的 Date
//2. 得到Date仍然在输出时，还是按照国外的形式，如果希望指定格式输出，需要转换
//3. 在把String -> Date， 使用的 sdf 格式需要和你给的String的格式一样，否则会抛出转换异常
SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
String s = "1996年01月01日 10:20:30 星期一";
Date parse = sdf.parse(s);
System.out.println("parse=" + sdf.format(parse));
```

### 第二代日期类
[Calendar_.java](/code/chapter13/src/com/jinjin/date_/Calendar_.java)
1. 第二代日期类，主要是`Calendar`类（日历）。
```java
public abstract class Calendar implements Serializable, Cloneable, Comparable<Calendar> {

}
```
2. `Calendar`类是一个抽象类，它为特定瞬间与一组诸如`YEAR`、`MONTH`、`DAY_OF_MONTH`、`HOUR`等日历字段之间的转换提供了一些方法，并为操作日历字段（例如获得下星期的日期）提供了一些方法。

### 第三代日期类
* 前面两代日期类的不足分析
JDK 1.0中包含了一个`java.util.Date`类，但是它的大多数方法已经在`JDK 1.1`引入`Calendar`类之后被弃用了。而`Calendar`类也存在的问题是：
    1. 可变性：像日期和时间这样的类应该是不可变的。
    2. 偏移性：`Date`中的年份是从1990年开始的，而月份都从0开始。
    3. 格式化：格式化只对`Date`有用，`Calendar`则不行。
    4. 此外，它们也不是线程安全的；不能处理闰秒等（每隔两天，多出1s）

* `LocalDate`（日期/年月日）、`LocalTime`（时间/时分秒）、`LocalDateTime`（日期时间/年月日时分秒）JDK8加入

案例：[LocalDate_.java](/code/chapter13/src/com/jinjin/date_/LocalDate_.java)

### `DateTimeFormatter`格式日期类
JDK8之后有的，类似于`SimpleDateFormat`。

```java
DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
String format = dateTimeFormatter.format(ldt);
System.out.println("格式化的日期=" + format);
```

### `Instant`时间戳
类似于`Date`，提供了一系列和`Date`类转换的方式：
* `Instant` -> `Date`:
    ```java
    Date date = Date.from(instant);
    ```
* `Date`  -> `Instant`:
    ```java
    Instant instant = date.toInstant();
    ```
案例：[Instant_.java](/code/chapter13/src/com/jinjin/date_/Instant_.java)

### 第三代日期类的更多方法
* `LocalDateTime`类
* `MonthDay`类：检查重复事件
* 是否是闰年
* 增加日期的某个部分
* 使用`plus`方法测试增加时间的某个部分
* 使用`minus`方法测试查看一年前和一年后的日期
* 其他方法可以查看API使用

## 本章作业
### ⭐️⭐️作业1
编程题 [Homework01.java](/code/chapter13/src/com/jinjin/homework/Homework01.java)

1. 将字符串中指定部分进行反转。比如将"a**bcde**f"反转为"a**edcb**f"。
2. 编写方法`public static String reverse(String str, int start, int end)`搞定。

* **关键思路**：将`String`字符串转换为`char[]`数组，然后进行反转，最后再将`char[]`数组转换为`String`字符串。
* `String`字符串转换为`char[]`数组：`str.toCharArray()`
* 将`char[]`数组转换为`String`字符串：`new String(chars)`
* 注意有可能出现异常，因此需要抛出异常，处理异常时，先考虑正确的情况，再取反。
```java
public static String reverse(String str, int start, int end) {
    if (!(str != null && start < end && start >= 0 && end < str.length())){
        throw new RuntimeException("参数不正确");
    }

    char[] chars = str.toCharArray();
    char temp = ' ';
    //进行反转交换
    for (int i = start, j = end; i < j; i++, j--) {
        temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    return new String(chars);
}
```

### ⭐️⭐️作业2
编程题：[Homework02.java](/code/chapter13/src/com/jinjin/homework/Homework02.java)

输入用户名、密码、邮箱，如果信息录入正确，则提示注册成功，否则生成异常对象。要求：
1. 用户名长度为2或3或4
2. 密码长度为3，要求全是数字
3. 邮箱中包含`@`和`.`，并且`@`在`.`的前面。

* 注册过程可以写成一个方法，在方法中对各个信息进行验证。
* 验证一个字符串是否全是数字构成的方法：
```java
//校验字符串中全由数字构成
public static boolean isDigital(String str){
    char[] chars = str.toCharArray();
    for (int i = 0; i < chars.length; i++) {
        if (chars[i] < '0' || chars[i] > '9') {
            return false;
        }
    }
    return true;
}
```
* 验证邮箱中包含`@`和`.`，并且`@`在`.`的前面
```java
//邮箱中包含@和.，并且@在.的前面。
int i = email.indexOf('@');
int j = email.indexOf('.');
if (!(i > 0 && i < j)) {
    throw new RuntimeException("邮箱中包含@和.，并且@在.的前面!");
}
```

### ⭐️作业3
编程题: [Homework03.java](/code/chapter13/src/com/jinjin/homework/Homework03.java)

编写java程序，输入形式为`"Willian Jefferson Clinton"`，输出形式为`Clinton, Willian.J`

* 输出姓名时，可以使用`String.format`。
```java
String format = String.format("%s,%s. %c", names[2], names[0], names[1].toUpperCase().charAt(0));
System.out.println(format);
```

### ⭐️作业4
编程题: [Homework04.java](/code/chapter13/src/com/jinjin/homework/Homework04.java)

输入字符串，判断里面有多少个大写字母，多少个小写字母，多少个数字？

* 这里在统计字符串中各个符号的个数时，可以使用`charAt()`，就不需要将`String`类型转换为`char[]`数组了。

### 作业5
判断输出什么？答案见[Homework05.java](/code/chapter13/src/com/jinjin/homework/Homework05.java)
```java
public class Homework05 {
    public static void main(String[] args) {
        String s1 = "hspedu";
        Animal a = new Animal(s1);
        Animal b = new Animal(s1);
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a.name == b.name);
        String s4 = new String("hspedu");
        String s5 = "hspedu";

        System.out.println(s1 == s4);
        System.out.println(s4 == s5);

        String t1 = "hello" + s1;
        String t2 = "hellohspedu";
        System.out.println(t1.intern() == t2);


    }
}

class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }
}
```

* 注意`String t1 = "hello" + s1;`，因为这里`s1`是一个变量，因此这里会在堆中建立一个`StringBuilder`，然后再指向常量池中的`"hellohspedu"`。

<img src="/notes/img-ch13/homework05.png">