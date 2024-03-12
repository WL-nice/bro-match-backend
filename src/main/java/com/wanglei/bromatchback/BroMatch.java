package com.wanglei.bromatchback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.wanglei.bromatchback.mapper")//扫描mapper
@EnableScheduling
public class BroMatch {

	public static void main(String[] args) {

		SpringApplication.run(BroMatch.class, args);
	}

}
