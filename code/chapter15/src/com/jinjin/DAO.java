package com.jinjin;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author 文进
 * @version 1.0
 */
public class DAO <T>{
    private Map<String, T> map = new HashMap<>();

    //保存T类型的对象到Map成员变量中
    public void save(String id, T entity) {
        map.put(id, entity);
    }

    //从map中获取id对应的对象
    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.replace(id, entity);
    }

    public List<T> list() {
        List<T> list = new ArrayList<>();
        Set<String> keySet = map.keySet();
        //使用增强for
        for (String key : keySet) {
            list.add(get(key));
        }
        return list;
    }

    public void delete(String id) {
        map.remove(id);
    }
}
