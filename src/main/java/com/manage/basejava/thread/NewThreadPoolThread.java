package com.manage.thread;

/**
 * @auther gaojian
 * @date 2019/2/20 11:08
 */
public class NewThreadPoolThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"————正在执行。。。");
    }
}
