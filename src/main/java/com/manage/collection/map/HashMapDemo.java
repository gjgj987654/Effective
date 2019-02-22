package com.manage.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @param
 * @auther gaojian
 * @date 2018/10/22 19:00
 */
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer,String> map=new HashMap<Integer,String>();
        for (int i =0;i<10;i++){
            map.put(i,"A"+i);
        }
        Set<Map.Entry<Integer,String>> entrySet=map.entrySet();
        for(Map.Entry<Integer,String> entry: entrySet){
            System.out.println(entry.getKey()+"|||"+entry.getValue());
        }
    }
}
