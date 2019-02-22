package com.manage.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @param
 * @auther gaojian
 * @date 2018/9/28 19:24
 */
public class ArrayListDemo {
    /**
     * ArrayList的优点：
     * 底层是数组的形式，增删慢，查询快
     * ArrayList初始数组长度为10，如果添加的值比数组长度大的话，则右移一位，数组长度增加原来的一半，即变为之前的1.5倍
     * 它底层执行remove()方法时，用的equals比较，循环比较删除所有一样的对象
     */
    public static void main(String[] args) {
        List a = new ArrayList();
        for(int i=0;i<22;i++){
            a.add("xiaowei");
        }
        a.add("gaojian");
        a.remove("gaojian");
        System.out.println(a.size());
    }
}
