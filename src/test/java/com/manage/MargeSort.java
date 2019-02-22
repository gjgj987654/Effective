package com.manage;

import org.junit.Test;

/**
 * @auther gaojian
 * @date 2019/2/14 14:56
 * 归并排序(速度仅次于快速排序)
 */
public class MargeSort {

    public static void merge(int[] a, int start, int mid,
                             int end) {
        int[] tmp = new int[a.length];
        System.out.println("merge " + start + "~" + end);
        int i = start, j = mid + 1, k = start;
        while (i != mid + 1 && j != end + 1) {
            if (a[i] < a[j])
                tmp[k++] = a[i++];
            else
                tmp[k++] = a[j++];
        }
        while (i != mid + 1)
            tmp[k++] = a[i++];
        while (j != end + 1)
            tmp[k++] = a[j++];
        for (i = start; i <= end; i++)
            a[i] = tmp[i];
        for (int p : a)
            System.out.print(p + " ");
        System.out.println();
    }

    static void mergeSort(int[] a, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(a, start, mid);// 左边有序
            mergeSort(a, mid + 1, end);// 右边有序
            merge(a, start, mid, end);
        }
    }

    @Test
    public void mergeSortTest(){
        int [] a={7,3,8,9,6,4,2,1,0,5};
        mergeSort(a,0,a.length-1);
        for (int anA : a) {//打印数组
            System.out.println(anA);
        }
    }

}
