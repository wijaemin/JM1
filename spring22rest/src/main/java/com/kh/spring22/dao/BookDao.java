package com.kh.spring22.dao;

import java.util.List;

import com.kh.spring22.dto.BookDto;

public interface BookDao {

	List<BookDto> selectList();
	void insert(BookDto bookDto);
	boolean delete(int bookId);
	BookDto selectOne(int bookId);
	List<BookDto> selectList(String bookTitle);
	void edit(int bookId, BookDto bookDto);
	boolean editUnit(int bookId, BookDto bookDto);
	List<BookDto> selectListByPage(int page, int size);
	
	

}
