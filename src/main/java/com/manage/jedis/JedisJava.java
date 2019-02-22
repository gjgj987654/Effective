package com.manage.jedis;

import redis.clients.jedis.Jedis;

/**
 * @param
 * @auther gaojian
 * @date 2018/11/19 17:12
 */
public class JedisJava {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("localhost");
        System.out.println("运行情况:"+jedis.ping());
        for(int i=0;i<20;i++){
            jedis.rpush("Name","xiaowei"+i);
        }
        //System.out.println(jedis.get("name"));
        
    }
}
