package com.wjm.springpractice.dto;


import java.sql.Date;

import lombok.Data;

@Data
public class MemberBlockDto {
	private String email;
	private Date blockTime;
	
}
