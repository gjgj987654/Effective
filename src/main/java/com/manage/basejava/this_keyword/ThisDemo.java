package com.manage.basejava.this_keyword;

/**
 * @auther gaojian
 * @date 2019/3/4 15:15
 */
public class ThisDemo {

    String name;

//    public void getName(String name){
//        System.out.println("输出::"+name);
//    }

    public void getName(String name){
        System.out.println("输出::"+this.name);
    }

}
