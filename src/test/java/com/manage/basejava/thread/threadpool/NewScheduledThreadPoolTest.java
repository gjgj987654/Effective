package com.manage.thread.threadpool;

import com.manage.DemoApplication;
import org.junit.Test;
import org.springframework.boot.SpringApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @auther gaojian
 * @date 2019/2/20 12:01
 * 创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。
 */
public class NewScheduledThreadPoolTest {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        ScheduledThreadPoolExecutor exec =new ScheduledThreadPoolExecutor(1);
        //每隔一段时间就触发异常
        exec.scheduleAtFixedRate(() -> {
            // TODO Auto-generated method stub
            //throw new RuntimeException();
            System.out.println("===================");

        }, 1000, 5000, TimeUnit.MILLISECONDS);

        //每隔一段时间打印系统时间，证明两者是互不影响的
        exec.scheduleAtFixedRate(() -> {
            // TODO Auto-generated method stub
            System.out.println(System.nanoTime());

        }, 1000, 2000, TimeUnit.MILLISECONDS);
    }
}
