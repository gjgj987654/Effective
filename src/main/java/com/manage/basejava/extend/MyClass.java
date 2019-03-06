package com.manage.extend;

/**
 * @auther gaojian
 * @date 2019/3/4 15:00
 */
class MyClass extends Test {
    Person person = new Person("MyClass");
    static{
        System.out.println("myclass static");
    }

    public MyClass() {
        System.out.println("myclass constructor");
    }
}
