package com.manage.effective.staticFactoryMethod_2;

/**
 * @param
 * @auther gaojian
 * @date 2018/9/27 19:58
 *      静态工厂方法的使用，为了替代构造方法。
 *      静态工厂方法优点:
 *          1.有自己的名字
 *          2.不用每次创建时new对象
 *          3.可以返回原返回类型的子类
 *          4.在创建带泛型的实例时更加简洁
 *      此外，它还可有
 *          1.多个参数相同名称不同的工厂方法
 *          2.可以减少对外暴露的属性
 *          3.多一层控制方便统计
 *      他的主要缺点是
 *          1.类如果不含公有的或者受保护的构造函数，就不能被子类化
 *          2.他们与其他的静态方法没有任何区别
 */     
public class SFMDemo {
    
    private String car;
    private String house;
    
    /**
     * 空构造方法
     * @param 
     */
    public SFMDemo() {
        this.car="奥迪";
        this.house="海景房";
    }
    
    /**
     * car和house构造方法
     * @param car
     * @param house
     */
    public SFMDemo(String car, String house){
        this.car=car;
        this.house=house;
    }
    
    public static final int GAO_JIAN = 1 ;
   
    public String getCar() {
        return car;
    }
    
    public void setCar(String car) {
        this.car = car;
    }
    
    public String getHouse() {
        return house;
    }
    
    public void setHouse(String house) {
        this.house = house;
    }
}
