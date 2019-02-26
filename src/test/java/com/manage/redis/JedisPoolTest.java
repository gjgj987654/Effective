package com.manage.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @auther gaojian
 * @date 2019/2/26 18:20
 */
public class JedisPoolTest {

    @Test
    public void jedisPoolTest(){
        JedisPoolConfig config=new JedisPoolConfig();
        //设置最大连接数
        config.setMaxTotal(30);
        //设置最大空闲连接数
        config.setMaxIdle(10);
        JedisPool jedisPool=new JedisPool(config,"localhost",6379);
        //获取核心对象
        Jedis jedis=null;
        try {
            //通过连接池获取连接
            jedis=jedisPool.getResource();
            jedis.set("name","小倩");
            String value=jedis.get("name");
            System.out.println(value);
        }catch (Exception e){
            System.out.println("异常");
        }finally {
            if(jedis!=null){
                jedis.close();
            }
            if(jedisPool!=null){
                jedisPool.close();
            }
        }
    }
}
