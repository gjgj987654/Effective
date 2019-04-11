package com.manage.basejava.this_keyword;

/**
 * @auther gaojian
 * @date 2019/3/4 15:16
 */
public class ThisDemo1 {
    public static void main(String[] args) {
        ThisDemo d1=new ThisDemo();
        d1.name="小唯";
        ThisDemo d2=new ThisDemo();
        d2.name="倩倩";

        d1.getName("xiaowei");
        d2.getName("qianqian");

    }
}
