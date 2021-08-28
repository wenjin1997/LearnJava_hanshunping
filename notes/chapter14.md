- [第14章 集合](#第14章-集合)
  - [集合的理解和好处](#集合的理解和好处)
    - [数组](#数组)
    - [集合](#集合)
  - [🚩集合的框架体系](#集合的框架体系)
  - [Collection接口和常用方法](#collection接口和常用方法)
    - [Collection接口实现类的特点](#collection接口实现类的特点)
    - [`Collection`接口遍历元素方式1-使用`Iterator`（迭代器）](#collection接口遍历元素方式1-使用iterator迭代器)
    - [`Collection`接口遍历对象方式2-增强`for`循环](#collection接口遍历对象方式2-增强for循环)
    - [课堂练习](#课堂练习)
  - [`List`接口和常用方法](#list接口和常用方法)
    - [`List`接口基本介绍](#list接口基本介绍)
    - [`List`接口的常用方法](#list接口的常用方法)
    - [`List`接口课堂练习](#list接口课堂练习)
    - [`List`的三种遍历方式（`ArrayList`、`LinkedList`、`Vector`）](#list的三种遍历方式arraylistlinkedlistvector)

# 第14章 集合
## 集合的理解和好处
### 数组
1. 长度开始必须指定，而且一旦指定，不能更改
2. 保存的必须为同一类型的元素
3. 使用数组进行增加/删除元素比较麻烦

### 集合
1. 可以**动态保存**任意多个对象，使用比较方便！
2. 提供了一系列方便的操作对象的方法：add、remove、set、get等
3. 使用集合添加删除新元素的代码简洁

## 🚩集合的框架体系
Java的集合类很多，主要分为两大类，框架体系需要记住！！！[Collection_.java](/code/chapter14/src/com/jinjin/collection_/Collection_.java)

<img src="/notes/img-ch14/Collection.png">

<img src="/notes/img-ch14/Map.png">

## Collection接口和常用方法
### Collection接口实现类的特点
`public interface Collection<E> extends Iterable<E>`

1. `Collection`实现子类可以存放多个元素，每个元素可以是`Object`
2. 有些`Collection`的实现类，可以存放重复的元素，有些不可以
3. 有些`Collection`的实现类，有些是有序的（`List`），有些不是有序的（`Set`）
4. `Collection`接口没有直接实现的子类，是通过它的子接口`Set`和`List`来实现的

`Collection`接口常用方法，以实现子类`ArrayList`为例。[CollectionMethod.java](/code/chapter14/src/com/jinjin/collection_/CollectionMethod.java)
* `add` 添加单个元素
* `remove` 删除指定元素，可以指定删除的索引，也可以删除指定的某个元素
* `contains` 查找元素是否存在
* `size` 获取元素个数
* `isEmpty` 判断是否为空
* `clear` 清空
* `addAll` 添加多个元素
* `containsAll` 查找多个元素是否都存在
* `removeAll` 删除多个元素

### `Collection`接口遍历元素方式1-使用`Iterator`（迭代器）
**基本介绍**
1. `Iterator`对象称为迭代器，主要用于遍历`Collection`集合中的元素。
2. 所有实现了`Collection`接口的集合类都有一个`iterator()`方法，用以返回一个实现了`Iterator`接口的对象，即可以返回一个迭代器。
3. `Iterator`的结构
4. `Iterator`仅用于遍历集合，`Iterator`本身并不存放对象。

**迭代器的执行原理**
```java
Iterator iterator = coll.iterator(); //得到一个集合迭代器
//hasNext() 判断是否还有下一个元素
while(iterator.hasNext()){
    //next()作用：1.下移 2.将下移以后集合位置上的元素返回
    System.out.println(iterator.next());
}
```

<img src="/notes/img-ch14/iterator.png">

**`Iterator`接口的方法**
* `hasNext()`
* `next()`
* `remove()`
* 在调用`iterator.next()`方法之前必须调用`iterator.hasNext()`进行检测。若不调用，且下一条记录无效，直接调用`iterator.next()`会抛出`NoSuchElementException`异常。

案例：[CollectionIterator.java](/code/chapter14/src/com/jinjin/collection_/CollectionIterator.java)
* 需要再次使用迭代器遍历时，需要重置迭代器:`iterator = col.iteraor();`
* 迭代器遍历的快捷键：itit
* 显示所有快捷键的快捷键：`command` + `j`

### `Collection`接口遍历对象方式2-增强`for`循环
增强`for`循环，可以代替`iterator`迭代器。特点：增强`for`就是简化版的`iterator`，本质一样。只能用于遍历集合或数组。

**基本语法：**
```java
for(元素类型 元素名: 集合名或数组名){
    访问元素
}
```

案例：[CollectionFor.java](/code/chapter14/src/com/jinjin/collection_/CollectionFor.java)
* 增强`for`循环快捷键：`I`
* 通过追源码知道实质也是`iterator`

### 课堂练习
编写程序 [CollectionExercise.java](/code/chapter14/src/com/jinjin/collection_/CollectionExercise.java)
1. 创建3个`Dog{name,age}`对象，放入到`ArrayList`中，赋给`List`引用
2. 用迭代器和增强`for`循环两种方式遍历
3. 重写`Dog`的`toString`方法，输出`name`和`age`

## `List`接口和常用方法
### `List`接口基本介绍
`List`接口是`Collection`接口的子接口 [List_.java](/code/chapter14/src/com/jinjin/list_/List_.java)
1. `List`集合类中元素有序（即添加顺序和取出顺序一致）、且可重复
2. `List`集合中的每个元素都有其对应的顺序索引，即支持索引
3. JDK API中`List`接口的实现类有：

<img src="/notes/img-ch14/List.png">

常用的有：`ArrayList`、`LinkedList`和`Vector`。

### `List`接口的常用方法
[ListMethod.java](/code/chapter14/src/com/jinjin/list_/ListMethod.java)
*  `void add(int index, Object ele)`:在`index`位置插入`ele`元素
*  `boolean addAll(int index, Collection eles)`:从`index`位置开始将`eles`中的所有元素添加进来
*  `Object get(int index)`:获取指定`index`位置的元素
*  `int indexOf(Object obj)`:返回`obj`在集合中首次出现的位置
*  `int lastIndexOf(Object obj)`:返回`obj`在当前集合中末次出现的位置
*  `Object remove(int index)`:移除指定`index`位置的元素，并返回此元素
*  `Object set(int index, Object ele)`:设置指定`index`位置的元素为`ele` , 相当于是替换.
*  `List subList(int fromIndex, int toIndex)`:返回从`fromIndex`到`toIndex`位置的子集合,注意返回的子集合`fromIndex` <= `subList` < `toIndex`

### `List`接口课堂练习
[ListExercise.java](/code/chapter14/src/com/jinjin/list_/ListExercise.java)

添加10个以上的元素（比如`String "hello"`），在2号位插入一个元素"进进"，获得第5个元素，删除第6个元素，修改第7个元素，再使用迭代器遍历集合，要求：使用`List`实现类`ArrayList`完成。

### `List`的三种遍历方式（`ArrayList`、`LinkedList`、`Vector`）
