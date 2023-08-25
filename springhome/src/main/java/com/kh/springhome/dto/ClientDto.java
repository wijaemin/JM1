package com.kh.springhome.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ClientDto {
	private String clientId;
	private String clientPassword;
	private String clientNickname;
	private String clientGrade;
	private Date clientJoin;
	private int clientPoint;
}
