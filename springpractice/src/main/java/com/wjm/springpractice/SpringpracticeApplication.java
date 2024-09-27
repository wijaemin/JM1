package com.wjm.springpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


//스케줄러를 사용하고 싶으면 사용하겠다는 설정을 해야한다
@EnableScheduling
@SpringBootApplication
public class SpringpracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringpracticeApplication.class, args);
	}

}
