package com.kh.spring16;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring16.dto.CustomerDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test01 {
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		sqlSession.insert("customer.add",CustomerDto.builder()
				.customerId("nunamian")
				.customerContact("010-1212-3434")
				.customerJoin("2000-01-01")
				.customerPurchase("2001-02-02")
				.customerMileage(1000)
				.customerLevel("플래티넘")
				.build()
				);
	}
}
