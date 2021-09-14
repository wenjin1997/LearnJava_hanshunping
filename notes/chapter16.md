- [第16章 坦克大战1](#第16章-坦克大战1)
  - [游戏介绍](#游戏介绍)
  - [Java绘图坐标体系](#java绘图坐标体系)
    - [坐标体系介绍](#坐标体系介绍)
    - [坐标体系-像素](#坐标体系-像素)
    - [绘图原理](#绘图原理)
    - [Graphics类](#graphics类)
    - [绘制坦克](#绘制坦克)
  - [Java事件处理机制](#java事件处理机制)
    - [基本说明](#基本说明)
    - [示意图](#示意图)
    - [机制分析](#机制分析)
    - [事件处理机制深入理解](#事件处理机制深入理解)
  - [坦克大战游戏](#坦克大战游戏)
# 第16章 坦克大战1
## 游戏介绍
▶️  为什么写这个项目
* 好玩
* 涉及到Java各个方面的技术
  * Java面向对象编程
  * 多线程
  * 文件I/O操作
  * 数据库
* 巩固旧知识，学习新知识

## Java绘图坐标体系
### 坐标体系介绍
下图说明了Java坐标系。坐标原点额日语左上角，以像素为单位。在Java坐标系中，第一个是x坐标，表示当前位置为水平方向，距离坐标原点x个像素；第二个是y坐标，表示当前位置为垂直方向，距离坐标原点y个像素。

<img src="/notes/img-ch16/draw/draw01.png">

### 坐标体系-像素
* 计算机在屏幕上显示的内容都是由屏幕上的每一个像素组成的。例如，计算机显示器的分辨率是800 x 600，表示计算机屏幕上的每一行由800个点组成，共有600行，整个计算机屏幕共有480 000个像素。
* 像素是一个**密度单位**，而厘米是**长度单位**，两者无法比较。

### 绘图原理
* Component类提供了两个和绘图相关最重要的方法：
  * `panint(Graphics g)` 绘制组件的外观
  * `repaint()` 刷新组件的外观
* 在以下情况，`paint()`将会被调用：
  * 当组件第一次在屏幕显示的时候，程序会自动的调用`paint()`方法来绘制组件
  * 窗口最小化，再最大化
  * 窗口的大小发生变化
  * `repaint()`方法被调用

### Graphics类
[DrawCircle.java](/code/chapter16/src/com/jinjin/draw/DrawCircle.java)
* 画直线 `drawLine(int x1,int y1,int x2,int y2)`
* 画矩形边框 `drawRect(int x, int y, int width, int height)`
* 画椭圆边框 `drawOval(int x, int y, int width, int height)`
* 填充矩形 `fillRect(int x, int y, int width, int height)`
  * 需要先设置画笔的颜色，再进行填充
  ```java
  g.setColor(Color.blue);
  g.fillRect(10, 10, 100, 100);
  ```
* 填充椭圆 `fillOval(int x, int y, int width, int height)`
* 画图片 `drawImage(Image img, int x, int y, ..)`，这里需要获取图片资源，要将图片放在`out/production/chapter16`根目录下，写上相应路径

<img src="/notes/img-ch16/draw/path.png">

```java
Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bg.png"));
g.drawImage(image, 10, 10, 175, 221, this);
```
* 画字符串 `drawString(String str, int x, int y)//写字`，注意x和y设定的坐标式文字左下角的坐标。
    ```java
    //给画笔设置颜色和字体
    g.setColor(Color.red);
    g.setFont(new Font("隶书", Font.BOLD, 50));
    //这里设置的 100， 100， 是 "北京你好"左下角
    g.drawString("北京你好", 100, 100);
    ```
* 设置画笔的字体 `setFont(Font font)`
* 设置画笔的颜色 `setColor(Color c)`

### 绘制坦克
坦克的整个图形是由一些简单的几何图形组合而成，首先要清楚各图形的坐标。

<img src="/notes/img-ch16/drawTank.png">

代码：
- [Tank.java](/code/chapter16/src/com/jinjin/tankgame/Tank.java)
- [Hero.java](/code/chapter16/src/com/jinjin/tankgame/Hero.java)
- [MyPanel.java](/code/chapter16/src/com/jinjin/tankgame/MyPanel.java)
- [JinTankGame01.java](/code/chapter16/src/com/jinjin/tankgame/JinTankGame01.java)

## Java事件处理机制
小程序：让小球受到键盘的控制，可以上下左右移动。[BallMove.java](/code/chapter16/src/com/jinjin/event/BallMove.java)

### 基本说明
java事件处理是采取“委派事件模型”。当事件发生时，产生事件的对象，会把此“信息”传递给“事件的监听者”处理，这里所说的“信息”实际上就是java.awt.event事件类库里某个类创建的对象，把它称为“事件的对象”。

### 示意图

<img src="/notes/img-ch16/event.png">

### 机制分析

<img src="/notes/img-ch16/eventAnalysis.png">

### 事件处理机制深入理解
1. 事件源：事件源是一个产生事件的对象，比如按钮，窗口等。
2. 事件：事件就是承载事件源状态改变时的对象，比如当键盘事件、鼠标事件、窗口事件等等，会产生一个事件对象，该对象保存着当时事件很多信息，比如KeyEvent对象有含有被按下键的Code值。java.awt.event包和javax.swing.event包中定义了各种事件类型。
3. 事件类型：查阅jdk文档

  <img src="/notes/img-ch16/EventClass.png">

4. 事件监听器接口：
   1. 当事件源产生一个事件，可以传送给事件监听者处理
   2. 事件监听者实际上就是一个类。该类实现了某个事件监听器接口。比如前面案例中的MyPanle就是一个类，它实现了KeyListener接口，它就可以作为一个事件监听者，对接受到的事件进行处理
   3. 事件监听器接口有多种，不同的事件监听器接口可以监听不同的事件，一个类可以实现多个监听接口
   4. 这些接口在java.awt.event包和javax.swing.event包中定义。

## 坦克大战游戏
用Java事件处理机制和Java绘图技术，通过按键控制上右下左的移动。
- [Tank.java](/code/chapter16/src/com/jinjin/tankgame2/Tank.java)
- [Hero.java](/code/chapter16/src/com/jinjin/tankgame2/Hero.java)
- [MyPanel.java](/code/chapter16/src/com/jinjin/tankgame2/MyPanel.java)
- [JinTankGame02.java](/code/chapter16/src/com/jinjin/tankgame2/JinTankGame02.java)