package com.manage.effective.generalMethod_3;

/**
 * @param
 * @auther gaojian
 * @date 2018/9/28 9:45
 */
public class GMDemo {
    private int car;
    
    /**
     * 构造函数
     * @param car
     */
    public GMDemo(int car){
        this.car=car;
    }
    
    /**
     * 测试方法
     * 深度理解equals：   https://blog.csdn.net/javazejian/article/details/51348320
     * @param args
     */
    public static void main(String[] args){
        GMDemo a1=new GMDemo(1);
        GMDemo a2=new GMDemo(1);
        //此时调用的是object超类的equals方法，没有重写，它底层原理和==一样，所以输出为false
        System.out.println(a1.equals(a2));
        System.out.println(a1==a2);
        //equals具有的特性，自反性，对称性，传递性，一致性
        System.out.println("自反性："+a1.equals(a1));
        System.out.println("对称性：");
        System.out.println(a1.equals(a2));
        System.out.println(a2.equals(a1));
        
    }
}
