- [第16章 坦克大战1](#第16章-坦克大战1)
  - [游戏介绍](#游戏介绍)
  - [Java绘图坐标体系](#java绘图坐标体系)
    - [坐标体系介绍](#坐标体系介绍)
    - [坐标体系-像素](#坐标体系-像素)
    - [绘图原理](#绘图原理)
    - [Graphics类](#graphics类)
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

<img src="/notes/img-ch16/draw01.png">

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
* 画图片 `drawImage(Image img, int x, int y, ..)`，这里需要获取图片资源，要将图片放在out根目录下，写上相应路径
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