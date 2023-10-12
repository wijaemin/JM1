package com.kh.spring15;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring15.dto.BookDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test01 {
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		
//		BookDto dto= new BookDto();
//		dto.setBookTitle("안녕하세요");
//		dto.setBookAuthor("위딸기");
//		dto.setBookPublicationDate("2021-11-22");
//		dto.setBookPrice(333);
//		dto.setBookPublisher("위재민회사");
//		dto.setBookPageCount(700);
//		dto.setBookGenre("애니멀");
		
//		BookDto dto=BookDto.builder().bookTitle("이게나야").build();
		sqlSession.insert("book.add",BookDto.builder()
				.bookTitle("미안")
				.bookAuthor("반가워")
				.bookPublicationDate("2002-05-13")
				.bookPrice(999)
				.bookPublisher("이게나야")
				.bookPageCount(700)
				.bookGenre("화나네")
				.build()
				);
	}
}
