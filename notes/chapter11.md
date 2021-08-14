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