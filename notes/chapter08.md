- [第8章 面向对象编程（中级部分）](#第8章-面向对象编程中级部分)
  - [IDEA的使用](#idea的使用)
    - [IDEA常用快捷键](#idea常用快捷键)
    - [模板/自定义模板](#模板自定义模板)
  - [包](#包)
    - [包的命名](#包的命名)
    - [常用的包](#常用的包)
    - [引入包](#引入包)
    - [注意事项和使用细节](#注意事项和使用细节)
  - [访问修饰符](#访问修饰符)
    - [4种访问修饰符的访问范围](#4种访问修饰符的访问范围)
    - [使用的注意事项](#使用的注意事项)
  - [封装](#封装)
    - [封装介绍](#封装介绍)
    - [封装的好处](#封装的好处)
    - [⭐️封装的实现步骤（三步）](#️封装的实现步骤三步)
    - [封装练习](#封装练习)
  - [继承](#继承)
    - [为什么需要继承](#为什么需要继承)
    - [继承的基本语法](#继承的基本语法)
    - [案例](#案例)
    - [继承给编程带来的便利](#继承给编程带来的便利)
    - [⭐️继承的细节问题](#️继承的细节问题)
    - [⭐️⭐️继承的本质分析](#️️继承的本质分析)
    - [继承练习](#继承练习)
  - [`super`关键字](#super关键字)
  - [方法重写/覆盖(Override)](#方法重写覆盖override)
    - [重写和重载的比较](#重写和重载的比较)
    - [方法重写/覆盖练习](#方法重写覆盖练习)
  - [面向对象编程——多态](#面向对象编程多态)
    - [多态细节](#多态细节)
    - [多态练习题](#多态练习题)
    - [⭐️⭐️⭐️ java的动态绑定机制](#️️️-java的动态绑定机制)
    - [多态数组](#多态数组)
    - [多态参数](#多态参数)
  - [Object类详解](#object类详解)
    - [`equals`方法](#equals方法)
    - [`equals`方法练习](#equals方法练习)
    - [`hashCode`方法](#hashcode方法)
    - [`toString`方法](#tostring方法)
    - [`finalize`方法](#finalize方法)
  - [断点调试(Debug)](#断点调试debug)
    - [断点调试介绍](#断点调试介绍)
    - [断点调试快捷键](#断点调试快捷键)
    - [断点调试应用案例](#断点调试应用案例)
  - [零钱通项目](#零钱通项目)
  - [本章作业](#本章作业)
    - [作业1](#作业1)
    - [作业2](#作业2)
    - [作业3](#作业3)
    - [作业4](#作业4)
    - [作业5](#作业5)
    - [⭐️⭐️作业6](#️️作业6)
    - [作业7](#作业7)
    - [⭐️⭐️⭐️作业8](#️️️作业8)
      - [代码：](#代码)
      - [⭐️⭐️**Remark**](#️️remark)
    - [作业9](#作业9)
    - [⭐️⭐️⭐️作业10](#️️️作业10)
    - [作业11](#作业11)
    - [⭐️⭐️⭐️作业12](#️️️作业12)
    - [作业13](#作业13)
    - [作业14](#作业14)
    - [⭐️⭐️作业15 多态](#️️作业15-多态)
    - [⭐️⭐️作业16 动态绑定机制](#️️作业16-动态绑定机制)

# 第8章 面向对象编程（中级部分）
## IDEA的使用
### IDEA常用快捷键
MacOS版本下的常用快捷键如下，如果要自定义可以找到Preferences-Keymap。
1) 删除当前行,默认是 command + delete
2) 复制当前行 command + D
3) 补全代码 alt + /
4) 添加注释和取消注释 ctrl + / 【第一次是添加注释，第二次是取消注释】
5) 导入该行需要的类先配置autoimport,位置位于Perferences-Editor-General-Auto Import,勾选Add unambiguous imports on the fly以及Optimize imports on the fly, 然后使用alt+enter即可，有时不用使用快捷键就直接导入了包。
6) 快速格式化代码 command + alt + L
7) 快速运行程序 ctrl + R
8) 生成构造器等 command + N [提高开发效率]
9) 查看一个类的层级关系，把光标放在类名上，然后按 ctrl + H [学习继承后，非常有用]
10) 将光标放在一个方法上，输入 command + B , 可以定位到方法 [学继承后，非常有用]
11) 自动的分配变量名 , 通过 在后面加 .var
12) 还有很多其它的快捷键...
### 模板/自定义模板
在Preferences-Editor-Live Templates中可以查看模板快捷键及自定义。

## 包
* 包的三大作用
  1. 区分相同名字的类
  2. 当类很多时，可以很好的管理类
  3. 控制访问范围
* 包基本语法 `package com.xxx`
  1. `package`：关键字，表示打包
  2. `com.xxx`：表示包名
* 包的本质：实际上就是创建不同的文件夹/目录来保存类文件。
### 包的命名
* 命名规则：只能包含数字、字母、下划线、小圆点.，但不能用数字开头，不能是关键字或保留字。
* 命名规范：小写字母+小圆点一般是`com.公司名.项目名.业务模块名`，如`com.sina.crm.user //用户模块`。
### 常用的包
1. `java.lang.*`：lang包是基本包，默认引入，不需要再引入。
2. `java.util.*`：util包，系统提供的工具包，工具类，使用Scanner
3. `java.net.* `：网络包，网络开发
4. `java.awt.*`：做java的界面开发，GUI

### 引入包  
需要使用到哪个类，就导入哪个包，不建议使用*导入，如`import java.util.Arrays;`。引入一个包的主要目的是要使用该包下的类。

### 注意事项和使用细节
* package的作用是声明当前类所在的包，需要放在类的最上面，一个类最多只有一句package。
* import指令位置放在package的下面，在类定义前面，可以有多句且没有顺序要求。
  
## 访问修饰符
### 4种访问修饰符的访问范围
|访问级别|访问控制修饰符|同类|同包|子类|不同包|
|----|----|----|----|----|----|
|公开|public|✔️|✔️|✔️|✔️|
|受保护|proteced|✔️|✔️|✔️|×|
|默认|没有修饰符|✔️|✔️|×|×|
|私有|privated|✔️|×|×|×|

### 使用的注意事项
1. 修饰符可以用来修饰类中的属性，成员方法以及类。
2. 只有默认的和public才能修饰类！并且遵循上述访问权限的特点。
3. 关于在子类中的访问权限，涉及到继承相关知识。
4. 成员方法的访问规则和属性完全一样。
代码位置：`/code/chapter08/src/com/jinjin/modifier`

## 封装
面向对象编程的三大特征：封装、继承、多态。
### 封装介绍
封装（encapsulation）就是把抽象出的数据[属性]和对数据的操作[方法]封装在一起，数据被保护在内部，程序的其它部分只有通过被授权的操作[方法],才能对数据进行操作。
### 封装的好处
1. 隐藏实现细节
2. 可以对数据进行验证，保证安全合理

### ⭐️封装的实现步骤（三步）
1. 将属性进行私有化private【不能直接修改属性】
2. 提供一个公共的(public)set方法，用于对属性判断并赋值
  
```java
public void setXxx(类型 参数名){//Xxx表示某个属性
  //加入数据验证的业务逻辑
  属性 = 参数名;
}
```
3. 提供一个公共的(public)get方法，用于获取属性的值

```java
public 数据类型 getXxx(){//权限判断，Xxx表示某个属性
  return xx;
}
```
### 封装练习
1. 不能随便查看人的年龄，工资等隐私，并对设置的年龄进行合理的验证。年龄合理就设置，否则给默认年龄，必须在1-120，年龄、工资不能直接查看，name的长度在2-6个字符之间。[Encapsulation01.java](/code/chapter08/src/com/jinjin/encap/Encapsulation01.java)
   * 构造器可以和setXxx方法结合，用于数据的验证，实现封装。
2. 创建程序，在其中定义两个类：Account和AccoutTese类体会Java的封装性。[Account.java](/code/chapter08/src/com/jinjin/encap/Account.java)及[AccountTest.java](/code/chapter08/src/com/jinjin/encap/AccountTest.java)
   1. Account类要求具有属性：姓名（长度为2位3位或4位）、余额（必须>20）、密码（必须是六位），如果不满足，则给出提示信息，并给默认值。
   2. 通过setXxx的方法给Account的属性赋值。
   3. 在AccountTest中测试。

## 继承
### 为什么需要继承
提高代码的复用性。
### 继承的基本语法
```java
class 子类 extends 父类 {

}
```
1. 子类会自动拥有父类定义的属性和方法
2. 父类又叫超类、基类。
3. 子类又叫派生类。
   
### 案例
父类:[Student.java](/code/chapter08/src/com/jinjin/extend_/improve_/Student.java)  
子类:[Pupil.java](/code/chapter08/src/com/jinjin/extend_/improve_/Pupil.java)、[Graduate.java](/code/chapter08/src/com/jinjin/extend_/improve_/Graduate.java)  
测试：[Extends01.java](/code/chapter08/src/com/jinjin/extend_/improve_/Extends01.java)

### 继承给编程带来的便利
1) 代码的复用性提高了
2) 代码的扩展性和维护性提高了

### ⭐️继承的细节问题
1) 子类继承了所有的属性和方法，非私有的属性和方法可以在子类直接访问, 但是私有属性和方法不能在子类直接访问，要通过父类提供公共的方法去访问；
2) 子类必须调用父类的构造器，完成父类的初始化；
3) 当创建子类对象时，不管使用子类的哪个构造器，默认情况下总会去调用父类的无参构造器，如果父类没有提供无参构造器，则必须在子类的构造器中用`super`去指定使用父类的哪个构造器完成对父类的初始化工作，否则，编译不通过；
4) 如果希望指定去调用父类的某个构造器，则显式的调用一下 : `super(参数列表)`；
5) `super`在使用时，必须放在构造器第一行(`super`只能在构造器中使用)；
6) `super()`和`this()`都只能放在构造器第一行，因此这两个方法不能共存在一个构造器；
7) java所有类都是Object类的子类, Object是所有类的基类；
8) 父类构造器的调用不限于直接父类!将一直往上追溯直到Object类(顶级父类)；
9) 子类最多只能继承一个父类(指直接继承)，即**java中是单继承机制**。  
思考:如何让A类继承B类和C类? 【A 继承 B， B继承C】；
10) 不能滥用继承，子类和父类之间必须满足 is-a 的逻辑关系。

### ⭐️⭐️继承的本质分析
实例：[ExtendsTheory.java](/code/chapter08/src/com/jinjin/extend_/ExtendsTheory.java)    
⭐️内存图：
<img src="/notes/img-ch8/img1.png">
如果要访问属性，按照查找关系来返回信息：
1. 首先看子类是否有该属性
2. 如果子类有这个属性，并且可以访问，则返回信息
3. 如果子类没有这个属性，就看父类有没有这个属性(如果父类有该属性，并且可以访问，就返回信息..)
4. 如果父类没有就按照(3)的规则，继续找上级父类，直到 Object... 

### 继承练习
1. [ExtendsExercise01.java](/code/chapter08/src/com/jinjin/extend_/exercise/ExtendsExercise01.java)  
执行main方法输出`a,b name,b`。
2. [ExtendsExercise02.java](/code/chapter08/src/com/jinjin/extend_/exercise/exercise02/ExtendsExercise02.java)
执行main方法输出结果如下：
<img src="/notes/img-ch8/img2.png">
3. 需求

* 编写 Computer 类，包含 CPU、内存、硬盘等属性，getDetails 方法用于返回 Computer 的详细信息
* 编写 PC 子类，继承 Computer 类，添加特有属性【品牌 brand】
* 编写 NotePad 子类，继承 Computer 类，添加特有属性【color】
* 编写 Test 类，在 main 方法中创建 PC 和 NotePad 对象，分别给对象中特有的属性赋值，以及从 Computer 类继承的 属性赋值，并使用方法并打印输出信息

**练习3代码：** 
- [Computer.java](/code/chapter08/src/com/jinjin/extend_/exercise/Computer.java)
- [PC.java](/code/chapter08/src/com/jinjin/extend_/exercise/PC.java)
- [NotePad.java](/code/chapter08/src/com/jinjin/extend_/exercise/NotePad.java)
- [ExtendsExercise03.java](/code/chapter08/src/com/jinjin/extend_/exercise/ExtendsExercise03.java) //测试类

## `super`关键字
* `super`代表父类的引用，用于访问父类的属性、方法、构造器
* 基本语法
  * 访问父类的属性，但不能访问父类的`private`属性,`super.属性名`
  * 访问父类的方法，不能访问父类的`private`方法，`super.方法名(参数列表);`
  * 访问父类的构造器，`super(参数列表);`只能放在构造器的第一句，只能出现一句！
* `super`细节
  * 调用父类的构造器的好处（分工明确，父类属性由父类初始化，子类的属性由子类初始化）
  * 当子类中有和父类中的成员（属性和方法）重名时，为了访问父类的成员，必须通过`super`。如果没有重名，使用`super`、`this`、直接访问是一样的效果！
  * `super`的访问不限于直接父类，如果爷爷类和本类中有同名的成员，也可以使用`super`去访问爷爷类的成员；如果多个基类（上级类）中都有同名的成员，使用super访问遵循就近原则。A->B->C，当然也需要遵守访问权限相关规则。
* ⭐️**super和this的比较**

|序号|区别点|this|super|
|----|----|----|----|
|1|访问属性|访问本类中的属性，如果本类没有此属性，则从父类中继续查找|从父类开始查找属性|
|2|调用方法|访问本类中的方法，如果本类没有此方法，则从父类中继续查找|从父类开始查找方法|
|3|调用构造器|访问本类构造器，必须放在构造器的首行|调用父类构造器，必须放在子类构造器的首行|
|4|特殊|表示当前对象|子类中访问父类对象|

## 方法重写/覆盖(Override)
* 子类方法的形参列表，方法名称，要和父类方法的形参列表，方法名称完全一样。
* **子类方法的返回类型和父类方法的返回类型一样，或者是父类返回类型的子类**，比如父类返回类型是`Object`，子类方法返回类型是`String`。
* **子类方法不能缩小父类方法的访问权限**。public->protected->默认->private。如果父类方法的访问修饰符是protected，则子类的访问修饰符是protected或public。

### 重写和重载的比较

|名称|发生范围|方法名|形参列表|返回类型|修饰符|
|----|----|----|----|----|----|
|重载（overload）|本类|必须一样|类型、个数或顺序至少有一个不同|无要求|无要求|
|重写（override）|父子类|必须一样|相同|子类重写的方法，返回的类型和父类返回的类型一致，或者是其子类|子类方法不能缩小父类方法的访问范围|

### 方法重写/覆盖练习
1) 编写一个Person类，包括属性/private(name、age)，构造器、方法say(返回自我介绍的字符串)。
2) 编写一个Student类，继承Person类，增加id、score属性/private，以及构造器，定义say方法(返回自我介绍的信息)。 
3) 在main中,分别创建Person和Student对象，调用say方法输出自我介绍。

**代码**
- [Person.java](/code/chapter08/src/com/jinjin/override_/Person.java)
- [Student.java](/code/chapter08/src/com/jinjin/override_/Student.java)
- [OverrideExercise02.java](/code/chapter08/src/com/jinjin/override_/OverrideExercise02.java)
* 注意：在Student类的say方法中，可以用super关键字调用其父类Person的say方法,提高代码复用。

```java
public String say() {
//        return " 你好，我叫" + getName() + "，今年" + getAge() +
//                "岁" + "我的id是：" + id + "，我考了" + score + "分。";
        return super.say() + "我的id是：" + id + "，我考了" + score + "分。";
    }
```

## 面向对象编程——多态
* 方法或对象具有多种状态，是面向对象的第三大特征，多态是建立在封装和继承基础之上的。
* 方法的多态：重写和重载就体现多态。
* 关于多态的重点：
  1. 一个对象的编译类型和运行类型可以不一致；
  2. 编译类型在定义对象时，就确定了，不能改变；
  3. 运行类型是可以变化的；
  4. 编译类型看定义时 = 号的左边，运行类型看 = 号的右边。

例如：
```java
//animal编译类型就是 Animal，运行类型是Dog
Animal animal = new Dog();
//因为运行时，执行到该行时，animal运行类型是Dog，所以cry就是Dog的cry
animal.cry();
```
多态实例代码：
- [Animal.java](/code/chapter08/src/com/jinjin/poly_/objectpoly_/Animal.java)
- [Dog.java](/code/chapter08/src/com/jinjin/poly_/objectpoly_/Dog.java)
- [Cat.java](/code/chapter08/src/com/jinjin/poly_/objectpoly_/Cat.java)
- [PolyObject.java](/code/chapter08/src/com/jinjin/poly_/objectpoly_/PolyObject.java)

### 多态细节
[PolyDetail.java](/code/chapter08/src/com/jinjin/poly_/detail_/PolyDetail.java)
* 多态的前提是：两个对象（类）存在继承关系
* **多态的向上转型**：
  * 本质：父类的引用指向了子类的对象
  * 语法：`父类类型 引用名 = new 子类类型();`
  * 特点：编译类型看左边，运行类型看右边。可以调用父类中的所有成员（需遵守访问权限），不能调用子类中特有成员；最终运行效果看子类的具体实现！
* **多态的向下转型**
  * 语法：`子类类型 引用名 = （子类类型）父类引用;`
  * 只能强转父类的引用，不能强转父类的对象
  * **要求父类的引用必须指向的是当前目标类型的对象**
  * 当向下转型后，可以调用子类类型中所有的成员
* 属性没有重写之说！属性的值看编译类型。[PolyDetail02.java](/code/chapter08/src/com/jinjin/poly_/detail_/PolyDetail02.java)
* `instanceOf`比较操作符，用于判断**对象的运行类型**是否位XX类型或XX类型的子类型。[PolyDetail03.java](/code/chapter08/src/com/jinjin/poly_/detail_/PolyDetail03.java)

### 多态练习题
判断输出什么：[PolyExercise02.java](/code/chapter08/src/com/jinjin/poly_/PolyExercise02.java)

### ⭐️⭐️⭐️ java的动态绑定机制
1. 当调用对象方法的时候，**该方法会和该对象的内存地址/运行类型**绑定
2. 当调用对象属性时，**没有动态绑定机制**，哪里声明，哪里使用

例子：[DynamicBinding.java](../code/chapter08/src/com/jinjin/poly_/dynamic_/DynamicBinding.java)

### 多态数组
* 数组的定义类型位父类类型，里面保存的实际元素类型为子类类型。

* 应用实例:现有一个继承结构如下:要求创建 1 个 Person 对象、2 个 Student 对象和 2 个 Teacher 对象, 统一放在数组 中，并调用每个对象say 方法.

* 应用实例代码：
  - [Person.java](../code/chapter08/src/com/jinjin/poly_/polyarr_/Person.java)
  - [Student.java](../code/chapter08/src/com/jinjin/poly_/polyarr_/Student.java)
  - [Teacher.java](../code/chapter08/src/com/jinjin/poly_/polyarr_/Teacher.java)
  - [PloyArray.java](../code/chapter08/src/com/jinjin/poly_/polyarr_/PloyArray.java)

### 多态参数
* 方法定义的形参类型为父类类型，实参类型允许为子类类型。
* 应用实例：
  * 定义员工类Employee，包含姓名和月工资[private]，以及计算年工资getAnnual方法。
  * 普通员工和经理继承了员工，经理类多了奖金bonus属性和管理manage方法，普通员工类多了work方法，普通员工和经理类要求分别重写getAnnual方法。
  * 测试类中添加一个方法showEmpAnnual(Employee e)，实现获取任何员工对象的年工资，并在main方法中调用该方法。
  
  ```java
  public void showEmpAnnual(Employee e) {
          System.out.println(e.getAnnual());//动态绑定机制
      }
  ```

  * 测试类中添加一个方法，testWork，如果是普通员工，则调用work方法，如果是经理，则调用manage方法。

  ```java
  public void testWork(Employee e) {
          if (e instanceof Worker) {
              ((Worker) e).work();//向下转型
          } else if (e instanceof Manager) {
              ((Manager) e).manager();//向下转型
          } else {
              System.out.println("不做处理...");
          }
      }
  ```
* 应用实例代码：
  - [Employee.java](../code/chapter08/src/com/jinjin/poly_/polyparameter/Employee.java)
  - [Worker.java](../code/chapter08/src/com/jinjin/poly_/polyparameter/Worker.java)
  - [Manager.java](../code/chapter08/src/com/jinjin/poly_/polyparameter/Manager.java)
  - [PolyParameter.java](../code/chapter08/src/com/jinjin/poly_/polyparameter/PolyParameter.java)

## Object类详解
### `equals`方法
* `==`和`equals`的对比
  * `==`：既可以判断基本类型，又可以判断引用类型
  * `==`：如果判断基本类型，判断的是值是否相等。
  * `==`：如果判断引用类型，判断的是地址是否相等，即判定是不是同一个对象。
  * `equals`：是`Object`类中的方法，**只能判断引用类型**。
  * 默认判断的是地址是否相等，子类中往往重写该方法，用于判断内容是否相等，比如`Integer`、`String`。
* `==`和`equals`代码：[Equals01.java](/code/chapter08/src/com/jinjin/object_/Equals01.java)
* 查看JDK源码：command + B

### `equals`方法练习
* **重写equals方法** [EqualsExercise01.java](/code/chapter08/src/com/jinjin/object_/EqualsExercise01.java)  
判断两个`Person`对象的内容是否相等，如果两个`Person`对象的各个属性值都一样，则返回`true`，反之`false`。  
`Person`属性如下：

```java
class Person {
    private String name;
    private int age;
    private char gender;
}
```
* 判断输出什么?

```java
System.out.println(“hello” == new java.sql.Date()); //编译错误
```
注意这里不是输出`false`，而是编译不能通过，因为两边比较的是不同的类，**直接编译报错**。

### `hashCode`方法
1. 提高具有哈希结构的容器的效率！
2. 两个引用，如果指向的是同一个对象，则哈希值肯定是一样的！
3. 两个引用，如果指向的是不同对象，则哈希值是不一样的。
4. 哈希值主要是根据地址号来的！但不能将哈希值等价于地址。
5. 在集合中，`hashCode`方法如果需要的话，也会重写。

### `toString`方法
1. 基本介绍  
   默认返回：全类名（包名+类名）+@+哈希值的十六进制，子类往往会重写`toStrin`g方法，用于返回对象的属性信息。
2. 重写`toString`方法，打印对象或拼接对象时，都会自动调用该对象的`toString`形式。
3. 当直接输出一个对象时，`toString`方法会被默认的调用，比如`System.out.println(monster);`等价于`System.out.println(monster.toString());`。

代码：[ToString_.java](/code/chapter08/src/com/jinjin/object_/ToString_.java)

### `finalize`方法
1) 当对象被回收时，系统自动调用该对象的`finalize`方法。子类可以重写该方法，做一些释放资源的操作。
2) 什么时候被回收:当某个对象没有任何引用时，则jvm就认为这个对象是一个垃圾对象，就会使用垃圾回收机制来销毁该对象，在销毁该对象前，会先调用`finalize`方法。
3) 垃圾回收机制的调用，是由系统来决定(即有自己的GC算法),也可以通过`System.gc()`主动触发垃圾回收机制。
* 我们在实际开发中，几乎不会运用`finalize`, 所以更多就是为了应付面试.

代码：[Finalize_.java](/code/chapter08/src/com/jinjin/object_/Finalize_.java)

## 断点调试(Debug)
### 断点调试介绍
* 在断点调试过程中，是运行状态，是以对象的运行类型来执行的。
* 断点调试是指在程序的某一行设置一个断点，调试时，程序运行到这一行就会停住，然后可以一步一步往下调试，调试过程中可以看各个变量当前的值，出错的话，调试到出错的代码行即显示错误，停下。进行分析从而找到这个Bug。
* 断点调试能帮助我们查看Java底层源代码的执行过程，提高程序员的Java水平。

### 断点调试快捷键
* F7 跳入方法内
* F8 逐行执行代码
* shift + F8 跳出方法内
* F9 resume，执行到下一个断点

### 断点调试应用案例
* 查看变量变化的情况 [Debug01.java](/code/chapter08/src/com/jinjin/debug_/Debug01.java)
* 查看数组越界的异常 [Debug02.java](/code/chapter08/src/com/jinjin/debug_/Debug02.java)
* 追溯源码 [Debug03.java](/code/chapter08/src/com/jinjin/debug_/Debug03.java)
* IDEA Debug 如何进入JDK源码
  1. 使用force step into: 快捷键 alt + shift + F7
  2. 配置：点击Setting --> Build,Execution,Deployment --> Debugger --> Stepping把Do not step into the classes中的java.*，javax.*取消勾选，其他的随意，然后就可以进入源码了。
* 执行到下一个断点F9,断点可以在debug过程中，动态的下断点。[Debug04.java](/code/chapter08/src/com/jinjin/debug_/Debug04.java)
* 使用断点调试的方法，追踪下一个对象创建的过程。Person[name, age, 构造器...] [DebugExercise.java](/code/chapter08/src/com/jinjin/debug_/DebugExercise.java)
* 使用断点调试，查看动态绑定机制如何工作 [DynamicBinding.java](/code/chapter08/src/com/jinjin/poly_/dynamic_/DynamicBinding.java)

## 零钱通项目
* 面向过程编写 [SmallChangeSys.java](/code/chapter08/src/com/jinjin/smallchange/SmallChangeSys.java)
* OOP思想编写 [SmallChangeSysOOP.java](/code/chapter08/src/com/jinjin/smallchange/oop/SmallChangeSysOOP.java)、[SmallChangeSysApp.java](/code/chapter08/src/com/jinjin/smallchange/oop/SmallChangeSysApp.java)

## 本章作业
### 作业1
定义一个Person类{name, age, job}，初始化Person对象数组，有3个person对象，并按照age从大到小进行排序，提示，使用冒泡排序。[Homework01.java](/code/chapter08/src/com/jinjin/homework/Homework01.java)

⭐️冒泡排序代码：

```java
//使用冒泡排序
Person temp = null; //临时变量，用于交换
for (int i = 0; i < persons.length; i++) {
    for (int j = 0; j < persons.length - 1 - i; j++) {
        if (persons[j].getAge() < persons[j+1].getAge()) {
            temp = persons[j];
            persons[j] = persons[j+1];
            persons[j+1] = temp;
        }
    }
}
```

### 作业2
写出四种访问修饰符和各自的访问权限。见[4种访问修饰符的访问范围](#4种访问修饰符的访问范围)。

### 作业3
编写老师类：
1. 要求有属性“姓名name”，“年龄age”，“职称post”，“基本工资salary”
2. 编写业务方法，introduce()，实现输出一个教师的信息。
3. 编写教师类的三个子类，教授类(Professor)、副教授类、讲师类。工资级别分别为：教授1.3、副教授1.2、讲师类1.1。在三个子类里面都重写父类的introduce()方法。
4. 定义并初始化一个老师对象，调用业务方法，实现对象基本信息的后台打印。

代码：
- [Homework03.java](/code/chapter08/src/com/jinjin/homework/homework03/Homework03.java)
- [Teacher.java](/code/chapter08/src/com/jinjin/homework/homework03/Teacher.java)
- [Professor.java](/code/chapter08/src/com/jinjin/homework/homework03/Professor.java)
- [AssociateProfessor.java](/code/chapter08/src/com/jinjin/homework/homework03/AssociateProfessor.java)
- [Lecturer.java](/code/chapter08/src/com/jinjin/homework/homework03/Lecturer.java)

### 作业4
通过继承实现员工工资核算打印功能：   
父类：员工类(Employee)  
子类：部门经理类(Manager)、普通员工类(Worker)
1. 部门经理工资 = 1000+单日工资 \* 天数 * 等级(1.2)
2. 普通员工工资 = 单日工资 \* 天数 * 等级(1.0)
3. 员工属性：姓名、单日工资、工作天数
4. 员工方法：打印工资
5. 普通员工及部门经理都是员工子类，需要重写打印工资方法。
6. 定义并初始化普通员工对象，调用打印工资方法输出工资，定义并初始化部门经理对象，调用打印工资方法输出工资。

作业4代码：
- [Homework04.java](/code/chapter08/src/com/jinjin/homework/homework04/Homework04.java)
- [Employee.java](/code/chapter08/src/com/jinjin/homework/homework04/Employee.java)
- [Manager.java](/code/chapter08/src/com/jinjin/homework/homework04/Manager.java)
- [Worker.java](/code/chapter08/src/com/jinjin/homework/homework04/Worker.java)

### 作业5
设计父类——员工类。子类：工人类(Worker)、农民类(Peasant)、教师类(Teacher)、科学家类(Scientist)、服务生类(Waiter)。
1. 其中工人、农民、服务生只有基本工资sal
2. 教师除基本工资外，还有课酬（元/天）classDay,classSal
3. 科学家除基本工资外，还有年终奖bonus
4. 编写一个测试类，将各种类型的员工的全年工资打印出来

* 注意事项
  * 教师类的classDay,classSal以及科学家的bonus属性可以不用设置在构造器中，用set和get方法更加灵活。
  * Employee类中打印全年工资方法如下，不用单独设置全年工资属性。

  ```java
  //打印全全年工资
  public void showSal() {
      System.out.println(name + "\t全年工资 " + (salPerMon * salMonth));
  }
  ```

作业5代码：
- [homework05.java](/code/chapter08/src/com/jinjin/homework/homework05/homework05.java)
- [Employee.java](/code/chapter08/src/com/jinjin/homework/homework05/Employee.java)
- [Worker.java](/code/chapter08/src/com/jinjin/homework/homework05/Worker.java)
- [Peasant.java](/code/chapter08/src/com/jinjin/homework/homework05/Peasant.java)
- [Teacher.java](/code/chapter08/src/com/jinjin/homework/homework05/Teacher.java)
- [Scientist.java](/code/chapter08/src/com/jinjin/homework/homework05/Scientist.java)
- [Waiter.java](/code/chapter08/src/com/jinjin/homework/homework05/Waiter.java)

### ⭐️⭐️作业6
假定Grand、Father和Son在同一个包，问：父类和子类中通过this和super都可以调用哪些属性和方法？

```java
package com.jinjin.homework.homework06;

public class Homework06 {
}

class Grand{ //超类
    String name = "AA";
    private int age = 100;
    public void g1(){ }
}

class Father extends Grand{ // 父类
    String id = "001";
    private double score;
    public void f1() {
        // super可以调用哪些属性和方法？

        // this可以调用哪些属性和方法？

    }
}

class Son extends Father{ //子类
    String name = "BB";
    public void g1() {
    }
    public void show(){
        // super可以调用哪些属性和方法？
        // this可以调用哪些属性和方法？
    }
}
```

* 解答：[Homework06.java](/code/chapter08/src/com/jinjin/homework/homework06/Homework06.java)
* ⭐️⭐️回顾笔记：[`super`关键字](#super关键字)

### 作业7
写出程序结果：[Homework07.java](/code/chapter08/src/com/jinjin/homework/homework07/Homework07.java)

答案：`Test Demo Rose Jack john Jack`

### ⭐️⭐️⭐️作业8
扩展如下的BankAccount类：[BankAccount.java](/code/chapter08/src/com/jinjin/homework/homework08/BankAccount.java)

要求：
1. 在上面类的基础上扩展新类CheckingAccount,对每次存款和取款都收取1美元的手续费。
2. 扩展前一个练习的BankAccount类，新类SavingAccount每个月都有利息产生（earnMonthlyInterest方法被调用），并且有每月三次免手续费的存款或取款。在earnMonthlyInterest方法中重置交易计数。
3. 体会重写的好处。

#### 代码：
* [CheckingAccount.java](/code/chapter08/src/com/jinjin/homework/homework08/CheckingAccount.java)
* [SavingsAccount.java](/code/chapter08/src/com/jinjin/homework/homework08/SavingsAccount.java)
* [Homework08.java](/code/chapter08/src/com/jinjin/homework/homework08/Homework08.java)

#### ⭐️⭐️**Remark**
* CheckingAccount类中的存款和取款方法可以直接调用父类的方法进行重写。

```java
//存款
@Override
public void deposit(double amount) {
    // setBalance(getBalance() + amount - 1);
    super.deposit(amount - 1);
}
```

* 实现每月三次免手续费的存款或取款，每月产生利息

```java
private int times = 3; // 每月免手续费次数

public void earnMonthlyInterest() {
        times = 3;
        // 每个月产生利息
        //setBalance(getBalance() + getBalance() * interest);
        super.deposit(getBalance() * interest);
    }

//存款
public void deposit(double amount) {
    if (times > 0) {
        super.deposit(amount);
    } else {
        super.deposit(amount - 1);
    }
    times --;
}
```

### 作业9
设计一个Point类，其x和y坐标可以通过构造器提供。提供一个子类LabeledPoint，其构造器接受一个标签值和x,y坐标，比如:`new LabeledPoint("Black", 1929, 230.07)`，写出对应的构造器即可。

```java
public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }
```
* 代码
  * [Point.java](/code/chapter08/src/com/jinjin/homework/homework09/Point.java)
  * [LabeledPoint.java](/code/chapter08/src/com/jinjin/homework/homework09/LabeledPoint.java)

### ⭐️⭐️⭐️作业10
编写Doctor类`{name, age, job, gender, sal}`
相应的getter()和setter()方法，5个参数构造器，重写父类(Object)的equals()方法:`public boolean equals(Object obj)`，并判断测试类中创建的两个对象是否相等。相等就是判断属性是否相同。

```java
// 重写父类(Object)的equals()方法:`public boolean equals(Object obj)`
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj instanceof Doctor) {
        Doctor aDoctor = (Doctor)obj; // 向下转型
        return aDoctor.name.equals(this.name) &&
                aDoctor.age == this.age &&
                aDoctor.gender == this.gender &&
                aDoctor.job.equals(this.job) &&
                aDoctor.sal == this.sal;
    }
    return false;
}
```

### 作业11
现有Person类，里面有方法run、eat，Student类继承了Person类，并重写了run方法，自定义了study方法，试写出对象向上转型和向下转型的代码，并写出各自都可以调用哪些方法，并写出方法输出什么？

```java
class Person {
  public void run() {System.out.println("person run");}
  public void eat() {System.out.println("person eat");}
}

class Student extends Person{
  public void run() {System.out.println("student run");}
  public void study() {System.out.println("student study..");}
}
```

* 对象向上转型
  * `Person person = new Student();`
  * 可以调用方法：`person.run();`输出`student run`
  * 可以调用方法：`person.eat();`输出`person eat`

* 对象向下转型
  * ⭐️⭐️`Student s = (Student) person;`
  * 可以调用方法：`s.run();`输出`student run`
  * 可以调用方法：`s.study();`输出`student study..`

### ⭐️⭐️⭐️作业12
说出==和equals的区别。

|名称|概念|用于基本数据类型|用于引用类型|
|----|----|----|----|
|==|比较运算符|可以，判断值是否相等|可以，判断两个对象是否相等|
|equals|Object类的方法，Java类都可以使用equals|不可以|可以，默认是判断两个对象是否相等，但是子类往往重写该方法，比较对象的属性是否相等，比如`(String, Integer)`|

### 作业13
<img src="/notes/img-ch8/homework13.png">

### 作业14
<img src="/notes/img-ch8/homework14.png">

输出内容：
```
我是A类
hahah我是B类的有参构造
我是c类的有参参构造
我是c类的无参构造
```

⭐️⭐️注意事项：

```java
public B(String name){
  //super();
  //⭐️注意这里有`super();`,默认调用父类A的无参构造器
  System.out.println(name+"我是B类的有参构造");
}
```

### ⭐️⭐️作业15 多态
什么是多态，多态具体体现有哪些？可举例说明: [Homework15.java](/code/chapter08/src/com/jinjin/homework/Homework15.java)

**多态**：方法或对象具有多种形态，是OOP的第三大特征，是建立在封装和继承基础之上。

**多态的具体体现**：
1. 方法多态
   1. 重载体现多态
   2. 重写体现多态
2. 对象多态
   1. 对象的编译类型和运行类型可以不一致，编译类型在定义时，就确定，不能变化
   2. 对象的运行类型是可以变化的，可以通过`getClass()`来查看运行类型
   3. 编译类型看定义时 `=` 号的左边，运行类型看 `=` 号的右边

### ⭐️⭐️作业16 动态绑定机制
java的动态绑定机制是什么？

1. 当调用对象的方法时，该方法会和对象的内存地址/运行类型绑定。
2. 当调用对象的属性时，没有动态绑定机制，哪里声明，哪里使用。