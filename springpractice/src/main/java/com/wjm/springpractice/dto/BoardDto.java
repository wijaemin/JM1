package com.wjm.springpractice.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardDto {

	private int no;
	private String writer, title, content;
	private int readcount, likecount, replycount;
	private Date createdAt, updatedAt;
}
