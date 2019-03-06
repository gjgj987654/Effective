package com.manage.thread;

/**
 * @auther gaojian
 * @date 2019/2/20 9:31
 */
public class NewThread extends Thread {

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread()+"_______"+i);
        }
    }
}
