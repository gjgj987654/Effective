package com.manage.extend;

/**
 * @auther gaojian
 * @date 2019/3/4 9:55
 */


public class Test {
    Person person = new Person("Test");

    static {
        System.out.println("test static");
    }

    public Test() {
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        new MyClass();
    }
}





