package com.manage.thread.runnabletest;

import com.manage.thread.NewRunnable;
/**
 * @auther gaojian
 * @date 2019/2/20 17:44
 */

public class RunnableTest {

    public static void main(String[] args) {
        NewRunnable t = new NewRunnable();
        Thread thread1 = new Thread(t, "窗口1");
        Thread thread2 = new Thread(t, "窗口2");
        Thread thread3 = new Thread(t, "窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
