package com.wjm.springpractice.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberListDto {
	private String email, password, nickname;
	private String contact, birth;
	private String post, addr1, addr2, rank;
	private int point;
	private Date joinAt, loginAt;
	
	private String block;//차단 여부를 알수 있는 컬럼
}
