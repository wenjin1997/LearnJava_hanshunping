- [第19章 IO流](#第19章-io流)
  - [文件](#文件)
    - [什么是文件](#什么是文件)
    - [文件流](#文件流)
  - [常用的文件操作](#常用的文件操作)
    - [创建文件对象相关构造器和方法](#创建文件对象相关构造器和方法)
    - [获取文件的相关信息](#获取文件的相关信息)
    - [目录的操作和文件删除](#目录的操作和文件删除)
# 第19章 IO流
## 文件
### 什么是文件
* 文件是保存数据的地方。

### 文件流
文件在程序中是以流的形式来操作的

<img src="/notes/img-ch19/IO.png">

* 流：数据在数据源（文件）和程序（内存）之间经历的路径
* 输入流：数据从数据源（文件）到程序（内存）的路径
* 输出流：数据从程序（内存）到数据源（文件）的路径

## 常用的文件操作
### 创建文件对象相关构造器和方法
[FileCreate.java](/code/chapter19/src/com/jinjin/file/FileCreate.java)
```java
new File(String pathname); // 根据路径构建一个File对象
new File(File parent, String child); // 根据父目录文件 + 子路径构建
new File(String parent, String child); // 根据父目录 + 子路径构建
creatNewFile(); //创建新文件
```

**File类**
```java
public class File implements Serializable, Comparable<File>{

}
```

### 获取文件的相关信息
```java
getName
getAbsolutePath
getParent
length
exists
isFile
isDirectory
```
应用案例：[FileInformation.java](/code/chapter19/src/com/jinjin/file/FileInformation.java)

### 目录的操作和文件删除
* mkdir创建一级目录、mkdirs创建多级目录、delete删除空目录或文件

应用案例
* 判断`"/Users/jinjin/code/LearnJava_hanshunping/code/chapter19/news1.txt"`是否存在，如果存在就删除
* 判断`"/Users/jinjin/code/LearnJava_hanshunping/code/chapter19/demo02"`是否存在，存在就删除，否则提示不存在
* 判断目录`"/Users/jinjin/code/LearnJava_hanshunping/code/chapter19/demo/a/b/c"`是否存在，如果存在就提示已经存在，否则就创建