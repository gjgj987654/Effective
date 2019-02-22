package com.manage;

import org.junit.Test;

/**
 * @auther gaojian
 * @date 2019/2/14 14:25
 * 简单选择排序
 */
public class SelectSort {

    @Test
    public void selectSort() {
        int [] a={7,3,8,9,6,4,2,1,0,5};
        int len = a.length;
        for (int i = 0; i < len; i++) {//循环次数
            int value = a[i];
            int position = i;
            for (int j = i + 1; j < len; j++) {//找到最小的值和位置
                if (a[j] < value) {
                    value = a[j];
                    position = j;
                }
            }
            a[position] = a[i];//进行交换
            a[i] = value;
        }
        for (int anA : a) {//打印数组
            System.out.println(anA);
        }
    }

}
