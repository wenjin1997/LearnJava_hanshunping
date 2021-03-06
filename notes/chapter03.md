- [第3章 变量](#第3章-变量)
  - [变量使用注意事项](#变量使用注意事项)
  - [🚩数据类型](#数据类型)
  - [整数类型](#整数类型)
  - [浮点类型](#浮点类型)
  - [Java API 文档](#java-api-文档)
  - [字符类型(`char`)](#字符类型char)
  - [布尔类型：`boolean`](#布尔类型boolean)
  - [基本数据类型转换](#基本数据类型转换)
    - [自动类型转换注意和细节](#自动类型转换注意和细节)
  - [强制类型转换](#强制类型转换)
    - [强制类型转换细节](#强制类型转换细节)
  - [基本数据类型转换——练习题](#基本数据类型转换练习题)
  - [基本数据类型和`String`类型的转换](#基本数据类型和string类型的转换)
  - [本章作业](#本章作业)
# 第3章 变量
## 变量使用注意事项
* 变量表示内存中的一个存储区域（不同的变量，类型不同，占用的空间大小不同）
* 变量必须先声明，后使用，即有顺序
* 变量三个基本要素：**类型+名称+数据类型**

## 🚩数据类型
每一种数据都定义了明确的数据类型，在内存中分配了不同大小的内存空间(字节)。

<img src="/notes/img-ch3/variable.png">

## 整数类型

<img src="/notes/img-ch3/Integer.png">

**整型的使用细节**
1. Java各整数类型有固定的范围和字段长度，不受具体OS（操作系统）的影响，以保证Java程序的可移植性。
2. **Java的整型常量默认为`int`型，声明`long`型常量须后加`'l'`或`'L'`**
3. Java程序中变量常声明为`int`型，除非不足以表示大数，才使用`long`
4. `bit`：计算机中的最小存储单位。`byte`：计算机中基本存储单位。`1 byte = 8 bit`

<img src="/notes/img-ch3/Integer02.png">

## 浮点类型

<img src="/notes/img-ch3/Float01.png">

* ⭐️浮点数在机器中存放形式：**浮点数 = 符号位 + 指数位 + 尾数位**
* 尾数部分可能丢失，造成精度损失（小数都是近似值）
* 与整数类型类似，Java浮点类型也有固定的范围和字段长度，不受具体OS（操作系统）的影响。(`float`是4个字节，`double`是8个字节)
* **Java的浮点型常量默认是`double`型，声明`float`型常量，须后加`'f'`或`'F'`**
* 浮点型常量有**两种表示形式**
    * 十进制数形式：如`5.12`、`512.0f`、`.512`(必须有小数点)
    * 科学计数形式：如`5.12e2`(5.12 * 10^2) `5.12E-2`(5.12 * 10^(-2))
* 通常情况下，应该使用`double`型，因为它比`float`型更精确。
* **浮点数使用陷阱**：2.7和8.1/3比较
  * 当我们对运算结果是小数的进行相等判断是，要小心！应该是以两个数的差值的绝对值，**在某个精度范围类判断**。

## Java API 文档
1. API(Application Programming Interface, 应用程序编程接口)是Java提供的基本编程接口（Java提供的类还有相关的方法）。[中文在线文档](https://www.matools.com/api/java8)
2. Java类的组织形式

<img src="/notes/img-ch3/API.png">

## 字符类型(`char`)
* 字符类型可以表示单个字符,字符类型是`char`，`char`是两个字节(可以存放汉字)，多个字符我们用字符串`String`
* 字符常量是用单引号`''`括起来的单个字符。
* Java中还允许使用转义字符`'\'`来将其后的字符转变为特殊字符型常量。
* 在Java中，**`char`的本质是一个整数，在输出时，是Unicode码对应的字符。**
* 可以直接给`char`赋一个整数，然后输出时，会按照对应的Unicode字符输出，例如97->a
* `char`类型是可以进行运算的，相当于一个整数，因为它都有对应的Unicode码。

**字符与码值**
1. 字符型存储到计算机中，需要将字符对应的码值（整数）找出来，例如`'a'`存储：`'a'` -> 码值97 -> 二进制110 0001 -> 存储。读取：二进制110 0001 -> 97 -> `'a'` -> 显示
2. 字符和码值的对应关系是通过字符编码表决定的

**字符编码表**
* ASCII：ASCII编码表，一个字节表示。一个128个字符，实际上一个字节可以表示256个字符，只用128个
* Unicode：Unicode编码表，固定大小的编码，使用两个字节来表示字符，字母和汉字统一都是占用两个字节，这样浪费空间
* **UTF-8**：编码表，大小可变的编码，字母使用1个字节，汉字使用3个字节，使用较多
* GBK：可以表示汉字，而且范围广，字母使用1个字节，汉字2个字节
* GB2312：可以表示汉字，GB2312可以表示的汉字比GBK少，实际使用较少。
* BIG5：繁体中文
* Unicode码兼容ASCII码

## 布尔类型：`boolean`
* 布尔类型数据只允许取值`true`和`false`，无`null`
* 布尔类型占1个字节。

## 基本数据类型转换
* 当Java程序在进行赋值或者运算时，精度小的类型自动转换为精度大的数据类型，这个就是**自动类型转换**。
* 🚩数据类型按精度（容量）大小排序为：

<img src="/notes/img-ch3/AutoConvert.png">

### 自动类型转换注意和细节
⭐️[AutoConvertDetail.java](/code/chapter03/src/AutoConvertDetail.java)
1. **有多种类型的数据混合运算时，系统首先自动将所有数据转换成容量最大的那种数据类型，然后再进行计算。**
2. 当我们把精度大的数据类型赋值给精度小的数据类型时，就会报错，反之就会进行自动类型转换。
3. **`byte`,`short`和`char`之间不会相互自动转换。**
4. `byte`,`short`,`char`它们三者可以计算，**在计算时首先转换为`int`类型**。**如果是两个`byte`的值进行运算，也会先转换为`int`类型。**
5. `boolean`不参与类型自动转换。
6. 自动提升原则：**表达式结果的类型自动提升为操作数中最大的类型**

## 强制类型转换
自动类型转换的逆过程，**将容量大的数据类型转换为容量小的数据类型**。使用时要加上强制转换符`( )`，但可能造成**精度降低或溢出**,格外要注意。
### 强制类型转换细节
[ForceConvertDetail.java](/code/chapter03/src/ForceConvertDetail.java)
1. 当进行数据的大小从 大 -> 小，就需要使用到强制转换
2. **强转符号只针对于最近的操作数有效**，往往会使用小括号提升优先级。
3. **`char`类型可以保存`int`的常量值，但不能保存`int`的变量值，需要强制转换**
4. **`byte`和`short`,`char`类型在进行运算时，当作`int`类型处理。**

## 基本数据类型转换——练习题

<img src="/notes/img-ch3/ConvertExercise.png">

* 注意第1小问和第2小问

## 基本数据类型和`String`类型的转换
* 基本类型转`String`类型，将基本类型的值 + ""即可。
* `String`类型转基本类型，通过基本类型的包装类调用`parseXX`方法即可。
* 在将`String`类型转成基本数据类型时，要确保`String`类型能够转成有效数据，比如我们可以把`"123"`转成一个整数，但是不能把`"hello"`转成一个整数。
* 如果格式不正确，就会抛出异常，程序就会终止。

## 本章作业
注意下面问题：
```java
char gender1 = '男';
char gender2 = '女';
//注意这里输出的是对应ASCII码值相加的结果，是一个整数
System.out.println(gender1 + gender2); //输出52906
```