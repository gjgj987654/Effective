package com.manage.basejava.thread.threaddemo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther gaojian
 * @date 2019/3/19 14:39
 */
public class ThreadA extends Thread {
    private static Object obj = new Object();

    public ThreadA(String name) {
        super(name);
    }

    public void run() {
        synchronized (obj) {
            for (int i = 0; i < 10; i++) {
                System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
                // i整除4时，调用yield
                if (i % 4 == 0)
                    Thread.yield();
            }
        }
    }
}
