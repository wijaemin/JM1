package com.wjm.springpractice.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class CertDto {
	private String email;
	private String num;
	private Date time;
}
