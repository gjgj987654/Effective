package com.manage.extend;

/**
 * @auther gaojian
 * @date 2019/3/4 15:01
 */
class Person {
    static {
        System.out.println("person static");
    }

    public Person(String str) {
        System.out.println("person " + str);
    }
}