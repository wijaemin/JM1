package com.kh.spring16;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring16.dto.CustomerDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test05 {
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		
		int count =sqlSession.update("customer.edit",CustomerDto.builder()
				.customerNo(1)
				.customerContact("010-9876-5432")
				.customerMileage(100)
				.customerLevel("플래티넘")
				.build()
				);
		boolean result=count>0;
		log.debug("resut={}",result);
			
	}
}
