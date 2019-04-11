package com.manage.basejava.collection.map;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @auther gaojian
 * @date 2019/3/18 20:16
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();
        ConcurrentSkipListMap concurrentSkipListMap=new ConcurrentSkipListMap();
        Set set=new ConcurrentSkipListSet();
    }
}
