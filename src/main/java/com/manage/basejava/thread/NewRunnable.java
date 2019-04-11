package com.manage.basejava.thread;

/**
 * @auther gaojian
 * @date 2019/2/20 17:40
 */
public class NewRunnable implements Runnable {

    private int tickets = 10;

    @Override
    public void run() {
        while (true){
            synchronized (this) {
                if (tickets > 0) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "--卖出了票：" + tickets--);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }
    }

}
