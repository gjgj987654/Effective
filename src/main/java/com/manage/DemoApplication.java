package com.manage;

import com.manage.basejava.thread.MyThread;
import com.manage.basejava.thread.NewThread;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.manage.mapper")
@EnableTransactionManagement
@ServletComponentScan(basePackages = "com.manage.springboot")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
