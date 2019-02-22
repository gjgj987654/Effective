package com.manage;

import org.junit.Test;

/**
 * @auther gaojian
 * @date 2019/2/14 11:55
 */
public class InsertSort {

    @Test
    public void insertSort(){
        int [] a={1,2,23,45,22,346,21,42};
        int len=a.length;//单独把数组长度拿出来，提高效率
        int insertNum;//要插入的数
        for(int i=1;i<len;i++){//因为第一次不用，所以从1开始
            insertNum=a[i];
            int j=i-1;//序列元素个数
            while(j>=0&&a[j]>insertNum){//从后往前循环，将大于insertNum的数向后移动
                a[j+1]=a[j];//元素向后移动
                j--;
            }
            a[j+1]=insertNum;//找到位置，插入当前元素
        }
        for(int i=1;i<len;i++) {//打印数组
            System.out.println(a[i]);
        }
    }
}
