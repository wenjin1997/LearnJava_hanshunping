- [第19章 IO流](#第19章-io流)
  - [文件](#文件)
    - [什么是文件](#什么是文件)
    - [文件流](#文件流)
  - [常用的文件操作](#常用的文件操作)
    - [创建文件对象相关构造器和方法](#创建文件对象相关构造器和方法)
    - [获取文件的相关信息](#获取文件的相关信息)
    - [目录的操作和文件删除](#目录的操作和文件删除)
  - [IO流原理及流的分类](#io流原理及流的分类)
    - [Java IO流原理](#java-io流原理)
    - [流的分类](#流的分类)
    - [IO流体系图-常用的类](#io流体系图-常用的类)
    - [FileInputStream](#fileinputstream)
    - [FileOutputStream](#fileoutputstream)
    - [FileReader](#filereader)
    - [FileWriter](#filewriter)
  - [节点流和处理流](#节点流和处理流)
    - [基本介绍](#基本介绍)
    - [节点流和处理流一览图](#节点流和处理流一览图)
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

应用案例： [Directory_.java](/code/chapter19/src/com/jinjin/file/Directory_.java)
* 判断`"/Users/jinjin/code/LearnJava_hanshunping/code/chapter19/news1.txt"`是否存在，如果存在就删除
* 判断`"/Users/jinjin/code/LearnJava_hanshunping/code/chapter19/demo02"`是否存在，存在就删除，否则提示不存在
* 判断目录`"/Users/jinjin/code/LearnJava_hanshunping/code/chapter19/demo/a/b/c"`是否存在，如果存在就提示已经存在，否则就创建

## IO流原理及流的分类
### Java IO流原理
1. I/O是Input/Output的缩写，I/O技术是非常实用的技术，用于处理数据传输。如读/写文件，网络通讯等。
2. Java程序中，对于数据的输入/输出操作以“流(stream)”的方式进行。
3. java.io包下提供了各种“流”类和接口，用以获取不同种类的数据，并通过方法输入或输出数据。
4. 输入input：读取外部数据（磁盘、光盘等存储设备的数据）到程序（内存）中。
5. 输出output:将程序（内存）数据输出到磁盘、光盘等存储设备中。

### 流的分类
* 按操作数据单位不同分为：**字节流**(8 bit)二进制文件、**字符流**（按字符）文本文件
* 按数据流的流向不同分为：输入流、输出流
* 按流的角色不同分为：节点流、处理流/包装流

|抽象基类|字节流|字符流|
|----|----|----|
|输入流|InputStream|Reader|
|输出流|OutputStream|Writer|

* Java的IO流共涉及40多个类，实际上非常规则，都是从如上四个抽象基类派生的。
* 由这四个类派生出来的子类名称都是以其父类名作为子类名后缀。

### IO流体系图-常用的类
* IO流体系图

<img src="/notes/img-ch19/IO流思维导图.png">

* 文件 VS 流

<img src="/notes/img-ch19/文件VS流.png">

### FileInputStream
[FileInputStream_.java](/code/chapter19/src/com/jinjin/inputstream_/FileInputStream_.java)
* `fileInputStream.read()`
* `fileInputStream.read(byte[] b)`

### FileOutputStream

<img src="/notes/img-ch19/OutputStream.png">

文件写入的几种方式
* 写入单个字节
  ```java
  fileOutputStream.write('a');
  ```
* 写入字节数组
  ```java
  String content = "hello, world!";
  fileOutputStream.write(content.getBytes());
  ```
* 写入字节数组，指定偏移量及长度
  ```java
  String content = "hello, world!";
  fileOutputStream.write(content.getBytes(),0,3);
  ```

上述三种方式为覆盖写入，如果想直接追加写入，则将`append`置为`true`。
```java
fileOutputStream = new FileOutputStream(filePath, true);
```

* 文件拷贝:[FileCopy.java](/code/chapter19/src/com/jinjin/outputstream_/FileCopy.java)

### FileReader
[FileReader_.java](/code/chapter19/src/com/jinjin/reader_/FileReader_.java)

<img src="/notes/img-ch19/FileReader.png">

1. `new FileReader(File/String)`
2. `read` 每次读取单个字符，返回该字符，如果到文件末尾返回-1
3. `read(char[])` 批量读取多个字符到数组，返回读取到的字符数，如果到文件末尾返回-1

* `new String(char[])` 将char[]转换成String
* `new String(char[], off, len)` 将char[]的指定部分转换成String

### FileWriter
[FileWriter_.java](/code/chapter19/src/com/jinjin/writer_/FileWriter_.java)

<img src="/notes/img-ch19/FileWriter.png">

1. `new FileWriter(File/String)` 覆盖模式，相当于流的指针在首端
2. `new FileWriter(File/String, true)` 追加模式，相当于流的指针在尾端
3. `writer(int)` 写入单个字符
4. `writer(char[])` 写入指定数组
5. `writer(char[], off, len)` 写入指定数组的指定部分
6. `writer(String)` 写入整个字符串
7. `writer(String, off, len)` 写入字符串的指定部分

* 相关API：String类，toCharArray 将String转换成char[]
* FileWriter使用后，**必须要关闭(close)或刷新(flush)**，否则写入不到指定的文件，追源码可以知道关闭文件流，等价于 flush() + 关闭。

## 节点流和处理流
### 基本介绍
1. 节点流可以从一个特定的数据源**读写数据**，如FileReader、FileWriter[源码]

<img src="/notes/img-ch19/节点流.png">

2. 处理流（也叫包装流）是“链接”在已存在的流（节点流或处理流）之上，为程序提供更为强大的读写功能，也更加灵活，如BufferedReader、BufferedWriter[源码]

```java
public class BufferedReader extends Reader {
  private Reader in;

  private char cb[];

  //...
}
```

<img src="/notes/img-ch19/包装流.png">

### 节点流和处理流一览图

<img src="/notes/img-ch19/节点流和处理流一览图.png">