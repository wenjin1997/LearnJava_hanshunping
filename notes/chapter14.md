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
    - [实现类的课堂练习2](#实现类的课堂练习2)
  - [`ArrayList`底层结构和源码分析](#arraylist底层结构和源码分析)
    - [`ArrayList`的注意事项](#arraylist的注意事项)
    - [🚩🚩🚩`ArrayList`的底层操作机制源码分析](#arraylist的底层操作机制源码分析)
    - [配置IDEA-更改JDK版本](#配置idea-更改jdk版本)
  - [`Vector`底层结构和源码剖析](#vector底层结构和源码剖析)
    - [`Vector`的基本介绍](#vector的基本介绍)
    - [`Vector`和`ArrayList`的比较](#vector和arraylist的比较)
  - [`LinkedList`底层结构](#linkedlist底层结构)
    - [`LinkedList`的全面说明](#linkedlist的全面说明)
    - [`LinkedList`的底层操作机制](#linkedlist的底层操作机制)
    - [`LinkedList`的增删改查案例](#linkedlist的增删改查案例)
  - [`ArrayList`和`LinkedList`比较](#arraylist和linkedlist比较)
    - [`ArrayList`和`LinkedList`的比较](#arraylist和linkedlist的比较)
  - [`Set`接口和常用方法](#set接口和常用方法)
    - [`Set`接口基本介绍](#set接口基本介绍)
    - [`Set`接口的常用方法](#set接口的常用方法)
    - [`Set`接口的遍历方式](#set接口的遍历方式)
    - [`Set`接口的常用方法举例](#set接口的常用方法举例)
  - [`Set`接口实现类——`HashSet`](#set接口实现类hashset)
    - [`HashSet`的全面说明](#hashset的全面说明)
    - [`HashSet`案例](#hashset案例)
    - [`HashSet`底层机制说明](#hashset底层机制说明)
    - [`HashSet`课堂练习1](#hashset课堂练习1)
    - [`HashSet`课堂练习2](#hashset课堂练习2)
  - [`Set`接口实现类-`LinkedHashSet`](#set接口实现类-linkedhashset)
    - [`LinkedHashSet`的全面说明](#linkedhashset的全面说明)
    - [`LinkedHashSet`课后练习题](#linkedhashset课后练习题)
  - [`Map`接口和常用方法](#map接口和常用方法)
    - [🚩`Map`接口实现类的特点](#map接口实现类的特点)
    - [`Map`接口常用方法](#map接口常用方法)
    - [`Map`接口遍历方法](#map接口遍历方法)
    - [`Map`接口课堂练习](#map接口课堂练习)
  - [`Map`接口实现类——`HashMap`](#map接口实现类hashmap)
    - [`HashMap`小结](#hashmap小结)
    - [`HashMap`底层机制及源码剖析](#hashmap底层机制及源码剖析)
  - [`Map`接口实现类—`Hashtable`](#map接口实现类hashtable)
    - [`Hashtable`的基本介绍](#hashtable的基本介绍)
    - [`Hashtable`和`HashMap`对比](#hashtable和hashmap对比)
  - [`Map`接口实现类——`Properties`](#map接口实现类properties)
  - [🚩总结——开发中如何选择集合实现类](#总结开发中如何选择集合实现类)
    - [`TreeSet`](#treeset)
    - [`TreeMap`](#treemap)
  - [`Collections`工具类](#collections工具类)
    - [`Collections`工具类介绍](#collections工具类介绍)
    - [排序操作（均为`static`方法）](#排序操作均为static方法)

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
[ListFor.java)](/code/chapter14/src/com/jinjin/list_/ListFor.java)
1. 方式一：使用`iterator`
    ```java
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
        Object obj =  iterator.next();
        System.out.println(obj);

    }
    ```
2. 方式二：使用增强`for`
    ```java
    for (Object o : list) {
        System.out.println("o=" + o);
    }
    ```
3. 方式三：使用普通`for`
    ```java
    for (int i = 0; i < list.size(); i++) {
        System.out.println("对象=" + list.get(i));
    }
    ```


**说明**：使用`LinkedList`完成，使用方式和`ArrayList`一样。

### 实现类的课堂练习2
使用`List`的实现类添加三本图书，并遍历，打印如下效果：

<img src="/notes/img-ch14/ListExercise02.png">

要求：
1. 按价格排序，从低到高（使用冒泡法）
2. 要求使用`ArrayList`、`LinkedList`和`Vector`三种集合实现

**代码：**[ListExercise02.java](/code/chapter14/src/com/jinjin/list_/ListExercise02.java)
* 冒泡排序方法
```java
public static void sort(List list) {
    for (int i = 0; i < list.size() - 1; i++) {
        for (int j = 0; j < list.size() - i - 1; j++) {
            Book book1 = (Book) list.get(j);
            Book book2 = (Book) list.get(j + 1);
            if (book1.getPrice() > book2.getPrice()) {
                list.set(j + 1, book1);
                list.set(j, book2);
            }
        }
    }
}
```
## `ArrayList`底层结构和源码分析
### `ArrayList`的注意事项
1. permits all elements, including null, `ArrayList`可以加入`null`，并且多个也可以
2. `ArrayList`是由数组来实现数据存储的
3. `ArrayList`基本等同于`Vector`，除了`ArrayList`是线程不安全的（执行效率高），在多线程情况下，不建议使用`ArrayList`。

### 🚩🚩🚩`ArrayList`的底层操作机制源码分析
[ArrayListSource.java](/code/chapter14/src/com/jinjin/list_/ArrayListSource.java)
1. `ArrayList`中维护了一个`Object`类型的数组`elementData`
    ```java
    //transient 表示瞬间，短暂的，表示该属性不会被序列化
    transient Object[] elementData; 
    ```
2. 当创建`ArrayList`对象时，如果使用的是无参构造器，则初始`elementData`容量为0，第1次添加，则扩容`elementData`为10，如需再次扩容，则扩容`elementData`为1.5倍。（JDK8）
3. 如果使用的是指定大小的构造器，则初始`elementData`容量为指定大小，如果需要扩容，则直接扩容`elementData`为1.5倍。

* `ArrayList`扩容机制

<img src="/notes/img-ch14/ArrayList.png">

* 默认情况下，IDEA显示的是简化后的数据。IDEA设置看到完整的数据步骤:选择Preferences-Buile,Execution,Deployment-Debugger-Data Viewer-Java，去掉勾选alternative view for Collections classes。

<img src="/notes/img-ch14/IDEA-Debugger.png">

### 配置IDEA-更改JDK版本
参考[Mac配置JDK版本](https://www.cnblogs.com/diShuiZhiYi/p/13774075.html)，如果是某一个project需要更换JDK版本，可以进行如下设置。

<img src="/notes/img-ch14/IDEA-SDK.png">

## `Vector`底层结构和源码剖析
### `Vector`的基本介绍
[Vector_.java](/code/chapter14/src/com/jinjin/list_/Vector_.java)
1. `Vector`类的定义说明
    ```java
    public class Vector<E>
    extends AbstractList<E>
    implements List<E>, RandomAccess, Cloneable, java.io.Serializable
    ```
2. `Vector`底层也是一个对象数组，`protected Object[] elementData;`
3. `Vector`是线程同步的，即线程安全，`Vector`类的操作方法带有`synchronized`
    ```java
    public synchronized E get(int index) {
        if (index >= elementCount)
            throw new ArrayIndexOutOfBoundsException(index);

        return elementData(index);
    }
    ```

### `Vector`和`ArrayList`的比较
||底层结构|版本|线程安全（同步）效率|扩容倍数|
|----|----|----|----|----|
|`ArrayList`|可变数组|jdk1.2|不安全，效率高|如果有参构造1.5倍，如果是无参构造，第一次10，从第二次开始按1.5倍扩|
|`Vector`|可变数组`Object[]`|jdk1.0|安全，效率不高|如果是无参构造，默认10，满后，就按2倍扩容。如果指定大小，则每次直接按2倍扩容。|

## `LinkedList`底层结构
### `LinkedList`的全面说明
1. `LinkedList`底层实现了双向**链表**和双端**队列**的特点。
2. 可以添加任意元素（元素可以重复），包括`null`。
3. 线程不安全，没有实现同步。

### `LinkedList`的底层操作机制
1. `LinkedList`底层维护了一个双向链表
2. `LinkedList`中维护了两个属性`first`和`last`分别指向首节点和尾节点。
3. 每个节点（`Node`对象），里面又维护了`prev`、`next`、`item`三个属性，其中通过`prev`指向前一个，通过`next`指向后一个节点，最终实现双向链表。
4. 所以`LinkedList`的元素的**添加和删除**，不是通过数组完成的，相对来说效率较高。
5. 模拟一个**简单**的双向链表。

<img src="/notes/img-ch14/LinkedList.png">

### `LinkedList`的增删改查案例
* 追源码，分析`LinkedList`底层操作 [LinkedListCRUD.java](/code/chapter14/src/com/jinjin/list_/LinkedListCRUD.java)

<img src="/notes/img-ch14/LinkedListCRUD.png">

## `ArrayList`和`LinkedList`比较
### `ArrayList`和`LinkedList`的比较
|    |底层结构|增删的效率|改查的效率|
|----|----|----|----|
|`ArrayList`|可变数组|较低，数组扩容|较高|
|`LinkedList`|双向链表|较高，通过链表追加|较低|

**如何选择`ArrayList`和`LinkedList`**
1. 如果我们改查的操作多，选择`ArrayList`
2. 如果我们增删的操作多，选择`LinkedList`
3. 一般来说，在程序中，80%-90%都是查询，因此大部分情况下会选择`ArrayList`
4. 在一个项目中，根据业务灵活选择，也可能这样，一个模块使用`ArrayList`，另外一个模块是`LinkedList`，也就是说，要根据业务来选择。

## `Set`接口和常用方法
### `Set`接口基本介绍
1. 无序（添加和取出的顺序不一致），没有索引
2. 不允许重复元素，所以最多包含一个`null`
3. JDK API中`Set`接口的实现类有：

<img src="/notes/img-ch14/Interface%20Set.png">

### `Set`接口的常用方法
和`List`接口一样，`Set`接口也是`Collection`的子接口，因此，常用方法和`Collection`接口一样。

### `Set`接口的遍历方式
同`Collection`的遍历方式一样，因为`Set`接口是`Collection`接口的子接口。
1. 可以使用迭代器
2. 增强`for`
3. **不能使用**索引的方式来获取。

### `Set`接口的常用方法举例
[SetMethod.java](/code/chapter14/src/com/jinjin/set_/SetMethod.java)

1. `Set`接口的实现类的对象(`Set`接口对象), 不能存放重复的元素, 可以添加一个`null`
2. `Set`接口对象存放数据是无序(即添加的顺序和取出的顺序不一致)
3. **注意**：取出的顺序的顺序虽然不是添加的顺序，但是它是固定的.
4. 遍历方法只有两种，使用迭代器和增强`for`循环，不能使用普通`for`循环，因为`Set`接口对象不能通过索引来获取。

## `Set`接口实现类——`HashSet`
### `HashSet`的全面说明
[HashSet_.java](/code/chapter14/src/com/jinjin/set_/HashSet_.java)
1. `HashSet`实现了`Set`接口
2. `HashSet`实际上是`HashMap`，源码：
  ```java
  public HashSet() {
      map = new HashMap<>();
  }
  ```
3. 可以存放`null`值，但是只能有一个`null`
4. `HashSet`不保证元素是有序的，取`hash`后，再确定索引的结果。（即不保证存放元素的顺序和取出顺序一致）
5. 不能有重复元素/对象。

### `HashSet`案例
案例：[HashSet01.java](/code/chapter14/src/com/jinjin/set_/HashSet01.java)

**经典面试题**：第二句能否加入？
```java
set.add(new String("hsp"));//ok
set.add(new String("hsp"));//加入不了.
System.out.println("set=" + set);
```

### `HashSet`底层机制说明

* `HashSet`底层是`HashMap`，`HashMap`底层是数组+链表+红黑树。[HashSetStructure.java](/code/chapter14/src/com/jinjin/set_/HashSetStructure.java)

<img src="/notes/img-ch14/hashset/HashSet01.png">

* `HashSet`的添加元素底层是如何实现?(hash()+equals()) [HashSetSource.java](/code/chapter14/src/com/jinjin/set_/HashSetSource.java)

<img src="/notes/img-ch14/hashset/HashSetSource.png">

* 分析`HashSet`的扩容和转成红黑树机制 [HashSetIncrement.java](/code/chapter14/src/com/jinjin/set_/HashSetIncrement.java)

<img src="/notes/img-ch14/hashset/HashSetIncrement.png">

* `threshold`的值，数组或者链表后添加的结点都纳入计算。
* 在进行树化过程中，如果是在同一个`hash`值后，不停的挂载结点，如果结点数到达8，而`table`的大小没有到达64，则每在链表后挂载一个结点，`table`的`size`翻倍，直到达到64，则会进行树化（红黑树）。

**Remark**：多追源码分析

### `HashSet`课堂练习1
[HashSetExercise.java](/code/chapter14/src/com/jinjin/set_/HashSetExercise.java)

定义一个`Employee`类，该类包含：`private`成员属性`name`，`age`。要求：
1. 创建3个`Employee`对象放入`HashSet`中
2. 当`name`和`age`的值相同时，认为是相同员工，不能添加到`HashSet`集合中。

### `HashSet`课堂练习2
[HashSetExercise02.java](/code/chapter14/src/com/jinjin/set_/exercise2/HashSetExercise02.java)

定义一个`Employee`类，该类包含：：`private`成员属性`name`，`sal`，`birthday`(`MyDate`类型)，其中`birthday`为`MyDate`类型（属性包括：`year`、`month`、`day`）。要求：
1. 创建3个`Employee`对象放入`HashSet`中
2. 当`name`和`birthday`的值相同时，认为是相同员工，不能添加到`HashSet`集合中。

* 这里需要在`MyDate`类中重写`hashCode()`和`equals()`方法。

## `Set`接口实现类-`LinkedHashSet`
### `LinkedHashSet`的全面说明
* `LinkedHashSet`是`HashSet`的子类

<img src="/notes/img-ch14/hashset/LinkedHashSet.png">

* `LinkedHashSet`底层是一个`LinkedHashMap`，底层维护了一个**数组 + 双向链表**。
* `LinkedHashSet`根据元素的`hashCode`值来决定元素的存储位置，同时使用链表维护元素的次序，这使得元素看起来是以插入顺序保存的。
* `LinkedHashSet`不允许添加重复元素。

[LinkedHashSetSource.java](/code/chapter14/src/com/jinjin/set_/LinkedHashSetSource.java):

<img src="/notes/img-ch14/hashset/LinkedHashSetSource.png">

* 添加第一次时，直接将数组`table`扩容到 16 ,存放的结点类型是 `LinkedHashMap$Entry`。数组是`HashMap$Node[]`存放的元素/数据是 `LinkedHashMap$Entry`类型

<img src="/notes/img-ch14/hashset/LinkedHashSetSource02.png">

### `LinkedHashSet`课后练习题
[LinkedHashSetExercise.java](/code/chapter14/src/com/jinjin/set_/LinkedHashSetExercise.java)

<img src="/notes/img-ch14/hashset/LinkedHashSetExercise.png">

## `Map`接口和常用方法
### 🚩`Map`接口实现类的特点
注意：这里讲的是**JDK8**的`Map`接口特点 [Map_.java](/code/chapter14/src/com/jinjin/map_/Map_.java)
1. `Map`与`Collection`并列存在。用于保存具有映射关系的数据:Key-Value(双列元素)
2. `Map`中的`key`和`value`可以是任何引用类型的数据，会封装到`HashMap$Node`对象中
3. `Map`中的`key`不允许重复，原因和`HashSet`一样.
4. `Map`中的`value`可以重复
5. `Map`的`key`可以为`null`, `value`也可以为`null`，注意`key`为`null`,只能有一个，`value`为`null`,可以多个
6. 常用`String`类作为`Map`的`key`
7. `key`和`value`之间存在单向一对一关系，即通过指定的`key`总能找到对应的 `value`
8. `Map`存放数据的`key-value`示意图，一对`k-v`是放在一个`HashMap$Node`中的，因为`Node`实现类`Entry`接口，有些书上也说一对`k-v`就是一个`Entry`。 [MapSource_.java](../code/chapter14/src/com/jinjin/map_/MapSource_.java)

<img src="/notes/img-ch14/map/MapSource.png">

```java
static class Node<K,V> implements Map.Entry<K,V> //HashMap class
final class EntrySet extends AbstractSet<Map.Entry<K,V>> //HashMap class
transient Set<Map.Entry<K,V>> entrySet; //HashMap field
Set<Map.Entry<K, V>> entrySet(); //Map
interface Entry<K,V>  //Map
```

### `Map`接口常用方法
[MapMethod.java](/code/chapter14/src/com/jinjin/map_/MapMethod.java)

### `Map`接口遍历方法
Map遍历的示意图（比`List`和`Set`复杂点，但是基本原理一样）

<img src="/notes/img-ch14/map/MapFor.png">

Map遍历方式案例 [MapFor.java](/code/chapter14/src/com/jinjin/map_/MapFor.java)
1. `containsKey`:查找键是否存在
2. `keySet`: 获取所有的键
3. `entrySet`: 获取所有关系k-v
4. `values`: 获取所有值

### `Map`接口课堂练习
[MapExercise.java](/code/chapter14/src/com/jinjin/map_/MapExercise.java)

使用`HashMa`p添加3个员工对象，要求  
1. 键：员工`id`
2. 值：员工对象
  
遍历显示工资>180000的员工（遍历方式最少两种)，其中员工类:姓名、工资、员工`id`。

## `Map`接口实现类——`HashMap`
### `HashMap`小结
1. `Map`接口的常用实现类：`HashMap`、`Hashtable`和`Properties`。
2. `HashMap`是`Map`接口使用频率最高的实现类。
3. `HashMap`是以`key-value`对的方式来存储数据（`HashMap$Node`类型）
4. `key`不能重复，但是值可以重复，允许使用`null`键和`null`值。
5. 如果添加相同的`key`，则会覆盖原来的`key-value`，等同于修改。（`key`不会替换，`value`会替换）
6. 与`HashSet`一样，不保证映射的顺序，因为底层是以`hash`表的方式来存储的。（`JDK8`的`HashMap`底层：数组+链表+红黑树）
7. `HashMap`没有实现同步，因此是线程不安全的，方法没有做同步互斥的操作，没有`synchronized`。

### `HashMap`底层机制及源码剖析

<img src="/notes/img-ch14/map/Source.png">

* 扩容机制：和`HashSet`相同

1. `HashMap`底层维护了`Node`类型的数组`table`，默认为`null`
2. 当创建对象时，将加载因子（`loadFactor`）初始化为0.75.
3. 当添加`key-val`时，通过`key`的哈希值得到在`table`索引。然后判断该索引处是否有元素，如果没有元素直接添加。如果该索引处有元素，继续判断该元素的`key`和准备加入的`key`是否相等，如果相等，则直接替换val；如果不相等需要判断是树结构还是链表结构，作出相应处理。如果添加时发现容量不够，则需要扩容。
4. 第1次添加，则需要扩容`table`容量为16，临界值（`threshold`）为12（16*0.75）
5. 以后再扩容，则需要扩容table容量为原来的2倍（32），临界值为原来的2倍，即24，以此类推。
6. 在`Java8`中，如果一条链表的元素个数超过`TREEIFY_THRESHOLD`（默认是8），并且`table`的大小>=`MIN_TREEIFY_CAPACITY`（默认64），就会进行树化（红黑树）

* 源码分析：[HashMapSource1.java](/code/chapter14/src/com/jinjin/map_/HashMapSource1.java)
* 模拟`HashMap`触发扩容、树化情况，并Debug验证。[HashMapSource2.java](/code/chapter14/src/com/jinjin/map_/HashMapSource2.java)

## `Map`接口实现类—`Hashtable`
### `Hashtable`的基本介绍
1. 存放的元素是键值对，即K-V
2. `Hashtable`的键和值都不能为`null`，否则会排除`NullPointerException`
3. `Hashtable`使用方法基本上和`HashMap`一样
4. `Hashtable`是线程安全的（`synchronized`），`HashMap`是线程不安全的

应用案例：[HashTableExercise.java](/code/chapter14/src/com/jinjin/map_/HashTableExercise.java)

### `Hashtable`和`HashMap`对比
||版本|线程安全（同步）|效率|允许`null`键和`null`值|
|----|----|----|----|----|
|`HashMap`|1.2|不安全|高|可以|
|`Hashtable`|1.0|安全|低|不可以|

## `Map`接口实现类——`Properties`
1. `Properties`类继承自`Hashtable`类并且实现了`Map`接口，也是使用一种键值对的形式来保存数据。
2. 它的使用特点和`Hashtable`类似
3. `Properties`还可以用于从`xxx.properties`文件中，加载数据到`Properties`类对象，并进行读取和修改
4. 说明：工作后`xxx.properties`文件通常作为配置文件，这个知识点在IO流中再详细讲。

* 基本使用：[Properties_.java](/code/chapter14/src/com/jinjin/map_/Properties_.java)

## 🚩总结——开发中如何选择集合实现类

<img src="/notes/img-ch14/HowToChoose.png">

### `TreeSet`
[TreeSet_.java](/code/chapter14/src/com/jinjin/set_/TreeSet_.java)

1. 构造器把传入的比较器对象，赋给了`TreeSet`的底层的`TreeMap`的属性`this.comparator`
```java
public TreeMap(Comparator<? super K> comparator) {
  this.comparator = comparator;
}
```
2. 在调用`treeSet.add("tom")`, 在底层会执行到
```java
if (cpr != null) {//cpr 就是我们的匿名内部类(对象)
  do {
      parent = t;
      //动态绑定到我们的匿名内部类(对象)compare
      cmp = cpr.compare(key, t.key);
      if (cmp < 0)
          t = t.left;
      else if (cmp > 0)
          t = t.right;
      else //如果相等，即返回0,这个Key就没有加入
          return t.setValue(value);
  } while (t != null);
}
```
### `TreeMap`
[TreeMap_.java](/code/chapter14/src/com/jinjin/map_/TreeMap_.java)

1. 构造器. 把传入的实现了`Comparator`接口的匿名内部类(对象)，传给给`TreeMap`的`comparator`
```java
public TreeMap(Comparator<? super K> comparator) {
  this.comparator = comparator;
}
```
2. 调用`put`方法
2.1 第一次添加, 把`k-v`封装到`Entry`对象，放入`root`
```java
Entry<K,V> t = root;
if (t == null) {
  compare(key, key); // type (and possibly null) check

  root = new Entry<>(key, value, null);
  size = 1;
  modCount++;
  return null;
}
```
2.2 以后添加
```java
Comparator<? super K> cpr = comparator;
if (cpr != null) {
  do { //遍历所有的key , 给当前key找到适当位置
    parent = t;
    cmp = cpr.compare(key, t.key);//动态绑定到我们的匿名内部类的compare
    if (cmp < 0)
      t = t.left;
    else if (cmp > 0)
      t = t.right;
    else  //如果遍历过程中，发现准备添加Key 和当前已有的Key 相等，就不添加
      return t.setValue(value);
  } while (t != null);
}
```
## `Collections`工具类
### `Collections`工具类介绍
1. `Collections`是一个操作`Set`、List和Map等集合的工具类
2. `Collections`中提供了一系列静态的方法对集合元素进行排序、查询和修改等操作

### 排序操作（均为`static`方法）
1. `reverse(List)`：反转`List`中元素的顺序
2. `shuffle(List)`：对`List`集合元素进行随机排序
3. `sort(List)`：根据元素的自然顺序对指定`List`集合元素按升序排序
4. `sort(List，Comparator)`：根据指定的`Comparator`产生的顺序对`List`集合元素进行排序
5. `swap(List，int， int)`：将指定`List`集合中的`i`处元素和`j`处元素进行交换
6. `Object max(Collection)`：根据元素的自然顺序，返回给定集合中的最大元素
7. `Object max(Collection，Comparator)`：根据`Comparator`指定的顺序，返回给定集合中的最大元素
8. `Object min(Collection)`
9. `Object min(Collection，Comparator)`
10. `int frequency(Collection，Object)`：返回指定集合中指定元素的出现次数
11. `void copy(List dest,List src)`：将`src`中的内容复制到`dest`中
  * 注意`dest`的大小，如果不合适，会抛出异常
  ```java
  public static <T> void copy(List<? super T> dest, List<? extends T> src) {
    int srcSize = src.size();
    if (srcSize > dest.size())
        throw new IndexOutOfBoundsException("Source does not fit in dest");
  }
  ```
12. `boolean replaceAll(List list，Object oldVal，Object newVal)`：使用新值替换`List`对象的所有旧值