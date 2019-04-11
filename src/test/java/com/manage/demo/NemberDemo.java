package com.manage.demo;

import org.junit.Test;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @auther gaojian
 * @date 2019/2/28 17:28
 */
public class NemberDemo {

    @Test
    public void nemberTest() {
        System.out.println(nember());
    }

    public int nember() {
        int i = 0;
        try {
            i++;
            return i++ / 2;
        } catch (Exception e) {
            i++;
            return i++;
        } finally {
            i++;
            return ++i;
        }
    }

    /**
     *
     假设一个小偷，带着一个size为100的袋子去装东西，商店里面一共有n个东西，每个东西的size和价值是
     (S1, v1), (S2, V2), ………………… (Sn, Vn)
     (1,1) (2,2) (3,3)
     如何在总size不超过100的情况下，这个袋子最多可以装价值多少的东西？这个小偷要怎么装？
     */
    @Test
    public void money(){
        HashMap<Integer,Integer> map =new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        System.out.println(map.get(1));
        //存入map<v,s> 比较v的大小，给价格排序
//        int n=100;
//        int size=100;
//        for(int i=0;i<n;i++){
//            for(int j=1;j<n;j++){
//                if(size/v1)
//            }
//        }

    }

}
