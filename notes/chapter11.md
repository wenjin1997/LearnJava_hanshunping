- [第11章 枚举和注解](#第11章-枚举和注解)
  - [先看一个需求](#先看一个需求)
    - [补充：如何在文件中自动添加作者等信息](#补充如何在文件中自动添加作者等信息)
  - [分析问题](#分析问题)
  - [解决方案—枚举](#解决方案枚举)
  - [枚举的两种实现方式](#枚举的两种实现方式)
  - [自定义类实现枚举-应用案例](#自定义类实现枚举-应用案例)
  - [自定义类实现枚举—小结](#自定义类实现枚举小结)
  - [enum关键字实现枚举-快速入门](#enum关键字实现枚举-快速入门)
  - [`enum`关键字实现枚举-课堂练习](#enum关键字实现枚举-课堂练习)
  - [`enum`常用方法说明](#enum常用方法说明)
  - [`enum`常用方法应用举例](#enum常用方法应用举例)
  - [`enum`实现接口](#enum实现接口)
  - [注解的理解](#注解的理解)
  - [基本的Annotation介绍](#基本的annotation介绍)
  - [基本的 Annotation 应用案例](#基本的-annotation-应用案例)
    - [`@Override`注解的案例](#override注解的案例)
    - [`@Deprecated`注解的案例](#deprecated注解的案例)
    - [`@SuppressWarnings`注解的案例](#suppresswarnings注解的案例)
  - [JDK的元Annotation(元注解， 了解)](#jdk的元annotation元注解-了解)
    - [元注解的基本介绍](#元注解的基本介绍)
    - [元注解的种类（了解）](#元注解的种类了解)
    - [`@Retention`注解](#retention注解)
    - [`@Target`](#target)
    - [`@Documented`](#documented)
    - [`@Inherited`注解](#inherited注解)
  - [作业](#作业)

# 第11章 枚举和注解
## 先看一个需求
要求创建季节(Season) 对象，请设计并完成。[Enumeration01.java](/code/chapter11/src/com/jinjin/enum_/Enumeration01.java)

```java
class Season{//类 
    private String name; 
    private String desc;//描述 
    //构造器
    //getXX
    //setXX
}
```

### 补充：如何在文件中自动添加作者等信息
在Preferences中找到Editor-File and Code Templates，修改 File Header，然后应用即可。

<img src="/notes/img-ch11/template01.png">

<img src="/notes/img-ch11/template02.png">

## 分析问题
创建Season对象有如下特点：
1. 季节的值是有限的几个值(spring,summer,autumn,winter) 
2. 只读，不需要修改。

## 解决方案—枚举
1) 枚举对应英文(enumeration, 简写 enum)
2) 枚举是一组常量的集合。
3) 可以这样理解:枚举属于一种特殊的类，里面只包含一组有限的特定的对象。

## 枚举的两种实现方式
1) 自定义类实现枚举
2) 使用enum关键字实现枚举

## 自定义类实现枚举-应用案例
[Enumeration02.java](/code/chapter11/src/com/jinjin/enum_/enum2/Enumeration02.java)

1. 不需要提供setXxx方法，因为枚举对象值通常为只读。
2. 对枚举对象/属性使用`final` + `static` 共同修饰，实现底层优化。
3. 枚举对象名通常使用全部大写，常量的命名规范。
4. 枚举对象根据需要，也可以有多个属性。

## 自定义类实现枚举—小结
1) 构造器私有化
2) 本类内部创建一组对象[四个 春夏秋冬]
3) 对外暴露对象(通过为对象添加`public` `final` `static` 修饰符) 
4) 可以提供 get 方法，但是不要提供 set方法

## enum关键字实现枚举-快速入门
使用 `enum` 来实现前面的枚举案例，主要体会和自定义类实现枚举不同的地方。[Enumeration03.java](/code/chapter11/src/com/jinjin/enum_/Enumeration03.java)

**enum关键字实现枚举注意事项：**
1. 当我们使用`enum`关键字开发一个枚举类时，默认会继承`Enum`类, 而且是一个`final`类，可以使用`javap`反编译指令来查看Season2.class。

    <img src="/notes/img-ch11/javap01.png">

    <img src="/notes/img-ch11/javap.png">

2. 传统的`public static final Season2 SPRING = new Season2("春天", "温暖");`简化成`SPRING("春天", "温暖")`， 这里必须知道，它调用的是哪个构造器.
3. 如果使用无参构造器创建枚举对象，则实参列表和小括号都可以省略。
4. 当有多个枚举对象时，使用`,`间隔，最后有一个分号结尾。 
5. 枚举对象必须放在枚举类的行首。

## `enum`关键字实现枚举-课堂练习
下面代码是否正确, 并说明表示的含义? 
```java
enum Gender{ //1min
BOY , GIRL; //这里其实就是调用 Gender 类的无参构造器 
}
```
1) 上面语法是ok
2) 有一个枚举类`Gender`，没有属性。
3) 有两个枚举对象BOY, GIRL,使用的无参构造器创建.

下面代码输出什么? [EnumExercise01.java](/code/chapter11/src/com/jinjin/enum_/EnumExercise01.java)
```java
public class EnumExercise01 {
    public static void main(String[] args) {
        Gender2 boy = Gender2.BOY;
        Gender2 boy2 = Gender2.BOY;
        System.out.println(boy);
        System.out.println(boy2 == boy); 
    }
}

enum Gender2{ 
    BOY , GIRL;
}
```

## `enum`常用方法说明
说明:使用关键字`enum`时，会隐式继承`Enum`类, 这样我们就可以使用`Enum`类相关的方法。

```java
public abstract class Enum<E extends Enum<E>> implements Comparable<E>, Serializable {

}
```

<img src="/notes/img-ch11/EnumMethod.png">

## `enum`常用方法应用举例
[EnumMethod.java](/code/chapter11/src/com/jinjin/enum_/EnumMethod.java)

1) `toString`:`Enum`类已经重写过了，返回的是当前对象名,子类可以重写该方法，用于返回对象的属性信息
2) `name`:返回当前对象名(常量名)，子类中不能重写
3) `ordinal`:返回当前对象的位置号，默认从`0`开始
4) `values`:返回当前枚举类中所有的常量
5) `valueOf`:将字符串转换成枚举对象，要求字符串必须为已有的常量名，否则报异常!
6) `compareTo`:比较两个枚举常量，比较的就是编号!

**练习**

声明`Week`枚举类，其中包含星期一至星期日的定义： `MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;`使用`values`返回所有的枚举数组,并遍历,输出效果如下图：

<img src="/notes/img-ch11/enumWeek.png">

练习代码：[EnumExercise02.java](/code/chapter11/src/com/jinjin/enum_/EnumExercise02.java)

* 注意把构造器设置为`private`
* 增强`for`循环
```java
Week[] weeks = Week.values(); //返回枚举对象数组
System.out.println("===所有星期的信息如下==");
for (Week week : weeks) {
    System.out.println(week);
}
```

## `enum`实现接口
1) 使用`enum`关键字后，就不能再继承其它类了，因为`enum`会隐式继承`Enum`，而Java是单继承机制。 
2) 枚举类和普通类一样，可以实现接口，如下形式。

```java
enum 类名 implements 接口 1，接口 2{
    
}
```

代码：[EnumDetail.java](/code/chapter11/src/com/jinjin/enum_/EnumDetail.java)

## 注解的理解
1) 注解(Annotation)也被称为元数据(Metadata)，用于修饰解释包、类、方法、属性、构造器、局部变量等数据信息。
2) 和注释一样，注解不影响程序逻辑，但注解可以被编译或运行，相当于嵌入在代码中的补充信息。
3) 在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE中注解占据了更重要的角色，例如用来配置应用程序的任何切面，代替 java EE 旧版中所遗留的繁冗代码和 XML 配置等。

## 基本的Annotation介绍
使用Annotation时要在其前面增加`@`符号, 并把该Annotation当成一个修饰符使用。用于修饰它支持的程序元素。

三个基本的 Annotation:
1) `@Override`: 限定某个方法，是重写父类方法, 该注解只能用于方法
2) `@Deprecated`: 用于表示某个程序元素(类, 方法等)已过时
3) `@SuppressWarnings`: 抑制编译器警告

## 基本的 Annotation 应用案例
### `@Override`注解的案例
案例代码:[Override_.java](/code/chapter11/src/com/jinjin/annotation_/Override_.java)

* `@Override`:限定某个方法，是重写父类的方法，该注解只能用于方法。
* `@interface`不是`interface`，是注解类，JDK5.0之后加入的。

`@Override`使用说明：
1. `@Override`表示指定重写父类的方法（从编译层面验证），如果父类没有`fly`方法，则会报错。
2. 如果不写`@Override`注解，而父类仍有`public void fly(){};`，仍然构成重写。
3. `@Override`只能修饰方法，不能修饰其他类、包、属性等等。
4. 查看`@Override`注解源码为`@Target(ElementType.METHOD)`，说明只能修饰方法
5. `@Target`是**修饰注解的注解，称为元注解**，记住这个概念。

### `@Deprecated`注解的案例
案例代码:[Deprecated_.java](/code/chapter11/src/com/jinjin/annotation_/Deprecated_.java)

`@Deprecated`的说明: 
1. 用于表示某个程序元素(类, 方法等)已过时
2. 可以修饰方法、类、字段、包、参数等等
3. `@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, MODULE, PARAMETER, TYPE})`
4. `@Deprecated`的作用可以做到新旧版本的兼容和过渡

###  `@SuppressWarnings`注解的案例
案例代码:[Deprecated_.java](/code/chapter11/src/com/jinjin/annotation_/Deprecated_.java)

`@SuppressWarnings`: 抑制编译器警告
1. `unchecked` 是忽略没有检查的警告
2. `rawtypes` 是忽略没有指定泛型的警告（传参时没有指定泛型的警告错误）
3. `unused` 是忽略没有使用某个变量的警告错误
4. `@SuppressWarnings`可以修饰的程序元素为，`@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})`
5. 生成`@SuppressWarnings`时，不用背，直接点击左侧的黄色提示，就可以选择（注意可以指定生成的位置）

## JDK的元Annotation(元注解， 了解)
### 元注解的基本介绍
JDK的元Annotation用于修饰其他Annotation。  
元注解：本身作用不大，但是看源码时，要知道它是干什么的。

### 元注解的种类（了解）
1) `Retention` //指定注解的作用范围，三种`SOURCE,CLASS,RUNTIME`
2) `Target` // 指定注解可以在哪些地方使用
3) `Documented` //指定该注解是否会在 javadoc 体现
4) `Inherited` //子类会继承父类注解

