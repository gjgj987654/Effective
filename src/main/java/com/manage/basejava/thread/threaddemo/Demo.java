package com.manage.basejava.thread.threaddemo;

/**
 * @auther gaojian
 * @date 2019/3/19 14:39
 */
public class Demo {

    public static void main(String[] args){
        ThreadA t1 = new ThreadA("t1");
        ThreadA t2 = new ThreadA("t2");
        t1.start();
        t2.start();
    }
}
