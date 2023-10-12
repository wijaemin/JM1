package com.kh.spring15;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring15.dto.BookDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test04 {
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void test() {
//		BookDto dto=new BookDto();
//		dto.setBookId(3);
//		dto.setBookTitle("난돼요");
//		dto.setBookAuthor("몰라");
//		
//		int count =sqlSession.update("book.edit",dto);
//		boolean result=count>0;
//		log.debug("result={}",result);
		
		int count=sqlSession.update("book.edit",BookDto.builder()
				.bookId(3)
				.bookTitle("난되는데")
				.bookAuthor("와우")
				.build()
				);
		boolean result=count>0;
		log.debug("result={}",result);
	}
	
}