### `@Retention`注解
说明
只能用于修饰一个 Annotation 定义, 用于指定该Annotation可以保留多长时间, `@Rentention`包含一个`RetentionPolicy`类型的成员变量, 使用`@Rentention` 时必须为该`value`成员变量指定值.

`@Retention`的三种值
1) `RetentionPolicy.SOURCE`: 编译器使用后，直接丢弃这种策略的注释
2) `RetentionPolicy.CLASS`: 编译器将把注解记录在`class`文件中. 当运行 Java程序时, JVM不会保留注解。这是默认值
3) `RetentionPolicy.RUNTIME`:编译器将把注解记录在`class`文件中. 当运行 Java程序时, JVM会保留注解. 程序可以通过反射获取该注解

### `@Target`
用于修饰Annotation定义，用于指定被修饰的Annotation能用于修饰哪些程序元素。`@Target`也包含一个名为`value`的成员变量。

### `@Documented`
`@Documented`：用于指定该元Annotation修饰Annotation类被javadoc工具提取成文档，即在生成文档时，可以看到该注解。

说明：定义为`Documented`的注解必须设置`Retention`值为`RUNTIME`。

### `@Inherited`注解
被它修饰的Annotation将具有继承性。如果某个类使用了被`@inherited`修饰的Annotation，则其子类将自动具有该注解。

## 作业
编程题：枚举类[Homework.java](/code/chapter11/src/com/jinjin/homework/Homework.java)

1. 创建一个Color枚举类
2. 有RED,BLUE,BLACK,YELLOW,GREEN这五个枚举值/对象
3. Color有三个属性redValue, greenValue, blueValue
4. 创建构造方法，参数包括这三个属性
5. 每个枚举值都要给这三个属性赋值，三个属性对应的值分别是red:255,0,0 blue:0,0,255 black:0,0,0 yellow:255,255,0 green:0,255,0
6. 定义接口，里面有方法show。要求Color实现该接口
7. show方法中显示三个属性的值
8. 将枚举对象在switch语句中匹配使用

注意：将枚举对象在switch语句中匹配使用的代码如下
```java
//将枚举对象在switch语句中匹配使用
switch (blue) {
    case RED:
        System.out.println("匹配到红色");
        break;
    case BLUE:
        System.out.println("匹配到蓝色");
        break;
    case BLACK:
        System.out.println("匹配到黑色");
        break;
    case GREEN:
        System.out.println("匹配到绿色");
        break;
    case YELLOW:
        System.out.println("匹配到黄色");
        break;
}
```