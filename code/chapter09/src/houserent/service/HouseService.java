package houserent.service;

import houserent.domain.House;
import houserent.utils.Utility;

/**
 * HouseService.java<=>类 [业务层]
 * //定义House[] ,保存House对象
 * 1. 响应HouseView的调用
 * 2. 完成对房屋信息的各种操作(增删改查c[create]r[read]u[update]d[delete])
 */
public class HouseService {
    private House[] houses; //保存House对象
    private int houseNum = 1;
    private int idCounter = 1;

    //构造器
    public HouseService(int size) {
        houses = new House[size];
        houses[0] = new House(1,"jack","121","北京市",1500,"未出租");
    }


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

    //del方法
    public boolean del(int delId) {
        int index = -1;
        for (int i = 0; i < houseNum; i++) {
            if (delId == houses[i].getId()) {
                index = i;
            }
        }

        if (index == -1) {
            return false;
        }

        for (int i = index; i < houseNum - 1; i++) {
            houses[i] = houses[i+1];
        }

        houses[--houseNum] = null;
        return true;
    }


    //add方法
    public boolean add(House newHouse) {
        if(houseNum == houses.length) { //不能再添加
            return false;
        }

        //新增加房屋信息
        houses[houseNum++] = newHouse;

        //设计自增加id功能
        newHouse.setId(++idCounter);

        return true;
    }

    //list方法
    public House[] list() {
        return houses;
    }
}
