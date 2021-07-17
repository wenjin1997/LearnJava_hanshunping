# 第8章 面向对象编程（中级部分）
## 8.3 IDEA的使用
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

## 8.4 包
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
[Import01.java](./code/chapter08/src/com/jinjin/pkg/Import01.java)  
需要使用到哪个类，就导入哪个包，不建议使用*导入，如`import java.util.Arrays;`。引入一个包的主要目的是要使用该包下的类。

### 注意事项和使用细节
* package的作业是声明当前类所在的包，需要放在类的最上面，一个类最多只有一句package。
* import指令位置放在package的下面，在类定义前面，可以有多句且没有顺序要求。
  
## 8.5 访问修饰符
### 4种访问修饰符的访问范围
|访问级别|访问控制修饰符|同类|同包|子类|不同包|
|----|----|----|----|----|----|
|公开|public|✔️|✔️|✔️|✔️|
|受保护|proteced|✔️|✔️|✔️|×|
|默认|没有修饰符|✔️|✔️|×|×|
|私有|privated|✔️|×|×|×|

### 使用的注意事项
1. 修饰符可以用来修饰类中的属性，成员方法以及类
2. 只有默认的和public才能修饰类！并且遵循上述访问权限的特点。
3. 关于在子类中的访问权限，学完继承后再看。
4. 成员方法的访问规则和属性完全一样。
代码位置：`/code/chapter08/src/com/jinjin/modifier`

## 8.6 封装
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
1. 不能随便查看人的年龄，工资等隐私，并对设置的年龄进行合理的验证。年龄合理就设置，否则给默认年龄，必须在1-120，年龄、工资不能直接查看，name的长度在2-6个字符之间。[Encapsulation01.java](./code/chapter08/src/com/jinjin/encap/Encapsulation01.java)
   * 构造器可以和setXxx方法结合，用于数据的验证，实现封装。
2. 创建程序，在其中定义两个类：Account和AccoutTese类体会Java的封装性。[Account.java](./code/chapter08/src/com/jinjin/encap/Account.java)及[AccountTest.java](./code/chapter08/src/com/jinjin/encap/AccountTest.java)
   1. Account类要求具有属性：姓名（长度为2位3位或4位）、余额（必须>20）、密码（必须是六位），如果不满足，则给出提示信息，并给默认值。
   2. 通过setXxx的方法给Account的属性赋值。
   3. 在AccountTest中测试。

## 8.8 继承
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

## 8.9 `super`关键字
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