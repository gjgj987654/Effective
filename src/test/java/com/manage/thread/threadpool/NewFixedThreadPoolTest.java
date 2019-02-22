package com.manage.thread.threadpool;

import com.manage.thread.NewThreadPoolThread;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther gaojian
 * @date 2019/2/20 11:25
 * 创建一个newFixedThreadPool线程池,该线程池需要自己配置核心池大小和线程池最大线程数
 */
public class NewFixedThreadPoolTest {
    @Test
    public void newFixedThreadPoolTest(){
        //创建一个newFixedThreadPool线程池
        ExecutorService pool=Executors.newFixedThreadPool(4);
        //创建了实现Runnable接口的对象
        Thread t1=new NewThreadPoolThread();
        Thread t2=new NewThreadPoolThread();
        Thread t3=new NewThreadPoolThread();
        Thread t4=new NewThreadPoolThread();
        Thread t5=new NewThreadPoolThread();
        //将对象放入线程池中
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        //关闭线程池
        pool.shutdown();
    }
}
