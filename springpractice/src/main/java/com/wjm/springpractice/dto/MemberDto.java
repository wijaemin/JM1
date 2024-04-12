package com.wjm.springpractice.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberDto {
	private String email, password, nickname;
	private String contact, birth;
	private String post, addr1, addr2, rank;
	private int point;
	private Date joinAt, loginAt;
}
