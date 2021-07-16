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
1. 修饰符可以用力啊修饰类中的属性，成员方法以及类
2. 只有默认的和public才能修饰类！并且遵循上述访问权限的特点。
3. 关于在子类中的访问权限，学完继承后再看。
4. 成员方法的访问规则和属性完全一样。
代码位置：`/code/chapter08/src/com/jinjin/modifier`