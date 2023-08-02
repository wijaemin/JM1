package com.kh.spring10.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring10.dto.BookDto;
import com.kh.spring10.mapper.BookDetailMapper;
import com.kh.spring10.mapper.BookListMapper;


@Repository
public class BookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BookListMapper listMapper;
	@Autowired
	private BookDetailMapper detailMapper;
	
	public void insert(BookDto dto) {
		String sql="insert into book(book_id, book_title, "
				+ "book_author, book_publication_date, "
				+ "book_price, book_publisher, "
				+ "book_page_count, book_genre) "
				+ "values(book_seq.nextval,?,?,?,?,?,?,?)";
		Object[] data= {dto.getBookTitle(), dto.getBookAuthor(), 
				dto.getBookPublicationDate(), dto.getBookPrice(), 
				dto.getBookPublisher(), dto.getBookPageCount(), 
				dto.getBookGenre()};
		jdbcTemplate.update(sql,data);
	}
		public boolean update(BookDto dto) {
			String sql="update book set book_title = ? , "
					+ "book_author = ?, book_publisher = ? "
					+ "where book_id = ?";
			Object[] data= {dto.getBookTitle(), dto.getBookAuthor(), 
					dto.getBookPublisher(), dto.getBookId() };
			return jdbcTemplate.update(sql,data)>0;
		}
		public boolean delete(int bookId) {
			String sql="delete book where book_id = ?";
			Object[] data= {bookId};
			return jdbcTemplate.update(sql,data)>0;
		}
		public List<BookDto>selectList(){
			String sql="select * from book order by book_id asc";
			return jdbcTemplate.query(sql, listMapper);
		}
		public BookDto selectOne(int bookId) {
			String sql="select * from book where book_id = ? order by book_id asc";
			Object[]data= {bookId};
			List<BookDto>list=jdbcTemplate.query(sql, detailMapper,data);
			return list.isEmpty() ? null :list.get(0);
		}
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
}
