package com.manage;

import org.junit.Test;

/**
 * @auther gaojian
 * @date 2019/2/14 14:07
 * 希尔排序
 */

public class SheelSort {

    @Test
    public void sheelSort(){
        int [] a={7,3,8,9,6,4,2,1,0,5};
        int len=a.length;//单独把数组长度拿出来，提高效率
        while(len!=0){
            len=len/2;
            for(int i=0;i<len;i++){//分组
                for(int j=i+len;j<a.length;j+=len){//元素从第二个开始
                    int k=j-len;//k为有序序列最后一位的位数
                    int temp=a[j];//要插入的元素
                    while(k>=0&&temp<a[k]){//从后往前遍历
                        a[k+len]=a[k];
                        k-=len;//向后移动len位
                    }
                    a[k+len]=temp;
                }
            }
        }
        for (int anA : a) {//打印数组
            System.out.println(anA);
        }
    }
}
