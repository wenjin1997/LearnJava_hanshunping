- [第10章 面向对象编程（高级部分）](#第10章-面向对象编程高级部分)
  - [10.1 类变量和类方法](#101-类变量和类方法)
    - [类变量快速入门](#类变量快速入门)
    - [类变量的内存布局](#类变量的内存布局)
    - [类变量](#类变量)
    - [类变量使用注意事项和细节讨论](#类变量使用注意事项和细节讨论)
    - [类方法](#类方法)
    - [⭐️类方法使用注意事项和细节讨论](#️类方法使用注意事项和细节讨论)
  - [10.2 理解`main`方法语法](#102-理解main方法语法)
    - [解释`main`方法的形式](#解释main方法的形式)
    - [特别提示](#特别提示)
    - [在IDEA中如何传递参数](#在idea中如何传递参数)
  - [10.3 代码块](#103-代码块)
    - [基本介绍](#基本介绍)
    - [基本语法](#基本语法)
    - [代码块的好处](#代码块的好处)
    - [🚩代码块使用注意事项和细节讨论](#代码块使用注意事项和细节讨论)
    - [练习题](#练习题)
  - [10.4 单例设计模式](#104-单例设计模式)
    - [什么是设计模式](#什么是设计模式)
    - [什么是单例模式](#什么是单例模式)
    - [单例模式应用实例](#单例模式应用实例)
      - [⭐️饿汉式VS懒汉式](#️饿汉式vs懒汉式)
  - [10.5 `final`关键字](#105-final关键字)
    - [基本介绍](#基本介绍-1)
    - [`final`使用注意事项和细节讨论](#final使用注意事项和细节讨论)
    - [`final`练习](#final练习)
  - [10.6 抽象类](#106-抽象类)
    - [抽象类的介绍](#抽象类的介绍)
    - [🚩抽象类使用的注意事项和细节讨论](#抽象类使用的注意事项和细节讨论)
    - [练习](#练习)
  - [10.7 抽象类最佳实践—模板设计模式](#107-抽象类最佳实践模板设计模式)
    - [基本介绍](#基本介绍-2)
    - [模板设计模式能解决的问题](#模板设计模式能解决的问题)
    - [最佳实践](#最佳实践)
  - [10.8 接口](#108-接口)
    - [快速入门](#快速入门)
    - [基本介绍](#基本介绍-3)
    - [深入讨论](#深入讨论)
    - [注意事项和细节](#注意事项和细节)
    - [课堂练习](#课堂练习)
    - [实现接口 VS 继承类](#实现接口-vs-继承类)
    - [接口的多态属性](#接口的多态属性)
    - [内部类的分类](#内部类的分类)
    - [局部内部类的使用](#局部内部类的使用)
    - [🚩🚩🚩匿名内部类的使用](#匿名内部类的使用)
    - [匿名内部类的最佳实践](#匿名内部类的最佳实践)
    - [匿名内部类练习](#匿名内部类练习)
    - [成员内部类的使用](#成员内部类的使用)
    - [静态内部类的使用](#静态内部类的使用)
    - [练习题](#练习题-1)

# 第10章 面向对象编程（高级部分）
## 10.1 类变量和类方法
### 类变量快速入门
提出问题：有一群小孩在玩堆雪人,不时有新的小孩加入,请问如何知道现在共有多少人在玩?编写程序解决。[ChildGame.java](/code/chapter10/src/com/jinjin/static_/ChildGame.java)

在类Child中定义一个类变量，统计有多少小孩加入了游戏。
```java
//类变量count，统计有多少小孩加入游戏
public static int count = 0;
```

### 类变量的内存布局
<img src="/notes/img-ch10/static.png">

* 静态变量具体存放在哪里与JDK版本有关系，JDK7以上的版本，存放在class对象中，JDK7之前存放在静态域中。
* 不管static变量存放在哪里，有以下两点共识：
  1. static变量是同一个类所有对象共享。
  2. static类变量，在类加载的时候就生成了。

### 类变量
* **什么是类变量**：类变量也叫静态变量/静态属性，是该类的所有对象共享的变量，任何一个该类的对象去访问它时，取到的都是相同的值，同样任何一个该类的对象去修改它时，修改的也是同一个变量。
* **如何定义类变量**
    ```java
    访问修饰符 static 数据类型 变量名; //推荐
    static 访问修饰符 数据类型 变量名;
    ```
* **如何访问类变量** [VisitStatic.java](/code/chapter10/src/com/jinjin/static_/VisitStatic.java)
    ```java
    类名.类变量名 //推荐
    对象名.类变量名
    ```
    * 静态变量的访问修饰符的访问权限和范围和普通属性是一样的。
    * 类变量是随着类的加载而创建，所以即使没有创建对象实例也可以访问。

### 类变量使用注意事项和细节讨论
1. 什么时候需要用类变量  
    当我们需要让某个类的所有对象都共享一个变量时，就可以考虑类变量（静态变量）。比如：定义学生类，统计所有学生共交多少钱。
2. 类变量与实例变量（普通属性）区别  
    类变量是该类的所有对象共享的，而实例变量是每个对象独享的。
3. 加上`static`称为类变量或静态变量，否则称为实例变量/普通变量/非静态变量。
4. 类变量可以通过`类名.类变量名`或者`对象名.类变量名`来访问，但java设计者推荐我们使用`类名.类变量名`方式访问。【**前提是**满足访问修饰符的权限和范围】
5. 实例变量不能通过`类名.类变量名`方式访问。
6. 类变量是在类加载时就初始化了，也就是说，即使你没有创建对象，只要类加载了，就可以使用类变量了。
7. 类变量的生命周期是随类的加载开始，随着类消亡而销毁。

### 类方法
* 类方法基本介绍  
类方法也叫静态方法。形式如下：
    ```java
    访问修饰符 static 数据返回类型 方法名() { } //推荐
    static 访问修饰符 数据返回类型 方法名() { } 
    ```
* 类方法的调用  
使用方式：`类名.类方法名`或者`对象名.类方法名`，前提是满足访问修饰符的访问权限和范围。

* 类方法经典的使用场景  
当方法中不涉及到任何和对象相关的成员，则可以将方法设计成静态方法，提高开发效率。比如：工具类中的方法utils、Math类、Arrays类、Collections集合类。  
在程序的实际开发中，往往会将一些通用的方法设计成静态方法，这样我们不需要创建对象就可以使用了，比如打印一维数组，冒泡排序，完成某个计算任务等。

### ⭐️类方法使用注意事项和细节讨论
1. 类方法和普通方法都是随着类的加载而加载，将结构信息存储在方法区：类方法中无this的参数、普通方法中隐含着this的参数。
2. 类方法可以通过类名调用，也可以通过对象名调用。
3. 普通方法和对象有关，需要通过对象名调用，比如`对象名.方法名(参数)`，不能通过类名调用。
4. 类方法中不允许使用和对象有关的关键字，比如`this`和`super`。普通方法（成员方法）可以。
5. **类方法（静态方法）中只能访问静态变量或静态方法。**
6. 普通成员方法，既可以访问非静态成员，也可以访问静态成员。

⭐️**小结**：
1. 静态方法，只能访问静态的成员；
2. 非静态的方法，可以访问所有成员；
3. 在编写代码时，仍然要遵守访问权限规则。

## 10.2 理解`main`方法语法
### 解释`main`方法的形式
```java
public static void main(String[] args){}
```

1. `main()`方法是虚拟机调用
2. java虚拟机需要调用类的`main()`方法，所以该方法的访问权限必须是`public`
3. java虚拟机在执行`main()`方法时不必创建对象，所以该方法必须是`static`
4. 该方法接收`String`类型的数组参数，该数组中保存执行java命令时传递给所运行的类的参数
5. `java 执行的程序 参数1 参数2 参数3 ...`
<img src="/notes/img-ch10/main.png">

### 特别提示
1. 在`main()`方法中，我们可以直接调用`main`方法所在类的静态方法或静态属性。
2. 但是，不能直接访问该类中的非静态成员，必须创建该类的一个实例对象后，才能通过这个对象去访问类中的非静态成员。

### 在IDEA中如何传递参数
步骤1：

<img src="/notes/img-ch10/main-idea1.png">

步骤2:

<img src="/notes/img-ch10/main-idea2.png">

应用保存后，再执行就可以了。

<img src="/notes/img-ch10/main-idea3.png">

## 10.3 代码块
### 基本介绍
代码块又称为初始化块，属于类中的成员[即是类的一部分]，类似于方法，将逻辑语句封装在方法体中，通过`{}`包围起来。
但和方法不同，没有方法名，没有返回，没有参数，只有方法体，而且不用通过对象或类显式调用，而是在加载类时，或创建对象时隐式调用。

### 基本语法
```java
[修饰符]{ //修饰符可选，不写或者是static
    代码
}; //;也可以省略
```
1. 修饰符可选，要写的话，也只能写`static`。
2. 代码块分为两类，使用`static`修饰的叫静态代码块，没有`static`修饰的，叫普通代码块/非静态代码块。
3. `;`号可以写上，也可以省略。

### 代码块的好处
1. **相当于另外一种形式的构造器（对构造器的补充机制），可以做初始化操作。**
2. 场景：如果多个构造器中都有重复的语句，可以抽取到初始化代码块中，提高代码的重用性。
3. 代码块快速入门：[CodeBlock01.java](/code/chapter10/src/com/jinjin/codeblock_/CodeBlock01.java)
   * 不管调用哪个构造器，创建对象，都会先调用代码块的内容。
   * 代码块调用的顺序优先于构造器...

### 🚩代码块使用注意事项和细节讨论
**细节1-3**:
1. `static`代码块也叫静态代码块，作用是对类进行初始化，而且它随着类的加载而执行，并且只会执行一次。如果是普通代码块，每创建一个对象，就执行。
2. ⭐️⭐️**类什么时候被加载**
   1. 创建对象实例时(new)
   2. 创建子类对象实例，父类也会被加载，而且父类先被加载，子类后被加载
   3. 使用类的静态成员时(静态属性，静态方法)
3. 普通的代码块，在创建对象实例时，会被隐式的调用。被创建一次，就会调用一次。如果只是使用类的静态成员时，普通代码块并不会执行。

**细节1-3代码**:[CodeBlockDetail01.java](/code/chapter10/src/com/jinjin/codeblock_/CodeBlockDetail01.java)

⭐️⭐️**细节1-3小结**：
   1. `static`代码块是类加载时执行，只会执行一次。
   2. 普通代码块是在创建对象时调用的，创建一次，调用一次。
   3. 类加载的3种情况，需要记住。


🚩⭐️⭐️⭐️**细节4**：创建一个对象时，在一个类调用顺序是（重点、难点）：
1. 调用静态代码块和静态属性初始化（注意：静态代码块和静态属性初始化调用的优先级一样，如果有多个静态代码块和多个静态变量要初始化，则按他们定义的顺序调用）
2. 调用普通代码块和普通属性初始化（注意：普通代码块和普通属性初始化调用的优先级一样，如果有多个普通代码块和多个普通属性初始化，则按定义顺序调用）
3. 调用构造方法。

⭐️**细节5**:

构造器的最前面其实隐含了`super()`和普通代码块。静态相关的代码块及属性初始化，在类加载时，就执行完毕，因此是优先于构造器和普通代码块执行的。
```java
class A {
    public A() {
        //这里隐藏的执行要求
        //(1)super();
        //(2)调用普通代码块
        System.out.println("ok");
    }
}
```

🚩🚩⭐️**细节6**：

我们看一下创建一个子类对象时（继承关系），它们的静态代码块，静态属性初始化，普通代码块，普通属性初始化，构造方法的调用顺序：
1. 父类的静态代码块和静态属性（优先级一样，按定义顺序执行）
2. 子类的静态代码块和静态属性（优先级一样，按定义顺序执行）
3. 父类的普通代码块和普通属性初始化（优先级一样，按定义顺序执行）
4. 父类的构造方法
5. 子类的普通代码块和普通属性初始化（优先级一样，按定义顺序执行）
6. 子类的构造方法 //面试题

例子：[CodeBlockDetail04.java](/code/chapter10/src/com/jinjin/codeblock_/CodeBlockDetail04.java)

**细节7**：

静态代码块只能直接调用静态成员（静态属性和静态方法），普通代码块可以调用任意成员。

### 练习题
下面的代码块输出什么？[CodeBlockExercise02.java](/code/chapter10/src/com/jinjin/codeblock_/CodeBlockExercise02.java)
```java
class Sample {
    Sample(String s) {
        System.out.println(s);
    }

    Sample() {
        System.out.println("Sample 默认构造函数被调用");
    }
}

class Test {
    Sample sam1 = new Sample("sam1 成员初始化");
    static Sample sam = new Sample("静态成员 sam 初始化 ");

    static {
        System.out.println("static 块执行");
        if (sam == null) System.out.println("sam is null");
    }

    Test()//构造器
    {
        System.out.println("Test 默认构造函数被调用");
    }

    //主方法
    public static void main(String str[]) {
        Test a = new Test();//无参构造器
    }
}
```
输出结果：

<img src="/notes/img-ch10/codeblock-ex2.png">

## 10.4 单例设计模式
### 什么是设计模式
1. 静态方法和属性的经典使用
2. 设计模式是在大量的实践中总结和理论化之后优选的代码结构、编程风格、以及解决问题的思考方式。设计模式就像是经典的棋谱，不同的棋局，我们用不同的棋谱，免去我们自己再思考和摸索。

### 什么是单例模式
单例（单个的实例）  
1. 所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，**对其个类只能存在一个对象实例，并且该类只提供一个取得其对象实例的方法**
2. 单例模式有两种方式：
   1. 饿汉式
   2. 懒汉式

### 单例模式应用实例
**步骤如下：**
1. 构造器私有化，防止直接`new`
2. 类的内部创建对象
3. 向外暴露一个静态的公共方法

**饿汉式实例**：[SingleTon01.java](/code/chapter10/src/com/jinjin/single_/SingleTon01.java)
1. 将构造器私有化，防止直接new
2. 在类的内部直接创建对象(该对象是`static`)
3. 提供一个公共的`static`方法，返回`gf`对象

**懒汉式实例**：[SingleTon02.java](/code/chapter10/src/com/jinjin/single_/SingleTon02.java)
1. 将构造器私有化
2. 定义一个`static`静态属性对象
3. 提供一个`public`的`static`方法，可以返回一个`Cat`对象
4. 懒汉式，只有当用户使用`getInstance`时，才返回`Cat`对象，后面再次调用时，会返回上次创建的的`Cat`对象，从而保证了单例

#### ⭐️饿汉式VS懒汉式
1. 二者最主要的区别在于创建对象的**时机**不同：饿汉式是在类加载就创建了对象实例，而懒汉式是在使用时才创建。
2. 饿汉式不存在线程安全问题，**懒汉式存在线程安全问题**。
3. **饿汉式存在浪费资源的可能**。因为如果程序员一个对象实例都没有使用，那么饿汉式创建的对象就浪费了，懒汉式是使用时才创建，不存在这个问题。
4. 在我们JavaSE标准类中，`java.lang.Runtime`就是经典的单例模式。

## 10.5 `final`关键字
### 基本介绍
`final`中文意思：最后的，最终的。  
`final`可以修饰类、属性、方法和局部变量。  
在某些情况下，程序员可能有以下需求，就会使用到`final`：
1. 当不希望类被继承时，可以用`final`修饰。
2. 当不希望父类的某个方法被子类覆盖/重写(override)时，可以用`final`关键字修饰。
3. 当不希望类的某个属性的值被修改，可以用`final`修饰。
4. 当不希望某个局部变量被修改，可以使用`final`修饰。

### `final`使用注意事项和细节讨论
1. `final`修饰的属性又叫常量，一般用XX_XX_XX来命名
2. `final`修饰的属性在定义时，必须赋初值，并且以后不能再修改，**赋值可以在如下位置之一**（选择一个位置赋初值即可）：
   1. 定义时：如`public final double TAX_RATE = 0.08;`
   2. 在构造器中
   3. 在代码块中
3. 如果`final`修饰的属性是静态的，则初始化的位置只能是：
   1. 定义时
   2. 在静态代码块中，不能在构造器中赋值
4. `final`类不能继承，但是可以实例化对象
5. 如果类不是`final`类，但是含有`final`方法，则该方法虽然不能重写，但是可以被继承。
6. 一般来说，如果一个类已经是`final`类了，就没有必要再将方法修饰为`final`方法。
7. `final`不能修饰构造方法（即构造器）
8. ⭐️❓`final`和`static`往往搭配使用，效率更高，不会导致类加载。底层编译器做了优化处理。
    ```java
    class Demo {
        public static final int NUM = 16;
        static{
            System.out.println("进进");
        }
    }
    ```
    当在`main`方法中执行`Demo.NUM`时，不会执行`static`代码块。
9. 包装类(Integer,Double,Float,Boolean等都是final),String类也是final类。

### `final`练习
请编写一个程序，能够计算圆形的面积。要求圆周率为3.14。赋值的三个方式都写一下。[FinalExercise01.java](/code/chapter10/src/com/jinjin/final_/FinalExercise01.java)

## 10.6 抽象类
### 抽象类的介绍
当父类的某些方法，需要声明，但是又不确定如何实现时，可以将其声明为抽象方法，那么这个类就是抽象类。

把Animal做成抽象类，并让子类Cat类实现。
```java
abstract class Animal{
    String name;
    int age;
    public abstract void cry();
}
```
1. 用abstract关键字来修饰一个类时，这个类就叫抽象类。
    ```java
    访问修饰符 abstract 类名{
        
    }
    ```
2. 用abstract关键字来修饰一个方法时，这个方法就是抽象方法
    ```java
    访问修饰符 abstract 返回类型 方法名(参数列表); //没有方法体
    ```
3. 抽象类的价值更多作用是在于设计，是设计者设计好后，让子类继承并实现抽象类
4. 抽象类，是考官比较爱问的知识点，在框架和设计模式使用较多

### 🚩抽象类使用的注意事项和细节讨论
1. 抽象类不能被实例化
2. 抽象类不一定要包含`abstract`方法。也就是说，抽象类可以没有`abstract`方法。
3. 一旦类包含了`abstract`方法，则这个类必须声明为`abstract`。
4. `abstract`只能修饰类和方法，不能修饰属性和其它的。
5. 抽象类可以有任意成员（**抽象类本质还是类**），比如：非抽象方法、构造器、静态属性等等。
6. 抽象方法不能有主体，即不能实现。
7. 如果一个类继承了抽象类。则它必须实现抽象类的所有抽象方法，除非它自己也声明为`abstract`类。
8. 抽象方法不能使用`private`、`final`和`static`来修饰，因为这些关键字和重写相违背。

### 练习
编写一个Employee类，声明为抽象类，包含如下三个属性：name,id,salary。提供必要的构造器和抽象方法：work()。对于Manager来说，他既是员工，还具有奖金(bonus)的属性。请使用继承的思想，设计CommonEmployee类和Manager类，要求类中提供必要的方法进行属性访问，实现work()，提示“经理/普通员工 名字 工作中...”

代码：
- [Employee.java](/code/chapter10/src/com/jinjin/abstract_/Employee.java)
- [CommonEmployee.java](/code/chapter10/src/com/jinjin/abstract_/CommonEmployee.java)
- [Manager.java](/code/chapter10/src/com/jinjin/abstract_/Manager.java)
- [AbstractExercise01.java](/code/chapter10/src/com/jinjin/abstract_/AbstractExercise01.java)

## 10.7 抽象类最佳实践—模板设计模式
### 基本介绍
抽象类体现的就是一种模板模式的设计，抽象类作为多个子类的通用模板，子类在抽象类的基础上进行扩展、改造，单个子类总体上会保留抽象类的行为方式。

### 模板设计模式能解决的问题
1. 当功能内部一部分实现是确定，一部分实现是不确定的。这时可以把不确定的部分暴露出去，让子类去实现。
2. 编写一个抽象父类，父类提供了多个子类的通用方法，并把一个或多个方法留给其子类实现，就是一种模板模式。

### 最佳实践
<img src="/notes/img-ch10/template.png">

**代码**：
- [Template.java](/code/chapter10/src/com/jinjin/abstract_/template_/Template.java)
- [A.java](/code/chapter10/src/com/jinjin/abstract_/template_/A.java)
- [B.java](/code/chapter10/src/com/jinjin/abstract_/template_/B.java)
- [TestTemplate.java](/code/chapter10/src/com/jinjin/abstract_/template_/TestTemplate.java)

**Note**：  
在[Template.java](/code/chapter10/src/com/jinjin/abstract_/template_/Template.java)中，`job();`具体执行时遵循动态绑定机制。
```java
public abstract class Template {
    public abstract void job();

    public void calculateTime() {
        long start = System.currentTimeMillis();
        job();//动态绑定机制
        long end = System.currentTimeMillis();
        System.out.println("任务运行时间 " + (end - start));
    }
}
```

## 10.8 接口
### 快速入门
模拟生活中的电脑有很多USB接口，可以插入相机、手机、U盘等。

**代码**：
- [Camera.java](/code/chapter10/src/com/jinjin/interface_/Camera.java)
- [Phone.java](/code/chapter10/src/com/jinjin/interface_/Phone.java)
- [UsbInterface.java](/code/chapter10/src/com/jinjin/interface_/UsbInterface.java)
- [Computer.java](/code/chapter10/src/com/jinjin/interface_/Computer.java)
- [Interface01.java](/code/chapter10/src/com/jinjin/interface_/Interface01.java)

### 基本介绍
接口就是给出一些没有实现的方法，封装到一起，到某个类要使用的时候，再根据具体情况把这些方法写出来。语法：

```java
interface 接口名{
    //属性
    //抽象方法
}
class 类名 implements 接口{
    自己属性;
    自己方法;
    必须实现的接口的抽象方法
}
```

**小结**：
* 接口体现了程序设计的多态和高内聚低耦合的设计思想。  
* 接口是更加抽象的抽象的类，抽象类里可以有方法体，接口里的所有方法都没有方法体【JDK7.0】。  
* JDK8.0后(包含JDK8.0)接口类可以有静态方法，默认方法，也就是说接口中可以有方法的具体实现。

```java
public interface AInterface {
    //接口中可以有属性
    public int n1 = 100;

    //接口中的抽象方法
    public void work();

    //JDK8之后，接口中可以有实现的方法
    // 1.默认方法，必须加上default关键字,
    default public void hi() {
        System.out.println("hi");
    }
    //2.静态方法
    public static void say() {
        System.out.println("say");
    }
}
```
### 深入讨论
接口应用场景举例：
1. 现在要制造战斗机，武装直升机。专家只需把飞机需要的功能/规格定下来即可，然后让别的人具体实现。
2. 现在有一个项目经理，管理三个程序员，功能开发一个软件，为了控制和管理软件，项目经理可以定义一些接口，然后由程序员具体实现。

<img src="/notes/img-ch10/ch10-interface/applying01.png">

<img src="/notes/img-ch10/ch10-interface/applying02.png">

### 注意事项和细节
1. 接口不能被实例化
2. 接口中所有方法是`public`方法，接口中抽象方法，可以不用`abstract`修饰。
    ```java
    void aaa();//实际上是 public abstract void aa();
    ``` 
3. 一个普通类实现接口，就必须将该接口的所有方法都实现。可以使用快捷键alt+enter。将光标放在要实现接口的类的第一行，使用快捷键alt+enter：

    <img src="/notes/img-ch10/ch10-interface/details01.png">

    <img src="/notes/img-ch10/ch10-interface/details02.png">

    <img src="/notes/img-ch10/ch10-interface/details03.png">
4. 抽象类实现接口，可以不用实现接口的方法。
5. 一个类同时可以实现多个接口。
6. 接口中的属性，只能是`final`的，而且是`public static final`修饰符。比如：`int a = 1;`实际上是`public static final int a = 1;`（必须初始化）。
7. 接口中属性的访问形式：`接口名.属性名`
8. 接口不能继承其它的类，但是可以继承多个别的接口。
    ```java
    interface A extends B,C{ }
    ```
9. 接口的修饰符只能是`public`和默认，这点和类的修饰符是一样的。

### 课堂练习
判断下列代码是否有错误？应该输出什么？
```java
public class InterfaceExercise01 {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.a);
        System.out.println(A.a);
        System.out.println(B.a);
    }
}

interface A{
    int a = 23;
}
class B implements A{
}
```
答案见[InterfaceExercise01.java](/code/chapter10/src/com/jinjin/interface_/InterfaceExercise01.java)

### 实现接口 VS 继承类
例子：[ExtendsVsInterface.java](/code/chapter10/src/com/jinjin/interface_/ExtendsVsInterface.java)
* 当子类继承了父类，就自动拥有父类的功能。如果子类需要扩展功能，可以通过实现接口的方式扩展。可以理解实现接口是对java单继承机制的一种补充。
* 接口和继承解决的问题不同
  * 继承的价值主要在于：解决代码的**复用性和可维护性**。
  * 接口的价值主要在于：设计，设计好各种规范（方法），让其它类去实现这些方法，即更加地灵活。
* 接口比继承更加灵活
  * 接口比继承更加灵活，继承是满足is-a关系，而接口只需满足like-a的关系。
* 接口在一定程度上实现代码解耦[即：接口规范性+动态绑定机制]

### 接口的多态属性
1. 多态参数  
   在前面的USB接口案例中，UsbInterface usb，既可以接收手机对象，又可以接收相机对象，就体现了接口多态（接口引用可以指向实现了接口的类的对象）。
2. 多态数组  
   给Usb数组中，存放Phone和Camera对象，Phone类还有一个特有的方法call()，请遍历Usb数组，如果是Phone对象，除了调用接口Usb定义的方法外，还需要调用Phone特有的方法call。[InterfacePolyArr.java](/code/chapter10/src/com/jinjin/interface_/interfacePoly/InterfacePolyArr.java)
   ```java
    for (int i = 0; i < usbs.length; i++) {
            usbs[i].work();
            if (usbs[i] instanceof Phone) { //向下转型
                ((Phone) usbs[i]).call();
            }
        }
   ```
3. 接口存在多态传递现象。[InterfacePolyPass.java](/code/chapter10/src/com/jinjin/interface_/interfacePoly/InterfacePolyPass.java)
   ```java
   //接口类型的变量可以指向，实现了该接口的类的对象实例
    IG ig = new Teacher();
    //如果 IG 继承了 IH 接口，而 Teacher 类实现了 IG 接口 
    // 那么，实际上就相当于 Teacher 类也实现了 IH 接口. 
    // 这就是所谓的 接口多态传递现象.
    IH ih = new Teacher();
    ```

### 课堂练习
判断代码是否正确？应该如何更改？[InterfaceExercise02.java](/code/chapter10/src/com/jinjin/interface_/interfaceExercise/InterfaceExercise02.java)

## 🚩🚩🚩10.9 内部类
### 基本介绍
一个类的内部又完整的嵌套了另一个类结构。被嵌套的类称为内部类（inner class），嵌套其他类的类称为外部类（outer class），是我们类的第五大成员【类的五大成员：属性、方法、构造器、代码块、内部类】，内部类最大的特点就是可以直接访问私有属性，并且可以体现类与类之间的包含关系。

注意：内部类是学习的难点，同时也是重点，后面看底层源码时，有大量的内部类。

### 基本语法
```java
class Outer { //外部类
    class Inner { //内部类

    }
}
class Other { //外部其他类

}
```
例子：[InnerClass01.java](/code/chapter10/src/com/jinjin/innerclass/InnerClass01.java)
### 内部类的分类
* 定义在外部类局部位置上（方法中/代码块）：
    1. 局部内部类（有类名）
    2. 🚩🚩匿名内部类（没有类名）
* 定义在外部类的成员位置上：
    1. 成员内部类（没有static修饰）
    2. 静态内部类（使有static修饰）

### 局部内部类的使用
说明：局部内部类是定义在外部类的局部位置，比如方法中，并且有类名。

例子：[LocalInnerClass.java](/code/chapter10/src/com/jinjin/innerclass/LocalInnerClass.java)

1. 可以直接访问外部类的所有成员，包含私有的
2. 不能添加修饰符，因为它的地位就是一个局部变量。局部变量是不能使用修饰符的。但是可以用final修饰，因为局部变量也可以使用final。
3. 作用域：仅仅在定义它的方法或代码块中。
4. 局部内部类---访问--->外部类的成员 [访问方式：直接访问]
5. 外部类---访问--->局部内部类的成员
    访问方式：创建对象，再访问（注意：必须在作用域内）

    **记住**：
    1. 局部内部类定义在方法中/代码块
    2. 作用域在方法体或者代码块中
    3. 本质仍然是一个类
6. 外部其他类---不能访问--->局部内部类，因为局部内部类的地位是一个局部变量
7. 如果外部类和局部内部类的成员重名时，默认遵循就近原则，如果想访问外部类的成员，可以使用`外部类名.this.成员`去访问
    ```java
    System.out.println(" 外部类的n1 = " + 外部类名.this.n1);
    ```

### 🚩🚩🚩匿名内部类的使用
重点把握：  
1. 本质是类
2. 内部类
3. 该类没有名字
4. 同时还是一个对象

匿名内部类是定义在外部类的局部位置，比如方法中，并且没有类名。
1. 匿名内部类的基本语法  
   ```java
   new 类或接口(参数列表){
       类体
   }
   ```
   案例[AnonymousInnerClass.java](/code/chapter10/src/com/jinjin/innerclass/AnonymousInnerClass.java)
2. 匿名内部类的语法比较奇特，因为匿名内部类既是一个类的定义，同时本身也是一个对象，因此从语法上看，它既有定义类的特征，也有创建对象的特征，对前面代码分析可以看出这个特点，因此可以调用匿名内部类的方法。
3. 可以直接访问外部类的所有成员，包含私有的。
4. 不能添加访问修饰符，因为它的地位就是一个局部变量。
5. 作用域：仅仅在定义它的方法或代码块中。
6. 匿名内部类---访问--->外部类成员 [访问方式：直接访问]
7. 外部其他类---不能访问--->匿名内部类，因为匿名内部类地位是一个局部变量。
8. 如果外部类和匿名内部类的成员重名，匿名内部类访问的话，默认遵循就近原则，如果想访问外部类的成员，则可以使用`外部类名.this.成员`去访问。

举例代码：[AnonymousInnerClassDetail.java](/code/chapter10/src/com/jinjin/innerclass/AnonymousInnerClassDetail.java)

### 匿名内部类的最佳实践
当做实参直接传递，简洁高效。[InnerClassExercise01.java](/code/chapter10/src/com/jinjin/innerclass/InnerClassExercise01.java)

### 匿名内部类练习
[InnerClassExercise02.java](/code/chapter10/src/com/jinjin/innerclass/InnerClassExercise02.java)

1. 有一个铃声接口Bell，里面有个ring方法。
2. 有一个手机类Cellphone，具有闹钟功能alarmClock，参数是Bell类型。
3. 测试手机类的闹钟功能，通过匿名内部类（对象）作为参数，打印：懒猪起床了。
4. 再传入另一个匿名内部类（对象），打印：小伙伴上课了
```java
interface Bell{
    void ring();
}

class Cellphone {
    public void alarmClock(Bell bell) {
        bell.ring();
    }
}
```

### 成员内部类的使用
说明：成员内部类是定义在外部类的成员位置，并且没有static修饰。

[MemberInnerClass01.java](/code/chapter10/src/com/jinjin/innerclass/MemberInnerClass01.java)
1. 可以直接访问外部类的所有成员，包含私有的。
2. 可以添加任意访问修饰符（public、protected、默认、private），因为它的地位就是一个成员。
3. 作用域  
   和外部类的其他成员一样，为整个类体，比如前面的例子，在外部类的成员方法中穿件成员内部类对象，再调用方法。
4. 成员内部类---访问--->外部类成员（比如：属性）[访问方式：直接访问]
5. 外部类---访问--->成员内部类，访问方式：创建对象，再访问
6. 外部其他类---访问--->成员内部类，访问方式有两种，见[MemberInnerClass01.java](/code/chapter10/src/com/jinjin/innerclass/MemberInnerClass01.java)
7. 如果外部类和内部类的成员重名时，内部类访问的话，默认遵循就近原则，如果访问外部类的成员，则可以使用`外部类名.this.成员`去访问。

### 静态内部类的使用
[StaticInnerClass01.java](/code/chapter10/src/com/jinjin/innerclass/StaticInnerClass01.java)

说明：静态内部类是定义在外部类的成员位置，并且有static修饰。
1. 可以直接访问外部类的所有静态成员，包含私有的，但不能直接访问非静态成员
2. 可以添加任意访问修饰符(public、protected 、默认、private),因为它的地位就是一个成员。
3. 作用域 ：同其他的成员，为整个类体
4. 静态内部类---访问------>外部类（比如静态属性），访问方式：直接访问所有静态成员
5. 外部类---访问------>静态内部类，访问方式：创建对象，再访问
6. 外部其他类---访问------>静态内部类，两种访问方式，见[StaticInnerClass01.java](/code/chapter10/src/com/jinjin/innerclass/StaticInnerClass01.java)
7. 如果外部类和静态内部类的成员重名时，静态内部类访问的时，默认遵循就近原则，如果想访问外部类的成员，则可以使用`外部类名.成员`去访问。

### 练习题
判断输出什么？答案见[InnerClassExercise.java](/code/chapter10/src/com/jinjin/innerclass/InnerClassExercise.java)
```java
class Test {
    public Test() {
        Inner s1 = new Inner();
        s1.a = 10;
        Inner s2 = new Inner();
        System.out.println(s2.a);
    }

    class Inner {
        public int a = 5;
    }

    public static void main(String[] args) {
        Test t = new Test();
        Inner r = t.new Inner();
        System.out.println(r.a);
    }
}
```