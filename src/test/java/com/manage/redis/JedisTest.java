package com.manage.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @auther gaojian
 * @date 2019/2/26 18:00
 */
public class JedisTest {
    @Test
    public void jedisTest(){
        Jedis jedis=new Jedis("localhost",6379);
//        jedis.auth("123456");
        //连接redis
        jedis.connect();
        Set<String> keys = jedis.keys("*");
        System.out.println(keys.size());
    }
}
