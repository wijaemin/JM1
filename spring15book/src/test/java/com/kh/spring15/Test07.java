package com.kh.spring15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring15.dto.BookDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test07 {
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void test() {
		Map<String, Object> param = new HashMap<>();
//		param.put("bookId",1);
//		param.put("bookTitle","왜");
//		param.put("bookAuthor","몰");
//		param.put("bookPublisher","위재민");
//		param.put("bookPriceMin",10);
//		param.put("bookPriceMax",1000);
//		param.put("bookPublicationBegin","2021-01-01");
//		param.put("bookPublicationEnd","2023-12-31");
//		param.put("bookPageMin", 500);
//		param.put("bookPageMax", 1000);
		param.put("bookGenreList",List.of("애니멀","화나네"));//장르가 여러개라면
		List<BookDto> list= sqlSession.selectList("book.complexSearch",param);
		log.debug("검색결과 = {}개",list.size());
		for(BookDto dto:list) {
			log.debug("dto={}",dto);
		}
	}
}






