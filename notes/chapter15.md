- [第15章 泛型](#第15章-泛型)
  - [泛型的理解](#泛型的理解)
  - [泛型的好处](#泛型的好处)
  - [泛型介绍](#泛型介绍)
  - [泛型的语法](#泛型的语法)
    - [泛型的声明](#泛型的声明)
    - [泛型的实例化](#泛型的实例化)
    - [泛型使用举例](#泛型使用举例)
    - [泛型使用的注意事项和细节](#泛型使用的注意事项和细节)
  - [🌟泛型课堂练习](#泛型课堂练习)
  - [自定义泛型](#自定义泛型)
    - [自定义泛型接口](#自定义泛型接口)
    - [自定义泛型方法](#自定义泛型方法)
    - [自定义泛型方法练习](#自定义泛型方法练习)
  - [泛型的继承和通配符](#泛型的继承和通配符)
  - [JUnit](#junit)
  - [本章作业](#本章作业)
# 第15章 泛型
## 泛型的理解
看一个需求：
1. 请编写程序，在ArrayList中，添加3个Dog对象
2. Dog对象含有name和age, 并输出name和age(要求使用getXxx())

**传统方法：** [Generic01.java](/code/chapter15/src/com/jinjin/generic/Generic01.java)
使用传统方法的问题分析：
1. 不能对加入到集合ArrayList中的数据类型进行约束（不安全）
2. 遍历的时候，需要进行类型转换，如果集合中的数据量较大，对效率有影响

**使用泛型解决：** [Generic02.java](/code/chapter15/src/com/jinjin/generic/improve/Generic02.java)

## 泛型的好处
1. 编译时，检查添加元素的类型，提高了安全性
2. 减少了类型转换的次数，提高效率
    * 不使用泛型：  
    Dog -加入-> Object -取出-> Dog //放入到ArrayList会先转成Object，在取出时，还需要转换成Dog  
    * 使用泛型：  
    Dog -加入-> Dog -取出-> Dog //放入和取出时，不需要类型转换，提高效率
3. 不再提示编译警告

## 泛型介绍
泛（广泛）型（类型） => Integer,String,Dog
1. **泛型又称为参数化类型，是JDK5.0出现的新特性**，解决数据类型的安全性问题
2. 在类声明或实例化时只要指定好需要的具体的类型即可。
3. Java泛型可以保证如果程序在编译时没有发出警告，运行时就不会产生ClassCastException异常。同时，代码更加简洁、健壮。
4. 泛型的作用是：可以在类声明时通过一个标识标识类中某个属性的类型，或者是某个方法的返回值类型，或者是参数类型。[Generic03.java](/code/chapter15/src/com/jinjin/generic/Generic03.java)
    * E具体的数据类型在定义Person对象的时候指定，即在编译期间，就确定E是什么类型

## 泛型的语法
### 泛型的声明
```java
interface 接口<T> {}
class 类<K,V>{} //比如List,ArrayList
```
1. 其中，T，K，V不代表值，而是表示类型
2. 任意字母都可以。常用T表示，是Type的缩写。

### 泛型的实例化
要在类名后面指定类型参数的值（类型）。如：
```java
List<String> strList = new ArrayList<String> ();
Iterator<Customer> iterator = customers.iterator();
```
### 泛型使用举例
举例说明，泛型在HashSet，HashMap的使用情况。[GenericExercise.java](/code/chapter15/src/com/jinjin/generic/GenericExercise.java)
* 创建3个学生对象
* 放入到HashSet中学生对象, 使用.
* 放入到HashMap中，要求Key是String name, Value就是学生对象
* 使用两种方式遍历

### 泛型使用的注意事项和细节
[GenericDetail.java](/code/chapter15/src/com/jinjin/generic/GenericDetail.java)
1. `interface List<T>{}`,`public class HashSet<E>{}`...等等，说明：T，E是能是引用类型。**给泛型指向数据类型是，要求是引用类型，不能是基本数据类型。**
    ```java
    List<Integer> list = new ArrayList<Integer>(); //OK
    List<int> list2 = new ArrayList<int>();//错误
    ```
2. 在给泛型指定具体类型后，**可以传入该类型或者其子类类型**
3. 泛型的使用形式
    ```java
    ArrayList<Integer> list1 = new ArrayList<Integer>();
    ArrayList<Integer> list3 = new ArrayList<>();//推荐写法
    ```
4. **如果是这样写，泛型默认是Object。**
    ```java
    //等价 ArrayList<Object> arrayList = new ArrayList<Object>();
    ArrayList arrayList = new ArrayList();
    ```

## 🌟泛型课堂练习
定义Employee类
* 该类包含：private成员变量name,sal,birthday，其中 birthday 为 MyDate 类的对象；
* 为每一个属性定义 getter, setter 方法；
* 重写 toString 方法输出 name, sal, birthday
* MyDate类包含: private成员变量month,day,year；并为每一个属性定义 getter, setter 方法；
* 创建该类的 3 个对象，并把这些对象放入 ArrayList 集合中（ArrayList 需使用泛型来定义），对集合中的元素进行排序，并遍历输出：
* 排序方式： 调用ArrayList 的 sort 方法 ,
* 传入 Comparator对象[使用泛型]，先按照name排序，如果name相同，则按生日日期的先后排序。【即：定制排序】

💻 **代码**
- [GenericExercise02.java](/code/chapter15/src/com/jinjin/generic/GenericExercise02.java)
- [Employee.java](/code/chapter15/src/com/jinjin/generic/Employee.java)
- [MyDate.java](/code/chapter15/src/com/jinjin/generic/MyDate.java)

✏️**Remark**
* 生日比较可以写在MyDate中，MyDate实现Compareable接口，使用泛型。
```java
package com.jinjin.generic;

/**
 * @author 文进
 * @version 1.0
 */

public class MyDate implements Comparable<MyDate>{

    //...

    @Override
    public int compareTo(MyDate o) {
        if (year != o.getYear()) {
            return year - o.getYear();
        }
        if (month != o.getMonth()) {
            return month - o.getMonth();
        }
        if (day != o.getDay()) {
            return day - o.getDay();
        }
        return 0;
    }
}
```
* 进行排序时，先比较name，后比较birthday，不要用嵌套的if-else，可以过关斩将，如果name比较不相同，返回一个值，接着再比较birthday。
```java
employees.sort(new Comparator<Employee>() {
    @Override
    public int compare(Employee e1, Employee e2) {
        int nameCompare = e1.getName().compareTo(e2.getName());
        if (nameCompare != 0) {
            return nameCompare;
        }
        return e1.getBirthday().compareTo(e2.getBirthday());
    }
});
```

## 自定义泛型
▶️  **基本语法**
```java
class 类名<T,R,...>{//...表示可以有多个泛型
    成员
}
```

▶️  **注意细节** [CustomGeneric_.java](/code/chapter15/src/com/jinjin/customgeneric/CustomGeneric_.java)
1. Tiger 后面泛型，所以我们把 Tiger 就称为自定义泛型类
2. T, R, M 泛型的标识符, 一般是单个大写字母
3. 泛型标识符可以有多个.
4. 普通成员可以使用泛型 (属性、方法)
5. **使用泛型的数组，不能初始化**
6. **静态方法中不能使用类的泛型**
7. 泛型类的类型，是在创建对象时确定的（因为创建对象时，需要指定确定类型）
8. 如果在创建对象时，没有指定类型，默认Object。

▶️  **练习**：说明自定义泛型代码是否正确，并说明原因。[CustomGeneric_.java](/code/chapter15/src/com/jinjin/customgeneric/CustomGeneric_.java)
```java
//T=Double, R=String, M=Integer
Tiger<Double,String,Integer> g = new Tiger<>("john");
g.setT(10.9);
g.setT("yy"); 
System.out.println(g);
Tiger g2 = new Tiger("john~~"); 
g2.setT("yy");
System.out.println("g2=" + g2);
```

### 自定义泛型接口
```java
interface 接口名<T,R,...>{

}
```
▶️  注意细节 [CustomInterfaceGeneric.java](/code/chapter15/src/com/jinjin/customgeneric/CustomInterfaceGeneric.java)
1. **接口中，静态成员也不能使用泛型**，接口中，属性默认是`public static final`修饰的。接口相关笔记见[第10章 面向对象编程（高级部分）](/notes/chapter10.md)。
2. 泛型接口的类型, 在**继承接口**或者**实现接口**时确定
3. 没有指定类型，默认为Object

### 自定义泛型方法
```java
修饰符 <T,R...> 返回类型 方法名(参数列表){

}
```

▶️  注意细节 [CustomMethodGeneric.java](/code/chapter15/src/com/jinjin/customgeneric/CustomMethodGeneric.java)
1. 泛型方法，可以定义在普通类中, 也可以定义在泛型类中
2. 当泛型方法被调用时，类型会确定
3. `public void eat(E e) {}`，修饰符后没有`<T,R...>`，eat方法不是泛型方法，而是使用了泛函。
4. 泛型方法，可以使用类声明的泛型，也可以使用自己声明泛型   
    ```java
    public<K> void hello(R r, K k) {
    }
    ```

### 自定义泛型方法练习
下面代码是否正确，如果有错误，修改正确，并说明输出什么？[CustomMethodGenericExercise.java](/code/chapter15/src/com/jinjin/customgeneric/CustomMethodGenericExercise.java)
```java
public class CustomMethodGenericExercise {
    public static void main(String[] args) {
        Apple<String, Integer, Double> apple = new Apple<>();
        apple.fly(10);
        apple.fly(new Dog());
    }
}

class Apple<T, R, M> {
    public <E> void fly(E e) {
        System.out.println(e.getClass().getSimpleName());
    }
    public void eat(U u) {}
    public void run(M m) {
    } 
}

class Dog {
}
```

✏️  Remark
* `e.getclass()`会输出包名+运行类型名称。`e.getClass().getSimpleName()`，直接输出运行类型名称。
    ```java
    public <E> void fly(E e) {
        System.out.println(e.getClass().getSimpleName());
    }
    ```

## 泛型的继承和通配符
[GenericExtends.java](/code/chapter15/src/com/jinjin/GenericExtends.java)
1. 泛型不具备继承性
    ```java
    //List<Object> list = new ArrayList<String>();//是错误的
    ```
2. `<?>`：支持任意泛型类型
3. `<? extends A>`:支持A类以及A类的子类，规定了泛型的上限
4. `<? super A>`:支持A类以及A类的父类，不限于直接父类，规定了泛型的下限

## JUnit
▶️  为什么需要JUnit
1. 一个类有很多功能代码需要测试，为了测试，就需要写入到main方法中
2. 如果有多个功能代码测试，就需要来回注释，切换很麻烦
3. 如果可以直接运行一个方法，就方便很多，并且可以给出相关信息，就好了  -> JUnit

▶️ 基本介绍
1. JUnit是一个Java语言的单元测试框架
2. 多数Java的开发环境都已经集成了JUnit作为单元测试的工具

▶️ IDEA配置JUnit [JUnit_.java](/code/chapter15/src/com/jinjin/junit_/JUnit_.java)
1. 在要测试的方法上方写上`@Test`，然后按键alt + enter，选择JUnit5

<img src="/notes/img-ch15/Junit01.png">


2. 再运行需要测试的方法

<img src="/notes/img-ch15/Junit02.png">

3. 最终运行效果如下
   
<img src="/notes/img-ch15/Junit03.png">

## 本章作业
* 定义一个泛型类 DAO<T>，在其中定义一个Map 成员变量，Map 的键为 String 类型，值为 T 类型。
* 分别创建以下方法：
  * public void save(String id,T entity)： 保存 T 类型的对象到 Map 成员变量中
  * public T get(String id)：从 map 中获取 id 对应的对象
  * public void update(String id,T entity)：替换 map 中key为id的内容,改为 entity 对象
  * public List<T> list()：返回 map 中存放的所有 T 对象
  * public void delete(String id)：删除指定 id 对象
* 定义一个 User 类：
  * 该类包含：private成员变量（int类型） id，age；（String 类型）name。
* 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方法来操作 User 对象，
* 使用 Junit 单元测试类进行测试。

💻  代码
- [DAO.java](/code/chapter15/src/com/jinjin/DAO.java)
- [User.java](/code/chapter15/src/com/jinjin/User.java)
- [Homework01.java](/code/chapter15/src/com/jinjin/Homework01.java)

✏️  Remark
* `public List<T> list()`：返回 map 中存放的所有 T 对象。这里不能直接返回，可以先创建一个ArrayList，用keySet来遍历添加到ArrayList，最后再返回。
```java
public List<T> list() {
    List<T> list = new ArrayList<>();
    Set<String> keySet = map.keySet();
    //使用增强for
    for (String key : keySet) {
        list. add(get(key));
    }
    return list;
}
```