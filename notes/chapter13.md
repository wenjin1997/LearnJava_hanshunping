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
题1 下面代码会输出什么？有没有错误？[StringBufferExercise01.java](/code/chapter13/src/com/jinjin/stringbuffer_/StringBufferExercise01.java)
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
商品名 商品价格  
手机   123,564.59 //比如价格3,456,789,88  
要求：价格的小数点前面每三位用逗号隔开，再输出。