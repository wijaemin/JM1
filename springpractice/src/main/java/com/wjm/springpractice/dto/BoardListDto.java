package com.wjm.springpractice.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class BoardListDto {

	private String nickname;
	private int no;
	private String writer, title;
	private int readcount, likecount, replycount;
	private Date createdAt, updatedAt;
	private int boardGroup, boardDepth;
	private Integer boardParent;
	
	public String getWriterString() {
		if(writer ==null) return "탈퇴한 사용자";
		else return nickname;

	}
	public String getCreatedAtString() {
		LocalDate current= LocalDate.now();//현재
		LocalDate created =createdAt.toLocalDate();//작성일
		
		if(created.equals(current)) {
			Timestamp stamp =new Timestamp(createdAt.getTime());
			LocalDateTime time=stamp.toLocalDateTime();
			LocalTime result=time.toLocalTime();
			
			return result.format(DateTimeFormatter.ofPattern("HH:mm"));
		}
		else {
			return created.toString();
		}
	}
	
}
