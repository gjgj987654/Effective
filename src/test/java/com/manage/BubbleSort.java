package com.manage;

import org.junit.Test;

/**
 * @auther gaojian
 * @date 2019/2/14 14:31
 * 冒泡排序
 */
public class BubbleSort {

    @Test
    public void bubbleSort(){
        int [] a={7,3,8,9,6,4,2,1,0,5};
        int len=a.length;
        for(int i=0;i<len;i++){
            for(int j=0;j<len-i-1;j++){//注意第二重循环的条件
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        for (int anA : a) {//打印数组
            System.out.println(anA);
        }
    }
}
