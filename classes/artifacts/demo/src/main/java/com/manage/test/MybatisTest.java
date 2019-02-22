package com.manage.test;

import com.manage.mapper.CanalServerMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {
    @Autowired
    CanalServerMapper canalServerMapper;
    @Test
    public void test(){
        SqlSessionFactory sqlSessionFactory = null;
        InputStream input = null;
        SqlSession session = null;
    
        //创建sqlSessionFactory
        try {
        
            input = Resources.getResourceAsStream("resources/application.yml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        //得到SqlSession对象,执行查询操作
        try{
            session  = sqlSessionFactory.openSession();
           //session.selectList()
           // if(stu != null){
           //     System.out.println("id: "+stu.getID());
           //     System.out.println("name: "+stu.getName());
           //     System.out.println("deparment: "+stu.getDepartment());
           // }
        }finally{
            session.close();
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
    
        //canalServerMapper.insert("小伟", "123456");
        //CanalServerBean canalServerBean = canalServerMapper.findUserByPhone("12345678910");
        //Assert.assertEquals("winterchen", u.getName());
    }
}
