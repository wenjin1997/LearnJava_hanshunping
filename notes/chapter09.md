- [第9章 项目-房屋出租系统](#第9章-项目-房屋出租系统)
  - [⭐️项目设计](#️项目设计)
  - [工具类Utility](#工具类utility)
  - [Remark](#remark)
  - [代码](#代码)

# 第9章 项目-房屋出租系统
## ⭐️项目设计
程序框架图（分层模式，当软件比较复杂时，需要模式管理）

<img src="/notes/img-ch9/design.png">

## 工具类Utility
* 当一个方法是static时，就是一个静态方法,静态方法可以直接通过类名调用.

## Remark
* 实现房屋信息列表功能时，可以在House类中重写toString方法。这样做的好处是，可以直接打印输出House对象，得到各个信息。
```java
@Override
public String toString() {
    return id +
            "\t\t" + name +
            "\t" + phone +
            "\t\t" + address +
            "\t" + rent +
            "\t" + state;
}
```

* 实现查找房屋信息时，在HouseService类中的方法可以返回一个House对象，而不是boolean值，`public House searchById(int searchId){ }`，这样做的好处是在实现修改房屋信息功能时，可以直接调用该方法。

```java
//查找房屋信息
public House searchById(int searchId) {
    int index = -1;
    for (int i = 0; i < houseNum; i++) {
        if (searchId == houses[i].getId()) {
            index = i;
        }
    }

    if (index == -1) {
        return null;
    }
    return houses[index];
}
```

* 实现修改房屋信息时，如果用户回车，则不修改该属性，例如姓名这一属性。

```java
System.out.print("姓名(" + house.getName() + "):");
String name = Utility.readString(8, "");
if (!name.equals("")) {
    house.setName(name);
}
```

## 代码
- houserent 房屋出租系统
  - 程序入口：[HouseRentApp.java](/code/chapter09/src/houserent/HouseRentApp.java)
  - view（界面层）
      - [HouseView.java](/code/chapter09/src/houserent/view/HouseView.java)
  - service （业务层）
      - [HouseService.java](/code/chapter09/src/houserent/service/HouseService.java)
   - domain （数据层）
      - [House.java](/code/chapter09/src/houserent/domain/House.java)
  - utils （工具类）
    - [Utility.java](/code/chapter09/src/houserent/utils/Utility.java)