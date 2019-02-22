package com.manage.thread.threadpool;

import com.manage.thread.NewThreadPoolThread;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther gaojian
 * @date 2019/2/20 11:10
 * 创建一个newSingleThreadExecutor线程池,他是一个单线程的线程池。
 */
public class NewSingleThreadExecutorTest {
    @Test
    public void newSingleThreadExecutorTest(){
        //创建一个newSingleThreadExecutor线程池
        ExecutorService pool=Executors.newSingleThreadExecutor();
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
