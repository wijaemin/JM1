package com.kh.spring22.dto;

import javax.validation.constraints.Pattern;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "도서")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class BookDto {
	
	@Schema(description = "도서번호(등록시x)")
	private int bookId;
	
	@Schema(description = "도서제목", example="하위용")
	private String bookTitle;
	
	@Pattern(regexp = "[^!@#$]+")
	@Schema(description = "저자", example="장준몬")
	private String bookAuthor;
	
	@Pattern(regexp ="^(19[0-9]{2}|20[0-9]{2})-(((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((02)-(0[1-9]|1[0-9]|2[0-9])))$")
	@Schema(description = "출판일", example="XXXX-XX-XX")
	private String bookPublicationDate;
	
	@Schema(description = "가격", example ="700")
	private float bookPrice;
	
	@Schema(description = "출판사", example ="위재민 컴퍼니")
	private String bookPublisher;
	
	@Schema(defaultValue = "페이지 수", example = "700")
	private int bookPageCount;
	
	@Schema(defaultValue = "장르", 
			allowableValues = {"Fantasy", "Classic", "Dystopian", 
					"Romance", "Modernist"}, 
			example = "Fantasy")
	private String bookGenre;
	
	@Schema(hidden = true)
	public boolean isEmpty() {
		return bookId == 0 && bookTitle == null && bookAuthor == null &&
				bookPublicationDate == null && bookPrice == 0 &&
				bookPublisher == null && bookPageCount == 0 && bookGenre == null;
	}
}
