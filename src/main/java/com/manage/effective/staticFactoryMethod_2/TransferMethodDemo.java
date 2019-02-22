package com.manage.effective.staticFactoryMethod_2;

import org.junit.Test;

/**
 * @param
 * @auther gaojian
 * @date 2018/9/27 20:05
 */
public class TransferMethodDemo {
    @Test
    public void tmDemo(){
        /**
         * 无参构造函数
         */
        SFMDemo sfm =new SFMDemo();
        System.out.println(sfm.getCar());
        System.out.println(sfm.getHouse());
        sfm.setCar("小唯");
        System.out.println(sfm.getCar());
        /**
         * 有参构造函数
         */
        SFMDemo sfm1 =new SFMDemo("奔驰","大豪宅");
        System.out.println(sfm1.getCar());
        System.out.println(sfm1.getHouse());
        
    }
    @Test
    public void conDemo(){
        ConstructorDemo con=new ConstructorDemo("奥迪");
    }
    /**
     * 假如生活欺骗了你，不要悲伤不要放弃，犹豫的日子即将过去，相信吧，快乐的日子即将来临。
     * 
     */
}
