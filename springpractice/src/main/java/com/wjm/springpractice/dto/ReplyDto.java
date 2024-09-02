package com.wjm.springpractice.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ReplyDto {
	private int no;
	private String writer;
	private String content;
	private Date createdAt;
	private int origin;
}
