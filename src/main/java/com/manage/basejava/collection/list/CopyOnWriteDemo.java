package com.manage.basejava.collection.list;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @auther gaojian
 * @date 2019/3/18 17:59
 */
public class CopyOnWriteDemo {

    private static CopyOnWriteTestList copyOnWriteTestList = new CopyOnWriteTestList();

    static class CopyOnWriteTestList {
        private Object[] array;

        public CopyOnWriteTestList() {
            this.array = new Object[0];
        }        //获取底层数组：

        public Object[] getArray() {
            return array;
        }        //设置底层数组：

        public void setArray(Object[] array) {
            this.array = array;
        }        //添加元素：

        public void add(String element) {
            int len = array.length;
            Object[] newElements = Arrays.copyOf(array, len + 1);
            newElements[len] = element;
            setArray(newElements);
        }

        public void get(int index) {
            Object[] array = getArray();
            get(array, index);
        }        //此步骤，就是为了验证在获取元素时，array是否会随着元素的添加而改变；

        public void get(Object[] array, int index) {
            for (; ; ) {
                System.out.println("获取方法：" + array.length);
            }
        }
    }    //创建线程：

    public static void main(String[] agrs) throws InterruptedException {        //启动异步线程，一直添加元素
        new ThreadPoolExecutor(10, 10, 10, TimeUnit.MINUTES, new ArrayBlockingQueue(11), new ThreadPoolExecutor.AbortPolicy()).execute(new Runnable() {
            public void run() {
                for (; ; ) {
                    int x = 0;
                    copyOnWriteTestList.add("jiaboyan" + x);
                    ++x;
                }
            }
        });
        Thread.sleep(1000);
        System.out.println(copyOnWriteTestList.getArray().length);        //启动线程：获取元素
        copyOnWriteTestList.get(0);
    }
}
