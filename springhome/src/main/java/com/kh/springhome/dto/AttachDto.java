package com.kh.springhome.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class AttachDto {
	private int attachNo;
	private String attachName;
	private Long attachSize;
	private String attachType;
	private Date attachTime;
}
